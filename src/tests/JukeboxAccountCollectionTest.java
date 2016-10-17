package tests;

import static org.junit.Assert.*;
import org.junit.Test;

import model.JukeboxAccount;
import model.JukeboxAccountCollection;

public class JukeboxAccountCollectionTest {

	@Test
	public void testJukeboxAccountCollection() {
		JukeboxAccountCollection accounts = JukeboxAccountCollection.getInstance();
		accounts.add(new JukeboxAccount("A", "123"));
		accounts.add(new JukeboxAccount("B", "321"));
		accounts.add(new JukeboxAccount("C", "456"));
		accounts.add(new JukeboxAccount("D", "654"));
		
		assertTrue(accounts.contains("A"));
		assertTrue(accounts.contains("B"));
		assertTrue(accounts.contains("C"));
		assertTrue(accounts.contains("D"));
		assertFalse(accounts.contains("E"));
		
		JukeboxAccount get = accounts.getAccount("B");
		
		assertEquals("B", get.getName());
		assertEquals("321", get.getPassword());
		
		assertNull(accounts.getAccount("E"));
	
	}

}
