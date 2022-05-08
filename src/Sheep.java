

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class Sheep extends ResourceCard
{
    private BufferedImage sheep;

    public Sheep()
    {
        super("sheep");
        try
        {
            sheep= ImageIO.read(Wheat.class.getResource("/resource/resourceCards/Sheep.PNG"));
        } catch (IOException e) {
            System.out.println("Exception Error");
            return;
        }
        this.setImage(sheep);
    }

    public BufferedImage getSheep()
    {
        return sheep;
    }
}
