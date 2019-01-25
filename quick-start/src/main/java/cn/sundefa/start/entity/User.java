package cn.sundefa.start.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * MongoDB测试类
 *
 * @author defa sun
 * @date 2018-08-21 15:44:39
 */
@Document
@Data
@Builder
public class User implements Serializable {

    /**
     * 用户id 主键重复覆盖
     */
    @Id
    private String userId;
    /**
     * 用户名称
     */
    private String name;
    /**
     * 年龄
     */
    private String age;
    /**
     * 地址
     */
    private List<Address> address;
    /**
     * 创建时间
     */
    private Date creatTime;
}
