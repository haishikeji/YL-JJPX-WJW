<script setup lang="ts">
import { _login } from "../http/api";
import { ref, inject, reactive, onMounted } from "vue";
import { useRouter } from "vue-router";
import { setCZTInfo } from "@/assets/index";
import { _sendCode } from "../http/api";
import md5 from "js-md5";
let login_type = ref(0);
let isShowpwd = ref(0);
const msg = reactive({
  phone: "",
  name: "",
  code: "",
  userName: "",
  password: "",
});
const countdown = ref(0);
let isShowLogin = () => {
  // debugger
  if (login_type.value == 0 && msg.userName && msg.password) return true;
  // if(login_type.value==1 && msg.phone&& msg.name && msg.code) return true
  if (login_type.value == 1 && msg.phone && msg.name) return true;
  return false;
};
let showMask = inject("showmask") as any;
const userouter = useRouter();
// method
function countdownSubtract() {
  if (countdown.value > 0) {
    setTimeout(() => {
      countdown.value -= 1;
      countdownSubtract();
    }, 1000);
  } else {
    countdown.value -= 0;
  }
}
function sendCode() {
  if (countdown.value > 0) return;
  if (msg.phone.length != 11) {
    return showMask.setData({
      showMask: true,
      msg: "请输入正确的手机号",
      cancel: "",
      confirm: "确认",
      delay: "",
      onCancel: () => {},
      onConfirm: () => {},
    });
  }
  _sendCode(msg.phone, md5(msg.phone + "wjwtest")).then((res: any) => {
    if (res.code !== 200) {
      showMask.setData({
        showMask: true,
        msg: res.msg,
        cancel: "",
        confirm: "确认",
        delay: "",
        onCancel: () => {},
        onConfirm: () => {},
      });
    } else {
      countdown.value = 60;
      countdownSubtract();
    }
  });
}
function resetPwd() {
  showMask.setData({
    showMask: true,
    msg: "请联系管理员重置密码",
    cancel: "",
    confirm: "我知道了",
    delay: "",
    onCancel: () => {},
    onConfirm: () => {},
  });
}
// function deBounce<T>(fn: T, delay: number): () => void {
//     let result:any;
//     console.log(111)
//     console.log(fn)
//     return function(): void {

//         const args: any[] = Array.prototype.map.call(arguments, val => val);
//       if (deBounce.id) {
//         clearTimeout(deBounce.id);
//       }
//       deBounce.id = setTimeout(() => {
//         if(typeof fn === 'function'){
//             result =  fn.apply(null, args)
//         }
//         return result;
//       }, 2000);
//     };
// }
function login() {
  let data = {
    loginType: 0,
    maskCode: "",
    password: "",
    sign: "",
    userName: "",
  };
  if (login_type.value == 0) {
    // msg.userName.length!=11
    if (msg.userName.length != 11 || !msg.password) {
      return showMask.setData({
        showMask: true,
        msg: "请输入帐号密码",
        cancel: "",
        confirm: "确定",
        delay: "",
        onCancel: () => {},
        onConfirm: () => {},
      });
    } else {
      data.loginType = 1;
      data.password = msg.password;
      data.userName = msg.userName;
      data.sign = md5(msg.userName + "wjwtest");
      data.maskCode = "";
    }
  } else {
    // !msg.name||msg.phone.length!=11||!msg.code
    if (!msg.name || msg.phone.length != 11) {
      return showMask.setData({
        showMask: true,
        msg: "请输入姓名手机号和验证码",
        cancel: "",
        confirm: "确定",
        delay: "",
        onCancel: () => {},
        onConfirm: () => {},
      });
    } else {
      data.loginType = 2;
      data.password = "";
      data.userName = msg.phone;
      data.sign = md5(msg.userName + "wjwtest");
      data.maskCode = msg.code;
    }
  }

  _login(data).then((res: any) => {
    if (res.code == 200) {
      setCZTInfo({
        _c_z_t: res.token,
        nickName: msg.name,
        phone: msg.userName || msg.phone,
      });

      userouter.push("/");
    } else {
      showMask.setData({
        showMask: true,
        msg: res.msg,
        cancel: "",
        confirm: "确定",
        delay: "500",
        onCancel: () => {},
        onConfirm: () => {},
      });
    }
  });
}
</script>
<template>
  <div class="page bg_gray">
    <div class="content">
      <div class="title">
        <p>急救培训管理系统</p>
      </div>

      <div class="login_type">
        <div :class="login_type == 0 && 'active'" @click="login_type = 0">
          密码登录
        </div>
        <!-- <div>|</div>
        <div :class="login_type == 1 && 'active'" @click="login_type = 1">
          验证码登录
        </div> -->
      </div>

      <div>
        <div v-show="login_type === 0">
          <div class="account">
            <input
              type="text"
              maxlength="11"
              v-model="msg.userName"
              placeholder="请输入帐号"
            />
          </div>
          <div class="password">
            <input
              :type="isShowpwd == 0 ? 'password' : 'text'"
              maxlength="11"
              v-model="msg.password"
              placeholder="请输入密码"
            />
            <img
              v-show="isShowpwd == 0"
              @click="isShowpwd = 1"
              src="@/assets/icon/Hidepassword@2x.png"
              alt=""
            />
            <img
              v-show="isShowpwd == 1"
              @click="isShowpwd = 0"
              src="@/assets/icon/Passwordvisible@2x.png"
              alt=""
            />
          </div>
        </div>
        <div v-show="login_type === 1" class="sign_msg">
          <div class="msg">
            <input
              v-model="msg.name"
              type="text"
              maxlength="8"
              placeholder="请输入你的姓名"
            />
          </div>
          <div class="msg">
            <input
              v-model="msg.phone"
              type="tel"
              pattern="[0-9]"
              maxlength="11"
              placeholder="请输入手机号码"
            />
          </div>
          <div class="msg">
            <input
              v-model="msg.code"
              type="number"
              maxlength="6"
              placeholder="请输入验证码"
            />
            <span @click="sendCode" :class="countdown > 0 && 'fgray'">{{
              countdown > 0 ? countdown : "获取验证码"
            }}</span>
          </div>
        </div>
      </div>
      <div
        @click="login"
        class="start bt_blue f16"
        :class="isShowLogin() && 'active'"
      >
        登录
      </div>
      <div @click="resetPwd" class="forget bt_blue f16">忘记密码</div>
    </div>
  </div>
