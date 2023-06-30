package cet.backend.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;
@Mapper
public interface ExamineeMapper {
    //进入考试页面后,后台检查次考生是否有考试资格
    @Select("select user_id from soft_apply where exam_id = #{exam_id} and payment_status ='已支付' ")
    List<Integer> GetCandidates(int exam_id);

}
