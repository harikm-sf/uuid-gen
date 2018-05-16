package io.digicom.core.uuid.service;

import java.util.Date;
import java.util.UUID;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import io.digicom.core.uuid.model.UUIDModel;


@Service
public class UUIDModelGeneratorImpl extends BaseService implements UUIDModelGenerator {
	

	@Override
	@Async
	public UUIDModel getUUIDModel() {
		UUIDModel model = new UUIDModel();
		UUID uuid =UUID.randomUUID();
		String base64 = Base64.encodeBase64String(uuid.toString().getBytes());
		model.setUuid(uuid)
		.setDateTime(new Date())
		.setBase64(base64);
		logger.trace("Generated UUID Model :" + model.toString());
		return model;
	}
	
	

}
