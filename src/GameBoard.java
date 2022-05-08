import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;

import javax.imageio.ImageIO;
import javax.swing.*;

public class GameBoard {
	/*
	 * player
	 */
	public static int numberPlayers;
	public static ArrayList<Player1> player1s;
	public static String[] playerColors, playerNames, roles;
	public static Queue<Player1> player1Order = new LinkedList<Player1>();
	public static BufferedImage Pown_Diver, Pown_Engineer, Pown_Explorer, Pown_Messenger, Pown_Navigator, Pown_Pilot,
			Pown_Diver_move, Pown_Engineer_move, Pown_Explorer_move, Pown_Messenger_move, Pown_Navigator_move, Pown_Pilot_move;
	public static BufferedImage[] powns, powns_move;
	//public static HashMap<String, Pair> move;
	//public static int currentPlayer;
	/*
	 * treasure deck
	 */
	public static TreasureDeck treasureDeck;
	public static String[] treasureNames, treasureCardNames;
	public static ArrayList<TreasureCard> player1Hand, player2Hand, player3Hand, player4Hand;
	//public static String[] treasurecolors = {"black", "red", "yellow", "blue"};
	//public static HashMap<String, Boolean> Treasure = new HashMap<String, Boolean>();
	/*
	 * flood deck
	 */
	public static FloodDeck floodDeck;
	public static ArrayList<FloodCard> usedFloodCards;
	/*
	 * islands
	 */
	public static Islands islands;
	public static ArrayList<Tile1> allTile1s;
	//public static ArrayList<ArrayList<Tile>> allTiles_2D;
	/*
	 * water meter
	 */
	public static WaterMeter waterMeter;
	public static int waterLevel;
	/*
	 * other
	 */
	public static ParentPanel p;
	private Random u;
	public static int[] dx={1,0,-1,0};
	public static int[] dy={0,1,0,-1};
	public static GUIGameBoard guiGameBoard;

	public GameBoard(ParentPanel p) throws IOException
	{
		/*
		 * setPlayerInformation: name, color, role, BufferedImage
		 */
		//setPlayerInformation();
		try
		{
			for(int i = 0; i < powns.length; i++)
			{
				powns[i] = ImageIO.read(GUIGameBoard.class.getResource("/Players/Pown_" + playerNames[i] + ".png"));
				//System.out.println("HI");
			}
			for(int i = 0; i < powns.length; i++)
			{
				powns_move[i] = ImageIO.read(GUIGameBoard.class.getResource("/Players/Pown_" + playerNames[i] + "_move.png"));
				//System.out.println("Bye");
			}
		}
		catch(Exception E)
		{
			System.out.println("GameBoard Exception");
			return;
		}

		setTreasureNames();
		setTreasureCardNames();
		this.p = p;
		//numberPlayers = p.getPlayerNumber();
		u = new Random(p.getSeed());
		//setWaterLevel();
		guiGameBoard = p.getGUIGameBoard();
		//waterMeter = new WaterMeter(this, waterLevel);
		//treasureDeck = new TreasureDeck(this, u);
		islands = new Islands(u);
		allTile1s = islands.getAllTiles();
		//floodDeck = new FloodDeck(this, u);

		//Treasure.put("blue", false);
		//Treasure.put("red", false);
		//Treasure.put("black", false);
		//Treasure.put("yellow", false);
		//currentPlayer = 0;

		//doing water level

		//
		initializePlayers(numberPlayers);

		draw2InitialTreasureCards();
		// move = new HashMap<String, Pair>();
		//move.put("Right", new Pair(1, 0));
		//move.put("Left", new Pair(-1, 0));
		//move.put("Down", new Pair(0, 1));
		//move.put("Up", new Pair(0, -1));
		//move.put("right", new Pair(1, 0));
		//move.put("left", new Pair(-1, 0));
		//move.put("down", new Pair(0, 1));
		// move.put("up", new Pair(0, -1));
        /*
        while (!won()) {
            //while (players.get(currentPlayer).canGo()) {

            }

            currentPlayer = (currentPlayer + 1) % numplayers;
        }
		*/
	}

