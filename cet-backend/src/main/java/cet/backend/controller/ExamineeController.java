package cet.backend.controller;

import cet.backend.entity.ExamRelated.AnswerInfo;
import cet.backend.entity.ExamRelated.ExamInfo;
import cet.backend.entity.ExamRelated.PaperInfo;
import cet.backend.entity.ExamRelated.SplitedPaper;
import cet.backend.entity.RestBean;
import cet.backend.entity.apply.ApplyInfo;
import cet.backend.service.impl.ExamineeHandlerServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/examinee")
public class ExamineeController {
    @Resource
    ExamineeHandlerServiceImpl examineeHandlerService;

    @PostMapping("/check-eligibility")//检验学生的报考信息
    public RestBean<Boolean> CheckEligibility(@RequestParam("user_id") int user_id,
                                              @RequestParam("exam_id") int exam_id) {//前端向后端发送请求,检查我是否具备本场考试资格

        if(examineeHandlerService.AmIVerified(user_id,exam_id)) {
            return RestBean.success(true);
        }else {
            return RestBean.failure(400 , false);
        }
    }

    @PostMapping("/get-paper")
    public RestBean<SplitedPaper> GetPaper(@RequestParam("user_id") int user_id, @RequestParam("exam_id") int exam_id) {
        //前端向后端请求试卷
        System.out.println(user_id);
        System.out.println(exam_id);
        PaperInfo paper = examineeHandlerService.ShowMeThePaper(user_id, exam_id);

        if(paper != null) {
            SplitedPaper splitedPaper = splitpaper(paper);
            System.out.println(splitedPaper);
            return RestBean.success(splitedPaper);
        }else {
            System.out.println("获取到了空试卷,可能数据库里没有数据");
            return RestBean.failure(400, null);
        }
    }

    private SplitedPaper splitpaper(PaperInfo paper) {
        SplitedPaper res = new SplitedPaper(paper);
        return res;
    }

    @PostMapping("/get-timeout")
    public RestBean<Boolean> IsTimeOut(@RequestParam("exam_id") int exam_id) {
        Boolean res = examineeHandlerService.IsTimeOut(exam_id);
        if(res) {
            return RestBean.success(true);
        }else {
            return RestBean.failure(400,false);
        }
    }

    @GetMapping("/get-act-exam")//在verify.vue中根据当前是否有正在进行的考试并将此考试id与学生报名信息比较
    public RestBean<ExamInfo> GetActExam() {
        ExamInfo exam = examineeHandlerService.FindActiveExam();
        if(exam != null){
            return RestBean.success(exam);
        } else {
            return RestBean.failure(400,null);
        }
    }

    @PostMapping("/query-one-result")
    public RestBean<Integer> QueryExamResult(@RequestParam("user_id") int user_id,
                                             @RequestParam("exam_id") int exam_id) {
        int res = examineeHandlerService.QueryOneExamResult(user_id,exam_id);
        if(res != -1) {
            return RestBean.success(res);
        } else {
            return RestBean.failure(400,-1);
        }
    }

    @PostMapping("/query-results")
    public RestBean<List<ApplyInfo>> QueryExamResult(@RequestParam("user_id") int user_id) {
        List<ApplyInfo> res = examineeHandlerService.QueryExamsResults(user_id);
        if(res.size() > 0) {
            return RestBean.success(res);
        } else {
            return RestBean.failure(400,null);
        }
    }

    @PostMapping("/submit-answers")
    public RestBean<Integer> SubmitAnswers(@RequestParam("exam_id") int exam_id,
                                       @RequestParam("user_id") int user_id,
                                       @RequestParam("stu_choiceW1") String stu_choiceW1,
                                       @RequestParam("stu_choiceW2") String stu_choiceW2,
                                       @RequestParam("stu_choiceW3") String stu_choiceW3,
                                       @RequestParam("stu_choiceW4") String stu_choiceW4,
                                       @RequestParam("stu_choiceW5") String stu_choiceW5,
                                       @RequestParam("stu_choiceW6") String stu_choiceW6,
                                       @RequestParam("stu_choiceW7") String stu_choiceW7,
                                       @RequestParam("stu_choiceW8") String stu_choiceW8,
                                       @RequestParam("stu_choiceW9") String stu_choiceW9,
                                       @RequestParam("stu_choiceW10") String stu_choiceW10,
                                       @RequestParam("translationW") String translationW,
                                       @RequestParam("writingW") String writingW) {
        AnswerInfo answerInfo = new AnswerInfo(exam_id, user_id, stu_choiceW1,
                stu_choiceW2, stu_choiceW3, stu_choiceW4, stu_choiceW5,
                stu_choiceW6, stu_choiceW7, stu_choiceW8, stu_choiceW9,
                stu_choiceW10, translationW, writingW);
        int res = examineeHandlerService.SubmitAnswers(exam_id, user_id, stu_choiceW1,
                stu_choiceW2, stu_choiceW3, stu_choiceW4, stu_choiceW5,
                stu_choiceW6, stu_choiceW7, stu_choiceW8, stu_choiceW9,
                stu_choiceW10, translationW, writingW);
        if(res == 1) {
            return RestBean.success(res);
        } else {
            return RestBean.failure(400,-1);
        }
    }
}
