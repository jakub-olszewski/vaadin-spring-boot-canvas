package eu.b24u.vaadin.canvas.utils;

import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.Window;

public class OknoWpiszImie extends Window {

	String imieZawodnika;

	public String getImieZawodnika() {
		return imieZawodnika;
	}

	public void setImieZawodnika(String imieZawodnika) {
		this.imieZawodnika = imieZawodnika;
	}

	public OknoWpiszImie(String imieZawodnika) {
		super();
		this.imieZawodnika = imieZawodnika;
		init();
		UI.getCurrent().addWindow(this);
	}

	private void init() {
		center();
		FormLayout layout = new FormLayout();
		layout.setMargin(true);
		TextField imieTextField = new TextField();
		layout.addComponent(imieTextField);
		Button potwierdz = new Button("Zatwierdź", e -> {
			setImieZawodnika(imieTextField.getValue());
			close();
			}
		) ;
		layout.addComponent(potwierdz);
		setContent(layout);
	}
}
