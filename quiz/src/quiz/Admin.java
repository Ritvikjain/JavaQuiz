package quiz;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Admin extends JFrame {

	private JPanel contentPane;

	
	public Admin(String userid) {
		setTitle("Admin Page");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(this);
		setResizable(false);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		/*contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));*/
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(2, 2, 0, 0));
		
		JButton btnUploadQuestion = new JButton("Upload Question");
		btnUploadQuestion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				QuestionUpload qu=new QuestionUpload();
				qu.setVisible(true);
			}
		});
		contentPane.add(btnUploadQuestion);
		
		JButton btnViewAllStudents = new JButton("View all students");
		btnViewAllStudents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				JFrame frm=new JFrame("View All Students");
				
				frm.setSize(800, 600);
				frm.setLocationRelativeTo(Admin.this);
				GetValues.getStudents();
				JTable t=new JTable(GetValues.records,GetValues.header);
				JScrollPane pane=new JScrollPane(t);
				frm.getContentPane().add(pane);
				frm.setVisible(true);
			}
		});
		contentPane.add(btnViewAllStudents);
		
		JButton btnRegisterNewAdmin = new JButton("Register New Admin");
		btnRegisterNewAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				AdminReg ar=new AdminReg();
				ar.setVisible(true);
			}
		});
		contentPane.add(btnRegisterNewAdmin);
		
		JButton btnViewupdateDetails = new JButton("View/Update Details");
		btnViewupdateDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				ViewUpdateAdmin vua=new ViewUpdateAdmin(userid);
				vua.setVisible(true);
			}
		});
		contentPane.add(btnViewupdateDetails);
	}

}
