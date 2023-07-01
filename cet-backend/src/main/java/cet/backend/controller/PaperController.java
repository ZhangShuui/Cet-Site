package cet.backend.controller;

import cet.backend.entity.ExamRelated.PaperInfo;
import cet.backend.entity.ExamRelated.choiceQuestion;
import cet.backend.entity.RestBean;
import jakarta.annotation.Resource;
import org.springframework.data.redis.listener.Topic;
import org.springframework.web.bind.annotation.*;
import cet.backend.service.impl.PaperHandleServiceImpl;

import java.util.ArrayList;


@RestController
@RequestMapping("/api/paper")
public class PaperController {
    @Resource
    PaperHandleServiceImpl paperHandleServiceimpl;


    @PostMapping("/create-choice")
    public RestBean<Boolean> CreateChoice( @RequestParam("Topic") String Topic,
                                           @RequestParam("OptionA") String OptionA,
                                           @RequestParam("OptionB") String OptionB,
                                           @RequestParam("OptionC") String OptionC,
                                           @RequestParam("OptionD") String OptionD){

        choiceQuestion choiceQ = new choiceQuestion(Topic,OptionA,OptionB,OptionC,OptionD);
        String combineC = choiceQ.combineChoice();
        int choiceNum = paperHandleServiceimpl.addChoice(combineC);
        if(choiceNum>0) {
            return RestBean.success(true);
        }else {
            return RestBean.failure(400,false);
        }

    }


    @PostMapping("/create-paper")       //新建试卷
    public RestBean<String> CreatePaper(@RequestParam("choiceW1") String choiceW1,
                                           @RequestParam("choiceW2") String choiceW2,
                                           @RequestParam("choiceW3") String choiceW3,
                                           @RequestParam("choiceW4") String choiceW4,
                                           @RequestParam("choiceW5") String choiceW5,
                                           @RequestParam("readingQ1") String readingQ1,
                                           @RequestParam("readingQ2") String readingQ2,
                                           @RequestParam("choiceW6") String choiceW6,
                                           @RequestParam("choiceW7") String choiceW7,
                                           @RequestParam("choiceW8") String choiceW8,
                                           @RequestParam("choiceW9") String choiceW9,
                                           @RequestParam("choiceW10") String choiceW10,
                                           @RequestParam("translationQ") String translationQ,
                                           @RequestParam("writingQ") String writingQ
    ) {
        ArrayList<String> choices = paperHandleServiceimpl.getChoices();
        if(choices.size()!=10){
            return RestBean.failure(400,"创建试卷失败");
        }
        PaperInfo paperInfo = new PaperInfo(choices.get(0), choiceW1, choices.get(1), choiceW2, choices.get(2), choiceW3, choices.get(3),
                choiceW4, choices.get(4), choiceW5, readingQ1, readingQ2, choices.get(5), choiceW6, choices.get(6), choiceW7, choices.get(7), choiceW8, choices.get(8),
                choiceW9, choices.get(9), choiceW10, translationQ, writingQ);
        int res = paperHandleServiceimpl.createPaper(choices.get(0), choiceW1, choices.get(1), choiceW2, choices.get(2), choiceW3, choices.get(3),
                choiceW4, choices.get(4), choiceW5, readingQ1, readingQ2, choices.get(5), choiceW6, choices.get(6), choiceW7, choices.get(7), choiceW8, choices.get(8),
                choiceW9, choices.get(9), choiceW10, translationQ, writingQ);
        paperHandleServiceimpl.clearChoices();
        if(res == 1) {
            return RestBean.success("创建试卷成功");
        } else {
            return RestBean.failure(400,"创建试卷失败");
        }
    }

    @GetMapping("/cancle")
    public RestBean<Boolean> cancleCreate(){
        paperHandleServiceimpl.clearChoices();
        if(paperHandleServiceimpl.getChoicesSize()==0){
            return RestBean.success(true);
        }else {
            return RestBean.failure(400,false);
        }
    }

    @PostMapping("/create-paper-old")       //新建试卷
    public RestBean<String> CreatePaperOld(@RequestParam("test_id") int test_id,
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

        PaperInfo paperInfo = new PaperInfo(choiceQ1, choiceW1, choiceQ2, choiceW2, choiceQ3, choiceW3, choiceQ4,
                choiceW4, choiceQ5, choiceW5, readingQ1, readingQ2, choiceQ6, choiceW6, choiceQ7, choiceW7, choiceQ8, choiceW8, choiceQ9,
                choiceW9, choiceQ10, choiceW10, translationQ, writingQ);
        int res = paperHandleServiceimpl.createPaper(choiceQ1, choiceW1, choiceQ2, choiceW2, choiceQ3, choiceW3, choiceQ4,
                choiceW4, choiceQ5, choiceW5, readingQ1, readingQ2, choiceQ6, choiceW6, choiceQ7, choiceW7, choiceQ8, choiceW8, choiceQ9,
                choiceW9, choiceQ10, choiceW10, translationQ, writingQ);
        if(res == 1) {
            return RestBean.success("创建试卷成功");
        } else {
            return RestBean.failure(400,"创建试卷失败");
        }
    }
}
