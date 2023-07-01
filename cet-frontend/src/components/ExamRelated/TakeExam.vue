<script setup>

import {onMounted, reactive} from "vue";
import {get, post} from "@/net";
import {ElMessage} from "element-plus";
import {useStore} from "@/stores";
import { ref } from 'vue'

const store = useStore()

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
  choiceQ1A:'',
  choiceQ1B:'',
  choiceQ1C:'',
  choiceQ1D:'',
  choiceW1: '',

  choiceQ2: '',
  choiceW2: '',
  choiceQ2A:'',
  choiceQ2B:'',
  choiceQ2C:'',
  choiceQ2D:'',

  choiceQ3: '',
  choiceQ3A:'',
  choiceQ3B:'',
  choiceQ3C:'',
  choiceQ3D:'',
  choiceW3: '',

  choiceQ4: '',
  choiceW4: '',
  choiceQ4A:'',
  choiceQ4B:'',
  choiceQ4C:'',
  choiceQ4D:'',

  choiceQ5: '',
  choiceW5: '',
  choiceQ5A:'',
  choiceQ5B:'',
  choiceQ5C:'',
  choiceQ5D:'',

  readingQ1: '',
  readingQ2: '',
  choiceQ6: '',
  choiceW6: '',
  choiceQ6A:'',
  choiceQ6B:'',
  choiceQ6C:'',
  choiceQ6D:'',

  choiceQ7: '',
  choiceW7: '',
  choiceQ7A:'',
  choiceQ7B:'',
  choiceQ7C:'',
  choiceQ7D:'',

  choiceQ8: '',
  choiceW8: '',
  choiceQ8A:'',
  choiceQ8B:'',
  choiceQ8C:'',
  choiceQ8D:'',

  choiceQ9: '',
  choiceW9: '',
  choiceQ9A:'',
  choiceQ9B:'',
  choiceQ9C:'',
  choiceQ9D:'',

  choiceQ10: '',
  choiceW10: '',
  choiceQ10A:'',
  choiceQ10B:'',
  choiceQ10C:'',
  choiceQ10D:'',

  translationQ: '',
  writingQ: '',
})


const submitAns = () => {
  console.log("点击了提交")
}

onMounted(()=> {
  get("/api/examinee/get-act-exam", (message) => {
    let eaxm_id = message.exam_id
    post("/api/examinee/get-paper", {
      user_id: store.auth.user.id,
      exam_id: eaxm_id,
    }, (paper_msg) => {
      form_paper.test_id = paper_msg.test_id
      form_paper.choiceQ1 = paper_msg.q.at(0).topic
      form_paper.choiceQ1A = paper_msg.q.at(0).optionA
      form_paper.choiceQ1B = paper_msg.q.at(0).optionB
      form_paper.choiceQ1C = paper_msg.q.at(0).optionC
      form_paper.choiceQ1D = paper_msg.q.at(0).optionD
      form_paper.choiceW1 = paper_msg.choiceW1

      form_paper.choiceQ2 = paper_msg.q.at(1).topic
      form_paper.choiceQ2A = paper_msg.q.at(1).optionA
      form_paper.choiceQ2B = paper_msg.q.at(1).optionB
      form_paper.choiceQ2C = paper_msg.q.at(1).optionC
      form_paper.choiceQ2D = paper_msg.q.at(1).optionD
      form_paper.choiceW2 = paper_msg.choiceW2

      form_paper.choiceQ3 = paper_msg.q.at(2).topic
      form_paper.choiceQ3A = paper_msg.q.at(2).optionA
      form_paper.choiceQ3B = paper_msg.q.at(2).optionB
      form_paper.choiceQ3C = paper_msg.q.at(2).optionC
      form_paper.choiceQ3D = paper_msg.q.at(2).optionD
      form_paper.choiceW3 = paper_msg.choiceW3

      form_paper.choiceQ4 = paper_msg.q.at(3).topic
      form_paper.choiceQ4A = paper_msg.q.at(3).optionA
      form_paper.choiceQ4B = paper_msg.q.at(3).optionB
      form_paper.choiceQ4C = paper_msg.q.at(3).optionC
      form_paper.choiceQ4D = paper_msg.q.at(3).optionD
      form_paper.choiceW4 = paper_msg.choiceW4

      form_paper.choiceQ5 = paper_msg.q.at(4).topic
      form_paper.choiceQ5A = paper_msg.q.at(4).optionA
      form_paper.choiceQ5B = paper_msg.q.at(4).optionB
      form_paper.choiceQ5C = paper_msg.q.at(4).optionC
      form_paper.choiceQ5D = paper_msg.q.at(4).optionD
      form_paper.choiceW5 = paper_msg.choiceW5

      form_paper.choiceQ6 = paper_msg.q.at(5).topic
      form_paper.choiceQ6A = paper_msg.q.at(5).optionA
      form_paper.choiceQ6B = paper_msg.q.at(5).optionB
      form_paper.choiceQ6C = paper_msg.q.at(5).optionC
      form_paper.choiceQ6D = paper_msg.q.at(5).optionD
      form_paper.choiceW6 = paper_msg.choiceW6

      form_paper.choiceQ7 = paper_msg.q.at(6).topic
      form_paper.choiceQ7A = paper_msg.q.at(6).optionA
      form_paper.choiceQ7B = paper_msg.q.at(6).optionB
      form_paper.choiceQ7C = paper_msg.q.at(6).optionC
      form_paper.choiceQ7D = paper_msg.q.at(6).optionD
      form_paper.choiceW7 = paper_msg.choiceW7

      form_paper.choiceQ8 = paper_msg.q.at(7).topic
      form_paper.choiceQ8A = paper_msg.q.at(7).optionA
      form_paper.choiceQ8B = paper_msg.q.at(7).optionB
      form_paper.choiceQ8C = paper_msg.q.at(7).optionC
      form_paper.choiceQ8D = paper_msg.q.at(7).optionD
      form_paper.choiceW8 = paper_msg.choiceW8

      form_paper.choiceQ9 = paper_msg.q.at(8).topic
      form_paper.choiceQ9A = paper_msg.q.at(8).optionA
      form_paper.choiceQ9B = paper_msg.q.at(8).optionB
      form_paper.choiceQ9C = paper_msg.q.at(8).optionC
      form_paper.choiceQ9D = paper_msg.q.at(8).optionD
      form_paper.choiceW9 = paper_msg.choiceW9

      form_paper.choiceQ10 = paper_msg.q.at(9).topic
      form_paper.choiceQ10A = paper_msg.q.at(9).optionA
      form_paper.choiceQ10B = paper_msg.q.at(9).optionB
      form_paper.choiceQ10C = paper_msg.q.at(9).optionC
      form_paper.choiceQ10D = paper_msg.q.at(9).optionD
      form_paper.choiceW10 = paper_msg.choiceW10

      form_paper.readingQ1 = paper_msg.readingQ1
      form_paper.readingQ2 = paper_msg.readingQ2
      form_paper.translationQ = paper_msg.translationQ
      form_paper.writingQ = paper_msg.writingQ
      ElMessage.success("获取试卷成功")
    }, ()=> {
      ElMessage.error("获取试卷失败")
    })
  }, () => {
    ElMessage.error("获取考试信息失败")
  })
})

