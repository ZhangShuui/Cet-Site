package cet.backend.service.impl;

import cet.backend.entity.teacher.TeacherInfo;
import cet.backend.mapper.TeacherMapper;
import cet.backend.service.TeacherInfoService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TeacherInfoServiceImpl implements TeacherInfoService {

    @Resource
    TeacherMapper mapper;


    @Override
    public boolean deleteTeacherInfo(int id) {
        return mapper.deleteTeacherInfo(id) > 0;
    }

    @Override
    public boolean addTeacherInfo(String name, String teacher_id) {
        return mapper.addTeacherInfo(-1, name, teacher_id) > 0;
    }

    @Override
    public List<TeacherInfo> getAllTeacherInfo() {
        return mapper.getAllTeacherInfo();
    }
}
