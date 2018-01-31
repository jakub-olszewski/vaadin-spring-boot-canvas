package eu.b24u.vaadin.canvas.utils;

import java.io.File;
import java.io.IOException;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import com.google.gson.Gson;

public class ObslugaPlikow {
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

	public File pobierzPlik(String sciezkaDoPliku) {
		File plik = new File(sciezkaDoPliku);
		return plik;
	}

	public String pobierzSciezkeDoPlikuZProjektu(String nazwaPliku) {
		ClassLoader classLoader = getClass().getClassLoader();
		String path = classLoader.getResource(nazwaPliku).getPath();
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
}
