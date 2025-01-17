<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="100px">
      <el-form-item label="文章标题" prop="title">
        <el-input v-model="queryParams.title" placeholder="请输入文章名称" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="文章类型" prop="type">
        <el-select v-model="queryParams.type" placeholder="请选择文章类型" clearable style="width: 200px">
          <el-option v-for="dict in dict.type.article_type" :key="dict.value" :label="dict.label" :value="dict.value"/>
        </el-select>
      </el-form-item>
      <el-form-item label="创建时间">
        <el-date-picker v-model="dateRange" style="width: 240px" value-format="yyyy-MM-dd" type="daterange"
                        range-separator="-" start-placeholder="开始日期" end-placeholder="结束日期"
        ></el-date-picker>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-table v-loading="loading" :data="statisticsList">
      <el-table-column label="文章标题" align="center" prop="title" :show-overflow-tooltip="true"/>
      <el-table-column label="文章类型" align="center" prop="typeName">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.article_type" :value="scope.row.type"/>
        </template>
      </el-table-column>

      <el-table-column label="创建时间" align="center" prop="createTime"/>
      <el-table-column label="已阅" align="center" prop="vieNum">
        <template slot-scope="scope">
          <!-- 添加内联样式使文本变蓝，并保持点击跳转功能 -->
          <a style="color: #1890ff; cursor: pointer;" href="#" @click.prevent="handle(scope.row.id)">{{ scope.row.vieNum
            }}</a>
        </template>
      </el-table-column>
      <el-table-column label="未阅" align="center" prop="notNum">
        <template slot-scope="scope">
          <!-- 添加内联样式使文本变蓝，并保持点击跳转功能 -->
          <a style="color: #1890ff; cursor: pointer;" href="#" @click.prevent="handleJump(scope.row.id)">{{
            scope.row.notNum }}</a>
        </template>
      </el-table-column>
      <!-- <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button size="mini" type="text" icon="el-icon-edit" @click="handleUpdate(scope.row)"
          v-hasPermi="['system:user:edit']">修改</el-button>
          <el-button size="mini" type="text" icon="el-icon-edit" @click="handleUpdate(scope.row)"
            v-hasPermi="['system:statistics:edit']">详情</el-button>
        </template>
      </el-table-column> -->
    </el-table>

    <pagination v-show="total > 0" :total="total" :page.sync="queryParams.pageNum" :limit.sync="queryParams.pageSize"
                @pagination="getList"
    />

    <!-- 添加或修改【请填写功能名称】对话框 -->
    <el-dialog :title="title" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="100px">
        <el-form-item label="文章标题" prop="taskName">
          <el-input v-model="form.taskName"/>
        </el-form-item>
        <el-form-item label="文章类型" prop="testBeginTime">
          <el-input v-model="form.testBeginTime"/>
        </el-form-item>
        <el-form-item label="创建时间" prop="testEndTime">
          <el-input v-model="form.testEndTime"/>
        </el-form-item>
        <el-form-item label="已阅" prop="testStatus">
          <dict-tag :options="dict.type.test_task_status" :value="form.testStatus"/>
        </el-form-item>
        <el-form-item label="未阅" prop="needNum">
          <el-input v-model="form.needNum"/>
        </el-form-item>
      </el-form>
    </el-dialog>
    <!-- 已阅 -->
    <el-dialog :title="title" :visible.sync="open" width="600px" append-to-body>
      <el-button type="warning" plain icon="el-icon-download" size="mini" style="margin-bottom: 20px;"
                 @click="vieInfohandleExport"
                 v-hasPermi="['statistics:task:export']"
      >导出
      </el-button>
      <el-table v-loading="loading" :data="Viewlist">
        <el-table-column label="单位" align="center" prop="deptName" width="200px"/>
        <el-table-column label="手机号" align="center" prop="phonenumber"/>
        <el-table-column label="姓名" align="center" prop="nickName"/>
        <!-- <el-table-column label="未考人数" align="center" prop="lastNum" >

        </el-table-column> -->
        <!-- <el-table-column label="参考率" align="center" prop="testRate" />
  <el-table-column label="平均分" align="center" prop="avgScore" /> -->
      </el-table>
      <pagination v-show="infototal > 0" :total="infototal" :page.sync="queryParams1.pageNum"
                  :limit.sync="queryParams1.pageSize"
                  @pagination="getVieInfo"
      />
    </el-dialog>
    <!-- 未阅 -->
    <el-dialog :title="title" :visible.sync="twoopen" width="600px" append-to-body>
      <el-button type="warning" plain icon="el-icon-download" size="mini" style="margin-bottom: 20px;"
                 @click="notVieInfohandleExport"
                 v-hasPermi="['statistics:task:export']"
      >导出
      </el-button>
      <el-table v-loading="loading" :data="notViewlist">
        <el-table-column label="单位" align="center" prop="deptName" width="200px"/>
        <el-table-column label="手机号" align="center" prop="phonenumber"/>
        <el-table-column label="姓名" align="center" prop="nickName"/>
        <!-- <el-table-column label="未考人数" align="center" prop="lastNum" >

        </el-table-column> -->
        <!-- <el-table-column label="参考率" align="center" prop="testRate" />
  <el-table-column label="平均分" align="center" prop="avgScore" /> -->
      </el-table>
      <pagination v-show="infototal > 0" :total="infototal" :page.sync="queryParams1.pageNum"
                  :limit.sync="queryParams1.pageSize"
                  @pagination="getnotVieInfo"
      />
    </el-dialog>
  </div>
