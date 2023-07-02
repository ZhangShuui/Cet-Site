<script setup >
import {reactive} from "vue";
import {get, post} from "@/net";
import {ElMessage} from "element-plus";
import {useStore} from "@/stores";
import router from "@/router";
import {ref } from 'vue'
import {Stamp} from "@element-plus/icons-vue";

const value2 = ref(true)
const store = useStore()

const form = reactive({
  id: -1,
  email: '',
  username: '',
  exam_id: -1,
})

const GoBack = () => {
  router.push('/index')
  console.log(router.currentRoute)
}

const VerifyMe = () => {
  get('/api/user/me', (message) => {
    form.id = message.id
    form.email = message.email
    form.username = message.username
    get('/api/examinee/get-act-exam', (message) => {
      form.exam_id = message.exam_id
      post('/api/examinee/check-eligibility', {
        user_id: form.id,
        exam_id: form.exam_id,
      }, (message) => {
        ElMessage.success("检测到您具备考试资格,进入考试")
        //在这里跳转
        router.push('/index/takeexam')
      },()=> {
        console.log(form)
        ElMessage.error("没有检测到您具备考试资格")
      })
    },() => {
      ElMessage.error("当前无考试")
    })
  }, () => {
    ElMessage.error("获取用户信息出错")
  })
}

</script>

<template>
  <el-card class="box-card">
    <template #header>
      <div class="card-header">
        <span style="font-size: 30px">资格信息确认</span>
      </div>
    </template>
    <el-card style="background-color: lightblue" class="box-card">
      <div style="color: red;font-weight: bold">提示：</div>
      <div style="margin-top: 3px">
        1、如果发现学籍信息有误，请勿继续报考，尽快联系学校相关负责老师进行处理。
      </div>
      <div style="margin-top: 3px">
        2、资格科目是综合当前考次的设置信息而生成的，如有异议，请联系学校相关负责老师。
      </div>
      <div style="margin-top: 3px">
        3、资格科目为无的考生无法继续报名。
      </div>
      <div style="margin-top: 3px; color: red; font-weight: bold">
        4、如暂时无法报考口试，可能是由于机位已满或考点暂未开放，完成笔试报考及缴费后，可随时登录系统查看可否进行口试报考。
      </div>
    </el-card>
    <el-card style="margin-top: 10px" class="box-card">
      <div>姓名：{{store.auth.user.username}}</div>
      <div style="margin-top: 3px">邮箱：{{store.auth.user.email}}</div>
      <div style="margin-top: 3px">考生编号：{{store.auth.user.id}}</div>
    </el-card>
<!--    <div style="margin-top: 3px">-->
<!--      <el-switch-->
<!--          v-model="value2"-->
<!--          style="&#45;&#45;el-switch-on-color: #13ce66; &#45;&#45;el-switch-off-color: #ff4949;"-->
<!--          active-text="我已检查并确认资格信息正确"-->
<!--      />-->

<!--    </div>-->
    <div style="margin-top: 10px"></div>
    <div align="center">
      <el-button style="background-color: deepskyblue;color: white" @click="GoBack">返回首页</el-button>
      <el-button style="background-color: deepskyblue;color: white" @click="VerifyMe">进入考试</el-button>
    </div>


  </el-card>
  <div style="margin-top: 30px;font-size: 10px;font-weight: bold">©2023 教育部教育考试院 版权所有</div>

</template>


<style scoped>

</style>

