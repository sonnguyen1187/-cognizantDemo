package demo.myapplication.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.content.Intent;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import demo.myapplication.model.Movie;
import demo.myapplication.services.AppDataServices;
import demo.myapplication.services.AppDataWebServices;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AppViewModel extends AndroidViewModel {
    AppDataWebServices repo;
    private MutableLiveData<List<Movie>> movies;
    public AppViewModel(@NonNull Application application) {
        super(application);
        repo = AppDataServices.getService();
    }
    public LiveData<List<Movie>> getMovies(){
        if(movies == null){
            movies = new MutableLiveData<>();
            getListMovies();
        }
        return movies;
    }
    private void getListMovies(){
        repo.listRepos().enqueue(new Callback<List<Movie>>() {
            @Override
            public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
                movies.postValue(response.body());
            }
            @Override
            public void onFailure(Call<List<Movie>> call, Throwable t) {
                movies.postValue(new ArrayList<Movie>());
            }
        });
    }
}
