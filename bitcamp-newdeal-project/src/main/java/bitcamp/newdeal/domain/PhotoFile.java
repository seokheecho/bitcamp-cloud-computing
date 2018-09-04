package bitcamp.newdeal.domain;

import java.io.Serializable;

public class PhotoFile implements Serializable{
    private static final long serialVersionUID = 1L;
    
    protected int no;
    protected int photoLogNo;
    protected String photoFileName;
    
    
    @Override
    public String toString() {
        return "PhotoFile [no=" + no + ", photoLogNo=" + photoLogNo + ", photoFileName=" + photoFileName + "]";
    }
    
    
    public int getNo() {
        return no;
    }
    public void setNo(int no) {
        this.no = no;
    }
    public int getPhotoLogNo() {
        return photoLogNo;
    }
    public void setPhotoLogNo(int photoLogNo) {
        this.photoLogNo = photoLogNo;
    }
    public String getPhotoFileName() {
        return photoFileName;
    }
    public void setPhotoFileName(String photoFileName) {
        this.photoFileName = photoFileName;
    }
    
    
}
