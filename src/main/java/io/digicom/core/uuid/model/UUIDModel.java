package io.digicom.core.uuid.model;

import java.io.Serializable;
import java.util.UUID;

public class UUIDModel implements Serializable {
	

	private static final long serialVersionUID = -4704777149181849049L;
	private UUID uuid;

	public UUID getUuid() {
		return uuid;
	}

	public UUIDModel setUuid(UUID uuid) {
		this.uuid = uuid;
		return this;
	}

	@Override
	public String toString() {
		return "UUIDModel [uuid=" + uuid + "]";
	}
	
	

	
	
	

}
