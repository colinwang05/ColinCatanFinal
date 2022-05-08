/*
 * 5
 */

import static java.lang.System.out;
import java.util.ArrayList;
import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.io.File;
import java.io.*;
import java.util.ArrayList;

public class GUIHelp extends JPanel implements ActionListener
{

  private JButton previousPageBtn, nextPageBtn, backToMenuBtn;
    private int pageIndex;
    private BufferedImage page1, page2, page3, page4, page5, page6, page7, page8, page9, page10, page11, page12, page13, page14, page15, currentPage;
    private ParentPanel p;
    private ArrayList<BufferedImage> menuAL;


    public GUIHelp(ParentPanel p)
    {

        this.p = p;
        pageIndex = 1;
        GridBagLayout gridbag = new GridBagLayout();
        setLayout(gridbag);
        this.setBackground(new Color(225,206,163));
        menuAL = new ArrayList<>();

        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(20,0,0,0);
        c.anchor=GridBagConstraints.SOUTH;


         //set the previousPageBtn button



        c.insets = new Insets(10,0,35,0);
        previousPageBtn = new JButton("  previous  ");
        previousPageBtn.setFont(new Font("PLAIN", Font.PLAIN, 11));
        previousPageBtn.setForeground(Color.WHITE);
        previousPageBtn.setBackground(new Color(64,0,0));
        Dimension d = new Dimension(90,50);
        previousPageBtn.setPreferredSize(d);
       previousPageBtn.addActionListener(this);
        c.weightx = 1;
        c.weighty = 1;
        c.gridx = 0;
        c.gridwidth = 1;
        c.gridy = 0;
        add(previousPageBtn, c);



         //set the nextPageBtn button

        nextPageBtn = new JButton(" next ");
        nextPageBtn.setForeground(Color.WHITE);
        nextPageBtn.setFont(new Font("PLAIN", Font.PLAIN, 11));
        nextPageBtn.setBackground(new Color(64,0,0));
        d = new Dimension(75,50);
        nextPageBtn.setPreferredSize(d);
        nextPageBtn.addActionListener(this);
        c.gridx = 2;
        c.gridwidth = 1;
        c.gridy = 0;
        add(nextPageBtn, c);


        //  set the backToMenuBtn button

        backToMenuBtn = new JButton(" back");
        backToMenuBtn.setForeground(Color.WHITE);
        backToMenuBtn.setFont(new Font("PLAIN", Font.PLAIN, 11));
        backToMenuBtn.setBackground(new Color(64,0,0));
        d = new Dimension(75,50);
        backToMenuBtn.setPreferredSize(d);
        backToMenuBtn.addActionListener(this);
        c.anchor=GridBagConstraints.CENTER;
        c.gridx = 2;
        c.gridwidth = 1;
        c.gridy = 0;
        add(backToMenuBtn, c);


         // import image

        try
        {
           // page1 = ImageIO.read(GUIHelp.class.getResource("/Images/page1.jpg"));
            page1 = ImageIO.read(GUIHelp.class.getResource("/resource/rule/rules1.jpg"));
            menuAL.add(page1);
            page2 = ImageIO.read(GUIHelp.class.getResource("/resource/rule/rules2.jpg"));
            menuAL.add(page1);
            page3 = ImageIO.read(GUIHelp.class.getResource("/resource/rule/rules3.jpg"));
            menuAL.add(page1);
            page4 = ImageIO.read(GUIHelp.class.getResource("/resource/rule/rules4.jpg"));
            menuAL.add(page1);
            page5 = ImageIO.read(GUIHelp.class.getResource("/resource/rule/rules5.jpg"));
            menuAL.add(page1);
            page6 = ImageIO.read(GUIHelp.class.getResource("/resource/rule/rules6.jpg"));
            menuAL.add(page1);
            page7 = ImageIO.read(GUIHelp.class.getResource("/resource/rule/rules7.jpg"));
            menuAL.add(page1);
            page8 = ImageIO.read(GUIHelp.class.getResource("/resource/rule/rules8.jpg"));
            menuAL.add(page1);
            page9 = ImageIO.read(GUIHelp.class.getResource("/resource/rule/rules9.jpg"));
            menuAL.add(page1);
            page10 = ImageIO.read(GUIHelp.class.getResource("/resource/rule/rules10.jpg"));
            menuAL.add(page1);
            page11 = ImageIO.read(GUIHelp.class.getResource("/resource/rule/rules11.jpg"));
            menuAL.add(page1);
            page12 = ImageIO.read(GUIHelp.class.getResource("/resource/rule/rules12.jpg"));
            menuAL.add(page1);
            page13 = ImageIO.read(GUIHelp.class.getResource("/resource/rule/rules13.jpg"));
            menuAL.add(page1);
            page14 = ImageIO.read(GUIHelp.class.getResource("/resource/rule/rules14.jpg"));
            menuAL.add(page1);
            page15 = ImageIO.read(GUIHelp.class.getResource("/resource/rule/rules15.jpg"));
            menuAL.add(page1);



            Dimension size = new Dimension(page1.getWidth(null), page1.getHeight(null));
            setPreferredSize(size);
            setMinimumSize(size);
            setMaximumSize(size);
            setSize(size);
        }
        catch(Exception E)
        {
            System.out.println("Exception");
            return;
        }
        setVisible(true);

    }

    public void paint(Graphics g)
    {
        super.paint(g);
        int index = getPageIndex();
        setCurrentPage(index);
        g.drawImage(currentPage, 340,0, 750, 1000, null);

    }

    public int getPageIndex()
    {
        return pageIndex;
    }

    public void setCurrentPage(int i)
    {
        currentPage = menuAL.get(7);
        //currentPage = menuAL.get(i-1);
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == previousPageBtn)
        {
            try
            {
                pageIndex--;
                if(pageIndex == 0)
                {
                    pageIndex = 8;
                }
                repaint();
            }
            catch(Exception ex)
            {
                return;
            }
        }
        else if(e.getSource() == nextPageBtn)
        {
            try
            {

                pageIndex++;
              /*  if(pageIndex == 16)
                {
                    pageIndex = 1;
                }

               */
                repaint();


            }
            catch(Exception ex)
            {
                return;
            }
        }
        else if(e.getSource() == backToMenuBtn)
        {
            try
            {
                p.change("MENU");
            }
            catch(Exception ex)
            {
                return;
            }
        }
    }



}