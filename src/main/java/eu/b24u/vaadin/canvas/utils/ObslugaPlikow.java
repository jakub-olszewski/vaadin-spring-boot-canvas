package eu.b24u.vaadin.canvas.utils;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import com.google.gson.Gson;
/**
 * klasa obsługująca piki
 * 
 * @author Adam
 *
 */
public class ObslugaPlikow {

	private static Logger logger = Logger.getLogger("ObslugaPlikow");

	Gson gson;
	
	public ObslugaPlikow() {
		gson = new Gson();
	}

	/**
	 * zapis obiektu do formatu JSONa
	 * 
	 * @param to
	 *            obiekt który zmienimay do formatu JSON
	 * @return zwraca obiekt w formacie JSON
	 */
	public String zapiszDoJSON(Object doZamianyWJSON) {
		return gson.toJson(doZamianyWJSON);
	}

	public Object odczytajZJSON(String jsonTekst, Class nazwaPlikuClass) {
		return gson.fromJson(jsonTekst, nazwaPlikuClass);
	}

	public Plik pobierzPlik(String sciezkaDoPliku) {
		Plik plik = new Plik(sciezkaDoPliku);
		return plik;
	}

	/**
	 * Metoda pobiera sciezke do pliku z projektu z katalogu resources
	 * 
	 * @param nazwaPliku
	 *            to nazwa pliku z katalogu
	 * @return sciezka do pliku z katalogu
	 */
	public String pobierzSciezkeDoPlikuZProjektu(String nazwaPliku) {
		ClassLoader classLoader = getClass().getClassLoader();
		String path = classLoader.getResource(nazwaPliku).getPath();
		if (path.startsWith("/")) {
			path = path.substring(1);
		}
		return path;
	}

	/**
	 * Metoda do zapisu tekstu do pliku
	 * 
	 * @param tekst
	 *            to tekst ktory zapisyjemy do pliku
	 * @param plikDoZapisu
	 *            to plik w ktorym zapisujemy tekst
	 */
	public void zapiszDoPliku(String tekst, File plikDoZapisu) {
		try {
			Files.write(tekst.getBytes(), plikDoZapisu);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void zapiszDoPliku(String tekst, String sciezkaDoPliku) {
		Plik plikDoZapisu = new Plik(sciezkaDoPliku);
		try {
			Files.write(tekst.getBytes(), plikDoZapisu);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * metoda ta odczytuje plik
	 * 
	 * @param plikDoOdczytu
	 *            to plik z ktorego odczytujemy dane
	 * @return zwraca tekst znajdujacy sie w pliku
	 */
	public String odczytajZPliku(File plikDoOdczytu) {
		String result = null;
		try {
			result = Files.asCharSource(plikDoOdczytu, Charsets.UTF_8).read();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * Metoda zapisuje pamiecGry do pliku
	 */
	public void zapiszPamiecGry(PamiecGry pamiecGry) {
		// TODO 1. pobierzSciezkeDoPlikuZProjektu dla pliku o nazwie 'data.json'
		String sciezkaDoPliku = pobierzSciezkeDoPlikuZProjektu("data.json");
		// TODO 2. utworzJsona z pamiecGry za pomoca zapiszDoJSON
		String json = zapiszDoJSON(pamiecGry);
		logger.info("json=" + json);
		// TODO 3. zapiszDoPliku jsona
		zapiszDoPliku(json, sciezkaDoPliku);
	}

	/**
	 * Metoda odczytuje pamiecGry z pliku
	 */
	public PamiecGry wczytajPamiecGry() {
		// TODO 1. pobierzSciezkeDoPlikuZProjektu dla pliku o nazwie 'data.json'
		String sciezkaDoPliku = pobierzSciezkeDoPlikuZProjektu("data.json");
		// TODO 2. pobierzPlik
		Plik plik = pobierzPlik(sciezkaDoPliku);

		// TODO 3. odczytajJson z pliku
		String json = odczytajZPliku(plik);
		// TODO 4. zamien jsona na pamiecGry
		// TODO 5. zwroc pamiecGry
		return null;
	}
}
