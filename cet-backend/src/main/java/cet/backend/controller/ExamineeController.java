package cet.backend.controller;

import cet.backend.entity.RestBean;
import cet.backend.service.impl.ExamineeHandlerServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/examinee")
public class ExamineeController {
    @Resource
    ExamineeHandlerServiceImpl examineeHandlerService;

    @PostMapping("/check-eligibility")
    public RestBean<Boolean> CheckEligibility(@RequestParam("user_id") int user_id,
                                              @RequestParam("exam_id") int exam_id) {//前端向后端发送请求,检查我是否具备本场考试资格
        if(examineeHandlerService.AmIVerified(user_id,exam_id)) {
            return RestBean.success(true);
        }else {
            return RestBean.failure(400 , false);
        }
    }
}
