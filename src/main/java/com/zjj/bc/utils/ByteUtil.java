package com.zjj.bc.utils;

import io.netty.channel.Channel.Unsafe;

/**
 *ClassName:ByteUtil
 *@Description:
 *
 *@Author zjj
 *@Date 2019年11月26日
 *@Version 1.0
 */
public class ByteUtil {
	
	public static final String BIG_ENDIAN="BIG_ENDIAN";
	
	public static final String LITTEL_ENDIAN="LITTEL_ENDIAN";
	
	public static final String byteOrder=BIG_ENDIAN;
	
	public static byte[] intToByte(int val) {
		byte[] b=new byte[4];
		b[3]=(byte) (val&0xff);
		b[2]=(byte)((val>>8)&0xff);
		b[1]=(byte)((val>>16)&0xff);
		b[0]=(byte)((val>>24)&0xff);
		return b;
	}
	public static int BytesToInt(byte[] b) {
		int val=0;
		for(int i=0;i<4;i++) {
			int shift=(3-i)*8;
			val+=(b[i]&0xff)<<shift;
		}
		return val;
	}
}
