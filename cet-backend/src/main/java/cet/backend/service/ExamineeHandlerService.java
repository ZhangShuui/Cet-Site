package cet.backend.service;

import cet.backend.entity.ExamRelated.AnswerInfo;
import cet.backend.entity.ExamRelated.ExamInfo;
import cet.backend.entity.ExamRelated.PaperInfo;
import cet.backend.entity.apply.ApplyInfo;

import java.util.List;

public interface ExamineeHandlerService {
    boolean AmIVerified(int user_id, int exam_id);

    PaperInfo ShowMeThePaper(int user_id, int exam_id);

    boolean IsTimeOut(int exam_id);

    ExamInfo FindActiveExam();

    int SubmitAnswers(int exam_id, int user_id, String stu_choiceW1,
                      String stu_choiceW2, String stu_choiceW3,
                      String stu_choiceW4, String stu_choiceW5,
                      String stu_choiceW6, String stu_choiceW7,
                      String stu_choiceW8, String stu_choiceW9,
                      String stu_choiceW10, String translationW,
                      String writingW);
    int QueryOneExamResult(int user_id, int exam_id);

    List<ApplyInfo> QueryExamsResults(int user_id);
}
