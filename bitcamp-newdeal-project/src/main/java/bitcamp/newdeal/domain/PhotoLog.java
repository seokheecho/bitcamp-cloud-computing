package bitcamp.newdeal.domain;

import java.io.Serializable;

public class PhotoLog implements Serializable{
    private static final long serialVersionUID = 1L;
    
    protected int no;
    protected int memberNo;
    protected String date;
    protected String title;
    protected String memo;
    
    
    @Override
    public String toString() {
        return "PhotoLog [no=" + no + ", memberNo=" + memberNo + ", date=" + date + ", title=" + title + ", memo="
                + memo + "]";
    }
    
    
    public int getNo() {
        return no;
    }
    public void setNo(int no) {
        this.no = no;
    }
    public int getMemberNo() {
        return memberNo;
    }
    public void setMemberNo(int memberNo) {
        this.memberNo = memberNo;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getMemo() {
        return memo;
    }
    public void setMemo(String memo) {
        this.memo = memo;
    }

}
