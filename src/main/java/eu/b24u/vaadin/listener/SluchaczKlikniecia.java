package eu.b24u.vaadin.listener;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;

abstract public class SluchaczKlikniecia implements Button.ClickListener {

	@Override
	public void buttonClick(ClickEvent event) {
		zdarzenieNaKlikniecie(event);
	}

	public abstract void zdarzenieNaKlikniecie(ClickEvent klikniecie);

}
