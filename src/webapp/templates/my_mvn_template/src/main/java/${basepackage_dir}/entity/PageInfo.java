<#include "/java_copyright.include">
package ${basepackage}.entity;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.criterion.Criterion;

public class PageInfo {

	/**
	 * 分页大小，默认值为10
	 * */
	private int pageSize = 10;
	/**
	 * 总页数
	 * */
	private int totalPages = 0;
	/**
	 * 当前页数
	 * */
	private int currentPage = 1;
	/**
	 * 记录总条数
	 * */
	private int totalCounts = 0;
	/**
	 * 当前页开始显示记录数
	 * */
	private int firstResult = 0;
	
	/**
	 * 排序类型(ASC,DESC)
	 */
	private String sortType;
	/**
	 * 排序属性
	 */
	private String sortAttribute;
	
	/**
	 * 精确匹配 and
	 */
	private Map<String, Object> querys = new HashMap<String, Object>();
	
	//private Criterion restrictions;
	/**
	 * 模糊匹配 or
	 */
	private Map<String, Object> matchMaps=new HashMap<String, Object>(); 
	
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalPages() {
		return (this.totalCounts - 1) / this.pageSize + 1;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalCounts() {
		return totalCounts;
	}
	public void setTotalCounts(int totalCounts) {
		this.totalCounts = totalCounts;
	}
	public int getFirstResult() {
		return (currentPage - 1) * pageSize ;
	}
	public void setFirstResult(int firstResult) {
		this.firstResult = firstResult;
	}
	public String getSortType() {
		return sortType;
	}
	public void setSortType(String sortType) {
		this.sortType = sortType;
	}
	public String getSortAttribute() {
		return sortAttribute;
	}
	public void setSortAttribute(String sortAttribute) {
		this.sortAttribute = sortAttribute;
	}
	public Map<String, Object> getQuerys() {
		return querys;
	}
	public void setQuerys(Map<String, Object> querys) {
		this.querys = querys;
	}
//	public Criterion getRestrictions() {
//		return restrictions;
//	}
//	public void setRestrictions(Criterion restrictions) {
//		this.restrictions = restrictions;
//	}
	public Map<String, Object> getMatchMaps() {
		return matchMaps;
	}
	public void setMatchMaps(Map<String, Object> matchMaps) {
		this.matchMaps = matchMaps;
	}
	
}

