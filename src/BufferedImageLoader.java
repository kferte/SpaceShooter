import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

class BufferedImageLoader {

    BufferedImage loadImage(String path) throws IOException {
        return ImageIO.read(getClass().getResource(path));
    }
}
