<script setup lang="ts">
import { ref, inject, reactive, onMounted } from 'vue'
import { _getCoList, _sign, _siginInfo, _sendCode, _checkPhone } from '../http/api'
import { useRouter } from 'vue-router';
import { setCZTInfo } from '@/assets';
import iconth from '../components/icon_th.vue'
import search from '../components/search_icon.vue'
import md5 from 'js-md5'
const disabled = ref(true)
const unSelect = ref(true)
const isCheck = ref(false)
const info: any = ref({})
const showSelect = ref(false)
const countdown = ref(0);
const msg = reactive({
  phone: '',
  name: '',
  code: '',
  coName: ''
})
const taskId = ref('');
const userouter = useRouter();
const list: any = ref({});
const list2: any = ref({});
const txt = ref('')
let showMask = inject('showmask') as any;
onMounted(() => {
  let query = userouter.currentRoute.value.query;
  if (!query.id) return userouter.push('/login')
  taskId.value = query.id as string;

  _siginInfo(query.id as string, '3').then((res: any) => {
    if (res.code==200) {
      info.value = res.data;
      if(res.data.taskStatus ==3){
        showMask.setData({
          showMask: true,
          msg: '考试已结束',
          cancel: "",
          confirm: "确认",
          delay: "",
          onCancel: () => { },
          onConfirm: () => { },
        });
      }
    } else {
      showMask.setData({
        showMask: true,
        msg: res.msg,
        cancel: "",
        confirm: "确认",
        delay: "",
        onCancel: () => { },
        onConfirm: () => { },
      });
    }
  })

  _getCoList().then((res: any) => {
    if (res.code==200) {
      list.value = res.data;
      list2.value = [...res.data]
    } else {
      showMask.setData({
        showMask: true,
        msg: res.msg,
        cancel: "",
        confirm: "确认",
        delay: "",
        onCancel: () => { },
        onConfirm: () => { },
      });
    }
  })
})
// method 
function countdownSubtract() {
  if (countdown.value > 0) {
    setTimeout(() => {
      countdown.value -= 1;
      countdownSubtract()
    }, 1000)
  } else {
    countdown.value -= 0;
  }
}
function sendCode() {
  if (countdown.value > 0) return
  if (msg.phone.length != 11) {
    return showMask.setData({
      showMask: true,
      msg: '请输入正确的手机号',
      cancel: "",
      confirm: "确认",
      delay: "",
      onCancel: () => { },
      onConfirm: () => { },
    });
  }
  _sendCode(msg.phone, md5(msg.phone + 'wjwtest')).then((res: any) => {
    if (res.code!==200) {
      showMask.setData({
        showMask: true,
        msg: res.msg,
        cancel: "",
        confirm: "确认",
        delay: "",
        onCancel: () => { },
        onConfirm: () => { },
      });
    } else {
      countdown.value = 60;
      countdownSubtract();
    }
  })
}
function goSign() {
  if(info.value.taskStatus ==3){
       return showMask.setData({
          showMask: true,
          msg: '考试已结束',
          cancel: "",
          confirm: "确认",
          delay: "",
          onCancel: () => { },
          onConfirm: () => { },
        });
      }
  if(msg.phone.length!=11){
    return showMask.setData({
          showMask: true,
          msg: '请输入正确手机号',
          cancel: "",
          confirm: "确认",
          delay: "",
          onCancel: () => { },
          onConfirm: () => { },
        });
  }
  if (!isCheck.value) {
    _checkPhone(msg.phone, taskId.value, md5(msg.phone + 'wjwtest')).then((res: any) => {
      if (res.code==200) {
        msg.coName = res.data.coName;
        msg.name = res.data.nickName;
        isCheck.value = true
        unSelect.value = false;
      } else {
        showMask.setData({
          showMask: true,
          msg: '验证失败，请输入您的身份信息',
          cancel: "",
          confirm: "确认",
          delay: '',
          onCancel: () => { },
          onConfirm: () => { isCheck.value = true }
        })
      }
    })
    return
  }
  let showText = '';
  if (!msg.phone) {
    showText = '手机号不能为空'
  } else if (!msg.name) {
    showText = '姓名不能为空'
  } else if (!msg.coName) {
    showText = '单位不能为空'
  } else if (!msg.code) (
    showText = '验证码不能为空'
  )
  if (!msg.phone || !msg.name || !msg.coName || !msg.code) return showMask.setData({
    showMask: true,
    msg: showText,
    cancel: "",
    confirm: "确认",
    delay: '',
    onCancel: () => { },
    onConfirm: () => { }
  })
  if (msg.phone.length != 11) return showMask.setData({
    showMask: true,
    msg: "手机号码不正确",
    cancel: "",
    confirm: "确认",
    delay: '',
    onCancel: () => { },
    onConfirm: () => { }
  })
  _sign({
    "coName": msg.coName,
    "maskCode": msg.code,
    "nickName": msg.name,
    "phone": msg.phone,
    "taskId": taskId.value,
    'sign': md5(msg.phone + 'wjwtest')
  }).then((res: any) => {
    if (res.code==200) {
      setCZTInfo({
        _c_z_t: 'czt',
        nickName: msg.name,
        phone: msg.phone,
        coName: msg.coName
      })
      if(res.data.newTest>0){
        userouter.push('/cdes?id=' + taskId.value)
      }else{
        //userouter.push('/score?id='+taskId.value)
        userouter.push('/ana?id='+taskId.value+'&type=')
      }
      
      
    } else {
      return showMask.setData({
        showMask: true,
        msg: res.msg,
        cancel: "",
        confirm: "确认",
        delay: '',
        onCancel: () => { },
        onConfirm: () => { }
      })
    }
  })
}
function onsearch() {
  if (!txt.value) return list.value = list2.value
  let arr = list.value.filter((item: any) => {
    return item.coName.indexOf(txt.value) > -1
  })
  if (arr.length > 0) {
    list.value = arr;
  } else {
    list.value = [...list2.value]
  }
}
</script>
<template>
  <div class="page ">
    <div class="content">
      <div  class="title">
        <!-- <p>{{ info.taskName }}</p> -->
        <p class="p" v-show="!isCheck">救在身边</p>
        <p v-show="!isCheck">急救知识培训</p>
      </div>
      <div class="sign_msg">
        <div v-show="isCheck" class="msg">
          <div>你的姓名</div>
          <input v-model="msg.name" type="text" maxlength="11" placeholder="请输入你的姓名">
        </div>
        <div v-show="isCheck" @click="unSelect?showSelect = !showSelect:false" class="msg">
          <div>选择单位</div>
          <!-- <select name="" id="">
              <option v-for="(item,index)  in list" :key="index" :value="item.id">{{ item.coName }}</option>
          </select> -->
          <input :value="msg.coName" type="text" maxlength="0" :disabled="disabled" placeholder="请选择你的单位">

          <div v-show="unSelect" class="icon_th">
            <iconth />
          </div>
        </div>
        <div class="msg">
          <div>手机号码</div>
          <input v-model="msg.phone" type="tel" pattern="[0-9]" maxlength="11"
            oninput="value=value.replace(/[\u4E00-\u9FA5]/g,'')" placeholder="请输入手机号码">
        </div>
        <div v-show="isCheck" class="msg">
          <div>验证码 </div>
          <input v-model="msg.code" type="number" maxlength="6" placeholder="请输验证码">
          <span @click="sendCode" :class="countdown > 0 && 'fgray'">{{ countdown > 0 ? countdown : '获取验证码' }}</span>
        </div>
      </div>
      <div @click="goSign" class="start bt_blue f16">
        {{ isCheck ? '签到考试' : '身份验证' }}
      </div>
    </div>

    <div v-show="showSelect" class="ul">

      <div class="wrap">

        <ul>
          <div class="search sticky">
            <div>
              <search class="search_icon" />
              <input placeholder="请输入关键词" type="search" autocomplete="off" @input="onsearch" v-model="txt" maxlength="20">
            </div>
          </div>
          <li v-for="(item, index)  in list" :key="index" @click.stop="(msg.coName = item.coName) && (showSelect = !showSelect)">
            {{ item.coName }}
          </li>
        </ul>
      </div>
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
    background: url('../assets/bg1.png') center center/670px 1080px no-repeat;

    .title {
      padding: 380px 20px 0;
      width: 100%;
      box-sizing: border-box;
      font-size: 40px;
      line-height: 64px;
      text-align: center;
      overflow: hidden;
      color: #415FB5;
      font-weight: 600;
      .p{
        padding-top: 120px;
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
        border: 2px solid #C5C5C5;
        border-radius: 16px;
        margin-bottom: 16px;
        padding: 12px 16px;
        display: flex;
        align-items: center;
        background-color: white;

        div {
          width: 130px;
          font-size: 28px;
          flex-shrink: 0;
        }

        input,
        select {
          min-width: 226px;
          height: 48px;
          flex-grow: 1;
          margin: 0 12px;
          font-size: 28px;
          background: transparent;

          &::placeholder {
            color: #C5C5C5;
            ;
          }

          &:disabled {
            background: transparent;
          }
        }

        .icon_th {
          transform: rotate(90deg);
          font-size: 24px;
          height: 48px;
          width: 48px;
        }

        select {
          border: none;
          outline: none;

          &:focus {
            border: none;
            outline: none;
          }
        }

        span {
          flex-shrink: 0;
          color: #415FB5;

          &.fgray {
            color: #C5C5C5;
          }
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
          background-color: white;
        }
      }
    }


  }

  .search {

    width: 100vw;
    padding: 20px 40px;


    box-sizing: border-box;
    overflow: hidden;

    div {
      display: flex;
      align-items: center;
      justify-content: center;
      background: #F6F6F6;
      padding: 0 20px;
      height: 80px;
      border-radius: 16px;
    }

    .search_icon {
      width: 32px;
      height: 32px;
      flex-shrink: 0;
      margin-right: 20px;
      color: #B9B4B4;
    }

    input {
      flex: 1;
      color: #150404;
      font-size: 28px;
      background: transparent;

      &::placeholder {
        color: #B9B4B4;
      }
    }
  }

}</style>