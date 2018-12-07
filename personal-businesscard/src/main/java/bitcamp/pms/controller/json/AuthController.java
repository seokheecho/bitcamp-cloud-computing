/*package bitcamp.pms.controller.json;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bitcamp.pms.domain.Member;
import bitcamp.pms.service.MemberService;

@RestController
@RequestMapping("/auth")
public class AuthController {
    
    MemberService memberService;
     
    public AuthController(MemberService memberService) {
        this.memberService = memberService;
    }
    
    @GetMapping("/loginUser")
    public Member loginUser(HttpSession session) {
        return (Member) session.getAttribute("loginUser");
    }
    
    @RequestMapping("/login")
    public Object login(
            @RequestParam("id") String id,
            @RequestParam("password") String password,
            HttpServletRequest request,
            HttpServletResponse response,
            HttpSession session) throws Exception {
        

        HashMap<String,Object> result = new HashMap<>();
        
        if (memberService.isExist(id, password)) { // 로그인 성공!
            session.setAttribute("loginUser", memberService.get(id));
            result.put("state", "success");
        } else { // 로그인 실패!
            session.invalidate();
            result.put("state", "fail");
        }
        return result;
    }
    
    @RequestMapping("/logout")
    public void logout(HttpSession session) throws Exception {
        // 세션을 꺼내 무효화시킨다.
        session.invalidate();
    }
}

//ver 55 - JSON 데이터를 출력하는 페이지 컨트롤러 생성*/