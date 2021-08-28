package com.store.grocery.utils;

import java.util.AbstractMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.http.HttpStatus;

public class HttpCodes {
		
		public static Map<Object,HttpStatus> codesMap = Stream.of(
				  new AbstractMap.SimpleEntry<>(CodesEnum.OK.getstatusCode(), HttpStatus.OK),
				  new AbstractMap.SimpleEntry<>(CodesEnum.DATA_NOT_FOUND.getstatusCode(), HttpStatus.NOT_FOUND),
				  new AbstractMap.SimpleEntry<>(CodesEnum.EMPTY_REQUEST.getstatusCode(), HttpStatus.BAD_REQUEST),
				  new AbstractMap.SimpleEntry<>(CodesEnum.PERSISTENCE_ERROR.getstatusCode(), HttpStatus.INTERNAL_SERVER_ERROR),
				  new AbstractMap.SimpleEntry<>(CodesEnum.CREATE.getstatusCode(), HttpStatus.CREATED),
				  new AbstractMap.SimpleEntry<>(CodesEnum.UPDATE.getstatusCode(), HttpStatus.OK))
				  .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
}
