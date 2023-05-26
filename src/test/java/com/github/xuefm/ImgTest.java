package com.github.xuefm;

import com.github.xuefm.combiner.DefaultImageCombiner;
import com.github.xuefm.combiner.ImageCombiner;
import com.github.xuefm.element.ImageElement;
import com.github.xuefm.element.RectangleElement;
import com.github.xuefm.element.TextElement;
import com.github.xuefm.enums.OutputFormat;
import com.github.xuefm.enums.RectangleType;
import org.junit.Test;

import java.awt.*;
import java.io.IOException;

public class ImgTest {

    private String filePath = "file:///F:/IdeaProjects/dome/img-combiner/test_file/";
    private String generateFilePath = "F:/IdeaProjects/dome/img-combiner/test_file/generate/";
    private String generateImgPath = generateFilePath + "img/";
    private String generateTextPath = generateFilePath + "text/";
    private String generateRectanglePath = generateFilePath + "rectangle/";


    /**
     * 测试添加图片(指定位置)
     *
     * @throws IOException
     */
    @Test
    public void addImageTest() throws IOException {
        ImageCombiner imageCombiner = DefaultImageCombiner.of(400, 600, OutputFormat.PNG, 0, 0f);
        imageCombiner.addElement(ImageElement.of(filePath + "cat.jpg", 10, 10));
        imageCombiner.generate();
        imageCombiner.save(generateImgPath + "指定位置.png");
    }

    /**
     * 添加图片(指定宽高)
     *
     * @throws IOException
     */
    @Test
    public void addImageWidthHeightTest() throws IOException {
        ImageCombiner imageCombiner = DefaultImageCombiner.of(400, 600, OutputFormat.PNG, 0, 0f);
        imageCombiner.addElement(ImageElement.of(filePath + "cat.jpg", 10, 10, 150, 200));
        imageCombiner.generate();
        imageCombiner.save(generateImgPath + "指定宽高.png");
    }

    /**
     * 添加图片(圆角)
     *
     * @throws IOException
     */
    @Test
    public void addImageFilletTest() throws IOException {
        ImageCombiner imageCombiner = DefaultImageCombiner.of(400, 600, OutputFormat.PNG, 0, 0f);
        imageCombiner.addElement(
                ImageElement.of(filePath + "cat.jpg", 50, 50, 150, 150).setRoundCorner(20)

        );
        imageCombiner.generate();
        imageCombiner.save(generateImgPath + "圆角.png");
    }

    /**
     * 添加图片(旋转)
     *
     * @throws IOException
     */
    @Test
    public void addImageRotateTest() throws IOException {
        ImageCombiner imageCombiner = DefaultImageCombiner.of(400, 600, OutputFormat.PNG, 0, 0f);
        imageCombiner.addElement(
                ImageElement.of(filePath + "cat.jpg", 50, 50, 150, 150)
                        .setRotate(45)
        );
        imageCombiner.generate();
        imageCombiner.save(generateImgPath + "旋转.png");
    }

    /**
     * 添加图片(透明)
     *
     * @throws IOException
     */
    @Test
    public void addImageAlphaTest() throws IOException {
        ImageCombiner imageCombiner = DefaultImageCombiner.of(400, 600, OutputFormat.PNG, 0, 0f);
        imageCombiner.addElement(
                ImageElement.of(filePath + "cat.jpg", 50, 50, 150, 150)
                        .setAlpha(0.5f)
        );
        imageCombiner.generate();
        imageCombiner.save(generateImgPath + "透明.png");
    }

    /**
     * 添加文本
     *
     * @throws IOException
     */
    @Test
    public void addTextTest() throws IOException {
        ImageCombiner imageCombiner = DefaultImageCombiner.of(400, 600, OutputFormat.PNG, 0, 0f);
        imageCombiner.addElement(
                TextElement.of("Hello World", 10, 10),
                TextElement.of("你好，世界", 10, 50)
        );
        imageCombiner.generate();
        imageCombiner.save(generateTextPath + "添加文本.png");
    }

    /**
     * 添加文本(颜色)
     *
     * @throws IOException
     */
    @Test
    public void addTextColorTest() throws IOException {
        ImageCombiner imageCombiner = DefaultImageCombiner.of(400, 600, OutputFormat.PNG, 0, 0f);
        imageCombiner.addElement(
                TextElement.of("Hello World", 10, 10).setColor(Color.CYAN),
                TextElement.of("你好，世界", 10, 50).setColor(Color.yellow)
        );
        imageCombiner.generate();
        imageCombiner.save(generateTextPath + "颜色.png");
    }


