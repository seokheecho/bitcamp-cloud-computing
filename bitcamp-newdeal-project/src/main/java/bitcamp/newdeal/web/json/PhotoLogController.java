package bitcamp.newdeal.web.json;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import bitcamp.newdeal.domain.Member;
import bitcamp.newdeal.domain.PhotoLog;
import bitcamp.newdeal.service.PhotoLogService;



@RestController
@RequestMapping("/photolog")
public class PhotoLogController {

    @Autowired ServletContext sc;
    @Autowired PhotoLogService photoLogService;

    
    // @RequestMapping(value="add", method=RequestMethod.POST)
    @PostMapping("add")
    public Object add(
            PhotoLog photoLog,
            MultipartFile[] files,
            HttpSession session) {
        System.out.println("add()...호출됨!test123");
        System.out.println("====================");
        System.out.println(files);
        System.out.println(photoLog);
        
        
        Member loginUser = 
                (Member)session.getAttribute("loginUser");
        
        photoLog.setMemberNo(loginUser.getNo());
        
        photoLogService.add(photoLog);
        
        
        HashMap<String,Object> result = new HashMap<>();
        result.put("status", "success");
        
        ArrayList<String> photoFileList = new ArrayList<>();
        result.put("photoFileList", photoFileList);
        
        try {
            for (MultipartFile file : files) {
                if (file.isEmpty()) continue;
                String newfilename = UUID.randomUUID().toString(); 
                String path = sc.getRealPath("/files/" + newfilename);
                file.transferTo(new File(path));
                photoFileList.add(newfilename);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        photoLog.setPhotoFiles(photoFileList);
        
        return result;
    }
    
}

