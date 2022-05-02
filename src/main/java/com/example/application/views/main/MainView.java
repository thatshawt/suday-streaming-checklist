package com.example.application.views.main;

import com.example.application.ShartifyText;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@PageTitle("Sunday Streaming Checklist")
@Route(value = "")
public class MainView extends VerticalLayout {

    private final ShartifyText title;
    private final List<Checkbox> checks;

    public MainView() {
        title = new ShartifyText("Sunday Streaming Checklist");
        title.addClassName("unselect");

        add(title);

        checks = new ArrayList<>();
        checks.add(new Checkbox("Turn on TV's"));
        checks.add(new Checkbox("Send Test Stream"));
        checks.add(new Checkbox("Download Transition/Misc. Videos"));

        for(Checkbox checkbox : checks)
            add(checkbox);

        add(new Paragraph("Impressive. Very nice. Let's see Paul Allen's card."));

    }

}
