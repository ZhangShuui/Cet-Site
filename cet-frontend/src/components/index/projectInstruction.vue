<script setup>

import router from "@/router";
</script>

<template>
<el-card style="margin-left: 100px;margin-right: 100px">
  <template #header>
    <el-text style="font-size: larger; color: black">
      关于CET
    </el-text>
  </template>
  <el-text style="margin-right: 50px">
    　　全国大学英语四、六级考试（CET）是由教育部主办，教育部教育考试院（原教育部考试中心）主持和实施的大规模标准化考试，是全国性的教学考试，其目的是促进我国大学英语教学工作，对大学生的英语能力进行客观、准确的测量，为提高我国大学英语课程的教学质量提供服务。CET始于1987年，已走过了三十多年的历程，对我国大学英语教学的发展和改革产生了积极的影响。
  </el-text>
<el-divider style="visibility: hidden">

</el-divider>
  <el-text>
    　　CET笔试的考试时间为每年6月和12月；CET口试的考试时间为每年5月和11月，报考口试的考生必须先报考当次相应级别的笔试。
  </el-text>
<el-divider style="visibility: hidden"/>
  <el-text>
    　　CET同时设有非英语考试科目，包括：日语四级(CJT4)、日语六级(CJT6)、俄语四级(CRT4)、俄语六级(CRT6)、德语四级(CGT4)、德语六级(CGT6)和法语四级(CFT4)，以上考试科目每年6月开考一次，均为笔试考核，无口试考核。
  </el-text>
</el-card>
  <el-divider style="visibility: hidden"/>
  <div align="center">
    <el-button size="large" @click="router.push('/index')">
      返回
    </el-button>
  </div>

</template>

<style scoped>

</style>