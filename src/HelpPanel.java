import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class HelpPanel extends JPanel {



        private BufferedImage im;
        private int num;
        public HelpPanel(int title){
            num = title;
            try{
                if(num == 1)
                    im = ImageIO.read(new File("src/resources/rule/rules1.jpg"));
                if(num == 2)
                    im = ImageIO.read(new File("src/resources/rule/rules2.jpg"));
                if(num == 3)
                    im = ImageIO.read(new File("src/resources/rule/rules3.jpg"));
                if(num == 4)
                    im = ImageIO.read(new File("src/resources/rule/rules4.jpg"));
                if(num == 5)
                    im = ImageIO.read(new File("src/resources/rule/rules5.jpg"));
                if(num == 6)
                    im = ImageIO.read(new File("src/resources/rule/rules6.jpg"));
                if(num == 7)
                    im = ImageIO.read(new File("src/resources/rule/rules7.jpg"));
                if(num == 8)
                    im = ImageIO.read(new File("src/resources/rule/rules8.jpg"));
                if(num == 9)
                    im = ImageIO.read(new File("src/resources/rule/rules9.jpg"));
                if(num == 10)
                    im = ImageIO.read(new File("src/resources/rule/rules10.jpg"));
                if(num == 11)
                    im = ImageIO.read(new File("src/resources/rule/rules11.jpg"));
                if(num == 12)
                    im = ImageIO.read(new File("src/resources/rule/rules12.jpg"));
                if(num == 13)
                    im = ImageIO.read(new File("src/resources/rule/rules13.jpg"));
                if(num == 14)
                    im = ImageIO.read(new File("src/resources/rule/rules14.jpg"));
                if(num == 15)
                    im = ImageIO.read(new File("src/resources/rule/rules15.jpg"));
                repaint();
            }  catch (IOException e) {
                System.out.println("Exception Error");
                return;
            }
        }

        public void paintComponent (Graphics g){
            super.paintComponent(g);
            g.drawImage(im, 0, 0, 750, 1000, null);


        }

    }


