package cet.backend.service;

import cet.backend.entity.ExamRelated.ExamInfo;

import java.sql.Timestamp;
import java.util.List;

public interface ExamInfoHandleService {
    List<ExamInfo> getAllExamInfo();

    List<ExamInfo> getExamInfoCanTake(int user_id);

    List<ExamInfo> getExamInfoCanQuit(int user_id);

    Timestamp getExamStartTime(int exam_id);
}
