<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="100px">
      <el-form-item label="考试任务名称" prop="taskName">
        <el-input v-model="queryParams.taskName" placeholder="请输入考试任务名称" clearable
                  @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="考试年度" prop="year">
        <el-date-picker
          v-model="queryParams.year"
          type="year"
          format="yyyy"
          value-format="yyyy"
          placeholder="请选择考试年度"
        >
        </el-date-picker>
        <!-- <el-input v-model="queryParams.year" placeholder="请输入考试年度" clearable @keyup.enter.native="handleQuery" /> -->
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-table v-loading="loading" :data="statisticsList">
      <el-table-column label="考试任务名称" align="center" prop="taskName"/>
      <el-table-column label="考试时间" align="center" width="300px" prop="testTime">
      </el-table-column>
      <el-table-column label="考试状态" align="center" prop="taskStatus" :show-overflow-tooltip="true">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.test_task_status" :value="scope.row.taskStatus"/>
        </template>
      </el-table-column>
      <el-table-column label="应考人数" align="center" prop="joinNum"/>
      <el-table-column label="实考人数" align="center" prop="testNum"/>
      <el-table-column label="未考人数" align="center">
        <template slot-scope="scope">
          {{ scope.row.joinNum-scope.row.testNum }}
        </template>
      </el-table-column>
      <el-table-column label="参考率" align="center" prop="testRate"/>
      <el-table-column label="平均分" align="center" prop="avgScore"/>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button size="mini" type="text" icon="el-icon-edit" @click="handleUpdate(scope.row)"
                     v-hasPermi="['statistics:task:info']"
          >详情
          </el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination v-show="total > 0" :total="total" :page.sync="queryParams.pageNum" :limit.sync="queryParams.pageSize"
                @pagination="getList"
    />

    <!-- 添加或修改【请填写功能名称】对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="800px" append-to-body>
      <el-button type="warning" plain icon="el-icon-download" size="mini" @click="handleExport"
                 style="margin-bottom: 20px;"
                 v-hasPermi="['statistics:task:export']"
      >导出
      </el-button>
      <el-table v-loading="loading" :data="taskinfoList">
        <el-table-column label="参考单位" align="center" prop="coName" width="200px"/>
        <el-table-column label="参考人数" align="center" prop="testNum"/>
        <el-table-column label="应考人数" align="center" prop="joinNum"/>
        <el-table-column label="未考人数" align="center" prop="lastNum">
          <template slot-scope="scope">
            <!-- 添加内联样式使文本变蓝，并保持点击跳转功能 -->
            <a style="color: #1890ff; cursor: pointer;" href="#" @click.prevent="handleJump(scope.row)">{{
              scope.row.lastNum }}</a>
          </template>
        </el-table-column>
        <el-table-column label="参考率" align="center" prop="testRate"/>
        <el-table-column label="平均分" align="center" prop="avgScore"/>
      </el-table>
      <pagination v-show="infototal > 0" :total="infototal" :page.sync="queryParams1.pageNum"
                  :limit.sync="queryParams1.pageSize"
                  @pagination="getinfoList"
      />
    </el-dialog>
    <el-dialog :title="title" :visible.sync="twoopen" width="600px" append-to-body>
      <el-button type="warning" plain icon="el-icon-download" size="mini" @click="lastlisthandleExport"
                 style="margin-bottom: 20px;"
                 v-hasPermi="['statistics:task:export']"
      >导出
      </el-button>
      <el-table v-loading="loading" :data="lastlist">
        <el-table-column label="参考单位" align="center" prop="coName" width="200px"/>
        <el-table-column label="手机号" align="center" prop="phonenumber"/>
        <el-table-column label="姓名" align="center" prop="nickName"/>
        <!-- <el-table-column label="未考人数" align="center" prop="lastNum" >

        </el-table-column> -->
        <!-- <el-table-column label="参考率" align="center" prop="testRate" />
  <el-table-column label="平均分" align="center" prop="avgScore" /> -->
      </el-table>
      <pagination v-show="infototal1 > 0" :total="infototal1" :page.sync="queryParams2.pageNum"
                  :limit.sync="queryParams2.pageSize"
                  @pagination="getlastList"
      />
    </el-dialog>
  </div>
</template>

<script>
import { listTaskStatistics, getStatistics, lastList } from '@/api/statistics/statistics'

export default {
  name: 'taskStatistics',
  dicts: ['test_task_status'],
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
      infototal1: 0,
      // 【请填写功能名称】表格数据
      statisticsList: [],
      taskinfoList: [],
      lastlist: [],
      // 弹出层标题
      title: '',
      // 是否显示弹出层
      open: false,
      // 二级弹出层
      twoopen: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        taskName: null,
        year: ''
      },
      queryParams1: {
        pageNum: 1,
        pageSize: 10,
        taskId: null,
        coName: null,
        testNum: null,
        joinNum: null,
        lastNum: null,
        testRate: null,
        avgScore: null

      },
      queryParams2: {
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
    /** 查询【请填写功能名称】列表 */
    getList() {
      this.loading = true
      listTaskStatistics(this.queryParams).then(response => {
        this.statisticsList = response.rows
        this.total = response.total
        this.loading = false
      })
    },
    getinfoList() {
      this.loading = true
      getStatistics(this.queryParams1).then(response => {
        this.taskinfoList = response.rows
        this.infototal = response.total
        this.loading = false
      })
    },
    // handleCellClick(column){
    //   debugger

    //   this.twoopen=true
    //   if(column){
    //     this.queryParams1.taskId=column.row.taskId
    //   }
    //   // 根据id获取参考人员名单
    //  console.log(column);

    // },
    handleJump(row) {
      console.log(row)
      this.queryParams2.taskId = this.queryParams1.taskId
      console.log(this.queryParams2)
      this.queryParams2.deptId = row.deptId
      this.getlastList()
      this.twoopen = true
    },
    // 获取未考信息
    getlastList() {
      lastList(this.queryParams2).then(response => {
        this.lastlist = response.rows
        this.infototal1 = response.total
        this.loading = false
      })
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
      console.log(this.queryParams.year)
      this.queryParams.pageNum = 1
      this.getList()
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm('queryForm')
      this.handleQuery()
    },

    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset()
      const id = row.id || this.ids
      this.queryParams1.taskId = row.taskId
      getStatistics(this.queryParams1).then(response => {
        this.taskinfoList = response.rows
        console.log(this.taskinfoList)
        this.open = true
        this.infototal = response.total
        this.title = '考试统计详情'
      })
    },
    handleExport() {
      console.log(this.queryParams1)
      this.download('statistics/exportTask', {
        ...this.queryParams1
      }, `grade_${new Date().getTime()}.xlsx`)
    },
    lastlisthandleExport() {
      console.log(this.queryParams2)
      this.download('/statistics/task/deptList/lastList/export', {
        ...this.queryParams2
      }, `grade_${new Date().getTime()}.xlsx`)
    }
  }
}
</script>
