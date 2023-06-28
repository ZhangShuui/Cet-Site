package cet.backend.service;




public interface ApplyHandleService {
    String addApplyInfo(int exam_id, int user_id, String payment_status, String application_time, int score, int test_id);

    String showAllApplyInfo();

    boolean deleteApplyInfo(int exam_id, int user_id);

    //TODO: 加上缴费函数


}
