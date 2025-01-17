<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="题库名称" prop="bankName">
        <el-input v-model="queryParams.bankName" placeholder="请输入题库名称" clearable style="width: 240px"/>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button type="primary" plain icon="el-icon-plus" size="mini" @click="handleAdd"
                   v-hasPermi="['examination:questionBank:add']"
        >新增
        </el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="success" plain icon="el-icon-edit" size="mini" :disabled="single" @click="handleUpdate"
                   v-hasPermi="['examination:questionBank:edit']"
        >修改
        </el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="danger" plain icon="el-icon-delete" size="mini" :disabled="multiple" @click="handleDelete"
                   v-hasPermi="['examination:questionBank:remove']"
        >删除
        </el-button>
      </el-col>
    </el-row>

    <el-table v-loading="loading" :data="bankList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center"/>
      <el-table-column label="题库名称" align="center" prop="bankName" :show-overflow-tooltip="true"/>
      <el-table-column label="题目数量" align="center" prop="qnum"/>
      <el-table-column label="单选题" align="center" prop="qradioNum"/>
      <el-table-column label="多选题" align="center" prop="qcheckboxNum"/>
      <el-table-column label="判断题" align="center" prop="qjudgeNum"/>
      <el-table-column label="案例" align="center" prop="qcaseNum"/>
      <el-table-column label="合格分数" align="center" prop="passScore"/>
      <el-table-column label="题库标签" align="center" prop="tag" :show-overflow-tooltip="true">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.topic_tag" :value="scope.row.tag"/>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button size="mini" type="text" icon="el-icon-edit" @click="handleUpdate(scope.row)"
                     v-hasPermi="['examination:questionBank:edit']"
          >修改
          </el-button>
          <el-button size="mini" type="text" icon="el-icon-delete" @click="handleDelete(scope.row)"
                     v-hasPermi="['examination:questionBank:remove']"
          >删除
          </el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination v-show="total > 0" :total="total" :page.sync="queryParams.pageNum" :limit.sync="queryParams.pageSize"
                @pagination="getList"
    />

    <!-- 添加或修改参数配置对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body :close-on-click-modal="false">
      <el-form ref="form" :model="form" :rules="rules" label-width="100px">
        <el-form-item label="题库名称" prop="bankName">
          <el-input v-model="form.bankName" placeholder="请输入题库名称"/>
        </el-form-item>
        <el-form-item label="题型选择">
          <span>题目类型</span><span style="margin-left: 50px;">题目数量</span>
        </el-form-item>
        <el-form-item label="单选题" prop="qradioNum" style="margin-left: 55px; margin-top: -10px;margin-bottom: 36px;">
          <el-input-number v-model="form.qradioNum" controls-position="right" :min="0"
                           style="width: 120px ;margin-left: 40px;"
          />
        </el-form-item>
        <el-form-item label="多选题" prop="qcheckboxNum"
                      style="margin-left: 55px;margin-top: -10px;margin-bottom: 36px;"
        >
          <el-input-number v-model="form.qcheckboxNum" controls-position="right" :min="0"
                           style="width: 120px ;margin-left: 40px;"
          />
        </el-form-item>
        <el-form-item label="判断题" prop="qjudgeNum" style="margin-left: 55px;margin-top: -10px;margin-bottom: 36px;">
          <el-input-number v-model="form.qjudgeNum" controls-position="right" :min="0"
                           style="width: 120px ;margin-left: 40px;"
          />
        </el-form-item>
        <el-form-item label="案  例" prop="qcaseNum" style="margin-left: 55px;margin-top: -10px;margin-bottom: 36px;">
          <el-input-number v-model="form.qcaseNum" controls-position="right" :min="0"
                           style="width: 120px ;margin-left: 40px;"
          />
        </el-form-item>
        <el-form-item label="合格分数线" prop="passScore">
          <el-input-number v-model="form.passScore" controls-position="right" :min="0" style="width: 100%"/>
        </el-form-item>
        <el-form-item label="题目排序">
          <el-radio-group v-model="form.sortType">
            <el-radio
              v-for="dict in dict.type.question_sort"
              :key="dict.value"
              :label="dict.value"
            >{{ dict.label }}
            </el-radio>
          </el-radio-group>
        </el-form-item>

        <el-form-item label="题目标签" prop="questionTags">
          <el-select v-model="form.questionTags" clearable multiple placeholder="请选择题目标签" style="width: 100%">
            <el-option v-for="dict in tagList" :key="dict.id" :label="dict.tagName" :value="dict.id"/>
          </el-select>
        </el-form-item>


        <el-form-item label="题库标签" prop="tag">
          <el-select v-model="form.tag" placeholder="请选择题库标签" clearable style="width: 100%">
            <el-option v-for="dict in dict.type.topic_tag" :key="dict.value" :label="dict.label" :value="dict.value"/>
          </el-select>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { addBank, delBank, getBank, listBank, taglist, updateBank } from '@/api/examination/questionBank'

