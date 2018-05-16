package io.digicom.core.uuid.model;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

public class UUIDModel implements Serializable {
	

	private static final long serialVersionUID = -4704777149181849049L;
	private UUID uuid;
	
	private Date dateTime;

	public UUID getUuid() {
		return uuid;
	}

	public UUIDModel setUuid(UUID uuid) {
		this.uuid = uuid;
		return this;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public UUIDModel setDateTime(Date dateTime) {
		this.dateTime = dateTime;
		return this;
	}

	
	
	

	
	
	

}