	public void changeToNextPlayer()
	{
		Player1 p = player1Order.remove();
		p.setBackToOriginal();
		player1Order.add(p);

	}

	public void initializePlayers(int numberPlayers)
	{
		player1s = new ArrayList<Player1>();
		ArrayList<Integer> current = new ArrayList<Integer>();
		for (int i = 0; i < numberPlayers; i++)
		{
			int orderNumber = (int) (u.nextInt(6));
			while (current.contains(orderNumber)) {
				orderNumber = (int) (u.nextInt(6));
			}
			current.add(orderNumber);
		}
		for (Integer i : current)
		{
			String role = roles[i];
			int xPos = getPlayerInitialXPos(role);//row
			int yPos = getPlayerInitialYPos(role);//column
			if(role.equals("Diver"))
			{
				Player1 pp = new Diver(this, i, playerColors[i], role, treasureDeck, powns[i], powns_move[i], xPos, yPos);
				player1Order.add(pp);
				player1s.add(pp);
			}
			if(role.equals("Engineer"))
			{
				Player1 pp = new Engineer(this, i, playerColors[i], role, treasureDeck, powns[i], powns_move[i], xPos, yPos);
				player1Order.add(pp);
				player1s.add(pp);
			}
			if(role.equals("Explorer"))
			{
				Player1 pp = new Explorer(this, i, playerColors[i], role, treasureDeck, powns[i], powns_move[i], xPos, yPos);
				player1Order.add(pp);
				player1s.add(pp);
			}
			if(role.equals("Messenger"))
			{
				Player1 pp = new Messenger(this, i, playerColors[i], role, treasureDeck, powns[i], powns_move[i], xPos, yPos);
				player1Order.add(pp);
				player1s.add(pp);
			}
			if(role.equals("Navigator"))
			{
				Player1 pp = new Navigator(this, i, playerColors[i], role, treasureDeck, powns[i], powns_move[i], xPos, yPos);
				player1Order.add(pp);
				player1s.add(pp);
			}
			if(role.equals("Pilot"))
			{
				Player1 pp = new Pilot(this, i, playerColors[i], role, treasureDeck, powns[i], powns_move[i], xPos, yPos);
				player1Order.add(pp);
				player1s.add(pp);
			}
		}
	}

	public void draw2InitialTreasureCards()
	{
		for(int i = 0; i < player1s.size(); i++)
		{
			player1s.get(i).drawTwoInitialCards();
		}
	}
/*
	public void setWaterLevel()
	{
		String wl ="";
		wl= p.getInitialWaterLevel();
		switch(wl)
		{
			case "novice":
				waterLevel = 0;
				break;
			case "normal":
				waterLevel = 1;
				break;
			case "elite":
				waterLevel = 2;
				break;
			case "legendary":
				waterLevel = 3;
				break;
		}
	}

 */
/*
	public void setPlayerInformation()
	{
		playerNames = new String[]{"Diver", "Engineer", "Explorer", "Messenger", "Navigator", "Pilot"};
		playerColors = new String[]{"black", "red", "green", "white", "yellow", "blue"};
		roles = new String[]{"Diver", "Engineer", "Explorer", "Messenger", "Navigator", "Pilot"};
		powns = new BufferedImage[] {Pown_Diver, Pown_Engineer, Pown_Explorer, Pown_Messenger, Pown_Navigator, Pown_Pilot};
		powns_move = new BufferedImage[] {Pown_Diver_move, Pown_Engineer_move, Pown_Explorer_move, Pown_Messenger_move, Pown_Navigator_move, Pown_Pilot_move};
	}
 */

	public int getPlayerInitialXPos(String role)
	{
		for(Tile1 t : allTile1s)
		{
			if(t.getRelatedPlayer().equals(role))
			{
				return t.getXPos();
			}
		}
		return 0;
	}

	public int getPlayerInitialYPos(String role)
	{
		for(Tile1 t : allTile1s)
		{
			if(t.getRelatedPlayer().equals(role))
			{
				return t.getYPos();
			}
		}
		return 0;
	}

