package eu.b24u.vaadin.canvas.utils;

import java.util.ArrayList;
import java.util.Random;

/**
 * tablica.java to klasa, ktora zawiera metody takie jak: dodajLiczbe
 * losujLiczbe losujLiczbeZPrzedzialu
 * 
 * @author student
 *
 */
public class Tablica extends ArrayList<Integer> {
	/**
	 * Konstruktor-tworzy obiekt typu tablica. To jest miejsce ktore wykonuje sie
	 * gdy wpisujemy new Tablica()
	 * 
	 * 
	 */
	public Tablica() {
		super();
	}

	/**
	 * metoda z parametrem ktora dodaje liczbe do tablicy.
	 *
	 * @param liczba
	 *            to liczba ktora dodajemy do tablicy.
	 */
	public void dodajLiczbe(int liczba) {
		add(liczba);
	}

	/**
	 * losuje liczbe z tablicy
	 * 
	 * @return dostajemy wylosowana liczbe z tablicy.
	 */
	public int losujLiczbe() {
		return get(losujLiczbeZPrzedzialu(0, size() - 1));
	}

	/**
	 * losuje liczbe z przedzialu od min do max.
	 * 
	 * @param min
	 *            najmniejsza liczba calkowita jaka moze sie wylosowac.
	 * @param max
	 *            najwieksza liczba calkowita jaka moze sie wylosowac.
	 * @return liczba z przedzialu od min do max
	 */
	private int losujLiczbeZPrzedzialu(int min, int max) {
		return new Random().ints(min, max + 1).findFirst().getAsInt();
	}

	/**
	 * Wypisywanie liczby w konsoli
	 * 
	 * @param liczba
	 *            ktora wypisujemy
	 */
	public void wypisz(int liczba) {
		System.out.println("Liczba " + liczba);
	}

	/**
	 * Test
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Tablica tablicaPunktow = new Tablica();
		tablicaPunktow.dodajLiczbe(40);
		tablicaPunktow.dodajLiczbe(60);
		tablicaPunktow.dodajLiczbe(80);
		tablicaPunktow.dodajLiczbe(100);
		int wylosowanaLiczba; // tworzenie zmiennej o nazwie wylosowana liczba
		wylosowanaLiczba = tablicaPunktow.losujLiczbe();
		// tablicaPunktow.wypisz(wylosowanaLiczba);
		int sumaPunktow = 0;
		sumaPunktow = wylosowanaLiczba;
		wylosowanaLiczba = tablicaPunktow.losujLiczbe();
		// sumaPunktow=sumaPunktow+wylosowanaLiczba;
		sumaPunktow += wylosowanaLiczba;// zwiekszenie sumy punktow o wylosowana liczbe
		wylosowanaLiczba = tablicaPunktow.losujLiczbe();
		sumaPunktow += wylosowanaLiczba;
		tablicaPunktow.wypisz(sumaPunktow);
	}

}
