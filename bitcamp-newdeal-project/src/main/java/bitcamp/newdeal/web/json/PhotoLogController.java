package bitcamp.newdeal.web.json;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import bitcamp.newdeal.domain.Member;
import bitcamp.newdeal.domain.PhotoLog;
import bitcamp.newdeal.service.PhotoLogService;



@RestController
@RequestMapping("/photolog")
public class PhotoLogController {

    @Autowired PhotoLogService photoLogService;
    @Autowired ServletContext sc;

    @RequestMapping("add")
    public Object add(
            PhotoLog photolog,
            String date,
            String title,
            String memo,
            MultipartFile[] files,
            HttpSession session) {
        System.out.println("add()...호출됨!test123");
        
        Member loginUser = 
                (Member)session.getAttribute("loginUser");
        
        photolog.setMemberNo(loginUser.getNo());
        
        photoLogService.add(photolog);
        
        
        HashMap<String,Object> result = new HashMap<>();
        result.put("date", date);
        result.put("title", title);
        result.put("memo", memo);
        
        result.put("status", "success");
        
        ArrayList<String> filenames = new ArrayList<>();
        result.put("filenames", filenames);
        
        try {
            for (MultipartFile file : files) {
                if (file.isEmpty()) continue;
                String newfilename = UUID.randomUUID().toString(); 
                String path = sc.getRealPath("/files/" + newfilename);
                file.transferTo(new File(path));
                filenames.add(newfilename);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
}

