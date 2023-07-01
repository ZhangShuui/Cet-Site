package cet.backend.service.impl;

import cet.backend.entity.ExamRelated.AnswerInfo;
import cet.backend.entity.ExamRelated.ExamInfo;
import cet.backend.entity.ExamRelated.PaperInfo;
import cet.backend.entity.apply.ApplyInfo;
import cet.backend.mapper.ExamineeMapper;
import cet.backend.service.ExamineeHandlerService;
import jakarta.annotation.Resource;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;


@Service
public class ExamineeHandlerServiceImpl implements ExamineeHandlerService {
    @Resource
    ExamineeMapper mapper;
    @Override
    public boolean AmIVerified(int user_id, int exam_id) {
        List<Integer> candidates = mapper.GetCandidates(exam_id);
        if(candidates.contains(user_id)) {
            return true;
        }else {
            return false;
        }
    }

    @Override
    public PaperInfo ShowMeThePaper(int user_id, int exam_id) {
        return mapper.GetPaper(user_id, exam_id);
    }

    @Override
    public boolean IsTimeOut(int exam_id) {
        Timestamp start_time =  mapper.GetStartTime(exam_id);
        Date currentTime = new Date();
        Timestamp curr_time = new Timestamp(currentTime.getTime());
        long diffInMilli = curr_time.getTime() - start_time.getTime();
        long diffInMinutes = TimeUnit.MILLISECONDS.toMinutes(diffInMilli);
        if(diffInMinutes >= 135) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public ExamInfo FindActiveExam() {
        List<ExamInfo> exams = mapper.GetAllExams();
        Date currentTime = new Date();
        Timestamp curr_time = new Timestamp(currentTime.getTime());
        for (ExamInfo exam : exams) {
            long diffInMilli = curr_time.getTime() - exam.getStart_time().getTime();
            long diffInMinutes = TimeUnit.MILLISECONDS.toMinutes(diffInMilli);
            if (diffInMinutes < 135 && diffInMinutes >= 0) {
                return exam;
            }
        }
        return null;
    }

    @Override
    public int SubmitAnswers(int exam_id, int user_id, String stu_choiceW1,
                             String stu_choiceW2, String stu_choiceW3,
                             String stu_choiceW4, String stu_choiceW5,
                             String stu_choiceW6, String stu_choiceW7,
                             String stu_choiceW8, String stu_choiceW9,
                             String stu_choiceW10, String translationW,
                             String writingW) {
        int res = mapper.SubmitAnswers(exam_id, user_id, stu_choiceW1,
                stu_choiceW2, stu_choiceW3, stu_choiceW4, stu_choiceW5,
                stu_choiceW6, stu_choiceW7, stu_choiceW8, stu_choiceW9,
                stu_choiceW10, translationW, writingW);
        return res;
    }

    @Override
    public int QueryOneExamResult(int user_id, int exam_id) {
        return mapper.queryOneExamResult(user_id,exam_id);
    }

    @Override
    public List<ApplyInfo> QueryExamsResults(int user_id) {
        return mapper.queryExamsResult(user_id);
    }
}
