package io.digicom.core.uuid.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.digicom.core.uuid.model.UUIDModel;
import io.digicom.core.uuid.service.UUIDFactory;

@RestController
public class UUIDController  {
	
	@Autowired
	UUIDFactory uuidFactory;
	
	@RequestMapping(value = "/uuid", method = RequestMethod.GET, produces = "application/json")
	public List<UUIDModel> getUUID() throws UnsupportedEncodingException {
		return uuidFactory.getOne();
	}
	
	@RequestMapping(value = "/uuid/{num}", method = RequestMethod.GET, produces = "application/json")
	public List<UUIDModel> getUUID2(@PathVariable(value="num") int num) throws UnsupportedEncodingException {
		return uuidFactory.getMany(num);
	}

}
