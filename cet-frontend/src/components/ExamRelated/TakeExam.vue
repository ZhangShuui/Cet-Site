<script setup>

import {onMounted, reactive} from "vue";
import {post} from "@/net";

const form_ans = reactive({
  exam_id: -1,
  user_id: -1,
  stu_choiceW1: '',
  stu_choiceW2: '',
  stu_choiceW3: '',
  stu_choiceW4: '',
  stu_choiceW5: '',
  stu_choiceW6: '',
  stu_choiceW7: '',
  stu_choiceW8: '',
  stu_choiceW9: '',
  stu_choiceW10: '',
  translationW: '',
  writingW: '',
})

const form_paper = reactive({
  test_id: -1,
  choiceQ1: '',
  choiceW1: '',
  choiceQ2: '',
  choiceW2: '',
  choiceQ3: '',
  choiceW3: '',
  choiceQ4: '',
  choiceW4: '',
  choiceQ5: '',
  choiceW5: '',
  readingQ1: '',
  readingQ2: '',
  choiceQ6: '',
  choiceW6: '',
  choiceQ7: '',
  choiceW7: '',
  choiceQ8: '',
  choiceW8: '',
  choiceQ9: '',
  choiceW9: '',
  choiceQ10: '',
  choiceW10: '',
  translationQ: '',
  writingQ: '',
})

const submitAns = () => {
  console.log("点击了提交")
}

onMounted(()=> {
  post()
})

</script>

<template onload="submitAns">
  <div>
    <el-form :model="form_ans" label-width="120px">
      <el-form-item>

      </el-form-item>
    </el-form>
    <el-button type="primary" @click="submitAns">提交</el-button>
  </div>
</template>


<style scoped>

</style>


<!--这个页面都需要哪些功能？-->
<!--最重要的是答题，答题需要先获取试卷-->
<!--所以1. 获取试卷-->
<!--2.接着，需要将试卷展现出来，包括题目，选项，主观题的答题区域-->
<!--3.需要一个变量存储学生的作答情况-->
<!--4.计时功能，需要计算剩余考试时间，到时间强制提交-->
<!--5.提交做答情况-->
<!--6.离开考试-->


