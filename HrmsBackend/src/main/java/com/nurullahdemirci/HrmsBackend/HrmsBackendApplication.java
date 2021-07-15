package com.nurullahdemirci.HrmsBackend;

//import java.io.File;
import java.io.IOException;
//import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//import com.cloudinary.*;
//import com.cloudinary.utils.ObjectUtils;

@SpringBootApplication
@EnableSwagger2
public class HrmsBackendApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(HrmsBackendApplication.class, args);
		
//		Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
//				"cloud_name", "boryabgukagan",
//				"api_key", "712857895316664",
//				"api_secret", "api_secret",
//				"secure", true));
//		
//		File file = new File("dragon.jpg");
//		Map uploadResult = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
//		
//		System.out.println(uploadResult.get("url"));		
	}
	
	@Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.basePackage("com.nurullahdemirci.HrmsBackend"))                
          .build();                                           
    }

}
