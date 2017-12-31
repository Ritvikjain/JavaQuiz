package quiz;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

public class ScoreBoard extends JFrame {

	private JPanel contentPane;
	String name,quiz1,quiz2,quiz3;
	
	public ScoreBoard(String reg) 
	{
		setTitle("Score Board");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(this);
		setResizable(false);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		Connection con=DBInfo.con;
		String query="Select * from student where regno=?";
		try
		{
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, reg);
			ResultSet res=ps.executeQuery();
			while(res.next())
			{
				break;
			}
			name=res.getString(1);
			quiz1=res.getString(8);
			quiz2=res.getString(9);
			quiz3=res.getString(10);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setIcon(new ImageIcon(new ImageIcon("SCORE.jpg").getImage().getScaledInstance(200, 100, Image.SCALE_DEFAULT)));
		
		JLabel lblRegisterationNo = new JLabel("Registeration No.");
		
		JLabel lblNewLabel_1 = new JLabel();
		lblNewLabel_1.setText(reg);
		
		JLabel lblName = new JLabel("Name");
		
		JLabel lblQuiz = new JLabel("Quiz 1");
		
		JLabel lblQuiz_1 = new JLabel("Quiz 2");
		
		JLabel lblQuiz_2 = new JLabel("Quiz 3");
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setText(name);
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setText(quiz1);
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setText(quiz2);
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setText(quiz3);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(96)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblRegisterationNo)
								.addComponent(lblName)
								.addComponent(lblQuiz)
								.addComponent(lblQuiz_1)
								.addComponent(lblQuiz_2))
							.addGap(59)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_5)
								.addComponent(lblNewLabel_4)
								.addComponent(lblNewLabel_3)
								.addComponent(lblNewLabel_2)
								.addComponent(lblNewLabel_1))))
					.addContainerGap(140, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRegisterationNo)
						.addComponent(lblNewLabel_1))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblName)
						.addComponent(lblNewLabel_2))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblQuiz)
						.addComponent(lblNewLabel_3))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblQuiz_1)
						.addComponent(lblNewLabel_4))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblQuiz_2)
						.addComponent(lblNewLabel_5))
					.addContainerGap(56, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
