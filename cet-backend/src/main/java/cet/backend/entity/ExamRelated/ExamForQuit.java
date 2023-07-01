package cet.backend.entity.ExamRelated;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
public class ExamForQuit {
    int exam_id;//考试编号
    Timestamp start_time;//开始考试时间
    String payment_status;
    Timestamp ddl;//报考截止

}
