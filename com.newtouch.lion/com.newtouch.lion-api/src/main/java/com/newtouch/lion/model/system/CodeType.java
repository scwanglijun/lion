/**
	* Copyright (c)  2012, lion
	* All rights reserved. 
	*
	* $id: TsCodeType.java 9552 2012-12-30 下午8:45:38 WangLijun$
*/
package com.newtouch.lion.model.system; 

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.newtouch.lion.model.VersionEntity;

/**
 * <p>
 * Title: 通用编码类型定义Model
 * </p>
 * <p>
 * Description: 通用编码类型定义Model
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
@Entity
@Table(name = "bas_code_type")
public class CodeType extends VersionEntity<Long> {
	
	private static final long serialVersionUID = -5566664366790451165L;
	/**类型id*/
	private Long id;
	/**类型*/
	private String type;
	/**中文名称*/
	private String nameZh;
	/**英文名称*/
	private String nameEn;
	/**是否可编辑*/
	private  Boolean editable;
	/**编码的值长度约束*/
	private Integer codeLenLimit;
	/**通用编码列表集合*/
	private  Set<CodeList> codeLists=new HashSet<CodeList>();
	


	/* (non-Javadoc)
	 * @see com.lion.framework.model.BaseEntity#getId()
	 */
  
 
	public Long getId() {
		return this.id;
	}
	
	
	
	/**
	 * @return the codeType
	 */
	@Column(name="CODE_TYPE",length=20)
	public String getType() {
		return type;
	}



	/**
	 * @return the nameZh
	 */
	@Column(name="NAME_ZH", unique=true,length=128)
	public String getNameZh() {
		return nameZh;
	}

	/**
	 * @return the nameEn
	 */
	@Column(name="NAME_EN", unique=true,length=128)
	public String getNameEn() {
		return nameEn;
	}

	/**
	 * @return the editable
	 */
	@Column(name="EDITABLE")
	public Boolean getEditable() {
		return editable;
	}

	

	/**
	 * @return the codeLenLimit
	 */
	@Column(name = "CODE_LEN_LIMIT", precision = 4, scale = 0)
	public Integer getCodeLenLimit() {
		return codeLenLimit;
	}



	/**
	 * @return the tsCodeLists
	 */
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy="codeType")
	public Set<CodeList> getCodeLists() {
		return codeLists;
	}



	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}



	/**
	 * @param codeType the codeType to set
	 */
	public void setType(String type) {
		this.type = type;
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
	 * @param editable the editable to set
	 */
	public void setEditable(Boolean editable) {
		this.editable = editable;
	}

	

	/**
	 * @param codeLenLimit the codeLenLimit to set
	 */
	public void setCodeLenLimit(Integer codeLenLimit) {
		this.codeLenLimit = codeLenLimit;
	}



	/**
	 * @param tsCodeLists the tsCodeLists to set
	 */
	public void setCodeLists(Set<CodeList> codeLists) {
		this.codeLists = codeLists;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CodeType [id=" + id + ", type=" + type + ", nameZh=" + nameZh
				+ ", nameEn=" + nameEn + ", editable=" + editable
				+ ", codeLenLimit=" + codeLenLimit + ", codeLists=" + codeLists
				+ "]";
	}
	
}

	