package com.boot.services.netflixzuulapigatewayserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

import brave.sampler.Sampler;

//Tez notes:
//Normal we access the micro service directly like
//http://localhost:spring-application-server-port/{request-uri}
//http://localhost:8100/currency-conversion-feign/from/USD/to/INR/2000
//The port indicates the spring application name.
//But when going through zuul gateway, all spring applications go through it.
//Hence the spring-application-name has to be part of the request URL
//http://localhost:zuul-port/{spring-application-name}/{request-uri}
//http://localhost:8765/currency-conversion-service/currency-conversion-feign/from/USD/to/INR/2000
@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
public class NetflixZuulApiGatewayServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(NetflixZuulApiGatewayServerApplication.class, args);
	}

	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}
}
