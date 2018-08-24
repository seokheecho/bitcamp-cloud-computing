package bitcamp.newdeal.service.Impl;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bitcamp.newdeal.domain.Member;
import bitcamp.newdeal.repository.MemberRepository;
import bitcamp.newdeal.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired MemberRepository memberRepository;
    
    @Override
    public int add(Member member) {
        return memberRepository.insert(member);
    }

    @Override
    public Member getMember(String email, String password) {
        HashMap<String,Object> params = new HashMap<>();
        params.put("email", email);
        params.put("password", password);
        return memberRepository.findByEmailAndPassword(params);
    }

}
