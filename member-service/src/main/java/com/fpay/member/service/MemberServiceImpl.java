package com.fpay.member.service;

import com.fpay.member.api.MemberService;
import com.fpay.member.domain.Member;
import org.apache.dubbo.config.annotation.DubboService;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @Author jianbo
 * @Date 2021/6/25 4:34 下午
 * @Version 1.0
 * @Description <br/>
 */
@DubboService
public class MemberServiceImpl implements MemberService {
    @Override
    public Member getById(long memberId) {
        //todo: now just for test
        Member member = new Member();
        member.setId(memberId);
        member.setUsername("jianbo" + ThreadLocalRandom.current().nextInt(0, 100));
        System.out.println("return "+member);
        return member;
    }
}
