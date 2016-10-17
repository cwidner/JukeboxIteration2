package tests;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import model.JukeboxAccount;

public class JukeboxAccountTest {

	@Test
	public void testJukeboxAccountConstructorAndGetters() {
		JukeboxAccount a = new JukeboxAccount("A", "123");
		JukeboxAccount b = new JukeboxAccount("B", "321");
		
		assertEquals("A", a.getName());
		assertEquals("B", b.getName());
		assertEquals("123", a.getPassword());
		assertEquals("321", b.getPassword());
		assertEquals(90000, a.getCredit());
		assertEquals(90000, b.getCredit());
	}
	
	@Test
	public void testTimesPlayed() {
		JukeboxAccount a = new JukeboxAccount("A", "123");
		JukeboxAccount b = new JukeboxAccount("B", "321");
		
		LocalDate today = LocalDate.now();
		
		assertEquals(0, a.timesPlayed(today));
		assertEquals(0, b.timesPlayed(today));
		
		a.play(today);
		a.play(today);
		b.play(today);
		
		assertEquals(2, a.timesPlayed(today));
		assertEquals(1, b.timesPlayed(today));
	}
	
	@Test
	public void testCanPlay() {
		JukeboxAccount a = new JukeboxAccount("A", "123");
		JukeboxAccount b = new JukeboxAccount("B", "321");
		
		LocalDate today = LocalDate.now();
		
		assertTrue(a.canPlay(today));
		assertTrue(b.canPlay(today));
		a.play(today);
		b.play(today);
		assertTrue(a.canPlay(today));
		assertTrue(b.canPlay(today));
		a.play(today);
		b.play(today);
		assertTrue(a.canPlay(today));
		assertTrue(b.canPlay(today));
		a.play(today);
		b.play(today);
		assertFalse(a.canPlay(today));
		assertFalse(b.canPlay(today));
	}
	
	@Test
	public void pretendItsTomorrow() {
		JukeboxAccount a = new JukeboxAccount("A", "123");
		JukeboxAccount b = new JukeboxAccount("B", "321");
		
		LocalDate today = LocalDate.now();
		
		assertTrue(a.canPlay(today));
		assertTrue(b.canPlay(today));
		assertEquals(0, a.timesPlayed(today));
		assertEquals(0, b.timesPlayed(today));
		a.play(today);
		b.play(today);
		assertTrue(a.canPlay(today));
		assertTrue(b.canPlay(today));
		assertEquals(1, a.timesPlayed(today));
		assertEquals(1, b.timesPlayed(today));
		a.play(today);
		b.play(today);
		assertTrue(a.canPlay(today));
		assertTrue(b.canPlay(today));
		assertEquals(2, a.timesPlayed(today));
		assertEquals(2, b.timesPlayed(today));
		a.play(today);
		b.play(today);
		assertFalse(a.canPlay(today));
		assertFalse(b.canPlay(today));
		assertEquals(3, a.timesPlayed(today));
		assertEquals(3, b.timesPlayed(today));
		
		today = today.plusDays(1);
		
		assertTrue(a.canPlay(today));
		assertTrue(b.canPlay(today));
		assertEquals(0, a.timesPlayed(today));
		assertEquals(0, b.timesPlayed(today));
		a.play(today);
		b.play(today);
		assertTrue(a.canPlay(today));
		assertTrue(b.canPlay(today));
		assertEquals(1, a.timesPlayed(today));
		assertEquals(1, b.timesPlayed(today));
		a.play(today);
		b.play(today);
		assertTrue(a.canPlay(today));
		assertTrue(b.canPlay(today));
		assertEquals(2, a.timesPlayed(today));
		assertEquals(2, b.timesPlayed(today));
		a.play(today);
		b.play(today);
		assertFalse(a.canPlay(today));
		assertFalse(b.canPlay(today));
		assertEquals(3, a.timesPlayed(today));
		assertEquals(3, b.timesPlayed(today));
	}
	
	@Test
	public void testWithdraw() {
		JukeboxAccount a = new JukeboxAccount("A", "123");
		JukeboxAccount b = new JukeboxAccount("B", "321");
		
		a.withdraw(100);
		b.withdraw(50);
		
		assertEquals(89900, a.getCredit());
		assertEquals(89950, b.getCredit());
	}
	
}
