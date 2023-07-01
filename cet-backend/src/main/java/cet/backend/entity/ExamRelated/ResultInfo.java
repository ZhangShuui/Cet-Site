package cet.backend.entity.ExamRelated;

import lombok.Data;

import java.sql.Timestamp;
@Data
public class ResultInfo {
    int exam_id;//考试编号
    Timestamp start_time;//开始考试时间
    int test_id;//试卷编号
    String application_time;
    int score;
    int user_id;
}
