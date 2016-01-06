package p1;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.BorderLayout;

import java.awt.GridLayout;
import java.awt.Container;
import java.io.*;
import java.util.*;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.BorderLayout;
import java.awt.Container;
import java.io.*;
import java.util.*;
public class DisplayAll extends JFrame {
	public DisplayAll(ArrayList<RegData> list) {
		super("Customer List");
		String heading[] = { "Name", "Customer Mail id", "Destination","Address","Ph no." };
		String data[][] = new String[100][5];

		int r = 0;
		for (RegData re : list) {
			data[r][0] = re.getNm();
			data[r][1] = re.getMail();
			data[r][2] = re.getPass();
			data[r][3] = re.getAdd();
			data[r][4] = re.getPh();
			

			r++;
		}
		Container con = getContentPane();
		con.setLayout(new GridLayout());

		JTable datatable = new JTable(data, heading);
		JScrollPane jsp = new JScrollPane(datatable);

		con.add(new JLabel("All Registration Details"), BorderLayout.NORTH);
		con.add(jsp, BorderLayout.CENTER);

		setSize(650, 300);

		setLocation(200, 200);
		setVisible(true);

	}

}
