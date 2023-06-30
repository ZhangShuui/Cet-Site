package cet.backend.service.impl;

import cet.backend.mapper.ExamineeMapper;
import cet.backend.service.ExamineeHandlerService;
import jakarta.annotation.Resource;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamineeHandlerServiceImpl implements ExamineeHandlerService {
    @Resource
    ExamineeMapper mapper;
    @Override
    public boolean AmIVerified(int user_id, int exam_id) {
        List<Integer> candidates = mapper.GetCandidates(exam_id);
        if(candidates.contains(user_id)) {
            return true;
        }else {
            return false;
        }
    }
}
