package com.productservice.productservice;

public class Product {

	private Long productId;
	private String productName;
	private String productDesc;
	private Integer productPrice;
	private Boolean productStock;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public Integer getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Integer productPrice) {
		this.productPrice = productPrice;
	}

	public Boolean getProductStock() {
		return productStock;
	}

	public void setProductStock(Boolean productStock) {
		this.productStock = productStock;
	}

	public Product() {
		super();
	}

	public Product(Long productId, String productName, String productDesc, Integer productPrice, Boolean productStock) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productDesc = productDesc;
		this.productPrice = productPrice;
		this.productStock = productStock;
	}

}
