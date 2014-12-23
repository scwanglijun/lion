/*
 * Copyright (c)  2013, lion
 * All rights reserved. 
 *
 * $id: DataGrid.java 9552 2013-3-27 下午4:51:03 WangLijun$
 */
package com.newtouch.lion.model.datagrid;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.newtouch.lion.model.VersionEntity;

/**
 * <p>
 * Title:
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2013
 * </p>
 * <p>
 * Company: lion
 * </p>
 * 
 * @author WangLijun
 * @version 1.0
 */
public class DataGrid extends VersionEntity<Long> {

	/**
		 * 
		 */
	private static final long serialVersionUID = -2196344082980302505L;

	/** ID 为DataGrid Id */
	private Long id;
	/**表格类型*/
	private String type;
	/**表格ID*/
	private String tableId;
	/**表格标题*/
	private String title;
	/**是否表格标题 ,默认为false*/
	private Boolean showTitle=Boolean.FALSE;
	/** 设置为true将自动使列适应表格宽度以防止出现水平滚动 */
	private Boolean fit;
	/** 跟列属性一样，但是这些列固定在左边，不会滚动。 */
	private Boolean frozen;
	/** 是否合并表头并分组显示，默认值：false */
	private Boolean showGroup;
	/** 显示集合列 */
	private Set<DataColumn> columns = new HashSet<DataColumn>();

	/** 是否显示分页显示条 */
	private Boolean pagination;
	/**
	 * True to auto expand/contract the size of the columns to fit the grid
	 * width and prevent horizontal scrolling.Default value is:false;
	 */
	private Boolean fitColumns;
	/** True to stripe the rows. Default value is:false */
	private Boolean striped;
	/** The method type to request remote data.Default value is:post */
	private String method;
	/** 默认设置为：true，当数据长度超出列宽时将会自动截取。 */
	private Boolean nowrap;
	/** A URL to request data from remote site. */
	private String url;
	/** The data to be loaded. */
	private String data;
	/**
	 * When loading data from remote site,show a prompt message.Default value
	 * is:'Processing, please wait …'
	 */
	private String loadMsg;
 
	/***
	 * True to show a row number column. Default value is:true;
	 */
	private Boolean rownumbers;
	/** True to allow selecting only one row. Default value is:true */
	private Boolean singleSelect;
	/**
	 * If true, the checkbox is checked/unchecked when the user clicks on a row.
	 * If false, the checkbox is only checked/unchecked when the user clicks
	 * exactly on the checkbox.
	 */
	private Boolean checkOnSelect;
	/**
	 * If set to true, clicking a checkbox will always select the row. If false,
	 * selecting a row will not check the checkbox.
	 */
	private Boolean selectOnCheck;
	/**
	 * Defines position of the pager bar. Available values are:
	 * 'top','bottom','both'.The default value is:bottom
	 */
	private String pagePosition;
	/** When set pagination property, initialize the page number. */
	private Long pageNumber;
	/** When set pagination property, initialize the page size. */
	private Long pageSize;
	/** When set pagination property, initialize the page size selecting list. */
	private String pageList;
	/** When request remote data, sending additional parameters also. */
	private String queryParams;
	/** Defines which column can be sorted. */
	private String sortName;
	/** Defines the column sort order, can only be 'asc' or 'desc'. */
	private String sortOrder;
	/** Defines if to sort data from server. */
	private Boolean remoteSort;
	/** Defines if to show row header. */
	private Boolean showHeader;
	/** Defines if to show row footer. */
	private Boolean showFooter;
	/**
	 * The scrollbar width(when scrollbar is vertical) or height(when scrollbar
	 * is horizontal).
	 */
	private int scrollbarSize;
	/**
	 * Return style such as 'background:red'. The function take two parameter:
	 * rowIndex: the row index, start with 0 rowData: the record corresponding
	 * to this row
	 */
	private String rowStyler;

	/**
	 * Defines how to load data from remote server. Return false can abort this
	 * action. This function takes following parameters: param: the parameter
	 * object to pass to remote server. success(data): the callback function
	 * that will be called when retrieve data successfully. error(): the
	 * callback function that will be called when failed to retrieve data.
	 */
	private String loader;

	/**
	 * Return the filtered data to display. The function take one parameter
	 * 'data' that indicate the original data. You can change original source
	 * data to standard data format. This function must return standard data
	 * object that contain 'total' and 'rows' properties.
	 */
	private String loadFilter;
	/** Defines the editor when editing a row. */
	private String editors;
	/** Defines the view of datagrid. */
	private String view;
	
	private List<DataColumn> sortColumns=new ArrayList<DataColumn>();

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.lion.framework.model.BaseEntity#getId()
	 */
	public Long getId() {
		return this.id;
	}

	
	
	/**
	 * @return the type
	 */
	@Column(name="TYPE",length=30)
	public String getType() {
		return type;
	}



	/**
	 * @return the tableId
	 */
	@Column(name="TABLE_ID",length=30)
	public String getTableId() {
		return tableId;
	}

	
	
