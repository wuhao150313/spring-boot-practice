package wuhao.springboot.middle.mapper;

import org.apache.ibatis.annotations.Mapper;
import wuhao.springboot.middle.entity.Answer;

import java.util.List;

/**
 * @author PC
 */
@Mapper
public interface AnswerMapper {
    void insertAnswer(Answer answer);
    List<Answer> findByQuestionId(Integer questionId);
}
