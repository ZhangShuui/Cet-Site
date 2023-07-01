package cet.backend.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface PaperMapper {
    @Insert("insert into soft_paper (test_id, choiceQ1, choiceW1, choiceQ2, choiceW2,choiceQ3, choiceW3,choiceQ4, choiceW4,choiceQ5, choiceW5,readingQ1,readingQ2,choiceQ6, choiceW6,choiceQ7, choiceW7,choiceQ8, choiceW8,choiceQ9, choiceW9,choiceQ10, choiceW10, translationQ,writingQ) " +
            "values (#{test_id}, #{choiceQ1}, #{choiceW1}, #{choiceQ2}, #{choiceW2}, #{choiceQ3}, #{choiceW3},#{choiceQ4}, #{choiceW4},#{choiceQ5}, #{choiceW5},#{readingQ1},#{readingQ2},#{choiceQ6}, #{choiceW6},#{choiceQ7}, #{choiceW7},#{choiceQ8}, #{choiceW8},#{choiceQ9}, #{choiceW9},#{choiceQ10}, #{choiceW10}, #{translationQ},#{writingQ})")
    int createPaper(int test_id, String choiceQ1, String choiceW1, String choiceQ2,
                    String choiceW2, String choiceQ3, String choiceW3, String choiceQ4,
                    String choiceW4, String choiceQ5, String choiceW5, String readingQ1,
                    String readingQ2, String choiceQ6, String choiceW6, String choiceQ7,
                    String choiceW7, String choiceQ8, String choiceW8, String choiceQ9,
                    String choiceW9, String choiceQ10, String choiceW10, String translationQ, String writingQ);

    @Update("update soft_paper set choiceQ1=#{choiceQ1}, choiceW1=#{choiceW1}, choiceQ2=#{choiceQ2}, choiceW2=#{choiceW2}, choiceQ3=#{choiceQ3}, choiceW3=#{choiceW3}, choiceQ4=#{choiceQ4}, choiceW4=#{choiceW4}, choiceQ5=#{choiceQ5}, choiceW5=#{choiceW5}, readingQ1=#{readingQ1}, readingQ2=#{readingQ2}, " +
            "choiceQ6=#{choiceQ6}, choiceW6=#{choiceW6}, choiceQ7=#{choiceQ7}, choiceW7=#{choiceW7}, choiceQ8=#{choiceQ8}, choiceW8=#{choiceW8}, choiceQ9=#{choiceQ9}, choiceW9=#{choiceW9}, choiceQ10=#{choiceQ10}, choiceW10=#{choiceW10}, translationQ=#{translationQ}, writingQ=#{writingQ} where test_id = #{test_id}")
    int resetAllPaper(int test_id, String choiceQ1, String choiceW1, String choiceQ2,
                      String choiceW2, String choiceQ3, String choiceW3, String choiceQ4,
                      String choiceW4, String choiceQ5, String choiceW5, String readingQ1,
                      String readingQ2, String choiceQ6, String choiceW6, String choiceQ7,
                      String choiceW7, String choiceQ8, String choiceW8, String choiceQ9,
                      String choiceW9, String choiceQ10, String choiceW10, String translationQ, String writingQ);
}
