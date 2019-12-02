package com.zjj.bc.config.netty.protocol.entity;

import java.io.Serializable;
import java.net.InetAddress;

import lombok.Data;

/**
 *ClassName:Signal
 *@Description:
 *
 *@Author zjj
 *@Date 2019年11月25日
 *@Version 1.0
 */
@Data
public class Signal implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public static final int EXPIRATION=1000*60*10;
	
	private Integer type;
	private long createDate;
	InetAddress destination;
	InetAddress source;
	Object data;
}
