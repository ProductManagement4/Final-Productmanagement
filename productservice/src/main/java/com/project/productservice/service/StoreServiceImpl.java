package com.project.productservice.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.productservice.dao.StoreDao;
import com.project.productservice.entity.ProductEntity;
import com.project.productservice.entity.StoreEntity;
import com.project.productservice.pojo.ProductPojo;
import com.project.productservice.pojo.StorePojo;
import org.apache.log4j.Logger;

@Service
public class StoreServiceImpl implements StoreService {
	static Logger LOG = Logger.getLogger(StoreServiceImpl.class.getClass());

	@Autowired
	StoreDao storeDao;

	@Override
	public StorePojo getStores(Integer storeId) {

		LOG.info("Enterd getStores()");

		StorePojo storePojo = null;
		Optional result = storeDao.findById(storeId);
		if (result.isPresent()) {
			StoreEntity storeEntity = (StoreEntity) result.get();
			ProductEntity productEntity = (ProductEntity) storeEntity.getAllProducts();
			ProductPojo productPojo = new ProductPojo(productEntity.getId(), productEntity.getName(),
					productEntity.getImage(), productEntity.getPrice(), productEntity.getQuantity(),
					productEntity.getDescription(), storePojo);
			storePojo = new StorePojo(storeEntity.getId(), storeEntity.getName(), storeEntity.getLocation(),
					storeEntity.getDate(), null);
		}

		return storePojo;

	}

	@Override
	public boolean addStore(StorePojo storePojo) {
		StoreEntity storeEntity = new StoreEntity();
		storeEntity.setId(0);
		storeEntity.setName(storePojo.getName());
		storeEntity.setLocation(storePojo.getLocation());
		storeEntity.setDate(storePojo.getDate());
		storeEntity = storeDao.saveAndFlush(storeEntity);
		storePojo.setId(storeEntity.getId());

		return true;
	}

	@Override
	public StorePojo getstore(Integer storeId) {

		StorePojo storePojo = null;
		List<ProductPojo> allProductsPojo = new ArrayList<ProductPojo>();
		Optional result = storeDao.findById(storeId);
		if (result.isPresent()) {
			StoreEntity storeEntity = (StoreEntity) result.get();
			List<ProductEntity> allProductsEntity = storeEntity.getAllProducts();
			for (ProductEntity p : allProductsEntity) {
				ProductPojo temp = new ProductPojo(p.getId(), p.getName(), p.getImage(), p.getPrice(), p.getQuantity(),
						p.getDescription(), null);
				allProductsPojo.add(temp);
			}
			storePojo = new StorePojo(storeEntity.getId(), storeEntity.getName(), storeEntity.getLocation(),
					storeEntity.getDate(), allProductsPojo);
		}
		return storePojo;

	}

	@Override
	public List<StorePojo> getAllStores() {

		List<StorePojo> allStorePojo = new ArrayList();
		Iterable<StoreEntity> allStoreEntity = storeDao.findAll();
		Iterator itr = allStoreEntity.iterator();

		while (itr.hasNext()) {
			StoreEntity storeEntity = (StoreEntity) itr.next();
			StorePojo storePojo = new StorePojo(storeEntity.getId(), storeEntity.getName(), storeEntity.getLocation(),
					storeEntity.getDate(), null);
			allStorePojo.add(storePojo);

		}
		return allStorePojo;
	}

}
