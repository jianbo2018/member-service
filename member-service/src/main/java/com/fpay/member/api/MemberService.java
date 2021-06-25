package com.fpay.member.api;

import com.fpay.member.domain.Member;

public interface MemberService {
    Member getById(long memberId);
}
