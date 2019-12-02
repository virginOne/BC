package com.zjj.bc.config.netty;

import com.zjj.bc.config.netty.handler.NettyBCHandler;
import com.zjj.bc.config.netty.handler.coder.decoder.BCTPDecoder;
import com.zjj.bc.config.netty.handler.coder.decoder.JsonDecoder;
import com.zjj.bc.config.netty.handler.coder.encoder.BCTPEncoder;
import com.zjj.bc.config.netty.handler.coder.encoder.JsonEncoder;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;

/**
 *ClassName:NettyBChandler
 *@Description:
 *
 *@Author zjj
 *@Date 2019年11月14日
 *@Version 1.0
 */
public class NettyBCCHannelInitializer extends ChannelInitializer<Channel> {

	@Override
	protected void initChannel(Channel ch) throws Exception {
		ch.pipeline().addLast(new BCTPDecoder());
		ch.pipeline().addLast(new JsonDecoder());
		ch.pipeline().addLast(new BCTPEncoder());
		ch.pipeline().addLast(new JsonEncoder());
		ch.pipeline().addLast(new NettyBCHandler());
	}
	
	
}
