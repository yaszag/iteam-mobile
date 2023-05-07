package com.example.iteam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.iteam.adapter.EventAdapter;
import com.example.iteam.database.EventDao;
import com.example.iteam.database.EventRepository;
import com.example.iteam.entity.Event;
import com.example.iteam.payload.EventsResponse;
import com.example.iteam.webservice.service.ServiceJobImpl;
import com.example.iteam.webservice.service.ServiceResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity implements ServiceResponse {

    RecyclerView recyclerView;
    private EventRepository eventRepository;
    private ServiceJobImpl serviceJob;
    private EventAdapter eventAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        eventAdapter = new EventAdapter();
        recyclerView.setAdapter(eventAdapter);

        eventRepository = new EventRepository(this);
        serviceJob = new ServiceJobImpl(this);
        serviceJob.getEvents();

    }

    private void init() {
        recyclerView = findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
    }

    @Override
    public void onEventsSuccess(List<EventsResponse> eventsResponseList) {
        Log.e("TAG", "onEventsSuccess: " + eventsResponseList.size());

        List<Event> eventList = eventsResponseList.stream()
                .map(eventsResponse -> new Event(
                        eventsResponse.getId(),
                        eventsResponse.getTitle(),
                        eventsResponse.getDescription(),
                        eventsResponse.getDate(),
                        eventsResponse.getOrganizer()
                ))
                .collect(Collectors.toList());
        eventAdapter.setList(eventList);
        eventRepository.insertEvents(eventList);
    }
}