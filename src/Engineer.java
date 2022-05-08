/*
 * shore up 2 tiles for 1 action
 */
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Engineer extends Player1
{
	private GameBoard gameBoard;
	private ArrayList<Tile1> movableTile1s;

	public Engineer(GameBoard gameBoard, int order, String Color, String Role, TreasureDeck treasureDeck,
					BufferedImage pown, BufferedImage pown_move, int xPos, int yPos)
	{
		super(gameBoard, order, Color, Role, treasureDeck, pown, pown_move, xPos, yPos);
		this.gameBoard = gameBoard;

	}

}
