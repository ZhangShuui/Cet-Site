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
    String readingQ1;
    String readingQ2;
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

    public String getChoiceI(int number) {
        switch (number) {
            case 1:
                return choiceQ1;
            case 2:
                return choiceQ2;
            case 3:
                return choiceQ3;
            case 4:
                return choiceQ4;
            case 5:
                return choiceQ5;
            case 6:
                return choiceQ6;
            case 7:
                return choiceQ7;
            case 8:
                return choiceQ8;
            case 9:
                return choiceQ9;
            case 10:
                return choiceQ10;
            default:
                throw new IllegalArgumentException("Invalid number: " + number);
        }
    }
}
