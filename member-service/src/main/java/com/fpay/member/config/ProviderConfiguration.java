package com.fpay.member.config;

import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ProtocolConfig;
import org.apache.dubbo.config.ProviderConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author jianbo
 * @Date 2021/6/25 4:56 下午
 * @Version 1.0
 * @Description <br/>
 */
@Configuration
@EnableDubbo(scanBasePackages = "com.fpay.member.service")
public class ProviderConfiguration {
    @Bean
    public ProviderConfig providerConfig() {
        return new ProviderConfig();
    }

    /**
     * <dubbo:application ../>
     *
     * @return
     */
    @Bean
    public ApplicationConfig applicationConfig() {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        //dubbo application name
        applicationConfig.setName("member-service");
        return applicationConfig;
    }

    /**
     * <dubbo:registry ../>
     *
     * @return
     */
    @Bean
    public RegistryConfig registryConfig() {
        RegistryConfig config = new RegistryConfig();
        config.setProtocol("zookeeper");
        config.setAddress("zookeeper://127.0.0.1:2181,zookeeper://127.0.0.1:2182,zookeeper://127.0.0.1:2183");
//        config.setPort(2181);
        return config;
    }

    /**
     * <dubbo:protocol ../>
     *
     * @return
     */
    @Bean
    public ProtocolConfig protocolConfig() {
        ProtocolConfig config = new ProtocolConfig();
        config.setName("dubbo");
        config.setPort(20880);
        return config;
    }
}
