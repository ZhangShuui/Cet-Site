package cet.backend.controller;

import cet.backend.entity.ExamRelated.PaperInfo;
import cet.backend.entity.RestBean;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import cet.backend.service.impl.PaperHandleServicelmpl;


@RestController
@RequestMapping("/api/paper")
public class PaperController {
    @Resource
    PaperHandleServicelmpl paperHandleServicelmpl;

    @PostMapping("/create_paper")       //新建试卷
    public RestBean<String> CreatePaper(@RequestParam("test_id") int test_id,
                                        @RequestParam("choiceQ1") String choiceQ1,
                                        @RequestParam("choiceW1") String choiceW1,
                                        @RequestParam("choiceQ2") String choiceQ2,
                                        @RequestParam("choiceW2") String choiceW2,
                                        @RequestParam("choiceQ3") String choiceQ3,
                                        @RequestParam("choiceW3") String choiceW3,
                                        @RequestParam("choiceQ4") String choiceQ4,
                                        @RequestParam("choiceW4") String choiceW4,
                                        @RequestParam("choiceQ5") String choiceQ5,
                                        @RequestParam("choiceW5") String choiceW5,
                                        @RequestParam("readingQ1") String readingQ1,
                                        @RequestParam("readingQ2") String readingQ2,
                                        @RequestParam("choiceQ6") String choiceQ6,
                                        @RequestParam("choiceW6") String choiceW6,
                                        @RequestParam("choiceQ7") String choiceQ7,
                                        @RequestParam("choiceW7") String choiceW7,
                                        @RequestParam("choiceQ8") String choiceQ8,
                                        @RequestParam("choiceW8") String choiceW8,
                                        @RequestParam("choiceQ9") String choiceQ9,
                                        @RequestParam("choiceW9") String choiceW9,
                                        @RequestParam("choiceQ10") String choiceQ10,
                                        @RequestParam("choiceW10") String choiceW10,
                                        @RequestParam("translationQ") String translationQ,
                                        @RequestParam("writingQ") String writingQ
                                        ) {

        PaperInfo paperInfo = new PaperInfo(test_id, choiceQ1, choiceW1, choiceQ2, choiceW2, choiceQ3, choiceW3, choiceQ4,
                choiceW4, choiceQ5, choiceW5, choiceQ6, choiceW6, choiceQ7, choiceW7, choiceQ8, choiceW8, choiceQ9,
                choiceW9, choiceQ10, choiceW10, translationQ, writingQ);
        int res = paperHandleServicelmpl.createPaper(test_id, choiceQ1, choiceW1, choiceQ2, choiceW2, choiceQ3, choiceW3, choiceQ4,
                choiceW4, choiceQ5, choiceW5, choiceQ6, choiceW6, choiceQ7, choiceW7, choiceQ8, choiceW8, choiceQ9,
                choiceW9, choiceQ10, choiceW10, translationQ, writingQ);
        if(res == 1) {
            return RestBean.success("创建试卷成功");
        } else {
            return RestBean.failure(400,"创建试卷失败");
        }
    }
}
