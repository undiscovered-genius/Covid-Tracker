package com.example.coronatracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.GridLayout;

import java.util.ArrayList;
import java.util.List;

public class PrecautionActivity extends AppCompatActivity {

    List<String> title;
    List<Integer> image;
    RecyclerView preview;
    HomeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_precaution);

        title = new ArrayList<>();
        image = new ArrayList<>();
        preview = findViewById(R.id.preView);

        title.add("Wear a protective Mask");
        title.add("Wear medical Gloves");
        title.add("Keep atleast 2m distance from others");
        title.add("Wash your hands frequently, at least for 20sec");
        title.add("Avoid touching your eyes, nose & mouth with hands");
        title.add("Cover when you cough or sneeze with a tissue");
        title.add("Avoid crowded places and close contact with anyone that has fever");
        title.add("Disinfect frequently touched objects and surfaces");
        title.add("Stay at home if you feel unwell");
        title.add("Seek medical care early if you have diffuclty in breathing");
        title.add("Don't panic, & get information from trusted sources");
        image.add(R.drawable.mask);
        image.add(R.drawable.gloves);
        image.add(R.drawable.social);
        image.add(R.drawable.hand);
        image.add(R.drawable.touch);
        image.add(R.drawable.tissue);
        image.add(R.drawable.crowd);
        image.add(R.drawable.spray);
        image.add(R.drawable.stay1);
        image.add(R.drawable.doctor);
        image.add(R.drawable.panic);

        adapter = new HomeAdapter(this,title,image);

        GridLayoutManager layoutManager = new GridLayoutManager(this,1,GridLayoutManager.VERTICAL,false);
        preview.setLayoutManager(layoutManager);
        preview.setAdapter((RecyclerView.Adapter) adapter);
    }
}