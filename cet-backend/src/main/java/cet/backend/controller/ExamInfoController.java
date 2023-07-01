package cet.backend.controller;

import cet.backend.entity.ExamRelated.ExamForQuit;
import cet.backend.entity.ExamRelated.ExamInfo;
import cet.backend.entity.ExamRelated.ExamInfoForGet;
import cet.backend.entity.RestBean;
import cet.backend.entity.apply.ApplyInfo;
import cet.backend.mapper.ApplyInfoMapper;
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

    List<ExamForQuit> convertQuit(List<ExamInfo> list, int user_id){
        ArrayList<ExamForQuit> newList = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        for (ExamInfo item : list) {
            calendar.setTime(item.getStart_time());
            calendar.add(Calendar.DATE, -7);
            Timestamp ddl = new Timestamp(calendar.getTimeInMillis());
            ApplyInfo curInfo = applyInfoMapper.findApplyInfoByMainKey(item.getExam_id(), user_id);
            newList.add(new ExamForQuit(item.getExam_id(), item.getStart_time(), curInfo.getPayment_status(),ddl));
        }
        return newList.subList(0, newList.size());
    }


    @Resource
    ExamInfoHandleServiceImpl service;

    @Resource
    ApplyInfoMapper applyInfoMapper;

    @PostMapping("/test/canTake")
    RestBean<List<ExamInfoForGet>> getExamInfoCanTake(@RequestParam("user_id") int user_id){
        return RestBean.success(
                convert(service.getExamInfoCanTake(user_id)));
    }


    @PostMapping("/test/canQuit")
    RestBean<List<ExamForQuit>> getExamInfoCanQuit(@RequestParam("user_id") int user_id){
        return RestBean.success(
                convertQuit(service.getExamInfoCanQuit(user_id), user_id));
    }

    @PostMapping("/test/getStartTime")
    RestBean<Timestamp> getExamStartTime(@RequestParam("exam_id") int exam_id) {
        return RestBean.success(service.getExamStartTime(exam_id));
    }
}
