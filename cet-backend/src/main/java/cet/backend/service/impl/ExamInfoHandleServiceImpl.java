package cet.backend.service.impl;

import cet.backend.entity.ExamRelated.ExamInfo;
import cet.backend.mapper.ExamMapper;
import cet.backend.service.ExamInfoHandleService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class ExamInfoHandleServiceImpl implements ExamInfoHandleService {

    private final Calendar calendar = Calendar.getInstance();

    @Resource
    ExamMapper mapper;

    private final Logger logger = Logger.getLogger("my");

    @Override
    public List<ExamInfo> getAllExamInfo() {
        return mapper.getAllExamInfo();
    }

    boolean computeDDLBefore(Timestamp timestamp, Timestamp cur){
        calendar.setTime(timestamp);
        calendar.add(Calendar.DATE, -7);
        Timestamp ddlTime = new Timestamp(calendar.getTimeInMillis());
        logger.info(ddlTime.toString());
        logger.info("dshdhas"+ cur.toString());
        return cur.before(ddlTime);
    }

    @Override
    public List<ExamInfo> getExamInfoCanTake(int user_id) {
        List<ExamInfo> allTest = mapper.getAllExamInfo();
        List<ExamInfo> takenTest = mapper.getAllExamTaken(user_id);
        Timestamp cur = new Timestamp((new Date()).getTime());

        return allTest
                .stream()
                .filter(item -> computeDDLBefore(item.getStart_time(), cur)&& !takenTest.contains(item))
                .collect(Collectors.toList());
    }

    @Override
    public List<ExamInfo> getExamInfoCanQuit(int user_id) {
        return mapper.getAllExamTaken(user_id);
    }
}
