package com.zjj.bc.config.netty;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.Setter;

/**
 *ClassName:NettyServerConfig
 *@Description:
 *
 *@Author zjj
 *@Date 2019年11月11日
 *@Version 1.0
 */
@Getter
@Setter
@ConfigurationProperties(prefix = "netty.server")
public class NettyServerProperties {
	/**
	 * @Description: The switch of nettyServer
	 */
	private boolean enable=false;
	/**
	 * @Description:The port of nettyServer
	 */
	private int port=9090;
	/**
	 * @Description:The size of boss dealChain threads
	 */
	private int bossSize=50;
	/**
	 * @Description:The size of work dealChain threads
	 */
	private int workSize=50;
}
