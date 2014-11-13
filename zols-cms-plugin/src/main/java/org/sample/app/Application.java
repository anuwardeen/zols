package org.sample.app;

import com.mangofactory.swagger.plugin.EnableSwagger;
import static org.springframework.boot.SpringApplication.run;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.zols.plugin.EnableCMS;

@ComponentScan
@EnableAutoConfiguration
@EnableCMS
@EnableSwagger
public class Application {    
    
    public static void main(String[] args) {
        run(Application.class, args);
    }
}
