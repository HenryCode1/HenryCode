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

public class login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUser;
	private JTextField txtPass;
	private JTextField txtEmail;
	private JTextField search;
	private Maincontroller maincontroller;
	private LinkedList<Person> people_list = null;
	private JLabel lblPassword;
	private JLabel lblGamil;
	private JLabel lblNewLabel;

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
		txtUser.setBounds(99, 44, 163, 20);
		contentPane.add(txtUser);
		txtUser.setColumns(10);
		
		txtPass = new JTextField();
		txtPass.setColumns(10);
		txtPass.setBounds(99, 85, 163, 20);
		contentPane.add(txtPass);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(99, 129, 163, 20);
		contentPane.add(txtEmail);
		
		JButton btnSumit = new JButton("Sumit");
		btnSumit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
					if(addPerson()){
						JOptionPane.showMessageDialog( null," the Datas are now added to Database ");
						
						txtUser.setText("");
						txtPass.setText("");
						txtEmail.setText("");
						
					}else{
						JOptionPane.showMessageDialog( null," Erro  can`t add duplicated data try another!!!");
					}
			}
		
		});
		btnSumit.setBounds(99, 210, 163, 23);
		contentPane.add(btnSumit);
		
		search = new JTextField();
		search.setColumns(10);
		search.setBounds(227, 11, 115, 20);
		contentPane.add(search);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Person  p=searchPerson();
				if(p!=null){
					JOptionPane.showMessageDialog( null,"Data Found"+"\n\n\n"+"NAME  :"+p.getusername()+"\n"+"PASSWORD  :"+p.getpassword()+"\n"+"Gmail  :"+p.getEmail());
					search.setText("");
				}else {
					JOptionPane.showMessageDialog( null,"No Data found");
				}
			}

			
		});
		btnSearch.setBounds(345, 10, 89, 23);
		contentPane.add(btnSearch);
		
		JLabel lblUserNamE = new JLabel("   USER NAM E");
		lblUserNamE.setBounds(10, 47, 81, 14);
		contentPane.add(lblUserNamE);
		
		lblPassword = new JLabel("   PASSWORD");
		lblPassword.setBounds(8, 88, 81, 14);
		contentPane.add(lblPassword);
		
		lblGamil = new JLabel("   GMAIL");
		lblGamil.setBounds(20, 132, 66, 14);
		contentPane.add(lblGamil);
		
		lblNewLabel = new JLabel("                       LOGIN FORM");
		lblNewLabel.setBounds(10, 11, 218, 17);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLUE);
		panel.setBounds(0, 0, 434, 261);
		contentPane.add(panel);
	}
	   private boolean addPerson() {
			
			return  maincontroller.addPerson(txtUser.getText(),txtPass.getText(),txtEmail.getText());
	   }
	   private Person searchPerson() {
			
			return maincontroller.searchPerson(search.getText());
		}
}
	  
