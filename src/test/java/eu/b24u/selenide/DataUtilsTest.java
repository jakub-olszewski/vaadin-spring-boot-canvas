package eu.b24u.selenide;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import com.google.gson.Gson;

import eu.b24u.vaadin.canvas.utils.Gracz;
import eu.b24u.vaadin.canvas.utils.ListaGraczy;

public class DataUtilsTest {

	private File getDataFile() {
		ClassLoader classLoader = getClass().getClassLoader();
		String path = classLoader.getResource("data.json").getPath();
		File dataJson = new File(path);
		return dataJson;
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
			Files.write(listaGraczyJson.getBytes(), getDataFile());

			// read
			String result = Files.asCharSource(getDataFile(), Charsets.UTF_8).read();
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
}
