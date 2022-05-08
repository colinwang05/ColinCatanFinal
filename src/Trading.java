/*
 * 4
 */

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

public class Trading extends JPanel implements ActionListener {
    ParentPanel p;
    JButton leave, bu3, artificial;
    private BufferedImage menuBackground, ore, sheep, wheat, wood, clay;
    private int width, height, W, H;
    //clay, ore, sheep, wheat, wood
    JButton confirm;
    private int trader;
    private String[] gclay = {"0", "1", "2", "3", "4", "5"};
    private String[] gore = {"0", "1", "2", "3", "4", "5"};
    private String[] gsheep = {"0", "1", "2", "3", "4", "5"};
    private String[] gwheat = {"0", "1", "2", "3", "4", "5"};
    private String[] gwood = {"0", "1", "2", "3", "4", "5"};
    private String[] rclay = {"0", "1", "2", "3", "4", "5"};
    private String[] rore = {"0", "1", "2", "3", "4", "5"};
    private String[] rsheep = {"0", "1", "2", "3", "4", "5"};
    private String[] rwheat = {"0", "1", "2", "3", "4", "5"};
    private String[] rwood = {"0", "1", "2", "3", "4", "5"};
    private JComboBox gc, go, gs, gwh, gwo, rc, ro, rs, rwh, rwo, play;
    private int c1, o1, s1, wh1, wo1, c2, o2, s2, wh2, wo2;
    private String[] player = {"partner","red","blue","white","yellow"};

