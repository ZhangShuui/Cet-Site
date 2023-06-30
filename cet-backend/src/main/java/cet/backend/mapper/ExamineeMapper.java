package cet.backend.mapper;

import cet.backend.entity.ExamRelated.AnswerInfo;
import cet.backend.entity.ExamRelated.ExamInfo;
import cet.backend.entity.ExamRelated.PaperInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.sql.Timestamp;
import java.util.List;
@Mapper
public interface ExamineeMapper {
    //进入考试页面后,后台检查次考生是否有考试资格
    @Select("select user_id from soft_apply where exam_id = #{exam_id} and payment_status ='已支付' ")
    List<Integer> GetCandidates(int exam_id);
    @Select("select * from soft_paper where test_id = #{test_id}")
    PaperInfo GetPaper(int test_id);
    @Select("select start_time from soft_examinfo where exam_id = #{exam_id}")
    Timestamp GetStartTime(int exam_id);
    @Select("select * from soft_examinfo")
    List<ExamInfo> GetAllExams();

    @Insert("insert into soft_answer (exam_id, user_id, stu_choiceW1, stu_choiceW2, stu_choiceW3, stu_choiceW4, stu_choiceW5, stu_choiceW6, stu_choiceW7, stu_choiceW8, stu_choiceW9, stu_choiceW10, translationW, writingW) " +
            "values (#{exam_id}, #{user_id}, #{stu_choiceW1}, #{stu_choiceW2}, #{stu_choiceW3}, #{stu_choiceW4}, #{stu_choiceW5}, #{stu_choiceW6}, #{stu_choiceW7}, #{stu_choiceW8}, #{stu_choiceW9}, #{stu_choiceW10}, #{translationW}, #{writingW})")
    int SubmitAnswers(int exam_id, int user_id, String stu_choiceW1,
                      String stu_choiceW2, String stu_choiceW3,
                      String stu_choiceW4, String stu_choiceW5,
                      String stu_choiceW6, String stu_choiceW7,
                      String stu_choiceW8, String stu_choiceW9,
                      String stu_choiceW10, String translationW,
                      String writingW);
}
