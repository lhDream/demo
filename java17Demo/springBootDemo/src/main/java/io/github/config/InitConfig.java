package io.github.config;

import cn.hutool.core.util.IdUtil;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class InitConfig {

    @PostConstruct
    public void test(){
        System.out.println("----------hutool create id-----------");
        System.out.println(IdUtil.fastSimpleUUID());
        System.out.println("-------------------------------------");
    }

}
