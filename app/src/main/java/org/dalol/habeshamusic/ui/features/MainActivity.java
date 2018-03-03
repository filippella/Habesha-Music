package org.dalol.habeshamusic.ui.features;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;

import org.dalol.habeshamusic.R;

import java.util.LinkedList;
import java.util.Random;

/**
 * Created by filippo on 13/01/2018.
 */

public class MainActivity extends AppCompatActivity {


    private LinkedList<String> imageSources = new LinkedList<>();
    private ImageView imageView;
    private ImageView imageView2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar seekBar = findViewById(R.id.slider_player_progress);

        seekBar.setSecondaryProgress(50);

        imageView = findViewById(R.id.image_example);
        imageView2 = findViewById(R.id.image_singer_avatar);

        TextView tv = findViewById(R.id.text_song_name);
        tv.setSelected(true);
        tv.setSingleLine();

//        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) seekBar.getLayoutParams();
//        params.setMargins(0, 0, 0, 0);
//        seekBar.setPadding(0, 0, 0, 0);

        findViewById(R.id.button_play).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MusicDashboardActivity.class));
            }
        });

        imageSources.clear();
        imageSources.add("http://www.huluzefen.com/assets/images/genres/Newest-Playlists.jpg");
        imageSources.add("http://www.huluzefen.com/assets/images/genres/Amharic.jpg");
        imageSources.add("http://www.huluzefen.com/assets/images/genres/Oromigna.jpg");
        imageSources.add("http://www.huluzefen.com/assets/images/genres/Tigrigna.jpg");
        imageSources.add("http://www.huluzefen.com/assets/images/genres/Eritrean.jpg");
        imageSources.add("http://www.huluzefen.com/assets/images/genres/Gonder.jpg");
        imageSources.add("http://www.huluzefen.com/assets/images/genres/Gojam.jpg");
        imageSources.add("http://www.huluzefen.com/assets/images/genres/Wollo.jpg");
        imageSources.add("http://www.huluzefen.com/assets/images/genres/Ethio-Reggae.jpg");
        imageSources.add("http://www.huluzefen.com/assets/images/genres/Ethio-Traditional.jpg");
        imageSources.add("http://www.huluzefen.com/assets/images/genres/Ethiopiques.jpg");
        imageSources.add("http://www.huluzefen.com/assets/images/genres/Ethio-Jazz.jpg");
        imageSources.add("http://www.huluzefen.com/assets/images/genres/Blues.jpg");
        imageSources.add("http://www.huluzefen.com/assets/images/genres/Ethio-Folk.jpg");
        imageSources.add("http://www.huluzefen.com/assets/images/genres/Ethiopian-Somali.jpg");
        imageSources.add("http://www.huluzefen.com/assets/images/genres/Afar.jpg");
        imageSources.add("http://www.huluzefen.com/assets/images/genres/Guragigna.jpg");
        imageSources.add("http://www.huluzefen.com/assets/images/genres/Kunama.jpg");
        imageSources.add("http://www.huluzefen.com/assets/images/genres/Harari.jpg");
        imageSources.add("http://www.huluzefen.com/assets/images/genres/Tizita-Playlist.jpg");
        imageSources.add("http://www.huluzefen.com/assets/images/genres/Ethio-HipHop.jpg");



        //No Image yet
//        imageSources.add("http://www.huluzefen.com/assets/images/genres/Instrumental.jpg");
        imageSources.add("http://www.huluzefen.com/assets/images/album-no-image.png");

        imageSources.add("http://www.huluzefen.com/assets/images/genres/Spiritual.jpg");
        imageSources.add("http://www.huluzefen.com/assets/images/genres/Wedding.jpg");
        imageSources.add("http://www.huluzefen.com/assets/images/genres/Holiday.jpg");
        imageSources.add("http://www.huluzefen.com/assets/images/genres/Bands.jpg");
        imageSources.add("http://www.huluzefen.com/assets/images/genres/Classical.jpg");


    }

    @Override
    protected void onResume() {
        super.onResume();

        Glide.with(this)
                .load(imageSources.get(new Random().nextInt(imageSources.size())))
                .transition(DrawableTransitionOptions.withCrossFade())
                .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.ALL))
                .apply(RequestOptions.placeholderOf(R.color.colorLightBlue))
                .into(imageView);

        Glide.with(this)
                .load(imageSources.get(new Random().nextInt(imageSources.size())))
                .transition(DrawableTransitionOptions.withCrossFade())
                .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.ALL))
                .apply(RequestOptions.placeholderOf(R.color.colorLightBlue))
                .into(imageView2);
    }
}
