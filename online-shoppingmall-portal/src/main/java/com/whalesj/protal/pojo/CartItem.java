package com.whalesj.protal.pojo;
/**
 * 购物车商品的pojo
 * @author wushijia
 *
 */
public class CartItem {
	private Long id;
	
	private String title;
	
	private String image;
	
	private Long price;
	
	private Integer num;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	
	
}
