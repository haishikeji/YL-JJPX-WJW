<script setup lang="ts">
import {  onMounted, ref, provide, defineComponent } from 'vue'
import type { InjectionKey } from 'vue'


import { RouterView } from 'vue-router'
import diaglog from './components/dialog.vue'

const mask  = ref<InstanceType<typeof diaglog> | null>(null)

function cancel(fn: ()=>void){
  fn();
}   
function confirm(fn: ()=>void){
  fn()
}
interface Obj {
  showMask: boolean;
  msg: string;
  cancel: string;
  confirm: string;
  delay: string;
  onCancel: ()=> void,
  onConfirm: ()=> void
}
// const showmask = Symbol() as InjectionKey<string>;
function isShow(){
  mask.value?.isShow();
} 
function isHide(){
  mask.value?.isHide();
}
function setData(msg:Obj){
  mask.value?.setData(msg)
}

provide('showmask' , {
  isShow,
  isHide,
  setData,
})


</script>

<template>
  <diaglog @onCancel="cancel" @onConfirm="confirm" ref="mask" />
  <RouterView />
</template>

<style lang="less" >
@import './assets/font.css';
@import './assets//layout.css';
@import './assets/rest.css';
@import './assets/color.css';
.page{
  width: 100vw;
  min-height: 100vh;
  padding: 20px;
  box-sizing: border-box;
  overflow: hidden;
}

</style>
