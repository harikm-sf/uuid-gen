package io.digicom.core.uuid.service;

import java.io.UnsupportedEncodingException;

import org.springframework.stereotype.Service;

import io.digicom.core.uuid.model.UUIDModel;
@Service
public interface UUIDModelGenerator {

	UUIDModel getUUIDModel() throws UnsupportedEncodingException;

}