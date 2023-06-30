package cet.backend.controller;

import cet.backend.entity.RestBean;
import cet.backend.entity.apply.ApplyInfo;
import cet.backend.service.impl.ApplyHandleServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/*
* 关于报考申请信息的请求处理控制器
* url设置为"/api/apply"
* */
@RestController
@RequestMapping("/api/apply")
public class ApplyInfoController {

    @Resource
    ApplyHandleServiceImpl service;

    @PostMapping("/payment-submit")
    public RestBean<String> paymentSubmit(@RequestParam("exam_id") int exam_id,
                                          @RequestParam("user_id") int user_id){
        if (service.payForApply(exam_id, user_id)){
            return RestBean.success("支付成功");
        }else
            return RestBean.failure(400 , "已完成支付，请勿重复支付");
    }

    @PostMapping("/apply-for-test")
    public RestBean<String> applyFotTest(@RequestParam("exam_id") int exam_id,
                                         @RequestParam("user_id") int user_id){
        if (service.applyTestByUser(exam_id, user_id)){
            return RestBean.success("申请考试成功");
        }else {
            return RestBean.failure(400, "申请失败");
        }
    }

    @PostMapping("/find-apply-info")
    public RestBean<List<ApplyInfo>> findApplyInfo(@RequestParam("exam_id") int exam_id,
                                                   @RequestParam("user_id") int user_id){

        if (exam_id == -1 && user_id == -1){
            return RestBean.success(service.showAllApplyInfo());
        }else if(user_id == -1){
            return RestBean.success(service.findByExamId(exam_id));
        }else if(exam_id == -1){
            return RestBean.success(service.findByUserId(user_id));
        }else {
            return RestBean.success(service.findByTwoId(exam_id, user_id));
        }
    }
    
    @PostMapping("/delete-apply-info")
    public RestBean<String> deleteApplyInfo(@RequestParam("exam_id") int exam_id,
                                            @RequestParam("user_id") int user_id){
        if (service.deleteApplyInfo(exam_id, user_id))
            return RestBean.success("取消考试成功");
        else
            return RestBean.failure(400, "取消考试失败");
    }

    @PostMapping()
    public RestBean<String> updateApplyInfo(@RequestParam("exam_id") int exam_id,
                                            @RequestParam("user_id") int user_id,
                                            @RequestParam("payment_status") String payment_status,
                                            @RequestParam("score") int score,
                                            @RequestParam("test_id") int test_id){
        if (service.updateTestOrPaymentStatus(exam_id, user_id, payment_status, test_id)
                &&service.updateScore(exam_id, user_id, score))
            return RestBean.success("修改考试信息成功");
        else
            return RestBean.failure(400, "修改考试信息失败");

    }
}
