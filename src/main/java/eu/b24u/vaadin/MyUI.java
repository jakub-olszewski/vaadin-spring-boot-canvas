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
import com.vaadin.spring.annotation.EnableVaadin;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.navigator.SpringViewProvider;
import com.vaadin.spring.server.SpringVaadinServlet;
import com.vaadin.ui.CustomLayout;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import eu.b24u.vaadin.canvas.Plotno;
import eu.b24u.vaadin.sandbox.Ludzik;

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

	@Override
	protected void init(VaadinRequest request) {

		Plotno plotno = new Plotno();
		MenuBar menu = new MenuBar();
		// plotno.setWidth(95, Unit.PERCENTAGE);
		CustomLayout content = new CustomLayout("my-layout");
		// content.setSizeFull();
		content.addComponent(plotno, "canvas");
		content.addComponent(menu, "menu");
		// setContent(content);

		VerticalLayout verticalLayout = new VerticalLayout();
		verticalLayout.setMargin(false);
		verticalLayout.setSpacing(false);
		verticalLayout.addComponent(menu);
		verticalLayout.addComponent(plotno);
		setContent(verticalLayout);

		menu.addItem("Rysuj trójkąt", e -> plotno.rysujOkrag(100, 100, 50));
		menu.addItem("Rysuj linie", e -> plotno.rysujLinie());
		menu.setSizeFull();
		plotno.rysujLinie(691, 287, 1144, 281);
		Ludzik tomekludzik = new Ludzik(plotno, 200, 200);
	}
}