	/**
	 * @return the title
	 */
	@Column(name="TITLE",length=50)
	public String getTitle() {
		return title;
	}

	
	
	/**
	 * @return the showTitle
	 */
	@Column(name="SHOW_TITLE",length=50)
	public Boolean getShowTitle() {
		return showTitle;
	}

	/**
	 * @return the fit
	 */
	@Column(name="FIT")
	public Boolean getFit() {
		return fit;
	}

	/**
	 * @return the frozen
	 */
	@Column(name="FROZEN")
	public Boolean getFrozen() {
		return frozen;
	}

	/**
	 * @return the showGroup
	 */
	@Column(name="SHOW_GROUP")
	public Boolean getShowGroup() {
		return showGroup;
	}

	/**
	 * @return the pagination
	 */
	@Column(name="PAGINACTION")
	public Boolean getPagination() {
		return pagination;
	}

	/**
	 * @return the fitColumns
	 */
	@Column(name="FIT_COLUMNS")
	public Boolean getFitColumns() {
		return fitColumns;
	}

	/**
	 * @return the striped
	 */
	@Column(name="STRIPED")
	public Boolean getStriped() {
		return striped;
	}

	/**
	 * @return the method
	 */
	@Column(name="METHOD")
	public String getMethod() {
		return method;
	}

	/**
	 * @return the nowrap
	 */
	@Column(name="NOWRAP")
	public Boolean getNowrap() {
		return nowrap;
	}

	/**
	 * @return the url
	 */
	@Column(name="URL")
	public String getUrl() {
		return url;
	}

	/**
	 * @return the data
	 */
	@Column(name="DATA")
	public String getData() {
		return data;
	}

	/**
	 * @return the loadMsg
	 */
	@Column(name="LOADMSG")
	public String getLoadMsg() {
		return loadMsg;
	}

 

	/**
	 * @return the rownumbers
	 */
	@Column(name="ROW_NUMBERS")
	public Boolean getRownumbers() {
		return rownumbers;
	}

	/**
	 * @return the singleSelect
	 */
	@Column(name="SINGLE_SELECT")
	public Boolean getSingleSelect() {
		return singleSelect;
	}

	/**
	 * @return the checkOnSelect
	 */
	@Column(name="CHECK_ON_SEELCT")
	public Boolean getCheckOnSelect() {
		return checkOnSelect;
	}

	/**
	 * @return the selectOnCheck
	 */
	@Column(name="SELECT_ON_CHECK")
	public Boolean getSelectOnCheck() {
		return selectOnCheck;
	}

	/**
	 * @return the pagePosition
	 */
	@Column(name="PAGE_POSITION")
	public String getPagePosition() {
		return pagePosition;
	}

	/**
	 * @return the pageNumber
	 */
	@Column(name="PAGE_NUMBER")
	public Long getPageNumber() {
		return pageNumber;
	}

	/**
	 * @return the pageSize
	 */
	@Column(name="PAGE_SIZE")
	public Long getPageSize() {
		return pageSize;
	}

	/**
	 * @return the pageList
	 */
	@Column(name="PAGE_LIST")
	public String getPageList() {
		return pageList;
	}

	/**
	 * @return the queryParams
	 */
	@Column(name="QUERY_PARAMS")
	public String getQueryParams() {
		return queryParams;
	}

	/**
	 * @return the sortName
	 */
	@Column(name="SORT_NAME")
	public String getSortName() {
		return sortName;
	}

	/**
	 * @return the sortOrder
	 */
	@Column(name="SORT_ORDER")
	public String getSortOrder() {
		return sortOrder;
	}

	/**
	 * @return the remoteSort
	 */
	@Column(name="REMOTE_SORT")
	public Boolean getRemoteSort() {
		return remoteSort;
	}

	/**
	 * @return the showHeader
	 */
	@Column(name="SHOW_HEADER")
	public Boolean getShowHeader() {
		return showHeader;
	}

	/**
	 * @return the showFooter
	 */
	@Column(name="SHOW_FOOTER")
	public Boolean getShowFooter() {
		return showFooter;
	}

	/**
	 * @return the scrollbarSize
	 */
	@Column(name="SCROLLBER_SIZE")
	public int getScrollbarSize() {
		return scrollbarSize;
	}

	/**
	 * @return the rowStyler
	 */
	@Column(name="ROW_STYLER")
	public String getRowStyler() {
		return rowStyler;
	}

	/**
	 * @return the loader
	 */
	@Column(name="LOADER")
	public String getLoader() {
		return loader;
	}

	/**
	 * @return the loadFilter
	 */
	@Column(name="LOAD_FILTER")
	public String getLoadFilter() {
		return loadFilter;
	}

	/**
	 * @return the editors
	 */
	@Transient
	public String getEditors() {
		return editors;
	}

	/**
	 * @return the view
	 */
	@Transient
	public String getView() {
		return view;
	}
	

