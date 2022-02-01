package com.example.okcredit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.okcredit.adapter.foodadapter;
import com.example.okcredit.model.Meal;
import com.example.okcredit.viewmodel.IngreidentsViewModel;
import com.example.okcredit.viewmodel.MainViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IngereidentsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private foodadapter foodadapter;
    private List<Meal> mealList = new ArrayList<>();
    IngreidentsViewModel mainViewModel;
    LinearLayoutManager layoutManager;

    private ImageView imageViewMain;
    private TextView textView;
    private TextView catText;
    private LinearLayout ingr;
    private TextView instructions;
    private String value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingereidents);

        Toolbar toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        Intent intent = getIntent();
        value = intent.getStringExtra("key"); //if it's a string you store

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        intialization();
    }

    private void intialization(){
        imageViewMain = findViewById(R.id.imageViewMain);
        textView = findViewById(R.id.name);
        catText = findViewById(R.id.cat);

        ingr = findViewById(R.id.ingr);
        instructions = findViewById(R.id.instructions);



        mainViewModel = new ViewModelProvider(this).get(IngreidentsViewModel.class);

        mainViewModel.getResponseLiveData(value).observe(this, response ->
        {
            if(response != null)
            {
                HashMap<String, String> map = response.getIngridients().get(0).getMap();

                Glide.with(getApplicationContext()).load(response.getIngridients().get(0).getStrMealThumb()).into(imageViewMain);

                textView.setText(response.getIngridients().get(0).getStrMeal());

                catText.setText(response.getIngridients().get(0).getStrCategory());

                TextView v = new TextView(getApplicationContext());
                v.setTextAppearance(R.style.TextAppearance_AppCompat_Body2);
                v.setText("Ingreidents \t : \t Quantity");

                ingr.addView(v);

                for(Map.Entry<String, String> e : map.entrySet())
                {
                    TextView v1 = new TextView(getApplicationContext());
                    v.setTextAppearance(R.style.TextAppearance_AppCompat_Body2);
                    v1.setText(e.getKey() + "\t : \t" + e.getValue());
                    ingr.addView(v1);
                }

                instructions.setText(response.getIngridients().get(0).getStrInstructions());
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}