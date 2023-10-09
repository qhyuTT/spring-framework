package com.qhyu.cloud.springEvent;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

/**
 * All rights Reserved, Designed By http://xnky.travelsky.net/ <br>
 * Title：EmailService <br>
 * Package：com.qhyu.cloud.springEvent <br>
 * Copyright © 2023 xnky.travelsky.net Inc. All rights reserved. <br>
 * Company：Aviation Cares Of Southwest Chen Du LTD  <br>
 *
 * @author piano <br>
 * date 2023年 10月08日 10:28 <br>
 * @version v1.0 <br>
 */
@Component
public class EmailService implements ApplicationEventPublisherAware, ApplicationContextAware {

	// 使用ApplicationEventPublisher应用事件发布器发布事件
	private ApplicationEventPublisher applicationEventPublisher;
	private ApplicationContext applicationContext;

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		this.applicationEventPublisher = applicationEventPublisher;
	}

	public void sendEmail(String address, String content) {
		applicationEventPublisher.publishEvent(new BlockedListEvent(applicationContext, address, content));
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext=applicationContext;
	}
}
