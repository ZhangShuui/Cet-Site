package cet.backend.mapper;

import cet.backend.entity.auth.Account;
import cet.backend.entity.user.AccountUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper {
    @Select("select * from soft_user where username = #{text} or email = #{text}")
    Account findAccountByNameOrEmail(String text);

    @Select("select * from soft_user where username = #{text} or email = #{text}")
    AccountUser findAccountUserByNameOrEmail(String text);

    @Insert("insert into soft_user (email, username, password, is_stu) values (#{email}, #{username}, #{password}, #{isStu})")
    int createAccount(String username, String password, String email, int isStu);

    @Update("update soft_user set password = #{password} where email = #{email}")
    int resetPasswordByEmail(String password, String email);

    @Select("select id from soft_teacher where name = #{username} and teacher_id = #{teacherId}")
    int isTeacherIdValid(String username, String teacherId);
}
