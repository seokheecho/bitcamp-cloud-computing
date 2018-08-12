package bitcamp.pms.domain;

public class BizCard {
    protected int no;
    protected String name;
    protected String phone;
    protected String tel;
    protected String fax;
    protected String email;
    protected String memo;
    
    
    @Override
    public String toString() {
        return "BizCard [no=" + no + ", name=" + name + ", phone=" + phone + ", tel=" + tel + ", fax=" + fax
                + ", email=" + email + ", memo=" + memo + "]";
    }
    
    
    public int getNo() {
        return no;
    }
    public void setNo(int no) {
        this.no = no;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getTel() {
        return tel;
    }
    public void setTel(String tel) {
        this.tel = tel;
    }
    public String getFax() {
        return fax;
    }
    public void setFax(String fax) {
        this.fax = fax;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getMemo() {
        return memo;
    }
    public void setMemo(String memo) {
        this.memo = memo;
    }


}