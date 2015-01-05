/*
* Copyright (c)  2015, Newtouch
* All rights reserved. 
*
* $id: MenuServiceTest.java 9552 2015年1月5日 上午10:30:22 WangLijun$
*/
package com.newtouch.lion.service.menu; 

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.newtouch.lion.model.menu.Menu;
import com.newtouch.lion.service.AllServiceTest;

/**
 * <p>
 * Title: 菜单测试类
 * </p>
 * <p>
 * Description: 菜单测试类
 * </p>
 * <p>
 * Copyright: Copyright (c) 2015
 * </p>
 * <p>
 * Company: Newtouch
 * </p>
 * 
 * @author WangLijun
 * @version 1.0
 */
public class MenuServiceTest extends AllServiceTest{
	
	@Autowired
	private MenuService menuService;
	
	@Test
	public void doFindByUserId(){
		Long userId=1L;
		List<Menu>  list=menuService.doFindByUserId(userId);
		logger.info("list.size:{}",list.size());
	}
	
}

	