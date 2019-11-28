package com.zjj.bc.config.netty.handler.coder.decoder;

import java.util.List;

import com.zjj.bc.config.netty.protocol.entity.BCTP;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import lombok.extern.slf4j.Slf4j;

/**
 *ClassName:BCTPDecoder
 *@Description:
 *
 *@Author zjj
 *@Date 2019年11月27日
 *@Version 1.0
 */
@Slf4j
public class BCTPDecoder extends ByteToMessageDecoder{

	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
		if(in.readableBytes()<BCTP.BASE_LENGTH) {//数据小于BCTP的基本长度 不予解析
			return ;
		}
		int startIndex;
		int headSign;
		int length;
		while(true) {//识别协议开始头部，防止非法数据
			startIndex=in.readerIndex();
			headSign=in.readInt();
			if(headSign==BCTP.HEAD_SIGN) {
				length=in.readInt();
				if(length>BCTP.MAX_LENGTH) {//超过协议允许的最大传输数据大小
					log.info("传输数据超过协议规定大小"+BCTP.MAX_LENGTH+"bytes");
					in.readerIndex(in.readerIndex()+length);
					return ;
				}
				if(in.readableBytes()<length) {//可读数据大小小于可以将数据封装的消大小
					in.readerIndex(startIndex);
					return ;
				}
				break;
			}
		}
		//封装数据
		out.add(getBCTP(in, length));
	}
	
	private BCTP getBCTP(ByteBuf in,int length) {
		ByteBuf b=in.readBytes(length);
		return new BCTP(b.array());
	}

}
