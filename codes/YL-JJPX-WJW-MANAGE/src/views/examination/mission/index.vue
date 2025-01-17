<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="100px">
      <el-form-item label="考试任务名称" prop="taskName">
        <el-input v-model="queryParams.taskName" placeholder="请输入考试任务名称" clearable style="width: 240px"/>
      </el-form-item>
      <el-form-item label="题库" prop="testBankId">
        <el-select v-model="queryParams.testBankId" placeholder="请选择题库" clearable style="width: 240px">
          <el-option v-for="item in bankList" :key="item.id" :label="item.bankName" :value="item.id"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="受试人员标签" prop="testPostId">
        <el-select v-model="queryParams.testPostId" placeholder="请选择标签" clearable style="width: 240px">
          <!-- <el-option v-for="dict in dict.type.subject_label" :key="dict.value" :label="dict.label"
            :value="dict.value" /> -->
          <el-option v-for="dict in dict.type.subject_label" :key="dict.raw.dictCode" :label="dict.raw.dictLabel"
                     :value="dict.raw.dictCode"
          >
          </el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="考试任务状态" prop="taskStatus">
        <el-select v-model="queryParams.taskStatus" placeholder="考试任务状态" clearable style="width: 240px">
          <el-option v-for="dict in dict.type.test_task_status" :key="dict.value" :label="dict.label"
                     :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button type="primary" plain icon="el-icon-plus" size="mini" @click="handleAdd"
                   v-hasPermi="['examination:mission:add']"
        >新增
        </el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="success" plain icon="el-icon-edit" size="mini" :disabled="single" @click="handleUpdate"
                   v-hasPermi="['examination:mission:edit']"
        >修改
        </el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="danger" plain icon="el-icon-delete" size="mini" :disabled="multiple" @click="handleDelete"
                   v-hasPermi="['examination:mission:remove']"
        >删除
        </el-button>
      </el-col>
    </el-row>

    <el-table v-loading="loading" :data="missionList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center"/>
      <el-table-column label="考试任务名称" align="center" prop="taskName" :show-overflow-tooltip="true"/>
      <el-table-column label="题库名称" align="center" prop="testBank" :show-overflow-tooltip="true"/>
      <el-table-column label="考核方式" align="center" prop="testTypeName" :show-overflow-tooltip="true">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.examine_type" :value="scope.row.testType"/>
        </template>
      </el-table-column>
      <el-table-column label="受试人员标签" align="center" prop="postName" :show-overflow-tooltip="true">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.subject_label" :value="scope.row.testPostStr"/>
        </template>
      </el-table-column>
      <el-table-column label="考试任务状态" align="center" prop="taskStatusName" :show-overflow-tooltip="true">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.test_task_status" :value="scope.row.taskStatus"/>
        </template>
      </el-table-column>
      <el-table-column label="创建时间" align="center" prop="createTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.createTime) }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width" width="350px">
        <template slot-scope="scope">
          <el-button size="mini" type="text" icon="el-icon-edit" @click="handleUpdate(scope.row)"
                     v-hasPermi="['examination:mission:edit']"
          >修改
          </el-button>
          <el-button v-if="scope.row.taskStatus == 1" size="mini" type="text" icon="el-icon-delete"
                     @click="handleDelete(scope.row)" v-hasPermi="['examination:mission:remove']"
          >删除
          </el-button>
          <el-button size="mini" type="text" icon="el-icon-reading" @click="handleGrade(scope.row)"
                     v-hasPermi="['examination:mission:grade']"
          >考试成绩
          </el-button>
          <el-button size="mini" type="text" icon="el-icon-document" @click="handleRecords(scope.row)"
                     v-hasPermi="['examination:mission:records']"
          >答题记录
          </el-button>
          <el-button v-if="((scope.row.taskStatus == 1 || scope.row.taskStatus == 2) && scope.row.testType == 3)"
                     size="mini" type="text" icon="el-icon-full-screen" @click="showQR(scope.row.id)"
                     v-hasPermi="['examination:mission:remove']"
          >查看二维码
          </el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination v-show="total > 0" :total="total" :page.sync="queryParams.pageNum" :limit.sync="queryParams.pageSize"
                @pagination="getList"
    />

    <!-- 添加或修改参数配置对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body :close-on-click-modal="false">
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="任务名称" prop="taskName">
          <el-input v-model="form.taskName" placeholder="请输入任务名称"/>
        </el-form-item>
        <el-form-item label="考核方式" prop="testType">
          <el-select v-model="form.testType" placeholder="请选择考核方式" clearable style="width: 100%">
            <el-option v-for="dict in dict.type.examine_type" :key="dict.value" :label="dict.label"
                       :value="dict.value"
            />
          </el-select>
        </el-form-item>
        <el-form-item label="受试标签" prop="testPost">
          <el-select v-model="form.testPost" multiple placeholder="请选择受试标签" clearable style="width: 100%">
            <el-option v-for="dict in dict.type.subject_label" :key="dict.value" :label="dict.label"
                       :value="dict.value+''"
            >
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="题库" prop="testBankId">
          <el-select v-model="form.testBankId" placeholder="请选择题库" clearable style="width: 100%">
            <el-option v-for="item in bankList" :key="item.id" :label="item.bankName" :value="item.id"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="开始时间" prop="testBeginTime">
          <el-date-picker v-model="form.testBeginTime" type="datetime" value-format="yyyy-MM-dd HH:mm:ss"
                          placeholder="选择日期时间" style="width: 100%"
          >
          </el-date-picker>
        </el-form-item>
        <el-form-item label="结束时间" prop="testEndTime">
          <el-date-picker v-model="form.testEndTime" type="datetime" value-format="yyyy-MM-dd HH:mm:ss"
                          placeholder="选择日期时间" style="width: 100%"
          >
          </el-date-picker>
        </el-form-item>
        <el-form-item label="考试时长" prop="testDuration">
          <el-input-number v-model="form.testDuration" controls-position="right" :min="0" style="width: 90%"/>
          <span
            style="margin-left: 10px;"
          >分钟</span>
        </el-form-item>
        <el-form-item label="重试次数" prop="retryNum">
          <el-input-number v-model="form.retryNum" controls-position="right" :min="0" style="width: 90%"/>
          <span
            style="margin-left: 10px;"
          >次</span>
        </el-form-item>
        <el-form-item label="展示分数">
          <el-radio-group v-model="form.isScore">
            <el-radio v-for="dict in dict.type.show_score" :key="dict.value" :label="dict.value">{{
                dict.label
              }}
            </el-radio>
          </el-radio-group>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>


    <!-- 考试成绩对话框 -->
    <el-dialog :title="gradeTitle" :visible.sync="gradeOpen" width="1400px" append-to-body
               :close-on-click-modal="false"
    >
      <el-form :model="queryGradeParams" ref="queryForm" size="small" :inline="true" v-show="showSearch"
               label-width="100px"
      >
        <el-form-item label="手机号" prop="phone">
          <el-input v-model="queryGradeParams.phone" placeholder="请输入手机号" clearable style="width: 240px"
                    @keyup.enter.native="handleGradeQuery"
          />
        </el-form-item>
        <el-form-item>
          <el-button type="primary" icon="el-icon-search" size="mini" @click="handleGradeQuery">搜索</el-button>
          <el-button type="warning" plain icon="el-icon-download" size="mini" @click="handleGradeExport"
                     v-hasPermi="['mission:grade:export']"
          >导出
          </el-button>
          <!-- 暂时隐藏 -->
          <!-- <el-button type="info" plain icon="el-icon-upload2" size="mini" @click="handleGradeImport"
            v-hasPermi="['mission:grade:import']">导入</el-button> -->
        </el-form-item>
      </el-form>
      <el-table v-loading="gradeLoading" :data="gradeList" @selection-change="handleSelectionChange">
        <el-table-column label="单位" align="center" prop="coName" :show-overflow-tooltip="true"/>
        <el-table-column label="姓名" align="center" prop="nickName" :show-overflow-tooltip="true"/>
        <el-table-column label="手机号" align="center" prop="phone" :show-overflow-tooltip="true"/>
        <el-table-column label="分数" align="center" prop="score" :show-overflow-tooltip="true"/>
        <!-- <el-table-column label="实操成绩" align="center" prop="grade" :show-overflow-tooltip="true" /> -->
        <el-table-column label="是否通过" align="center" prop="isPassStr" :show-overflow-tooltip="true"/>
        <el-table-column label="准确率" align="center" prop="successRate" :show-overflow-tooltip="true"/>
        <el-table-column label="考试用时" align="center" prop="useTime_yy" :show-overflow-tooltip="true"/>
        <el-table-column label="考试次数" align="center" prop="testNum" :show-overflow-tooltip="true"/>
        <el-table-column label="交卷时间" align="center" prop="createTime" width="180">
          <template slot-scope="scope">
            <span>{{ parseTime(scope.row.createTime) }}</span>
          </template>
        </el-table-column>

      </el-table>
      <pagination v-show="gradeTotal > 0" :total="gradeTotal" :page.sync="queryGradeParams.pageNum"
                  :limit.sync="queryGradeParams.pageSize" @pagination="getGradeList"
      />
    </el-dialog>

    <!-- 成绩导入对话框 -->
    <el-dialog :title="upload.title" :visible.sync="upload.open" width="400px" append-to-body>
      <el-upload ref="upload" :limit="1" accept=".xlsx, .xls" :headers="upload.headers"
                 :action="upload.url + '?updateSupport=' + upload.updateSupport" :disabled="upload.isUploading"
                 :on-progress="handleFileUploadProgress" :on-success="handleFileSuccess" :auto-upload="false" drag
      >
        <i class="el-icon-upload"></i>
        <div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
        <div class="el-upload__tip text-center" slot="tip">
          <span>仅允许导入xls、xlsx格式文件。</span>
          <el-link type="primary" :underline="false" style="font-size:12px;vertical-align: baseline;"
                   @click="importTemplate"
          >下载模板
          </el-link>
        </div>
      </el-upload>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitFileForm">确 定</el-button>
        <el-button @click="upload.open = false">取 消</el-button>
      </div>
    </el-dialog>

    <!-- 答题记录对话框 -->
    <el-dialog :title="recordTitle" :visible.sync="recordOpen" width="1400px" append-to-body
               :close-on-click-modal="false"
    >
      <el-form :model="queryRecordParams" ref="queryForm" size="small" :inline="true" v-show="showSearch"
               label-width="100px"
      >
        <el-form-item label="手机号" prop="phone">
          <el-input v-model="queryRecordParams.phone" placeholder="请输入手机号" clearable style="width: 240px"
                    @keyup.enter.native="handleRecordQuery"
          />
        </el-form-item>
        <el-form-item>
          <el-button type="primary" icon="el-icon-search" size="mini" @click="handleRecordQuery">搜索</el-button>
          <el-button type="warning" plain icon="el-icon-download" size="mini" @click="handleRecordExport"
                     v-hasPermi="['mission:record:export']"
          >导出
          </el-button>
        </el-form-item>
      </el-form>
      <el-table v-loading="recordLoading" :data="recordList" @selection-change="handleSelectionChange">
        <el-table-column label="单位" align="center" prop="coName" :show-overflow-tooltip="true"/>
        <el-table-column label="姓名" align="center" prop="nickName" :show-overflow-tooltip="true"/>
        <el-table-column label="手机号" align="center" prop="phone" :show-overflow-tooltip="true"/>
        <el-table-column label="分数" align="center" prop="score" :show-overflow-tooltip="true"/>
        <el-table-column label="是否通过" align="center" prop="isPassStr" :show-overflow-tooltip="true"/>
        <el-table-column label="准确率" align="center" prop="successRate" :show-overflow-tooltip="true"/>
        <el-table-column label="考试用时" align="center" prop="useTime_yy" :show-overflow-tooltip="true"/>
        <el-table-column label="交卷时间" align="center" prop="createTime" width="180">
          <template slot-scope="scope">
            <span>{{ parseTime(scope.row.createTime) }}</span>
          </template>
        </el-table-column>

      </el-table>
      <pagination v-show="recordTotal > 0" :total="recordTotal" :page.sync="queryRecordParams.pageNum"
                  :limit.sync="queryRecordParams.pageSize" @pagination="getRecordList"
      />
    </el-dialog>

    <!-- 二维码对话框 -->
    <el-dialog :title="QRTitle" :visible.sync="QROpen" width="240px" append-to-body :close-on-click-modal="false">
      <qrcode-vue :value="QRUrl" :size="200"></qrcode-vue>
    </el-dialog>

  </div>
