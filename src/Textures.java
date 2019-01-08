import java.awt.image.BufferedImage;

public class Textures {

    public BufferedImage player, missile, enemy;
    private SpriteSheet ss;

    public Textures(Game game){
        ss = new SpriteSheet(game.getSpriteSheet());

        getTextures();
    }

    private void getTextures(){
        player = ss.grabeImage(0, 0, 32, 32);
        missile = ss.grabeImage(1, 0, 32, 32);
        enemy = ss.grabeImage(2, 0, 32, 32);
    }
}
