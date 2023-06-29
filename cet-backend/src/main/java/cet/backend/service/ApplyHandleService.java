package cet.backend.service;


import cet.backend.entity.apply.ApplyInfo;

import java.util.List;

public interface ApplyHandleService {
    String addApplyInfo(int exam_id, int user_id, String payment_status, String application_time, int score, int test_id);

    boolean applyTestByUser(int exam_id, int user_id);

    List<ApplyInfo> showAllApplyInfo();

    boolean deleteApplyInfo(int exam_id, int user_id);

    boolean payForApply(int exam_id, int user_id);

}
