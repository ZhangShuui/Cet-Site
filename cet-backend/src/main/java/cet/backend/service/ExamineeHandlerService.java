package cet.backend.service;

import cet.backend.entity.ExamRelated.*;
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

    List<ResultInfo> QueryExamsResults(int user_id);

    List<AnswerInfoForGet> getAllAnswerInfo();

    AnswerInfo getCurrentAnswer(int exam_id,int user_id);

    int getTestId(int exam_id,int user_id);

    ChoiceAnswers getChoiceAnswers(int exam_id, int user_id);

    int updateScore(int score,int exam_id,int user_id);

    int updateGradingStatus(String grading_status,int exam_id,int user_id);
}
