package com.example.iteam.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.iteam.entity.Event;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;

@Dao
public interface EventDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    Completable insert(Event event);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable insertAllEvents(List<Event> eventList);

    @Query("SELECT * FROM Event")
    LiveData<Event> getEvents();
}
