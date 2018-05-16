package io.digicom.core.uuid.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import io.digicom.core.uuid.model.UUIDModel;
@Service
public interface UUIDModelGenerator {

	UUIDModel getUUIDModel();

}