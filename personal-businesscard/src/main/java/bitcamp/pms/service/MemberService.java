package bitcamp.pms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bitcamp.pms.dao.MemberDao;
import bitcamp.pms.domain.Member;

@Service
public class MemberService {
    
    @Autowired MemberDao memberDao;

    public void add(Member member) {
        memberDao.insert(member);
    }
    
}




