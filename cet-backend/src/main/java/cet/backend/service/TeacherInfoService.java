package cet.backend.service;

import cet.backend.entity.teacher.TeacherInfo;

import java.util.List;

public interface TeacherInfoService {
    boolean deleteTeacherInfo(int id);

    boolean addTeacherInfo(String name, String teacher_id);

    List<TeacherInfo> getAllTeacherInfo();
}
