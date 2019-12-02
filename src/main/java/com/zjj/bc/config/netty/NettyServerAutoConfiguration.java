package com.zjj.bc.config.netty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zjj.bc.config.netty.handler.NettyBCHandler;
import com.zjj.bc.config.netty.handler.coder.decoder.BCTPDecoder;
import com.zjj.bc.config.netty.handler.coder.decoder.JsonDecoder;
import com.zjj.bc.config.netty.handler.coder.encoder.BCTPEncoder;
import com.zjj.bc.config.netty.handler.coder.encoder.JsonEncoder;

import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioDatagramChannel;
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
@ConditionalOnProperty(prefix = "netty.server", name = "enable", havingValue = "true")
@EnableConfigurationProperties(NettyServerProperties.class)
public class NettyServerAutoConfiguration {
	
	@Autowired
	private NettyServerProperties properties;
	
	@Bean
	@ConditionalOnProperty(prefix = "netty.server", name="protocol", havingValue = "TCP")
	@ConditionalOnMissingBean(ServerBootstrap.class)
	public ServerBootstrap serverBootstrap() {
		ServerBootstrap serverBootstrap=new ServerBootstrap();
		serverBootstrap
			.group(bossGroup() , workGroup())
			.channel(NioServerSocketChannel.class)
			.option(ChannelOption.SO_BACKLOG, 1024)
			.childHandler(new NettyBCCHannelInitializer())
			.childOption(ChannelOption.TCP_NODELAY, true);
		log.debug("=========NettyServer start on port:"+properties.getPort());
		return serverBootstrap;
	}
	
	@Bean
	@ConditionalOnProperty(prefix = "netty.server", name="protocol", havingValue = "UDP")
	@ConditionalOnMissingBean(Bootstrap.class)
	public Bootstrap bootstrap() {
		
		Bootstrap bootstrap=new Bootstrap();
		bootstrap.group(bossGroup())
			.channel(NioDatagramChannel.class)
			.option(ChannelOption.SO_BROADCAST, true)
			.handler(new NettyBCCHannelInitializer());
		
		return null;
	}
	
	
	private NioEventLoopGroup bossGroup() {
		return new NioEventLoopGroup(properties.getBossSize());
	}
	
	private NioEventLoopGroup workGroup() {
		return new NioEventLoopGroup(properties.getWorkSize());
	}
	
}
