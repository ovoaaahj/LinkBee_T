package com.link.login.Controller;

import com.link.login.Service.MemberService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j //log
@RestController
@AllArgsConstructor
@RequestMapping("/login")
public class MemberController {

    private final MemberService memberService;
    @PostMapping("/saveDumi")
    public void saveDumi(){
        memberService.saveDumi();
    }
}
