package cet.backend.service.impl;

import cet.backend.service.ApplyHandleService;
import org.springframework.stereotype.Service;

@Service
public class ApplyHandleServiceImpl implements ApplyHandleService {
    @Override
    public String addApplyInfo(int exam_id, int user_id, String payment_status, String application_time, int score, int test_id) {
        return null;
    }

    @Override
    public String showAllApplyInfo() {
        return null;
    }

    @Override
    public boolean deleteApplyInfo(int exam_id, int user_id) {
        return false;
    }
}
