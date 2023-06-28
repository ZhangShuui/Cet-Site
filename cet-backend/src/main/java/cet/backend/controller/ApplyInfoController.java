package cet.backend.controller;

import cet.backend.service.impl.ApplyHandleServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/*
* 关于报考申请信息的请求处理控制器
* url设置为"/api/apply"
* */
@RestController
@RequestMapping("/api/apply")
public class ApplyInfoController {

    @Resource
    ApplyHandleServiceImpl service;

}
