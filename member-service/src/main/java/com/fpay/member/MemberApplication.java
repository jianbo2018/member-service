package com.fpay.member;

import com.fpay.member.config.ProviderConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.CountDownLatch;

/**
 * @Author jianbo
 * @Date 2021/6/25 4:36 下午
 * @Version 1.0
 * @Description <br/>
 */
public class MemberApplication {
    public static void main(String[] args) {
        CountDownLatch downLatch = new CountDownLatch(1);
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProviderConfiguration.class);
        context.start();
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("shut down by jianbo");
            downLatch.countDown();
        }));
        try {
            downLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
