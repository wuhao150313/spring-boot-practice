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
public class Section {
    private String sectionId;
    private String specialId;
    private String sectionTitle;


}
