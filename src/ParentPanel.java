/*
 * 3
 */

import java.awt.*;
import java.io.IOException;

import javax.swing.*;
import java.util.Random;

public class ParentPanel extends JPanel
{
    private int seed, numberOfPlayers, width, height, waterLevel;
    private Random rand;
    private GUIGameBoard guiGameBoard;
    private Menu menu;
    private CardLayout card;
    private GameBoard gameBoard;
    private GUIHelp guiHelp;
    private String currentPanel;
    private String[] waterLevelChoices;
    private String initialWaterLevel;
    private GUIWindow f;
    private GameState GameState;
    private Trading domestic;
    public static void infoBox(String infoMessage, String titleBar)
    {
        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }
    public ParentPanel(int w, int h, GUIWindow f)
    {
        this.f = f;
        width = w;
        height = h;
        waterLevelChoices = new String[]{"novice", "normal", "elite", "legendary"};

        /*
         * initiate Card Layout
         */
        card = new CardLayout();
        setLayout(card);

        /*
         * call Menu class
         */
        menu = new Menu(this);
        menu.setVisible(true);
        add(menu, "MENU");
        card.show(this, "MENU");

        /*
         * add GUIHelp class
         */
        guiHelp = new GUIHelp(this);
        guiHelp.setVisible(false);
        add(guiHelp, "rule");
        domestic = new Trading(this);
        domestic.setVisible(false);
        add(domestic, "domestic");

    }

    public void change(String s)
    {
        currentPanel = s;
        switch(currentPanel)
        {
            case "trade":
                card.show(this, "trade");
            case "deck4":
                card.show(this,"deck4");
                break;
            case "deck3":
                card.show(this,"deck3");
                break;
            case "deck2":
                card.show(this,"deck2");
                break;
            case "deck1":
                card.show(this,"deck1");
                break;
            case "maritime":
                card.show(this, "maritime");
                break;
            case "domestic":
                card.show(this, "domestic");
                break;
            case "tradechoose":
                card.show(this, "tradechoose");
                break;
            case "play":
                card.show(this, "play");
                break;
            case "MENU":
                card.show(this, "MENU");
                break;
            case "rule":
                card.show(this, "rule");
                break;
        }
    }

    public String getCurrentPanel()
    {
        return currentPanel;
    }

    public void generate() throws IOException
    {
    	/*JOptionPane.showMessageDialog(null, "NOTICE:\nIf input is not a number, input box will close, please press start again to play");
        seed = Integer.parseInt(JOptionPane.showInputDialog("Enter game number (please enter a number"));
        numberOfPlayers = Integer.parseInt(JOptionPane.showInputDialog("Enter number of players"));
        while(numberOfPlayers > 4 || numberOfPlayers < 2) {
            JOptionPane.showMessageDialog(null, "The number of players cannot be greater than 4 or smaller than 2");
            numberOfPlayers = Integer.parseInt(JOptionPane.showInputDialog("Enter number of players"));
        }
        initialWaterLevel = (String) JOptionPane.showInputDialog(null, "Select Water Meter", "Water Meter", JOptionPane.QUESTION_MESSAGE, null, waterLevelChoices, waterLevelChoices[1]);
        */

        //seed = helper("Game Number", true);
        //numberOfPlayers = helper("Number of Players", false);


        //initialWaterLevel = (String)JOptionPane.showInputDialog(null, "Select Water Meter", "Water Meter", JOptionPane.QUESTION_MESSAGE, null, waterLevelChoices, waterLevelChoices[1]);

        /*
         * call GameBoard class
         */
        gameBoard = new GameBoard(this);
        //gameBoard.setWaterLevel();
        /*
         * add GUIGameBoard class
         */
        numberOfPlayers=4;
        GameState=new GameState(numberOfPlayers, this);
        guiGameBoard = new GUIGameBoard(this);
        guiGameBoard.setVisible(false);
        add(guiGameBoard, "play");


        rand = new Random(seed);

    }

    public void generate2() throws IOException {
        seed = (int) (Math.random()*50) +1;
        numberOfPlayers = (int) (Math.random()*3) +1;
        int r = (int) (Math.random()*3) +1;
        initialWaterLevel = waterLevelChoices[r];

        gameBoard = new GameBoard(this);
        //gameBoard.setWaterLevel();
        /*
         * add GUIGameBoard class
         */
        guiGameBoard = new GUIGameBoard(this);
        guiGameBoard.setVisible(false);
        add(guiGameBoard, "play");
        rand = new Random(seed);
    }

    /*
     * ask user input
     * check validity
     * return user input to ParentPanel.generate()
     */
    public GameState getGameState(){
        return GameState;
    }
    private int helper(String s, boolean b)
    {
        int temp = 0;

        while (true) {
            String weight = JOptionPane.showInputDialog(null, "Enter " + s, s, JOptionPane.PLAIN_MESSAGE);
            if (weight == null) {
                break;
            }
            try {
                temp = Integer.parseInt(weight);
                if(!b && (temp > 4 || temp <2))
                    JOptionPane.showMessageDialog(null, "The number of players cannot be greater than 4 or smaller than 2", "error", JOptionPane.ERROR_MESSAGE);
                else
                    b = true;
                if(b)
                    break;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter a valid integer", "error", JOptionPane.ERROR_MESSAGE);
            }
        }
        return temp;
    }

    public GameBoard getGameBoard()
    {
        return gameBoard;
    }

    public int getPlayerNumber()
    {
        return numberOfPlayers;
    }

    public String getInitialWaterLevel()
    {
        return initialWaterLevel;
    }

    public int getSeed()
    {
        return seed;
    }

    public int getWidth()
    {
        return width;
    }

    public int getHeight()
    {
        return height;
    }

    public GUIGameBoard getGUIGameBoard()
    {
        return guiGameBoard;
    }

    public JDialog displayMessage()
    {
        return new JDialog(f, "dialog Box");
    }
}
