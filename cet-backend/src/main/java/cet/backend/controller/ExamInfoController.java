package cet.backend.controller;

import cet.backend.entity.ExamRelated.ExamInfo;
import cet.backend.entity.ExamRelated.ExamInfoForGet;
import cet.backend.entity.RestBean;
import cet.backend.service.impl.ExamInfoHandleServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.*;

@RestController
@RequestMapping("/api/examinfo")
public class ExamInfoController {

    List<ExamInfoForGet> convert(List<ExamInfo> list){
        ArrayList<ExamInfoForGet> newList = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        for (ExamInfo item : list) {
            calendar.setTime(item.getStart_time());
            calendar.add(Calendar.DATE, -7);
            Timestamp ddl = new Timestamp(calendar.getTimeInMillis());
            newList.add(new ExamInfoForGet(item.getExam_id(), item.getStart_time(), ddl));
        }
        return newList.subList(0, newList.size());
    }


    @Resource
    ExamInfoHandleServiceImpl service;

    @PostMapping("/test/canTake")
    RestBean<List<ExamInfoForGet>> getExamInfoCanTake(@RequestParam("user_id") int user_id){
        return RestBean.success(
                convert(service.getExamInfoCanTake(user_id)));
    }


    @PostMapping("/test/canQuit")
    RestBean<List<ExamInfoForGet>> getExamInfoCanQuit(@RequestParam("user_id") int user_id){
        return RestBean.success(
                convert(service.getExamInfoCanQuit(user_id)));
    }
}
