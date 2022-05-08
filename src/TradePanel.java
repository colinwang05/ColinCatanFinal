
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class TradePanel extends JPanel implements ActionListener, MouseListener
{
    private  int WIDTH ,HEIGHT ;
    private JFrame frame;
    private BufferedImage floor;
    private String player;
    private boolean first;
    private boolean second;
    private JButton giveToGet;
    private JButton finalize;
    public TradePanel(String player, int width, int height)
    {

        try {
            floor = ImageIO.read(new File("src/resource/backgrounds/Floor.jpg"));
        } catch(IOException e) {
            System.out.println("HEHEHHEHEHHA");
        }
        WIDTH= (int) (width/1.7);
        HEIGHT=(int)(height/1.7);
        frame = new JFrame();
        this.player = player;
        frame.setTitle(player);
        frame.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        frame.setResizable(false);
        frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        int xpos=WIDTH/5;
        int ypos=HEIGHT/7;
        setLayout(null);
        addMouseListener(this);
        Color cc = new Color(0, 32, 64);
        finalize=new JButton("finish");

        giveToGet=new JButton("next");
        finalize.setBackground(cc);
        finalize.setForeground(Color.white);
        finalize.setBounds(WIDTH / 48, HEIGHT - HEIGHT / 8, WIDTH/20, HEIGHT/40);
        giveToGet.setBackground(cc);
        giveToGet.setForeground(Color.white);
        giveToGet.setBounds(WIDTH / 48, HEIGHT - HEIGHT / 8, WIDTH/20, HEIGHT/40);
        //add(build);
        finalize.addMouseListener(this);
        finalize.setVisible(false);

        giveToGet.addMouseListener((this));
        giveToGet.setVisible(true);
        add(finalize);
        add(giveToGet);
        first = true;
        second = false;



    }
    public void PaintComponent(Graphics g)
    {
        System.out.println("2usdfushduighsfui");
        super.paintComponent(g);
        g.drawImage(floor,0,0, WIDTH, HEIGHT, null);
        if(first){


        }
        else if(!first&&second){
            finalize.setVisible(true);
            giveToGet.setVisible(false);

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()==giveToGet){
           first=false;
           second=true;
           repaint();
       }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
