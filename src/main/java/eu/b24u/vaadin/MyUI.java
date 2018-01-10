package eu.b24u.vaadin;

/**
 * This UI is the application entry point. A UI may either represent a browser window (or tab) or
 * some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be
 * overridden to add component to the user interface and initialize non-component functionality.
 */

import javax.servlet.annotation.WebListener;
import javax.servlet.annotation.WebServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.ContextLoaderListener;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Viewport;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.colorpicker.Color;
import com.vaadin.spring.annotation.EnableVaadin;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.navigator.SpringViewProvider;
import com.vaadin.spring.server.SpringVaadinServlet;
import com.vaadin.ui.CustomLayout;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import eu.b24u.vaadin.canvas.Plotno;
import eu.b24u.vaadin.canvas.Punkt;
import eu.b24u.vaadin.canvas.utils.OknoWpiszImie;
import eu.b24u.vaadin.canvas.utils.Stoper;
import eu.b24u.vaadin.sandbox.Strzala;
import eu.b24u.vaadin.sandbox.Tarcza;

@SpringUI
@Theme("mytheme")
@Viewport("initial-scale=1, maximum-scale=1")
@SuppressWarnings("serial")
public class MyUI extends UI {

	@WebServlet(value = "/*", asyncSupported = true)
	public static class Servlet extends SpringVaadinServlet {
	}

	@WebListener
	public static class MyContextLoaderListener extends ContextLoaderListener {
	}

	@Configuration
	@EnableVaadin
	public static class MyConfiguration {
	}

	@Autowired
	SpringViewProvider viewProvider;

	int licznikPunktow;
	int sumaWylosowanychPunktow;
	Stoper czasomierz;
    String imieZawodnika;
	/**
	 * stworz/zainicjuj,metoda wykonywana jako pierwsza
	 */
	@Override
	protected void init(VaadinRequest request) {
  czasomierz=new Stoper("czasomierz");
		licznikPunktow = 0;
		Plotno plotno = new Plotno();

		MenuBar menu = new MenuBar();
		CustomLayout content = new CustomLayout("my-layout");
		content.addComponent(plotno, "canvas");
		content.addComponent(menu, "menu");

		VerticalLayout verticalLayout = new VerticalLayout();
		verticalLayout.setMargin(false);
		verticalLayout.setSpacing(false);
		verticalLayout.addComponent(menu);
		verticalLayout.addComponent(plotno);
		setContent(verticalLayout);

		/**
		 * Rozpocznij grę, od razu resetuje licznik punktów
		 */
		menu.addItem("Rozpocznij grę", e -> {
			licznikPunktow = 0;
			sumaWylosowanychPunktow = 240;// TODO tutaj należy wstawić sumę wylosowanych punktów

			OknoWpiszImie oknoDowpisaniaImienia = new OknoWpiszImie();
					});
		menu.addItem("Wyjdź", e -> plotno.clear());
		menu.addItem("Start", e -> czasomierz.start());
		menu.addItem("Stop", e -> czasomierz.stop());
		menu.addItem("Twój czas", e -> {
			Notification.show(czasomierz.wypiszCzas());
		});
		menu.addItem("Wypisz imię", e -> {
			Notification.show(imieZawodnika);
		});
		menu.setSizeFull();
		
		plotno.rysujProstokat(new Punkt(0, 0), new Punkt(1000, 600), new Color(0, 191, 255));
		Tarcza kolorowaTarcza = new Tarcza(plotno, 600, 300);
		plotno.wstawText(new Punkt(50, 50), "Gra lotki !", Color.WHITE);


		// dodanie zdarzenia na klikniecie myszka na plotnie
		plotno.dodajZdarzenieNaKlikniecieMyszka(e -> {
			// czysci plotno
			plotno.clear();
			// wstawia tekst "Gra lotki !"
			plotno.wstawText(new Punkt(50, 50), "Gra lotki !");
			// Rysuje prostokat na plotnie
			plotno.rysujProstokat(new Punkt(0, 0), new Punkt(1000, 600), new Color(0, 191, 255));
			// tworzy tarcze na plotnie
			Tarcza tarcza = new Tarcza(plotno, 600, 300);
			// pobranie kliknietego punktu na plotnie
			// kliknietyPunkt - to nazwa zmiennej zawierajacej wspolrzedne klikniecia myszka
			Punkt kliknietyPunkt = new Punkt(e.getRelativeX(), e.getRelativeY());
			// oblicza odleglosc od srodka tarczy
			double odleglosc = tarcza.obliczOdlegloscOdSrodka(kliknietyPunkt);
			// wstawia tekst "Liczba punktów"

			int punkty = 0;

			new Strzala(plotno, kliknietyPunkt);
			if (odleglosc < 200) {
				// wykonaj kiedy odleglosc jest mniejsz niż 200
			} else {
				//Notification.show("nie trafiony");
			}
			if (odleglosc < 50) {
				//Notification.show("Brawo sam środek !!!");
				punkty = 100;
			}
			// znak && oznacza litere 'i'
			if (odleglosc > 50 && odleglosc < 100) {
				//Notification.show("Brawo trafiłes w czerwony krąg !!!");
				punkty = 80;
			}

			if (odleglosc > 100 && odleglosc < 150) {
				//Notification.show("Brawo trafiłes w biały krąg !!!");
				punkty = 60;
			}

			if (odleglosc > 150 && odleglosc < 200) {
				//Notification.show("Brawo trafiłes w niebieski krąg !!!");
				punkty = 40;
			}

			System.out.println("odleglosc=" + odleglosc);
			// licznikPunktow=licznikPunktow+punkty;
			licznikPunktow += punkty;
			plotno.wstawText(new Punkt(50, 550), "Liczba punktów:" + licznikPunktow);
			plotno.wstawText(new Punkt(71, 466), "Zbierz:" + sumaWylosowanychPunktow);
		});
	}

	public void wypiszOdlegloscOdSrodkaTarczy(Tarcza kolorowaTarcza, int x, int y) {
		double odleglosc = kolorowaTarcza.obliczOdlegloscOdSrodka(new Punkt(x, y));
		System.out.println("odleglosc=" + odleglosc);
	}
}