    public Trading(ParentPanel p) {
        trader = 0;
        c1 = 0;
        s1 = 0;
        wh1 = 0;
        wo1 = 0;
        o1 = 0;
        c2 = 0;
        o2 = 0;
        s2 = 0;
        wh2 = 0;
        wo2 = 0;
        this.p = p;
        width = p.getWidth();
        height = p.getHeight();
        W = (int) (width / 1.7);
        H = (int) (height / 1.7);
        setLayout(null);
        Color cc = new Color(0, 32, 64);
        play = new JComboBox(player);
        play.addActionListener(this);
        play.setBackground(cc);
        play.setForeground(Color.white);
        play.setBounds(7 * width / 8, height / 2 + height / 15, width / 20, height / 40);
        add(play);
        confirm = new JButton("confirm");
        confirm.addActionListener(this);
        confirm.setBackground(cc);
        confirm.setForeground(Color.white);
        confirm.setBounds(7 * width / 8, height / 2, width / 20, height / 40);
        add(confirm);
        leave = new JButton("back");
        leave.addActionListener(this);
        leave.setBackground(cc);
        leave.setForeground(Color.white);
        leave.setBounds(width / 48, height - height / 8, width / 20, height / 40);
        add(leave);
        //int xpos = width / 15;
        // int xpos=width/48;
        int ypos = height / 3;
        //int add = width / 10;
        gc = new JComboBox(gclay);
        gc.addActionListener(this);
        gc.setBackground(cc);
        gc.setForeground(Color.white);
        gc.setBounds(W/15, ypos, width / 20, height / 40);
        //xpos += add;
        add(gc);
        go = new JComboBox(gore);
        go.addActionListener(this);
        go.setBackground(cc);
        go.setForeground(Color.white);
        go.setBounds((int)(W/15+1.9*(W/10)), ypos, width / 20, height / 40);
        //xpos += add;
        add(go);
        gs = new JComboBox(gore);
        gs.addActionListener(this);
        gs.setBackground(cc);
        gs.setForeground(Color.white);
        gs.setBounds((int)(W/15+3.8*(W/10)), ypos, width / 20, height / 40);
        //xpos += add;
        add(gs);
        gwh = new JComboBox(gore);
        gwh.addActionListener(this);
        gwh.setBackground(cc);
        gwh.setForeground(Color.white);
        gwh.setBounds((int)(W/15+5.7*(W/10)), ypos, width / 20, height / 40);
        //xpos += add;
        add(gwh);
        gwo = new JComboBox(gore);
        gwo.addActionListener(this);
        gwo.setBackground(cc);
        gwo.setForeground(Color.white);
        gwo.setBounds((int)(W/15+7.6*(W/10)), ypos, width / 20, height / 40);
        //xpos += add;
        add(gwo);


        //xpos = width / 15;
        // int xpos=width/48;
        ypos = (int)(2 * height / 2.5);
        //add = width / 10;
        rc = new JComboBox(gclay);
        rc.addActionListener(this);
        rc.setBackground(cc);
        rc.setForeground(Color.white);
        rc.setBounds(W/15, ypos, width / 20, height / 40);
        //xpos += add;
        add(rc);
        ro = new JComboBox(gore);
        ro.addActionListener(this);
        ro.setBackground(cc);
        ro.setForeground(Color.white);
        ro.setBounds((int)(W/15+1.9*(W/10)), ypos, width / 20, height / 40);
        //xpos += add;
        add(ro);
        rs = new JComboBox(gore);
        rs.addActionListener(this);
        rs.setBackground(cc);
        rs.setForeground(Color.white);
        rs.setBounds((int)(W/15+3.8*(W/10)), ypos, width / 20, height / 40);
        //xpos += add;
        add(rs);
        rwh = new JComboBox(gore);
        rwh.addActionListener(this);
        rwh.setBackground(cc);
        rwh.setForeground(Color.white);
        rwh.setBounds((int)(W/15+5.7*(W/10)), ypos, width / 20, height / 40);
        //xpos += add;
        add(rwh);
        rwo = new JComboBox(gore);
        rwo.addActionListener(this);
        rwo.setBackground(cc);
        rwo.setForeground(Color.white);
        rwo.setBounds((int)(W/15+7.6*(W/10)), ypos, width / 20, height / 40);
        //xpos += add;
        add(rwo);
        //GridBagLayout gridbag = new GridBagLayout();
        //this.setLayout(gridbag);
        //this.setBackground(new Color(66, 66, 66));
        //Dimension d = new Dimension(100,50);
        //GridBagConstraints c = new GridBagConstraints();
        //c.insets = new Insets(100,0,0,0);
        //c.anchor=GridBagConstraints.CENTER;

        /*
         * add title: Forbidden Island
         */
        //JLabel headerLabel = new JLabel("Forbidden Island");
        //headerLabel.setFont(new Font("Serif", Font.BOLD, 150));// | Font.ITALIC
        //headerLabel.setForeground(Color.WHITE);
        //c.weightx=1;
        //c.weighty = 1;
        //c.gridx = 0;
        //c.gridwidth = 3;
        //c.gridheight = 1;
        //c.gridy = 0;
        //add(headerLabel, c);

        /*
         * set the Start button
         */
        //c.insets = new Insets(10,0,height/14,0);
        //startBtn = new JButton("Start");
        //startBtn.setFont(new Font("BOLD", Font.BOLD, 18));
        //startBtn.setForeground(Color.WHITE);
        //startBtn.setBackground(new Color(64,0,0));
        //startBtn.setPreferredSize();
        //startBtn.addActionListener(this);
        //c.weightx = 1;
        //c.weighty = 10;
        //c.gridx = 1;
        //c.gridwidth = 1;
        //c.gridy = 2;
        //add(startBtn);

        /*
         * set the Instruction button
         */
        //ruleBtn = new JButton("Rules");
        //ruleBtn.setForeground(Color.WHITE);
        //ruleBtn.setFont(new Font("BOLD", Font.BOLD, 18));
        //ruleBtn.setBackground(new Color(64,0,0));
        //ruleBtn.setBounds(width/2-50, height/10, 100,50);
        //.addActionListener(this);
        //c.gridx = 1;
        //c.gridwidth = 1;
        //c.gridy = 2;
        //add(ruleBtn);


        /*
         * artificial intelligence
         */
		/*
		artificial = new JButton("Artificial Intelligence");
		artificial.setFont(new Font("BOLD", Font.BOLD, 18));
		artificial.setForeground(Color.WHITE);
		artificial.setBackground(new Color(64,0,0));
		artificial.setPreferredSize(d);
		artificial.addActionListener(this);
		c.gridx = 1;
		c.gridwidth = 1;
		c.gridy = 3;
		add(artificial, c);
		*/


        /*
         * import image
         */
        try {
            menuBackground = ImageIO.read(Menu.class.getResource("resource/backgrounds/floor.jpg"));
            clay = ImageIO.read(Menu.class.getResource("/resource/resourceCards/Clay.PNG"));
            wheat = ImageIO.read(Menu.class.getResource("/resource/resourceCards/Wheat.PNG"));
            sheep = ImageIO.read(Menu.class.getResource("/resource/resourceCards/Sheep.PNG"));
            ore = ImageIO.read(Menu.class.getResource("/resource/resourceCards/Ore.PNG"));
            wood = ImageIO.read(Menu.class.getResource("/resource/resourceCards/Wood.PNG"));
        } catch (Exception E) {
            System.out.println("Exception");
            return;
        }
        setVisible(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(menuBackground, 0, 0, width, height, null);
        g.drawImage(clay, W/15, H/10, ((W / 12)*2)-25  , (H / 5)*2,null);
        g.drawImage(ore, (int)(W/15+1.9*(W/10)), H/10, ((W / 12)*2)-25  , (H / 5)*2,null);
        g.drawImage(sheep, (int)(W/15+3.8*(W/10)), H/10, ((W / 12)*2)-25  , (H / 5)*2,null);
        g.drawImage(wheat, (int)(W/15+5.7*(W/10)), H/10, ((W / 12)*2)-25  , (H / 5)*2,null);
        g.drawImage(wood, (int)(W/15+7.6*(W/10)), H/10, ((W / 12)*2)-25  , (H / 5)*2,null);

        g.drawImage(clay, W/15, (int)(H-(H / 9.1)), ((W / 12)*2)-25  , (H / 5)*2,null);
        g.drawImage(ore, (int)(W/15+1.9*(W/10)), (int)(H-(H / 9.1)), ((W / 12)*2)-25  , (H / 5)*2,null);
        g.drawImage(sheep, (int)(W/15+3.8*(W/10)), (int)(H-(H / 9.1)), ((W / 12)*2)-25  , (H / 5)*2,null);
        g.drawImage(wheat, (int)(W/15+5.7*(W/10)), (int)(H-(H / 9.1)), ((W / 12)*2)-25  , (H / 5)*2,null);
        g.drawImage(wood, (int)(W/15+7.6*(W/10)), (int)(H-(H / 9.1)), ((W / 12)*2)-25  , (H / 5)*2,null);

        // int cw=
//        /*
//         * islands
//         */
//        paintIslands(g);
//        if (moveAnother) {
//
//            ApaintMovableTiles(g);
//        }
//        if (shore) {
//
//            paintShoreableTiles(g);
//
//        }
//        if (move) {
//            paintMovableTiles(g);
//        }
//        if (useSandBagBtn) {
//            paintUseSandbag(g);
//        }
//        if (useHelicopterBtn) {
//            paintUseHelicopter(g);
//        }

        /*
         * treasures
         */
        // paintTreasures(g);

        // g.drawImage(discard, treasureDeckXPos, treasureDeckYPos - spaceBtTiles - cardW, cardH, cardW, null);
        // g.drawImage(discard, floodDeckXPos, floodDeckYPos + spaceBtTiles + cardW, cardH, cardW, null);

        /*
         * players, hand
         */
        // paintHandBackground(g);
        // paintPlayerSymbols(g);
        //paintAllHands(g);
        // paintPowns(g);
        /*
         * draw WaterMeter
         */
        // paintWaterMeter(g);
        /*
         * discard piles
         */
        //paintUsedTreasureCard(g);
        //paintUsedFloodCard(g);
        /*
        if(gameBoard.getIslandsClass().getSunkenTiles().size() == 24)
        {
        	JOptionPane.showInputDialog(null, "You lost because there is no tile.");
        }*/
    }


    public void addNotify() {
        super.addNotify();
        requestFocus();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        //private JComboBox gc,go,gs,gwh,gwo,rc,ro,rs,rwh,rwo;
        // private int c1,o1,s1,wh1,wo1,c2,o2,s2,wh2,wo2;
        if (e.getSource() == play) {
            String str = play.getSelectedItem().toString();
            if(str.equals("red")||str.equals("blue")||str.equals("yellow")||str.equals("white")){
                for(int i=0;i<4;i++){
                    if(GameState.players.get(i).getColor().equals(str)){
                        trader=i;
                    }
                }
            }

        }
        if (e.getSource() == confirm) {
            ArrayList<ResourceCard> give = new ArrayList<ResourceCard>();
            ArrayList<ResourceCard> recieve = new ArrayList<ResourceCard>();
            for (int i = 0; i < c1; i++) {
                give.add(new Clay());
            }
            for (int i = 0; i < o1; i++) {
                give.add(new Ore());
            }
            for (int i = 0; i < s1; i++) {
                give.add(new Sheep());
            }
            for (int i = 0; i < wh1; i++) {
                give.add(new Wheat());
            }
            for (int i = 0; i < wo1; i++) {
                give.add(new Wood());
            }


            for (int i = 0; i < c2; i++) {
                recieve.add(new Clay());
            }
            for (int i = 0; i < o2; i++) {
                recieve.add(new Ore());
            }
            for (int i = 0; i < s2; i++) {
                recieve.add(new Sheep());
            }
            for (int i = 0; i < wh2; i++) {
                recieve.add(new Wheat());
            }
            for (int i = 0; i < wo2; i++) {
                recieve.add(new Wood());
            }
            if(GameState.players.get(GameState.currentPlayer).trade(trader, give, recieve)){

            }
            else{
                infoBox("Trade failed", "");
            }
            p.change("play");
        }
        if (e.getSource() == leave) {
            p.change("play");
        }
        if (e.getSource() == gc) {
            c1 = Integer.parseInt(gc.getSelectedItem().toString());
        }
        if (e.getSource() == go) {
            o1 = Integer.parseInt(go.getSelectedItem().toString());
        }
        if (e.getSource() == gs) {
            s1 = Integer.parseInt(gs.getSelectedItem().toString());
        }
        if (e.getSource() == gwh) {
            wh1 = Integer.parseInt(gwh.getSelectedItem().toString());
        }
        if (e.getSource() == gwo) {
            wo1 = Integer.parseInt(gwo.getSelectedItem().toString());
        }


        if (e.getSource() == rc) {
            c2 = Integer.parseInt(rc.getSelectedItem().toString());
        }
        if (e.getSource() == ro) {
            o2 = Integer.parseInt(ro.getSelectedItem().toString());
        }
        if (e.getSource() == rs) {
            s2 = Integer.parseInt(rs.getSelectedItem().toString());
        }
        if (e.getSource() == rwh) {
            wh2 = Integer.parseInt(rwh.getSelectedItem().toString());
        }
        if (e.getSource() == rwo) {
            wo2 = Integer.parseInt(rwo.getSelectedItem().toString());
        }


/*
		if(e.getSource() == artificial)
		{
			try {
				JOptionPane.showMessageDialog(null, "player number and water level will be random for artificial intelligence.");
				p.generate2();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
			p.change("play");
		}

 */

    }

    public static void infoBox(String infoMessage, String titleBar)
    {
        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }
}
