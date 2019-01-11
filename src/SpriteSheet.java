import java.awt.image.BufferedImage;

class SpriteSheet {

    private BufferedImage image;

    SpriteSheet(BufferedImage image){
        this.image = image;
    }

    BufferedImage grabeImage(int col, int row, int width, int height){
        return image.getSubimage((col * 32), (row * 32), width, height);
    }
}
