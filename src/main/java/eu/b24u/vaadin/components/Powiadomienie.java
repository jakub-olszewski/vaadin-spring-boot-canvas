package eu.b24u.vaadin.components;

import com.vaadin.ui.Notification;

public class Powiadomienie {

	public static void wyswietl(String tekst) {
		Notification.show(tekst);
	}
}
