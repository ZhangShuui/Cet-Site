package cet.backend.entity.ExamRelated;

import lombok.Data;

@Data
public class AnswerInfo {
    int exam_id;
    int user_id;
    String stu_choiceW1;
    String stu_choiceW2;
    String stu_choiceW3;
    String stu_choiceW4;
    String stu_choiceW5;
    String stu_choiceW6;
    String stu_choiceW7;
    String stu_choiceW8;
    String stu_choiceW9;
    String stu_choiceW10;
    String translationW;
    String writingW;

    public AnswerInfo(int exam_id, int user_id, String stu_choiceW1,
                      String stu_choiceW2, String stu_choiceW3,
                      String stu_choiceW4, String stu_choiceW5,
                      String stu_choiceW6, String stu_choiceW7,
                      String stu_choiceW8, String stu_choiceW9,
                      String stu_choiceW10, String translationW,
                      String writingW) {
        this.exam_id = exam_id;
        this.user_id = user_id;
        this.stu_choiceW1 = stu_choiceW1;
        this.stu_choiceW2 = stu_choiceW2;
        this.stu_choiceW3 = stu_choiceW3;
        this.stu_choiceW4 = stu_choiceW4;
        this.stu_choiceW5 = stu_choiceW5;
        this.stu_choiceW6 = stu_choiceW6;
        this.stu_choiceW7 = stu_choiceW7;
        this.stu_choiceW8 = stu_choiceW8;
        this.stu_choiceW9 = stu_choiceW9;
        this.stu_choiceW10 = stu_choiceW10;
        this.translationW = translationW;
        this.writingW = writingW;
    }
}
