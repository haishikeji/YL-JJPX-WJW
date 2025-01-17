<script setup lang="ts">
import foot from "../components/footer.vue";
import mainview from "../components/mainview.vue";
import { onMounted, inject } from "vue";
import type { Ref } from "vue";
import { _homeTask } from "../http/api";
import { reactive, ref } from "vue";
import { setCZTInfo } from "../assets/index";
import { useRouter } from "vue-router";
const userouter = useRouter();
const showMask = inject("showmask") as any;
const data: any = reactive({
  info: {},
  isShow: false,
  isflag: false,
});
const statusArr = ref(["全部", "未开始", "考核中", "已结束"]);
const yearArr = ref(["2023", "2024", "2025", "2026"]);
const dateone = ref([
  {
    taskId: 54,
    taskName: "现场考试测试",
    testType: 2,
    testTypeName: "练习模式",
    taskStatus: 2,
    taskStatusName: "考核中",
    passScore: 1,
    score: null,
    point: null,
    testNum: 0,
    retryNum: 0,
    desc: "题目数量:3 参与次数:0 ",
    qnum: 3,
  },
  {
    taskId: 54,
    taskName: "现场考试测试",
    testType: 2,
    testTypeName: "练习模式",
    taskStatus: 2,
    taskStatusName: "考核中",
    passScore: 1,
    score: null,
    point: null,
    testNum: 0,
    retryNum: 0,
    desc: "题目数量:3 参与次数:0 ",
    qnum: 3,
  },
  {
    taskId: 54,
    taskName: "现场考试测试",
    testType: 2,
    testTypeName: "练习模式",
    taskStatus: 2,
    taskStatusName: "考核中",
    passScore: 1,
    score: null,
    point: null,
    testNum: 0,
    retryNum: 0,
    desc: "题目数量:3 参与次数:0 ",
    qnum: 3,
  },
  {
    taskId: 54,
    taskName: "现场考试测试",
    testType: 2,
    testTypeName: "练习模式",
    taskStatus: 2,
    taskStatusName: "考核中",
    passScore: 1,
    score: null,
    point: null,
    testNum: 0,
    retryNum: 0,
    desc: "题目数量:3 参与次数:0 ",
    qnum: 3,
  },
  {
    taskId: 54,
    taskName: "现场考试测试",
    testType: 2,
    testTypeName: "练习模式",
    taskStatus: 2,
    taskStatusName: "考核中",
    passScore: 1,
    score: null,
    point: null,
    testNum: 0,
    retryNum: 0,
    desc: "题目数量:3 参与次数:0 ",
    qnum: 3,
  },
  {
    taskId: 54,
    taskName: "现场考试测试",
    testType: 2,
    testTypeName: "练习模式",
    taskStatus: 2,
    taskStatusName: "考核中",
    passScore: 1,
    score: null,
    point: null,
    testNum: 0,
    retryNum: 0,
    desc: "题目数量:3 参与次数:0 ",
    qnum: 3,
  },
]);
const taskStatus: Ref<any> = ref(" ");
const year = ref(new Date().getFullYear() + "");
onMounted(() => {
  _homeTask({
    year: year.value,
    taskStatus: taskStatus.value == " " ? null : taskStatus.value,
    //  taskStatus: taskStatus.value === ' ' ? null : taskStatus.value as string | null
  }).then((res: any) => {
    data.info = res.data;
    if (data.info.taskList.length == 0) {
      data.isflag = true;
    }
    setCZTInfo({
      nickName: res.data.nickName,
      phone: res.data.phone,
    });
  });
});
function goTest(type: string, id: string, status: string, num: number) {
  console.log(type);

  if (status == "1") {
    return showMask.setData({
      showMask: true,
      msg: "考试未开始",
      cancel: "",
      confirm: "确认",
      delay: "",
      onCancel: () => {},
      onConfirm: () => {},
    });
  }
  if (status == "3") {
    return showMask.setData({
      showMask: true,
      msg: "考试已结束",
      cancel: "",
      confirm: "确认",
      delay: "",
      onCancel: () => {},
      onConfirm: () => {},
    });
  }
  if (num > 0) {
    return userouter.push("/ana?id=" + id + "&type=" + type);
  }
  userouter.push("/cdes?id=" + id + "&type=" + type);
}
function setStatus(index: string) {
  if (index == "0") {
    taskStatus.value = null;
  } else {
    taskStatus.value = index;
  }
  data.isShow = !data.isShow;
  _homeTask({
    year: year.value,
    taskStatus: taskStatus.value,
  }).then((res: any) => {
    data.info = res.data;
  });
}
function setYear(index: number) {
  year.value = yearArr.value[index];
  data.isYearShow = !data.isYearShow;
  _homeTask({
    year: year.value,
    taskStatus: taskStatus.value,
  }).then((res: any) => {
    data.info = res.data;
  });
}
</script>
<template>
  <div class="page bg_gray">
    <header>急救培训管理系统</header>
    <div class="select">
      <div @click="data.isShow = !data.isShow">
        <p>全部</p>
        <span></span>
      </div>
      <div @click="data.isYearShow = !data.isYearShow">
        <p>{{ year }}年度</p>
        <span></span>
      </div>
    </div>
    <div class="list">
      <!-- dateone  data.info.taskList -->
      <div
        @click.stop="
          goTest(item.testType, item.taskId, item.taskStatus, item.testNum)
        "
        v-for="(item, index) in data.info.taskList"
        :key="index"
        class="item"
      >
        <div class="img">
          <div
            :class="[
              item.testTypeName == '线上考试' && 'active1',
              item.testTypeName == '练习模式' && 'active2',
              item.testTypeName == '积分模式' && 'active3',
            ]"
          >
            {{ item.testTypeName }}
          </div>
          <span
            :class="[
              item.taskStatusName == '考核中' && 'active1',
              item.taskStatusName == '已结束' && 'active2',
              item.taskStatusName == '未开始' && 'active3',
            ]"
            class="tag"
            >{{ item.taskStatusName }}</span
          >
        </div>
        <div class="info">
          <div class="title limit2">{{ item.taskName }}</div>

          <div class="more">{{ item.desc }}</div>
        </div>
      </div>
      <div class="without">
        <span></span>
        <p>我是有底线的</p>
        <span></span>
      </div>
    </div>
    <!-- <div class="without">
            <span></span>
            <p>我是有底线的</p>
            <span></span>
        </div> -->
    <!-- <mainview :info="data.info" /> -->
    <div v-if="data.isShow" class="ul">
      <div class="wrap">
        <ul>
          <li
            v-for="(item, index) in statusArr"
            :key="index"
            @click="setStatus(index + '')"
          >
            {{ item }}
          </li>
          <li @click="data.isShow = !data.isShow">取消</li>
        </ul>
      </div>
    </div>
    <div v-if="data.isYearShow" class="ul">
      <div class="wrap">
        <ul>
          <li
            v-for="(item, index) in yearArr"
            :key="index"
            @click="setYear(index)"
          >
            {{ item }}年度
          </li>
          <li @click="data.isYearShow = !data.isYearShow">取消</li>
        </ul>
      </div>
    </div>
    <foot />
  </div>
