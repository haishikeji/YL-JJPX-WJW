<script setup lang="ts">
import { inject } from 'vue';
import foot from '../components/footer.vue'
import iconth from '../components/icon_th.vue'
import icona from '../components/icon_a.vue'
import icont from '../components/icon_t.vue'
import { _exitLogin } from '../http/api'
import { setCZTInfo } from'../assets/index'
import { useRouter } from 'vue-router';
let showMask = inject('showmask') as any;
import { _homeTask } from '../http/api'
import { reactive, ref, onMounted } from 'vue';
const data:any = reactive({
    info: {}
})
const userouter = useRouter();
onMounted(()=>{
    _homeTask({
        year: '',
        taskStatus: ''
    }).then((res: any) => {
        data.info = res.data
        setCZTInfo({
            nickName: res.data.nickName,
            phone: res.data.phone
        })
    })
})

// method 
function exit() {
    showMask.setData({
        showMask: true,
        msg: "确认要退出吗？",
        cancel: "取消",
        confirm: "退出",
        delay: '',
        onCancel: () => { },
        onConfirm: () => { 
            _exitLogin().then((res:any)=>{
                if(res.code){
                    setCZTInfo({
                        _c_z_t: ' ',
                        nickName: ' ',
                        phone: ' ',
                        coName: ' '
                    })
                    userouter.replace('/login')
                }else {

                }

            })
         }
    })
}
</script>
<template>
    <div class="page bg_gray">
        <header>
            <p>你好，{{ data.info.nickName }}</p>

            <section>

                <!-- <div class="msg">
                    <div class="title">
                        <icont class="icon" />
                        <div>
                            每日答题
                        </div>
                    </div>
                    <p>{{data.info.testDailySuccessNum }}/{{ data.info.dailyQNum   }}</p>
                </div> -->
                <!-- <div class="msg">
                    <div class="title">
                        <icona class="icon" />
                        <div>
                            年度考试
                        </div>
                    </div>
                    <p>{{data.info.testAnnualSuccessNum  }}/{{ data.info.annualQNum  }}</p>
                </div> -->

            </section>
        </header>
        <main>
            <RouterLink to="pwd" class="action_item">
                <p>修改密码</p>
                <iconth />
            </RouterLink>
            <div @click="exit" class="action_item exit">退出登录</div>
        </main>
        <foot />
    </div>
</template>

<style lang="less" scoped>
header {
    width: 670px;
    margin: auto;
    padding: 40px;
    box-sizing: border-box;
    color: white;
    font-size: 40px;
    border-radius: 24px;
    background: #415FB5;
}

section {
    display: flex;
    flex-flow: row nowrap;
    justify-content: space-between;
    align-items: center;
    .msg{
        width: 283px;
        height: 144px;
        padding: 24px 32px;
        margin-top: 64px;
        font-size: 28px;
        box-sizing: border-box;
        border-radius: 16px;
        background: rgba(255, 255, 255, 0.1);
        .title{
            display: flex;
            margin-bottom: 8px;
            align-items: center;
            font-size: 28px;
            color: rgba(255, 255, 255, 0.6);
            .icon{
                width: 24px;
                height: 24px;
                margin-right: 10px;
            }
            
            
        }
        p{
            font-size: 32px;
            line-height: 48px;
            
        }
    }
}


.action_item {
    display: flex;
    flex-flow: row nowrap;
    align-items: center;
    justify-content: space-between;
    height: 112px;
    width: 670px;
    padding: 16px 32px;
    box-sizing: border-box;
    margin: auto;
    margin-top: 24px;
    font-size: 32px;
    border-radius: 24px;
    background: white;

    &.exit {
        color: #E2624E;
    }
}
</style>