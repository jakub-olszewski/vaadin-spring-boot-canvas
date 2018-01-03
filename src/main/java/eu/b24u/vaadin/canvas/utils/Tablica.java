package eu.b24u.vaadin.canvas.utils;

import java.util.ArrayList;
import java.util.Random;

/**
 * 
 * @author student
 *
 */
public class Tablica extends ArrayList<Integer> {

	public Tablica() {
		super();
	}

	public void dodajLiczbe(int liczba) {
		add(liczba);
	}

	public int losujLiczbe() {
		return get(losujLiczbeZPrzedzialu(0, size() - 1));
	}

	private int losujLiczbeZPrzedzialu(int min, int max) {
		return new Random().ints(min, max + 1).findFirst().getAsInt();
	}

	/**
	 * Test
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Tablica tablica = new Tablica();
		tablica.dodajLiczbe(40);
		tablica.dodajLiczbe(60);
		tablica.dodajLiczbe(80);
		System.out.println(tablica.losujLiczbe());
	}

}
