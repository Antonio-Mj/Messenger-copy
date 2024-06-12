package com.example.messenger;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private List<ListElement> elements;
    private Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConstraintLayout constraintLayout = findViewById(R.id.main);
        CardView cardView = findViewById(R.id.cardView);
        setThemeColors(constraintLayout, cardView);

        initRecyclerView();
    }

    private void setThemeColors(ConstraintLayout constraintLayout, CardView cardView) {
        int nightModeFlags = getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;
        int backgroundColor = nightModeFlags == Configuration.UI_MODE_NIGHT_YES ?
                R.color.colorBackgroundDark : R.color.colorBackgroundLight;
        int cardBackgroundColor = nightModeFlags == Configuration.UI_MODE_NIGHT_YES ?
                R.color.gris_oscurodos : R.color.gris_claro;

        constraintLayout.setBackgroundColor(getResources().getColor(backgroundColor));
        cardView.setCardBackgroundColor(getResources().getColor(cardBackgroundColor));
    }

    private void initRecyclerView() {
        elements = new ArrayList<>();
        random = new Random();

        populateListElements();

        ListAdapter listAdapter = new ListAdapter(elements, this);
        RecyclerView recyclerView = findViewById(R.id.listRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdapter);
    }

    private void populateListElements() {
        elements.add(new ListElement("Mary Serrano❤️", truncateMessage("Te amo 3M❤️"), generateRandomTimeOrDay(), R.drawable.mary));
        elements.add(new ListElement("Luis Angel", truncateMessage("Que tranza mi hermano"), generateRandomTimeOrDay(), R.drawable.luisillo));
        elements.add(new ListElement("Rafael Murrieta", truncateMessage("Nah we, date"), generateRandomTimeOrDay(), R.drawable.rafa));
        elements.add(new ListElement("Edgar Rojas", truncateMessage("Cubitos?"), generateRandomTimeOrDay(), R.drawable.eddy));
        elements.add(new ListElement("Nezareth Mejia", truncateMessage("Que onda men🤙"), generateRandomTimeOrDay(), R.drawable.neza));
        elements.add(new ListElement("Metzi Camacho", truncateMessage("Hola amix"), generateRandomTimeOrDay(), R.drawable.metzi));
        elements.add(new ListElement("Aram Esquivel", truncateMessage("Tú: Aram samsam "), generateRandomTimeOrDay(), R.drawable.aramsamsam));
        elements.add(new ListElement("Humberto Mejia", truncateMessage("Vas al oxxo?, por favor"), generateRandomTimeOrDay(), R.drawable.humberto));
        elements.add(new ListElement("Rocio Medina", truncateMessage("Te habla tu papá"), generateRandomTimeOrDay(), R.drawable.mama));
        elements.add(new ListElement("Elizabeth Mejia", truncateMessage("Tu: A donde vas?"), generateRandomTimeOrDay(), R.drawable.eli));
        elements.add(new ListElement("Ana MedVall", truncateMessage("Vamos a vernos jajja"), generateRandomTimeOrDay(), R.drawable.ana));
        elements.add(new ListElement("Nancy Yeraldi", truncateMessage("Está mal eso Antonio🤬"), generateRandomTimeOrDay(), R.drawable.nancy));
        elements.add(new ListElement("Alee Prz", truncateMessage("Hola tio"), generateRandomTimeOrDay(), R.drawable.ale));
    }

        private String truncateMessage(String message) {
            int maxLength = 32;
            return message.length() > maxLength ? message.substring(0, maxLength - 3) + "..." : message;
        }

    private String generateRandomTimeOrDay() {
        boolean generateTime = random.nextBoolean();

        if (generateTime) {
            int hour = random.nextInt(12) + 1;
            int minute = random.nextInt(60);
            String amPm = random.nextBoolean() ? "AM" : "PM";
            return String.format("%02d:%02d %s", hour, minute, amPm);
        } else {
            String[] daysOfWeek = {"Dom", "Lun", "Mar", "Mié", "Jue", "Vie", "Sáb"};
            return daysOfWeek[random.nextInt(daysOfWeek.length)];
        }
    }

}
