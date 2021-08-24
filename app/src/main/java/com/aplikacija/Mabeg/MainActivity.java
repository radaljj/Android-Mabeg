package com.aplikacija.Mabeg;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.smarteist.autoimageslider.SliderLayout;
import com.smarteist.autoimageslider.SliderView;

public class MainActivity extends AppCompatActivity {
    SliderLayout sliderLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       sliderLayout = findViewById(R.id.imageSlider);sliderLayout.setIndicatorAnimation(SliderLayout.Animations.FILL); //set indicator animation by using SliderLayout.Animations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
       sliderLayout.setScrollTimeInSec(2); //set scroll delay in seconds :

       setSliderViews();

        if (isFirstTime()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this, R.style.DialogeTheme);
            String mystring = getResources().getString(R.string.noviMeni);
            builder.setTitle("Navigacioni meni aplikacije");
            builder.setMessage(mystring);
            builder.setNegativeButton("U redu", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });

            builder.create().show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.email_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.istorija:
                startActivity(new Intent(MainActivity.this, IstorijaPorudzbina.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    public void proizvodi(View view) {
        Intent intent = new Intent(view.getContext(), Proizvodi.class);
        view.getContext().startActivity(intent);
    }

    public void kalkulator(View view) {
        Intent intent = new Intent(view.getContext(), Kalkulator.class);
        view.getContext().startActivity(intent);
    }

    public void naruciEmail(View view) {
        Intent intent = new Intent(view.getContext(), EmailActivity.class);
        view.getContext().startActivity(intent);
    }

    public void poziv(View view) {
        Intent intent = new Intent(view.getContext(), PozivAktivnost.class);
        view.getContext().startActivity(intent);
    }

    public void websajt(View view) {
        if(isConnected()){
            Intent Getintent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.mabeg.rs/"));
            startActivity(Getintent);

        }else {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this,R.style.DialogeTheme);
            String mystring="Konektujte se na internet";
            builder.setTitle("Greška");
            builder.setMessage(mystring);
            builder.setNegativeButton("U redu", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });

            builder.create().show();
        }
    }

    public void oNama(View view) {
        Intent intent = new Intent(view.getContext(), O_nama.class);
        view.getContext().startActivity(intent);
    }

    public void pomoc(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this,R.style.DialogeTheme);
        String mystring = getResources().getString(R.string.article_text);
        builder.setTitle("Pomoć u korišćenju apliakcije");
        builder.setMessage(mystring);
        builder.setNegativeButton("U redu", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        builder.create().show();
    }

    public void mapa(View view) {
        if(isConnected()){
            Intent intent = new Intent(view.getContext(), MapsActivity.class);
            view.getContext().startActivity(intent);

        }else {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this,R.style.DialogeTheme);
            String mystring="Konektujte se na internet";
            builder.setTitle("Greška");
            builder.setMessage(mystring);
            builder.setNegativeButton("U redu", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });

            builder.create().show();
        }
    }


    public boolean isConnected() {
        boolean connected = false;
        try {
            ConnectivityManager cm = (ConnectivityManager)getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo nInfo = cm.getActiveNetworkInfo();
            connected = nInfo != null && nInfo.isAvailable() && nInfo.isConnected();
            return connected;
        } catch (Exception e) {
            Log.e("Connectivity Exception", e.getMessage());
        }
        return connected;
    }


    private boolean isFirstTime() {
        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        boolean ranBefore = preferences.getBoolean("MainNewActivity", false);
        if (!ranBefore) {
            // first time
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("MainNewActivity", true);
            editor.commit();
        }
        return !ranBefore;
    }




    private void setSliderViews() {

        for (int i = 0; i <= 4; i++) {

            SliderView sliderView = new SliderView(this);

            switch (i) {
                case 0:
                    sliderView.setImageDrawable(R.drawable.rsz_pocetni);
                    break;
                case 1:
                    sliderView.setImageDrawable(R.drawable.rsz_stampaci_baner);
                    break;
                case 2:
                    sliderView.setImageDrawable(R.drawable.rsz_riboni_baner);
                    break;
                case 3:
                    sliderView.setImageDrawable(R.drawable.rsz_1etikete_baner);
                    break;
                case 4:
                    sliderView.setImageDrawable(R.drawable.rsz_trake_baner);
                    break;
            }


            //at last add this view in your layout :
           sliderLayout.addSliderView(sliderView);
        }

    }
}