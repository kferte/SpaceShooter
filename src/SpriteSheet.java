import java.awt.image.BufferedImage;

public class SpriteSheet {

    private BufferedImage image;

    public SpriteSheet(BufferedImage image){
        this.image = image;
    }

    public BufferedImage grabeImage(int col, int row, int width, int height){
        BufferedImage img = image.getSubimage((col * 32), (row * 32), width, height);
        return img;
    }
}
