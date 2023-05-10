package com.qhyu.cloud.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * All rights Reserved, Designed By http://xnky.travelsky.net/ <br>
 * Title：AopConfig <br>
 * Package：com.qhyu.cloud.aop <br> 
 * Copyright © 2022 xnky.travelsky.net Inc. All rights reserved. <br>
 * Company：Aviation Cares Of Southwest Chen Du LTD  <br>
 * @author 于琦海 <br>
 * date 2022年 04月22日 16:21 <br>
 * @version v1.0 <br>
 */
@EnableAspectJAutoProxy
@ComponentScan(value = {"com.qhyu.cloud.**"})
public class AopConfig {
}
