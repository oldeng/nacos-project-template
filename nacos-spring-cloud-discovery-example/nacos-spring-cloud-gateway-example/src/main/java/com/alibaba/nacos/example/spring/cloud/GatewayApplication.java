package com.alibaba.nacos.example.spring.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author oldeng
 */
@SpringBootApplication
@EnableDiscoveryClient
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

	// @RestController
	// class EchoController {
	// 	@RequestMapping(value = "/gateway", method = RequestMethod.GET)
	// 	public String echo(@PathVariable String string) {
	// 		return "gateway";
	// 	}
	// }
}
