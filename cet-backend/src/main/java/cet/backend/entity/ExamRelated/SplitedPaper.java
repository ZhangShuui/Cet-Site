package cet.backend.entity.ExamRelated;
import lombok.Data;

import java.util.ArrayList;

@Data
public class SplitedPaper {
    int test_id;
    String readingQ1;
    String readingQ2;
    String translationQ;
    String writingQ;
    String choiceW1;
    String choiceW2;
    String choiceW3;
    String choiceW4;
    String choiceW5;
    String choiceW6;
    String choiceW7;
    String choiceW8;
    String choiceW9;
    String choiceW10;
    private ArrayList<choiceQuestion> q;

    public SplitedPaper(PaperInfo paper) {
        test_id = paper.test_id;
        readingQ1 = paper.readingQ1;
        readingQ2 = paper.readingQ2;
        translationQ = paper.translationQ;
        writingQ = paper.writingQ;
        choiceW1 = paper.choiceW1;
        choiceW2 = paper.choiceW2;
        choiceW3 = paper.choiceW3;
        choiceW4 = paper.choiceW4;
        choiceW5 = paper.choiceW5;
        choiceW6 = paper.choiceW6;
        choiceW7 = paper.choiceW7;
        choiceW8 = paper.choiceW8;
        choiceW9 = paper.choiceW9;
        choiceW10 = paper.choiceW10;
        q = new ArrayList<>();
        for(int i = 1; i <= 10; i ++) {
            choiceQuestion choiceQ = new choiceQuestion(paper.getChoiceI(i));
            q.add(choiceQ);
        }
    }

    @Data
    private class choiceQuestion {
        String Topic;
        String OptionA;
        String OptionB;
        String OptionC;
        String OptionD;

        public choiceQuestion(String choice) {
            String[] parts = choice.split("\\$\\$");
            Topic = parts[0];
            OptionA = parts[1];
            OptionB = parts[2];
            OptionC = parts[3];
            OptionD = parts[4];
        }
    }
}
