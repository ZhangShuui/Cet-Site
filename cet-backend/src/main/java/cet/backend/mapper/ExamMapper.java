package cet.backend.mapper;

import cet.backend.entity.ExamRelated.ExamInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.sql.Timestamp;
import java.util.List;

@Mapper
public interface ExamMapper {
    @Select("select * from soft_examinfo")
    List<ExamInfo> getAllExamInfo();

    @Select("select soft_examinfo.exam_id, start_time, soft_examinfo.test_id from soft_examinfo inner join soft_apply " +
            "on soft_examinfo.exam_id = soft_apply.exam_id " +
            "where user_id = #{user_id}")
    List<ExamInfo> getAllExamTaken(int user_id);
    @Select("select start_time from soft_examinfo where exam_id = #{exam_id} ")
    Timestamp getStartTime(int exam_id);

    @Insert("insert into soft_examinfo (exam_id, start_time, test_id) values (null, #{start_time}, #{test_id})")
    int addExamInfo(Timestamp start_time, int test_id);

    @Select("select test_id from soft_examinfo where exam_id=#{exam_id}")
    int getTestId(int exam_id);
    @Delete("delete from soft_examinfo where exam_id=#{exam_id}")
    int deleteExamInfo(int exam_id);

}
