    package com.aplikacija.Mabeg;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.smarteist.autoimageslider.SliderLayout;
import com.smarteist.autoimageslider.SliderView;

public class Proizvodi extends AppCompatActivity {

    SliderLayout sliderLayout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proizvodi);
        displaySnackbar();


        sliderLayout = findViewById(R.id.imageSlider);
        sliderLayout.setIndicatorAnimation(SliderLayout.Animations.DROP); //set indicator animation by using SliderLayout.Animations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderLayout.setScrollTimeInSec(500000); //set scroll delay in seconds :

        setSliderViews();
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
                startActivity(new Intent(Proizvodi.this, IstorijaPorudzbina.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setSliderViews() {

        int duzina=14;
        for (int i = 0; i <= duzina; i++) {

            SliderView sliderView = new SliderView(this);

            switch (i) {
                case 0:
                    sliderView.setDescription("Komplet etiketa sa ribonom");
                    sliderView.setImageDrawable(R.drawable.komplet);
                    break;
                case 1:
                    sliderView.setDescription("CL-E 321-Štampač samolepljivih etiketa");
                    sliderView.setImageDrawable(R.drawable.cle321);
                    break;
                case 2:
                    sliderView.setDescription("CL-S 631-Štampač ušivnih etiketa");
                    sliderView.setImageDrawable(R.drawable.cl631);
                    break;
                case 3:
                    sliderView.setDescription("CL-S 631II-Nova serija");
                    sliderView.setImageDrawable(R.drawable.mabeg_stampac);
                    break;
                case 4:
                    sliderView.setDescription("CL-S 621-Štampač deklaracija za široke formate");
                    sliderView.setImageDrawable( R.drawable.stampac_621);
                    break;
                case 5:
                    sliderView.setDescription("CL-E 730-Štampač deklaracija i ušivnih etiketa");
                    sliderView.setImageDrawable( R.drawable.nov_stampac);
                    break;
                case 6:
                    sliderView.setDescription("Hot stamp folija za datumare");
                    sliderView.setImageDrawable( R.drawable.ribon);
                    break;
                case 7:
                    sliderView.setDescription("Samolepljive etikete");
                    sliderView.setImageDrawable( R.drawable.mabeg_rolna);
                    break;
                case 8:
                    sliderView.setDescription("Termaltransfer riboni");
                    sliderView.setImageDrawable( R.drawable.ribon_tata);
                    break;
                case 9:
                    sliderView.setDescription("Ušivne tekstilne trake i care label riboni");
                    sliderView.setImageDrawable( R.drawable.sve);
                    break;
                case 10:
                    sliderView.setDescription("Etikete na A4 papiru");
                    sliderView.setImageDrawable(R.drawable.a4_etikete);
                    break;
                case 11:
                    sliderView.setDescription("Ušivna etiketa");
                    sliderView.setImageDrawable( R.drawable.mabegtraka);
                    break;
                case 12:
                    sliderView.setDescription("Etikete za specijalnu namenu");
                    sliderView.setImageDrawable(R.drawable.posebnaetiketa);
                    break;
                case 13:
                    sliderView.setDescription("Ušivne tekstilne trake");
                    sliderView.setImageDrawable(  R.drawable.traka2);
                    break;
                case 14:
                    sliderView.setDescription("Datumar HP-30");
                    sliderView.setImageDrawable( R.drawable.hp_30);
                    break;

                default:
                    sliderView.setDescription("Proizvod");

            }

            sliderView.setImageScaleType(ImageView.ScaleType.FIT_CENTER);


            final int finalI = i;
            sliderView.setOnSliderClickListener(new SliderView.OnSliderClickListener() {
               @Override
                public void onSliderClick(SliderView sliderView) {
                   switch (finalI){
                       case 0:
                           if(isConnected()){
                               Intent myIntent = new Intent(Proizvodi.this, Komplet.class);
                               startActivity(myIntent);

                           }else {
                               AlertDialog.Builder builder = new AlertDialog.Builder(Proizvodi.this,R.style.DialogeTheme);
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
                           break;
                       case 1:
                           if(isConnected()){
                               Intent myIntent = new Intent(Proizvodi.this, Cle321.class);
                               startActivity(myIntent);

                           }else {
                               AlertDialog.Builder builder = new AlertDialog.Builder(Proizvodi.this,R.style.DialogeTheme);
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
                           break;
                       case 2:
                           if(isConnected()){
                               Intent myIntent = new Intent(Proizvodi.this, Cls631.class);
                               startActivity(myIntent);

                           }else {
                               AlertDialog.Builder builder = new AlertDialog.Builder(Proizvodi.this,R.style.DialogeTheme);
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
                           break;

                           case 3:
                           if(isConnected()){
                           Intent myIntent = new Intent(Proizvodi.this, Cls631.class);
                           startActivity(myIntent);

                       }else {
                               AlertDialog.Builder builder = new AlertDialog.Builder(Proizvodi.this,R.style.DialogeTheme);
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
                           break;
                       case 4:
                           if(isConnected()){
                               Intent myIntent = new Intent(Proizvodi.this, Cls621.class);
                               startActivity(myIntent);

                           }else {
                               AlertDialog.Builder builder = new AlertDialog.Builder(Proizvodi.this,R.style.DialogeTheme);
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
                           break;

                       case 5:
                           if(isConnected()){
                               Intent myIntent = new Intent(Proizvodi.this, Cle730.class);
                               startActivity(myIntent);

                           }else {
                               AlertDialog.Builder builder = new AlertDialog.Builder(Proizvodi.this,R.style.DialogeTheme);
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
                           break;
                       case 6:
                           if(isConnected()){
                               Intent myIntent = new Intent(Proizvodi.this, Hotstamp.class);
                               startActivity(myIntent);

                           }else {
                               AlertDialog.Builder builder = new AlertDialog.Builder(Proizvodi.this,R.style.DialogeTheme);
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
                           break;
                       case 7:
                           if(isConnected()){
                               Intent myIntent = new Intent(Proizvodi.this, SamolepljiveEtikete.class);
                               startActivity(myIntent);

                           }else {
                               AlertDialog.Builder builder = new AlertDialog.Builder(Proizvodi.this,R.style.DialogeTheme);
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
                           break;
                       case 8:
                           if(isConnected()){
                               Intent myIntent = new Intent(Proizvodi.this, Riboni.class);
                               startActivity(myIntent);

                           }else {
                               AlertDialog.Builder builder = new AlertDialog.Builder(Proizvodi.this,R.style.DialogeTheme);
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
                           break;
                       case 9:
                           if(isConnected()){
                               Intent myIntent = new Intent(Proizvodi.this, Textil.class);
                               startActivity(myIntent);

                           }else {
                               AlertDialog.Builder builder = new AlertDialog.Builder(Proizvodi.this,R.style.DialogeTheme);
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
                           break;
                       case 10:
                           if(isConnected()){
                               Intent myIntent = new Intent(Proizvodi.this, A4.class);
                               startActivity(myIntent);

                           }else {
                               AlertDialog.Builder builder = new AlertDialog.Builder(Proizvodi.this,R.style.DialogeTheme);
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
                           break;
                       case 11:
                           if(isConnected()){
                               Intent myIntent = new Intent(Proizvodi.this, Saten.class);
                               startActivity(myIntent);

                           }else {
                               AlertDialog.Builder builder = new AlertDialog.Builder(Proizvodi.this,R.style.DialogeTheme);
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
                           break;
                       case 12:
                           if(isConnected()){
                               Intent myIntent = new Intent(Proizvodi.this, SpecijalneEtikete.class);
                               startActivity(myIntent);

                           }else {
                               AlertDialog.Builder builder = new AlertDialog.Builder(Proizvodi.this,R.style.DialogeTheme);
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
                           break;
                       case 13:
                           if(isConnected()){
                               Intent myIntent = new Intent(Proizvodi.this, Najlon.class);
                               startActivity(myIntent);

                           }else {
                               AlertDialog.Builder builder = new AlertDialog.Builder(Proizvodi.this,R.style.DialogeTheme);
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
                           break;
                       case 14:
                           if(isConnected()){
                               Intent myIntent = new Intent(Proizvodi.this, Hp30.class);
                               startActivity(myIntent);

                           }else {
                               AlertDialog.Builder builder = new AlertDialog.Builder(Proizvodi.this,R.style.DialogeTheme);
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
                           break;



                   }
               }
            });

            sliderLayout.addSliderView(sliderView);
        }

        Button dugme2 = (Button) findViewById(R.id.meni);
        dugme2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), MainActivity.class);
                view.getContext().startActivity(intent);}
        });

    }

    public void displaySnackbar(){
        String poruka="Za detaljniji pregled kliknite na sliku.";
        final Snackbar snackBar = Snackbar.make(findViewById(android.R.id.content), poruka, Snackbar.LENGTH_INDEFINITE).setActionTextColor(Color.parseColor("#FFC107"));
;

        snackBar.setAction("U redu", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                snackBar.dismiss();
            }
        });
        snackBar.show();
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



}