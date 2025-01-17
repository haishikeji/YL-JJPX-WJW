<script setup lang="ts">
import {onMounted , ref, inject} from 'vue';
import { RouterLink, useRouter} from  'vue-router';
import {_getTaskInfo, _getTask } from '../http/api';
import { getCZTInfo } from '@/assets';
const userouter = useRouter();
const taskId = ref('');
const type = ref();
const info = ref({
    nickName: '',
    phone: '',
    coName: ''
})
const score:any = ref({});
let showMask = inject('showmask') as any;
onMounted(() => {
  let query = userouter.currentRoute.value.query;
  if(!query.id)return userouter.push('/login')
  taskId.value = query.id as string;
  taskId.value = userouter.currentRoute.value.query.id as string;
  type.value = userouter.currentRoute.value.query.type || '';
    info.value  = getCZTInfo();
    if(type && type.value > 0){
        getTask()
    }else{
        getInfo();
    }

}) 
function getTask(){
    _getTask(taskId.value).then((res:any)=>{
        if(res.code==200){
            score.value = res.data;

        }else{
            showMask.setData({
                showMask: true,
                msg: res.msg,
                cancel: "",
                confirm: "确认",
                delay: '',
                onCancel: ()=>{},
                onConfirm: ()=>{console.log(111)}
            })
        }
    })
}
function getInfo(){
    let data = {
        nickName: info.value.nickName,
        phone: info.value.phone,
        taskId: taskId.value,
        maskCode: '',
        coName: info.value.coName
    }
    _getTaskInfo(data).then((res:any)=>{
        if(res.code==200){
            score.value = res.data;

        }else{
            showMask.setData({
                showMask: true,
                msg: res.msg,
                cancel: "",
                confirm: "确认",
                delay: '',
                onCancel: ()=>{},
                onConfirm: ()=>{console.log(111)}
            })
        }
    })
}
function resetTask(){
    userouter.replace('/list?id='+taskId.value+'&type='+type.value+'&retry=1')
}
</script>
<template>
    <div class="page bg_gray">
        <div v-if="score.taskId" class="content">
            <div @click="userouter.push('/ana?type='+type+'&id='+taskId)"  class="log">考试记录</div>
            <img v-if="score&&score.isPass == 1" src="@/assets/icon/qualified@2x.png" alt="">
            <img v-else src="@/assets/icon/unqualified@2x.png" alt="">
            <p v-if="score.isPass == 1" class="rate" :class="score.isPass == 1?'success': 'fail'">考试通过</p>
            <p v-if="score.isPass == 0" class="rate" :class="score.isPass == 1?'success': 'fail'">考试不通过</p>
            <div class="line"></div>
            <div class="msg">
                <div class="l">
                    <p class="t">考生姓名</p><p>{{ score.nickName }}</p>
                </div>
                <!-- <div class="l">
                    <p class="t">考试用时</p><p>233333</p>
                </div> -->
                <div v-if="score.isScore" class="l">
                    <p class="t">考试分数</p><p class="point"  :class="score.score >= score.passScore?'success': 'fail'">{{score.score}}分</p>
                </div>
                <div class="l">
                    <p class="t">错题数量</p><p><span>{{ score.wrongNum }}</span>/{{ score.qnum  }}</p>
                </div>
            </div>
            <div @click="userouter.push('/alist?type='+type+'&id='+score.taskLogId)"  class="ana">题目解析</div>
            <div v-if="score.isPass == 0 && score.retryStatus==1"  @click="resetTask" class="start bt_blue f16">
                重新考试
            </div>
        </div>
    </div>
</template>
<style lang="less" scoped>
.page {

    .content {
        padding: 20px;
        width: 670px;
        border-radius: 24px;
        margin: auto;
        background: white;
        padding: 40px 0 20px;
        box-sizing: border-box;
        text-align: center;
        position: relative;
        .log{
            font-size: 28px;
            color: #415FB5;
            text-align: right;
            padding: 0 40px;
        }
        img{
            width: 80px;
            height: 80px;
            
        }
        .rate{
            font-size: 56px;
            font-weight: 500;
            line-height: 88px;
            margin-top: 15px;
            &.success{
                color: #41B575;
            }
            &.fail{
                color: #E2624E;
            }
        }
        .line{
            height: 0;
            width: 590px;
            border-top: 2px dashed #C5C5C5;
            margin: 56px;
        }
        .msg{
            padding: 0 40px;
            .l{
                margin-bottom: 12px;
                display: flex;
                align-items: center;
                justify-content: space-between;
                .t{
                    
                    color: #999999
                }
                p{
                    font-size: 28px;
                    color: #3D3D3D;
                    span{
                        color: #E2624E;
                    }
                }
                .point{
                    &.success{
                        color: #41B575;
                    }
                    &.fail{
                        color: #E2624E;
                    }
                }
            }
        }
        .ana{
            width: 590px;
            height: 104px;
            color: #415FB5;
            border-radius: 16px;
            font-size: 32px;
            line-height: 104px;
            margin: 80px auto 0;
            border: 2px solid #415FB5;
        }
        .start{
            width: 590px;
            height: 104px;
            border-radius: 16px;
            font-size: 32px;
            color: white;
            text-align: center;
            line-height: 104px;
            margin: 24px auto;
        }
    }
    
}
</style>