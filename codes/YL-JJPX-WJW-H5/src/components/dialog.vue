<template>
  <div>
    <Teleport to="body">
      <div v-show="data.showMask" class="mask">
        <div class="content">
          <div class="msg">{{ data.msg || "请确认" }}</div>
          <div v-show="data.confirm" class="action">
            <div v-if="data.cancel" @click="cancel" class="cancel">{{ data.cancel }}</div>
            <div v-if="data.confirm" @click="confirm" class="confirm">
              {{ data.confirm }}
            </div>
          </div>
        </div>
      </div>
    </Teleport>
  </div>
</template>

<script lang="ts" setup>
import { ref } from "vue";

let data = ref({
    showMask: false,
  msg: "",
  cancel: "",
  confirm: "",
  delay: '',
  onCancel: ()=>{},
  onConfirm: ()=>{}
});
// methods
interface Obj {
  showMask: boolean;
  msg: string;
  cancel: string;
  confirm: string;
  delay: string;
  onCancel: ()=> void,
  onConfirm: ()=> void
}
function setData(obj:Obj){
    data.value = obj;
}
function cancel(){
    isHide();
    data.value.onCancel()
}
function confirm(){
    isHide();
    data.value.onConfirm()
}
function isShow() {
  data.value.showMask = true;
  if(Number(data.value.delay) > 0)(
    setTimeout(()=>{
        data.value.showMask = false;
    },Number(data.value.delay))
  )
}
function isHide() {
    data.value.showMask = false; 
}
defineExpose({
  setData,
  isShow,
  isHide,
});
</script>

<style lang="less" scoped>
.mask {
  display: flex;
  justify-content: center;
  align-items: center;
  text-align: center;
  .content {
    background-color: white;
    width: fit-content;
    max-height: 600px;
    padding: 20px;
    border-radius: 10px;
    overflow: hidden;
    .msg {
      width: 540px;
      font-size: 32px;
      line-height: 48px;
      padding: 40px;
      box-sizing: border-box;
      color: #000000;
      word-wrap:break-word;
      word-break:break-all;
    }
    .action {
      display: flex;
      justify-content: space-between;
      align-items: center;
      width: 540px;
      height: 88px;
      font-size: 32px;
      line-height: 88px;
      color: #007aff;
      border-top: 1px solid rgba(60, 60, 67, 0.36);
      div {
        width: 49%;
        flex: 1;
        &:nth-child(2) {
          border-left: 1px solid rgba(60, 60, 67, 0.36);
        }
      }
    }
  }
}
</style>