export default {
  name: 'QuestionBank',
  dicts: ['topic_tag', 'question_sort'],
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
      // 题库表格数据
      bankList: [],
      // 弹出层标题
      title: '',
      // 是否显示弹出层
      open: false,
      // 日期范围
      dateRange: [],
      tagList: [],
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        bankName: [
          { required: true, message: '题库名称不能为空', trigger: 'blur' }
        ],
        qradioNum: [
          { required: true, message: '单选题数量不能为空', trigger: 'blur' },
          { type: 'number', min: 0, message: '', trigger: 'change' }
        ],
        qcheckboxNum: [
          { required: true, message: '多选题数量不能为空', trigger: 'blur' },
          { type: 'number', min: 0, message: '', trigger: 'change' }
        ],
        qjudgeNum: [
          { required: true, message: '判断题数量不能为空', trigger: 'blur' },
          { type: 'number', min: 0, message: '', trigger: 'change' }
        ],
        qcaseNum: [
          { required: true, message: '案例题数量不能为空', trigger: 'blur' },
          { type: 'number', min: 0, message: '', trigger: 'change' }
        ],
        passScore: [
          { required: true, message: '合格分数线不能为空', trigger: 'blur' },
          { type: 'number', min: 0, message: '', trigger: 'change' }
        ],
        tag: [
          { required: true, message: '标签不能为空', trigger: 'blur' }
        ],
        questionTags: [
          { required: true, message: '题目标签不能为空', trigger: 'blur' }
        ],
        questionsequence: [
          { required: true, message: '请选择排序', trigger: 'blur' }
        ]

      }
    }
  },
  created() {
    this.getList()
    console.log(this.dict.type.topic_tag)
    this.getTagList()
  },
  methods: {
    /** 查询题库类型列表 */
    getList() {
      this.loading = true
      listBank(this.addDateRange(this.queryParams, this.dateRange)).then(response => {
          this.bankList = response.rows
          this.total = response.total
          this.loading = false
        }
      )
    },
    // 查询tag列表
    getTagList() {
      taglist().then(response => {
        this.tagList = response.data
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
        passScore: 0,
        qradioNum: 0,
        qcheckboxNum: 0,
        qjudgeNum: 0,
        qcaseNum: 0,
        sortType: '1'
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
      this.dateRange = []
      this.resetForm('queryForm')
      this.handleQuery()
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset()
      this.open = true
      this.title = '添加题库'
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length != 1
      this.multiple = !selection.length
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset()
      const dictId = row.id || this.ids
      getBank(dictId).then(response => {
        this.form = response.data
        this.open = true
        this.title = '修改题库'
      })
    },
    /** 提交按钮 */
    submitForm: function() {
      this.$refs['form'].validate(valid => {
        if (valid) {
          if (this.form.id != undefined) {
            updateBank(this.form).then(response => {
              this.$modal.msgSuccess('修改成功')
              this.open = false
              this.getList()
            })
          } else {
            addBank(this.form).then(response => {
              this.$modal.msgSuccess('新增成功')
              this.open = false
              this.getList()
            })
          }
        }
      })
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const bankIds = row.id || this.ids
      this.$modal.confirm('是否确认删除题库').then(function() {
        return delBank(bankIds)
      }).then(() => {
        this.getList()
        this.$modal.msgSuccess('删除成功')
      }).catch(() => {
      })
    }
  }
}
</script>
