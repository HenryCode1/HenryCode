import java.util.Random;
public class Maincontroller {

	/*
	 * this is just the maincontroller part that controls the system
	 */
	private static Maincontroller maincontroller = null;
	private Database database;// i callled in database class
	private Person person;// same to person
	
	/*
	 * this is my singleton class to protect the class ,there are many copies of object so this method ensure we use
	 * same object 
	 * that we need to store data in same memory location 
	 */
	private Maincontroller() {
		
		database = Database.getDatabase();
	
	}
	
	public static Maincontroller getMaincontroller() {
		
		if(maincontroller == null)
			maincontroller = new Maincontroller();
		
		return maincontroller;
	}
      	
	public boolean addPerson(String username, String password, String email) {
		
		person = new Person(username, password, email);
		
		return database.addPerson(person);
	}
	
	public Person searchPerson(String name) {
		
		return database.searchPerson(name);
	}
	

}
