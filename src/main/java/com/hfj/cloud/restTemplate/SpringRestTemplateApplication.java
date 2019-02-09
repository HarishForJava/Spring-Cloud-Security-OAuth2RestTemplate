package com.hfj.cloud.restTemplate;
/**
 * @author HFJ
 *
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.hfj.cloud.restTemplate.web.RestApiUtill;

@SpringBootApplication
public class SpringRestTemplateApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SpringRestTemplateApplication.class, args);

		RestApiUtill restApiUtill = new RestApiUtill();
		restApiUtill.getRequestUri("/getOsDetails", String.class);
	}
}