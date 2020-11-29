package com.aplikacija.Mabeg;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
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
        getSupportActionBar().hide();
    }


    public void proizvodi(View view) {
        Intent intent = new Intent(view.getContext(), Proizvodi.class);
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
            AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
            alertDialog.setTitle("Konektujte se na internet");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();
        }
    }

    public void oNama(View view) {
        Intent intent = new Intent(view.getContext(), O_nama.class);
        view.getContext().startActivity(intent);
    }

    public void pomoc(View view) {
        Intent intent = new Intent(view.getContext(), Pomoc.class);
        view.getContext().startActivity(intent);
    }

    public void mapa(View view) {
        if(isConnected()){
            Intent intent = new Intent(view.getContext(), MapsActivity.class);
            view.getContext().startActivity(intent);

        }else {
            AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
            alertDialog.setTitle("Konektujte se na internet");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();
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