package com.zjj.bc.entity;

import lombok.Data;

/**
 *ClassName:Block
 *@Description:
 *
 *@Author zjj
 *@Date 2019年11月8日
 *@Version 1.0
 */
@Data
public class Block {
	private byte[] hash;
	private String content;
	private byte beforeBlock;
	
}
