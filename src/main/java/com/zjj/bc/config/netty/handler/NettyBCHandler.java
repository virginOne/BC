package com.zjj.bc.config.netty.handler;

import com.zjj.bc.config.netty.protocol.entity.Signal;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http2.Http2HeadersDecoder;
import io.netty.handler.codec.http2.Http2Settings;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import lombok.extern.slf4j.Slf4j;

/**
 *ClassName:NettyBCHandler
 *@Description:
 *
 *@Author zjj
 *@Date 2019年11月25日
 *@Version 1.0
 */
@Slf4j
public class NettyBCHandler extends ChannelHandlerAdapter {
	
	
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		Signal signal=(Signal) msg;
		super.channelRead(ctx, msg);
	}
	
	private void errorHandler(Signal signal) {
		log.info("error"+signal.toString());
	}
	
	private void queryHandler(Signal signal) {
		
	}
	
	private void replyHandler(Signal signal) {
		
	}
	
	private void broadcastHandler(Signal signal) {
		
	}
}
