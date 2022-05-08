/*
 * 4
 */

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Menu extends JPanel implements ActionListener
{
	ParentPanel p;
	JButton startBtn, ruleBtn, bu3, artificial;
	private BufferedImage menuBackground;
	private int width, height;

	public Menu(ParentPanel p)
	{
		this.p = p;
		width = p.getWidth();
		height = p.getHeight();
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
		startBtn = new JButton("Start");
		//startBtn.setFont(new Font("BOLD", Font.BOLD, 18));
		//startBtn.setForeground(Color.WHITE);
		//startBtn.setBackground(new Color(64,0,0));
		//startBtn.setPreferredSize();
		startBtn.addActionListener(this);
		//c.weightx = 1;
		//c.weighty = 10;
		//c.gridx = 1;
		//c.gridwidth = 1;
		//c.gridy = 2;
		//add(startBtn);

		/*
		 * set the Instruction button
		 */
		ruleBtn = new JButton("Rules");
		//ruleBtn.setForeground(Color.WHITE);
		//ruleBtn.setFont(new Font("BOLD", Font.BOLD, 18));
		//ruleBtn.setBackground(new Color(64,0,0));
		//ruleBtn.setBounds(width/2-50, height/10, 100,50);
		ruleBtn.addActionListener(this);
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
		try
		{
			menuBackground = ImageIO.read(Menu.class.getResource("resource/backgrounds/Background.jpg"));
		}
		catch(Exception E)
		{
			System.out.println("Exception");
			return;
		}
		setVisible(true);
	}

	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(menuBackground, 0, 0, width, height, null);
		add(ruleBtn);
		ruleBtn.setForeground(Color.WHITE);
		ruleBtn.setFont(new Font("BOLD", Font.BOLD, 18));
		ruleBtn.setBackground(new Color(64,0,0));
		ruleBtn.setBounds(width/2-50, height/2+25, 100,50);

		add(startBtn);
		startBtn.setFont(new Font("BOLD", Font.BOLD, 18));
		startBtn.setForeground(Color.WHITE);
		startBtn.setBackground(new Color(64,0,0));
		startBtn.setBounds(width/2-50, height/2-75, 100,50);
	}

	public void addNotify()
	{
		super.addNotify();
		requestFocus();
	}

	public static void infoBox(String infoMessage, String titleBar)
	{
		JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == startBtn)
		{
			/*
			 * call Parent Panel class when Start button is hit
			 */
			try {
				p.generate();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
			p.change("play");
			infoBox("Each player click on the board to place their settlement and road player turn is in top right corner. Also, please click the center of a vertex and road to place it and keep your mouse still when clicking", "");
		}

		if(e.getSource() == ruleBtn)
		{
			/*
			 * call GUIHelp Class when Rule button is clicked
			 */
			p.change("rule");
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


}
