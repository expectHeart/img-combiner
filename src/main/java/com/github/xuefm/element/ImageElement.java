package com.github.xuefm.element;

import com.github.xuefm.enums.ZoomMode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

/**
 * 图片元素
 */
@Getter
@Accessors(chain = true)
public class ImageElement extends Element {

    private BufferedImage image;            //图片对象
    private String imgUrl;                  //图片地址
    private Integer width;                  //绘制宽度
    private Integer height;                 //绘制高度
    @Setter
    private Integer roundCorner;            //圆角大小
    @Setter
    private ZoomMode zoomMode;              //缩放模式
    @Setter
    private Integer rotate;                 //旋转角度
    @Setter
    private Integer blur;                   //高斯模糊（毛玻璃）


    private ImageElement(String imgUrl, int x, int y) {
        super(x, y);
        this.imgUrl = imgUrl;
        try {
            image = ImageIO.read(new URL(imgUrl));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private ImageElement(String imgUrl, int x, int y, Integer width, Integer height) {
        super(x, y);
        this.imgUrl = imgUrl;
        this.width = width;
        this.height = height;
        try {
            image = ImageIO.read(new URL(imgUrl));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private ImageElement(BufferedImage image, int x, int y) {
        super(x, y);
        this.image = image;
    }

    public static ImageElement of(String imgUrl, int x, int y) {
        return new ImageElement(imgUrl, x, y);
    }

    public static ImageElement of(String imgUrl, int x, int y, Integer width, Integer height) {
        return new ImageElement(imgUrl, x, y, width, height);
    }

    public static ImageElement of(BufferedImage image, int x, int y) {
        return new ImageElement(image, x, y);
    }


}