package cet.backend.mapper;

import cet.backend.entity.apply.ApplyInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/*
* 考生报考信息映射
* 需要包括以下功能：
* 前台
* - 考生报名
* 后台
* - 考生报考查询（全部信息）
* - 考生报考信息修改
* - 考生报考信息添加
* - 考生报考信息删除
* */
@Mapper
public interface ApplyInfoMapper {

    @Insert("insert into soft_apply (exam_id, user_id, payment_status, application_time, score, test_id) values (#{exam_id}, #{user_id}, #{payment_status}, #{application_time}, #{score}, #{test_id})")
    int addApplyInfo(int exam_id, int user_id, String payment_status, String application_time, int score, int test_id);

    @Select("select * from soft_apply")
    List<ApplyInfo> findAllApplyInfo();

    @Update("update soft_apply set payment_status=#{payment_status}, set score=#{score}, set test_id=#{test_id} where exam_id=#{exam_id} and user_id=#{user_id}")
    int updateApplyInfo(int exam_id, int user_id, String payment_status, int score, int test_id);

    @Update("update soft_apply set payment_status=#{payment_status} where exam_id=#{exam_id} and user_id=#{user_id}")
    int updatePaymentStatus(int exam_id, int user_id, String payment_status);

    @Delete("delete from soft_apply where exam_id=#{exam_id} and user_id=#{user_id}")
    int deleteApplyInfo(int exam_id, int user_id);

    @Select("select * from soft_apply where exam_id=#{exam_id} and user_id=#{user_id}")
    ApplyInfo findApplyInfoByMainKey(int exam_id, int user_id);
}
