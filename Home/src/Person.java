import java.io.Serializable;

public class Person implements Serializable{

	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private String email;
	
	public Person(String username, String password, String email) {
		
		this.username = username;
		this.password = password;
		this.email = email;
	}
	
	public String getusername() {
		return username;
	}

	public void setusername(String username) {
		this.username = username;
	}

	public String getpassword() {
		return password;
	}

	public void setpassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


}
