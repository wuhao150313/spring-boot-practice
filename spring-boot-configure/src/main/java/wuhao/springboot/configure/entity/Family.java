package wuhao.springboot.configure.entity;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import wuhao.springboot.configure.loader.YamPropertyLoader;


/**
 * @author PC
 */
@Data
@Component
@ConfigurationProperties(prefix = "family")
//@PropertySource(value = {"classpath:family.properties"})
@PropertySource(value = {"classpath:family.yml"},factory = YamPropertyLoader.class)
@Validated

public class Family {
    @Length(min = 5, max = 10 ,message = "家庭名称必须在5到10之间")
    private String familyName;
    private String father;
    private String mother;
    private String child;


    @Range(min = 3,message = "家庭年限必须大于3年！")
    private Integer age;

}
