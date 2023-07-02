package cet.backend.mapper;

import cet.backend.entity.teacher.TeacherInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TeacherMapper {
    @Select("select * from soft_teacher")
    List<TeacherInfo> getAllTeacherInfo();

    @Insert("insert into soft_teacher(id, name, teacher_id) values (#{id}, #{name}, #{teacher_id})")
    int addTeacherInfo(int id, String name, String teacher_id);

    @Delete("delete from soft_teacher where id = #{id}")
    int deleteTeacherInfo(int id);


}
