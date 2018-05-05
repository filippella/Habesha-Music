package org.dalol.habeshamusic.ui.features;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import org.dalol.habeshamusic.R;
import org.dalol.habeshamusic.common.callback.OnBackListener;
import org.dalol.habeshamusic.data.callback.OnMusicPlayerStateListener;
import org.dalol.habeshamusic.player.HMPlayer;
import org.dalol.habeshamusic.player.MusicPlayer;
import org.dalol.habeshamusic.ui.base.BaseActivity;
import org.dalol.habeshamusic.ui.controllers.MainFragmentController;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created by filippo on 13/01/2018.
 */

public class MainActivity extends BaseActivity {

    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;
    private ActionBarDrawerToggle mDrawerToggle;

    private LinkedList<String> imageSources = new LinkedList<>();
    private ImageView imageView;
    private ImageView imageView2;
    private AdView mAdView;
    private SeekBar seekBar;

    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        showHome();

        mDrawerLayout = findViewById(R.id.mainNavigationDrawer);
        mNavigationView = findViewById(R.id.mainNavigationView);
        mAdView = findViewById(R.id.adView);

        mAdView.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
                if (mAdView.getVisibility() != View.VISIBLE) mAdView.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAdFailedToLoad(int i) {
                super.onAdFailedToLoad(i);
                showToast("Failed to load ad -> " + i);
            }
        });

        seekBar = findViewById(R.id.slider_player_progress);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    HMPlayer.INSTANCE.getMusicPlayer().seekPayer(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //seekBar.setSecondaryProgress(50);

//        imageView = findViewById(R.id.image_example);
        imageView2 = findViewById(R.id.image_singer_avatar);

        TextView tv = findViewById(R.id.text_song_name);
        tv.setSelected(true);
        tv.setSingleLine();

//        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) seekBar.getLayoutParams();
//        params.setMargins(0, 0, 0, 0);
//        seekBar.setPadding(0, 0, 0, 0);

        MusicPlayer musicPlayer = HMPlayer.INSTANCE.getMusicPlayer();
        musicPlayer.initMediaPlayer();
        musicPlayer.addOnMusicPlayerStateListener(new OnMusicPlayerStateListener() {
            @Override
            public void onSeekChanged(int currentPosition) {
                seekBar.setProgress(currentPosition);
            }

            @Override
            public void onBufferingUpdate(int percent) {
                seekBar.setSecondaryProgress(seekBar.getMax() * percent);
            }

            @Override
            public void onComplete() {

            }

            @Override
            public void onPlay(int maxDuration, String totalDuration) {
                TextView tv = findViewById(R.id.text_duration);
                tv.setText(totalDuration);
                seekBar.setMax(maxDuration);
            }

            @Override
            public void onPause() {

            }

            @Override
            public void onStop() {

            }

            @Override
            public void onProgress(int currentProgress, String elapsed) {
                seekBar.setProgress(currentProgress);
                TextView tv = findViewById(R.id.text_elapsed);
                tv.setText(elapsed);
            }
        });

        findViewById(R.id.button_play).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView iv = (ImageView) v;
                MusicPlayer player = HMPlayer.INSTANCE.getMusicPlayer();
                if (player.isPlaying()) {
                    player.pausePlaying();
                    iv.setImageResource(R.drawable.ic_play_arrow_black_24dp);
                } else {
                    player.playMusic("https://github.com/filippella/Sample-API-Files/raw/master/LHiver%20Indien%20-%20Balijo.mp3");
                    iv.setImageResource(R.drawable.ic_pause_black_24dp);
                }

                //button_play


                //startActivity(new Intent(MainActivity.this, MusicDashboardActivity.class));
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


        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.openDrawer, R.string.closeDrawer) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                invalidateOptionsMenu();
                supportInvalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                invalidateOptionsMenu();
                supportInvalidateOptionsMenu();
            }
        };
        mDrawerToggle.setDrawerIndicatorEnabled(true);
        mDrawerLayout.addDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();

        if (null == savedInstanceState) {
            replaceFragment(R.id.main_fragment_container, MainFragmentController.newInstance(), "TAG_MAIN_FRAGMENT_CONTROLLER");
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();

        mAdView.loadAd(new AdRequest.Builder().build());

//        Glide.with(this)
//                .load(imageSources.get(new Random().nextInt(imageSources.size())))
//                .transition(DrawableTransitionOptions.withCrossFade())
//                .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.ALL))
//                .apply(RequestOptions.placeholderOf(R.color.colorLightBlue))
//                .into(imageView);

        Glide.with(this)
                .load(imageSources.get(new Random().nextInt(imageSources.size())))
                .transition(DrawableTransitionOptions.withCrossFade())
                .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.ALL))
                .apply(RequestOptions.placeholderOf(R.color.colorLightBlue))
                .into(imageView2);
    }

    @Override
    public void onBackPressed() {
        List<Fragment> fragments = getSupportFragmentManager().getFragments();
        if (!fragments.isEmpty()) {
            OnBackListener onBackListener = (OnBackListener) fragments.get(0);
            if (!onBackListener.onBack()) {
                super.onBackPressed();
            }
        }
    }
}
