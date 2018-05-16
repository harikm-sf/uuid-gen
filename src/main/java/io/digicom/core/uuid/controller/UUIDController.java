package io.digicom.core.uuid.controller;

import java.io.Serializable;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
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
	public UUIDModel getUUID() {
		return uuidFactory.getOne();
	}
	
	@RequestMapping(value = "/uuid2", method = RequestMethod.GET, produces = "application/json")
	public UUIDModel getUUID2() {
		UUIDModel model = new UUIDModel();
		model.setUuid(UUID.randomUUID());
		return model;
	}

}
