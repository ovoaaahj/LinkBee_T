package com.link.login.Service;

import com.link.login.Dto.Member;
import com.link.login.Repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j //log
@RequiredArgsConstructor // final 로 지정된 멤버변수에 대해서 생성자 자동생성
public class MemberService {

    //@RequiredArgsConstructor 선언으로 생성자 자동 생성 되면서 컨테이너로부터 메모리 자동 주입
    final private MemberRepository memberRepository;
    public void saveDumi(){

        Member member = Member.builder()
                .email("test@test.com")
                .password("1234")
                .build();

        memberRepository.save(member);

    }
}
