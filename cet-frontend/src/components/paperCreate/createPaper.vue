<template>
  <div style="margin-top: 0px">
    <div style="font-size: 25px;font-weight: bold">阅读题1</div>
  </div>
  <div style="margin-top: 10px">
    <el-form :model="form_paper" :rules="rules" label-width="120px">
      <el-form-item label="阅读内容" prop="readingQ1">
        <el-input v-model="form_paper.readingQ1" type="textarea" placeholder="请输入阅读内容..." />
      </el-form-item>
      <el-divider></el-divider>
      <el-form-item label="问题1" prop="choiceQ1">
        <el-input v-model="form_paper.choiceQ1" type="textarea" placeholder="请输入问题1..." />
      </el-form-item>
      <el-form-item label="A" prop="choiceQ1A">
        <el-input v-model="form_paper.choiceQ1A" placeholder="请输入选项A..." />
      </el-form-item>
      <el-form-item label="B" prop="choiceQ1B">
        <el-input v-model="form_paper.choiceQ1B" placeholder="请输入选项B..." />
      </el-form-item>
      <el-form-item label="C" prop="choiceQ1C">
        <el-input v-model="form_paper.choiceQ1C" placeholder="请输入选项C..." />
      </el-form-item>
      <el-form-item label="D" prop="choiceQ1D">
        <el-input v-model="form_paper.choiceQ1D" placeholder="请输入选项D..." />
      </el-form-item>
      <el-form-item label="问题1答案" prop="choiceW1">
        <el-radio-group v-model="form_paper.choiceW1">
          <el-radio label="A" />
          <el-radio label="B" />
          <el-radio label="C" />
          <el-radio label="D" />
        </el-radio-group>
      </el-form-item>
      <el-divider></el-divider>

      <el-form-item label="问题2" prop="choiceQ2">
        <el-input v-model="form_paper.choiceQ2" type="textarea" placeholder="请输入问题2..." />
      </el-form-item>
      <el-form-item label="A" prop="choiceQ2A">
        <el-input v-model="form_paper.choiceQ2A" placeholder="请输入选项A..." />
      </el-form-item>
      <el-form-item label="B" prop="choiceQ2B">
        <el-input v-model="form_paper.choiceQ2B" placeholder="请输入选项B..." />
      </el-form-item>
      <el-form-item label="C" prop="choiceQ2C">
        <el-input v-model="form_paper.choiceQ2C" placeholder="请输入选项C..." />
      </el-form-item>
      <el-form-item label="D" prop="choiceQ2D">
        <el-input v-model="form_paper.choiceQ2D" placeholder="请输入选项D..." />
      </el-form-item>
      <el-form-item label="问题2答案" prop="choiceW2">
        <el-radio-group v-model="form_paper.choiceW2">
          <el-radio label="A" />
          <el-radio label="B" />
          <el-radio label="C" />
          <el-radio label="D" />
        </el-radio-group>
      </el-form-item>
      <el-divider></el-divider>

      <el-form-item label="问题3" prop="choiceQ3">
        <el-input v-model="form_paper.choiceQ3" type="textarea" placeholder="请输入问题3.." />
      </el-form-item>
      <el-form-item label="A" prop="choiceQ3A">
        <el-input v-model="form_paper.choiceQ3A" placeholder="请输入选项A..." />
      </el-form-item>
      <el-form-item label="B" prop="choiceQ3B">
        <el-input v-model="form_paper.choiceQ3B" placeholder="请输入选项B..." />
      </el-form-item>
      <el-form-item label="C" prop="choiceQ3C">
        <el-input v-model="form_paper.choiceQ3C" placeholder="请输入选项C..." />
      </el-form-item>
      <el-form-item label="D" prop="choiceQ3D">
        <el-input v-model="form_paper.choiceQ3D" placeholder="请输入选项D..." />
      </el-form-item>
      <el-form-item label="问题3答案" prop="choiceW3">
        <el-radio-group v-model="form_paper.choiceW3">
          <el-radio label="A" />
          <el-radio label="B" />
          <el-radio label="C" />
          <el-radio label="D" />
        </el-radio-group>
      </el-form-item>
      <el-divider></el-divider>

      <el-form-item label="问题4" prop="choiceQ4">
        <el-input v-model="form_paper.choiceQ4" type="textarea" placeholder="请输入问题4..." />
      </el-form-item>
      <el-form-item label="A" prop="choiceQ4A">
        <el-input v-model="form_paper.choiceQ4A" placeholder="请输入选项A..." />
      </el-form-item>
      <el-form-item label="B" prop="choiceQ4B">
        <el-input v-model="form_paper.choiceQ4B" placeholder="请输入选项B..." />
      </el-form-item>
      <el-form-item label="C" prop="choiceQ4C">
        <el-input v-model="form_paper.choiceQ4C" placeholder="请输入选项C..." />
      </el-form-item>
      <el-form-item label="D" prop="choiceQ4D">
        <el-input v-model="form_paper.choiceQ4D" placeholder="请输入选项D..." />
      </el-form-item>
      <el-form-item label="问题4答案" prop="choiceW4">
        <el-radio-group v-model="form_paper.choiceW4">
          <el-radio label="A" />
          <el-radio label="B" />
          <el-radio label="C" />
          <el-radio label="D" />
        </el-radio-group>
      </el-form-item>
      <el-divider></el-divider>

      <el-form-item label="问题5" prop="choiceQ5">
        <el-input v-model="form_paper.choiceQ5" type="textarea" placeholder="请输入问题5..." />
      </el-form-item>
      <el-form-item label="A" prop="choiceQ5A">
        <el-input v-model="form_paper.choiceQ5A" placeholder="请输入选项A..." />
      </el-form-item>
      <el-form-item label="B" prop="choiceQ5B">
        <el-input v-model="form_paper.choiceQ5B" placeholder="请输入选项B..." />
      </el-form-item>
      <el-form-item label="C" prop="choiceQ5C">
        <el-input v-model="form_paper.choiceQ5C" placeholder="请输入选项C..." />
      </el-form-item>
      <el-form-item label="D" prop="choiceQ5D">
        <el-input v-model="form_paper.choiceQ5D" placeholder="请输入选项D..." />
      </el-form-item>
      <el-form-item label="问题5答案" prop="choiceW5">
        <el-radio-group v-model="form_paper.choiceW5">
          <el-radio label="A" />
          <el-radio label="B" />
          <el-radio label="C" />
          <el-radio label="D" />
        </el-radio-group>
      </el-form-item>
      <el-divider></el-divider>

    </el-form>
  </div>

  <div style="margin-top: 0px">
    <div style="font-size: 25px;font-weight: bold">阅读题2</div>
  </div>
  <div style="margin-top: 10px">
    <el-form :model="form_paper" :rules="rules" label-width="120px">
      <el-form-item label="阅读内容" prop="readingQ2">
        <el-input v-model="form_paper.readingQ2" type="textarea" placeholder="请输入阅读内容..." />
      </el-form-item>
      <el-divider></el-divider>
      <el-form-item label="问题6" prop="choiceQ6">
        <el-input v-model="form_paper.choiceQ6" type="textarea" placeholder="请输入问题6..." />
      </el-form-item>
      <el-form-item label="A" prop="choiceQ6A">
        <el-input v-model="form_paper.choiceQ6A" placeholder="请输入选项A..." />
      </el-form-item>
      <el-form-item label="B" prop="choiceQ6B">
        <el-input v-model="form_paper.choiceQ6B" placeholder="请输入选项B..." />
      </el-form-item>
      <el-form-item label="C" prop="choiceQ6C">
        <el-input v-model="form_paper.choiceQ6C" placeholder="请输入选项C..." />
      </el-form-item>
      <el-form-item label="D" prop="choiceQ6D">
        <el-input v-model="form_paper.choiceQ6D" placeholder="请输入选项D..." />
      </el-form-item>
      <el-form-item label="问题6答案" prop="choiceW6">
        <el-radio-group v-model="form_paper.choiceW6">
          <el-radio label="A" />
          <el-radio label="B" />
          <el-radio label="C" />
          <el-radio label="D" />
        </el-radio-group>
      </el-form-item>
      <el-divider></el-divider>

      <el-form-item label="问题7" prop="choiceQ7">
        <el-input v-model="form_paper.choiceQ7" type="textarea" placeholder="请输入问题7..." />
      </el-form-item>
      <el-form-item label="A" prop="choiceQ7A">
        <el-input v-model="form_paper.choiceQ7A" placeholder="请输入选项A..." />
      </el-form-item>
      <el-form-item label="B" prop="choiceQ7B">
        <el-input v-model="form_paper.choiceQ7B" placeholder="请输入选项B..." />
      </el-form-item>
      <el-form-item label="C" prop="choiceQ7C">
        <el-input v-model="form_paper.choiceQ7C" placeholder="请输入选项C..." />
      </el-form-item>
      <el-form-item label="D" prop="choiceQ7D">
        <el-input v-model="form_paper.choiceQ7D" placeholder="请输入选项D..." />
      </el-form-item>
      <el-form-item label="问题7答案" prop="choiceW7">
        <el-radio-group v-model="form_paper.choiceW7">
          <el-radio label="A" />
          <el-radio label="B" />
          <el-radio label="C" />
          <el-radio label="D" />
        </el-radio-group>
      </el-form-item>
      <el-divider></el-divider>

      <el-form-item label="问题8" prop="choiceQ8">
        <el-input v-model="form_paper.choiceQ8" type="textarea" placeholder="请输入问题8.." />
      </el-form-item>
      <el-form-item label="A" prop="choiceQ8A">
        <el-input v-model="form_paper.choiceQ8A" placeholder="请输入选项A..." />
      </el-form-item>
      <el-form-item label="B" prop="choiceQ8B">
        <el-input v-model="form_paper.choiceQ8B" placeholder="请输入选项B..." />
      </el-form-item>
      <el-form-item label="C" prop="choiceQ8C">
        <el-input v-model="form_paper.choiceQ8C" placeholder="请输入选项C..." />
      </el-form-item>
      <el-form-item label="D" prop="choiceQ8D">
        <el-input v-model="form_paper.choiceQ8D" placeholder="请输入选项D..." />
      </el-form-item>
      <el-form-item label="问题8答案" prop="choiceW8">
        <el-radio-group v-model="form_paper.choiceW8">
          <el-radio label="A" />
          <el-radio label="B" />
          <el-radio label="C" />
          <el-radio label="D" />
        </el-radio-group>
      </el-form-item>
      <el-divider></el-divider>

      <el-form-item label="问题9" prop="choiceQ9">
        <el-input v-model="form_paper.choiceQ9" type="textarea" placeholder="请输入问题9..." />
      </el-form-item>
      <el-form-item label="A" prop="choiceQ9A">
        <el-input v-model="form_paper.choiceQ9A" placeholder="请输入选项A..." />
      </el-form-item>
      <el-form-item label="B" prop="choiceQ9B">
        <el-input v-model="form_paper.choiceQ9B" placeholder="请输入选项B..." />
      </el-form-item>
      <el-form-item label="C" prop="choiceQ9C">
        <el-input v-model="form_paper.choiceQ9C" placeholder="请输入选项C..." />
      </el-form-item>
      <el-form-item label="D" prop="choiceQ9D">
        <el-input v-model="form_paper.choiceQ9D" placeholder="请输入选项D..." />
      </el-form-item>
      <el-form-item label="问题9答案" prop="choiceW9">
        <el-radio-group v-model="form_paper.choiceW9">
          <el-radio label="A" />
          <el-radio label="B" />
          <el-radio label="C" />
          <el-radio label="D" />
        </el-radio-group>
      </el-form-item>
      <el-divider></el-divider>

      <el-form-item label="问题10" prop="choiceQ10">
        <el-input v-model="form_paper.choiceQ10" type="textarea" placeholder="请输入问题10..." />
      </el-form-item>
      <el-form-item label="A" prop="choiceQ10A">
        <el-input v-model="form_paper.choiceQ10A" placeholder="请输入选项A..." />
      </el-form-item>
      <el-form-item label="B" prop="choiceQ10B">
        <el-input v-model="form_paper.choiceQ10B" placeholder="请输入选项B..." />
      </el-form-item>
      <el-form-item label="C" prop="choiceQ10C">
        <el-input v-model="form_paper.choiceQ10C" placeholder="请输入选项C..." />
      </el-form-item>
      <el-form-item label="D" prop="choiceQ10D">
        <el-input v-model="form_paper.choiceQ10D" placeholder="请输入选项D..." />
      </el-form-item>
      <el-form-item label="问题10答案" prop="choiceW10">
        <el-radio-group v-model="form_paper.choiceW10">
          <el-radio label="A" />
          <el-radio label="B" />
          <el-radio label="C" />
          <el-radio label="D" />
        </el-radio-group>
      </el-form-item>
      <el-divider></el-divider>
    </el-form>
  </div>

  <div style="margin-top: 0px">
    <div style="font-size: 25px;font-weight: bold">翻译题</div>
  </div>
  <div style="margin-top: 10px">
    <el-form :model="form_paper" :rules="rules" label-width="120px">
      <el-form-item label="翻译题" prop="translationQ">
        <el-input v-model="form_paper.translationQ" type="textarea" placeholder="请输入翻译题题干..." />
      </el-form-item>
      <el-divider></el-divider>
    </el-form>
  </div>

  <div style="margin-top: 0px">
    <div style="font-size: 25px;font-weight: bold">写作题</div>
  </div>
  <div style="margin-top: 10px">
    <el-form :model="form_paper" :rules="rules" label-width="120px">
      <el-form-item label="写作题" prop="writingQ">
        <el-input v-model="form_paper.writingQ" type="textarea" placeholder="请输入写作题题干..." />
      </el-form-item>
    </el-form>
  </div>

  <div style="margin-top: 50px" align="center">
    <el-button type="primary" @click="onSubmit">添加试卷</el-button>
    <el-button @click="onCancel">取消</el-button>
  </div>


