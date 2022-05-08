/*
 * 6 GUIGameBoard
 * also contain all the names of the tiles, treasure cards, flood cards, treasures, ant etc.
 * apology: what I mean by "pown" is actually "pawn", but it's too late to change, so we'll just go with "pown" - 12/2/2021
 */

import java.awt.*;

import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class GUIGameBoard extends JPanel implements ActionListener, MouseListener {
    private boolean playedd;
    private boolean firstroad;
    private boolean secondroad;
    ParentPanel p;
    private boolean buildSettlement, buildRoad;
    private boolean buildfirsts;
    private boolean buildfirstr;
    BufferedImage bandit2;
    private boolean buildCity;
    private JComboBox<String> seeDeck, build, trade;
    private JComboBox development;
    private boolean ilovemen=false;
    private GameState GameState;
    private boolean bandit;
    private boolean onroad=false;
    private boolean onsettlement=true;
    private BufferedImage gameBoardBackground, redCard, blueCard, whiteCard, yellowCard;
    private BufferedImage diceL, diceR;
    private JButton roll;
    private int width, height;
    private boolean first;
    private boolean second;
    private String[] tradeDrop = {"Maritime", "Domestic"};
    private boolean isfirstset;
    private boolean issecondset;
    private int tempp;
    private String[] deckDrop = {"Deck", "red", "white", "blue", "yellow"};
    private String[] buildDrop = {"Build", "Road", "Settlement", "City", "Development Card"};
    private JButton nextTurn;
    private Color color;
    private String[]d={"Develop", "knight","2 road", "2 resource", "victory"};
    public void setBandit(boolean bandit) {
        this.bandit = bandit;
    }
    public void setPlayedd(boolean b){
        playedd=b;
    }
    public GUIGameBoard(ParentPanel p) {
        playedd=false;
        tempp=0;
        first=true;
        second=false;

        try {
            bandit2 =ImageIO.read(GUIGameBoard.class.getResource("/resource/tiles/bandit.PNG"));}
        catch(Exception E){
            System.out.println("MATTHEW LOVES");
        }
        firstroad=false;
        secondroad=false;
        buildfirsts=true;
        buildfirstr=false;
        isfirstset=true;
        issecondset=false;
        this.p = p;
//        gameBoard = p.getGameBoard();
//        waterMeter = gameBoard.getWaterMeter();
//        floodDeck = gameBoard.getFloodDeck();
//        waterLevel = waterMeter.getWaterLevel();
        GameState = p.getGameState();
        addMouseListener(this);
        width = p.getWidth();
        buildSettlement = false;
        buildRoad=false;
        buildCity = false;
        height = p.getHeight();
        color = Color.red;

        setLayout(null);
        Color cc = new Color(0, 32, 64);
        bandit=false;
        nextTurn = new JButton("next turn");
        build = new JComboBox(buildDrop);
        seeDeck = new JComboBox(deckDrop);
        trade = new JComboBox(tradeDrop);
        development = new JComboBox(d);
        roll = new JButton("roll");
        nextTurn.addActionListener(this);

        build.addActionListener(this);
        seeDeck.addActionListener(this);
        trade.addActionListener(this);
        development.addActionListener(this);
        roll.addActionListener(this);

        build.setBackground(cc);
        build.setForeground(Color.white);
        build.setBounds(width / 48, height - height / 8, width / 20, height / 40);
        add(build);


        roll.setBackground(cc);
        roll.setForeground(Color.white);
        roll.setBounds(width / 3, height / 8, width / 20, height / 40);
        add(roll);

        seeDeck.setBackground(cc);
        seeDeck.setForeground(Color.white);
        seeDeck.setBounds(width / 48 + build.getX() + width / 24, height - height / 8, width / 20, height / 40);
        add(seeDeck);

        trade.setBackground(cc);
        trade.setForeground(Color.white);
        trade.setBounds(width / 48 + seeDeck.getX() + width / 24, height - height / 8, width / 20, height / 40);
        add(trade);

        development.setBackground(cc);
        development.setForeground(Color.white);
        development.setBounds(width / 48 + trade.getX() + width / 24, height - height / 8, width / 20, height / 40);
        add(development);

        nextTurn.setBackground(cc);
        nextTurn.setForeground(Color.white);
        nextTurn.setBounds(width / 48 + development.getX() + width / 24, height - height / 8, width / 20, height / 40);
        add(nextTurn);
//        setLayout(null);
//        shuffleFloodCardsBtn = new JButton("shuffle");
//        shuffleFloodCardsBtn.setForeground(Color.WHITE);
//        shuffleFloodCardsBtn.setBackground(cc);
//        shuffleFloodCardsBtn.setBounds(floodDeckXPos, floodDeckYPos + spaceBtTiles * 2 + cardW * 2, cardH, buttonH);
//        shuffleFloodCardsBtn.addActionListener(this);
//        add(shuffleFloodCardsBtn);
//
//        getFloodCardsBtn = new JButton("draw");
//        getFloodCardsBtn.setForeground(Color.WHITE);
//        getFloodCardsBtn.setBackground(cc);
//        getFloodCardsBtn.setBounds(floodDeckXPos, floodDeckYPos - buttonH, cardH, buttonH);
//        getFloodCardsBtn.addActionListener(this);
//        add(getFloodCardsBtn);
//        getFloodCardsBtn.setVisible(true);
//        /*
//         * Treasure Cards: shuffle and get
//         */
//        shuffleTreasureCardsBtn = new JButton("shuffle");
//        shuffleTreasureCardsBtn.setForeground(Color.WHITE);
//        shuffleTreasureCardsBtn.setBackground(cc);
//        shuffleTreasureCardsBtn.setBounds(treasureDeckXPos, treasureDeckYPos - cardW - spaceBtTiles - buttonH, cardH, buttonH);
//        shuffleTreasureCardsBtn.addActionListener(this);
//        add(shuffleTreasureCardsBtn);
//
//        getTreasureCardsBtn = new JButton("draw 2");
//        getTreasureCardsBtn.setForeground(Color.WHITE);
//        getTreasureCardsBtn.setBackground(cc);
//        getTreasureCardsBtn.setBounds(treasureDeckXPos, treasureDeckYPos + spaceBtTiles + cardW, cardH, buttonH);
//        getTreasureCardsBtn.addActionListener(this);
//        add(getTreasureCardsBtn);
//
//        /*
//         * user movements: move, shore up, move another player (navigator), give treasure cards, end turns
//         */
//        int x = treasureDeckXPos - cardH - spaceBtTiles;
//        moveBtn = new JButton("move");
//        moveBtn.setForeground(Color.WHITE);
//        moveBtn.setBackground(cc);
//        moveBtn.setBounds(x, treasureDeckYPos - cardW, cardH, buttonH);
//        moveBtn.addActionListener(this);
//        add(moveBtn);
//
//        shoreUpBtn = new JButton("shore up");
//        shoreUpBtn.setForeground(Color.WHITE);
//        shoreUpBtn.setBackground(cc);
//        shoreUpBtn.setBounds(x, treasureDeckYPos - cardW + (buttonH + spaceBtTiles), cardH, buttonH);
//        shoreUpBtn.addActionListener(this);
//        add(shoreUpBtn);
//
//        moveAnotherPlayerBtn = new JButton("move another Player");
//        moveAnotherPlayerBtn.setForeground(Color.WHITE);
//        moveAnotherPlayerBtn.setBackground(cc);
//        moveAnotherPlayerBtn.setBounds(x, treasureDeckYPos - cardW + (buttonH + spaceBtTiles) * 2, cardH, buttonH);
//        moveAnotherPlayerBtn.addActionListener(this);
//        add(moveAnotherPlayerBtn);
//
//        giveCardBtn = new JButton("give/discard Card");
//        giveCardBtn.setForeground(Color.WHITE);
//        giveCardBtn.setBackground(cc);
//        giveCardBtn.setBounds(x, treasureDeckYPos - cardW + (buttonH + spaceBtTiles) * 3, cardH, buttonH);
//        giveCardBtn.addActionListener(this);
//        add(giveCardBtn);
//
//        endTurnBtn = new JButton("end move");
//        endTurnBtn.setForeground(Color.WHITE);
//        endTurnBtn.setBackground(cc);
//        endTurnBtn.setBounds(x, treasureDeckYPos - cardW + (buttonH + spaceBtTiles) * 4, cardH, buttonH);
//        endTurnBtn.addActionListener(this);
//        add(endTurnBtn);
//
//        /*
//         * special actions (helicopter and sandbags) and rules
//         */
//        moveToHelpBtn = new JButton("rules");
//        moveToHelpBtn.setForeground(Color.WHITE);
//        moveToHelpBtn.setBackground(cc);
//        moveToHelpBtn.setBounds(x, treasureDeckYPos - cardW - buttonH - spaceBtTiles, cardH, buttonH);
//        moveToHelpBtn.addActionListener(this);
//        add(moveToHelpBtn);
//
//        activateHelicopterBtn = new JButton("use Helicopter");
//        activateHelicopterBtn.setForeground(Color.WHITE);
//        activateHelicopterBtn.setBackground(cc);
//        activateHelicopterBtn.setBounds(x, treasureDeckYPos - cardW + (buttonH + spaceBtTiles) * 5, cardH, buttonH);
//        activateHelicopterBtn.addActionListener(this);
//        add(activateHelicopterBtn);
//
//        activateSandbagBtn = new JButton("use Sand bag");
//        activateSandbagBtn.setForeground(Color.WHITE);
//        activateSandbagBtn.setBackground(cc);
//        activateSandbagBtn.setBounds(x, treasureDeckYPos - cardW + (buttonH + spaceBtTiles) * 6, cardH, buttonH);
//        activateSandbagBtn.addActionListener(this);
//        add(activateSandbagBtn);

        /*
         * import images
         */
        try {
            gameBoardBackground = ImageIO.read(GUIGameBoard.class.getResource("/resource/backgrounds/Floor.jpg"));
            redCard = ImageIO.read(GUIGameBoard.class.getResource("/playerCard/RedCost.PNG"));
//            for (int i = 0; i < treasures.length; i++) {
//                treasures[i] = ImageIO.read(GUIGameBoard.class.getResource("/Treasures/" + treasureNames[i] + ".png"));
//            }
//            TreasureDeck_back = ImageIO.read(GUIGameBoard.class.getResource("/TreasureDeck/TreasureDeck_back.png"));
//            FloodDeck_back = ImageIO.read(GUIGameBoard.class.getResource("/FloodDeck/FloodDeck_back.png"));
//            discard = ImageIO.read(GUIGameBoard.class.getResource("/Images/discard.png"));
//            hand = ImageIO.read(GUIGameBoard.class.getResource("/Images/hand.png"));
//            WaterMeter = ImageIO.read(GUIGameBoard.class.getResource("/WaterMeter/WaterMeter.png"));
//            stick = ImageIO.read(GUIGameBoard.class.getResource("/WaterMeter/stick.png"));
//
//            for (int i = 0; i < playersBufferedImage.length; i++) {
//                playersBufferedImage[i] = ImageIO.read(GUIGameBoard.class.getResource("/Players/" + playerNames[i] + ".png"));
//            }
//            Tile_move = ImageIO.read(GUIGameBoard.class.getResource("/Islands/Tile_move.png"));
        } catch (Exception E) {
//
//            System.out.println("Exception");
//            return;
        }

        setVisible(true);
    }











    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(isfirstset){
            // JOptionPane.showInputDialog(null, "Each player place one settlement then road");
        }
        g.drawImage(gameBoardBackground, 0, 0, width, height, null);
        g.setColor(Color.WHITE);
        g.fillRect(width / 64, height / 36, (width / (3)), height / 6);
        g.fillRect(width / 64, height / 36 + height / 5, (width / (3)), height / 6);
        g.fillRect(width / 64, height / 36 + height / 5 * 2, (width / (3)), height / 6);
        g.fillRect(width / 64, height / 36 + height / 5 * 3, (width / (3)), height / 6);
        //AffineTransform af = AffineTransform.getTranslateInstance(100, 100);
        g.setColor(Color.BLACK);
        g.drawString("RED:", width/64+width/400, height/20+height/300);
        g.drawString("City:"+ GameState.players.get(0).cityNumber(), width/64+width/400, height/16+height/200);
        g.drawString("Settle:"+ GameState.players.get(0).settlementNumber(), width/64+width/64+width/400, height/16+height/200);
        g.drawString("Road:"+ GameState.players.get(0).roadNumber(), width/128+width/64+width/64+width/64+width/400, height/16+height/200);
        g.drawString("RC:"+ GameState.players.get(0).getResourceCards().size(), width/128+width/64+width/64+width/64+width/64+width/64+width/400, height/16+height/200);
        g.drawString("DC:"+ GameState.players.get(0).getDevelopmentCards().size(), width/128+width/64+width/64+width/64+width/64+width/64+width/64+width/400, height/16+height/200);

        g.drawString("BLUE:", width/64+width/400, height/20+height/300 + height / 5);
        g.drawString("City:"+ GameState.players.get(1).cityNumber(), width/64+width/400, height/16+height/200 + height / 5);
        g.drawString("Settle:"+ GameState.players.get(1).settlementNumber(), width/64+width/64+width/400, height/16+height/200 + height / 5);
        g.drawString("Road:"+ GameState.players.get(1).roadNumber(), width/128+width/64+width/64+width/64+width/400, height/16+height/200 + height / 5);
        g.drawString("RC:"+ GameState.players.get(1).getResourceCards().size(), width/128+width/64+width/64+width/64+width/64+width/64+width/400, height/16+height/200+ height / 5);
        g.drawString("DC:"+ GameState.players.get(1).getDevelopmentCards().size(), width/128+width/64+width/64+width/64+width/64+width/64+width/64+width/400, height/16+height/200+ height / 5);

        g.drawString("WHITE:", width/64+width/400, height/20+height/300 + height / 5 + height / 5);
        g.drawString("City:"+ GameState.players.get(2).cityNumber(), width/64+width/400, height/16+height/200 + height / 5 + height / 5);
        g.drawString("Settle:"+ GameState.players.get(2).settlementNumber(), width/64+width/64+width/400, height/16+height/200 + height / 5 + height / 5);
        g.drawString("Road:"+ GameState.players.get(2).roadNumber(), width/128+width/64+width/64+width/64+width/400, height/16+height/200 + height / 5 + height / 5);
        g.drawString("RC:"+ GameState.players.get(2).getResourceCards().size(), width/128+width/64+width/64+width/64+width/64+width/64+width/400, height/16+height/200 + height / 5 + height / 5);
        g.drawString("DC:"+ GameState.players.get(2).getDevelopmentCards().size(), width/128+width/64+width/64+width/64+width/64+width/64+width/64+width/400, height/16+height/200 + height / 5 + height / 5);

        g.drawString("YELLOW:", width/64+width/400, height/20+height/300 + height / 5 + height / 5 + height / 5);
        g.drawString("City:"+ GameState.players.get(3).cityNumber(), width/64+width/400, height/16+height/200 + height / 5 + height / 5 + height / 5);
        g.drawString("Settle:"+ GameState.players.get(3).settlementNumber(), width/64+width/64+width/400, height/16+height/200 + height / 5 + height / 5 + height / 5);
        g.drawString("Road:"+ GameState.players.get(3).roadNumber(), width/128+width/64+width/64+width/64+width/400, height/16+height/200 + height / 5 + height / 5 + height / 5);
        g.drawString("RC:"+ GameState.players.get(3).getResourceCards().size(), width/128+width/64+width/64+width/64+width/64+width/64+width/400, height/16+height/200 + height / 5 + height / 5 + height / 5);
        g.drawString("DC:"+ GameState.players.get(3).getDevelopmentCards().size(), width/128+width/64+width/64+width/64+width/64+width/64+width/64+width/400, height/16+height/200 + height / 5 + height / 5 + height / 5);

        //g.drawImage(redCard,width/64,height / 36,width/20,100,null);


        Player curr = GameState.players.get(GameState.getCurrentPlayer());
        if (curr.getColor() == "red") {
            //g.drawRect(width-width/20,height-height/20,width/20, height/20);
            g.setColor(Color.red);
            g.fillRect(width - width / 15, 0, width / 15, height / 15);
            //
        }
        if (curr.getColor() == "blue") {
            //g.drawRect(width-width/20,height-height/20,width/20, height/20);
            g.setColor(Color.blue);
            g.fillRect(width - width / 15, 0, width / 15, height / 15);
            //
        }
        if (curr.getColor() == "white") {
            //g.drawRect(width-width/20,height-height/20,width/20, height/20);
            g.setColor(Color.white);
            g.fillRect(width - width / 15, 0, width / 15, height / 15);
            //
        }
        if (curr.getColor() == "yellow") {
            //g.drawRect(width-width/20,height-height/20,width/20, height/20);
            g.setColor(Color.yellow);
            g.fillRect(width - width / 15, 0, width / 15, height / 15);
            //System.out.println("MATTHEW");
        }
        //BufferedImage bandit = null;

        double wd = 2048 / 200;
        //rbwy
        //int h=abc;
        double hd = 1147 / 200;
        //int w = hd;
        int w = (int) ((double) width / wd);
        int h = (int) ((double) height / hd);
        int side = (int) ((double) w / Math.sqrt(3) / 2);
        int cw = width * 81 / 128 - w;
        int ch = height / 10;

        g.setColor(Color.black);

        for (int i = 0; i < 3; i++) {
            Tile current = GameState.tilesList[i];

            g.drawImage(GameState.tilesList[i].getImage(), cw + i * w, ch, (int) ((double) width / wd), (int) ((double) height / hd), null);
            if(current.getHasBandit()){
             //   System.out.println("OH YEAH");
                g.drawImage(bandit2, cw + i * w + w / 2, ch + h / 2, (int) ((double) width / wd/3), (int) ((double) height / hd/3), null);
            }
            g.drawString("" + GameState.tilesList[i].getRollNumber(), cw + i * w + w / 2, ch + h / 2);

            current.setXpos(cw + i * w + w / 2);
            current.setYpos(ch + h / 2);
            current.setXverticies(doX(cw + i * w + w / 2));
            current.setYverticies(doY(ch + h / 2));
            current.setxroad(doxv(current.getXverticies()));
            current.setyroad(doyv(current.getYverticies()));
            for (int k = 0; k < 6; k++) {
                int xpos = current.getxroad()[k];
                int ypos = current.getyroad()[k];
                //System.out.println(xpos+" "+ypos);
                //g.drawRect((int) ((double)xpos-width/81.92), (int) (ypos-(double)height/45.88), (int) ((double)width/40.96), (int) ((double)height/22.94));
                xpos = current.getXverticies()[k];
                ypos = current.getYverticies()[k];
                //g.drawRect((int) ((double)xpos-width/81.92), (int) (ypos-(double)height/45.88), (int) ((double)width/40.96), (int) ((double)height/22.94));
            }
        }
        ch = (int) (ch + (int) (((double) w / Math.sqrt(3)) + side - (double) h / 40));
        cw = cw - w / 2;
        for (int i = 0; i < 4; i++) {
            Tile current = GameState.tilesList[i + 3];
//            for(int j=0;j<6;j++){
//                Tile e=GameState.tilesList[j];
//                System.out.println("TILE "+i+3+" SPOT "+ j+": x "+e.getXverticies()[j]+" y "+e.getYverticies()[j]);
//                //System.out.println("TILE "+i+" SPOT "+ j+": "+canFit(e.getX(),e.getY(),curr.getXverticies()[j],curr.getYverticies()[j]));
//            }

            g.drawImage(GameState.tilesList[i + 3].getImage(), cw + i * w, ch, (int) ((double) width / wd), (int) ((double) height / hd), null);
            if(current.getHasBandit()){
             //   System.out.println("OH YEAH");
                g.drawImage(bandit2, cw + i * w + w / 2, ch + h / 2, (int) ((double) width / wd/3), (int) ((double) height / hd/3), null);
            }
            g.drawString("" + GameState.tilesList[i + 3].getRollNumber(), cw + i * w + w / 2, ch + h / 2);

            current.setXpos(cw + i * w + w / 2);
            current.setYpos(ch + h / 2);
            current.setXverticies(doX(cw + i * w + w / 2));
            current.setYverticies(doY(ch + h / 2));
            current.setxroad(doxv(current.getXverticies()));
            current.setyroad(doyv(current.getYverticies()));
            for (int k = 0; k < 6; k++) {
                int xpos = current.getXverticies()[k];
                int ypos = current.getYverticies()[k];
                //g.drawRect((int) ((double)xpos-width/81.92), (int) (ypos-(double)height/45.88), (int) ((double)width/40.96), (int) ((double)height/22.94));
            }
        }
        cw = cw - w / 2;
        ch = (int) (ch + (int) (((double) w / Math.sqrt(3)) + side - (double) h / 40));
        for (int i = 0; i < 5; i++) {

            Tile current = GameState.tilesList[i + 7];

            g.drawImage(GameState.tilesList[i + 7].getImage(), cw + i * w, ch, (int) ((double) width / wd), (int) ((double) height / hd), null);
            if(current.getHasBandit()){
         //       System.out.println("OH YEAH");
                g.drawImage(bandit2, cw + i * w + w / 2, ch + h / 2, (int) ((double) width / wd/3), (int) ((double) height / hd/3), null);
            }
            g.drawString("" + GameState.tilesList[i + 7].getRollNumber(), cw + i * w + w / 2, ch + h / 2);
            current.setXpos(cw + i * w + w / 2);
            current.setYpos(ch + h / 2);
            current.setXverticies(doX(cw + i * w + w / 2));
            current.setYverticies(doY(ch + h / 2));
            current.setxroad(doxv(current.getXverticies()));
            current.setyroad(doyv(current.getYverticies()));
            for (int k = 0; k < 6; k++) {
                int xpos = current.getXverticies()[k];
                int ypos = current.getYverticies()[k];
                //g.drawRect((int) ((double)xpos-width/81.92), (int) (ypos-(double)height/45.88), (int) ((double)width/40.96), (int) ((double)height/22.94));
            }
        }
        cw = cw + w / 2;
        ch = (int) (ch + (int) (((double) w / Math.sqrt(3)) + side - (double) h / 40));
        for (int i = 0; i < 4; i++) {
            Tile current = GameState.tilesList[i + 12];
            g.drawImage(GameState.tilesList[i + 12].getImage(), cw + i * w, ch, (int) ((double) width / wd), (int) ((double) height / hd), null);

            if(current.getHasBandit()){
           //     System.out.println("OH YEAH");
                g.drawImage(bandit2, cw + i * w + w / 2, ch + h / 2, (int) ((double) width / wd/3), (int) ((double) height / hd/3), null);
            }
            g.drawString("" + GameState.tilesList[i + 12].getRollNumber(), cw + i * w + w / 2, ch + h / 2);
            current.setXpos(cw + i * w + w / 2);
            current.setYpos(ch + h / 2);
            current.setXverticies(doX(cw + i * w + w / 2));
            current.setYverticies(doY(ch + h / 2));
            current.setxroad(doxv(current.getXverticies()));
            current.setyroad(doyv(current.getYverticies()));
            for (int k = 0; k < 6; k++) {
                int xpos = current.getXverticies()[k];
                int ypos = current.getYverticies()[k];
                //g.drawRect((int) ((double)xpos-width/81.92), (int) (ypos-(double)height/45.88), (int) ((double)width/40.96), (int) ((double)height/22.94));
            }
        }
        //g.drawRect(width / 2, height / 2, 100, 100);
        cw = cw + w / 2;
        ch = (int) (ch + (int) (((double) w / Math.sqrt(3)) + side - (double) h / 40));
        for (int i = 0; i < 3; i++) {
            Tile current = GameState.tilesList[i + 16];
            g.drawImage(GameState.tilesList[i + 16].getImage(), cw + i * w, ch, (int) ((double) width / wd), (int) ((double) height / hd), null);
            if(current.getHasBandit()){
          //      System.out.println("OH YEAH");
                g.drawImage(bandit2, cw + i * w + w / 2, ch + h / 2, (int) ((double) width / wd/3), (int) ((double) height / hd/3), null);
            }
            g.drawString("" + GameState.tilesList[i + 16].getRollNumber(), cw + i * w + w / 2, ch + h / 2);
            current.setXpos(cw + i * w + w / 2);
            current.setYpos(ch + h / 2);

            current.setXverticies(doX(cw + i * w + w / 2));
            current.setYverticies(doY(ch + h / 2));
            current.setxroad(doxv(current.getXverticies()));
            current.setyroad(doyv(current.getYverticies()));
            for (int k = 0; k < 6; k++) {
                int xpos = current.getXverticies()[k];
                int ypos = current.getYverticies()[k];
                //g.drawRect((int) ((double)xpos-width/81.92), (int) (ypos-(double)height/45.88), (int) ((double)width/40.96), (int) ((double)height/22.94));
            }
        }


        cw = width * 81 / 128 - w;
        ch = height / 10;
        for (int i = 0; i < 3; i++) {
            Tile current = GameState.tilesList[i];
            //g.drawImage(GameState.tilesList[i].getImage(), cw + i * w, ch, (int) ((double) width / wd), (int) ((double) height / hd), null);
            //g.drawString("" + GameState.tilesList[i].getRollNumber(), cw + i * w + w / 2, ch + h / 2);
//            current.setXpos(cw+i*w+w/2);
//            current.setYpos(ch+h/2);
//            current.setXverticies(doX(cw+i*w+w/2));
//            current.setYverticies(doY(ch+h/2));
            for (int k = 0; k < 6; k++) {
                if (current.getVertexRoads()[k]) {
                    int xpos = current.getxroad()[k];
                    int ypos = current.getyroad()[k];
                    String c = current.getVertexColor()[k];
                    //System.out.println(p.getColor()+": AIOUGHIUDSHIGUSHIGLUDHULSGD");
                    if (c.equals("red")) {
                        //g.drawRect(width-width/20,height-height/20,width/20, height/20);
                        g.setColor(Color.red);

                        //System.out.println("MATTHEW");
                    }
                    if (c.equals("blue")) {
                        //g.drawRect(width-width/20,height-height/20,width/20, height/20);
                        g.setColor(Color.blue);

                        //
                    }
                    if (c.equals("white")) {
                        //g.drawRect(width-width/20,height-height/20,width/20, height/20);
                        g.setColor(Color.white);

                        //
                    }
                    if (c.equals("yellow")) {
                        //g.drawRect(width-width/20,height-height/20,width/20, height/20);
                        g.setColor(Color.yellow);

                        //System.out.println("MATTHEW");
                    }
                    g.fillRect((int) ((double) xpos - width / 81.92), (int) (ypos - (double) height / 45.88), (int) ((double) width / 40.96), (int) ((double) height / 22.94));
                    g.setColor(Color.black);
                }
                if (current.gethascityorsettlement()[k] == 1) {
                    int xpos = current.getXverticies()[k];
                    int ypos = current.getYverticies()[k];
                    Player p = GameState.players.get(GameState.getCurrentPlayer());
                    String c = current.getSettlementColor()[k];
                    //System.out.println(p.getColor()+": AIOUGHIUDSHIGUSHIGLUDHULSGD");
                    if (c.equals("red")) {
                        //g.drawRect(width-width/20,height-height/20,width/20, height/20);
                        g.setColor(Color.red);


                    }
                    if (c.equals("blue")) {
                        //g.drawRect(width-width/20,height-height/20,width/20, height/20);
                        g.setColor(Color.blue);

                        //
                    }
                    if (c.equals("white")) {
                        //g.drawRect(width-width/20,height-height/20,width/20, height/20);
                        g.setColor(Color.white);

                        //
                    }
                    if (c.equals("yellow")) {
                        //g.drawRect(width-width/20,height-height/20,width/20, height/20);
                        g.setColor(Color.yellow);

                        //System.out.println("MATTHEW");
                    }
                    g.fillRect((int) ((double) xpos - width / 81.92), (int) (ypos - (double) height / 45.88), (int) ((double) width / 40.96), (int) ((double) height / 22.94));
                    g.setColor(Color.black);
                }
                if (current.gethascityorsettlement()[k] == 2) {
                    int xpos = current.getXverticies()[k];
                    int ypos = current.getYverticies()[k];
                    Player p = GameState.players.get(GameState.getCurrentPlayer());
                    String c = current.getSettlementColor()[k];
                    //System.out.println(p.getColor()+": AIOUGHIUDSHIGUSHIGLUDHULSGD");
                    if (c.equals("red")) {
                        //g.drawRect(width-width/20,height-height/20,width/20, height/20);
                        g.setColor(Color.red);

                        //System.out.println("MATTHEW");
                    }
                    if (c.equals("blue")) {
                        //g.drawRect(width-width/20,height-height/20,width/20, height/20);
                        g.setColor(Color.blue);

                        //
                    }
                    if (c.equals("white")) {
                        //g.drawRect(width-width/20,height-height/20,width/20, height/20);
                        g.setColor(Color.white);

                        //
                    }
                    if (c.equals("yellow")) {
                        //g.drawRect(width-width/20,height-height/20,width/20, height/20);
                        g.setColor(Color.yellow);

                        //System.out.println("MATTHEW");
                    }
                    g.fillOval((int) ((double) xpos - width / 81.92), (int) (ypos - (double) height / 45.88), (int) ((double) width / 40.96), (int) ((double) height / 22.94));
                    g.setColor(Color.black);
                }
                //g.drawRect((int) ((double)xpos-width/81.92), (int) (ypos-(double)height/45.88), (int) ((double)width/40.96), (int) ((double)height/22.94));
            }
        }
        ch = (int) (ch + (int) (((double) w / Math.sqrt(3)) + side - (double) h / 40));
        cw = cw - w / 2;
        for (int i = 0; i < 4; i++) {
            Tile current = GameState.tilesList[i + 3];
//            for(int j=0;j<6;j++){
//                Tile e=GameState.tilesList[j];
//                System.out.println("TILE "+i+3+" SPOT "+ j+": x "+e.getXverticies()[j]+" y "+e.getYverticies()[j]);
//                //System.out.println("TILE "+i+" SPOT "+ j+": "+canFit(e.getX(),e.getY(),curr.getXverticies()[j],curr.getYverticies()[j]));
//            }
            //g.drawImage(GameState.tilesList[i + 3].getImage(), cw + i * w, ch, (int) ((double) width / wd), (int) ((double) height / hd), null);
            // g.drawString("" + GameState.tilesList[i + 3].getRollNumber(), cw + i * w + w / 2, ch + h / 2);
//            current.setXpos(cw+i*w+w/2);
//            current.setYpos(ch+h/2);
//            current.setXverticies(doX(cw+i*w+w/2));
//            current.setYverticies(doY(ch+h/2));
            for (int k = 0; k < 6; k++) {
                if (current.getVertexRoads()[k]) {
                    int xpos = current.getxroad()[k];
                    int ypos = current.getyroad()[k];
                    String c = current.getVertexColor()[k];
                    //System.out.println(p.getColor()+": AIOUGHIUDSHIGUSHIGLUDHULSGD");
                    if (c.equals("red")) {
                        //g.drawRect(width-width/20,height-height/20,width/20, height/20);
                        g.setColor(Color.red);

                       //
                    }
                    if (c.equals("blue")) {
                        //g.drawRect(width-width/20,height-height/20,width/20, height/20);
                        g.setColor(Color.blue);

                        //
                    }
                    if (c.equals("white")) {
                        //g.drawRect(width-width/20,height-height/20,width/20, height/20);
                        g.setColor(Color.white);

                        //
                    }
                    if (c.equals("yellow")) {
                        //g.drawRect(width-width/20,height-height/20,width/20, height/20);
                        g.setColor(Color.yellow);

                        //System.out.println("MATTHEW");
                    }
                    g.fillRect((int) ((double) xpos - width / 81.92), (int) (ypos - (double) height / 45.88), (int) ((double) width / 40.96), (int) ((double) height / 22.94));
                    g.setColor(Color.black);
                }
                if (current.gethascityorsettlement()[k] == 1) {
                    int xpos = current.getXverticies()[k];
                    int ypos = current.getYverticies()[k];
                    Player p = GameState.players.get(GameState.getCurrentPlayer());
                    String c = current.getSettlementColor()[k];
                    //System.out.println(p.getColor()+": AIOUGHIUDSHIGUSHIGLUDHULSGD");
                    if (c.equals("red")) {
                        //g.drawRect(width-width/20,height-height/20,width/20, height/20);
                        g.setColor(Color.red);

                        //System.out.println("MATTHEW");
                    }
                    if (c.equals("blue")) {
                        //g.drawRect(width-width/20,height-height/20,width/20, height/20);
                        g.setColor(Color.blue);

                        //
                    }
                    if (c.equals("white")) {
                        //g.drawRect(width-width/20,height-height/20,width/20, height/20);
                        g.setColor(Color.white);

                        //
                    }
                    if (c.equals("yellow")) {
                        //g.drawRect(width-width/20,height-height/20,width/20, height/20);
                        g.setColor(Color.yellow);

                        //System.out.println("MATTHEW");
                    }
                    g.fillRect((int) ((double) xpos - width / 81.92), (int) (ypos - (double) height / 45.88), (int) ((double) width / 40.96), (int) ((double) height / 22.94));
                    g.setColor(Color.black);
                }
                if (current.gethascityorsettlement()[k] == 2) {
                    int xpos = current.getXverticies()[k];
                    int ypos = current.getYverticies()[k];
                    Player p = GameState.players.get(GameState.getCurrentPlayer());
                    String c = current.getSettlementColor()[k];
                    //System.out.println(p.getColor()+": AIOUGHIUDSHIGUSHIGLUDHULSGD");
                    if (c.equals("red")) {
                        //g.drawRect(width-width/20,height-height/20,width/20, height/20);
                        g.setColor(Color.red);

                      //
                    }
                    if (c.equals("blue")) {
                        //g.drawRect(width-width/20,height-height/20,width/20, height/20);
                        g.setColor(Color.blue);

                        //
                    }
                    if (c.equals("white")) {
                        //g.drawRect(width-width/20,height-height/20,width/20, height/20);
                        g.setColor(Color.white);

                        //
                    }
                    if (c.equals("yellow")) {
                        //g.drawRect(width-width/20,height-height/20,width/20, height/20);
                        g.setColor(Color.yellow);

                        //System.out.println("MATTHEW");
                    }
                    g.fillOval((int) ((double) xpos - width / 81.92), (int) (ypos - (double) height / 45.88), (int) ((double) width / 40.96), (int) ((double) height / 22.94));
                    g.setColor(Color.black);
                }
                //g.drawRect((int) ((double)xpos-width/81.92), (int) (ypos-(double)height/45.88), (int) ((double)width/40.96), (int) ((double)height/22.94));
            }
        }
        cw = cw - w / 2;
        ch = (int) (ch + (int) (((double) w / Math.sqrt(3)) + side - (double) h / 40));
        for (int i = 0; i < 5; i++) {
            Tile current = GameState.tilesList[i + 7];
//            g.drawImage(GameState.tilesList[i + 7].getImage(), cw + i * w, ch, (int) ((double) width / wd), (int) ((double) height / hd), null);
//            g.drawString("" + GameState.tilesList[i + 7].getRollNumber(), cw + i * w + w / 2, ch + h / 2);
//            current.setXpos(cw+i*w+w/2);
//            current.setYpos(ch+h/2);
//            current.setXverticies(doX(cw+i*w+w/2));
//            current.setYverticies(doY(ch+h/2));
            for (int k = 0; k < 6; k++) {
                if (current.getVertexRoads()[k]) {
                    int xpos = current.getxroad()[k];
                    int ypos = current.getyroad()[k];
                    String c = current.getVertexColor()[k];
                    //System.out.println(p.getColor()+": AIOUGHIUDSHIGUSHIGLUDHULSGD");
                    if (c.equals("red")) {
                        //g.drawRect(width-width/20,height-height/20,width/20, height/20);
                        g.setColor(Color.red);

                  //
                    }
                    if (c.equals("blue")) {
                        //g.drawRect(width-width/20,height-height/20,width/20, height/20);
                        g.setColor(Color.blue);

                        //
                    }
                    if (c.equals("white")) {
                        //g.drawRect(width-width/20,height-height/20,width/20, height/20);
                        g.setColor(Color.white);

                        //
                    }
                    if (c.equals("yellow")) {
                        //g.drawRect(width-width/20,height-height/20,width/20, height/20);
                        g.setColor(Color.yellow);

                        //System.out.println("MATTHEW");
                    }
                    g.fillRect((int) ((double) xpos - width / 81.92), (int) (ypos - (double) height / 45.88), (int) ((double) width / 40.96), (int) ((double) height / 22.94));
                    g.setColor(Color.black);
                }
                if (current.gethascityorsettlement()[k] == 1) {
                    int xpos = current.getXverticies()[k];
                    int ypos = current.getYverticies()[k];
                    Player p = GameState.players.get(GameState.getCurrentPlayer());
                    String c = current.getSettlementColor()[k];
                    //System.out.println(p.getColor()+": AIOUGHIUDSHIGUSHIGLUDHULSGD");
                    if (c.equals("red")) {
                        //g.drawRect(width-width/20,height-height/20,width/20, height/20);
                        g.setColor(Color.red);

                       //
                    }
                    if (c.equals("blue")) {
                        //g.drawRect(width-width/20,height-height/20,width/20, height/20);
                        g.setColor(Color.blue);

                        //
                    }
                    if (c.equals("white")) {
                        //g.drawRect(width-width/20,height-height/20,width/20, height/20);
                        g.setColor(Color.white);

                        //
                    }
                    if (c.equals("yellow")) {
                        //g.drawRect(width-width/20,height-height/20,width/20, height/20);
                        g.setColor(Color.yellow);

                        //System.out.println("MATTHEW");
                    }
                    g.fillRect((int) ((double) xpos - width / 81.92), (int) (ypos - (double) height / 45.88), (int) ((double) width / 40.96), (int) ((double) height / 22.94));
                    g.setColor(Color.black);
                }
                if (current.gethascityorsettlement()[k] == 2) {
                    int xpos = current.getXverticies()[k];
                    int ypos = current.getYverticies()[k];
                    Player p = GameState.players.get(GameState.getCurrentPlayer());
                    String c = current.getSettlementColor()[k];
                    //System.out.println(p.getColor()+": AIOUGHIUDSHIGUSHIGLUDHULSGD");
                    if (c.equals("red")) {
                        //g.drawRect(width-width/20,height-height/20,width/20, height/20);
                        g.setColor(Color.red);


                    }
                    if (c.equals("blue")) {
                        //g.drawRect(width-width/20,height-height/20,width/20, height/20);
                        g.setColor(Color.blue);

                        //
                    }
                    if (c.equals("white")) {
                        //g.drawRect(width-width/20,height-height/20,width/20, height/20);
                        g.setColor(Color.white);

                        //
                    }
                    if (c.equals("yellow")) {
                        //g.drawRect(width-width/20,height-height/20,width/20, height/20);
                        g.setColor(Color.yellow);

                        //System.out.println("MATTHEW");
                    }
                    g.fillOval((int) ((double) xpos - width / 81.92), (int) (ypos - (double) height / 45.88), (int) ((double) width / 40.96), (int) ((double) height / 22.94));
                    g.setColor(Color.black);
                }
                //g.drawRect((int) ((double)xpos-width/81.92), (int) (ypos-(double)height/45.88), (int) ((double)width/40.96), (int) ((double)height/22.94));
            }
        }
        cw = cw + w / 2;
        ch = (int) (ch + (int) (((double) w / Math.sqrt(3)) + side - (double) h / 40));
        for (int i = 0; i < 4; i++) {
            Tile current = GameState.tilesList[i + 12];
//            g.drawImage(GameState.tilesList[i + 12].getImage(), cw + i * w, ch, (int) ((double) width / wd), (int) ((double) height / hd), null);
//            g.drawString("" + GameState.tilesList[i + 12].getRollNumber(), cw + i * w + w / 2, ch + h / 2);
//            current.setXpos(cw+i*w+w/2);
//            current.setYpos(ch+h/2);
//            current.setXverticies(doX(cw+i*w+w/2));
//            current.setYverticies(doY(ch+h/2));
            for (int k = 0; k < 6; k++) {
                if (current.getVertexRoads()[k]) {
                    int xpos = current.getxroad()[k];
                    int ypos = current.getyroad()[k];
                    String c = current.getVertexColor()[k];
                    //System.out.println(p.getColor()+": AIOUGHIUDSHIGUSHIGLUDHULSGD");
                    if (c.equals("red")) {
                        //g.drawRect(width-width/20,height-height/20,width/20, height/20);
                        g.setColor(Color.red);


                    }
                    if (c.equals("blue")) {
                        //g.drawRect(width-width/20,height-height/20,width/20, height/20);
                        g.setColor(Color.blue);

                        //
                    }
                    if (c.equals("white")) {
                        //g.drawRect(width-width/20,height-height/20,width/20, height/20);
                        g.setColor(Color.white);

                        //
                    }
                    if (c.equals("yellow")) {
                        //g.drawRect(width-width/20,height-height/20,width/20, height/20);
                        g.setColor(Color.yellow);

                        //System.out.println("MATTHEW");
                    }
                    g.fillRect((int) ((double) xpos - width / 81.92), (int) (ypos - (double) height / 45.88), (int) ((double) width / 40.96), (int) ((double) height / 22.94));
                    g.setColor(Color.black);
                }
                if (current.gethascityorsettlement()[k] == 1) {
                    int xpos = current.getXverticies()[k];
                    int ypos = current.getYverticies()[k];
                    Player p = GameState.players.get(GameState.getCurrentPlayer());
                    String c = current.getSettlementColor()[k];
                    //System.out.println(p.getColor()+": AIOUGHIUDSHIGUSHIGLUDHULSGD");
                    if (c.equals("red")) {
                        //g.drawRect(width-width/20,height-height/20,width/20, height/20);
                        g.setColor(Color.red);


                    }
                    if (c.equals("blue")) {
                        //g.drawRect(width-width/20,height-height/20,width/20, height/20);
                        g.setColor(Color.blue);

                        //
                    }
                    if (c.equals("white")) {
                        //g.drawRect(width-width/20,height-height/20,width/20, height/20);
                        g.setColor(Color.white);

                        //
                    }
                    if (c.equals("yellow")) {
                        //g.drawRect(width-width/20,height-height/20,width/20, height/20);
                        g.setColor(Color.yellow);

                        //System.out.println("MATTHEW");
                    }
                    g.fillRect((int) ((double) xpos - width / 81.92), (int) (ypos - (double) height / 45.88), (int) ((double) width / 40.96), (int) ((double) height / 22.94));
                    g.setColor(Color.black);
                }
                if (current.gethascityorsettlement()[k] == 2) {
                    int xpos = current.getXverticies()[k];
                    int ypos = current.getYverticies()[k];
                    Player p = GameState.players.get(GameState.getCurrentPlayer());
                    String c = current.getSettlementColor()[k];
                    //System.out.println(p.getColor()+": AIOUGHIUDSHIGUSHIGLUDHULSGD");
                    if (c.equals("red")) {
                        //g.drawRect(width-width/20,height-height/20,width/20, height/20);
                        g.setColor(Color.red);


                    }
                    if (c.equals("blue")) {
                        //g.drawRect(width-width/20,height-height/20,width/20, height/20);
                        g.setColor(Color.blue);

                        //
                    }
                    if (c.equals("white")) {
                        //g.drawRect(width-width/20,height-height/20,width/20, height/20);
                        g.setColor(Color.white);

                        //
                    }
                    if (c.equals("yellow")) {
                        //g.drawRect(width-width/20,height-height/20,width/20, height/20);
                        g.setColor(Color.yellow);

                        //System.out.println("MATTHEW");
                    }
                    g.fillOval((int) ((double) xpos - width / 81.92), (int) (ypos - (double) height / 45.88), (int) ((double) width / 40.96), (int) ((double) height / 22.94));
                    g.setColor(Color.black);
                }
                //g.drawRect((int) ((double)xpos-width/81.92), (int) (ypos-(double)height/45.88), (int) ((double)width/40.96), (int) ((double)height/22.94));
            }
        }
        //g.drawRect(width / 2, height / 2, 100, 100);
        cw = cw + w / 2;
        ch = (int) (ch + (int) (((double) w / Math.sqrt(3)) + side - (double) h / 40));
        for (int i = 0; i < 3; i++) {
            Tile current = GameState.tilesList[i + 16];
//            g.drawImage(GameState.tilesList[i + 16].getImage(), cw + i * w, ch, (int) ((double) width / wd), (int) ((double) height / hd), null);
//            g.drawString("" + GameState.tilesList[i + 16].getRollNumber(), cw + i * w + w / 2, ch + h / 2);
//            current.setXpos(cw+i*w+w/2);
//            current.setYpos(ch+h/2);
//            current.setXverticies(doX(cw+i*w+w/2));
//            current.setYverticies(doY(ch+h/2));
            for (int k = 0; k < 6; k++) {
                if (current.getVertexRoads()[k]) {
                    int xpos = current.getxroad()[k];
                    int ypos = current.getyroad()[k];
                    String c = current.getVertexColor()[k];
                    //System.out.println(p.getColor()+": AIOUGHIUDSHIGUSHIGLUDHULSGD");
                    if (c.equals("red")) {
                        //g.drawRect(width-width/20,height-height/20,width/20, height/20);
                        g.setColor(Color.red);


                    }
                    if (c.equals("blue")) {
                        //g.drawRect(width-width/20,height-height/20,width/20, height/20);
                        g.setColor(Color.blue);

                        //
                    }
                    if (c.equals("white")) {
                        //g.drawRect(width-width/20,height-height/20,width/20, height/20);
                        g.setColor(Color.white);

                        //
                    }
                    if (c.equals("yellow")) {
                        //g.drawRect(width-width/20,height-height/20,width/20, height/20);
                        g.setColor(Color.yellow);

                        //System.out.println("MATTHEW");
                    }
                    g.fillRect((int) ((double) xpos - width / 81.92), (int) (ypos - (double) height / 45.88), (int) ((double) width / 40.96), (int) ((double) height / 22.94));
                    g.setColor(Color.black);
                }
                if (current.gethascityorsettlement()[k] == 1) {
                    int xpos = current.getXverticies()[k];
                    int ypos = current.getYverticies()[k];
                    Player p = GameState.players.get(GameState.getCurrentPlayer());
                    String c = current.getSettlementColor()[k];
                    //System.out.println(p.getColor()+": AIOUGHIUDSHIGUSHIGLUDHULSGD");
                    if (c.equals("red")) {
                        //g.drawRect(width-width/20,height-height/20,width/20, height/20);
                        g.setColor(Color.red);


                    }
                    if (c.equals("blue")) {
                        //g.drawRect(width-width/20,height-height/20,width/20, height/20);
                        g.setColor(Color.blue);

                        //
                    }
                    if (c.equals("white")) {
                        //g.drawRect(width-width/20,height-height/20,width/20, height/20);
                        g.setColor(Color.white);

                        //
                    }
                    if (c.equals("yellow")) {
                        //g.drawRect(width-width/20,height-height/20,width/20, height/20);
                        g.setColor(Color.yellow);

                        //System.out.println("MATTHEW");
                    }
                    g.fillRect((int) ((double) xpos - width / 81.92), (int) (ypos - (double) height / 45.88), (int) ((double) width / 40.96), (int) ((double) height / 22.94));
                    g.setColor(Color.black);
                }
                if (current.gethascityorsettlement()[k] == 2) {
                    int xpos = current.getXverticies()[k];
                    int ypos = current.getYverticies()[k];
                    Player p = GameState.players.get(GameState.getCurrentPlayer());
                    String c = current.getSettlementColor()[k];
                    //System.out.println(p.getColor()+": AIOUGHIUDSHIGUSHIGLUDHULSGD");
                    if (c.equals("red")) {
                        //g.drawRect(width-width/20,height-height/20,width/20, height/20);
                        g.setColor(Color.red);


                    }
                    if (c.equals("blue")) {
                        //g.drawRect(width-width/20,height-height/20,width/20, height/20);
                        g.setColor(Color.blue);

                        //
                    }
                    if (c.equals("white")) {
                        //g.drawRect(width-width/20,height-height/20,width/20, height/20);
                        g.setColor(Color.white);

                        //
                    }
                    if (c.equals("yellow")) {
                        //g.drawRect(width-width/20,height-height/20,width/20, height/20);
                        g.setColor(Color.yellow);

                        //System.out.println("MATTHEW");
                    }
                    g.fillOval((int) ((double) xpos - width / 81.92), (int) (ypos - (double) height / 45.88), (int) ((double) width / 40.96), (int) ((double) height / 22.94));
                    g.setColor(Color.black);
                }
                //g.drawRect((int) ((double)xpos-width/81.92), (int) (ypos-(double)height/45.88), (int) ((double)width/40.96), (int) ((double)height/22.94));
            }
        }

//        if(gameBoard.getIslandsClass().getSunkenTiles().size() == 24)
//        {
//        	JOptionPane.showInputDialog(null, "You lost because there is no tile.");
//        }
    }

    public void paintDice(Graphics g) {
        JPanel dice = new JPanel();
        int r1, r2;
        r1 = GameState.dice1;
        r2 = GameState.dice2;
        try {
            if (r1 == 1) {
                diceL = ImageIO.read(Wheat.class.getResource("/resource/dice/Dice1.PNG"));
            }
            else if(r1 == 2){
                diceL = ImageIO.read(Wheat.class.getResource("/resource/dice/Dice2.PNG"));
            }
            else if(r1 == 3){
                diceL = ImageIO.read(Wheat.class.getResource("/resource/dice/Dice3.PNG"));
            }
            else if(r1 == 4){
                diceL = ImageIO.read(Wheat.class.getResource("/resource/dice/Dice4.PNG"));
            }
            else if(r1 == 5){
                diceL = ImageIO.read(Wheat.class.getResource("/resource/dice/Dice2.PNG"));
            }
            else if (r1 == 6){
                diceL = ImageIO.read(Wheat.class.getResource("/resource/dice/Dice6.PNG"));
            }

            if (r2 == 1) {
                diceR = ImageIO.read(Wheat.class.getResource("/resource/dice/Dice1.PNG"));
            }
            else if(r2 == 2){
                diceR = ImageIO.read(Wheat.class.getResource("/resource/dice/Dice2.PNG"));
            }
            else if(r2 == 3){
                diceR = ImageIO.read(Wheat.class.getResource("/resource/dice/Dice3.PNG"));
            }
            else if(r2 == 4){
                diceR = ImageIO.read(Wheat.class.getResource("/resource/dice/Dice4.PNG"));
            }
            else if(r2 == 5){
                diceR = ImageIO.read(Wheat.class.getResource("/resource/dice/Dice5.PNG"));
            }
            else if(r2 == 6){
                diceR = ImageIO.read(Wheat.class.getResource("/resource/dice/Dice6.PNG"));
            }
        } catch (Exception E) {
       //     System.out.println("Exception");
            return;
        }


    }

    public boolean canFit(int x, int y, int centerx, int centery) {
        int sq = (int) ((double) width / 20);
        return (x > centerx - sq / 2 && x < centerx + sq / 2 && y < centery + sq / 2 && y > centery - sq / 2);
    }
    public boolean canFit2(int x, int y, int centerx, int centery) {
        int sq = (int) ((double) width / 20);
        return (x > centerx - sq / 2 && x < centerx + sq / 2 && y < centery + sq / 2 && y > centery - sq / 2);
    }

    public int[] doX(int x) {
        double wd = width / 200;
        //rbwy
        //int h=abc;
        double hd = height / 200;
        int arr[] = new int[6];
        int w = (int) ((double) width / wd);
        int h = (int) ((double) height / hd);
        int side = (int) ((double) w / Math.sqrt(3) / 2);
        int cw = width * 81 / 128 - w;
        int ch = height / 10;
        arr[0] = x;
        arr[1] = x + w / 2;
        arr[2] = arr[1];
        arr[3] = x;
        arr[4] = x - w / 2;
        arr[5] = arr[4];
        return arr;
    }
    public int[]doxv(int x[]){
        double wd = width / 200;
        int arr[]=new int[6];
        double hd = height / 200;

        int w = (int) ((double) width / wd);
        int h = (int) ((double) height / hd);
        int side = (int) ((double) w / Math.sqrt(3) / 2);
        int cw = width * 81 / 128 - w;
        int ch = height / 10;
        arr[0]=x[0]+(x[1]-x[0])/2;
        arr[1]=x[1];
        arr[2]=arr[0];
        arr[3]=x[0]-(x[1]-x[0])/2;
        arr[4]=x[4];
        arr[5]=x[0]-(x[1]-x[0])/2;



        return arr;
    }
    public int[]doyv(int x[]){
        double wd = width / 200;
        int arr[]=new int[6];
        double hd = height / 200;

        int w = (int) ((double) width / wd);
        int h = (int) ((double) height / hd);
        int side = (int) ((double) w / Math.sqrt(3) / 2);
        int cw = width * 81 / 128 - w;
        int ch = height / 10;
        arr[0]=x[0]+(x[1]-x[0])/2;
        arr[1]=x[0]+(x[3]-x[0])/2;
        // arr[2]=arr[1]+((x[3]-x[0]+x[2]+x[1])/2)/2;
        arr[2]=arr[1]+arr[1]-arr[0];
        arr[3]=arr[2];
        arr[4]=arr[1];
        arr[5]=arr[0];




        return arr;
    }
    public int[] doY(int y) {
        double wd = width / 200;
        //rbwy
        //int h=abc;
        double hd = height / 200;
        int arr[] = new int[6];
        int w = (int) ((double) width / wd);
        int h = (int) ((double) height / hd);
        int side = (int) ((double) w / Math.sqrt(3) / 2);
        int cw = width * 81 / 128 - w;
        int ch = height / 10;
        arr[0] = y - h / 2;
        arr[1] = (int) (y - side / 2 * 1.75);
        arr[2] = (int) (y + side / 2 * 1.75);
        arr[3] = y + h / 2;
        arr[4] = (int) (y + side / 2 * 1.75);
        arr[5] = (int) (y - side / 2 * 1.75);
        return arr;
    }







    public static BufferedImage rotate(BufferedImage bimg, Double angle) {
        double sin = Math.abs(Math.sin(Math.toRadians(angle))),
                cos = Math.abs(Math.cos(Math.toRadians(angle)));
        int w = bimg.getWidth();
        int h = bimg.getHeight();
        int neww = (int) Math.floor(w * cos + h * sin),
                newh = (int) Math.floor(h * cos + w * sin);
        BufferedImage rotated = new BufferedImage(neww, newh, bimg.getType());
        Graphics2D graphic = rotated.createGraphics();
        graphic.translate((neww - w) / 2, (newh - h) / 2);
        graphic.rotate(Math.toRadians(angle), w / 2, h / 2);
        graphic.drawRenderedImage(bimg, null);
        graphic.dispose();
        return rotated;
    }














    @SuppressWarnings("deprecation")
    public void actionPerformed(ActionEvent e) {
        //System.out.println("act:(");

        if(!first && ! second)
        {
                if(e.getSource()==development){
                    if(development.getSelectedItem().toString()=="2 resource") {

                        while (true) {
                            String str = (JOptionPane.showInputDialog("What is one resource you would like (ore, wood, wheat, clay, sheep"));
                            str = str.toLowerCase();
                            if (str.equals("sheep")) {
                                GameState.players.get(GameState.getCurrentPlayer()).addResourceCard(new Sheep());
                                break;
                            }
                            if (str.equals("ore")) {
                                GameState.players.get(GameState.getCurrentPlayer()).addResourceCard(new Ore()); break;
                            }
                            if (str.equals("wood")) {
                                GameState.players.get(GameState.getCurrentPlayer()).addResourceCard(new Wood()); break;
                            }
                            if (str.equals("wheat")) {
                                GameState.players.get(GameState.getCurrentPlayer()).addResourceCard(new Wheat()); break;
                            }
                            if (str.equals("clay")) {
                                GameState.players.get(GameState.getCurrentPlayer()).addResourceCard(new Clay()); break;
                            }
                            else{
                                infoBox("try again", "");
                            }
                        }
                        repaint();
                        while (true) {
                            String str = (JOptionPane.showInputDialog("What another resource you would like (ore, wood, wheat, clay, sheep"));
                            str = str.toLowerCase();
                            if (str.equals("sheep")) {
                                GameState.players.get(GameState.getCurrentPlayer()).addResourceCard(new Sheep());
                                break;
                            }
                            if (str.equals("ore")) {
                                GameState.players.get(GameState.getCurrentPlayer()).addResourceCard(new Ore()); break;
                            }
                            if (str.equals("wood")) {
                                GameState.players.get(GameState.getCurrentPlayer()).addResourceCard(new Wood()); break;
                            }
                            if (str.equals("wheat")) {
                                GameState.players.get(GameState.getCurrentPlayer()).addResourceCard(new Wheat()); break;
                            }
                            if (str.equals("clay")) {
                                GameState.players.get(GameState.getCurrentPlayer()).addResourceCard(new Clay()); break;
                            }
                            else{
                                infoBox("try again", "");
                            }
                        }
                        repaint();
                    }
                    if(development.getSelectedItem().toString()=="knight"){
                        boolean flag=false;
                        for(int i=0;i<4;i++){
                            if(i!=GameState.currentPlayer){
                                if(GameState.players.get(i).getResourceCards().size()!=0){
                                    flag=true;
                                }
                            }
                        }
                        if(flag) {
                            setBandit(true);
                            infoBox("Click the center of a tile to steal from", "");
                        }

                    }
                    if(development.getSelectedItem().toString()=="2 road"){
                        firstroad=true;
                        infoBox("Click 2 roads to build", "");
                    }
                }
            if (e.getSource() == build) {
                if (build.getSelectedItem().toString() == "Settlement") {
                    buildSettlement = true;
                }
                if (build.getSelectedItem().toString() == "Road") {
                    buildRoad = true;
                }
                if (build.getSelectedItem().toString() == "City") {
                    buildCity = true;
                }
                if(build.getSelectedItem().toString()=="Development Card"){
                    if( GameState.players.get(GameState.getCurrentPlayer()).obtainDevelopmentCard()){
                        repaint();
                    }
                    else{

                    }

                }
            }
            if (e.getSource() == nextTurn) {
                GameState.nextTurn();
                Player curr = GameState.players.get(GameState.getCurrentPlayer());

                if (curr.getColor() == "red") {
                    //g.drawRect(width-width/20,height-height/20,width/20, height/20);
                    color = Color.red;
                    //
                }
                if (curr.getColor() == "blue") {
                    //g.drawRect(width-width/20,height-height/20,width/20, height/20);
                    color = Color.blue;
                    //
                }
                if (curr.getColor() == "white") {
                    //g.drawRect(width-width/20,height-height/20,width/20, height/20);
                    color = Color.white;
                    //
                }
                if (curr.getColor() == "yellow") {
                    //g.drawRect(width-width/20,height-height/20,width/20, height/20);
                    color = Color.yellow;
                    //System.out.println("MATTHEW");
                }

                repaint();
            }

            if (e.getSource() == roll) {
                GameState.rollDice();

            }

            if (e.getSource() == trade) {
                if (trade.getSelectedItem().toString() == "Maritime") {
                    new TradePanel("Maritime", width, height);
                    trade.setSelectedIndex(0);
                }
                if (trade.getSelectedItem().toString() == "Domestic") {
                    p.change("domestic");
                }
            }
            if (e.getSource() == seeDeck) {
                if (seeDeck.getSelectedItem().toString() == "red") {
                    new DeckPanel("red", width, height);
                    seeDeck.setSelectedIndex(0);
                } else if (seeDeck.getSelectedItem().toString() == "blue") {
                    new DeckPanel("blue", width, height);
                    seeDeck.setSelectedIndex(0);
                } else if (seeDeck.getSelectedItem().toString() == "white") {
                    new DeckPanel("white", width, height);
                    seeDeck.setSelectedIndex(0);
                } else if (seeDeck.getSelectedItem().toString() == "yellow") {
                    new DeckPanel("yellow", width, height);
                    seeDeck.setSelectedIndex(0);

                }
            }
        }
    }
    public static void infoBox(String infoMessage, String titleBar)
    {
        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }
    public void mouseClicked(MouseEvent e) {
        //System.out.println("HERE0");
        boolean xor2=true;
        boolean xor3=true;
        if(first) {
                boolean xor=true;

            if (buildfirsts) {
                {
                    int count = 0;
                    for (int i = 0; i < 19; i++) {
                        for (int j = 0; j < 6; j++) {
                            Tile curr = GameState.tilesList[i];
                            // System.out.println("TILE "+i+" SPOT "+ j+": x "+curr.getXverticies()[j]+" y "+curr.getYverticies()[j]);
                            if (canFit(e.getX(), e.getY(), curr.getXverticies()[j], curr.getYverticies()[j])) {
                                curr.gethascityorsettlement()[j] = 1;
                                GameState.players.get(GameState.getCurrentPlayer()).getHasCity()[i][j] = 1;
                                if (!curr.getPlayersOnTile().contains(GameState.players.get(GameState.getCurrentPlayer())))
                                    curr.getPlayersOnTile().add(GameState.players.get(GameState.getCurrentPlayer()));
                                curr.getSettlementColor()[j] = GameState.players.get(GameState.getCurrentPlayer()).getColor();
                                count++;
                                buildfirsts = false;
                                buildfirstr = true;

                                //buildSettlement = false;
                            }
                        }
                    }
                    if (count != 0)
                        GameState.players.get(GameState.getCurrentPlayer()).setSettlements(GameState.players.get(GameState.getCurrentPlayer()).settlementNumber() - 1);
                    repaint();
                    xor=false;

                }
            }
            if (xor&&buildfirstr) {
                int count = 0;
                boolean flag = false;
                for (int i = 0; i < 19; i++) {
                    for (int j = 0; j < 6; j++) {
                        Tile curr = GameState.tilesList[i];
                        //System.out.println("TILE "+i+" SPOT "+ j+": x "+curr.getXverticies()[j]+" y "+curr.getYverticies()[j]);
                        if (canFit(e.getX(), e.getY(), curr.getxroad()[j], curr.getyroad()[j])) {
//                        //curr.gethascityorsettlement()[j] = 1;
                            Pair x = two(j);
                            if (curr.gethascityorsettlement()[x.first()] == 1 || curr.gethascityorsettlement()[x.first()] == 2 || curr.gethascityorsettlement()[x.second()] == 1 || curr.gethascityorsettlement()[x.second()] == 2) {
                                String c = GameState.players.get(GameState.getCurrentPlayer()).getColor();
//                              if(!curr.getSettlementColor()[x.first()].equals(null)&&curr.getSettlementColor()[x.first()].equals(c)||curr.getSettlementColor()[x.second()].equals(c))
//                                flag=true;
                                if ((curr.getSettlementColor()[x.first()]) == null && curr.getSettlementColor()[x.second()].equals(c)) {
                                    flag = true;
                                } else if (curr.getSettlementColor()[x.first()].equals(c) && curr.getSettlementColor()[x.second()] == (null)) {
                                    flag = true;
                                }
//                            else if (curr.getSettlementColor()[x.second()].equals(c) && curr.getSettlementColor()[x.second()]==(null)) {
//                                flag = true;
//                            }
//                            else if (curr.getSettlementColor()[x.second()]==(null) && curr.getSettlementColor()[x.second()].equals(c)) {
//                                flag = true;
//                            }

                            }


                            Pair y = three(j);
                            if (curr.getVertexRoads()[y.first()] || curr.getVertexRoads()[y.second()]) {
                                String c = GameState.players.get(GameState.getCurrentPlayer()).getColor();
                                if (curr.getVertexColor()[y.first()] == null && curr.getVertexColor()[y.second()] == null) {

                                } else if (curr.getVertexColor()[y.second()] == null) {
                                    if (curr.getVertexColor()[y.first()].equals(c)) {
                                        flag = true;
                                    }

                                } else if (curr.getVertexColor()[y.first()] == null) {

                                    if (curr.getVertexColor()[y.second()].equals(c))
                                        flag = true;
                                } else if (curr.getVertexColor()[y.first()].equals(c) && curr.getVertexColor()[y.first()].equals(c)) {
                                    flag = true;
                                } else {

                                }
                            }
                        }


//                        curr.getVertexRoads()[j] = true;
////                    GameState.players.get(GameState.getCurrentPlayer()).getHasCity()[i][j] = 1;
//                        repaint();
//                        buildRoad = false;
//                        System.out.println("TILE " + i + " SPOT " + j + ": x " + curr.getxroad()[j] + " y " + curr.getyroad()[j]);

                    }
                }

                for (int i = 0; i < 19; i++) {
                    for (int j = 0; j < 6; j++) {
                        Tile curr = GameState.tilesList[i];
                        //System.out.println("TILE "+i+" SPOT "+ j+": x "+curr.getXverticies()[j]+" y "+curr.getYverticies()[j]);
                        if (canFit(e.getX(), e.getY(), curr.getxroad()[j], curr.getyroad()[j]) && flag) {
                            //curr.gethascityorsettlement()[j] = 1;
                            curr.getVertexColor()[j] = GameState.players.get(GameState.getCurrentPlayer()).getColor();
                            //GameState.players.get(GameState.getCurrentPlayer()).setSettlements(GameState.players.get(GameState.getCurrentPlayer()).settlementNumber()-1);
                            curr.getVertexRoads()[j] = true;
//                    GameState.players.get(GameState.getCurrentPlayer()).getHasCity()[i][j] = 1;
                            count++;
                            //buildRoad = false;
                         //   System.out.println("TILE " + i + " SPOT " + j + ": x " + curr.getxroad()[j] + " y " + curr.getyroad()[j]);
                            buildfirstr = false;
                            buildfirsts = true;

                        }
                    }
                }
                if (count != 0) {
                    GameState.players.get(GameState.getCurrentPlayer()).setRoads(GameState.players.get(GameState.getCurrentPlayer()).roadNumber() - 1);
                    repaint();
                    GameState.nextTurn();
                    if (GameState.getCurrentPlayer() == 0) {
                        second = true;
                        first = false;
                        GameState.setCurrentPlayer(3);
                        buildfirsts=true;
                        buildfirstr=false;
                        repaint();
                        xor2=false;
                    }
                }

            }


        }
        if(second&&xor2){

            boolean xor=true;
            if (buildfirsts) {
                {
                    int count = 0;
                    int t1=-1;
                    int t2=-1;
                    int t3=-1;
                    for (int i = 0; i < 19; i++) {
                        for (int j = 0; j < 6; j++) {
                            Tile curr = GameState.tilesList[i];
                            // System.out.println("TILE "+i+" SPOT "+ j+": x "+curr.getXverticies()[j]+" y "+curr.getYverticies()[j]);
                            if (canFit(e.getX(), e.getY(), curr.getXverticies()[j], curr.getYverticies()[j])) {
                                curr.gethascityorsettlement()[j] = 1;
                                GameState.players.get(GameState.getCurrentPlayer()).getHasCity()[i][j] = 1;
                                if(t1==-1){
                                    t1=i;
                                }
                                else if(t2==-1){
                                    t2=i;
                                }
                                else if(t3==-1){
                                    t3=i;
                                }
                                if (!curr.getPlayersOnTile().contains(GameState.players.get(GameState.getCurrentPlayer())))
                                    curr.getPlayersOnTile().add(GameState.players.get(GameState.getCurrentPlayer()));
                                curr.getSettlementColor()[j] = GameState.players.get(GameState.getCurrentPlayer()).getColor();
                                count++;
                                buildfirsts = false;
                                buildfirstr = true;

                                //buildSettlement = false;
                            }
                        }
                    }
                    if (count != 0)
                        GameState.players.get(GameState.getCurrentPlayer()).setSettlements(GameState.players.get(GameState.getCurrentPlayer()).settlementNumber() - 1);
                    if(t1!=-1){
                        GameState.players.get(GameState.getCurrentPlayer()).getResourceCards().add(GameState.tilesList[t1].getType());
                    }if(t2!=-1){
                    GameState.players.get(GameState.getCurrentPlayer()).getResourceCards().add(GameState.tilesList[t2].getType());
                }
                    if(t3!=-1){
                        GameState.players.get(GameState.getCurrentPlayer()).getResourceCards().add(GameState.tilesList[t3].getType());
                    }
                    repaint();
                    xor=false;

                }
            }
            if (xor&&buildfirstr) {
                int count = 0;
                boolean flag = false;
                for (int i = 0; i < 19; i++) {
                    for (int j = 0; j < 6; j++) {
                        Tile curr = GameState.tilesList[i];
                        //System.out.println("TILE "+i+" SPOT "+ j+": x "+curr.getXverticies()[j]+" y "+curr.getYverticies()[j]);
                        if (canFit(e.getX(), e.getY(), curr.getxroad()[j], curr.getyroad()[j])) {
//                        //curr.gethascityorsettlement()[j] = 1;
                            Pair x = two(j);
                            if (curr.gethascityorsettlement()[x.first()] == 1 || curr.gethascityorsettlement()[x.first()] == 2 || curr.gethascityorsettlement()[x.second()] == 1 || curr.gethascityorsettlement()[x.second()] == 2) {
                                String c = GameState.players.get(GameState.getCurrentPlayer()).getColor();
//                              if(!curr.getSettlementColor()[x.first()].equals(null)&&curr.getSettlementColor()[x.first()].equals(c)||curr.getSettlementColor()[x.second()].equals(c))
//                                flag=true;
                                if ((curr.getSettlementColor()[x.first()]) == null && curr.getSettlementColor()[x.second()].equals(c)) {
                                    flag = true;
                                } else if (curr.getSettlementColor()[x.first()].equals(c) && curr.getSettlementColor()[x.second()] == (null)) {
                                    flag = true;
                                }
//                            else if (curr.getSettlementColor()[x.second()].equals(c) && curr.getSettlementColor()[x.second()]==(null)) {
//                                flag = true;
//                            }
//                            else if (curr.getSettlementColor()[x.second()]==(null) && curr.getSettlementColor()[x.second()].equals(c)) {
//                                flag = true;
//                            }

                            }


                            Pair y = three(j);
                            if (curr.getVertexRoads()[y.first()] || curr.getVertexRoads()[y.second()]) {
                                String c = GameState.players.get(GameState.getCurrentPlayer()).getColor();
                                if (curr.getVertexColor()[y.first()] == null && curr.getVertexColor()[y.second()] == null) {

                                } else if (curr.getVertexColor()[y.second()] == null) {
                                    if (curr.getVertexColor()[y.first()].equals(c)) {
                                        flag = true;
                                    }

                                } else if (curr.getVertexColor()[y.first()] == null) {

                                    if (curr.getVertexColor()[y.second()].equals(c))
                                        flag = true;
                                } else if (curr.getVertexColor()[y.first()].equals(c) && curr.getVertexColor()[y.first()].equals(c)) {
                                    flag = true;
                                } else {

                                }
                            }
                        }


//                        curr.getVertexRoads()[j] = true;
////                    GameState.players.get(GameState.getCurrentPlayer()).getHasCity()[i][j] = 1;
//                        repaint();
//                        buildRoad = false;
//                        System.out.println("TILE " + i + " SPOT " + j + ": x " + curr.getxroad()[j] + " y " + curr.getyroad()[j]);

                    }
                }

                for (int i = 0; i < 19; i++) {
                    for (int j = 0; j < 6; j++) {
                        Tile curr = GameState.tilesList[i];
                        //System.out.println("TILE "+i+" SPOT "+ j+": x "+curr.getXverticies()[j]+" y "+curr.getYverticies()[j]);
                        if (canFit(e.getX(), e.getY(), curr.getxroad()[j], curr.getyroad()[j]) && flag) {
                            //curr.gethascityorsettlement()[j] = 1;
                            curr.getVertexColor()[j] = GameState.players.get(GameState.getCurrentPlayer()).getColor();
                            //GameState.players.get(GameState.getCurrentPlayer()).setSettlements(GameState.players.get(GameState.getCurrentPlayer()).settlementNumber()-1);
                            curr.getVertexRoads()[j] = true;
//                    GameState.players.get(GameState.getCurrentPlayer()).getHasCity()[i][j] = 1;
                            count++;
                            //buildRoad = false;
                         //   System.out.println("TILE " + i + " SPOT " + j + ": x " + curr.getxroad()[j] + " y " + curr.getyroad()[j]);
                            buildfirstr = false;
                            buildfirsts = true;

                        }
                    }
                }
                if (count != 0) {
                    GameState.players.get(GameState.getCurrentPlayer()).setRoads(GameState.players.get(GameState.getCurrentPlayer()).roadNumber() - 1);
                    repaint();
                    GameState.nextTurn2();
                    if (GameState.getCurrentPlayer() == 3) {
                        second = false;
                        first = false;
                    }
                }

            }

        }

         if(!first&&!second)
        {
            if(firstroad){
               xor3=false;
                int count=0;
                boolean flag = false;
                for (int i = 0; i < 19; i++) {
                    for (int j = 0; j < 6; j++) {
                        Tile curr = GameState.tilesList[i];
                        //System.out.println("TILE "+i+" SPOT "+ j+": x "+curr.getXverticies()[j]+" y "+curr.getYverticies()[j]);
                        if (canFit(e.getX(), e.getY(), curr.getxroad()[j], curr.getyroad()[j])) {
//                        //curr.gethascityorsettlement()[j] = 1;
                            Pair x = two(j);
                            if (curr.gethascityorsettlement()[x.first()] == 1 || curr.gethascityorsettlement()[x.first()] == 2 || curr.gethascityorsettlement()[x.second()] == 1 || curr.gethascityorsettlement()[x.second()] == 2) {
                                String c = GameState.players.get(GameState.getCurrentPlayer()).getColor();
//                              if(!curr.getSettlementColor()[x.first()].equals(null)&&curr.getSettlementColor()[x.first()].equals(c)||curr.getSettlementColor()[x.second()].equals(c))
//                                flag=true;
                                if ((curr.getSettlementColor()[x.first()]) == null && curr.getSettlementColor()[x.second()].equals(c)) {
                                    flag = true;
                                } else if (curr.getSettlementColor()[x.first()].equals(c) && curr.getSettlementColor()[x.second()] == (null)) {
                                    flag = true;
                                }
//                            else if (curr.getSettlementColor()[x.second()].equals(c) && curr.getSettlementColor()[x.second()]==(null)) {
//                                flag = true;
//                            }
//                            else if (curr.getSettlementColor()[x.second()]==(null) && curr.getSettlementColor()[x.second()].equals(c)) {
//                                flag = true;
//                            }

                            }


                            Pair y = three(j);
                            if (curr.getVertexRoads()[y.first()] || curr.getVertexRoads()[y.second()]) {
                                String c = GameState.players.get(GameState.getCurrentPlayer()).getColor();
                                if (curr.getVertexColor()[y.first()] == null && curr.getVertexColor()[y.second()] == null) {

                                } else if (curr.getVertexColor()[y.second()] == null) {
                                    if (curr.getVertexColor()[y.first()].equals(c)) {
                                        flag = true;
                                    }

                                } else if (curr.getVertexColor()[y.first()] == null) {

                                    if (curr.getVertexColor()[y.second()].equals(c))
                                        flag = true;
                                } else if (curr.getVertexColor()[y.first()].equals(c) && curr.getVertexColor()[y.first()].equals(c)) {
                                    flag = true;
                                } else {

                                }
                            }
                        }


//                        curr.getVertexRoads()[j] = true;
////                    GameState.players.get(GameState.getCurrentPlayer()).getHasCity()[i][j] = 1;
//                        repaint();
//                        buildRoad = false;
//                        System.out.println("TILE " + i + " SPOT " + j + ": x " + curr.getxroad()[j] + " y " + curr.getyroad()[j]);

                    }
                }

                for (int i = 0; i < 19; i++) {
                    for (int j = 0; j < 6; j++) {
                        Tile curr = GameState.tilesList[i];
                        //System.out.println("TILE "+i+" SPOT "+ j+": x "+curr.getXverticies()[j]+" y "+curr.getYverticies()[j]);
                        if (canFit(e.getX(), e.getY(), curr.getxroad()[j], curr.getyroad()[j]) && flag) {
                            //curr.gethascityorsettlement()[j] = 1;
                            curr.getVertexColor()[j] = GameState.players.get(GameState.getCurrentPlayer()).getColor();
                            //GameState.players.get(GameState.getCurrentPlayer()).setSettlements(GameState.players.get(GameState.getCurrentPlayer()).settlementNumber()-1);
                            curr.getVertexRoads()[j] = true;
//                    GameState.players.get(GameState.getCurrentPlayer()).getHasCity()[i][j] = 1;

                            count++;
                            //buildRoad = false;
                            //     System.out.println("TILE " + i + " SPOT " + j + ": x " + curr.getxroad()[j] + " y " + curr.getyroad()[j]);
                        }
                    }
                }
                if(count==0){
                    infoBox("place a road in a valid spot", "");
                }
                if(count!=0)
                {GameState.players.get(GameState.getCurrentPlayer()).setRoads(GameState.players.get(GameState.getCurrentPlayer()).roadNumber()-1);
                    firstroad=false;
                    secondroad=true;
                    repaint();
                    infoBox("place a second road","");

                }





            }
            if(secondroad&&xor3){
                System.out.println("ADSHSADHHDAHAD");
                int count=0;
                boolean flag = false;
                for (int i = 0; i < 19; i++) {
                    for (int j = 0; j < 6; j++) {
                        Tile curr = GameState.tilesList[i];
                        //System.out.println("TILE "+i+" SPOT "+ j+": x "+curr.getXverticies()[j]+" y "+curr.getYverticies()[j]);
                        if (canFit(e.getX(), e.getY(), curr.getxroad()[j], curr.getyroad()[j])) {
//                        //curr.gethascityorsettlement()[j] = 1;
                            Pair x = two(j);
                            if (curr.gethascityorsettlement()[x.first()] == 1 || curr.gethascityorsettlement()[x.first()] == 2 || curr.gethascityorsettlement()[x.second()] == 1 || curr.gethascityorsettlement()[x.second()] == 2) {
                                String c = GameState.players.get(GameState.getCurrentPlayer()).getColor();
//                              if(!curr.getSettlementColor()[x.first()].equals(null)&&curr.getSettlementColor()[x.first()].equals(c)||curr.getSettlementColor()[x.second()].equals(c))
//                                flag=true;
                                if ((curr.getSettlementColor()[x.first()]) == null && curr.getSettlementColor()[x.second()].equals(c)) {
                                    flag = true;
                                } else if (curr.getSettlementColor()[x.first()].equals(c) && curr.getSettlementColor()[x.second()] == (null)) {
                                    flag = true;
                                }
//                            else if (curr.getSettlementColor()[x.second()].equals(c) && curr.getSettlementColor()[x.second()]==(null)) {
//                                flag = true;
//                            }
//                            else if (curr.getSettlementColor()[x.second()]==(null) && curr.getSettlementColor()[x.second()].equals(c)) {
//                                flag = true;
//                            }

                            }


                            Pair y = three(j);
                            if (curr.getVertexRoads()[y.first()] || curr.getVertexRoads()[y.second()]) {
                                String c = GameState.players.get(GameState.getCurrentPlayer()).getColor();
                                if (curr.getVertexColor()[y.first()] == null && curr.getVertexColor()[y.second()] == null) {

                                } else if (curr.getVertexColor()[y.second()] == null) {
                                    if (curr.getVertexColor()[y.first()].equals(c)) {
                                        flag = true;
                                    }

                                } else if (curr.getVertexColor()[y.first()] == null) {

                                    if (curr.getVertexColor()[y.second()].equals(c))
                                        flag = true;
                                } else if (curr.getVertexColor()[y.first()].equals(c) && curr.getVertexColor()[y.first()].equals(c)) {
                                    flag = true;
                                } else {

                                }
                            }
                        }


//                        curr.getVertexRoads()[j] = true;
////                    GameState.players.get(GameState.getCurrentPlayer()).getHasCity()[i][j] = 1;
//                        repaint();
//                        buildRoad = false;
//                        System.out.println("TILE " + i + " SPOT " + j + ": x " + curr.getxroad()[j] + " y " + curr.getyroad()[j]);

                    }
                }

                for (int i = 0; i < 19; i++) {
                    for (int j = 0; j < 6; j++) {
                        Tile curr = GameState.tilesList[i];
                        //System.out.println("TILE "+i+" SPOT "+ j+": x "+curr.getXverticies()[j]+" y "+curr.getYverticies()[j]);
                        if (canFit(e.getX(), e.getY(), curr.getxroad()[j], curr.getyroad()[j]) && flag) {
                            //curr.gethascityorsettlement()[j] = 1;
                            curr.getVertexColor()[j] = GameState.players.get(GameState.getCurrentPlayer()).getColor();
                            //GameState.players.get(GameState.getCurrentPlayer()).setSettlements(GameState.players.get(GameState.getCurrentPlayer()).settlementNumber()-1);
                            curr.getVertexRoads()[j] = true;
//                    GameState.players.get(GameState.getCurrentPlayer()).getHasCity()[i][j] = 1;
                            firstroad=false;
                            secondroad=false;
                            count++;
                            //buildRoad = false;
                            //     System.out.println("TILE " + i + " SPOT " + j + ": x " + curr.getxroad()[j] + " y " + curr.getyroad()[j]);
                        }
                    }
                }
                if(count==0){
                    infoBox("place a road in a valid spot", "");
                }
                if(count!=0)
                {GameState.players.get(GameState.getCurrentPlayer()).setRoads(GameState.players.get(GameState.getCurrentPlayer()).roadNumber()-1);
                    //infoBox("place a second road","");
                }
                repaint();
            }
            if (bandit) {
                int flag2 = 0;
                for (Player m : GameState.players) {
                    if (m.getResourceCards().isEmpty()) {
                        flag2++;
                    }
                }
                if (flag2 == 4) {
                    bandit = false;

                }
                if (flag2 != 4)
                    for (int i = 0; i < 19; i++) {
                        Tile curr = GameState.tilesList[i];
                        // System.out.println("TILE "+i+" SPOT "+ j+": x "+curr.getXverticies()[j]+" y "+curr.getYverticies()[j]);
                        if (canFit2(e.getX(), e.getY(), curr.getXpos(), curr.getYpos())) {

                            int count = 0;
                            boolean flag = false;
                            for (Player m : curr.getPlayersOnTile()) {
                                if (!m.getResourceCards().isEmpty())
                                    flag = true;
                            }
                            if (!flag) {
                                infoBox("Pick another tile", "");
                                break;
                            }
                            if (curr.getPlayersOnTile().isEmpty() || (curr.getPlayersOnTile().size() == 1 && curr.getPlayersOnTile().get(0).getColor().equals(GameState.players.get(GameState.getCurrentPlayer()).getColor()))) {
                                infoBox("Pick another tile", "");
                                break;
                            }
                            if (curr.getHasBandit()) {
                                infoBox("Pick another tile", "");
                                break;
                            }
                            String str = (JOptionPane.showInputDialog("Enter the color of the player who you would like to steal from"));
                            str = str.toLowerCase();
                            System.out.println(str);
                            System.out.println(i+" TILE");
                            for (int j = 0; j < curr.getPlayersOnTile().size(); j++) {
                                Player p = curr.getPlayersOnTile().get(j);
                                System.out.println(p.getColor()+" "+j);

                                if (p.getColor().equals(str) && !GameState.players.get(GameState.getCurrentPlayer()).getColor().equals(str)) {
                                    System.out.println(true);
                                    int ash=0;
                                    for(int k=0;k<4;k++){
                                        if(GameState.players.get(k).getColor().equals(p.getColor())){
                                            ash=k;
                                        }
                                    }
                                    count++;
                                    int c = p.getResourceCards().size();
                                    int random = (int) (Math.random() * c + 0);
                                    for (int k = 0; k < 19; k++) {
                                        Tile curr2 = GameState.tilesList[k];
                                        if (curr2.getHasBandit()) {
                                            curr2.setBandit(false);
                                        }

                                    }

                                    curr.setBandit(true);

                                    GameState.players.get(GameState.getCurrentPlayer()).steal(ash, random);
                                    repaint();
                                    bandit = false;
                                }

                            }


                        }
                    }


            }

        {
        if (buildSettlement){
            int count=0;
            for (int i = 0; i < 19; i++) {
                for (int j = 0; j < 6; j++) {
                    Tile curr = GameState.tilesList[i];
                    // System.out.println("TILE "+i+" SPOT "+ j+": x "+curr.getXverticies()[j]+" y "+curr.getYverticies()[j]);
                    if (canFit(e.getX(), e.getY(), curr.getXverticies()[j], curr.getYverticies()[j])) {
                        curr.gethascityorsettlement()[j] = 1;
                        GameState.players.get(GameState.getCurrentPlayer()).getHasCity()[i][j] = 1;
                        if(!curr.getPlayersOnTile().contains(GameState.players.get(GameState.getCurrentPlayer())))
                        curr.getPlayersOnTile().add(GameState.players.get(GameState.getCurrentPlayer()));
                        curr.getSettlementColor()[j] = GameState.players.get(GameState.getCurrentPlayer()).getColor();
                        count++;


                        buildSettlement = false;
                    }
                }
            }
            if(count!=0)
                GameState.players.get(GameState.getCurrentPlayer()).setSettlements(GameState.players.get(GameState.getCurrentPlayer()).settlementNumber()-1);
            repaint();
        }
        buildSettlement = false;
        if(buildCity&&GameState.players.get(GameState.getCurrentPlayer()).buildInfrastructure("city",0, 0)){
            int count=0;
            for (int i = 0; i < 19; i++) {
                for (int j = 0; j < 6; j++) {
                    Tile curr = GameState.tilesList[i];
                    // System.out.println("TILE "+i+" SPOT "+ j+": x "+curr.getXverticies()[j]+" y "+curr.getYverticies()[j]);
                    if (canFit(e.getX(), e.getY(), curr.getXverticies()[j], curr.getYverticies()[j])) {
                        if(curr.gethascityorsettlement()[j] ==1){
                        curr.gethascityorsettlement()[j] = 2;
                        GameState.players.get(GameState.getCurrentPlayer()).getHasCity()[i][j] = 2;
                        //curr.getPlayersOnTile().add(GameState.players.get(GameState.getCurrentPlayer()));
                        //curr.getSettlementColor()[j] = GameState.players.get(GameState.getCurrentPlayer()).getColor();
                        count++;


                        buildCity = false;
                    }
                }
                }
            }
            if(count!=0){
                GameState.players.get(GameState.getCurrentPlayer()).setCities(GameState.players.get(GameState.getCurrentPlayer()).cityNumber()-1);
                GameState.players.get(GameState.getCurrentPlayer()).setSettlements(GameState.players.get(GameState.getCurrentPlayer()).settlementNumber()+1);
            }
            repaint();
        }
        buildCity=false;
        if (buildRoad&& GameState.players.get(GameState.getCurrentPlayer()).buildInfrastructure("road",0, 0)) {
            int count=0;
            boolean flag = false;
            for (int i = 0; i < 19; i++) {
                for (int j = 0; j < 6; j++) {
                    Tile curr = GameState.tilesList[i];
                    //System.out.println("TILE "+i+" SPOT "+ j+": x "+curr.getXverticies()[j]+" y "+curr.getYverticies()[j]);
                    if (canFit(e.getX(), e.getY(), curr.getxroad()[j], curr.getyroad()[j])) {
//                        //curr.gethascityorsettlement()[j] = 1;
                        Pair x = two(j);
                        if (curr.gethascityorsettlement()[x.first()] == 1 || curr.gethascityorsettlement()[x.first()] == 2 || curr.gethascityorsettlement()[x.second()] == 1 || curr.gethascityorsettlement()[x.second()] == 2) {
                            String c = GameState.players.get(GameState.getCurrentPlayer()).getColor();
//                              if(!curr.getSettlementColor()[x.first()].equals(null)&&curr.getSettlementColor()[x.first()].equals(c)||curr.getSettlementColor()[x.second()].equals(c))
//                                flag=true;
                            if ((curr.getSettlementColor()[x.first()]) == null && curr.getSettlementColor()[x.second()].equals(c)) {
                                flag = true;
                            } else if (curr.getSettlementColor()[x.first()].equals(c) && curr.getSettlementColor()[x.second()] == (null)) {
                                flag = true;
                            }
//                            else if (curr.getSettlementColor()[x.second()].equals(c) && curr.getSettlementColor()[x.second()]==(null)) {
//                                flag = true;
//                            }
//                            else if (curr.getSettlementColor()[x.second()]==(null) && curr.getSettlementColor()[x.second()].equals(c)) {
//                                flag = true;
//                            }

                        }


                        Pair y = three(j);
                        if (curr.getVertexRoads()[y.first()] || curr.getVertexRoads()[y.second()]) {
                            String c = GameState.players.get(GameState.getCurrentPlayer()).getColor();
                            if (curr.getVertexColor()[y.first()] == null && curr.getVertexColor()[y.second()] == null) {

                            } else if (curr.getVertexColor()[y.second()] == null) {
                                if (curr.getVertexColor()[y.first()].equals(c)) {
                                    flag = true;
                                }

                            } else if (curr.getVertexColor()[y.first()] == null) {

                                if (curr.getVertexColor()[y.second()].equals(c))
                                    flag = true;
                            } else if (curr.getVertexColor()[y.first()].equals(c) && curr.getVertexColor()[y.first()].equals(c)) {
                                flag = true;
                            } else {

                            }
                        }
                    }


//                        curr.getVertexRoads()[j] = true;
////                    GameState.players.get(GameState.getCurrentPlayer()).getHasCity()[i][j] = 1;
//                        repaint();
//                        buildRoad = false;
//                        System.out.println("TILE " + i + " SPOT " + j + ": x " + curr.getxroad()[j] + " y " + curr.getyroad()[j]);

                }
            }

            for (int i = 0; i < 19; i++) {
                for (int j = 0; j < 6; j++) {
                    Tile curr = GameState.tilesList[i];
                    //System.out.println("TILE "+i+" SPOT "+ j+": x "+curr.getXverticies()[j]+" y "+curr.getYverticies()[j]);
                    if (canFit(e.getX(), e.getY(), curr.getxroad()[j], curr.getyroad()[j]) && flag) {
                        //curr.gethascityorsettlement()[j] = 1;
                        curr.getVertexColor()[j] = GameState.players.get(GameState.getCurrentPlayer()).getColor();
                        //GameState.players.get(GameState.getCurrentPlayer()).setSettlements(GameState.players.get(GameState.getCurrentPlayer()).settlementNumber()-1);
                        curr.getVertexRoads()[j] = true;
//                    GameState.players.get(GameState.getCurrentPlayer()).getHasCity()[i][j] = 1;
                        count++;
                        buildRoad = false;
                   //     System.out.println("TILE " + i + " SPOT " + j + ": x " + curr.getxroad()[j] + " y " + curr.getyroad()[j]);
                    }
                }
            }
            if(count!=0)
                GameState.players.get(GameState.getCurrentPlayer()).setRoads(GameState.players.get(GameState.getCurrentPlayer()).roadNumber()-1);
            repaint();
        }
        buildRoad = false;
        }
        }
    }
    //1090 483





    public Pair three(int x){
        if(x==0){
            return new Pair(1,5);
        }
        if(x==5){
            return new Pair(0,4);
        }
        else
            return new Pair(x-1,x+1);
    }
    public Pair two (int x){
        Pair p;
        if(x!=5){
            return new Pair(x, x+1);
        }
        else{
            return new Pair(x,0);
        }
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
