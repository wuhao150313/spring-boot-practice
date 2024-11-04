package wuhao.springboot.middle.mapper;

import wuhao.springboot.middle.entity.Question;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * @author PC
 */
@Mapper
public interface QuestionMapper {
    void insertQuestion(Question question);
    List<Question> findAllQuestions();
    Question findById(Integer id);
}