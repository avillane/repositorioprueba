package com.everis.util;

import java.io.IOException;
import java.util.ArrayList;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;


public class FileToObjectLoader {
	private static final ObjectMapper mapper;

	static {
		mapper = new ObjectMapper();
		mapper.findAndRegisterModules();
	}

	public static <T> T readDataFromFile(String fileName, Class<T> tdClass) throws IOException {
		return mapper.readValue(FileToObjectLoader.class.getClassLoader().getResourceAsStream(fileName), tdClass);
	}

	public static <T> T readDataFromFileAsList(String fileName, Class<T> resultClass) {
		CollectionType listType = mapper.getTypeFactory().constructCollectionType(ArrayList.class, resultClass);
		try {
			return mapper.readValue(FileToObjectLoader.class.getClassLoader().getResourceAsStream(fileName), listType);
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

}
