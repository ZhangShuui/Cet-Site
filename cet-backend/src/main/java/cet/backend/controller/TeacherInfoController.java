package cet.backend.controller;

import cet.backend.entity.RestBean;
import cet.backend.entity.teacher.TeacherInfo;
import cet.backend.service.impl.TeacherInfoServiceImpl;
import jakarta.annotation.Resource;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Validated
@RestController
@RequestMapping("/api/teacher")
public class TeacherInfoController {

    private static final String TEACHERID_REGEX = "^[A-Z]+";

    @Resource
    TeacherInfoServiceImpl service;

    @GetMapping("/get-all-teacher-info")
    RestBean<List<TeacherInfo>> getAllTeacherInfo(){
        return RestBean.success(service.getAllTeacherInfo());
    }

    @PostMapping("/add-teacher-info")
    RestBean<String> addTeacherInfo(@Pattern(regexp = TEACHERID_REGEX) @Length(min = 6, max = 6) @RequestParam("teacher_id") String teacher_id,
                                    @RequestParam("name") String name){
        if (service.addTeacherInfo(name, teacher_id)){
            return RestBean.success("添加教师信息成功");
        }else
            return RestBean.failure(400, "添加教师信息失败");
    }

    @PostMapping("delete-teacher-info")
    RestBean<String> deleteTeacherInfo(@RequestParam("id") int id){
        if (service.deleteTeacherInfo(id))
            return RestBean.success("删除教师信息成功");
        else
            return RestBean.failure(400,"删除教师信息失败");
    }


}
