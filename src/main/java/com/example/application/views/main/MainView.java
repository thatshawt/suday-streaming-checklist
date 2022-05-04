package com.example.application.views.main;

import com.example.application.elements.RickRoll;
import com.example.application.elements.ShartifyText;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.util.ArrayList;
import java.util.List;

@PageTitle("Sunday Streaming Checklist")
@Route(value = "")
public class MainView extends VerticalLayout {

    private final ShartifyText title;
    private final RickRoll roll;
    private final List<Checkbox> checks;

    public MainView() {
        roll = new RickRoll("bruhj");
        title = new ShartifyText("Sunday Streaming Checklist");
        title.addClassName("unselect");

        add(title);

        checks = new ArrayList<>();
        checks.add(new Checkbox("Turn on TV's"));
        checks.add(new Checkbox("Send Test Stream"));
        checks.add(new Checkbox("Download Transition/Misc. Videos"));

        for(Checkbox checkbox : checks)
            add(checkbox);

        add(new Paragraph("dababy123"));
        add(new Paragraph("Impressive. Very nice. Let's see Paul Allen's card."));
        add(new Image("https://c.tenor.com/hi9RxkFRriAAAAAM/no-maidens-megamind.gif",
                "no maidens?"));
        add(new Image("https://c.tenor.com/bVh8C-q-TG4AAAAC/interstellar-cost.gif", "Sploinky Yoinky"));
        add(new Image("https://c.tenor.com/y0tNqpVBR9AAAAAd/thanos-avengers.gif", "Thanos, The Mad Titan"));
        add(new Image("https://c.tenor.com/J3qLu0yobXYAAAAC/thanos-philosophy.gif", "Strongest Will"));
        add(new Image("https://c.tenor.com/5bnBHE0rvtgAAAAC/infinity-war-avengers.gif", "~Everything..."));
    }
}
