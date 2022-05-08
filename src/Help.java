import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;



    public class Help extends JFrame implements WindowListener {
        private static final int WIDTH = 800;
        private static final int HEIGHT = 1050;
        private HelpPanel page;
        private JFrame frm;
        private ArrayList<HelpPanel> rules;
        private ParentPanel p;



        public Help (String title){
            this.p = p;

            frm = new JFrame();
            frm.setPreferredSize(new Dimension(WIDTH, HEIGHT));
            frm.pack();
            frm.setTitle(title);
            frm.setLocationRelativeTo(null);
            frm.setResizable(false);
            frm.setDefaultCloseOperation(frm.DISPOSE_ON_CLOSE);
            frm.setVisible(true);
            rules = new ArrayList<HelpPanel>();

            for(int i = 1; i<16; i++) {
                page = new HelpPanel(i);
                page.setPreferredSize(new Dimension(770, 1000));
                rules.add(page);
            }

            JPanel total = new JPanel();
            int k = 0;
            for(HelpPanel p: rules){
                total.add(p,k);
                k++;

            }

            JScrollPane scrollable = new JScrollPane (total, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

            scrollable.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
            scrollable.setPreferredSize(new Dimension(790,1010));
            frm.add(scrollable);
            frm.addWindowListener(this);
        }

        @Override
        public void windowOpened(WindowEvent e) {}

        @Override
        public void windowClosing(WindowEvent e) {
         //   new StartingMenu();
        }

        @Override
        public void windowClosed(WindowEvent e) {}
        @Override
        public void windowIconified(WindowEvent e) {}
        @Override
        public void windowDeiconified(WindowEvent e) {}
        @Override
        public void windowActivated(WindowEvent e) {}
        @Override
        public void windowDeactivated(WindowEvent e) {}
    }


