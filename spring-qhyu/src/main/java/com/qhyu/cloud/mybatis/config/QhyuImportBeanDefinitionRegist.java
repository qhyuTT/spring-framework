package com.qhyu.cloud.mybatis.config;

import com.qhyu.cloud.mybatis.annotation.QhyuSanner;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;
import java.util.Map;

/**
 * All rights Reserved, Designed By http://xnky.travelsky.net/ <br>
 * Title：QhyuImportBeanDefinitionRegist <br>
 * Package：com.qhyu.cloud.mybatis.config <br> 
 * Copyright © 2022 xnky.travelsky.net Inc. All rights reserved. <br>
 * Company：Aviation Cares Of Southwest Chen Du LTD  <br>
 * @author 于琦海 <br>
 * date 2022年 05月30日 10:43 <br>
 * @version v1.0 <br>
 */
public class QhyuImportBeanDefinitionRegist implements ImportBeanDefinitionRegistrar {

	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		// 这里就是为了将我mapper包下的接口进行扫描，然后生成BeanDefinition到Spring中进行注册
		Map<String, Object> annotationAttributes =
				importingClassMetadata.getAnnotationAttributes(QhyuSanner.class.getName());
		String path = (String) annotationAttributes.get("value");
		System.out.println("我的扫描路径为:"+path);
		QhyuConfigSanner qhyuConfigSanner = new QhyuConfigSanner(registry);
		// 添加了一个包含过滤器，所以可以让其接口不被跳过
		qhyuConfigSanner.addIncludeFilter(new TypeFilter() {
			@Override
			public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
				return true;
			}
		});
		 qhyuConfigSanner.scan(path);
	}
}
