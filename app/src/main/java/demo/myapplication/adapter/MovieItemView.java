package demo.myapplication.adapter;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import demo.myapplication.MainActivity;
import demo.myapplication.model.Movie;

public class MovieItemView{
    TextView itemName;
    ImageView imgIcon;
    Button btnDetail;
    public void updateData(Movie movie, MainActivity.OnMoviesItemClick onMoviesItemClick){
        itemName.setText(movie.getName());
        if(!movie.getImageurl().isEmpty()){
            Picasso.get().load(movie.getImageurl()).into(imgIcon);
        }
        btnDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               onMoviesItemClick.onMoviesClick(movie);
            }
        });
    }
}
