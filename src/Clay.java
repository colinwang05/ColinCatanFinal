


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Clay extends ResourceCard
{
    private BufferedImage clay;

    public Clay()
    {
        super("clay");
        try
        {
            clay= ImageIO.read(Wheat.class.getResource("/resource/resourceCards/Clay.PNG"));
        } catch (IOException e) {
            System.out.println("Exception Error");
            return;
        }
        this.setImage(clay);
    }

    public BufferedImage getClay()
    {
        return clay;
    }
}
