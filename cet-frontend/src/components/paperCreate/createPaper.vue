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

    </el-form>
  </div>
</template>

<script setup>

import {reactive, ref} from "vue";


const onSubmit = () => {
  console.log('submit!')
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