</template>

<script>
import {
  listMission,
  getMission,
  addMission,
  updateMission,
  delMission,
  getQrcodeURL,
  listTestScore,
  listAnswerRecord
} from '@/api/examination/mission'
import { listBank, examlistBank } from '@/api/examination/questionBank'
import { listDatas } from '@/api/system/dict/data'
import { getData } from '@/api/system/dict/data'
import { getToken } from '@/utils/auth'
import QrcodeVue from 'qrcode.vue'

export default {
  name: 'Mission',
  dicts: ['test_task_status', 'subject_label', 'examine_type', 'show_score'],
  components: {
    QrcodeVue
  },
  data() {
    return {
      // 遮罩层
      loading: true,
      gradeLoading: true,
      recordLoading: true,
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
      gradeTotal: 0,
      recordTotal: 0,
      // 考试任务表格数据
      missionList: [],
      gradeList: [],
      recordList: [],
      bankList: [],
      dictDataList: [],
      // 弹出层标题
      title: '',
      gradeTitle: '',
      recordTitle: '',
      QRTitle: '',
      // 是否显示弹出层
      open: false,
      gradeOpen: false,
      recordOpen: false,
      QROpen: false,
      // 日期范围
      dateRange: [],
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10
      },
      queryRecordParams: {
        pageNum: 1,
        pageSize: 10,
        taskIdStr: undefined
      },
      queryGradeParams: {
        pageNum: 1,
        pageSize: 10,
        taskIdStr: undefined
      },
      QRUrl: '',
      // 用户导入参数
      upload: {
        // 是否显示弹出层（用户导入）
        open: false,
        // 弹出层标题（用户导入）
        title: '',
        // 是否禁用上传
        isUploading: false,
        // 是否更新已经存在的用户数据
        updateSupport: 0,
        // 设置上传的请求头部
        headers: { Authorization: 'Bearer ' + getToken() },
        // 上传的地址
        url: process.env.VUE_APP_BASE_API + '/mission/importData'
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        taskName: [
          { required: true, message: '任务名称不能为空', trigger: 'blur' }
        ],
        testBankId: [
          { required: true, message: '题库不能为空', trigger: 'blur' }
        ],
        testBeginTime: [
          { required: true, message: '开始时间不能为空', trigger: 'blur' },
          { validator: this.validateStartTime, trigger: 'blur' }
        ],
        testEndTime: [
          { required: true, message: '结束时间不能为空', trigger: 'blur' },
          { validator: this.validateEndTime, trigger: 'blur' }
        ],
        testPost: [
          { required: true, message: '受试标签不能为空', trigger: 'blur' }
        ],
        testType: [
          { required: true, message: '考核方式不能为空', trigger: 'blur' }
        ]
      }
    }
  },
  created() {
    this.getList()
    this.getQuestionBankList()
    this.getDictDateList()
  },
  methods: {
    async getData() {
      const res = await getData()
      if (res.code == 200) {
        this.tabname = res.data
      }
    },
    validateStartTime(rule, value, callback) {
      if (value && this.form.testEndTime && value > this.form.testEndTime) {
        callback(new Error('开始时间不能大于结束时间'))
      } else {
        callback()
      }
    },
    validateEndTime(rule, value, callback) {
      if (value && this.form.testBeginTime && value < this.form.testBeginTime) {
        callback(new Error('结束时间不能小于开始时间'))
      } else {
        callback()
      }
    },
    /** 查询考试任务类型列表 */
    getDictDateList() {
      var queryDictData = {
        dictType: 'subject_label'
      }
      listDatas(queryDictData).then(response => {
        this.dictDataList = response.rows
      })
    },
    /** 查询考试任务列表 */
    getList() {
      this.loading = true
      listMission(this.addDateRange(this.queryParams, this.dateRange)).then(response => {
          this.missionList = response.rows
          this.total = response.total
          this.loading = false
        }
      )
    },
    /** 查询考试成绩列表 */
    getGradeList() {
      this.gradeLoading = true
      listTestScore(this.queryGradeParams).then(response => {
        this.gradeList = response.rows
        this.gradeTotal = response.total
        this.gradeLoading = false
      })
    },
    /** 查询答题记录列表 */
    getRecordList() {
      this.recordLoading = true
      listAnswerRecord(this.queryRecordParams).then(response => {
        this.recordList = response.rows
        this.recordTotal = response.total
        this.recordLoading = false
      })
    },
    /** 查询题库类型列表 */
    getQuestionBankList() {
      this.loading = true
      examlistBank().then(response => {
          this.bankList = response.data
        }
      )
    },
    // 取消按钮
    cancel() {
      this.open = false
      this.reset()
    },
    // 表单重置
    reset() {
      this.form = {
        testDuration: 0,
        retryNum: 0,
        isScore: '1'
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
      this.dict.type.subject_label.forEach(item => {
        item.value = item.raw.dictCode
      })
      this.reset()
      this.open = true
      this.title = '添加考试任务'
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      console.log(selection)
      this.ids = selection.map(item => item.id)
      this.single = selection.length != 1
      this.multiple = !selection.length
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.dict.type.subject_label.forEach(item => {
        item.value = item.raw.dictCode
      })
      this.reset()
      console.log(row)
      this.id = row.id || this.ids
      getMission(this.id).then(response => {
        this.form = response.data
        if (typeof this.form.testPost === 'string') {
          this.form.testPost = this.form.testPost.split(',')
        }
        this.open = true
        this.title = '修改考试任务'
      })
    },
    /** 查看二维码 */
    showQR(id) {
      // 查看二维码的时候传递考试任务id
      console.log(id)
      getQrcodeURL({ taskId: id }).then(response => {
        this.QRUrl = response.msg
        this.QROpen = true
        this.QRTitle = '考试二维码'
      })
    },
    /** 考试成绩搜索按钮操作 */
    handleGradeQuery() {
      this.queryGradeParams.pageNum = 1
      listTestScore(this.queryGradeParams).then(response => {
        this.gradeList = response.rows
        this.gradeTotal = response.total
      })

    },
    /** 成绩导入按钮操作 */
    handleGradeImport() {
      this.upload.title = '成绩导入'
      this.upload.open = true
    },
    /** 成绩下载模板操作 */
    importTemplate() {
      this.download('mission/importTemplate', {}, `成绩导入模板_${new Date().getTime()}.xlsx`)
    },
    /** 成绩导出按钮操作 */
    handleGradeExport() {
      this.download('mission/exportGrade', {
        ...this.queryGradeParams
      }, `考试成绩_${new Date().getTime()}.xlsx`)
    },
    /** 考试成绩按钮操作 */
    handleGrade(row) {
      this.reset()
      var code = ''
      for (var i = 0; i < 6; i++) {
        code += parseInt(Math.random() * 10)
      }
      row.taskIdStr = row.id + '_wjwTest-' + code
      this.queryGradeParams.taskIdStr = row.taskIdStr
      listTestScore(this.queryGradeParams).then(response => {
        this.gradeList = response.rows
        this.gradeTotal = response.total
        this.gradeOpen = true
        this.gradeTitle = '考试成绩'
        this.gradeLoading = false
      })
    },

    /** 答题记录搜索按钮操作 */
    handleRecordQuery() {
      this.queryRecordParams.pageNum = 1
      listAnswerRecord(this.queryRecordParams).then(response => {
        this.recordList = response.rows
        this.recordTotal = response.total
      })
    },
    /** 答题记录按钮操作 */
    handleRecords(row) {
      this.reset()
      var code = ''
      for (var i = 0; i < 6; i++) {
        code += parseInt(Math.random() * 10)
      }
      row.taskIdStr = row.id + '_wjwTest-' + code
      this.queryRecordParams.taskIdStr = row.taskIdStr
      listAnswerRecord(this.queryRecordParams).then(response => {
        this.recordList = response.rows
        this.recordTotal = response.total
        this.recordOpen = true
        this.recordTitle = '答题记录'
        this.recordLoading = false
      })
    },
    /** 提交按钮 */
    submitForm: function() {
      this.$refs['form'].validate(valid => {
        if (valid) {
          this.form.testPost = this.form.testPost + ''
          if (this.form.id != undefined) {
            updateMission(this.form).then(response => {
              this.$modal.msgSuccess('修改成功')
              this.open = false
              this.getList()
            })
          } else {
            this.form.deptId =
              addMission(this.form).then(response => {
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
      const dictIds = row.id || this.ids
      this.$modal.confirm('是否确认删除考试任务').then(function() {
        return delMission(dictIds)
      }).then(() => {
        this.getList()
        this.$modal.msgSuccess('删除成功')
      }).catch(() => {
      })
    },

    /** 答题记录导出按钮操作 */
    handleRecordExport() {
      this.download('mission/exportRecord', {
        ...this.queryParams
      }, `type_${new Date().getTime()}.xlsx`)
    },
    // 文件上传中处理
    handleFileUploadProgress(event, file, fileList) {
      this.upload.isUploading = true
    },
    // 文件上传成功处理
    handleFileSuccess(response, file, fileList) {
      this.upload.open = false
      this.upload.isUploading = false
      this.$refs.upload.clearFiles()
      this.$alert('<div style=\'overflow: auto;overflow-x: hidden;max-height: 70vh;padding: 10px 20px 0;\'>' + response.msg + '</div>', '导入结果', { dangerouslyUseHTMLString: true })
      this.getGradeList()
    },
    // 提交上传文件
    submitFileForm() {
      this.$refs.upload.submit()
    }
  }
}
</script>

<style scoped>
.qr-code {
  margin-top: 20px;
  display: flex;
  justify-content: center;
}
</style>
