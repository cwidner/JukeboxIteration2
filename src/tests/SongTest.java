
package tests;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import model.Song;
import model.SongQueue;

public class SongTest {

	@Test
	public void testConstructorAndGetters() {
		Song q = new Song("explosion");
		
		assertEquals("explosion", q.getFileName());

	}
    
	@Test
	public void setGetArtitistAndLength(){
	Song q = new Song("explosion");
	q.setArtistName("Qiming");
	assertEquals("Qiming", q.getArtist());
	q.setSongLength(33);
	assertEquals(33,q.getSongLength());
	}
	
	@Test
	public void timesPlayedTest(){
		Song q = new Song("explosion");	
		assertEquals(q.canPlay(LocalDate.now()),true);
		q.play(LocalDate.now());
		assertEquals(q.canPlay(LocalDate.now()),true);
		q.play(LocalDate.now());
		assertEquals(q.canPlay(LocalDate.now()),true);
		q.play(LocalDate.now());
		assertEquals(q.canPlay(LocalDate.now()),false);
		
		LocalDate plusOne=LocalDate.now().plusDays(1);
		assertEquals(q.canPlay(plusOne),true);
		q.play(plusOne);
		assertEquals(q.canPlay(plusOne),true);
		q.play(plusOne);
		assertEquals(q.canPlay(plusOne),true);
		q.play(plusOne);
		assertEquals(q.canPlay(plusOne),false);
	
	}
}
