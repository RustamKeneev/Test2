package com.onlineapteka.test.App;

import android.app.Application;

import androidx.room.Room;

import com.onlineapteka.test.repository.IRepository;
import com.onlineapteka.test.repository.Repository;
import com.onlineapteka.test.repository.remote.ApiClient;
import com.onlineapteka.test.repository.remote.IApiClient;

public class App extends Application {

    public static IRepository repository;
    private static IApiClient apiClient;

    @Override
    public void onCreate() {
        super.onCreate();
        apiClient = new ApiClient();
        repository = new Repository(apiClient);
    }

}
