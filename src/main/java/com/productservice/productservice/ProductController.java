package com.productservice.productservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
	
	List<ProductInfo> productList = new ArrayList<ProductInfo>();

	@GetMapping("/products/details/{productId}")
	public Product getProductDetails(@PathVariable("productId") Long productid) {
		
		ProductInfo productInfo = getProductInfo(productid);
		
		return new Product(productInfo.getProductId(),productInfo.getProductName(),
				productInfo.getProductDesc(),999,true);
	}

	private ProductInfo getProductInfo(Long productid) {
		populateProductList();
		for(ProductInfo p : productList) {
			if(productid.equals(p.getProductId())) {
				return p;
			}
		}
		return null;
	}

	private void populateProductList() {
		productList.add(new ProductInfo(101L,"iPhone","iPhone is more expensive"));
		productList.add(new ProductInfo(102L,"Book","Book is good"));
		productList.add(new ProductInfo(103L,"washing MC","Washing machine is necessory"));
	}
	
}
