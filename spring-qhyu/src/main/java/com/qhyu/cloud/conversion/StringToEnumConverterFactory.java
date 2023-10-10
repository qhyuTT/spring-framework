package com.qhyu.cloud.conversion;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;

/**
 * All rights Reserved, Designed By https://umd.edu/ <br>
 * Title：StringToEnumConverterFactory <br>
 * Package：com.qhyu.cloud.conversion <br>
 * Copyright © 2023 umd.edu. All rights reserved. <br>
 * Company：The University of Maryland  <br>
 *
 * @author candidate <br>
 * @date 2023年 10月10日 10:12 <br>
 */
@SuppressWarnings(value = {"rawtypes","unchecked"})
public class StringToEnumConverterFactory implements ConverterFactory<String,Enum> {

	@Override
	public <T extends Enum> Converter<String, T> getConverter( Class<T> targetType) {
		return new StringToEnumConverter<>(targetType);
	}

	private static final class StringToEnumConverter<T extends Enum> implements Converter<String, T> {

		private final Class<T> enumType;

		public StringToEnumConverter(Class<T> enumType) {
			this.enumType = enumType;
		}

		public T convert(String source) {
			return (T) Enum.valueOf(this.enumType, source.trim());
		}
	}
}
