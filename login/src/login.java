import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.SystemColor;
import java.awt.Font;

public class login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUser;
	private JTextField txtPass;
	private Maincontroller maincontroller;
	private LinkedList<Person> people_list = null;
	private JLabel lblPassword;
	private JLabel lblNewLabel;
	private JTextField search;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public login() {
		setBackground(new Color(0, 0, 255));
		
		maincontroller = Maincontroller.getMaincontroller();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtUser = new JTextField();
		txtUser.setBounds(99, 83, 184, 23);
		contentPane.add(txtUser);
		txtUser.setColumns(10);
		
		JButton btnSumit = new JButton("Sumit");
		btnSumit.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSumit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
					if(addPerson()){
						JOptionPane.showMessageDialog( null," the Datas are now added to Database ");
						
						txtUser.setText("");
						txtPass.setText("");
						
						
					}else{
						JOptionPane.showMessageDialog( null," Erro  can`t add duplicated data try another!!!");
					}
			}
		
		});
		btnSumit.setBounds(134, 160, 117, 23);
		contentPane.add(btnSumit);
		
		txtPass = new JTextField();
		txtPass.setColumns(10);
		txtPass.setBounds(99, 117, 184, 20);
		contentPane.add(txtPass);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Person  p=searchPerson();
				if(p!=null){
					JOptionPane.showMessageDialog( null,"Data Found"+"\n\n\n"+"NAME  :"+p.getusername()+"\n"+"PASSWORD  :"+p.getpassword());
					txtPass.setText("");
				}else {
					JOptionPane.showMessageDialog( null,"No Data found");
				}
			}

			
		});
		btnSearch.setBounds(353, 10, 81, 20);
		contentPane.add(btnSearch);
		
		JLabel lblUserNamE = new JLabel("   USERNAME");
		lblUserNamE.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUserNamE.setBounds(8, 87, 81, 14);
		contentPane.add(lblUserNamE);
		
		lblPassword = new JLabel("   PASSWORD");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPassword.setBounds(8, 120, 81, 14);
		contentPane.add(lblPassword);
		
		lblNewLabel = new JLabel("    LOGIN FORM");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(134, 60, 132, 28);
		contentPane.add(lblNewLabel);
		
		JLabel lblForgotPassword = new JLabel("        forgot password?");
		lblForgotPassword.setFont(new Font("Tahoma", Font.ITALIC, 9));
		lblForgotPassword.setBounds(8, 236, 153, 14);
		contentPane.add(lblForgotPassword);
		
		search = new JTextField();
		search.setBounds(257, 11, 99, 20);
		contentPane.add(search);
		search.setColumns(10);
	}
	   private boolean addPerson() {
			
			return  maincontroller.addPerson(txtUser.getText(),txtPass.getText());
	   }
	   private Person searchPerson() {
			
			return maincontroller.searchPerson(search.getText());
		}
}
	  
