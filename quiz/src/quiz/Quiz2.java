package quiz;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Quiz2 extends JFrame {

	private JPanel contentPane;
	int marks=0;
	int count=0;

	public Quiz2(String reg) 
	{
		setTitle("Quiz 1");
		setResizable(false);
		setLocationRelativeTo(this);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 395);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setIcon(new ImageIcon(new ImageIcon("quiz.jpg").getImage().getScaledInstance(80, 40, Image.SCALE_DEFAULT)));
		
		JLabel lblQuestion = new JLabel("Question:");
		
		JTextArea textArea = new JTextArea();
		
		JRadioButton rdbtnOptionA = new JRadioButton("Option A");
		
		JRadioButton rdbtnOptionB = new JRadioButton("Option B");
		
		JRadioButton rdbtnOptionC = new JRadioButton("Option C");
		
		JRadioButton rdbtnOptionD = new JRadioButton("Option D");
		
		ButtonGroup bg=new ButtonGroup();
		bg.add(rdbtnOptionA);
		bg.add(rdbtnOptionB);
		bg.add(rdbtnOptionC);
		bg.add(rdbtnOptionD);
		
		
		Connection con=DBInfo.con;
		String query="select* from questions2";
		try
		{
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet res=ps.executeQuery();
			/*ResultSetMetaData rsmd=res.getMetaData();
			int colCount=rsmd.getColumnCount();*/
			res.next();
			textArea.setText(res.getString(1));
			rdbtnOptionA.setText(res.getString(2));
			rdbtnOptionB.setText(res.getString(3));
			rdbtnOptionC.setText(res.getString(4));
			rdbtnOptionD.setText(res.getString(5));
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		JButton btnNextQues = new JButton("Next Ques");
		btnNextQues.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				count++;
				if(count==9)
				   btnNextQues.setText("Finish");
				if(count<10){
				String ques=textArea.getText();
				String query="select * from questions2";
				try
				{
					PreparedStatement ps=con.prepareStatement(query);
					ResultSet res=ps.executeQuery();
					while(res.next())
					{
						if(res.getString(1).equals(ques))
						{
							break;
						}
					}
					res.next();
					textArea.setText(res.getString(1));
					rdbtnOptionA.setText(res.getString(2));
					rdbtnOptionB.setText(res.getString(3));
					rdbtnOptionC.setText(res.getString(4));
					rdbtnOptionD.setText(res.getString(5));
				}
				catch(Exception f)
				{
					f.printStackTrace();
				}
				bg.clearSelection();
				}
				else
				{	
					String query="update student set quiz2=? where regno=?";
					int i=0;
					try
					{
						PreparedStatement ps=con.prepareStatement(query);
						ps.setInt(1, marks);
						ps.setString(2, reg);
						i=ps.executeUpdate();
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
					if(i==1)
					{
						JOptionPane.showMessageDialog(Quiz2.this, "Quiz Completed Your Score:"+ marks+" out of 10");
						Quiz2.this.setVisible(false);
					}
				}
			}
		});
		
		JButton btnSubmit = new JButton("SaveAns.");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				if(rdbtnOptionA.isSelected())
				{
					String ans=rdbtnOptionA.getActionCommand();
					String ques=textArea.getText();
					String query="select * from questions2 where question=?";
					try
					{
						PreparedStatement ps=con.prepareStatement(query);
						ps.setString(1, ques);
						ResultSet res=ps.executeQuery();
						while(res.next())
						{
							break;
						}
						if(res.getString(6).equals(ans))
						{
							System.out.println(ans);
							marks++;
						}
					}
					catch(Exception f)
					{
						f.printStackTrace();
					}
				}
				else if(rdbtnOptionB.isSelected())
				{
					String ans=rdbtnOptionB.getActionCommand();
					String ques=textArea.getText();
					String query="select * from questions2 where question=?";
					try
					{
						PreparedStatement ps=con.prepareStatement(query);
						ps.setString(1, ques);
						ResultSet res=ps.executeQuery();
						while(res.next())
						{
							break;
						}
						if(res.getString(6).equals(ans))
						{
							System.out.println(ans);
							marks++;
						}
					}
					catch(Exception f)
					{
						f.printStackTrace();
					}
				}
				else if(rdbtnOptionC.isSelected())
				{
					String ans=rdbtnOptionC.getActionCommand();
					String ques=textArea.getText();
					String query="select * from questions2 where question=?";
					try
					{
						PreparedStatement ps=con.prepareStatement(query);
						ps.setString(1, ques);
						ResultSet res=ps.executeQuery();
						while(res.next())
						{
							break;
						}
						if(res.getString(6).equals(ans))
						{
							System.out.println(ans);
							marks++;
						}
					}
					catch(Exception f)
					{
						f.printStackTrace();
					}
				}
				else if(rdbtnOptionD.isSelected())
				{
					String ans=rdbtnOptionD.getActionCommand();
					String ques=textArea.getText();
					String query="select * from questions2 where question=?";
					try
					{
						PreparedStatement ps=con.prepareStatement(query);
						ps.setString(1, ques);
						ResultSet res=ps.executeQuery();
						while(res.next())
						{
							break;
						}
						if(res.getString(6).equals(ans))
						{
							System.out.println(ans);
							marks++;
						}
					}
					catch(Exception f)
					{
						f.printStackTrace();
					}
				}
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(180)
							.addComponent(lblNewLabel))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblQuestion))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(textArea, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(46)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(rdbtnOptionC)
								.addComponent(rdbtnOptionB)
								.addComponent(rdbtnOptionA)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(rdbtnOptionD)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(40)
											.addComponent(btnSubmit, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)))
									.addGap(59)
									.addComponent(btnNextQues)))
							.addGap(101)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addGap(18)
					.addComponent(lblQuestion)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(rdbtnOptionA)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(rdbtnOptionB)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(rdbtnOptionC)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(rdbtnOptionD)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNextQues)
						.addComponent(btnSubmit))
					.addContainerGap(21, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
