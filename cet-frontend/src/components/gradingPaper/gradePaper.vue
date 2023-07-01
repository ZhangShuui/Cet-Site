<script setup>

import {onMounted, reactive} from "vue";
import { ref } from 'vue'
import router from "@/router";
import {get, post} from "@/net";
import {ElMessage} from "element-plus";

const num_translation = ref(0)
const num_writing = ref(0)

const handleChange = (value) => {
  console.log(value)
}

const form = reactive({
  translationQ:'这是翻译题题干',
  translationW:'这是考生的翻译题答案',
  translationScore:0,
  writingQ:'这是写作题题干',
  writingW:'这是考生的写作题答案',
  writingScore:0,
  user_id:-1,
  exam_id:-1,
})

onMounted(() => {
  //get,从后端获取stu_id和exam_id
  //post,从soft_paper里查出这张试卷,为表单中的Q赋值
  //post,从soft_answer里查出这个考生的答卷,为表单中的W赋值
  get('/api/examinee/get-answer-id', (message) => {
    form.user_id = message.user_id
    form.exam_id = message.exam_id
    post('/api/examinee/get-paper', {
      user_id: form.user_id,
      exam_id: form.exam_id,

    }, (paper_msg) => {
      form.translationQ = paper_msg.translationQ
      form.writingQ = paper_msg.writingQ
      console.log(paper_msg)
      get('/api/examinee/getCurrentAns', (ans_msg) => {
        form.translationW = ans_msg.translationW
        form.writingW = ans_msg.writingW
        ElMessage.success("获取答卷成功")
      })
    }, () => {
      console.log()
      ElMessage.error("获取答卷失败")
    })
  }, () => {
    ElMessage.error("获取学生信息失败")
  })
})

const SaveAndSubmit = () => {
  form.translationScore = num_translation.value
  form.writingScore = num_writing.value
  //post


  console.log(form)
  goback()
}

const goback = () => {
  router.push('/teacher/index/answerList')
}

</script>


<template>


  <div style="font-size: 25px; font-weight: bold;margin-left: 80px">
    Translation
  </div>
  <div style=" line-height: 20px;font-size: 17px;margin-top: 10px;margin-left: 90px;margin-right: 150px">{{form.translationQ}}</div>
  <div>
    <el-card class="box-card">
      <template #header>
        <div class="card-header" align="center">
          <span style="font-size: 20px; font-weight: bold">Answer</span>
        </div>
      </template>
      <div style="min-height: 50px">{{form.translationW}}</div>
    </el-card>
  </div>

  <el-input-number v-model="num_translation" :min="1" :max="100" style="margin-left: 80px;margin-top: 10px" @change="handleChange" />

  <el-divider style="visibility: hidden"/>
  <div style="font-size: 25px; font-weight: bold; margin-top: 10px;margin-left: 85px">
    Writing
  </div>
  <div style=" line-height: 20px;font-size: 17px;margin-top: 10px;margin-left: 90px;margin-right: 150px">{{form.writingQ}}</div>
  <div>
    <el-card class="box-card">
      <template #header>
        <div class="card-header" align="center">
          <span style="font-size: 20px; font-weight: bold">Answer</span>
        </div>
      </template>
      <div style="min-height: 50px">{{form.writingW}}</div>
    </el-card>
  </div>

  <el-input-number v-model="num_writing" :min="1" :max="100" style="margin-left: 80px;margin-top: 10px" @change="handleChange" />

  <el-divider style="visibility: hidden"/>

  <div style="margin-left: 90px">
    <el-button type="success" @click="SaveAndSubmit" plain>保存并提交</el-button><br>
    <el-button type="warning" @click="goback" style="margin-top: 10px" plain>退出阅卷</el-button>

  </div>
</template>

<style scoped>
.text {
  font-size: 14px;
}

.item {
  padding: 18px 0;
}

.box-card {
  margin-top: 10px;
  width: 80%;
  margin-left: 80px;
}
</style>