</template>

<script>
import { listArticleStatistics, getStatistics, notVieInfo, vieInfo } from '@/api/statistics/statistics'
import ItemVue from '../../../layout/components/Sidebar/Item.vue'

export default {
  name: 'taskStatistics',
  dicts: ['test_task_status', 'article_type'],
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      infototal: 0,
      notViewlist: [],
      Viewlist: [],
      // 【请填写功能名称】表格数据
      statisticsList: [],
      dateRange: [],
      // 弹出层标题
      title: '',
      // 是否显示弹出层
      open: false,
      twoopen: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        title: ''

      },
      queryParams1: {
        pageNum: 1,
        pageSize: 10
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {}
    }
  },
  created() {
    this.getList()
  },
  methods: {
    handle(id) {
      this.open = true
      this.queryParams1.articleId = id
      this.getVieInfo()

    },
    handleJump(id) {
      this.queryParams1.articleId = id
      this.getnotVieInfo()
      this.twoopen = true
    },
    getnotVieInfo() {
      this.loading = true
      notVieInfo(this.queryParams1).then(response => {
        this.notViewlist = response.rows
        this.infototal = response.total

        this.loading = false
      })
    },
    getVieInfo() {
      vieInfo(this.queryParams1).then(response => {
        this.Viewlist = response.rows
        this.infototal = response.total
        this.loading = false
      })
    },
    /** 查询【请填写功能名称】列表 */
    getList() {
      this.loading = true
      console.log(this.dateRange)
      let beginTime = this.dateRange[0]
      let endTime = this.dateRange[1]
      this.queryParams.beginTime = beginTime
      this.queryParams.endTime = endTime
      listArticleStatistics(this.queryParams).then(response => {
        this.statisticsList = response.rows
        this.total = response.total
        this.loading = false
      })
    },
    handopen() {
      this.open = true
    },
    // 取消按钮
    cancel() {
      this.open = false
      this.reset()
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        taskId: null,
        needNum: null,
        actualNum: null,
        notNum: null,
        rate: null,
        averageScore: null
      }
      this.resetForm('form')
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1
      this.getList()
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm('queryForm')
      this.handleQuery()
    },

    notVieInfohandleExport() {
      this.download('/statistics/article/notVieInfo/export', {
        ...this.queryParams1
      }, `grade_${new Date().getTime()}.xlsx`)
    },
    vieInfohandleExport() {
      this.download('/statistics/article/vieInfo/export', {
        ...this.queryParams1
      }, `grade_${new Date().getTime()}.xlsx`)
    }
  }
}
</script>
