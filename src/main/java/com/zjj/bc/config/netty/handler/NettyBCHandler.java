package com.zjj.bc.config.netty.handler;

import java.util.ArrayList;
import java.util.List;

import com.zjj.bc.config.netty.protocol.entity.Node;
import com.zjj.bc.config.netty.protocol.entity.Signal;
import com.zjj.bc.config.netty.protocol.enums.SignalTypeEnum;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
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
public class NettyBCHandler extends SimpleChannelInboundHandler<Signal> {
	
	public static List<Node> nodes=new ArrayList<>();
	
	@Override
	protected void channelRead0(ChannelHandlerContext ctx, Signal msg) throws Exception {
		
		Integer type=msg.getType();
		if(SignalTypeEnum.ERROR.getValue().equals(type)) {
			errorHandler(msg);
		}else if(SignalTypeEnum.QUERY.getValue().equals(type)) {
			queryHandler(msg);
		}else if(SignalTypeEnum.FIND_NODE.getValue().equals(type)) {
			findNodeHandler(msg);
		}else if(SignalTypeEnum.REPLY.getValue().equals(type)) {
			replyHandler(msg);
		}else if(SignalTypeEnum.FIND_NODE.getValue().equals(type)) {
			findNodeHandler(msg);
		}else if(SignalTypeEnum.BROADCAST.getValue().equals(type)) {
			broadcastHandler(msg);
		}else {
			throw new RuntimeException("未知Signal类型");
		}
		
	}
	
	private void errorHandler(Signal signal) {
		log.info("error"+signal.toString());
	}
	
	private void queryHandler(Signal signal) {
		
	} 
	
	private void replyHandler(Signal signal) {
		
	}
	
	private void findNodeHandler(Signal signal) {
		
	}
	
	private void broadcastHandler(Signal signal) {
		
	}

}
