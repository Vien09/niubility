package cn.nsu.estore.dao.imagecode;

import java.time.LocalDateTime;

public class ValidateCode {
    //    验证码
    private String code;

    //    判断过期时间
    private LocalDateTime localDateTime;

    public ValidateCode(String code, int expireIn){
        this.code = code;
        this.localDateTime = LocalDateTime.now().plusSeconds(expireIn);
    }

    public ValidateCode(String code, LocalDateTime localDateTime){
        this.code = code;
        this.localDateTime = localDateTime;
    }

    public boolean isExpried(){
        return LocalDateTime.now().isAfter(localDateTime);
    }

    public String getCode(){
        return code;
    }

    public void setCode(String code){
        this.code = code;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }
}
