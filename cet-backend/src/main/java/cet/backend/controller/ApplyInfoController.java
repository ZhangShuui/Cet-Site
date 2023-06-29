package cet.backend.controller;

import cet.backend.entity.RestBean;
import cet.backend.entity.apply.ApplyInfo;
import cet.backend.service.impl.ApplyHandleServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

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
    public RestBean<String> paymentSubmit(@SessionAttribute("exam_id") int exam_id,
                                          @SessionAttribute("user_id") int user_id){
        if (service.payForApply(exam_id, user_id)){
            return RestBean.success("支付成功");
        }else
            return RestBean.failure(400 , "已完成支付，请勿重复支付");
    }

    @PostMapping("/apply-for-test")
    public RestBean<String> applyFotTest(@SessionAttribute("exam_id") int exam_id,
                                         @SessionAttribute("user_id") int user_id){
        if (service.applyTestByUser(exam_id, user_id)){
            return RestBean.success("申请考试成功");
        }else {
            return RestBean.failure(400, "申请失败");
        }
    }

    @PostMapping("/find-apply-info")
    public RestBean<List<ApplyInfo>> findApplyInfo(@SessionAttribute("exam_id") int exam_id,
                                                   @SessionAttribute("user_id") int user_id){

        return null;
    }

}
