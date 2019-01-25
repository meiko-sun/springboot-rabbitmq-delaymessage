package cn.sundefa.start.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 基础位置表
 *
 * @author defa sun
 * @date 2018-08-21 15:44:39
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Table(name = "qz_advert_position")
public class AdvertPosition implements Serializable {

    /**
     * 主键id
     */
    @Id
    private Integer advertPositionId;
    /**
     * 系统  1 android 2 ios 3 androidH5 4 iosH5
     */
    private Integer appSystem;
    /**
     * 位置名称
     */
    private String positionName;
    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;
}
