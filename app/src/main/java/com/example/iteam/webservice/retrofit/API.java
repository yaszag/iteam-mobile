package com.example.iteam.webservice.retrofit;

import com.example.iteam.payload.EventsResponse;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface API {

    @Headers({
            "Accept: application/json",
    })

    @GET("event")
    Observable<List<EventsResponse>> find_all_events();
}
