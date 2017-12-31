package quiz;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Login() 
	{
		setTitle("Login Page");
		setResizable(false);
		setLocationRelativeTo(this);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setIcon(new ImageIcon(new ImageIcon("login1.jpg").getImage().getScaledInstance(200, 300, Image.SCALE_DEFAULT)));
		
		JLabel lblUseridregNo = new JLabel("UserId/Reg. No.");
		
		JLabel lblUsertype = new JLabel("Usertype");
		
		JLabel lblPassword = new JLabel("Password");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		String user[]={"Select","Admin","Student"};
		JComboBox comboBox = new JComboBox(user);
		
		passwordField = new JPasswordField();
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				String userid=textField.getText();
				char ch[]=passwordField.getPassword();
				String password=String.copyValueOf(ch);
				String type=(String)comboBox.getSelectedItem();
				Connection con=DBInfo.con;
				int flag=0;
				if(type.equalsIgnoreCase("admin"))
				{
					String query="select * from admin where userid=? and password=?";
					try
					{
						PreparedStatement ps=con.prepareStatement(query);
						ps.setString(1, userid);
						ps.setString(2, password);
						ResultSet res=ps.executeQuery();
						while(res.next())
						{
							flag=1;
							break;
						}
					}
					catch(Exception f)
					{
						f.printStackTrace();
					}
					if(flag==1)
					{
						Admin a=new Admin(userid);
						a.setVisible(true);
						dispose();
					}
					else
					{
						JOptionPane.showMessageDialog(Login.this, "Wrong username or password","Error",JOptionPane.ERROR_MESSAGE);
					}
				}
				if(type.equalsIgnoreCase("student"))
				{
					String query="select * from student where regno=? and password=?";
					try
					{
						PreparedStatement ps=con.prepareStatement(query);
						ps.setString(1, userid);
						ps.setString(2, password);
						ResultSet res=ps.executeQuery();
						while(res.next())
						{
							flag=1;
							break;
						}
					}
					catch(Exception f)
					{
						f.printStackTrace();
					}
					if(flag==1)
					{
						Student s=new Student(userid);
						s.setVisible(true);
						dispose();
					}
					else
					{
						JOptionPane.showMessageDialog(Login.this, "Wrong username or password","Error",JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(null);
				passwordField.setText(null);
				comboBox.setSelectedIndex(0);
			}
		});
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StudentReg sr=new StudentReg();
				sr.setVisible(true);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addGap(127)
							.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addGap(94)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblUseridregNo)
										.addComponent(lblUsertype)
										.addComponent(lblPassword))
									.addGap(65)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(textField)
										.addComponent(passwordField)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnLogin)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnReset)
									.addGap(18)
									.addComponent(btnSignUp)))))
					.addContainerGap(110, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUseridregNo)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUsertype)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPassword)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnLogin)
						.addComponent(btnSignUp)
						.addComponent(btnReset))
					.addContainerGap(41, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