	/**
	 * @return the columns
	 */
	@OneToMany(cascade=CascadeType.MERGE,fetch=FetchType.LAZY)
	@JoinColumn(name = "BAS_DATAGRID_ID", updatable = false, insertable = false)
	public Set<DataColumn> getColumns() {
		return columns;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @param tableId the tableId to set
	 */
	public void setTableId(String tableId) {
		this.tableId = tableId;
	}

	/**
	 * @param fit the fit to set
	 */
	public void setFit(Boolean fit) {
		this.fit = fit;
	}

	/**
	 * @param frozen the frozen to set
	 */
	public void setFrozen(Boolean frozen) {
		this.frozen = frozen;
	}

	/**
	 * @param showGroup the showGroup to set
	 */
	public void setShowGroup(Boolean showGroup) {
		this.showGroup = showGroup;
	}

	/**
	 * @param columns the columns to set
	 */
	public void setColumns(Set<DataColumn> columns) {
		this.columns = columns;
	}

	/**
	 * @param pagination the pagination to set
	 */
	public void setPagination(Boolean pagination) {
		this.pagination = pagination;
	}

	/**
	 * @param fitColumns the fitColumns to set
	 */
	public void setFitColumns(Boolean fitColumns) {
		this.fitColumns = fitColumns;
	}

	/**
	 * @param striped the striped to set
	 */
	public void setStriped(Boolean striped) {
		this.striped = striped;
	}

	/**
	 * @param method the method to set
	 */
	public void setMethod(String method) {
		this.method = method;
	}

	/**
	 * @param nowrap the nowrap to set
	 */
	public void setNowrap(Boolean nowrap) {
		this.nowrap = nowrap;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(String data) {
		this.data = data;
	}

	/**
	 * @param loadMsg the loadMsg to set
	 */
	public void setLoadMsg(String loadMsg) {
		this.loadMsg = loadMsg;
	}

	/**
	 * @param rownumbers the rownumbers to set
	 */
	public void setRownumbers(Boolean rownumbers) {
		this.rownumbers = rownumbers;
	}

	/**
	 * @param singleSelect the singleSelect to set
	 */
	public void setSingleSelect(Boolean singleSelect) {
		this.singleSelect = singleSelect;
	}

	/**
	 * @param checkOnSelect the checkOnSelect to set
	 */
	public void setCheckOnSelect(Boolean checkOnSelect) {
		this.checkOnSelect = checkOnSelect;
	}

	/**
	 * @param selectOnCheck the selectOnCheck to set
	 */
	public void setSelectOnCheck(Boolean selectOnCheck) {
		this.selectOnCheck = selectOnCheck;
	}

	/**
	 * @param pagePosition the pagePosition to set
	 */
	public void setPagePosition(String pagePosition) {
		this.pagePosition = pagePosition;
	}

	/**
	 * @param pageNumber the pageNumber to set
	 */
	public void setPageNumber(Long pageNumber) {
		this.pageNumber = pageNumber;
	}

	/**
	 * @param pageSize the pageSize to set
	 */
	public void setPageSize(Long pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * @param pageList the pageList to set
	 */
	public void setPageList(String pageList) {
		this.pageList = pageList;
	}

	/**
	 * @param queryParams the queryParams to set
	 */
	public void setQueryParams(String queryParams) {
		this.queryParams = queryParams;
	}

	/**
	 * @param sortName the sortName to set
	 */
	public void setSortName(String sortName) {
		this.sortName = sortName;
	}

	/**
	 * @param sortOrder the sortOrder to set
	 */
	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}

	/**
	 * @param remoteSort the remoteSort to set
	 */
	public void setRemoteSort(Boolean remoteSort) {
		this.remoteSort = remoteSort;
	}

	/**
	 * @param showHeader the showHeader to set
	 */
	public void setShowHeader(Boolean showHeader) {
		this.showHeader = showHeader;
	}

	/**
	 * @param showFooter the showFooter to set
	 */
	public void setShowFooter(Boolean showFooter) {
		this.showFooter = showFooter;
	}

	/**
	 * @param scrollbarSize the scrollbarSize to set
	 */
	public void setScrollbarSize(int scrollbarSize) {
		this.scrollbarSize = scrollbarSize;
	}

	/**
	 * @param rowStyler the rowStyler to set
	 */
	public void setRowStyler(String rowStyler) {
		this.rowStyler = rowStyler;
	}

	/**
	 * @param loader the loader to set
	 */
	public void setLoader(String loader) {
		this.loader = loader;
	}

	/**
	 * @param loadFilter the loadFilter to set
	 */
	public void setLoadFilter(String loadFilter) {
		this.loadFilter = loadFilter;
	}

	/**
	 * @param editors the editors to set
	 */
	public void setEditors(String editors) {
		this.editors = editors;
	}

	/**
	 * @param view the view to set
	 */
	public void setView(String view) {
		this.view = view;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	

	/**
	 * @param showTitle the showTitle to set
	 */
	public void setShowTitle(Boolean showTitle) {
		this.showTitle = showTitle;
	}

	@Transient
	public List<DataColumn> getSortColumns() {
		return sortColumns;
	}

	public void setSortColumns(List<DataColumn> sortColumns) {
		this.sortColumns = sortColumns;
	}
	
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}	
}