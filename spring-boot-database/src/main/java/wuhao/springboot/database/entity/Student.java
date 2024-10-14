package wuhao.springboot.database.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

/**
 * @author PC
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {
    private Integer studentId;

    private Integer clazzId;

    private String studentName;

    private String hometown;

    private LocalDate birthday;

    private Clazz clazz;

    private List<Course> courses;

}
