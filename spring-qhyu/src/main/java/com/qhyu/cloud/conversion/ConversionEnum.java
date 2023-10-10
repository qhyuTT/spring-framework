package com.qhyu.cloud.conversion;

/**
 * All rights Reserved, Designed By https://umd.edu/ <br>
 * Title：ConversionEnum <br>
 * Package：com.qhyu.cloud.conversion <br>
 * Copyright © 2023 umd.edu. All rights reserved. <br>
 * Company：The University of Maryland  <br>
 *
 * @author candidate <br>
 * @date 2023年 10月10日 10:23 <br>
 */
public enum ConversionEnum {
	A("a","A");
	private String code;
	private String des;
	ConversionEnum(String code, String des) {
		this.code=code;
		this.des=des;
	}

	private String getCode(){
		return code;
	}

	private String getDes(){
		return des;
	}
}
