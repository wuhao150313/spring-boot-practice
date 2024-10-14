package wuhao.springboot.database.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author PC
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Teacher {

    private  Integer teacherId;
    private  String teacherName;
    private  Integer classId;
    public Clazz clazz;
}
