package demo.myapplication.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AppDataServices {
   private static AppDataWebServices service;
    public static AppDataWebServices getService(){
        if(service == null){
            Gson gson = new GsonBuilder()
                    .create();
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://simplifiedcoding.net/")
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
             service = retrofit.create(AppDataWebServices.class);
        }
        return service;
    }

}
