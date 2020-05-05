package com.example.chienmusic.ui.playTrack;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.viewpager.widget.ViewPager;

import com.example.chienmusic.R;
import com.example.chienmusic.constant.Constant;
import com.example.chienmusic.data.model.Track;
import com.example.chienmusic.data.model.User;
import com.example.chienmusic.databinding.ActivityPlaytrackBinding;
import com.google.android.material.tabs.TabLayout;

public class PlayTrackActivity extends AppCompatActivity {
    private ActivityPlaytrackBinding mBinding;

    private static ViewPagerAdapter sViewPagerAdapter;

    private ViewPager mViewPager;
    private TabLayout mTabLayout;

    private Track mTrack;
    private User mUser;

    private TextView mTextTittleTrack;
    private TextView mTextNameArtist;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(
                this,
                R.layout.activity_playtrack
        );
        initViews();
        getData();
        customViewPager();
        setDataToViewPager();
    }

    private void setDataToViewPager() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

            }
        }, Constant.EVENT_DELAY);
    }

    private void customViewPager() {

    }

    private void getData() {
        Bundle bundle = getIntent().getExtras();
        mTrack = bundle.getParcelable(Constant.BUNDLE_TRACK);
        mUser = bundle.getParcelable(Constant.BUNDLE_USER);
        mTextTittleTrack.setText(mTrack.getTitle());
        mTextNameArtist.setText(mUser.getName());
    }

    private void initViews() {
        mViewPager = mBinding.viewPagerTrack;
        mTextTittleTrack = mBinding.titleSongPlay;
        mTextNameArtist = mBinding.singerPlay;
        mTabLayout = mBinding.tabs;
    }

    public static Intent getIntent(Context context) {
        Intent intent = new Intent(context, PlayTrackActivity.class);
        return intent;
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}
