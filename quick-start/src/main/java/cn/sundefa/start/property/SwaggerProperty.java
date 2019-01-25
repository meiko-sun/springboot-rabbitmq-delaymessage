package cn.sundefa.start.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * CodeMessage
 *
 * @author sundefa
 * @date 2018/12/13
 */
@Component
@ConfigurationProperties(prefix = "fw.swagger")
@Data
public class SwaggerProperty {
    /**
     * 项目描述
     */
    private String description;
    /**
     * 项目版本
     */
    private String version;
    /**
     * 联系邮箱
     */
    private String email;
    /**
     * 项目负责人
     */
    private String contactName;
    /**
     * 相关网站url
     */
    private String url;
    /**
     * 扫描路径
     */
    private String basePackage = "cn.sundefa";
    /**
     * 是否开启(避免冲突)
     */
    private boolean enable = false;
}