</template>

<script setup>

import {reactive, ref} from "vue";
import {get, post} from "@/net";
import {ElMessage} from "element-plus";
import router from "@/router";

const onCancel = () => {
  get('api/paper/cancle',()=>{
    ElMessage.success("取消成功");
    router.push('/teacher/index/paperList');
  },()=>{
    ElMessage.error("发生错误");
    router.push('/teacher/index/paperList');
  })
  console.log(router.currentRoute);
}

const onSubmit = () => {
  post('/api/paper/create-choice', {
    Topic: form_paper.choiceQ1, OptionA: form_paper.choiceQ1A, OptionB: form_paper.choiceQ1B, OptionC: form_paper.choiceQ1C, OptionD: form_paper.choiceQ1D
  }, (message) => {
    post('/api/paper/create-choice', {
      Topic: form_paper.choiceQ2, OptionA: form_paper.choiceQ2A, OptionB: form_paper.choiceQ2B, OptionC: form_paper.choiceQ2C, OptionD: form_paper.choiceQ2D
    }, (message) => {
      post('/api/paper/create-choice', {
        Topic: form_paper.choiceQ3, OptionA: form_paper.choiceQ3A, OptionB: form_paper.choiceQ3B, OptionC: form_paper.choiceQ3C, OptionD: form_paper.choiceQ3D
      }, (message) => {
        post('/api/paper/create-choice', {
          Topic: form_paper.choiceQ4, OptionA: form_paper.choiceQ4A, OptionB: form_paper.choiceQ4B, OptionC: form_paper.choiceQ4C, OptionD: form_paper.choiceQ4D
        }, (message) => {
          post('/api/paper/create-choice', {
            Topic: form_paper.choiceQ5, OptionA: form_paper.choiceQ5A, OptionB: form_paper.choiceQ5B, OptionC: form_paper.choiceQ5C, OptionD: form_paper.choiceQ5D
          }, (message) => {
            post('/api/paper/create-choice', {
              Topic: form_paper.choiceQ6, OptionA: form_paper.choiceQ6A, OptionB: form_paper.choiceQ6B, OptionC: form_paper.choiceQ6C, OptionD: form_paper.choiceQ6D
            }, (message) => {
              post('/api/paper/create-choice', {
                Topic: form_paper.choiceQ7, OptionA: form_paper.choiceQ7A, OptionB: form_paper.choiceQ7B, OptionC: form_paper.choiceQ7C, OptionD: form_paper.choiceQ7D
              }, (message) => {
                post('/api/paper/create-choice', {
                  Topic: form_paper.choiceQ8, OptionA: form_paper.choiceQ8A, OptionB: form_paper.choiceQ8B, OptionC: form_paper.choiceQ8C, OptionD: form_paper.choiceQ8D
                }, (message) => {
                  post('/api/paper/create-choice', {
                    Topic: form_paper.choiceQ9, OptionA: form_paper.choiceQ9A, OptionB: form_paper.choiceQ9B, OptionC: form_paper.choiceQ9C, OptionD: form_paper.choiceQ9D
                  }, (message) => {
                    post('/api/paper/create-choice', {
                      Topic: form_paper.choiceQ10, OptionA: form_paper.choiceQ10A, OptionB: form_paper.choiceQ10B, OptionC: form_paper.choiceQ10C, OptionD: form_paper.choiceQ10D
                    }, (message) => {
                      post('/api/paper/create-paper',{
                        choiceW1: form_paper.choiceW1, choiceW2: form_paper.choiceW2, choiceW3: form_paper.choiceW3, choiceW4: form_paper.choiceW4, choiceW5: form_paper.choiceW5,
                        readingQ1: form_paper.readingQ1, readingQ2: form_paper.readingQ2, choiceW6: form_paper.choiceW6, choiceW7: form_paper.choiceW7, choiceW8: form_paper.choiceW8,
                        choiceW9: form_paper.choiceW9, choiceW10: form_paper.choiceW10, translationQ: form_paper.translationQ, writingQ: form_paper.writingQ
                      },()=>{
                        ElMessage.success("创建试卷成功");
                        router.push('/teacher/index/paperList');
                      },()=>{
                        ElMessage.error("创建试卷失败");
                      })
                    },()=> {
                      ElMessage.error("请填写完整的试卷信息")
                    })
                  },()=> {
                    ElMessage.error("请填写完整的试卷信息")
                  })
                },()=> {
                  ElMessage.error("请填写完整的试卷信息")
                })
              },()=> {
                ElMessage.error("请填写完整的试卷信息")
              })
            },()=> {
              ElMessage.error("请填写完整的试卷信息")
            })
          },()=> {
            ElMessage.error("请填写完整的试卷信息")
          })
        },()=> {
          ElMessage.error("请填写完整的试卷信息")
        })
      },()=> {
        ElMessage.error("请填写完整的试卷信息")
      })
    },()=> {
      ElMessage.error("请填写完整的试卷信息")
    })
  },()=> {
    ElMessage.error("请填写完整的试卷信息")
  })
  console.log(router.currentRoute);
}


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

