/*
 * 2
 */

import java.awt.Dimension;

import javax.swing.JFrame;

import java.awt.Toolkit;

public class GUIWindow extends JFrame
{
	private static int WIDTH;//1280
	private static int HEIGHT;//680
	private ParentPanel p;

	public GUIWindow (String title)
	{
		super(title);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		WIDTH = screenSize.width;
		HEIGHT = screenSize.height-5;
		System.out.println(WIDTH+" "+HEIGHT);
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/*
		 * call ParentPanel class
		 */
		p = new ParentPanel(WIDTH, HEIGHT, this);
		p.setBounds(0, 0, WIDTH, HEIGHT);
		add(p);
		setVisible(true);
	}

}
