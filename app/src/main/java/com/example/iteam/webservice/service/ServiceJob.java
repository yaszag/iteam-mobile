package com.example.iteam.webservice.service;

import com.example.iteam.payload.EventsResponse;
import com.example.iteam.webservice.retrofit.WebService;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class ServiceJob {

    public Observable<List<EventsResponse>> getEvents() {
        return WebService.getInstance().getApi().find_all_events()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
