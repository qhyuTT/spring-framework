package com.qhyu.cloud.conversion;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.support.GenericConversionService;

/**
 * All rights Reserved, Designed By https://umd.edu/ <br>
 * Title：Test <br>
 * Package：com.qhyu.cloud.conversion <br>
 * Copyright © 2023 umd.edu. All rights reserved. <br>
 * Company：The University of Maryland  <br>
 * @author candidate <br>
 * @date 2023年 10月10日 10:20 <br>
 */
public class Test {
	/**
	 * Title: main
	 * @author  candidate
	 * @date  2023/10/10 10:20
	 * @since  2023/10/10
	 * @param args String
	 */
	public static void main(String[] args) {
		StringToEnumConverterFactory stringToEnumConverterFactory = new StringToEnumConverterFactory();
		Converter<String, ConversionEnum> converter = stringToEnumConverterFactory.getConverter(ConversionEnum.class);
		System.out.println(converter.convert("A"));
		GenericConversionService genericConversionService = new GenericConversionService();
		genericConversionService.addConverter(converter);
		System.out.println(genericConversionService.convert("A", Enum.class));
	}
}
