/**
 * 
 */
package eu.b24u.vaadin.sandbox;

/**
 * @author Jakub
 *
 */
public class Main {

	/**
	 * Klasa glowna - odpowiada za uruchomienie naszego programu
	 */
	public Main() {
	}

	/**
	 * Metoda statyczna (static) publiczna (widoczna dla wszystkich) <br>
	 * . Wykonywane linie z gory na dol tworza nasz program.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// W tej lini tworzymy zmienna o nazwie filipludzik
		// New oznacza tworzenie nowego obiektu
		Tarcza filipLudzik = new Tarcza(null, 0, 0);
		Tarcza dawidLudzik;
		filipLudzik.przedstawSie();
	}

}
