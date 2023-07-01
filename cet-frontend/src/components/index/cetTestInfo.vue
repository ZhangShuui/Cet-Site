<script setup>

import router from "@/router";
</script>

<template>
  <el-card style="margin-left: 100px;margin-right: 100px">
    <template #header>
      <el-text style="font-size: larger; color: black">
        CET考试分值分布
      </el-text>
    </template>
    <el-text style="margin-right: 50px">
      　　全国大学英语六级考试（CET）是由教育部主办，教育部教育考试院（原教育部考试中心）主持和实施的大规模标准化考试，是全国性的教学考试，其目的是促进我国大学英语教学工作，对大学生的英语能力进行客观、准确的测量，为提高我国大学英语课程的教学质量提供服务。CET始于1987年，已走过了三十多年的历程，对我国大学英语教学的发展和改革产生了积极的影响。考试分值分布如下：
    </el-text>

    <el-divider style="visibility: hidden">

    </el-divider>

    <table align="center" border="1" style="background:white; border-collapse:collapse; border:solid #dddddd 1.0pt; width:432.75pt">
      <tbody>
      <tr>
        <td style="background-color:white; height:18.0pt; width:72.0pt">
          <p style="margin-left:0cm; margin-right:0cm; text-align:center">试卷结构</p>
        </td>
        <td style="background-color:white; height:18.0pt; width:57.0pt">
          <p style="margin-left:0cm; margin-right:0cm; text-align:center">测试内容</p>
        </td>
        <td style="background-color:white; height:18.0pt; width:135.0pt">
          <p style="margin-left:0cm; margin-right:0cm; text-align:center">测试题型</p>
        </td>
        <td style="background-color:white; height:18.0pt; width:57.0pt">
          <p style="margin-left:0cm; margin-right:0cm; text-align:center">题目数量</p>
        </td>
        <td style="background-color:white; height:18.0pt; width:57.0pt">
          <p style="margin-left:0cm; margin-right:0cm; text-align:center">分值比例</p>
        </td>
        <td style="background-color:white; height:18.0pt; width:57.0pt">
          <p style="margin-left:0cm; margin-right:0cm; text-align:center">考试时间</p>
        </td>
      </tr>
      <tr>
        <td style="background-color:white; height:13.5pt; width:72.0pt">
          <p style="margin-left:0cm; margin-right:0cm; text-align:center">写作</p>
        </td>
        <td style="background-color:white; height:13.5pt; width:57.0pt">
          <p style="margin-left:0cm; margin-right:0cm; text-align:center">写作</p>
        </td>
        <td style="background-color:white; height:13.5pt; width:135.0pt">
          <p style="margin-left:0cm; margin-right:0cm; text-align:center">短文写作</p>
        </td>
        <td style="background-color:white; height:13.5pt; width:57.0pt">
          <p style="margin-left:0cm; margin-right:0cm; text-align:center">1</p>
        </td>
        <td style="background-color:white; height:13.5pt; width:57.0pt">
          <p style="margin-left:0cm; margin-right:0cm; text-align:center">15%</p>
        </td>
        <td style="background-color:white; height:13.5pt; width:57.0pt">
          <p style="margin-left:0cm; margin-right:0cm; text-align:center">30分钟</p>
        </td>
      </tr>
      <tr>
        <td rowspan="3" style="background-color:white; height:13.5pt; width:72.0pt">
          <p style="margin-left:0cm; margin-right:0cm; text-align:center">听力理解</p>
        </td>
        <td style="background-color:white; height:13.5pt; width:57.0pt">
          <p style="margin-left:0cm; margin-right:0cm; text-align:center">长对话</p>
        </td>
        <td style="background-color:white; height:13.5pt; width:135.0pt">
          <p style="margin-left:0cm; margin-right:0cm; text-align:center">选择题（单选题）</p>
        </td>
        <td style="background-color:white; height:13.5pt; width:57.0pt">
          <p style="margin-left:0cm; margin-right:0cm; text-align:center">8</p>
        </td>
        <td style="background-color:white; height:13.5pt; width:57.0pt">
          <p style="margin-left:0cm; margin-right:0cm; text-align:center">8%</p>
        </td>
        <td rowspan="3" style="background-color:white; height:13.5pt; width:57.0pt">
          <p style="margin-left:0cm; margin-right:0cm; text-align:center">30分钟</p>
        </td>
      </tr>
      <tr>
        <td style="background-color:white; height:13.5pt; width:57.0pt">
          <p style="margin-left:0cm; margin-right:0cm; text-align:center">听力篇章</p>
        </td>
        <td style="background-color:white; height:13.5pt; width:135.0pt">
          <p style="margin-left:0cm; margin-right:0cm; text-align:center">选择题（单选题）</p>
        </td>
        <td style="background-color:white; height:13.5pt; width:57.0pt">
          <p style="margin-left:0cm; margin-right:0cm; text-align:center">7</p>
        </td>
        <td style="background-color:white; height:13.5pt; width:57.0pt">
          <p style="margin-left:0cm; margin-right:0cm; text-align:center">7%</p>
        </td>
      </tr>
      <tr>
        <td style="background-color:white; height:13.5pt; width:57.0pt">
          <p style="margin-left:0cm; margin-right:0cm; text-align:center">讲话/报道/讲座</p>
        </td>
        <td style="background-color:white; height:13.5pt; width:135.0pt">
          <p style="margin-left:0cm; margin-right:0cm; text-align:center">选择题（单选题）</p>
        </td>
        <td style="background-color:white; height:13.5pt; width:57.0pt">
          <p style="margin-left:0cm; margin-right:0cm; text-align:center">10</p>
        </td>
        <td style="background-color:white; height:13.5pt; width:57.0pt">
          <p style="margin-left:0cm; margin-right:0cm; text-align:center">20%</p>
        </td>
      </tr>
      <tr>
        <td rowspan="3" style="background-color:white; height:13.5pt; width:72.0pt">
          <p style="margin-left:0cm; margin-right:0cm; text-align:center">阅读理解</p>
        </td>
        <td style="background-color:white; height:13.5pt; width:57.0pt">
          <p style="margin-left:0cm; margin-right:0cm; text-align:center">词汇理解</p>
        </td>
        <td style="background-color:white; height:13.5pt; width:135.0pt">
          <p style="margin-left:0cm; margin-right:0cm; text-align:center">选词填空</p>
        </td>
        <td style="background-color:white; height:13.5pt; width:57.0pt">
          <p style="margin-left:0cm; margin-right:0cm; text-align:center">10</p>
        </td>
        <td style="background-color:white; height:13.5pt; width:57.0pt">
          <p style="margin-left:0cm; margin-right:0cm; text-align:center">5%</p>
        </td>
        <td rowspan="3" style="background-color:white; height:13.5pt; width:57.0pt">
          <p style="margin-left:0cm; margin-right:0cm; text-align:center">40分钟</p>
        </td>
      </tr>
      <tr>
        <td style="background-color:white; height:13.5pt; width:57.0pt">
          <p style="margin-left:0cm; margin-right:0cm; text-align:center">长篇阅读</p>
        </td>
        <td style="background-color:white; height:13.5pt; width:135.0pt">
          <p style="margin-left:0cm; margin-right:0cm; text-align:center">匹配</p>
        </td>
        <td style="background-color:white; height:13.5pt; width:57.0pt">
          <p style="margin-left:0cm; margin-right:0cm; text-align:center">10</p>
        </td>
        <td style="background-color:white; height:13.5pt; width:57.0pt">
          <p style="margin-left:0cm; margin-right:0cm; text-align:center">10%</p>
        </td>
      </tr>
      <tr>
        <td style="background-color:white; height:13.5pt; width:57.0pt">
          <p style="margin-left:0cm; margin-right:0cm; text-align:center">仔细阅读</p>
        </td>
        <td style="background-color:white; height:13.5pt; width:135.0pt">
          <p style="margin-left:0cm; margin-right:0cm; text-align:center">选择题（选择题）</p>
        </td>
        <td style="background-color:white; height:13.5pt; width:57.0pt">
          <p style="margin-left:0cm; margin-right:0cm; text-align:center">10</p>
        </td>
        <td style="background-color:white; height:13.5pt; width:57.0pt">
          <p style="margin-left:0cm; margin-right:0cm; text-align:center">20%</p>
        </td>
      </tr>
      <tr>
        <td style="background-color:white; height:13.5pt; width:72.0pt">
          <p style="margin-left:0cm; margin-right:0cm; text-align:center">翻译</p>
        </td>
        <td style="background-color:white; height:13.5pt; width:57.0pt">&nbsp;</td>
        <td style="background-color:white; height:13.5pt; width:135.0pt">
          <p style="margin-left:0cm; margin-right:0cm; text-align:center">段落翻译</p>
        </td>
        <td style="background-color:white; height:13.5pt; width:57.0pt">
          <p style="margin-left:0cm; margin-right:0cm; text-align:center">1</p>
        </td>
        <td style="background-color:white; height:13.5pt; width:57.0pt">
          <p style="margin-left:0cm; margin-right:0cm; text-align:center">15%</p>
        </td>
        <td style="background-color:white; height:13.5pt; width:57.0pt">
          <p style="margin-left:0cm; margin-right:0cm; text-align:center">30分钟</p>
        </td>
      </tr>
      <tr>
        <td colspan="3" style="background-color:white; height:13.5pt; width:263.25pt">
          <p style="margin-left:0cm; margin-right:0cm; text-align:center">总计</p>
        </td>
        <td style="background-color:white; height:13.5pt; width:57.0pt">
          <p style="margin-left:0cm; margin-right:0cm; text-align:center">57</p>
        </td>
        <td style="background-color:white; height:13.5pt; width:57.0pt">
          <p style="margin-left:0cm; margin-right:0cm; text-align:center">100%</p>
        </td>
        <td style="background-color:white; height:13.5pt; width:57.0pt">
          <p style="margin-left:0cm; margin-right:0cm; text-align:center">130分钟</p>
        </td>
      </tr>
      </tbody>
    </table>



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