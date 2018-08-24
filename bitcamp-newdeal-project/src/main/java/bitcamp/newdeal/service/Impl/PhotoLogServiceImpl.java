package bitcamp.newdeal.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bitcamp.newdeal.domain.PhotoLog;
import bitcamp.newdeal.repository.PhotoLogRepository;
import bitcamp.newdeal.service.PhotoLogService;

@Service
public class PhotoLogServiceImpl implements PhotoLogService {

    @Autowired PhotoLogRepository photoLogRepository;
    
    @Override
    public int add(PhotoLog photolog) {
        return photoLogRepository.insert(photolog);
    }
    
}
