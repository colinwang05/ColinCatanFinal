
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Wheat extends ResourceCard
{
    private BufferedImage wheat;

    public Wheat()
    {
        super("wheat");
        try
        {
           wheat= ImageIO.read(Wheat.class.getResource("/resource/resourceCards/Wheat.PNG"));
        } catch (IOException e) {
            System.out.println("Exception Error");
            return;
        }
        this.setImage(wheat);
    }

    public BufferedImage getWheat()
    {
        return wheat;
    }
}