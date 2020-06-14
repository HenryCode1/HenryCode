
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;


public class Database {
	
	private LinkedList<Person> people_list = null;
	
	private static Database database = null;
	
	private Database() {
		validateFile();
		saveToFile();
		readFile();

	}
	
	public static Database getDatabase() {
		
		if(database == null)
			database = new Database();
		
		return database;
	}
	/*this section  of my psuedo code check  for duplicate Data in the database,mostly in my project i make use of boolean (true/false),so what i did 
	 * is that i run a loop all through  the database memory holding the data to check if there is any duplicate data if yes 
	 * then the boolean data type set false else output should be true , that`s all sir.
	 *
	 * 
	 */
	 boolean validateDuplicatePeople(Person personToCheck) {
		
		boolean duplicatePeople = false;
		
		int size = people_list.size();
		
		if(size == 0) 
			return false;
			
		for(Person p: people_list) {
			if(p.getEmail() == personToCheck.getEmail()) {
				duplicatePeople = true;
			
			}else {
				duplicatePeople = false;
			}
		}
		return duplicatePeople;
	}
	 /*since i am  making use of File i/o  as my database all i need is to write my Person Object as file
	  * by my running method "saveToFile .that`s for this uncle Tj.
	  * 
	  */
	private void saveToFile() {


		try {
	
			FileOutputStream os = new FileOutputStream("db.txt");
			ObjectOutputStream oos = new ObjectOutputStream(os);
			oos.writeObject(people_list);
			oos.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}

		
	}
	/*in this section after i already convert to File using above method (saveToFile) the file need to be read in other to give an Output
	 * that`s all.
	 * 
	 */
	@SuppressWarnings("unchecked")
	private void readFile() {
		

		
		try {
			FileInputStream is = new FileInputStream("db.txt");
			ObjectInputStream ois = new ObjectInputStream(is);
			
			people_list = (LinkedList<Person>) ois.readObject();
			is.close();
			ois.close();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	/*
	 * sir this section of my code only check if file is existing 
	 *  if file then above method readFile should run in other to avoid duplited file in the memory
	 */
	private void validateFile() {
		File file = new File("db.txt");
		
		if(!file.exists()) {
			people_list = new LinkedList<>();
		}else {
			readFile();
		}
	}
	/*
	 * this section of code can only search for data store in memory
	 */
	public Person searchPerson(String name) {
		readFile();
		Person person = null;		
		for(Person p: people_list) {
			if(p.getusername().equalsIgnoreCase(name) || p.getpassword().equalsIgnoreCase(name)) {
				person = p;
			}
		}
		return person;
	}
	/**
	 * this section add new data to memory
	 * @param newPerson
	 * @return
	 */
	public boolean addPerson(Person newPerson) {
		boolean addSuccessful = false;
		
		if(!validateDuplicatePeople(newPerson)) {
			people_list.add(newPerson);
			addSuccessful = true;
		}
		saveToFile();
		return addSuccessful;
	}
	/*
	 * that`s `all for my Database
	 */
}


