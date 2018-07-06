package io.digicom.core.uuid.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.UUID;

public class UUIDModel implements Serializable {
	

	private static final long serialVersionUID = -4704777149181849049L;
	private UUID uuid;
	
	private String base64;
	
	private String md5Hex;
	
	private byte[] md5;
	
	private Date dateTime;
	
	private long procTimeMillis;
	

	public long getProcTime() {
		return procTimeMillis;
	}

	public UUIDModel setProcTime(long procTime) {
		this.procTimeMillis = procTime;
		return this;
	}

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

	public String getMd5Hex() {
		return md5Hex;
	}

	public UUIDModel setMd5Hex(String md5Hex) {
		this.md5Hex = md5Hex;
		return this;
	}

	public byte [] getMd5() {
		return md5;
	}

	public UUIDModel setMd5(byte [] md5) {
		this.md5 = md5;
		return this;
	}

	@Override
	public String toString() {
		return "UUIDModel [uuid=" + uuid + ", base64=" + base64 + ", md5Hex=" + md5Hex + ", md5=" + Arrays.toString(md5)
				+ ", dateTime=" + dateTime + "]";
	}



	
	
	

	
	
	

}
