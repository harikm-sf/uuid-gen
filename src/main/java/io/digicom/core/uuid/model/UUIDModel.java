package io.digicom.core.uuid.model;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

public class UUIDModel implements Serializable {
	

	private static final long serialVersionUID = -4704777149181849049L;
	private UUID uuid;
	
	private Date dateTime;
	
	private String base64;

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

	public String getBase64() {
		return base64;
	}

	public UUIDModel setBase64(String base64) {
		this.base64 = base64;
		return this;
	}

	@Override
	public String toString() {
		return "UUIDModel [uuid=" + uuid + ", dateTime=" + dateTime + ", base64=" + base64 + "]";
	}

	
	
	

	
	
	

}
