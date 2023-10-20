package com.productservice.productservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ProductController {
	
	List<ProductInfo> productList = new ArrayList<ProductInfo>();
	
	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/products/details/{productId}")
	public Product getProductDetails(@PathVariable("productId") Long productid) {
		
		Price price = restTemplate
				.getForObject("http://localhost:8002/price/details/"+productid, Price.class);
		Inventory inventory = restTemplate
				.getForObject("http://localhost:8003/inventory/details/"+productid, Inventory.class);
		
		ProductInfo productInfo = getProductInfo(productid);
		
		return new Product(productInfo.getProductId(),productInfo.getProductName(),
				productInfo.getProductDesc(),price.getDiscountPrice(),inventory.getIsStock());
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
