package cn.sundefa.start.config;

import cn.sundefa.start.property.SwaggerProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * CodeMessage
 *
 * @author sundefa
 * @date 2018/12/13
 */
@ConditionalOnProperty(name = "fw.swagger.enable", havingValue = "true")
@Profile({"dev", "test", "default", "lab", "home"})
@Configuration
@EnableSwagger2
@Slf4j
public class SwaggerConfig {
    @Bean
    public Docket docket(SwaggerProperty swaggerProperty, @Value("${spring.application.name}") String applicationName) {
        log.info("swagger2 init...");
        log.info("swagger properties:[{}],applicationName:{}", swaggerProperty, applicationName);
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo(swaggerProperty, applicationName))
                .select()
                .apis(RequestHandlerSelectors.basePackage(swaggerProperty.getBasePackage()))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo(SwaggerProperty swaggerProperty, String applicationName) {
        return new ApiInfoBuilder()
                .title(applicationName)
                .description(swaggerProperty.getDescription())
                .contact(new Contact(swaggerProperty.getContactName(), swaggerProperty.getUrl(), swaggerProperty.getEmail()))
                .version(swaggerProperty.getVersion())
                .build();
    }
}
