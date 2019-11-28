package com.zjj.bc;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.zjj.bc.utils.SpringUtil;

import io.netty.bootstrap.ChannelFactory;
import io.netty.bootstrap.ServerBootstrap;

@SpringBootApplication
@EnableAutoConfiguration
public class BcApplication implements ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(BcApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
	}

}
