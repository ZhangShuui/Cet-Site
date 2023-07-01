package cet.backend.entity.ExamRelated;

import lombok.Data;

@Data
public class AnswerInfoForGet {
    int exam_id;
    int user_id;

    public AnswerInfoForGet(int exam_id, int user_id) {
        this.exam_id = exam_id;
        this.user_id = user_id;
    }
}
