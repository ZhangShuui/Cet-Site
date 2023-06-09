package cet.backend.controller;

import cet.backend.entity.RestBean;
import cet.backend.entity.apply.ApplyInfo;
import cet.backend.mapper.ExamMapper;
import cet.backend.service.impl.ApplyHandleServiceImpl;
import jakarta.annotation.Resource;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

    @Resource
    ExamMapper examMapper;

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

    @PostMapping("/apply-for-test-back")
    public RestBean<String> applyFotTestBack(@RequestParam("exam_id") String s_exam_id,
                                         @RequestParam("user_id") String s_user_id){
        Integer exam_id;
        Integer user_id;
        if (s_exam_id.equals("") || s_user_id.equals(""))
            return RestBean.failure(400, "请填写申请的id");
        else {
            exam_id = Integer.valueOf(s_exam_id);
            user_id = Integer.valueOf(s_user_id);
        }

        if (service.applyTestByUser(exam_id, user_id)){
            return RestBean.success("申请考试成功");
        }else {
            return RestBean.failure(400, "申请失败");
        }
    }


    @PostMapping("/find-apply-info")
    public RestBean<List<ApplyInfo>> findApplyInfo(@RequestParam("exam_id") String s_exam_id,
                                                   @RequestParam("user_id") String s_user_id){

        Integer exam_id;
        Integer user_id;
        if (s_exam_id.equals(""))
            exam_id = -1;
        else
            exam_id = Integer.valueOf(s_exam_id);
        if (s_user_id.equals(""))
            user_id = -1;
        else
            user_id = Integer.valueOf(s_user_id);

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
        LocalDateTime ddl = examMapper.getStartTime(exam_id).toLocalDateTime().minusDays(7);
        LocalDateTime now = LocalDateTime.now();
        if (!now.isBefore(ddl)){
            return RestBean.failure(400, "退考截止日期已过");
        }
        if (service.deleteApplyInfo(exam_id, user_id))
            return RestBean.success("取消考试成功");
        else
            return RestBean.failure(400, "取消考试失败");
    }

    @PostMapping("/update-apply-info")
    public RestBean<String> updateApplyInfo(@RequestParam("exam_id") int exam_id,
                                            @RequestParam("user_id") int user_id,
                                            @RequestParam("payment_status") String payment_status,
                                            @RequestParam("test_id") int test_id){
        if (service.updateTestOrPaymentStatus(exam_id, user_id, payment_status, test_id))
            return RestBean.success("修改考试信息成功");
        else
            return RestBean.failure(400, "修改考试信息失败");

    }

    @GetMapping("/all-apply-info")
    public RestBean<List<ApplyInfo>> getAllApplyInfo(){
        return RestBean.success(service.showAllApplyInfo());
    }



}
