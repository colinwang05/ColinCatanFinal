
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class DeckPanel extends JPanel
{
    private int WIDTH ,HEIGHT ;
    private JFrame frame;
    private BufferedImage floor, Clay, Wheat, Sheep, Ore, Wood;
    private BufferedImage knight, road, resource, victory;
    public DeckPanel(String player, int width, int height)
    {
        try {
            knight = ImageIO.read(GUIGameBoard.class.getResource("/resource/developmentCard/Knight.PNG"));
            road = ImageIO.read(GUIGameBoard.class.getResource("/resource/developmentCard/RoadBuild.PNG"));
            resource = ImageIO.read(GUIGameBoard.class.getResource("/resource/developmentCard/YearOfPlenty.PNG"));
            victory = ImageIO.read(GUIGameBoard.class.getResource("/resource/developmentCard/VP.PNG"));
            floor = ImageIO.read(GUIGameBoard.class.getResource("/resource/backgrounds/Floor.jpg"));
            Clay = ImageIO.read(GUIGameBoard.class.getResource("/resource/resourceCards/Clay.PNG"));
            Wheat = ImageIO.read(GUIGameBoard.class.getResource("/resource/resourceCards/Wheat.PNG"));
            Sheep = ImageIO.read(GUIGameBoard.class.getResource("/resource/resourceCards/Sheep.PNG"));
            Ore = ImageIO.read(GUIGameBoard.class.getResource("/resource/resourceCards/Ore.PNG"));
            Wood = ImageIO.read(GUIGameBoard.class.getResource("/resource/resourceCards/Wood.PNG"));

        } catch(IOException e) {
            System.out.println("Floor");
        }
        this.WIDTH= (int) (width/1.7);
        this.HEIGHT=(int)(height/1.7);
        frame = new JFrame();
        frame.setTitle(player + "'s Deck");
        frame.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        frame.setResizable(false);
        frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setContentPane(new JPanel()
        {
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                int W = (int) (width / 1.7);
                int H = (int) (height / 1.7);
                g.drawImage(floor, 0, 0, W, H, null);
                //g.drawImage(Rcard,100,100, W/12, H/5, null);

                int xpos = W / 64;
                int ypos = H / 64;
                /*
                for(int i=0;i<GameState.players.get(GameState.currentPlayer).getResourceCards().size();i++)
                {
                    //BufferedImage br=GameState.players.get(GameState.currentPlayer).getResourceCards().get(i).getImage();

                }

                 */

                for (int i = 0; i < GameState.players.size(); i++) {
                    //int add = 10;
                    if (GameState.players.get(i).getColor().equals(player)) {
                        g.drawImage(knight,W/120,H/15,(W / 12)*2  , (H / 5)*2, null );
                        g.drawImage(road,(int) (W/5.12),H/15,(W / 12)*2  , (H / 5)*2, null );
                        g.drawImage(resource, (int) (W/2.61),H/15,(W / 12)*2  , (H / 5)*2, null );
                        g.drawImage(victory, (int) (W/1.76),H/15,(W / 12)*2  , (H / 5)*2, null );
                        g.drawImage(Clay, W/120,H/2, (W / 12)*2  , (H / 5)*2, null);
                        g.drawImage(Ore, (int) (W/5.12),H/2, (W / 12)*2  , (H / 5)*2, null);
                        g.drawImage(Sheep, (int) (W/2.61),H/2, (W / 12)*2  , (H / 5)*2, null);
                        g.drawImage(Wheat, (int) (W/1.76),H/2, (W / 12)*2  , (H / 5)*2, null);
                        g.drawImage(Wood, (int) (W/1.323),H/2, (W / 12)*2  , (H / 5)*2, null);
                        int claycount=0;
                        int orecount=0;
                        int sheepcount=0;
                        int wheatcount=0;
                        int woodcount=0;
                        int k=0;
                        int r=0;
                        int re=0;
                        int v=0;
                        for(DevelopmentCard d: GameState.players.get(i).getDevelopmentCards()){
                            if(d.getType().equals("knight")){
                                k++;
                            }
                            if(d.getType().equals("road building")){
                                r++;
                            }
                            if(d.getType().equals("year of plenty")){
                                re++;
                            } if(d.getType().equals("victory point")){
                                v++;
                            }
                        }
                        for (ResourceCard card : GameState.players.get(i).getResourceCards()) {
                            if(card.getType().equals("clay")){
                                claycount++;
                            }
                            if(card.getType().equals("ore")){
                                orecount++;
                            }if(card.getType().equals("sheep")){
                                sheepcount++;
                            }if(card.getType().equals("wheat")){
                                wheatcount++;
                            }if(card.getType().equals("wood")){
                                woodcount++;
                            }
                            //BufferedImage br = card.getImage();
                            //g.drawImage(RCard, add, 100, W / 12, H / 5, null);
                            //System.out.println("MATTHEW HERE");
                        }
                        g.setColor(Color.white);
                        g.drawString(""+claycount, W/120+(W / 12),H/2-H/50);
                        g.drawString(""+orecount, (int) (W/5.12)+(W / 12),H/2-H/50);
                        g.drawString(""+sheepcount, (int) (W/2.61)+(W / 12),H/2-H/50);
                        g.drawString(""+wheatcount, (int) (W/1.76)+(W / 12),H/2-H/50);
                        g.drawString(""+woodcount, (int) (W/1.323)+(W / 12),H/2-H/50);

                        g.drawString(""+k, W/120+(W / 12),H/30);
                        g.drawString(""+r, (int) (W/5.12)+(W / 12),H/30);
                        g.drawString(""+re, (int) (W/2.61)+(W / 12),H/30);
                        g.drawString(""+v, (int) (W/1.76)+(W / 12),H/30);
                        //g.drawString(""+woodcount, (int) (W/1.323)+(W / 12),H/2-H/30);
                        //add += 50;
                    }
                }
            }
        });
        /*
        frame.setContentPane(new JPanel()
        {
            public void paintComponent(Graphics g)
            {
                super.paintComponent(g);
                g.drawImage(floor,0,0, width, height, null);
            }
        });

         */
    }
}
