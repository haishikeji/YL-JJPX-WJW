package com.px.system.service.impl;

import com.alibaba.fastjson2.JSON;
import com.github.pagehelper.PageInfo;
import com.px.common.core.domain.entity.SysDictData;
import com.px.common.exception.ServiceException;
import com.px.common.utils.DateUtils;
import com.px.common.utils.RedisUtil;
import com.px.system.domain.*;
import com.px.system.domain.dto.TaskDto;
import com.px.system.mapper.*;
import com.px.system.service.MissionService;
import com.px.system.service.QuestionService;
import com.px.system.service.TempService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

/**
 * @Author：盛剑波
 * @Date：2024/6/3 15:13
 */
@Service
public class MissionServiceImpl implements MissionService {

    @Autowired
    private MissionMapper missionMapper;

    @Autowired
    private TempService tempService;

    @Autowired
    private UserTestTaskMapper userTestTaskMapper;

    @Autowired
    private QuestionBankMapper questionBankMapper;

    @Autowired
    private QuestionService questionService;

    @Autowired
    private UserTaskDetailMapper userTaskDetailMapper;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private UserTestLogMapper userTestLogMapper;

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private SysDictDataMapper sysDictDataMapper;


    @Override
    public List<Mission> selectMissionList(Mission mission) {
        List<Mission> missions = missionMapper.selectMissionList(mission);
        for (Mission mission1 : missions) {
            if (null != mission1.getTestPost() && !"".equals(mission1.getTestPost().trim())) {
                StringBuilder testPostStr = new StringBuilder();
                String[] dictCodes = mission1.getTestPost().split(",");
                for (String dictCode : dictCodes) {
                    SysDictData sysDictData = sysDictDataMapper.selectDictDataById(Long.parseLong(dictCode));
                    testPostStr.append(sysDictData.getDictLabel()).append(" ");
                }
                mission1.setTestPostStr(testPostStr.toString());
            }
        }
        return missions;
    }

