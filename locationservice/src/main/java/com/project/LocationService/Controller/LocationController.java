package com.project.LocationService.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.project.LocationService.Pojo.StorePojo;
import io.swagger.annotations.Api;

@CrossOrigin
@RestController
@Api
public class LocationController {

	@GetMapping("/location/{storeId}")
	String getLocations(@PathVariable("storeId") Integer id) {
		RestTemplate restTemplate = new RestTemplate();
		StorePojo storePojo = restTemplate.getForObject("http://localhost:8083/productservice/store/" + id,
				StorePojo.class);

		String location = storePojo.getLocation();
		return location;

	}

}
