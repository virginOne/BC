package com.zjj.bc.config.netty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import lombok.extern.slf4j.Slf4j;

/**
 *ClassName:NettyServerConfig
 *@Description:
 *
 *@Author zjj
 *@Date 2019年11月11日
 *@Version 1.0
 */
@Slf4j
@Configuration
@ConditionalOnProperty(havingValue = "netty.server.enable")
@EnableConfigurationProperties(NettyServerProperties.class)
public class NettyServerAutoConfiguration {
	
	@Autowired
	private NettyServerProperties properties;
	
	@Bean
	@ConditionalOnMissingBean(ServerBootstrap.class)
	public ServerBootstrap serverBootstrap() {
		ServerBootstrap serverBootstrap=new ServerBootstrap();
		serverBootstrap
			.group(bossGroup() , workGroup())
			.channel(NioServerSocketChannel.class)
			.option(ChannelOption.SO_BACKLOG, 1024)
			.childHandler(new ChannelInitializer<Channel>() {
				@Override
				protected void initChannel(Channel ch) throws Exception {
				}
				
			}).childOption(ChannelOption.TCP_NODELAY, true);
		log.debug("=========NettyServer start on port:"+properties.getPort());
		return serverBootstrap;
	}
	
	private NioEventLoopGroup bossGroup() {
		return new NioEventLoopGroup(properties.getBossSize());
	}
	
	private NioEventLoopGroup workGroup() {
		return new NioEventLoopGroup(properties.getWorkSize());
	}
	
}