    /**
     * 添加文本(字体)
     *
     * @throws IOException
     */
    @Test
    public void addTextFontTest() throws IOException {
        ImageCombiner imageCombiner = DefaultImageCombiner.of(400, 600, OutputFormat.PNG, 0, 0f);
        int y = 0;
        imageCombiner.addElement(
                TextElement.of("Hello World", 10, y += 36).setFont(new Font("微软雅黑", Font.PLAIN, 36)),
                TextElement.of("Hello World", 10, y += 36).setFont(new Font("宋体", Font.PLAIN, 36)),
                TextElement.of("你好，世界", 10, y += 72).setFont(new Font("微软雅黑", Font.PLAIN, 72)),
                TextElement.of("你好，世界", 10, y += 72).setFont(new Font("宋体", Font.BOLD, 72))
        );
        imageCombiner.generate();
        imageCombiner.save(generateTextPath + "字体.png");
    }


    /**
     * 添加文本(透明)
     *
     * @throws IOException
     */
    @Test
    public void addTextAlphaTest() throws IOException {
        ImageCombiner imageCombiner = DefaultImageCombiner.of(400, 600, OutputFormat.PNG, 0, 0f);
        int y = 0;
        imageCombiner.addElement(
                TextElement.of("Hello World", 10, y += 36).setFont(new Font("微软雅黑", Font.PLAIN, 36)),
                TextElement.of("Hello World", 10, y += 36).setFont(new Font("宋体", Font.PLAIN, 36)).setAlpha(0.5f),
                TextElement.of("你好，世界", 10, y += 72).setFont(new Font("微软雅黑", Font.PLAIN, 72)),
                TextElement.of("你好，世界", 10, y += 72).setFont(new Font("宋体", Font.BOLD, 72)).setAlpha(0.2f)
        );
        imageCombiner.generate();
        imageCombiner.save(generateTextPath + "文字透明.png");
    }

    /**
     * 添加文本(旋转)
     *
     * @throws IOException
     */
    @Test
    public void addTextRotateTest() throws IOException {
        ImageCombiner imageCombiner = DefaultImageCombiner.of(400, 600, OutputFormat.PNG, 0, 0f);
        imageCombiner.addElement(
                TextElement.of("Hello World", 0, -36).setFont(new Font("微软雅黑", Font.PLAIN, 36)).setRotate(180),
                TextElement.of("Hello World", 0, 72).setFont(new Font("微软雅黑", Font.PLAIN, 36))
        );
        imageCombiner.generate();
        imageCombiner.save(generateTextPath + "文字旋转.png");
    }

    /**
     * 添加矩形
     *
     * @throws IOException
     */
    @Test
    public void addRectangleTest() throws IOException {
        ImageCombiner imageCombiner = DefaultImageCombiner.of(400, 600, OutputFormat.PNG, 0, 0f);
        imageCombiner.addElement(
                RectangleElement.of(10, 10, 100, 100).setColor(Color.CYAN)
        );
        imageCombiner.generate();
        imageCombiner.save(generateRectanglePath + "矩形.png");
    }

    /**
     * 添加矩形
     *
     * @throws IOException
     */
    @Test
    public void addRectangleFilletTest() throws IOException {
        ImageCombiner imageCombiner = DefaultImageCombiner.of(400, 600, OutputFormat.PNG, 0, 0f);
        imageCombiner.addElement(
                RectangleElement.of(10, 10, 100, 100, RectangleType.DrawRoundRect).setRoundCorner(100).setColor(Color.CYAN),
                RectangleElement.of(110, 10, 100, 100, RectangleType.FillRoundRect).setRoundCorner(100).setColor(Color.CYAN)
        );
        imageCombiner.generate();
        imageCombiner.save(generateRectanglePath + "矩形圆角.png");
    }

    /**
     * 添加全部
     *
     * @throws IOException
     */
    @Test
    public void addRectangleAllTest() throws IOException {
        ImageCombiner imageCombiner = DefaultImageCombiner.of(400, 600, OutputFormat.PNG, 0, 0f);
        imageCombiner.addElement(
                RectangleElement.of(10, 10, 100, 100, RectangleType.DrawRect).setColor(Color.CYAN),
                RectangleElement.of(120, 10, 100, 100, RectangleType.FillRect).setColor(Color.CYAN),

                RectangleElement.of(10, 110, 100, 100, RectangleType.Draw3DRect).setColor(Color.CYAN),
                RectangleElement.of(120, 110, 100, 100, RectangleType.Fill3DRect).setColor(Color.CYAN),

                RectangleElement.of(10, 220, 100, 100, RectangleType.DrawRoundRect).setRoundCorner(100).setColor(Color.CYAN),
                RectangleElement.of(120, 220, 100, 100, RectangleType.FillRoundRect).setRoundCorner(100).setColor(Color.CYAN)


        );
        imageCombiner.generate();
        imageCombiner.save(generateRectanglePath + "矩形全部.png");
    }


}