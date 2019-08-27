package demo.myapplication.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

import demo.myapplication.MainActivity;
import demo.myapplication.R;
import demo.myapplication.model.Movie;

public class MovieAdapter extends ArrayAdapter<Movie> {
    List<Movie> listMovies;
    MainActivity.OnMoviesItemClick itemClick;
    public MovieAdapter(@NonNull Context context, int resource,MainActivity.OnMoviesItemClick itemClick) {
        super(context, resource);
        this.itemClick = itemClick;
        listMovies = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return listMovies.size();
    }

    public void setListMovies(List<Movie> listMovies) {
        this.listMovies = listMovies;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        MovieItemView movieItemView;
        if (convertView == null) {
            movieItemView = new MovieItemView();
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_view_holder, parent, false);
            movieItemView.itemName = convertView.findViewById(R.id.tv_name);
            movieItemView.imgIcon = convertView.findViewById(R.id.img_icon);
            movieItemView.btnDetail = convertView.findViewById(R.id.btnDetail);
            convertView.setTag(movieItemView);
        } else {
            movieItemView = (MovieItemView) convertView.getTag();
        }
        movieItemView.updateData(listMovies.get(position),itemClick);
        return convertView;
    }
}
