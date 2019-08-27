package demo.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class DetailsActivity extends Activity {
    public static final String EXT_INTENT_URL= "url";
    ImageView imageView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        imageView = findViewById(R.id.imgContent);
        String url = getIntent().getExtras().getString(EXT_INTENT_URL);
        if(!url.isEmpty()){
            Picasso.get().load(url).into(imageView);
        }


    }
}
