package com.viptaojin.union;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by pj on 5/10/17.
 */
@EnableAutoConfiguration
@SpringBootApplication
@EnableSwagger2
@ServletComponentScan
@EnableTransactionManagement
public class VipTaoJinApplication {

    public static void main(String[] args ){
        SpringApplication.run(VipTaoJinApplication.class,args);
    }
}
