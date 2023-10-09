package com.qhyu.cloud.springEvent;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * All rights Reserved, Designed By http://xnky.travelsky.net/ <br>
 * Title：AnnotationBlockedListNotifier <br>
 * Package：com.qhyu.cloud.springEvent <br>
 * Copyright © 2023 xnky.travelsky.net Inc. All rights reserved. <br>
 * Company：Aviation Cares Of Southwest Chen Du LTD  <br>
 *
 * @author piano <br>
 * date 2023年 10月08日 14:40 <br>
 * @version v1.0 <br>
 */
@Component
public class AnnotationBlockedListNotifier {
	@EventListener
	public void processBlockedListEvent(BlockedListEvent event) {
		System.out.println("Annotation-地址:"+event.getAddress());
		System.out.println("Annotation-内容:"+event.getContent());
	}
}
