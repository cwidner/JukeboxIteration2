package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Song;
import model.SongQueue;

public class SongQueueTest {

	@Test
	public void testConstructorAndGetters() {
		SongQueue q = new SongQueue();
		
		assertEquals(0, q.getSize());
		assertTrue(q.isEmpty());
	}

	@Test
	public void testAddSong() {
		SongQueue q = new SongQueue();
		
		Song a = new Song("DanseMacabreViolinHook.mp3");
		a.setArtistName("Kevin MacLeod");
		a.setSongTitle("Danse Macabre");
		a.setSongLength(34);

		Song b = new Song("DeterminedTumbao.mp3");
		b.setArtistName("FreePlay Music");
		b.setSongTitle("Determined Tumbao");
		b.setSongLength(20);
		
		q.addSong(a);
		q.addSong(b);
		
		assertFalse(q.isEmpty());
		assertEquals(2, q.getSize());
	}
	
	@Test
	public void testPop() {
		SongQueue q = new SongQueue();
		
		Song a = new Song("DanseMacabreViolinHook.mp3");
		a.setArtistName("Kevin MacLeod");
		a.setSongTitle("Danse Macabre");
		a.setSongLength(34);

		Song b = new Song("DeterminedTumbao.mp3");
		b.setArtistName("FreePlay Music");
		b.setSongTitle("Determined Tumbao");
		b.setSongLength(20);
		
		q.addSong(a);
		q.addSong(b);
		Song s = q.pop();
		
		assertFalse(q.isEmpty());
		assertEquals(1, q.getSize());
		assertEquals("Danse Macabre", s.getTitle());
	}

}
