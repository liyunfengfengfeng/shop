package com.changjiang.viewModel;

import java.util.List;

/**
 * 用于向前端传递function数据
 * @author Administrator
 *
 */
public class FunctionNestNode {
	private Integer id;
	private String icon;
	private String name;
	private Integer child;//0无1有
	private String urls;
	private List<FunctionNestNode> nodes;
	public String getUrls() {
		return urls;
	}
	public void setUrls(String urls) {
		this.urls = urls;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getChild() {
		return child;
	}
	public void setChild(Integer child) {
		this.child = child;
	}
	public List<FunctionNestNode> getNodes() {
		return nodes;
	}
	public void setNodes(List<FunctionNestNode> nodes) {
		this.nodes = nodes;
	}
	
}
