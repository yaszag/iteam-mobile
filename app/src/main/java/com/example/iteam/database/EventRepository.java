package com.example.iteam.database;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;

import com.example.iteam.entity.Event;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class EventRepository {

    private final EventDao eventDao;
    private final LiveData<Event> eventsLiveData;

    public EventRepository(Context context) {
        IteamRoomDatabase db = IteamRoomDatabase.getDatabase(context);
        this.eventDao = db.eventDao();
        eventsLiveData = this.eventDao.getEvents();
    }

    public void insertEvents(List<Event> events) {
        eventDao.insertAllEvents(events)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onComplete() {
                        Log.e("TAG", "onComplete: save Events Success");
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.e("TAG", "save Events Fail: " + e.getMessage());
                    }
                });
    }

    public LiveData<Event> getEvents() {
        return eventsLiveData;
    }
}
