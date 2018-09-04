package bitcamp.newdeal.service;

import java.util.List;

import bitcamp.newdeal.domain.PhotoFile;
import bitcamp.newdeal.domain.PhotoLog;

public interface PhotoLogService {

    int add(PhotoLog photoLog);
    
// 사진파일(PHOTOFILE) add
    void addPhotoFiles(List<PhotoFile> photoFiles, int photoLogNo);

    
}
