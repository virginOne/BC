package com.zjj.bc.config.netty.protocol.entity;

import com.zjj.bc.utils.ByteUtil;

import lombok.Getter;

/**
 *ClassName:BCTP
 *@Description:
 *
 *@Author zjj
 *@Date 2019年11月26日
 *@Version 1.0
 */
public class BCTP {
	
	public static final int MAX_LENGTH=2048;
	public static final int BASE_LENGTH=4+4;
	public static final int HEAD_SIGN= 0x101;  
	
	@Getter
	private byte[] data;
	@Getter
	private int length;
	
	public BCTP(byte[] data){
		this.data=data;
		this.length=data.length;
	}
	
	public byte[] getBytes() {
		byte[] b=new byte[length+BASE_LENGTH];
		byte[] h=ByteUtil.intToByte(HEAD_SIGN);
		byte[] l=ByteUtil.intToByte(length);
		b[0]=h[0];
		b[1]=h[1];
		b[2]=h[2];
		b[3]=h[3];
		b[4]=l[0];
		b[5]=l[1];
		b[6]=l[2];
		b[7]=l[3];
		for(int i=8;i<length;i++) {
			b[i]=data[i-8];
		}
		return b;
	}
	
}
