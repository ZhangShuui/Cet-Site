package cet.backend.mapper;

import cet.backend.entity.ExamRelated.*;
import cet.backend.entity.apply.ApplyInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.sql.Timestamp;
import java.util.List;
@Mapper
public interface ExamineeMapper {
    //进入考试页面后,后台检查次考生是否有考试资格
    @Select("select user_id from soft_apply where exam_id = #{exam_id} and payment_status ='已支付' ")
    List<Integer> GetCandidates(int exam_id);
    @Select("select * from soft_paper where test_id = (select test_id from soft_apply where user_id = #{user_id} and exam_id = #{exam_id})")
    PaperInfo GetPaper(int user_id, int exam_id);
    @Select("select start_time from soft_examinfo where exam_id = #{exam_id}")
    Timestamp GetStartTime(int exam_id);
    @Select("select * from soft_examinfo")
    List<ExamInfo> GetAllExams();

    @Insert("insert into soft_answer (exam_id, user_id, stu_choiceW1, stu_choiceW2, stu_choiceW3, stu_choiceW4, stu_choiceW5, stu_choiceW6, stu_choiceW7, stu_choiceW8, stu_choiceW9, stu_choiceW10, translationW, writingW, grading_status) " +
            "values (#{exam_id}, #{user_id}, #{stu_choiceW1}, #{stu_choiceW2}, #{stu_choiceW3}, #{stu_choiceW4}, #{stu_choiceW5}, #{stu_choiceW6}, #{stu_choiceW7}, #{stu_choiceW8}, #{stu_choiceW9}, #{stu_choiceW10}, #{translationW}, #{writingW},'未完成')")
    int SubmitAnswers(int exam_id, int user_id, String stu_choiceW1,
                      String stu_choiceW2, String stu_choiceW3,
                      String stu_choiceW4, String stu_choiceW5,
                      String stu_choiceW6, String stu_choiceW7,
                      String stu_choiceW8, String stu_choiceW9,
                      String stu_choiceW10, String translationW,
                      String writingW);
    @Select("select score from soft_apply where exam_id = #{exam_id} and user_id = #{user_id}")
    int queryOneExamResult(int user_id, int exam_id);
    @Select("select soft_apply.exam_id, start_time, soft_apply.test_id, application_time, score, user_id from soft_apply join soft_examinfo on soft_apply.exam_id = soft_examinfo.exam_id where user_id = #{user_id}")
    List<ResultInfo> queryExamsResult(int user_id);

    @Select("select exam_id,user_id, grading_status from soft_answer")
    List<AnswerInfoForGet> getAllAnswerInfo();

    @Select("select * from soft_answer where exam_id = #{exam_id} and user_id = #{user_id}")
    AnswerInfo getAnswerInfo(int exam_id, int user_id);

    @Select("select test_id from soft_apply where exam_id = #{exam_id} and user_id = #{user_id}")
    int getTestId(int exam_id, int user_id);

    @Select("select choiceW1,choiceW2,choiceW3,choiceW4,choiceW5,choiceW6,choiceW7,choiceW8,choiceW9,choiceW10 from soft_paper where test_id = #{test_id}")
    ChoiceAnswers getChoiceAnswers(int test_id);

    @Update("update soft_apply set score=#{score} where exam_id=#{exam_id} and user_id=#{user_id}")
    int updateScore(int score,int exam_id,int user_id);

    @Update("update soft_answer set grading_status=#{grading_status} where exam_id=#{exam_id} and user_id=#{user_id}")
    int updateGradingStatus(String grading_status,int exam_id,int user_id);
}
