package wuhao.zhihu.api.entity;

import jdk.jfr.DataAmount;
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

public class Special {
    private String id;
    private String title;
    private String banner;
    private String description;
    private String isFollowing;
    private Integer followersCount;
    private Integer viewCount;
    private String updated;
}
