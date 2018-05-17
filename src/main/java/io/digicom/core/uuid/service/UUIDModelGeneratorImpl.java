package io.digicom.core.uuid.service;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.UUID;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import io.digicom.core.uuid.model.UUIDModel;


@Service
public class UUIDModelGeneratorImpl extends BaseService implements UUIDModelGenerator {
	

	@Override
	//@Async
	public UUIDModel getUUIDModel() throws UnsupportedEncodingException {
		UUIDModel model = new UUIDModel();
		UUID uuid =UUID.randomUUID();
		byte[] bytesOfUUID = uuid.toString().getBytes("UTF-8");
		String base64 = Base64.encodeBase64String(bytesOfUUID);
		String md5Hex = DigestUtils.md5DigestAsHex(bytesOfUUID);
		byte [] md5 = DigestUtils.md5Digest(bytesOfUUID);
		
		model.setUuid(uuid)
		.setDateTime(new Date())
			.setBase64(base64)
				.setMd5(md5)
					.setMd5Hex(md5Hex);
		
		logger.trace("Generated UUID Model :" + model.toString());
		return model;
	}
	
	

}
