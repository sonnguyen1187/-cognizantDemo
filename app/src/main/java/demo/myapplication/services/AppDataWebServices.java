package demo.myapplication.services;

import java.util.List;

import demo.myapplication.model.Movie;
import retrofit2.Call;
import retrofit2.http.GET;

public interface AppDataWebServices {
    @GET("demos/marvel/")
   public Call<List<Movie>> listRepos();
}
