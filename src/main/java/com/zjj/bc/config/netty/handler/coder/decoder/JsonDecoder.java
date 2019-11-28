package com.zjj.bc.config.netty.handler.coder.decoder;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.zjj.bc.config.netty.handler.coder.CoderConfig;
import com.zjj.bc.config.netty.protocol.entity.BCTP;
import com.zjj.bc.config.netty.protocol.entity.Signal;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;

/**
 *ClassName:JsonDecoder
 *@Description:
 *
 *@Author zjj
 *@Date 2019年11月25日
 *@Version 1.0
 */
public class JsonDecoder extends MessageToMessageDecoder<BCTP> {
	
	@Override
	protected void decode(ChannelHandlerContext ctx, BCTP msg, List<Object> out) throws Exception {
		String json=new String(msg.getBytes(), CoderConfig.DEFAULT_CHARSET);
		
		out.add(JSONObject.parseObject(json, Signal.class));
	}
}
