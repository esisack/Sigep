package ar.gob.sigep.inicidences.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SpringFoxConfig {                                    
    @Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.basePackage("ar.gob.sigep.inicidences.app.controller"))              
          .paths(PathSelectors.any())                          
          .build();                                           
    }
    
    public static ApiInfo metadata(){
        return new ApiInfoBuilder()
                .title("SiGeP - Sistema de gestion del espacio publico ")
                .description("Microservicio para la gestion de oficios levantados en calle, calzada y espacio publico en general")
                .version("1.x")
                .build();
    }
}