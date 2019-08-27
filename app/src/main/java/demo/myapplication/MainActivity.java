package demo.myapplication;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import demo.myapplication.adapter.MovieAdapter;
import demo.myapplication.model.Movie;
import demo.myapplication.viewmodel.AppViewModel;

import static demo.myapplication.DetailsActivity.EXT_INTENT_URL;

public class MainActivity extends AppCompatActivity{
    AppViewModel appViewModel;
    ListView listView;
    MovieAdapter movieAdapter;
    OnMoviesItemClick itemClick;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView)findViewById(R.id.listItem);
        itemClick = new OnMoviesItemClick() {
            @Override
            public void onMoviesClick(Movie movie) {
                navigateToDetails(movie);
            }
        };
        movieAdapter = new MovieAdapter(this,R.layout.item_view_holder,itemClick);
        listView.setAdapter(movieAdapter);
        appViewModel = ViewModelProviders.of(this).get(AppViewModel.class);
        updateData();

    }
    public void updateData(){
        appViewModel.getMovies().observe(this,movieList -> {
            movieAdapter.setListMovies(movieList);
            movieAdapter.notifyDataSetChanged();
        });
    }

    public void navigateToDetails(Movie movie){
        Intent intent = new Intent(this,DetailsActivity.class);
        Bundle bundle= new Bundle();
        bundle.putString(EXT_INTENT_URL,movie.getImageurl());
        intent.putExtras(bundle);
        startActivity(intent);
    }


    public interface OnMoviesItemClick{
        void onMoviesClick(Movie movie);
    }
}
