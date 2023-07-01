package cet.backend.entity.ExamRelated;

import lombok.Data;

@Data
public class AnswerInfoForGet {
    int exam_id;
    int user_id;

    Boolean grading_status;

    public AnswerInfoForGet(int exam_id, int user_id,Boolean grading_status) {
        this.exam_id = exam_id;
        this.user_id = user_id;
        this.grading_status = grading_status;
    }
}
