package eu.b24u.selenide;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import com.google.gson.Gson;

import eu.b24u.vaadin.canvas.utils.Gracz;
import eu.b24u.vaadin.canvas.utils.ListaGraczy;

public class DataUtilsTest {

	private File pobierzPlikONazwie(String nazwaPliku) {
		ClassLoader classLoader = getClass().getClassLoader();
		String path = classLoader.getResource(nazwaPliku).getPath();
		File dataJson = new File(path);
		return dataJson;
	}

	private ListaGraczy pobierzListeGraczyZPliku(File plikZGraczami) {
		try {
			// read
			String result = Files.asCharSource(plikZGraczami, Charsets.UTF_8).read();
			Gson gson = new Gson();
			ListaGraczy listaGraczy = gson.fromJson(result, ListaGraczy.class);
			return listaGraczy;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// @Test
	public void setData() {

		Gracz gracz = new Gracz();
		gracz.ustawImieGracza("Janek");
		ListaGraczy listaGraczy = new ListaGraczy();
		listaGraczy.dodajGracza(gracz);

		Gson gson = new Gson();
		String listaGraczyJson = gson.toJson(listaGraczy);
		// System.out.println(listaGraczyJson);

		try {
			// write
			Files.write(listaGraczyJson.getBytes(), pobierzPlikONazwie(""));

			// read
			String result = Files.asCharSource(pobierzPlikONazwie(""), Charsets.UTF_8).read();
			System.out.println(result);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// @Test
	public void whenWriteUsingFiles_thenWritten() throws IOException {
		String expectedValue = "Hello world";
		File file = new File("test.txt");
		Files.write(expectedValue.getBytes(), file);
		String result = Files.asCharSource(file, Charsets.UTF_8).read();
		assertEquals(expectedValue, result);
	}

	// @Test
	public void whenReadUsingFiles_thenRead() throws IOException {
		String expectedValue = "Hello world";
		File file = new File("test.txt");
		String result = Files.asCharSource(file, Charsets.UTF_8).read();

		assertEquals(expectedValue, result);
	}

	@Test
	public void testPobranieGraczyZPliku() {
		// krok1 pobranie pliku
		File pobranyPlik = pobierzPlikONazwie("data.json");
		// krok2 wyświetlenie zawortości pliku
		ListaGraczy listaGraczy = pobierzListeGraczyZPliku(pobranyPlik);
		// nazwaObiektu kropka nazwaMetody
		// Samochod samochodJasia = new Samochod();
		// samochodJasia.otworzDrzwi();
		listaGraczy.wypiszDoKonsoli();
		// krok3 czy franek jest na liście
	}
}
