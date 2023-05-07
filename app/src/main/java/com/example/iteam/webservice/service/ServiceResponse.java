package com.example.iteam.webservice.service;

import com.example.iteam.payload.EventsResponse;

import java.util.List;

public interface ServiceResponse {

    void onEventsSuccess(List<EventsResponse> eventsResponseList);
}
