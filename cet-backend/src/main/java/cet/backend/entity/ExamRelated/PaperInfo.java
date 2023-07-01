package cet.backend.entity.ExamRelated;

import lombok.Data;

@Data
public class PaperInfo {
    int test_id;
    String choiceQ1;
    String choiceW1;
    String choiceQ2;
    String choiceW2;
    String choiceQ3;
    String choiceW3;
    String choiceQ4;
    String choiceW4;
    String choiceQ5;
    String choiceW5;
    String choiceQ6;
    String choiceW6;
    String choiceQ7;
    String choiceW7;
    String choiceQ8;
    String choiceW8;
    String choiceQ9;
    String choiceW9;
    String choiceQ10;
    String choiceW10;
    String translationQ;
    String writingQ;

    public PaperInfo(int test_id, String choiceQ1, String choiceW1, String choiceQ2,
                     String choiceW2, String choiceQ3, String choiceW3, String choiceQ4,
                     String choiceW4, String choiceQ5, String choiceW5, String choiceQ6,
                     String choiceW6, String choiceQ7, String choiceW7, String choiceQ8,
                     String choiceW8, String choiceQ9, String choiceW9, String choiceQ10,
                     String choiceW10, String translationQ, String writingQ) {
        this.test_id = test_id;
        this.choiceQ1 = choiceQ1;
        this.choiceW1 = choiceW1;
        this.choiceQ2 = choiceQ2;
        this.choiceW2 = choiceW2;
        this.choiceQ3 = choiceQ3;
        this.choiceW3 = choiceW3;
        this.choiceQ4 = choiceQ4;
        this.choiceW4 = choiceW4;
        this.choiceQ5 = choiceQ5;
        this.choiceW5 = choiceW5;
        this.choiceQ6 = choiceQ6;
        this.choiceW6 = choiceW6;
        this.choiceQ7 = choiceQ7;
        this.choiceW7 = choiceW7;
        this.choiceQ8 = choiceQ8;
        this.choiceW8 = choiceW8;
        this.choiceQ9 = choiceQ9;
        this.choiceW9 = choiceW9;
        this.choiceQ10 = choiceQ10;
        this.choiceW10 = choiceW10;
        this.translationQ = translationQ;
        this.writingQ = writingQ;
    }

    public PaperInfo(int test_id) {
        this.test_id = test_id;
    }

}
