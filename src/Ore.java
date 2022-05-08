


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Ore extends ResourceCard
{
    private BufferedImage ore;

    public Ore()
    {
        super("ore");
        try
        {
            ore= ImageIO.read(Wheat.class.getResource("/resource/resourceCards/Ore.PNG"));
        } catch (IOException e) {
            System.out.println("Exception Error");
            return;
        }
        this.setImage(ore);
    }

    public BufferedImage getOre()
    {
        return ore;
    }
}
