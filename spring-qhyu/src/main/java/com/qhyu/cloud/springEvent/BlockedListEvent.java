package com.qhyu.cloud.springEvent;

import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ApplicationContextEvent;

import java.io.Serializable;

/**
 * All rights Reserved, Designed By http://xnky.travelsky.net/ <br>
 * Title：BlockedListEvent <br>
 * Package：com.qhyu.cloud.springEvent <br>
 * Copyright © 2023 xnky.travelsky.net Inc. All rights reserved. <br>
 * Company：Aviation Cares Of Southwest Chen Du LTD  <br>
 * @author piano <br>
 * date 2023年 10月08日 10:23 <br>
 * @version v1.0 <br>
 */
public class BlockedListEvent extends ApplicationContextEvent implements Serializable {

	private static final long serialVersionUID = 1L;
	private final String address;
	private final String content;

	/**
	 * Create a new ContextStartedEvent.
	 * @param source the {@code ApplicationContext} that the event is raised for
	 *               (must not be {@code null})
	 */
	public BlockedListEvent(ApplicationContext source, String address, String content) {
		super(source);
		this.address = address;
		this.content = content;
	}

	public String getAddress() {
		return address;
	}

	public String getContent() {
		return content;
	}
}
