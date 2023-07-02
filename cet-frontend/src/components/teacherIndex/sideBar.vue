<script setup>

import {Avatar, EditPen, Menu, Document, Refresh} from "@element-plus/icons-vue";
import router from "@/router";

const handleSelectGrading = () => {
  router.push('/teacher/index/answerList');
  console.log(router.currentRoute);
}

const handleSelectPaper = () => {
  router.push('/teacher/index/paperList');
  console.log(router.currentRoute);
}

const handleSelectExamInfo = () => {
  router.push('/teacher/index/examList');
  console.log(router.currentRoute);
}

const handleSelectLogin = () =>{
  router.push('/teacher/index/');
  console.log(router.currentRoute);
}

const handleSelectApplyInfo = () => {
  router.push('/teacher/index/applyInfo')
  console.log(router.currentRoute);
}

const handleSelectTeacherInfo = () => {
  router.push('/teacher/index/teacherInfo')
}

</script>

<template>
  <el-container direction="horizontal" style="height: 40px; background-color: #475669">
    <img src="../../figs/cetlogo.png"
         style="width: 20px; height: 20px; margin: 11px" alt="sss"/>
    <el-text style="color: white">
      教师管理系统
    </el-text>
  </el-container>
  <el-menu
      active-text-color="#ffd04b"
      background-color= "#475669"
      class="el-menu-vertical-demo"
      text-color="#fff"
      style="width: 201px;"
  >
    <el-divider style="margin-top: 5px; stroke-dashoffset: 10px" />
    <el-sub-menu index="1">
      <template #title>
        <el-icon><Avatar/></el-icon>
        <span>用户信息管理</span>
      </template>
      <el-menu-item-group title="CET-6">
        <el-menu-item index="1-1" @click="handleSelectApplyInfo">学生报考信息</el-menu-item>
        <el-menu-item index="1-2" @click="handleSelectTeacherInfo">教师信息</el-menu-item>
      </el-menu-item-group>
    </el-sub-menu>
    <el-menu-item index="examInfo" @click="handleSelectExamInfo">
      <el-icon><EditPen/></el-icon>
      <span>考试安排信息</span>
    </el-menu-item>
    <el-menu-item index="gradingPapers" @click="handleSelectGrading">
      <el-icon><Menu /></el-icon>
      <span>考试阅卷系统</span>
    </el-menu-item>
    <el-menu-item index="paper" @click="handleSelectPaper">
      <el-icon><Document /></el-icon>
      <span>考试试题管理</span>
    </el-menu-item>
    <el-menu-item index="login" @click="handleSelectLogin">
      <el-icon><Refresh /></el-icon>
      <span>返回首页</span>
    </el-menu-item>
  </el-menu>
</template>

<style scoped>

</style>