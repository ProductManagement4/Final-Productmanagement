package com.project.productservice.service;

import java.util.List;
import com.project.productservice.pojo.StorePojo;

public interface StoreService {

	StorePojo getStores(Integer storeId);

	StorePojo getstore(Integer storeId);

	boolean addStore(StorePojo storePojo);

	List<StorePojo> getAllStores();

}
