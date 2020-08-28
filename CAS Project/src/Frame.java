import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Frame extends JFrame implements ActionListener {
	private int W = 1200;
	private int H = 800;
	private Container c = getContentPane();

	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem menuItem[] = new JMenuItem[4];

	private Panel1 p1 = new Panel1(W, H);
	private Panel2 p2 = new Panel2(W, H);
	private Panel3 p3 = new Panel3(W, H);
	private Panel4 p4 = new Panel4(W, H);

	Frame() {
		super("CAS Project");
		c.setLayout(null);
		p1.b[0].addActionListener(this);
		p1.b[1].addActionListener(this);
		c.add(p1);
		MenuSetup();
	}

	public void MenuSetup() {
		this.setJMenuBar(null);
		menuBar = new JMenuBar();
		menu = new JMenu("Menu");
		menuItem[0] = new JMenuItem("Home");
		menuItem[1] = new JMenuItem("Settings");
		menuItem[2] = new JMenuItem("Play");
		menuItem[3] = new JMenuItem("Exit");
		for (int i = 0; i < menuItem.length; i++) {
			menuItem[i].addActionListener(this);
			menu.add(menuItem[i]);
		}
		menuBar.add(menu);
		this.setJMenuBar(menuBar);
		this.setSize(W, H);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == menuItem[0] || e.getSource() == p4.b[1]) {
			c.removeAll();
			p1.b[0].addActionListener(this);
			p1.b[1].addActionListener(this);
			c.add(p1);
			MenuSetup();
		}

		else if (e.getSource() == menuItem[1] || e.getSource() == p1.b[0]) {
			c.removeAll();
			c.add(p2);
			MenuSetup();
		}

		else if (e.getSource() == menuItem[2] || e.getSource() == p1.b[1]) {
			c.removeAll();
			p3 = new Panel3(W, H);
			c.add(p3);
			MenuSetup();
		}

		else if (e.getSource() == menuItem[3]) {
			c.removeAll();
			p4 = new Panel4(W, H);
			p4.b[1].addActionListener(this);
			c.add(p4);
			MenuSetup();
		}
	}

}
