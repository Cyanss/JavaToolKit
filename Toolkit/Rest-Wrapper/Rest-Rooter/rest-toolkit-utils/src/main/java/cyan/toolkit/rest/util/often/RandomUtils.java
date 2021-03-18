package cyan.toolkit.rest.util.often;

import cyan.toolkit.rest.model.ImageVerify;
import cyan.toolkit.rest.util.common.GeneralUtils;
import org.springframework.lang.NonNull;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

/**
 * <p>RandomUtils</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 11:34 2019/12/19
 */
public class RandomUtils {
    private static final String BASE_SYMBOL = "!@#$%^&*()[]{}\";:+~·=-/,.<>?\\|";
    private static final String BASE_STRING_UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private static final String BASE_STRING_LOWER = BASE_STRING_UPPER.toLowerCase();
    private static final String BASE_REGEX = "_";
    private static final String BASE_NUMBER = "0123456789";
    private static final String BASE_STRING = BASE_NUMBER.concat(BASE_STRING_LOWER).concat(BASE_STRING_UPPER);
    private static final Integer MIN_LENGTH = 3;
    private static final Random RANDOM = new Random();

    private static final Integer DEFAULT_IMAGE_WIDTH = 70;
    private static final Integer DEFAULT_IMAGE_HEIGHT = 25;
    private static final Color DEFAULT_IMAGE_COLOR = Color.WHITE;
    private static final String[] FONT_NAME_ARRAY = { "宋体", "华文楷体", "黑体", "微软雅黑", "楷体_GB2312", "Arial" };
    private static final Integer[] AFFINE_TRANSFORM_ARRAY = { 0, 15, 20, 30, 35, 40 };

    public static synchronized String uuid() {
        return UUID.randomUUID().toString().replaceAll("-","");
    }

    public static synchronized Long randomLong() {
        return System.currentTimeMillis() + (long) ((int) (Math.random() * 10000));
    }

    public static synchronized Double randomDouble() {
        return System.currentTimeMillis() + Math.random();
    }

    public static synchronized Integer randomInt() {
        return RANDOM.nextInt();
    }

    public static synchronized Character randomChar() {
        int index = RANDOM.nextInt(BASE_STRING.length());
        return BASE_STRING.charAt(index);
    }

    public static synchronized ImageVerify randomImageVerify() {
        ImageVerify imageVerify = new ImageVerify(DEFAULT_IMAGE_WIDTH,DEFAULT_IMAGE_HEIGHT,DEFAULT_IMAGE_COLOR);
        return randomImageVerify(imageVerify);
    }

    public static synchronized ImageVerify randomImageVerify(Integer width, Integer height) {
        ImageVerify imageVerify;
        if (GeneralUtils.isNotEmpty(width) && GeneralUtils.isNotEmpty(height)) {
            imageVerify = new ImageVerify(width,height,DEFAULT_IMAGE_COLOR);
        } else {
            imageVerify = new ImageVerify(DEFAULT_IMAGE_WIDTH,DEFAULT_IMAGE_HEIGHT,DEFAULT_IMAGE_COLOR);
        }
        return randomImageVerify(imageVerify);
    }

    public static synchronized ImageVerify randomImageVerify(@NonNull ImageVerify imageVerify) {
        Integer width = Optional.ofNullable(imageVerify.getWidth()).orElse(DEFAULT_IMAGE_WIDTH);
        Integer height = Optional.ofNullable(imageVerify.getHeight()).orElse(DEFAULT_IMAGE_HEIGHT);
        Color color = Optional.ofNullable(imageVerify.getColor()).orElse(DEFAULT_IMAGE_COLOR);
        ImageVerify.Builder builder = new ImageVerify.Builder();
        builder.width(width).height(height).color(color);
        /** 渲染图片 */
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = (Graphics2D) image.getGraphics();
        graphics.setColor(color);
        graphics.fillRect(0,0,width,height);
        /** 干扰线条 */
        for (int i = 0; i < 150; ++i) {
            int startX = RANDOM.nextInt(width);
            int startY = RANDOM.nextInt(height);
            int endX = RANDOM.nextInt(width);
            int endY = RANDOM.nextInt(height);
            graphics.setColor(randomColor(170, 200));
            graphics.drawLine(startX, startY, endX, endY);
        }
        /** 验证码 */
        StringBuilder contentBuilder = new StringBuilder();
        for (int i = 0; i < 4; ++i) {
            String character = String.valueOf(randomChar());
            contentBuilder.append(character);
            Graphics2D contentGraphics = graphics;
            AffineTransform affineTransform = new AffineTransform();
            affineTransform.rotate(randomTransform() * 3.14 / 180, 15 * i + 3.5, 5);
            contentGraphics.setTransform(affineTransform);
            graphics.setFont(randomFont());
            graphics.setColor(randomColor());
            graphics.drawString(character, 15 * i + 7, 16);
        }
        builder.content(contentBuilder.toString()).image(image);
        return new ImageVerify(builder);
    }



    public static synchronized Color randomColor() {
        return randomColor(0,150);
    }


    public static synchronized Color randomColor(Integer min, Integer max) {
        if (min > 255) {
            min = 255;
        }
        if (max > 255) {
            max = 255;
        }
        int red = RANDOM.nextInt(max - min) + min;
        int green = RANDOM.nextInt(max - min) + min;
        int blue = RANDOM.nextInt(max - min) + min;
        return new Color(red, green, blue);
    }

    private static synchronized Font randomFont() {
        int index = RANDOM.nextInt(FONT_NAME_ARRAY.length);
        String fontName = FONT_NAME_ARRAY[index];
        int style = RANDOM.nextInt(4);
        int size = RANDOM.nextInt(5) + 20;
        return new Font(fontName, style, size);
    }

    private static synchronized Integer randomTransform() {
        int index = RANDOM.nextInt(AFFINE_TRANSFORM_ARRAY.length);
        return AFFINE_TRANSFORM_ARRAY[index];
    }


}
