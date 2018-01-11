package com.example;

import com.vaadin.annotations.Title;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import javax.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.spring.events.EventBus;
import org.vaadin.spring.events.annotation.EventBusListenerMethod;

/**
 *
 * @author erickjvallejo@gmail.com
 */

@SpringUI
@Title("Mi Eventbus with Vaadin4Spring")
public class EventbusUI extends UI {

    private final EventBus.UIEventBus uiEventBus;

    @Autowired
    public EventbusUI(EventBus.UIEventBus viewEventBus) {
        this.uiEventBus = viewEventBus;
        viewEventBus.subscribe(this);
    }

    @Override
    protected void init(VaadinRequest request) {

        Button button = new Button("Logout");
        button.addClickListener((event) -> {
            uiEventBus.publish(this, new LogoutEvent());
        });

        setContent(button);
    }

    @EventBusListenerMethod
    private void logoutChanged(LogoutEvent event) {
     Notification.show("Closing session from Vaadin4Spring EventBus", Notification.Type.ERROR_MESSAGE);
    }

    @PreDestroy
    public void destroy() {
        uiEventBus.unsubscribe(this);
    }
}
