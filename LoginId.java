package p1;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class LoginId extends JFrame implements ActionListener   

{
	private JLabel l1,l2,l3,l4;
	private JTextField tid;
	private JPasswordField tpass;
	private JButton blogin,bback;
	
	public LoginId()
	{
		super("Login");
		ImageIcon login=new ImageIcon("login.jpg");
		ImageIcon lock=new ImageIcon("lock.jpg");
		Container con=getContentPane();
		con.setLayout(new GridLayout(4,2));
		
		tid=new JTextField(20);
		tpass=new JPasswordField(20);
			
		blogin=new JButton("Log In");
        blogin.addActionListener(this);
        
        bback=new JButton("Back");
        bback.addActionListener(this);
       
        Font f=new Font("Arial",Font.BOLD,18);
		l1=new JLabel("Login Id");
		l1.setFont(f);
		l1.setForeground(Color.BLUE);
		
		Font f1=new Font("Arial",Font.BOLD,18);
		l2=new JLabel("Password");
		l2.setFont(f1);
		l2.setForeground(Color.BLUE);
		
		con.add(new JLabel(lock));con.add(new JLabel(login));
		con.add(l1);con.add(tid);
		con.add(l2);con.add(tpass);
		con.add(bback);con.add(blogin);
	
		setSize(475, 475);
		setLocation(465, 175);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent arg) 
	{
		if(arg.getSource()==blogin)
		{
			String id,pass;
			
			 id=tid.getText();
			 pass=tpass.getText();
			 if((id.contentEquals("admin"))&&(pass.contentEquals("root123")))
			 {
				 new Administration("Admin panel");
				 setVisible(false);
			 }
			 else
			 {
				 JOptionPane.showMessageDialog(this, "Invalid password");
				 tid.setText("");
				 tpass.setText("");
			 }
		}
		if(arg.getSource()==bback)
		{
			new FirstFrame("Choose User");
			setVisible(false);
		}	
	}	
}
