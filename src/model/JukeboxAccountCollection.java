package model;

import java.util.ArrayList;

import javax.swing.table.TableModel;

/**
 * This class stores all the JukeboxAccount objects into one collection.
 * 
 * @author Colin Widner and Qiming Wan
 *
 */
public class JukeboxAccountCollection  {
	
	private ArrayList<JukeboxAccount> accounts;
	private static JukeboxAccountCollection list;
	int size;

	/*
	 * The JukeboxAccountCollection constructor.
	 */
	private JukeboxAccountCollection() {
		accounts = new ArrayList<JukeboxAccount>();
		size = 0;
		populateCollection();
	}
	
	private void populateCollection() {
		this.add(new JukeboxAccount("Chris", "1"));
		this.add(new JukeboxAccount("Devon", "22"));
		this.add(new JukeboxAccount("River", "333"));
		this.add(new JukeboxAccount("Ryan", "4444"));
		
	}

	/*
	 * The get instance method of the singleton class.
	 * 
	 * Returns: The instance of the JukeboxAccountCollection.
	 */
	public static JukeboxAccountCollection getInstance() {
		if(list == null)
			list = new JukeboxAccountCollection();
		
		return list;
	}
	
	/*
	 * Adds a JukeboxAccount object to the collection.
	 * 
	 * Parameters:
	 * 	student - The JukeboxAccount to be added to the collection.
	 */
	public void add(JukeboxAccount student) {
		accounts.add(student);
		size++;
	}
	
	/*
	 * Determines if the collection contains the specific account.
	 * 
	 * Parameters:
	 * 	student - The username to search for in the collection.
	 * 
	 * Returns: True if the account was found in the collection, false otherwise.
	 */
	public boolean contains(String student) {
		for(int i = 0; i < size; i++) {
			JukeboxAccount acct = accounts.get(i);
			if(acct.getName().compareTo(student) == 0)
				return true;
		}
		
		return false;
	}

	/*
	 * Returns the JukeboxAccount specified.
	 * 
	 * Parameters:
	 * 	student - The username to search for in the collection and return.
	 * 
	 * Returns: A JukeboxAccount of the specified username, null otherwise.
	 */
	public JukeboxAccount getAccount(String student) {
		for(int i = 0; i < size; i++) {
			JukeboxAccount acct = accounts.get(i);
			if(acct.getName().compareTo(student) == 0)
				return acct;
		}
		
		return null;
	}
}
