import java.awt.image.BufferedImage;

public class FloodCard
{
    private BufferedImage bufferedImage;
    private String name;

    public FloodCard(BufferedImage b, String name)
    {
        bufferedImage = b;
        this.name = name;
    }

    public BufferedImage getBufferedImage()
    {
        return bufferedImage;
    }

    public String getName()
    {
        return name;
    }
}
