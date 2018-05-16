package io.digicom.core.uuid.service;

import java.util.UUID;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import io.digicom.core.uuid.model.UUIDModel;


@Service
public class UUIDModelGeneratorImpl extends BaseService implements UUIDModelGenerator {
	

	@Override
	@Async
	public UUIDModel getUUIDModel() {
		UUIDModel model = new UUIDModel();
		model.setUuid(UUID.randomUUID());
		return model;
	}
	
	

}
