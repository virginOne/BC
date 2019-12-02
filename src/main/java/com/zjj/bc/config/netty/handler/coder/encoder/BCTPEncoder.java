package com.zjj.bc.config.netty.handler.coder.encoder;

import com.zjj.bc.config.netty.protocol.entity.BCTP;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 *ClassName:BCTPEncoder
 *@Description:
 *
 *@Author zjj
 *@Date 2019年11月27日
 *@Version 1.0
 */
public class BCTPEncoder extends MessageToByteEncoder<BCTP>{

	@Override
	protected void encode(ChannelHandlerContext ctx, BCTP msg, ByteBuf out) throws Exception {
		out.writeByte(BCTP.HEAD_SIGN);
		out.writeByte(msg.getLength());
		out.writeBytes(msg.getBytes());
	}

}
