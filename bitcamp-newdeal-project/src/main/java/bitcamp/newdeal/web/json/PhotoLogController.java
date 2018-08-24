package bitcamp.newdeal.web.json;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bitcamp.newdeal.domain.Member;
import bitcamp.newdeal.domain.PhotoLog;
import bitcamp.newdeal.service.PhotoLogService;



@RestController
@RequestMapping("/photolog")
public class PhotoLogController {

    @Autowired PhotoLogService photoLogService;

    @PostMapping("add")
    public Object add(
            PhotoLog photolog,
            HttpSession session) {
        
        Member loginUser = 
                (Member)session.getAttribute("loginUser");
        
        photolog.setMemberNo(loginUser.getNo());
        
        photoLogService.add(photolog);
        
        HashMap<String,Object> result = new HashMap<>();
        result.put("status", "success");
        return result;
    }
}