	public ArrayList<Tile1> getFloodedTiles()
	{
		return islands.getFloodedTiles();
	}

	public void setTreasureNames()
	{
		treasureNames = new String[]{"OceansChalice", "CrystalOfFire", "StatueOfTheWind", "EarthStone"};
	}

	public  TreasureDeck getTreasureDeck() {
		return treasureDeck;
	}

	public void setTreasureCardNames()
	{
		treasureCardNames = new String[]{"Card_CrystalOfFire", "Card_EarthStone", "Card_OceansChalice", "Card_StatueOfTheWind", "Card_WatersRise", "Card_Helicopter", "Card_SandBag"};
	}
	public int getCurrentPlayerIndex(){
		Player1 cp=this.getCurrentPlayer();
		int current=0;
		for (int i = 0; i < player1s.size(); i++) {
			if (cp.getRole() == player1s.get(i).getRole()) {
				current = i;
			}
		}
		return current;
	}
	public Player1 getCurrentPlayer()
	{
		//System.out.println("the first player"+playerOrder.peek().getRole());
		return player1Order.peek();
	}
	public ArrayList<Tile1> getShorableTiles()
	{
		Player1 currentPlayer1 = getCurrentPlayer();
		return currentPlayer1.getShorableTiles();
	}
	public ArrayList<Tile1> getMovableTiles()
	{
		Player1 currentPlayer1 = getCurrentPlayer();
		return currentPlayer1.getMovableTiles();
	}
//	public ArrayList<Tile1> getMovableTile2s()
//	{
//		//Player1 currentPlayer1 = p.getGUIGameBoard().getmove2();
//		//return currentPlayer1.getMovableTiles();
//	}
	public Stack<TreasureCard> getDiscardTreasureCards()
	{
		return treasureDeck.getDiscardTreasureCards();
	}


	public ArrayList<TreasureCard> getPlayer1Hand()
	{

		int numberOfCards = player1s.get(0).getHand().size();
		player1Hand = new ArrayList<TreasureCard>();
		for(int j = 0; j < numberOfCards; j++)
		{
			player1Hand.add(player1s.get(0).getHand().get(j));
		}
		//BUG capture treasures even not on treasure tile
		checkCaptureTreasures(player1Hand, player1s.get(0));
		player1Hand = checkHands(player1Hand);
		return player1Hand;
	}

	public ArrayList<TreasureCard> getPlayer2Hand()
	{
		int numberOfCards = player1s.get(1).getHand().size();
		player2Hand = new ArrayList<TreasureCard>();
		for(int j = 0; j < numberOfCards; j++)
		{
			player2Hand.add(player1s.get(1).getHand().get(j));
		}
		checkCaptureTreasures(player2Hand, player1s.get(1));
		player2Hand = checkHands(player2Hand);
		return player2Hand;
	}

	public ArrayList<TreasureCard> getPlayer3Hand()
	{
		int numberOfCards = player1s.get(2).getHand().size();
		player3Hand = new ArrayList<TreasureCard>();
		for(int j = 0; j < numberOfCards; j++)
		{
			player3Hand.add(player1s.get(2).getHand().get(j));
		}
		checkCaptureTreasures(player3Hand, player1s.get(2));
		player3Hand = checkHands(player3Hand);
		return player3Hand;
	}

	public ArrayList<TreasureCard> getPlayer4Hand()
	{
		int numberOfCards = player1s.get(3).getHand().size();
		player4Hand = new ArrayList<TreasureCard>();
		for(int j = 0; j < numberOfCards; j++)
		{
			player4Hand.add(player1s.get(3).getHand().get(j));
		}
		checkCaptureTreasures(player4Hand, player1s.get(3));
		player4Hand = checkHands(player4Hand);
		return player4Hand;
	}

	public void discardSandbag()
	{
		discardTreasureCard("Sandbag");
	}

	public void discardHelicopterLift()
	{
		discardTreasureCard("Helicopter");
	}

