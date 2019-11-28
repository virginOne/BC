package com.zjj.bc.config.netty.protocol.enums;

/**
 *ClassName:SignalTypeEnum
 *@Description:
 *
 *@Author zjj
 *@Date 2019年11月25日
 *@Version 1.0
 */
public enum SignalTypeEnum {
	
	ERROR(-1,"错误"),QUERY(0,"查询"),REPLY(1,"回复"),BROADCAST(100,"广播");
	
	private Integer value;
	private String description;
	SignalTypeEnum(Integer value,String description){
		this.value=value;
		this.description=description;
	}
	
	public Integer getValue() {
		return value;
	}
	
	public String getDescription() {
		return description;
	}
	
	public static void main(String[] args) {
		System.out.println(SignalTypeEnum.BROADCAST);
	}
}
