package cet.backend.entity.ExamRelated;

import lombok.Data;

@Data
public class choiceQuestion {
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

    public choiceQuestion(String topic, String optionA, String optionB, String optionC, String optionD) {
        Topic = topic;
        OptionA = optionA;
        OptionB = optionB;
        OptionC = optionC;
        OptionD = optionD;
    }

    public String combineChoice(){
        String combineRes= Topic+"$$"+OptionA+"$$"+OptionB+"$$"+OptionC+"$$"+OptionD;
        return combineRes;
    }
}