</template>
<style lang="less" scoped>
.page {
  background: white url("../assets/login_img.png") center top/100% 496px
    no-repeat;
  .content {
    padding: 40px;
    width: 670px;
    height: 1080px;
    border-radius: 24px;
    box-sizing: border-box;
    margin: auto;

    .title {
      padding: 40px 20px;
      width: 100%;
      box-sizing: border-box;
      text-align: center;
      overflow: hidden;
      p:nth-child(1) {
        font-size: 36px;
        font-weight: bold;
        line-height: 56px;
        font-weight: 400;
      }
      p:nth-child(2) {
        margin-top: 8px;
        font-size: 48px;
        font-weight: normal;
        line-height: 72px;
        color: #e2624e;
        font-weight: 600;
      }
    }
    .login_type {
      width: 400px;
      height: 88px;
      display: flex;
      align-items: center;
      justify-content: space-between;
      font-size: 32px;
      line-height: 88px;
      color: #999999;
      .active {
        color: #415fb5;
      }
    }
    .account,
    .password {
      margin-top: 20px;
      width: 590px;
      height: 96px;
      border-radius: 16px;
      display: flex;
      flex-direction: row;
      padding: 24px 32px;
      box-sizing: border-box;
      border: 2px solid #c5c5c5;
      input {
        flex: 1;
        font-size: 28px;
        color: #3d3d3d;
        &::placeholder {
          font-size: 28px;
          color: #c5c5c5;
        }
      }
      img {
        width: 48px;
        height: 48px;
        margin-left: 20px;
        flex-shrink: 0;
      }
    }

    .sign_msg {
      padding: 20px 0;
      display: flex;
      flex-flow: column nowrap;
      font-family: 思源黑体;
      font-size: 28px;

      .msg {
        width: 590px;
        height: 96px;
        box-sizing: border-box;
        border: 2px solid #c5c5c5;
        border-radius: 16px;
        margin-bottom: 16px;
        padding: 12px 16px;
        display: flex;
        align-items: center;

        div {
          width: 112px;
          flex-shrink: 0;
        }

        input {
          min-width: 226px;
          height: 48px;
          flex-grow: 1;
          margin: 0 12px;

          &::placeholder {
            color: #c5c5c5;
          }
        }

        span {
          flex-shrink: 0;
          color: #415fb5;
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
      margin-top: 40px;
      background: #999999;
      &.active {
        background-color: #415fb5;
      }
    }
    .forget {
      width: 590px;
      height: 104px;
      font-size: 32px;
      border-radius: 16px;
      color: #999999;
      text-align: center;
      line-height: 104px;
      margin-top: 16px;
      background-color: white;
    }
  }
}
</style>
