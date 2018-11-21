package com.thinkhodl.bedshema;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

public class SettingsActivity extends AppCompatActivity {

    // Action Bar
    private Toolbar myToolbar;
    // Action Bar Title
    private TextView mToolbarTitle;

    private SeekBar mFontSeekBar;
    private TextView mParagraphTitleTextView, mParagraphSubtitleTextView, mParagraphMainTextView;

    private Button mResetFontSizeButton;
    private Button mSaveFontSizeButton;

    private RadioGroup mRadioGroup;

    private SharedPreferences mSharedPref;
    private int mThemeMode;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Context context = this;
        mSharedPref = context.getSharedPreferences(
                getString(R.string.preference_file_key),
                Context.MODE_PRIVATE);

        mThemeMode = mSharedPref.getInt(getString(R.string.saved_theme_mode),
                AppCompatDelegate.MODE_NIGHT_AUTO);

        AppCompatDelegate.setDefaultNightMode(mThemeMode);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        setActionBarItems();

        // Set the toolbar
        myToolbar = findViewById(R.id.toolbar);
        myToolbar.setTitle(getString(R.string.action_settings));
        myToolbar.setTitle("");
        setSupportActionBar(myToolbar);
        mToolbarTitle = findViewById(R.id.toolbar_title);
        mToolbarTitle.setText(R.string.action_settings);

        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_arrow_back);


        // Set the title for the Action Bar
        mToolbarTitle = findViewById(R.id.toolbar_title);

        mParagraphTitleTextView = findViewById(R.id.paragraph_title_settings);
        mParagraphSubtitleTextView = findViewById(R.id.paragraph_subtitle_settings);
        mParagraphMainTextView = findViewById(R.id.paragraph_main_settings);

        mFontSeekBar = findViewById(R.id.change_font_seekBar);
        mFontSeekBar.getProgressDrawable().setColorFilter(Color.RED, PorterDuff.Mode.SRC_IN);
        mFontSeekBar.getThumb().setColorFilter(Color.RED, PorterDuff.Mode.SRC_IN);
        mFontSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                mParagraphMainTextView.setTextSize(i);
                mParagraphTitleTextView.setTextSize((float) (i * 1.25));
                mParagraphSubtitleTextView.setTextSize((float) (i * 0.8));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        mFontSeekBar.setProgress(mSharedPref.getInt(getString(R.string.saved_font_size), 20));

        mSaveFontSizeButton = findViewById(R.id.save_button);
        mSaveFontSizeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = mSharedPref.edit();
                editor.putInt(getString(R.string.saved_font_size),
                        mFontSeekBar.getProgress()).apply();
            }
        });

        mResetFontSizeButton = findViewById(R.id.reset_button);
        mResetFontSizeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mParagraphMainTextView.setTextSize(TypedValue.COMPLEX_UNIT_PX,
                        getResources().getDimension(R.dimen.textSizeParagraphMain_default));
                mParagraphTitleTextView.setTextSize(TypedValue.COMPLEX_UNIT_PX,
                        getResources().getDimension(R.dimen.textSizeParagraphTitle_default));
                mParagraphSubtitleTextView.setTextSize(TypedValue.COMPLEX_UNIT_PX,
                        getResources().getDimension(R.dimen.textSizeParagraphSubTitle_default));
                mFontSeekBar.setProgress(20);
                SharedPreferences.Editor editor = mSharedPref.edit();
                editor.putInt(getString(R.string.saved_font_size),
                        mFontSeekBar.getProgress()).apply();
            }
        });


        mRadioGroup = findViewById(R.id.radio_theme_group);
        initateRadioButtons();
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                SharedPreferences.Editor editor = mSharedPref.edit();
                switch (i) {
                    case R.id.day_theme_radioButton:
                        editor.putInt(getString(R.string.saved_theme_mode),
                                AppCompatDelegate.MODE_NIGHT_NO).apply();
                        recreate();
                        break;

                    case R.id.night_theme_radioButton:
                        editor.putInt(getString(R.string.saved_theme_mode),
                                AppCompatDelegate.MODE_NIGHT_YES).apply();
                        recreate();
                        break;

                    case R.id.auto_radioButton:

                        editor.putInt(getString(R.string.saved_theme_mode),
                                AppCompatDelegate.MODE_NIGHT_AUTO).apply();
                        recreate();
                        break;
                }
            }
        });
    }

    /*
     * Change the Status Bar to black and removes notification icons
     */
    @RequiresApi(api = Build.VERSION_CODES.M)
    private void setActionBarItems() {
        Window window = getWindow();
        window.setStatusBarColor(getColor(R.color.colorSecondaryLight));

        View decorView = window.getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void initateRadioButtons() {
        switch (mThemeMode) {
            case AppCompatDelegate.MODE_NIGHT_NO:
                mRadioGroup.check(R.id.day_theme_radioButton);
                break;
            case AppCompatDelegate.MODE_NIGHT_YES:
                mRadioGroup.check(R.id.night_theme_radioButton);
                break;
            case AppCompatDelegate.MODE_NIGHT_AUTO:
                mRadioGroup.check(R.id.auto_radioButton);
                break;

        }
    }

    @Override
    protected void onDestroy() {
        Intent returnIntent = new Intent();
        setResult(RESULT_OK, returnIntent);
        super.onDestroy();
    }
}
