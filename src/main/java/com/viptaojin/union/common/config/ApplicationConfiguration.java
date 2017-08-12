package com.viptaojin.union.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Created by pj on 17-4-20.
 */
@Configuration
public class ApplicationConfiguration extends WebMvcConfigurerAdapter {

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("vip淘金网接口文档").description("vip淘金网接口文档 1.0版本")
                .version("1.0")
                .build();
    }

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.watch.vip.ds"))
                .paths(PathSelectors.any())
                .build();
    }

}