    @Override
    public Mission selectMissionById(Long missionId) {
        Mission mission = new Mission();
        mission.setId(missionId.intValue());
        return missionMapper.selectMissionById(mission);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int addMission(Mission mission) {
        int i = missionMapper.addMission(mission);
        if (StringUtils.isNotBlank(mission.getTestPost())) {
            String[] postIdList = mission.getTestPost().split(",");
            for (String postId : postIdList) {
                mission.setTaskId(mission.getId());
                mission.setTestPostId(Integer.valueOf(postId));
                missionMapper.addTaskPost(mission);
            }
        }

//        //查询这个任务标签的人数
//        SysUser sysUser = new SysUser();
//        sysUser.setStatus("0");
//        sysUser.setDeptId(mission.getDeptId());
//        sysUser.setTagIds(mission.getTestPost());
//        Integer userCounts = sysUserMapper.selectUserCounts(sysUser);
//        //新增考试统计表
//        TaskStatistics taskStatistics = new TaskStatistics();
//        taskStatistics.setTaskId(mission.getId().longValue());
//        taskStatistics.setActualNum(0L);
//        taskStatistics.setNotNum(userCounts.longValue());
//        taskStatistics.setNeedNum(userCounts.longValue());
//        taskStatistics.setAverageScore(0d);
//        taskStatistics.setRate("0%");
//        taskStatisticsMapper.insertTTaskStatistics(taskStatistics);

        return i;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateMission(Mission mission) {
        if (StringUtils.isNotBlank(mission.getTestPost())) {
            String[] postIdList = mission.getTestPost().split(",");
            for (String postId : postIdList) {
                mission.setTaskId(mission.getId());
                mission.setTestPostId(Integer.valueOf(postId));
                missionMapper.addTaskPost(mission);
            }
        }
        missionMapper.deletePost(mission.getTestPostId());

        int i = missionMapper.updateMission(mission);

        //查询这个任务标签的人数
//        SysUser sysUser = new SysUser();
//        sysUser.setStatus("0");
//        sysUser.setDeptId(mission.getDeptId());
//        sysUser.setTagIds(mission.getTestPost());
//        Integer userCounts = sysUserMapper.selectUserCounts(sysUser);
//        //编辑考试统计表
//        TaskStatistics statistics = taskStatisticsMapper.selectTTaskStatisticsByTaskId(mission.getId().longValue());
//        if (null != statistics) {
//            statistics.setId(statistics.getId());
//            statistics.setActualNum(0L);
//            statistics.setNotNum(userCounts.longValue());
//            statistics.setNeedNum(userCounts.longValue());
//            statistics.setAverageScore(0d);
//            statistics.setRate("0%");
//            taskStatisticsMapper.updateTTaskStatistics(statistics);
//        }
        return i;
    }

    @Override
    public int deleteMissionByIds(Long[] missionId) {
        for (int i = 0; i < missionId.length; i++) {
            missionMapper.deletePost(missionId[i].intValue());

        }
        return missionMapper.deleteMissionByIds(missionId);

    }

    @Override
    public String getCodeUrl(String code) {
        return tempService.select(code);
    }

    @Override
    public List<Map<String, Object>> selectUserPassExam() {
        return missionMapper.selectUserPassExam();
    }

    @Override
    public List<UserTestTask> getTestScore(UserTestTask userTestTask) {
        return userTestTaskMapper.selectListByCondition(userTestTask);
    }

    @Override
    public List<UserTestTask> getTestRecord(UserTestTask userTestTask) {
        return userTestTaskMapper.selectLogListByCondition(userTestTask);
    }

    @Override
    public String importUserTestTask(List<UserTestTask> list) {
        if (com.px.common.utils.StringUtils.isNull(list) || list.isEmpty()) {
            throw new ServiceException("导入成绩数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (UserTestTask userTestTask : list) {
            try {
                userTestTaskMapper.updateUserTestTask(userTestTask);
                successNum++;
            } catch (Exception e) {
                failureNum++;
                String msg = "<br/>" + failureNum + "、成绩 " + userTestTask.getNickName() + " 导入失败：";
                failureMsg.append(msg + e.getMessage());
            }
        }
        if (failureNum > 0) {
            failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
            throw new ServiceException(failureMsg.toString());
        } else {
            successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        }
        return successMsg.toString();
    }

    @Override
    public UserTaskResponse userTaskList(UserTestTask testTask) {
        Integer dailyNum = 0;
        Integer testDailyNum = 0;
        Integer annualNum = 0;
        Integer testAnnualNum = 0;
        Integer dailyQNum = 0;
        Integer testDailySuccessNum = 0;
        Integer testDailyFailNum = 0;
        Integer annualQNum = 0;
        Integer testAnnualSuccessNum = 0;
        Integer testAnnualFailNum = 0;
        List<UserTaskDetailResponse> detailResponseList = new ArrayList<>();

        List<UserTestTask> userTestTaskList = userTestTaskMapper.selectUserTaskListByCondition(testTask);
        if (!CollectionUtils.isEmpty(userTestTaskList)) {
            for (UserTestTask userTestTask : userTestTaskList) {
                Integer taskType = userTestTask.getTestType();
                Map<String, Long> response = userTestTaskMapper.selectUserNums(userTestTask.getTaskId());
                UserTaskDetailResponse detailResponse = UserTaskDetailResponse.builder().taskId(userTestTask.getTaskId()).taskName(userTestTask.getTaskName()).testType(taskType).taskStatus(userTestTask.getTaskStatus()).build();
                detailResponse.setPassScore(userTestTask.getPassScore());
                detailResponse.setScore(userTestTask.getScore());
                detailResponse.setPoint(userTestTask.getTotalPoint());
                detailResponse.setQNum(userTestTask.getTotalNum());
                detailResponse.setTestNum(userTestTask.getTestNum());
                detailResponse.setRetryNum(userTestTask.getReTryNum());
                detailResponse.setTestBeginTime(userTestTask.getTestBeginTime());
                detailResponse.setTestEndTime(userTestTask.getTestEndTime());
                detailResponse.setTotalNum(response.get("totalNum"));
                detailResponse.setHasPassExamNum(response.get("hasPassExamNum"));
                detailResponse.setTestBeginTimeStr(formatDate(userTestTask.getTestBeginTime()));
                detailResponse.setTestEndTimeStr(formatDate(userTestTask.getTestEndTime()));

                detailResponseList.add(detailResponse);
            }
        }
        UserTaskResponse response = UserTaskResponse.builder().dailyNum(dailyNum).testDailyNum(testDailyNum).annualNum(annualNum).testAnnualNum(testAnnualNum)
                .dailyQNum(dailyQNum).testDailySuccessNum(testDailySuccessNum).testDailyFailNum(testDailyFailNum).annualQNum(annualQNum)
                .testAnnualSuccessNum(testAnnualSuccessNum).testAnnualFailNum(testAnnualFailNum).build();
        response.setTaskList(detailResponseList);

        return response;

    }

    @Override
    public TTestJoin getUserCheckStatus(TTestJoin testJoin) {
        return null;
    }

    @Override
    public Mission getTestTaskInfoByID(Integer taskId) {
        return missionMapper.selectByPrimaryKey(taskId);
    }

    @Override
    public List<SysCompany> getCompanyList(SysCompany query) {
        return Collections.emptyList();
    }

    @Override
    public SignResponse addTestSign(TTestJoin user, Mission testTask) {
        return null;
    }

    @Override
    public List<UserTestTask> getUserTestList(UserTestTask userTestTask) {
        return userTestTaskMapper.selectListByCondition(userTestTask);
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public QuestionResponse addExam(String phone, String nickName, String coName, Mission testTask, List<QuestionListRequest> answerList, Integer lastTestId, Integer maxScore, Integer totalPoint) {
        String userSubmitKey = "WJW_T_SUB_ANSWER_" + phone + "_" + testTask.getId();
        redisUtil.del(userSubmitKey);
        QuestionResponse result = QuestionResponse.builder().taskId(testTask.getId()).taskName(testTask.getTaskName()).testType(Integer.valueOf(testTask.getTestType())).testBeginTime(testTask.getTestBeginTime())
                .testEndTime(testTask.getTestEndTime()).taskStatus(testTask.getTaskStatus()).testDuration(testTask.getTestDuration()).retryNum(testTask.getRetryNum()).isScore(Integer.valueOf(testTask.getIsScore()))
                .build();
        QuestionBank questionBank = getBankById(testTask.getTestBankId());
        if (null == questionBank) {
            throw new ServiceException("该考试题库已删除，无法继续考试");
        }
        result.setPassScore(questionBank.getPassScore());
        result.setTag(questionBank.getTag());

        result.setQCheckboxNum(questionBank.getQCheckboxNum());
        result.setQJudgeNum(questionBank.getQJudgeNum());
        result.setQRadioNum(questionBank.getQRadioNum());
        result.setQCaseNum(questionBank.getQCaseNum());
        result.setQNum(questionBank.getQNum());
        result.setPhone(phone);
        Integer score = 0;
        Integer point = 0;
        Integer successNum = 0;
        List<UserTestLog> userTestLogList = new ArrayList<>();

        UserTaskDetail userTaskDetail = userTaskDetailMapper.selectByCondition(UserTaskDetail.builder().phone(phone).taskId(testTask.getId()).build());
        List<Question> questionList = new ArrayList<>();
        if (userTaskDetail != null) {
            String qList = userTaskDetail.getTaskInfo();
            questionList = JSON.parseArray(qList, Question.class);
        }
        if (!CollectionUtils.isEmpty(questionList)) {
            for (Question tQuestion : questionList) {
                List<String> optionList = getUserOption(answerList, tQuestion.getId());
                Question question = questionMapper.selectQuestionById(tQuestion.getId().longValue());
//                if (question == null || !question.getTag().equals(questionBank.getTag())) {
                if (question == null) {
                    throw new ServiceException("提交的题目ID:" + tQuestion.getId() + ",非法");
                }
                String submitAnswer = "";
                if (!CollectionUtils.isEmpty(optionList)) {
                    Collections.sort(optionList);
                    for (String option : optionList) {
                        submitAnswer += option.trim() + ";";
                    }
                    if (submitAnswer.length() > 1) {
                        submitAnswer = submitAnswer.substring(0, submitAnswer.length() - 1);
                    }
                }
                UserTestLog userTestLog = UserTestLog.builder().phone(phone).qId(question.getId()).qAnswer(submitAnswer).build();
                userTestLog.setAnswer(question.getQAnswer());
                if (submitAnswer.equals(question.getQAnswer())) {
                    userTestLog.setScore(question.getScore());
                    successNum++;
                    score = score + question.getScore();
                    if (question.getPoint() != null) {
                        point = point + question.getPoint();
                    }
                } else {
                    userTestLog.setScore(0);
                }
                userTestLogList.add(userTestLog);
            }
        }
        // 把其他考试 更新失效
        if (Objects.equals(testTask.getTestType(), "4") || Objects.equals(testTask.getTestType(), "2")) {
            //积分模式 题目更新
            userTaskDetailMapper.deleteByPrimaryKey(userTaskDetail.getId());
        } else {
            userTaskDetailMapper.updateByPrimaryKeySelective(UserTaskDetail.builder().id(userTaskDetail.getId()).submitStatus(1).build());
        }
        Date startTime = userTaskDetail.getCreateTime();
        Date now = new Date();
        Long useTimeSec = DateUtils.getSecondBetween(startTime, now);
        String useTime = "";
        if (useTimeSec > 60) {
            Long userTimeMin = useTimeSec / 60;
            if (userTimeMin >= testTask.getTestDuration().longValue()) {
                useTime = testTask.getTestDuration() + "分钟0秒";
            } else {
                Long useTimeSecond = useTimeSec % 60;
                useTime = userTimeMin + "分钟" + useTimeSecond + "秒";
            }
        } else {
            useTime = useTimeSec + "秒";
        }

        // 非最高分
        Boolean newMaxScoce = score >= maxScore;
        if (lastTestId != null && newMaxScoce) {
            UserTestTask userTestTask = new UserTestTask();
            userTestTask.setPhone(phone);
            userTestTask.setTaskId(testTask.getId());
            userTestTask.setStatus(0);
            userTestTaskMapper.updateUserTest(userTestTask);
        }
        Integer failNum = questionBank.getQNum() - successNum;
        UserTestTask userTestTask = new UserTestTask();
        userTestTask.setPhone(phone);
        userTestTask.setCoName(coName);
        userTestTask.setNickName(nickName);
        userTestTask.setTaskId(testTask.getId());
        userTestTask.setWrongNum(failNum);
        userTestTask.setCorrectNum(successNum);
        userTestTask.setTotalNum(questionBank.getQNum());
        userTestTask.setScore(score);
        userTestTask.setPoint(point);
        Boolean isPass = score >= questionBank.getPassScore();
        userTestTask.setUseTime(useTime);
        userTestTask.setIsPass(isPass ? 1 : 0);
        userTestTask.setCreateTime(new Date());
        userTestTask.setStatus(newMaxScoce ? 1 : 0);
        result.setUseTime(useTime);
        result.setPoint(point + totalPoint);
        result.setScore(userTestTask.getScore());
        result.setIsPass(userTestTask.getIsPass());
        result.setCorrectNum(userTestTask.getCorrectNum());
        result.setWrongNum(userTestTask.getWrongNum());
        result.setLastTestTime(userTestTask.getCreateTime());
        userTestTaskMapper.insertSelective(userTestTask);
        result.setTaskLogId(userTestTask.getId());
        if (!CollectionUtils.isEmpty(userTestLogList)) {
            for (UserTestLog userTestLog : userTestLogList) {
                userTestLog.setUserTaskId(userTestTask.getId());
                userTestLogMapper.insertSelective(userTestLog);
            }
        }
//        updateTaskStatistics(testTask.getId().longValue());
        return result;
    }

//    public void updateTaskStatistics(Long taskId) {
//        TaskStatistics statistics = taskStatisticsMapper.selectTTaskStatisticsByTaskId(taskId);
//        if (statistics != null) {
//            statistics.setActualNum(statistics.getActualNum() + 1);
//            statistics.setNotNum(statistics.getNotNum() - 1);
//            double v = ((double) statistics.getActualNum() / statistics.getNeedNum()) * 100;
//            statistics.setRate(v + "%");
//            UserTestTask userTestTask = new UserTestTask();
//            userTestTask.setTaskId(taskId.intValue());
//            userTestTask.setStatus(1);
//            double ava = userTestTaskMapper.selectUserTestTaskList(userTestTask);
//            statistics.setAverageScore(ava);
//            taskStatisticsMapper.updateTTaskStatistics(statistics);
//        }
//
//    }


    private List<String> getUserOption(List<QuestionListRequest> answerList, Integer qid) {
        if (!CollectionUtils.isEmpty(answerList)) {
            for (QuestionListRequest questionListRequest : answerList) {
                if (questionListRequest != null && questionListRequest.getId() != null) {
                    if (questionListRequest.getId().equals(qid)) {
                        return questionListRequest.getOptionList();
                    }
                }
            }
        }
        return Collections.EMPTY_LIST;
    }

    @Override
    public List<UserTestTask> getUserTestLogList(UserTestTask userTestTask) {
        return userTestTaskMapper.selectUserListByCondition(userTestTask);
    }

    @Override
    public QuestionBank getBankById(Integer bankId) {
        return questionBankMapper.selectQuestionBankById(bankId.longValue());
    }

    @Override
    public List<Question> getQuestionByBank(QuestionBank questionBank, String phone, Integer taskId, Integer newTest) {
        UserTaskDetail userTaskDetail = userTaskDetailMapper.selectByCondition(UserTaskDetail.builder().phone(phone).taskId(taskId).build());
        List<Question> questionList = new ArrayList<>();
        if (userTaskDetail == null && null != newTest && 1 == newTest) {
            Question query = new Question();
//            query.setTag(questionBank.getTag());
            query.setSortType(Integer.valueOf(questionBank.getSortType()));
            String tags = questionBank.getQuestionTag();
            if (tags != null && !tags.equals("")) {
                query.setTags(tags.split(","));
            }
            if (questionBank.getQRadioNum() > 0) {
                query.setQType("1");
                PageInfo<Question> radioList = questionService.selectQuestionOptionList(1, questionBank.getQRadioNum(), query);
                if (radioList != null && !CollectionUtils.isEmpty(radioList.getList())) {
                    for (Question question : radioList.getList()) {
                        question.setQAnswer(null);
                        questionList.add(question);
                    }
                }
            }
            if (questionBank.getQCheckboxNum() > 0) {
                query.setQType("2");
                PageInfo<Question> checkboxList = questionService.selectQuestionOptionList(1, questionBank.getQCheckboxNum(), query);
                if (checkboxList != null && !CollectionUtils.isEmpty(checkboxList.getList())) {
                    for (Question question : checkboxList.getList()) {
                        question.setQAnswer(null);
                        questionList.add(question);
                    }
                }
            }
            if (questionBank.getQJudgeNum() > 0) {
                query.setQType("3");
                PageInfo<Question> judgeList = questionService.selectQuestionOptionList(1, questionBank.getQJudgeNum(), query);
                if (judgeList != null && !CollectionUtils.isEmpty(judgeList.getList())) {
                    for (Question question : judgeList.getList()) {
                        question.setQAnswer(null);
                        questionList.add(question);
                    }
                }
            }
            if (questionBank.getQCaseNum() > 0) {
                query.setQType("4");
                PageInfo<Question> caseList = questionService.selectQuestionOptionList(1, questionBank.getQCaseNum(), query);
                if (caseList != null && !CollectionUtils.isEmpty(caseList.getList())) {
                    for (Question question : caseList.getList()) {
                        question.setQAnswer(null);
                        questionList.add(question);
                    }
                }
            }
            Date now = new Date();
            questionBank.setTestStartTime(now);
            userTaskDetailMapper.insertSelective(UserTaskDetail.builder().phone(phone).taskId(taskId).taskInfo(JSON.toJSONString(questionList)).createTime(now).submitStatus(0).build());
        } else {
            if (null != userTaskDetail) {
                String qList = userTaskDetail.getTaskInfo();
                questionList = JSON.parseArray(qList, Question.class);
                questionBank.setTestStartTime(userTaskDetail.getCreateTime());
                if (userTaskDetail.getSubmitStatus() == 1 && null != newTest && 1 == newTest) {
                    Date now = new Date();
                    questionBank.setTestStartTime(now);
                    userTaskDetailMapper.updateByPrimaryKeySelective(UserTaskDetail.builder().id(userTaskDetail.getId()).createTime(now).submitStatus(0).build());
                }
            }
        }
        return questionList;
    }

    @Override
    public AnalysisResponse examAnalysis(String phone, Integer taskLogId) {
        AnalysisResponse response = AnalysisResponse.builder().phone(phone).build();
        UserTestTask userTestTask = userTestTaskMapper.selectByPrimaryKey(taskLogId);
        if (null == userTestTask) {
            throw new ServiceException("考试记录不存在");
        }
        response.setTaskId(userTestTask.getTaskId());
        response.setQNum(userTestTask.getTotalNum());
        response.setWrongNum(userTestTask.getWrongNum());
        response.setUseTime(userTestTask.getUseTime());
        Mission testTask = getTestTaskInfoByID(userTestTask.getTaskId());
        if (testTask == null) {
            throw new ServiceException("该考试任务不存在");
        }
        QuestionBank questionBank = getBankById(testTask.getTestBankId());
        if (questionBank == null) {
            throw new ServiceException("题库不存在");
        }
        response.setQCheckboxNum(questionBank.getQCheckboxNum());
        response.setQJudgeNum(questionBank.getQJudgeNum());
        response.setQRadioNum(questionBank.getQRadioNum());
        response.setQCaseNum(questionBank.getQCaseNum());
        response.setQNum(questionBank.getQNum());
        UserTestLog build = UserTestLog.builder().phone(phone).userTaskId(taskLogId).build();
        List<UserTestLog> userTestLogList = userTestLogMapper.selectListByCondition(build);
        List<Question> questionList = new ArrayList<>();
        List<QuestionListRequest> answerList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(userTestLogList)) {
            for (UserTestLog userTestLog : userTestLogList) {
                Question query = new Question();
                query.setId(userTestLog.getQId());
                PageInfo<Question> qList = questionService.selectQuestionOptionList(1, 1, query);
                QuestionListRequest optionReq = new QuestionListRequest();
                if (qList != null && !CollectionUtils.isEmpty(qList.getList())) {
                    Question question = qList.getList().get(0);
                    questionList.add(question);
                    optionReq.setQType(Integer.valueOf(question.getQType()));
                }
                List<String> optionList = new ArrayList<>();
                if (StringUtils.isNotBlank(userTestLog.getQAnswer())) {
                    String[] qanswerList = userTestLog.getQAnswer().split(";");
                    for (String qanswer : qanswerList) {
                        optionList.add(qanswer);
                    }
                }

                optionReq.setId(userTestLog.getQId());

                optionReq.setOptionList(optionList);
                answerList.add(optionReq);
            }
        }
        response.setQuestionList(questionList);
        response.setAnswerList(answerList);
        return response;
    }

    @Override
    public List<TaskStatistics> selectStatisticsByCondition(TaskStatistics record) {
        return missionMapper.selectStatisticsByCondition(record);
    }

    @Override
    public List<TaskStatistics> getTaskStatisticsPage(TaskStatistics user) {
        return missionMapper.getTaskStatisticsPage(user);
    }

    @Override
    public List<TaskStatistics> selectLastList(TaskStatistics user) {
        return missionMapper.selectLastList(user);
    }

    //查询某个考试id下所有的用户的姓名、电话、单位、实操成绩信息
    public List<UserTestTask> selectUserListByTaskId(TaskDto task) {
        return userTestTaskMapper.selectUsersByTaskID(task.getTaskId(), task.getSearch());
    }

    @Override
    public List<UserTestTask> selectNotScoredUserList(TaskDto task) {
        return userTestTaskMapper.selectNotScoredUserList(task.getTaskId(), task.getSearch());
    }

    @Override
    public int updateUserTestTask(UserTestTask task) {
        return userTestTaskMapper.updateTUserTestTask(task);
    }

    private String formatDate(Date date) {
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = instant.atZone(zone).toLocalDateTime();
        // 获取月份
        int month = localDateTime.getMonthValue();
        // 获取日期
        int day = localDateTime.getDayOfMonth();
        // 获取小时
        int hour = localDateTime.getHour();
        // 获取分钟
        int minute = localDateTime.getMinute();
        return month + "月" + day + "日 " + hour + "时" + minute + "分";

    }

}
