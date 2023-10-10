package com.qhyu.cloud.conversion;

import org.springframework.core.convert.converter.Converter;

import javax.annotation.Nonnull;

/**
 * All rights Reserved, Designed By http://xnky.travelsky.net/ <br>
 * Title：StringToInteger <br>
 * Package：com.qhyu.cloud.conversion <br>
 * Copyright © 2023 xnky.travelsky.net Inc. All rights reserved. <br>
 * Company：Aviation Cares Of Southwest Chen Du LTD  <br>
 * @author piano <br>
 * @date 2023年 10月09日 14:47 <br>
 * @version v1.0 <br>
 */
public class StringToInteger implements Converter<String,Integer> {

	@Override
	public Integer convert(@Nonnull String source) {
		return Integer.valueOf(source);
	}

}
