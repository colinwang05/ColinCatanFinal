

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Wood extends ResourceCard
{
    private BufferedImage wood;

    public Wood()
    {
        super("wood");
        try
        {
            wood= ImageIO.read(Wheat.class.getResource("/resource/resourceCards/Wood.PNG"));
        } catch (IOException e) {
            System.out.println("Exception Error");
            return;
        }
        this.setImage(wood);

    }

    public BufferedImage getWood()
    {
        return wood;
    }
}
