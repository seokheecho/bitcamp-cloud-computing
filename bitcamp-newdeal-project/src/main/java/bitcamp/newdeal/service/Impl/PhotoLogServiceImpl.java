package bitcamp.newdeal.service.Impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bitcamp.newdeal.domain.PhotoLog;
import bitcamp.newdeal.repository.PhotoFileRepository;
import bitcamp.newdeal.repository.PhotoLogRepository;
import bitcamp.newdeal.service.PhotoLogService;

@Service
public class PhotoLogServiceImpl implements PhotoLogService {

    @Autowired PhotoLogRepository photoLogRepository;
    @Autowired PhotoFileRepository photoFileRepository;
    
    @Override
    public int add(PhotoLog photoLog) {
        int count = photoLogRepository.insert(photoLog);
        
        if (photoLog.getPhotoFiles() != null) {
        this.addPhotoFiles(photoLog.getPhotoFiles(), photoLog.getNo());
        }
        //System.out.println(count + " <= PhotoLogServiceImpl");
        //System.out.println(photoLog.toString() + " <= PhotoLogServiceImpl");
        
        return count;
        // return photoLogRepository.insert(photoLog);
        // 우선 int count 에 photoLogRepository.insert(photoLog) 담아두고 
        // addPhotoFiles() 실행 후
        // return count;
    }

    @Override
    public void addPhotoFiles(ArrayList<String> photoFiles, int photoLogNo) {
        for (String photoFile : photoFiles) {
            System.out.println(photoFile.toString());
            photoFile.set
            //photoFile.setPhotoLogNo(photoLogNo);
            photoFileRepository.insert(photoFile);
        }
    }

    
    
}
