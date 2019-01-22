package com.springmvc.website.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity()
@Table(name="Menu")
public class Menu {
	
	@Id
	@Column(name="Id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="parent_id")
	private Integer parentId;
	@Column(name="is_visible")
	private Boolean isVisible;
	@Column(name="content")
	private String content;
	@Column(name="category")
	private String category;
	@Column(name="url")
	private String url;
	@Column(name="is_dropdown")
	private Boolean isDropdown;
	
	@Transient
	private List<Menu> subMenu;
	
	
	
	public Boolean getIsVisible() {
		return isVisible;
	}
	public void setIsVisible(Boolean isVisible) {
		this.isVisible = isVisible;
	}
	public Boolean getIsDropdown() {
		return isDropdown;
	}
	public void setIsDropdown(Boolean isDropdown) {
		this.isDropdown = isDropdown;
	}
	public List<Menu> getSubMenu() {
		return subMenu;
	}
	public void setSubMenu(List<Menu> subMenu) {
		this.subMenu = subMenu;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

}
