package com.test.demo.zhuru.test;

import org.springframework.stereotype.Component;

@Component
//@Primary //Primary可以理解为默认优先选择,不可以同时设置多个,内部实质是设置BeanDefinition的primary属性
public class ZhuRuTest2 extends ZhuRuTest {
}
