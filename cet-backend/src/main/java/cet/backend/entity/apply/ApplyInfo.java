package cet.backend.entity.apply;

import lombok.Data;

@Data
public class ApplyInfo {
    int exam_id;
    int user_id;
    String payment_status;
    String application_time;
    int score;
    int test_id;
}