const rules = {
  choiceQ1: [
    { required: true, message: '请输入题干', trigger: ['blur', 'change'] },
  ],
  choiceQ1A:[
    { required: true, message: '请输入选项', trigger: ['blur', 'change'] },
  ],
  choiceQ1B:[
    { required: true, message: '请输入选项', trigger: ['blur', 'change'] },
  ],
  choiceQ1C:[
    { required: true, message: '请输入选项', trigger: ['blur', 'change'] },
  ],
  choiceQ1D:[
    { required: true, message: '请输入选项', trigger: ['blur', 'change'] },
  ],
  choiceW1: [
    { required: true, message: '请输入答案', trigger: ['blur', 'change'] },
  ],
  choiceQ2: [
    { required: true, message: '请输入题干', trigger: ['blur', 'change'] },
  ],
  choiceW2: [
    { required: true, message: '请输入答案', trigger: ['blur', 'change'] },
  ],
  choiceQ2A:[
    { required: true, message: '请输入选项', trigger: ['blur', 'change'] },
  ],
  choiceQ2B:[
    { required: true, message: '请输入选项', trigger: ['blur', 'change'] },
  ],
  choiceQ2C:[
    { required: true, message: '请输入选项', trigger: ['blur', 'change'] },
  ],
  choiceQ2D: [
    { required: true, message: '请输入选项', trigger: ['blur', 'change'] },
  ],

  choiceQ3: [
    { required: true, message: '请输入题干', trigger: ['blur', 'change'] },
  ],
  choiceQ3A:[
    { required: true, message: '请输入选项', trigger: ['blur', 'change'] },
  ],
  choiceQ3B:[
    { required: true, message: '请输入选项', trigger: ['blur', 'change'] },
  ],
  choiceQ3C:[
    { required: true, message: '请输入选项', trigger: ['blur', 'change'] },
  ],
  choiceQ3D:[
    { required: true, message: '请输入选项', trigger: ['blur', 'change'] },
  ],
  choiceW3: [
    { required: true, message: '请输入答案', trigger: ['blur', 'change'] },
  ],

  choiceQ4: [
    { required: true, message: '请输入题干', trigger: ['blur', 'change'] },
  ],
  choiceW4: [
    { required: true, message: '请输入答案', trigger: ['blur', 'change'] },
  ],
  choiceQ4A:[
    { required: true, message: '请输入选项', trigger: ['blur', 'change'] },
  ],
  choiceQ4B:[
    { required: true, message: '请输入选项', trigger: ['blur', 'change'] },
  ],
  choiceQ4C:[
    { required: true, message: '请输入选项', trigger: ['blur', 'change'] },
  ],
  choiceQ4D:[
    { required: true, message: '请输入选项', trigger: ['blur', 'change'] },
  ],

  choiceQ5: [
    { required: true, message: '请输入题干', trigger: ['blur', 'change'] },
  ],
  choiceW5: [
    { required: true, message: '请输入答案', trigger: ['blur', 'change'] },
  ],
  choiceQ5A: [
    { required: true, message: '请输入选项', trigger: ['blur', 'change'] },
  ],
  choiceQ5B: [
    { required: true, message: '请输入选项', trigger: ['blur', 'change'] },
  ],
  choiceQ5C: [
    { required: true, message: '请输入选项', trigger: ['blur', 'change'] },
  ],
  choiceQ5D: [
    { required: true, message: '请输入选项', trigger: ['blur', 'change'] },
  ],

  readingQ1: [
    { required: true, message: '请输入阅读内容', trigger: ['blur', 'change'] },
  ],
  readingQ2: [
    { required: true, message: '请输入阅读内容', trigger: ['blur', 'change'] },
  ],
  choiceQ6: [
    { required: true, message: '请输入题干', trigger: ['blur', 'change'] },
  ],
  choiceW6: [
    { required: true, message: '请输入答案', trigger: ['blur', 'change'] },
  ],
  choiceQ6A: [
    { required: true, message: '请输入选项', trigger: ['blur', 'change'] },
  ],
  choiceQ6B: [
    { required: true, message: '请输入选项', trigger: ['blur', 'change'] },
  ],
  choiceQ6C: [
    { required: true, message: '请输入选项', trigger: ['blur', 'change'] },
  ],
  choiceQ6D: [
    { required: true, message: '请输入选项', trigger: ['blur', 'change'] },
  ],

  choiceQ7: [
    { required: true, message: '请输入选项', trigger: ['blur', 'change'] },
  ],
  choiceW7: [
    { required: true, message: '请输入答案', trigger: ['blur', 'change'] },
  ],
  choiceQ7A: [
    { required: true, message: '请输入选项', trigger: ['blur', 'change'] },
  ],
  choiceQ7B: [
    { required: true, message: '请输入选项', trigger: ['blur', 'change'] },
  ],
  choiceQ7C: [
    { required: true, message: '请输入选项', trigger: ['blur', 'change'] },
  ],
  choiceQ7D: [
    { required: true, message: '请输入选项', trigger: ['blur', 'change'] },
  ],

  choiceQ8:  [
    { required: true, message: '请输入题干', trigger: ['blur', 'change'] },
  ],
  choiceW8: [
    { required: true, message: '请输入答案', trigger: ['blur', 'change'] },
  ],
  choiceQ8A: [
    { required: true, message: '请输入选项', trigger: ['blur', 'change'] },
  ],
  choiceQ8B: [
    { required: true, message: '请输入选项', trigger: ['blur', 'change'] },
  ],
  choiceQ8C: [
    { required: true, message: '请输入选项', trigger: ['blur', 'change'] },
  ],
  choiceQ8D: [
    { required: true, message: '请输入选项', trigger: ['blur', 'change'] },
  ],

  choiceQ9:  [
    { required: true, message: '请输入题干', trigger: ['blur', 'change'] },
  ],
  choiceW9:  [
    { required: true, message: '请输入答案', trigger: ['blur', 'change'] },
  ],
  choiceQ9A: [
    { required: true, message: '请输入选项', trigger: ['blur', 'change'] },
  ],
  choiceQ9B: [
    { required: true, message: '请输入选项', trigger: ['blur', 'change'] },
  ],
  choiceQ9C: [
    { required: true, message: '请输入选项', trigger: ['blur', 'change'] },
  ],
  choiceQ9D: [
    { required: true, message: '请输入选项', trigger: ['blur', 'change'] },
  ],

  choiceQ10: [
    { required: true, message: '请输入题干', trigger: ['blur', 'change'] },
  ],
  choiceW10: [
    { required: true, message: '请输入答案', trigger: ['blur', 'change'] },
  ],
  choiceQ10A: [
    { required: true, message: '请输入选项', trigger: ['blur', 'change'] },
  ],
  choiceQ10B: [
    { required: true, message: '请输入选项', trigger: ['blur', 'change'] },
  ],
  choiceQ10C: [
    { required: true, message: '请输入选项', trigger: ['blur', 'change'] },
  ],
  choiceQ10D: [
    { required: true, message: '请输入选项', trigger: ['blur', 'change'] },
  ],

  translationQ:  [
    { required: true, message: '请输入翻译题题干', trigger: ['blur', 'change'] },
  ],
  writingQ: [
    { required: true, message: '请输入写作题题干', trigger: ['blur', 'change'] },
  ],
}

</script>