const ShowMyAns = () => {
  console.log(form_ans)
}

</script>

<template>
  <div>
    <el-form :model="form_ans" label-width="120px">
      <el-card style="margin-top: 10px" class="box-card">
        <template #header>
          <div class="card-header">
            <span style="font-size: 20px; font-weight: bold">Passage One</span>
          </div>
        </template>
        <div>{{form_paper.readingQ1}}</div>
        <el-card style="margin-top: 10px" class="box-card">
          <template #header>
            <div class="card-header">
              <span style="font-size: 15px; font-weight: bold">Question 1</span>
            </div>
          </template>
          <div>{{form_paper.choiceQ1}}</div>
          <el-form-item style="margin-top: 5px" prop="stu_choiceW1">
            <div class="mb-2 flex items-center text-sm">
              <el-radio-group v-model="form_ans.stu_choiceW1" class="ml-4" @change="ShowMyAns">
                <el-radio label="A" size="large">A. {{form_paper.choiceQ1A}}</el-radio>
                <el-radio label="B" size="large">B. {{form_paper.choiceQ1B}}</el-radio>
                <el-radio label="C" size="large">C. {{form_paper.choiceQ1C}}</el-radio>
                <el-radio label="D" size="large">D. {{form_paper.choiceQ1D}}</el-radio>
              </el-radio-group>
            </div>
          </el-form-item>
        </el-card>

        <el-card style="margin-top: 10px" class="box-card">
          <template #header>
            <div class="card-header">
              <span style="font-size: 15px; font-weight: bold">Question 2</span>
            </div>
          </template>
          <div>{{form_paper.choiceQ2}}</div>
          <el-form-item style="margin-top: 5px" prop="stu_choiceW2">
            <div class="mb-2 flex items-center text-sm">
              <el-radio-group v-model="form_ans.stu_choiceW2" class="ml-4" @change="ShowMyAns">
                <el-radio label="A" size="large">A. {{form_paper.choiceQ2A}}</el-radio>
                <el-radio label="B" size="large">B. {{form_paper.choiceQ2B}}</el-radio>
                <el-radio label="C" size="large">C. {{form_paper.choiceQ2C}}</el-radio>
                <el-radio label="D" size="large">D. {{form_paper.choiceQ2D}}</el-radio>
              </el-radio-group>
            </div>
          </el-form-item>
        </el-card>

        <el-card style="margin-top: 10px" class="box-card">
          <template #header>
            <div class="card-header">
              <span style="font-size: 15px; font-weight: bold">Question 3</span>
            </div>
          </template>
          <div>{{form_paper.choiceQ3}}</div>
          <el-form-item style="margin-top: 5px" prop="stu_choiceW1">
            <div class="mb-2 flex items-center text-sm">
              <el-radio-group v-model="form_ans.stu_choiceW3" class="ml-4" @change="ShowMyAns">
                <el-radio label="A" size="large">A. {{form_paper.choiceQ3A}}</el-radio>
                <el-radio label="B" size="large">B. {{form_paper.choiceQ3B}}</el-radio>
                <el-radio label="C" size="large">C. {{form_paper.choiceQ3C}}</el-radio>
                <el-radio label="D" size="large">D. {{form_paper.choiceQ3D}}</el-radio>
              </el-radio-group>
            </div>
          </el-form-item>
        </el-card>

        <el-card style="margin-top: 10px" class="box-card">
          <template #header>
            <div class="card-header">
              <span style="font-size: 15px; font-weight: bold">Question 4</span>
            </div>
          </template>
          <div>{{form_paper.choiceQ4}}</div>
          <el-form-item style="margin-top: 5px" prop="stu_choiceW1">
            <div class="mb-2 flex items-center text-sm">
              <el-radio-group v-model="form_ans.stu_choiceW4" class="ml-4" @change="ShowMyAns">
                <el-radio label="A" size="large">A. {{form_paper.choiceQ4A}}</el-radio>
                <el-radio label="B" size="large">B. {{form_paper.choiceQ4B}}</el-radio>
                <el-radio label="C" size="large">C. {{form_paper.choiceQ4C}}</el-radio>
                <el-radio label="D" size="large">D. {{form_paper.choiceQ4D}}</el-radio>
              </el-radio-group>
            </div>
          </el-form-item>
        </el-card>

        <el-card style="margin-top: 10px" class="box-card">
          <template #header>
            <div class="card-header">
              <span style="font-size: 15px; font-weight: bold">Question 5</span>
            </div>
          </template>
          <div>{{form_paper.choiceQ5}}</div>
          <el-form-item style="margin-top: 5px" prop="stu_choiceW1">
            <div class="mb-2 flex items-center text-sm">
              <el-radio-group v-model="form_ans.stu_choiceW5" class="ml-4" @change="ShowMyAns">
                <el-radio label="A" size="large">A. {{form_paper.choiceQ5A}}</el-radio>
                <el-radio label="B" size="large">B. {{form_paper.choiceQ5B}}</el-radio>
                <el-radio label="C" size="large">C. {{form_paper.choiceQ5C}}</el-radio>
                <el-radio label="D" size="large">D. {{form_paper.choiceQ5D}}</el-radio>
              </el-radio-group>
            </div>
          </el-form-item>
        </el-card>
      </el-card>
      <el-card style="margin-top: 10px" class="box-card">
        <template #header>
          <div class="card-header">
            <span style="font-size: 20px; font-weight: bold">Passage Two</span>
          </div>
        </template>
        <div>{{form_paper.readingQ2}}</div>
        <el-card style="margin-top: 10px" class="box-card">
          <template #header>
            <div class="card-header">
              <span style="font-size: 15px; font-weight: bold">Question 6</span>
            </div>
          </template>
          <div>{{form_paper.choiceQ6}}</div>
          <el-form-item style="margin-top: 5px" prop="stu_choiceW1">
            <div class="mb-2 flex items-center text-sm">
              <el-radio-group v-model="form_ans.stu_choiceW6" class="ml-4" @change="ShowMyAns">
                <el-radio label="A" size="large">A. {{form_paper.choiceQ6A}}</el-radio>
                <el-radio label="B" size="large">B. {{form_paper.choiceQ6B}}</el-radio>
                <el-radio label="C" size="large">C. {{form_paper.choiceQ6C}}</el-radio>
                <el-radio label="D" size="large">D. {{form_paper.choiceQ6D}}</el-radio>
              </el-radio-group>
            </div>
          </el-form-item>
        </el-card>

        <el-card style="margin-top: 10px" class="box-card">
          <template #header>
            <div class="card-header">
              <span style="font-size: 15px; font-weight: bold">Question 7</span>
            </div>
          </template>
          <div>{{form_paper.choiceQ7}}</div>
          <el-form-item style="margin-top: 5px" prop="stu_choiceW2">
            <div class="mb-2 flex items-center text-sm">
              <el-radio-group v-model="form_ans.stu_choiceW7" class="ml-4" @change="ShowMyAns">
                <el-radio label="A" size="large">A. {{form_paper.choiceQ7A}}</el-radio>
                <el-radio label="B" size="large">B. {{form_paper.choiceQ7B}}</el-radio>
                <el-radio label="C" size="large">C. {{form_paper.choiceQ7C}}</el-radio>
                <el-radio label="D" size="large">D. {{form_paper.choiceQ7D}}</el-radio>
              </el-radio-group>
            </div>
          </el-form-item>
        </el-card>

        <el-card style="margin-top: 10px" class="box-card">
          <template #header>
            <div class="card-header">
              <span style="font-size: 15px; font-weight: bold">Question 8</span>
            </div>
          </template>
          <div>{{form_paper.choiceQ8}}</div>
          <el-form-item style="margin-top: 5px" prop="stu_choiceW1">
            <div class="mb-2 flex items-center text-sm">
              <el-radio-group v-model="form_ans.stu_choiceW8" class="ml-4" @change="ShowMyAns">
                <el-radio label="A" size="large">A. {{form_paper.choiceQ8A}}</el-radio>
                <el-radio label="B" size="large">B. {{form_paper.choiceQ8B}}</el-radio>
                <el-radio label="C" size="large">C. {{form_paper.choiceQ8C}}</el-radio>
                <el-radio label="D" size="large">D. {{form_paper.choiceQ8D}}</el-radio>
              </el-radio-group>
            </div>
          </el-form-item>
        </el-card>

        <el-card style="margin-top: 10px" class="box-card">
          <template #header>
            <div class="card-header">
              <span style="font-size: 15px; font-weight: bold">Question 9</span>
            </div>
          </template>
          <div>{{form_paper.choiceQ9}}</div>
          <el-form-item style="margin-top: 5px" prop="stu_choiceW1">
            <div class="mb-2 flex items-center text-sm">
              <el-radio-group v-model="form_ans.stu_choiceW9" class="ml-4" @change="ShowMyAns">
                <el-radio label="A" size="large">A. {{form_paper.choiceQ9A}}</el-radio>
                <el-radio label="B" size="large">B. {{form_paper.choiceQ9B}}</el-radio>
                <el-radio label="C" size="large">C. {{form_paper.choiceQ9C}}</el-radio>
                <el-radio label="D" size="large">D. {{form_paper.choiceQ9D}}</el-radio>
              </el-radio-group>
            </div>
          </el-form-item>
        </el-card>

        <el-card style="margin-top: 10px" class="box-card">
          <template #header>
            <div class="card-header">
              <span style="font-size: 15px; font-weight: bold">Question 10</span>
            </div>
          </template>
          <div>{{form_paper.choiceQ10}}</div>
          <el-form-item style="margin-top: 5px" prop="stu_choiceW1">
            <div class="mb-2 flex items-center text-sm">
              <el-radio-group v-model="form_ans.stu_choiceW10" class="ml-4" @change="ShowMyAns">
                <el-radio label="A" size="large">A. {{form_paper.choiceQ10A}}</el-radio>
                <el-radio label="B" size="large">B. {{form_paper.choiceQ10B}}</el-radio>
                <el-radio label="C" size="large">C. {{form_paper.choiceQ10C}}</el-radio>
                <el-radio label="D" size="large">D. {{form_paper.choiceQ10D}}</el-radio>
              </el-radio-group>
            </div>
          </el-form-item>
        </el-card>
      </el-card>
      <el-card class="box-card">
        <template #header>
          <div class="card-header">
            <span style="font-size: 20px; font-weight: bold">Translation</span>
            <div>{{form_paper.translationQ}}</div>
            <el-form-item style="margin-top: 5px" prop="translationW">
              <el-input
                  v-model="form_ans.translationW"
                  :autosize="{ minRows: 0, maxRows: 20 }"
                  type="textarea"
                  placeholder="Please input"
                  @change="ShowMyAns"
              />
            </el-form-item>

          </div>
        </template>
      </el-card>
      <el-card class="box-card">
        <template #header>
          <div class="card-header">
            <span style="font-size: 20px; font-weight: bold">Writing</span>
            <div>{{form_paper.writingQ}}</div>
            <el-form-item style="margin-top: 5px" prop="writingW">
              <el-input
                  v-model="form_ans.writingW"
                  :autosize="{ minRows: 0, maxRows: 20 }"
                  type="textarea"
                  placeholder="Please input"
                  @change="ShowMyAns"
              />
            </el-form-item>
          </div>
        </template>
      </el-card>
    </el-form>
    <el-button style="margin-top: 10px" type="primary" @click="ShowMyAns">保存答案</el-button>
    <el-button style="margin-top: 10px" type="primary" @click="submitAns">提交试卷</el-button>
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


