package com.project.productservice;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import com.project.productservice.dao.ProductDao;
import com.project.productservice.entity.ProductEntity;
import com.project.productservice.entity.StoreEntity;
import com.project.productservice.pojo.ProductPojo;
import com.project.productservice.pojo.StorePojo;
import com.project.productservice.service.ProductService;

@RunWith(SpringRunner.class)
@SpringBootTest

class ProductserviceApplicationTests {

	@Autowired
	private ProductService productService;

	@MockBean
	private ProductDao productDao;

	@Test
	void contextLoads() {
		StorePojo str = new StorePojo();
		str.setId(101);
		StoreEntity strEntity = new StoreEntity();
		strEntity.setId(101);
		ProductPojo outputPojo = new ProductPojo(1, "name", "img", 123, 1, "desc", str);
		ProductEntity prodEntity = new ProductEntity(1, "name", "img", 123, 1, "desc", strEntity);
		when(productDao.findById(1)).thenReturn(Optional.of(prodEntity));
		assertEquals(outputPojo.getName(), productService.getproduct(1).getName());
	}

}
