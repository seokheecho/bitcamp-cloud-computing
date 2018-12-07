package bitcamp.pms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import bitcamp.pms.domain.Member;
import bitcamp.pms.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {

    @Autowired MemberService memberService;
    

    @PostMapping("add")
    public String add(Member member) throws Exception {
        
        memberService.add(member);
        return "redirect:list";
    }
    


}










