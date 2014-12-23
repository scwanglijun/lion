/**
	* Copyright (c)  2012, lion
	* All rights reserved. 
	*
	* $id: TsSysGroup.java 9552 2012-12-30 下午6:01:17 WangLijun$
*/
package com.newtouch.lion.model.system; 

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.newtouch.lion.model.VersionEntity;

/**
 * <p>
 * Title: 用户组 Model
 * </p>
 * <p>
 * Description: 用户组Model
 * </p>
 * <p>
 * Copyright: Copyright (c) 2012
 * </p>
 * <p>
 * Company: lion
 * </p>
 * 
 * @author WangLijun
 * @version 1.0
 */
public class Group extends VersionEntity<Long>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3219823117459262329L;
	/***
	 * 用户组ID
	 */
	private Long  id;
	/**用户组名称－中文*/
	private String nameZh;
	/**用户组名称－英文*/
	private String nameEn;
	/**用户组描述*/
	private String description;
	/**是否可编辑*/
	private Boolean editable;
	/***
	 * 所属用户组用户集合
	 */
	private Set<User> users = new HashSet<User>(0);
	
	/**所属用户组角色集合*/
	private Set<Role> roles = new HashSet<Role>(0);

	/* (non-Javadoc)
	 * @see com.lion.framework.model.BaseEntity#getId()
	 */
	@Override
	public Long getId() {
		return this.id;
	}
	
	

	/**
	 * @return the nameZh
	 */
	@Column(name="NAME_ZH", unique=true,length=100)
	public String getNameZh() {
		return nameZh;
	}

	/**
	 * @return the nameEn
	 */
	@Column(name="NAME_EN", unique=true,length=100)
	public String getNameEn() {
		return nameEn;
	}

	/**
	 * @return the description
	 */
	@Column(name="DESCRIPTION", length=255)
	public String getDescription() {
		return description;
	}

	/**
	 * @return the editable
	 */
	@Column(name="EDITABLE")
	public Boolean getEditable() {
		return editable;
	}
	
	/**
	 * @return the users
	 */
	@ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinTable(name = "BAS_USER_GROUP", joinColumns = { @JoinColumn(name = "BAS_GROUP_ID") }, inverseJoinColumns = { @JoinColumn(name = "BAS_USER_ID") })
	public Set<User> getUsers() {
		return users;
	}



	/**
	 * @return the roles
	 */
	@ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinTable(name = "BAS_GROUP_ROLE", joinColumns = { @JoinColumn(name = "BAS_GROUP_ID") }, inverseJoinColumns = { @JoinColumn(name = "BAS_ROLE_ID") })
	public Set<Role> getRoles() {
		return roles;
	}



	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}



	/**
	 * @param nameZh the nameZh to set
	 */
	public void setNameZh(String nameZh) {
		this.nameZh = nameZh;
	}



	/**
	 * @param nameEn the nameEn to set
	 */
	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}



	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}



	/**
	 * @param editable the editable to set
	 */
	public void setEditable(Boolean editable) {
		this.editable = editable;
	}



	/**
	 * @param users the users to set
	 */
	public void setUsers(Set<User> users) {
		this.users = users;
	}



	/**
	 * @param roles the roles to set
	 */
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
}

	