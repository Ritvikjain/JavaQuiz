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
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Student extends JFrame {
	

	private JPanel contentPane;

	public Student(String reg) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 459, 312);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setIcon(new ImageIcon(new ImageIcon("student.jpg").getImage().getScaledInstance(200, 130, Image.SCALE_DEFAULT)));
		
		JLabel lblWhichQuizYou = new JLabel("Which Quiz You want to attempt?");
		
		String quiz[]={"Select","Quiz 1","Quiz 2","Quiz 3"};
		JComboBox comboBox = new JComboBox(quiz);
		
		JButton btnAttemptQuiz = new JButton("Attempt Quiz");
		btnAttemptQuiz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				String quiz=(String)comboBox.getSelectedItem();
				if(quiz.equals("Quiz 1"))
				{
					Quiz q1=new Quiz(reg);
					q1.setVisible(true);
				}
				else if(quiz.equals("Quiz 2"))
				{
					Quiz2 q2=new Quiz2(reg);
					q2.setVisible(true);
				}
				else if(quiz.equals("Quiz 3"))
				{
					Quiz3 q3=new Quiz3(reg);
					q3.setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(Student.this, "Choose a Valid Option");
				}
			}
		});
		
		JLabel lblScoreBoard = new JLabel("Score Board");
		
		JButton btnViewScoreboard = new JButton("View Scoreboard");
		btnViewScoreboard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				ScoreBoard sb=new ScoreBoard(reg);
				sb.setVisible(true);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(41)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblWhichQuizYou)
								.addComponent(lblScoreBoard))
							.addGap(19)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(10)
									.addComponent(btnAttemptQuiz))
								.addComponent(btnViewScoreboard)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(85)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 267, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(53, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
					.addGap(36)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblWhichQuizYou)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAttemptQuiz))
					.addGap(47)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblScoreBoard)
						.addComponent(btnViewScoreboard))
					.addContainerGap(53, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