</template>

<style lang="less" scoped>
.page {
  padding: 40px;
}

header {
  width: 670px;
  height: 160px;
  font-size: 40px;
  text-align: center;
  line-height: 160px;
  color: white;
  overflow: hidden;
  border-radius: 10px;
  background: url("../assets/home.png") left top/ 670px 280px no-repeat;
}

.select {
  margin-top: 16px;
  width: 670px;
  height: 72px;
  display: flex;
  justify-content: space-between;
  align-items: center;

  div {
    height: 100%;
    line-height: 72px;
    text-align: center;
    flex-shrink: 0;
    flex-grow: 1;
    display: flex;
    align-items: center;
    justify-content: center;

    p {
      margin-right: 10px;
    }

    span {
      width: 0;
      height: 0;
      border-left: 10px solid transparent;
      border-right: 10px solid transparent;
      border-top: 10px solid #000;
    }
  }
}

.list {
  margin-top: 16px;

  .item {
    margin-top: 16px;
    width: 670px;
    height: 180px;
    border-radius: 24px;
    background-color: white;
    padding: 16px;
    box-sizing: border-box;
    display: flex;
    justify-content: space-between;

    .img {
      width: 196px;
      height: 148px;
      border-radius: 16px;
      overflow: hidden;
      flex-shrink: 0;
      position: relative;

      div {
        width: 196px;
        height: 148px;
        text-align: center;
        line-height: 148px;

        &.active1 {
          background: url("../assets/active1.png") center/100% 100% no-repeat;
          color: #e2624e;
        }

        &.active2 {
          color: #415fb5;
          background: url("../assets/active2.png") center/100% 100% no-repeat;
        }

        &.active3 {
          color: #f78f2d;
          background: url("../assets/active3.png") center/100% 100% no-repeat;
        }
      }

      span {
        position: absolute;
        left: 8px;
        bottom: 8px;
        width: 90px;
        height: 40px;
        border-radius: 8px;
        color: white;
        font-size: 22px;
        text-align: center;
        line-height: 40px;
        z-index: 9;

        &.active1 {
          background: #415fb5;
        }

        &.active2 {
          background: #e2624e;
        }

        &.active3 {
          background: #999999;
        }
      }
    }

    .info {
      flex-grow: 1;
      margin-left: 16px;

      .title {
        font-size: 32px;
        line-height: 48px;
        color: #3d3d3d;
        font-weight: 600;
        width: 426px;
        height: 96px;
      }

      .more {
        font-size: 24px;
        line-height: 34px;
        color: #999999;
      }
    }
  }
}
.without {
  display: flex;
  align-items: center;
  margin-top: 50px;
  justify-content: space-between;
  span {
    display: inline-block;
    width: 239px;
    height: 2px;
    background: #c5c5c5;
  }
  p {
    font-size: 24px;
    color: #c5c5c5;
  }
}
p {
  display: inline;
}

.ul {
  position: fixed;
  left: 0;
  bottom: 0;
  right: 0;
  width: 100vw;
  height: 100vh;
  box-sizing: border-box;
  background: rgba(0, 0, 0, 0.4);
  overflow: hidden;
  z-index: 99999;

  .wrap {
    position: relative;
    height: 100%;

    ul {
      position: absolute;
      background-color: white;
      width: 100vw;
      max-height: 700px;
      overflow-y: scroll;
      box-sizing: border-box;
      bottom: 0;
      left: 0;

      li {
        padding: 40px 40px;
        font-size: 32px;
        line-height: 40px;
        border: 2px solid rgba(0, 0, 0, 0.1);
        border-left: none;
        border-right: none;
        box-sizing: border-box;
        text-align: center;
        background-color: white;
      }
    }
  }
}
</style>
