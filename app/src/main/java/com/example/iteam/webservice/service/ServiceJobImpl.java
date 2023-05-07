package com.example.iteam.webservice.service;

import android.util.Log;

import com.example.iteam.payload.EventsResponse;

import java.util.List;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.observers.BlockingBaseObserver;
import io.reactivex.rxjava3.observers.DisposableObserver;
import io.reactivex.rxjava3.subscribers.DisposableSubscriber;
import retrofit2.HttpException;

public class ServiceJobImpl {

    private final ServiceResponse serviceResponse;
    Disposable disposable;

    public ServiceJobImpl(ServiceResponse serviceResponse) {
        this.serviceResponse = serviceResponse;
    }

    public void getEvents() {
        disposable = new ServiceJob().getEvents()
                .subscribeWith(new DisposableObserver<List<EventsResponse>>() {
                    @Override
                    public void onNext(@NonNull List<EventsResponse> eventsResponseList) {
                        Log.d("TAG", "onSuccess: " + eventsResponseList.size());
                        serviceResponse.onEventsSuccess(eventsResponseList);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        if (e instanceof HttpException) {
                            try {
                                HttpException error = (HttpException) e;
                                Log.d("TAG", "onError*: " + "/ " + error.code());
                            } catch (Exception exception) {
                                exception.printStackTrace();
                                Log.e("TAG", "onError**: " + "/ " + e.getMessage());
                            }
                        } else {
                            Log.e("TAG", "onError: " + "/ " + e.getMessage());
                        }
                    }

                    @Override
                    public void onComplete() {
                        Log.d("TAG", "onComplete: ");
                    }
                });
    }
}
