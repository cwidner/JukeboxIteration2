package tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import model.Jukebox;

public class JukeboxTest {

	@Test
	public void testJukebox() {
		Jukebox j = new Jukebox();
		
		assertTrue(j.isAccount("River"));
		assertTrue(j.isAccount("Chris"));
		assertFalse(j.isAccount("Colin"));
	}

}