	public void discardTreasureCard(String str)
	{
		for(TreasureCard t : getPlayer1Hand())
		{
			if(t.getName().equals(str))
			{
				player1s.get(0).getHand().remove(t);
				treasureDeck.getDiscardTreasureCards().add(t);
				break;
			}
		}
		for(TreasureCard t : getPlayer2Hand())
		{
			if(t.getName().equals(str))
			{
				player1s.get(1).getHand().remove(t);
				treasureDeck.getDiscardTreasureCards().add(t);
				break;
			}
		}
		if(numberPlayers > 2)
		{
			for(TreasureCard t : getPlayer3Hand())
			{
				if(t.getName().equals(str))
				{
					player1s.get(2).getHand().remove(t);
					treasureDeck.getDiscardTreasureCards().add(t);
					break;
				}
			}
			if(numberPlayers > 3)
			{
				for(TreasureCard t : getPlayer4Hand())
				{
					if(t.getName().equals(str))
					{
						player1s.get(3).getHand().remove(t);
						treasureDeck.getDiscardTreasureCards().add(t);
						break;
					}
				}
			}
		}

	}

	public void discardTreasureCard(Player1 player1, String str)
	{
		for(TreasureCard t : player1.getHand())
		{
			if(t.getName().equals(str))
			{
				player1.getHand().remove(t);
				treasureDeck.getDiscardTreasureCards().add(t);
			}
		}
	}

	public void checkFoolsLandingSunk()
	{
		for(Tile1 t: islands.getSunkenTiles())
		{
			if(t.getName().equals("FoolsLanding"))
			{
				JDialog d = this.p.displayMessage();
				d.setLocationRelativeTo(null);
				JLabel l = new JLabel("Game Lost: Fool's Landing sank", SwingConstants.CENTER);
				d.add(l);
				// setsize of dialog
				d.setSize(400, 100);
				// set visibility of dialog
				d.setVisible(true);
				p.change("MENU");
			}
		}
	}



	public void checkCaptureTreasures(ArrayList<TreasureCard> hand, Player1 player1)
	{
		int oceansChalice = 0;
		int crystalOfFire = 0;
		int statueOfTheWind = 0;
		int earthStone = 0;
		for(TreasureCard t : hand)
		{
			if(t.getName().equals("OceansChalice"))
			{
				oceansChalice++;
			}
			else if(t.getName().equals("CrystalOfFire"))
			{
				crystalOfFire++;
			}
			else if(t.getName().equals("StatueOfTheWind"))
			{
				statueOfTheWind++;
			}
			else if(t.getName().equals("EarthStone"))
			{
				earthStone++;
			}
		}
		if(oceansChalice == 4)
		{
			player1.setRelatedTreasure("OceansChalice");
			discardTreasureCard(player1, "OceansChalice");
		}
		if(crystalOfFire == 4)
		{
			player1.setRelatedTreasure("CrystalOfFire");
			discardTreasureCard(player1, "CrystalOfFire");
		}
		if(statueOfTheWind == 4)
		{
			player1.setRelatedTreasure("StatueOfTheWind");
			discardTreasureCard(player1, "StatueOfTheWind");
		}
		if(earthStone == 4)
		{
			player1.setRelatedTreasure("EarthStone");
			discardTreasureCard(player1, "EarthStone");
		}
	}

	public ArrayList<TreasureCard> checkHands(ArrayList<TreasureCard> playerHand)
	{
		int size = playerHand.size();
		String choice = "";
		/*
		if(size > 5)
		{
			String[] userChoice = new String[] {"discard a card", "use sandbag", "use helicopter lift"};
	        choice = (String)JOptionPane.showInputDialog(null, "You have more than 5 cards", "User Choices", JOptionPane.QUESTION_MESSAGE, null, userChoice, userChoice[1]);
		}
		if(choice.equals("discard a card"))
		{*/
//		if(size > 5)
//		{
//			getDiscardTreasureCards().add(playerHand.get(0));
//			playerHand.remove(0);
//			if(size > 6)
//			{
//				getDiscardTreasureCards().add(playerHand.get(0));
//				playerHand.remove(0);
//			}
//		}
		/*
		}
		else 
		{
			
		}

		for(TreasureCard t : playerHand)
		{
			if(t.getName().equals("Sandbag"))
			{
				
			}
			
		}
		*/

		return playerHand;
	}

