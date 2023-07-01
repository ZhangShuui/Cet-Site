package cet.backend.entity.ExamRelated;

import lombok.Data;

@Data
public class PaperInfoForGet {
    int test_id;

    public PaperInfoForGet(int test_id) {
        this.test_id = test_id;
    }
}
