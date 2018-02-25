package com.example.android.RerySuryani_1202154358_Modul3;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class Detail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_detail);

        TextView mainTitle = (TextView) findViewById(R.id.titleDetail);
        ImageView mainImage = (ImageView) findViewById(R.id.ImageDetail);

        Drawable drawable = ContextCompat.getDrawable(this, getIntent().getIntExtra(Main.IMAGE_KEY, 0));

        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.GRAY);

        if (drawable != null){
            gradientDrawable.setSize(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        mainTitle.setText(getIntent().getStringExtra(Main.TITLE_KEY));

        Glide.with(this).load(getIntent().getIntExtra(Main.IMAGE_KEY, 0)).placeholder(gradientDrawable).into(mainImage);
    }
    public void IncreaseScore(View view) {
    }

    public void DecreaseScore(View view) {
    }
}