	public String getHelicopterPlayers()
	{
		ArrayList<ArrayList<Player1>> allPossibilities = new ArrayList<ArrayList<Player1>>();

		for(int i = 0; i < 4; i++)
		{
			allPossibilities.add(new ArrayList<Player1>());
			for(int j = 0; j < 4; j++)
			{
				allPossibilities.get(i).add(new Player1(this, -1, "", "", treasureDeck, powns[0], powns_move[0], -1, -1));
			}
		}
		int index = 0;
		for(Player1 p : getPlayerArrayList())
		{
			int x = p.getX();//row
			int y = p.getY();//column
			Boolean hasntAdd = false;
			for(int i = 0; i < 4; i++)
			{

				if(allPossibilities.get(i).get(0).getRole().equals("") && !hasntAdd)
				{
					allPossibilities.get(i).set(0, p);
					hasntAdd = true;
				}
				else
				{
					int xPlayerInList = allPossibilities.get(i).get(0).getX();
					int yPlayerInList = allPossibilities.get(i).get(0).getY();
					if(p.getX() == xPlayerInList && p.getY() == yPlayerInList)
					{
						if(allPossibilities.get(i).get(1).getRole().equals(""))
						{
							allPossibilities.get(i).set(1, p);
						}
						else if(allPossibilities.get(i).get(2).getRole().equals(""))
						{
							allPossibilities.get(i).set(2, p);
						}
						else
						{
							allPossibilities.get(i).set(3, p);
						}
					}
				}
			}




		}
		String[] allPossibilities_String = new String[allPossibilities.size()];
		for(int i = 0; i < allPossibilities.size(); i++)
		{
			String str = "";
			for(int j = 0; j < allPossibilities.get(i).size(); j++)
			{
				Player1 p = allPossibilities.get(i).get(j);
				String role = p.getRole();
				str = str + role + " ";
			}

			allPossibilities_String[i] = str;
		}
		String userChosenPossibility = (String)JOptionPane.showInputDialog(null, "Select the group of players you want to move", "Helicopter Lift", JOptionPane.QUESTION_MESSAGE, null, allPossibilities_String, allPossibilities_String[0]);
		return userChosenPossibility;
	}

	public void changeHelicopterPlayerPositions(ArrayList<Player1> playersToFly, int tileX, int tileY)
	{
		for(Player1 p : playersToFly)
		{
			p.setX(tileX);
			p.setY(tileY);
			//System.out.println(p.getX() + " " + p.getY());
		}
	}

	public String[] getTreasureNames()
	{
		return treasureNames;
	}

	public String[] getTreasureCardNames()
	{
		return treasureCardNames;
	}

	public ArrayList<TreasureCard> getUsedTreasureCards()
	{
		return treasureDeck.getUsedCards();
	}

	public FloodDeck getFloodDeck()
	{
		return floodDeck;
	}

	public int getInitialWaterLevel()
	{
		return waterLevel;
	}

	public Queue<Player1> getPlayers()
	{
		return player1Order;
	}

	public ArrayList<Player1> getPlayerArrayList()
	{
		return player1s;
	}

	public ArrayList<FloodCard> getUsedFloodCards()
	{
		return floodDeck.getUsedFloodCards();
	}

	public Islands getIslandsClass()
	{
		return islands;
	}

	public ArrayList<Tile1> getAllTiles()
	{
		return islands.getAllTiles();
	}

	public ArrayList<ArrayList<Tile1>> getAllTiles_2D()
	{
		return islands.getAllTiles_2D();
	}
	public WaterMeter getWaterMeter()
	{
		return waterMeter;
	}
	/*
    public boolean won() {
        return Treasure.get("red") == true && Treasure.get("blue") == true && Treasure.get("yellow") == true && Treasure.get("black") == true;

    }*/
}
