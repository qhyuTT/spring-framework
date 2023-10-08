package com.qhyu.cloud.springEvent;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * All rights Reserved, Designed By http://xnky.travelsky.net/ <br>
 * Title：BlockedListNotifier <br>
 * Package：com.qhyu.cloud.springEvent <br>
 * Copyright © 2023 xnky.travelsky.net Inc. All rights reserved. <br>
 * Company：Aviation Cares Of Southwest Chen Du LTD  <br>
 * @author piano <br>
 * date 2023年 10月08日 10:33 <br>
 * @version v1.0 <br>
 */
@Component
public class BlockedListNotifier implements ApplicationListener<BlockedListEvent> {

	@Override
	public void onApplicationEvent(BlockedListEvent event) {
		System.out.println("地址:"+event.getAddress());
		System.out.println("内容:"+event.getContent());
	}
}
