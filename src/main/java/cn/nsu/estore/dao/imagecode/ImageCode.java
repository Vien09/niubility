package cn.nsu.estore.dao.imagecode;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

public class ImageCode extends ValidateCode {
    /** 生成的图片验证码 */
    private BufferedImage image;

    public ImageCode(String code, int expireIn, BufferedImage image) {
        super(code, expireIn);
        this.image = image;
    }

    public ImageCode(String code, LocalDateTime localDateTime, BufferedImage image) {
        super(code, localDateTime);
        this.image = image;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }
}
