package com.zjj.bc.config.netty.handler.coder.encoder;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.zjj.bc.config.netty.handler.coder.CoderConfig;
import com.zjj.bc.config.netty.protocol.entity.BCTP;
import com.zjj.bc.config.netty.protocol.entity.Signal;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;

/**
 *ClassName:JsonEncoder
 *@Description:
 *
 *@Author zjj
 *@Date 2019年11月26日
 *@Version 1.0
 */
public class JsonEncoder extends MessageToMessageEncoder<Signal> {

	@Override
	protected void encode(ChannelHandlerContext ctx, Signal msg, List<Object> out) throws Exception {
		out.add(new BCTP(JSON.toJSONString(msg).getBytes(CoderConfig.DEFAULT_CHARSET)));
	}

}
