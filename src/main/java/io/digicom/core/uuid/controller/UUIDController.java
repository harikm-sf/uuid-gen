package io.digicom.core.uuid.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.digicom.core.uuid.model.UUIDModel;
import io.digicom.core.uuid.service.UUIDFactory;

@RestController
public class UUIDController  {
	
	@Autowired
	UUIDFactory uuidFactory;
	
	/*@RequestMapping(value = "/uuid", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	@ResponseBody
	public List<UUIDModel> getUUID() throws UnsupportedEncodingException {
		return uuidFactory.getOne();
	}*/
	
	@RequestMapping(value = {"/{num}", "/", ""}, method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	@ResponseBody
	public ResponseEntity<List<UUIDModel>> getUUID2(@Nullable @PathVariable(value="num") Integer num) throws UnsupportedEncodingException {
		long start = System.currentTimeMillis();
		num = (num == null || num <= 0) ? 1 : num;
		List<UUIDModel> returnVal = uuidFactory.getMany(num.intValue());
		long end = System.currentTimeMillis();
		long procTime = end - start;
		
		//long totalGenTime =0;
		
		//returnVal.forEach(model -> totalGenTime += model.getProcTime());
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("Stats", Long.toString(procTime));
		
		return new ResponseEntity<List<UUIDModel>>(returnVal, responseHeaders, HttpStatus.OK);
	}
	
	

}
