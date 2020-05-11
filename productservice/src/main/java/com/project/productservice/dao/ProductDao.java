package com.project.productservice.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.project.productservice.entity.ProductEntity;
import com.project.productservice.entity.StoreEntity;

@Repository
public interface ProductDao extends JpaRepository<ProductEntity, Integer> {

	int countByStoreId(int id);

	List<ProductEntity> findByStoreId(StoreEntity storeEntity);

}
