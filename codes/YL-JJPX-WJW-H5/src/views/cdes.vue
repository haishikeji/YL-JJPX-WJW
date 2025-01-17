<script setup lang="ts">
import { ref, inject, reactive, onMounted } from "vue";
import { useRouter } from "vue-router";
import { _siginInfo, _getTaskInfo } from "../http/api";
import { getCZTInfo } from "../assets/index";
const msg = reactive({
  phone: "",
  name: "",
  code: "",
  id: "",
});
const testType = ref("");
const score: any = ref({});
const info: any = ref({});
let showMask = inject("showmask") as any;
const router = useRouter();
onMounted(() => {
  let query = router.currentRoute.value.query;
  if (!query.id) return router.push("/login");
  msg.id = query.id as string;
  testType.value = (query.type as string) || "";
  info.value = getCZTInfo();
  if (Number(testType.value) < 1) {
    getInfo();
    document.title = "救在身边急救知识培训";
  } else {
    document.title = "急救培训管理系统";
  }
  _siginInfo(query.id as string, "3").then((res: any) => {
    if (res.code == 200) {
      info.value = { ...info.value, ...res.data };
      console.log(info.value);
    } else {
      showMask.setData({
        showMask: true,
        msg: res.msg,
        cancel: "",
        confirm: "确认",
        delay: "",
        onCancel: () => {},
        onConfirm: () => {},
      });
    }
  });
});

// method
function getInfo() {
  let data = {
    nickName: info.value.nickName,
    phone: info.value.phone,
    taskId: msg.id,
    maskCode: "",
    coName: info.value.coName,
  };
  _getTaskInfo(data).then((res: any) => {
    if (res.code == 200) {
      if (res.data.lastTestTime) {
        // if(Number(testType.value)>0){
        //   return router.replace('/ana?id='+msg.id+'&type='+testType.value)
        // }else{
        //   return router.replace('/score?id='+msg.id)
        // }
        return router.replace("/ana?id=" + msg.id + "&type=" + testType.value);
      }
      score.value = res.data;
    } else {
      showMask.setData({
        showMask: true,
        msg: res.msg,
        cancel: "",
        confirm: "确认",
        delay: "",
        onCancel: () => {},
        onConfirm: () => {
          console.log(111);
        },
      });
    }
  });
}
function goTask() {
  if (Number(testType.value) > 0) {
    return router.replace(`/list?id=${msg.id}&type=${testType.value}`);
  }
  console.log(info.value);
  let data = {
    nickName: info.value.nickName,
    phone: info.value.phone,
    taskId: msg.id,
    maskCode: "",
    coName: info.value.coName,
  };
  _getTaskInfo(data).then((res: any) => {
    if (res.code == 200) {
      if (res.data.lastTestTime) {
        // if(Number(testType.value)>0){
        //   return router.replace('/ana?id='+msg.id+'&type='+testType.value)
        // }else{
        //   return router.replace('/score?id='+msg.id)
        // }
        return router.replace("/ana?id=" + msg.id + "&type=" + testType.value);
      }
      score.value = res.data;
      router.replace(`/list?id=${msg.id}&type=${testType.value}`);
    } else {
      showMask.setData({
        showMask: true,
        msg: res.msg,
        cancel: "",
        confirm: "确认",
        delay: "",
        onCancel: () => {},
        onConfirm: () => {},
      });
    }
  });
}
function sendCode() {
  showMask.setData({
    showMask: true,
    msg: "签到成功",
    cancel: "",
    confirm: "确认",
    delay: "",
    onCancel: () => {},
    onConfirm: () => {},
  });
}
</script>
<template>
  <div class="page bg_gray">
    <div class="content bg_white" :class="Number(testType) > 0 && 'active'">
      <div v-if="info.taskName" class="title">
        <p v-show="Number(testType) > 0" class="p">{{ info.taskName }}</p>
      </div>
      <div v-if="info.totalNum" class="sign_msg">
        <div class="num">
          <img src="@/assets/icon/examinationquestions@2x.png" alt="" />
          <p class="subtitle">{{ info.totalNum }}</p>
          <p class="des">考题数量</p>
        </div>
        <div class="time">
          <img src="@/assets/icon/Dailyexams@2x.png" alt="" />
          <p class="subtitle">{{ info.testDuration }}分钟</p>
          <p class="des">考试时长</p>
        </div>
      </div>
      <div @click="goTask" class="start bt_blue f16">开始考试</div>
    </div>
  </div>
</template>
<style lang="less" scoped>
.page {
  .content {
    padding: 20px;
    width: 670px;
    height: 1080px;
    border-radius: 24px;
    flex-direction: column;
    display: flex;
    align-items: center;
    margin: auto;
    justify-content: space-between;
    box-sizing: border-box;
    background: url("../assets/bg1.png") center center/670px 1080px no-repeat;
    &.active {
      background: url("../assets/bg2.png") center center/670px 1080px no-repeat;
    }
    .title {
      padding: 60px 20px;
      width: 100%;
      box-sizing: border-box;
      font-size: 40px;
      line-height: 64px;
      text-align: center;
      overflow: hidden;
    }
    .p {
      padding-top: 88px;
      font-weight: 600;
      color: rgba(226, 98, 78, 1);
    }
    .sign_msg {
      padding: 0 20px;
      display: flex;
      flex-flow: row nowrap;
      font-family: 思源黑体;
      .num {
        margin-right: 12px;
      }
      .num,
      .time {
        width: 280px;
        height: 280px;
        border-radius: 16px;
        background: rgba(255, 255, 255, 0.8);
        display: flex;
        flex-flow: column nowrap;
        justify-content: center;
        align-items: center;
        img {
          width: 48px;
          height: 48px;
        }
        .subtitle {
          font-size: 40px;
          line-height: 60px;
          color: #3d3d3d;
          margin: 8px auto;
        }
        .des {
          font-size: 20px;
          color: #999999;
        }
      }
    }
    .start {
      width: 590px;
      height: 104px;
      font-size: 32px;
      border-radius: 16px;
      color: white;
      text-align: center;
      line-height: 104px;
    }
  }
}
</style>
