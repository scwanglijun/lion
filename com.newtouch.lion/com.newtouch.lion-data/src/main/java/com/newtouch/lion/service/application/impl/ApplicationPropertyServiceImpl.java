
/*
* Copyright (c)  2014, Newtouch
* All rights reserved. 
*
* $id: ApplicationPropertyServiceImpl.java 9552 2014年12月23日 下午3:28:10 WangLijun$
*/
package com.newtouch.lion.service.application.impl; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newtouch.lion.dao.application.ApplicationPropertyDao;
import com.newtouch.lion.model.application.ApplicationProperty;
import com.newtouch.lion.page.PageResult;
import com.newtouch.lion.query.QueryCriteria;
import com.newtouch.lion.service.application.ApplicationPropertyService;

/**
 * <p>
 * Title: 项目属性配置服务配置实现
 * </p>
 * <p>
 * Description: 项目属性配置服务配置实现
 * </p>
 * <p>
 * Copyright: Copyright (c) 2014
 * </p>
 * <p>
 * Company: Newtouch
 * </p>
 * 
 * @author WangLijun
 * @version 1.0
 */
@Service
public class ApplicationPropertyServiceImpl implements
		ApplicationPropertyService {
	/***
	 * 定义项目应用配置项Dao
	 */
	@Autowired
	private ApplicationPropertyDao applicationPropertyDao;

	/* (non-Javadoc)
	 * @see com.newtouch.lion.service.application.ApplicationPropertyService#doFindById(java.lang.Long)
	 */
	@Override
	public ApplicationProperty doFindById(Long id) {
		return this.applicationPropertyDao.findById(id);
	}

	/* (non-Javadoc)
	 * @see com.newtouch.lion.service.application.ApplicationPropertyService#doCreateObj(com.newtouch.lion.model.application.ApplicationProperty)
	 */
	@Override
	public void doCreateObj(
			ApplicationProperty applicationProperty) {
		this.applicationPropertyDao.save(applicationProperty);
	}

	/* (non-Javadoc)
	 * @see com.newtouch.lion.service.application.ApplicationPropertyService#doFindByCriteria(com.newtouch.lion.query.QueryCriteria)
	 */
	@Override
	public PageResult<ApplicationProperty> doFindByCriteria(
			QueryCriteria criteria) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.newtouch.lion.service.application.ApplicationPropertyService#doDeleteById(java.lang.Long)
	 */
	@Override
	public void doDeleteById(Long id) {
		ApplicationProperty obj=new ApplicationProperty();
		obj.setId(id);
		this.applicationPropertyDao.remove(obj);
	}

}

	