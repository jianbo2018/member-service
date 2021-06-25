package com.fpay.member.domain;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Author jianbo
 * @Date 2021/6/25 4:27 下午
 * @Version 1.0
 * @Description <br/>
 */
@Data
@ToString
public class Member implements Serializable {
    private long id;
    private String username;
}
