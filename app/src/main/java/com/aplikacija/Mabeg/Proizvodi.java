package com.aplikacija.Mabeg;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.smarteist.autoimageslider.SliderLayout;
import com.smarteist.autoimageslider.SliderView;

public class Proizvodi extends AppCompatActivity {

    SliderLayout sliderLayout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proizvodi);


        sliderLayout = findViewById(R.id.imageSlider);
        sliderLayout.setIndicatorAnimation(SliderLayout.Animations.DROP); //set indicator animation by using SliderLayout.Animations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderLayout.setScrollTimeInSec(500000); //set scroll delay in seconds :

        setSliderViews();
    }

    private void setSliderViews() {

        int duzina=13;
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
                    sliderView.setDescription("Hot stamp folija za datumare");
                    sliderView.setImageDrawable( R.drawable.ribon);
                    break;
                case 6:
                    sliderView.setDescription("Samolepljive etikete");
                    sliderView.setImageDrawable( R.drawable.mabeg_rolna);
                    break;
                case 7:
                    sliderView.setDescription("Termaltransfer riboni");
                    sliderView.setImageDrawable( R.drawable.ribon_tata);
                    break;
                case 8:
                    sliderView.setDescription("Ušivne tekstilne trake i care label riboni");
                    sliderView.setImageDrawable( R.drawable.sve);
                    break;
                case 9:
                    sliderView.setDescription("Etikete na A4 papiru");
                    sliderView.setImageDrawable(R.drawable.a4);
                    break;
                case 10:
                    sliderView.setDescription("Ušivna etiketa");
                    sliderView.setImageDrawable( R.drawable.mabegtraka);
                    break;
                case 11:
                    sliderView.setDescription("Etikete za specijalnu namenu");
                    sliderView.setImageDrawable(R.drawable.posebnaetiketa);
                    break;
                case 12:
                    sliderView.setDescription("Ušivne tekstilne trake");
                    sliderView.setImageDrawable(  R.drawable.traka2);
                    break;
                case 13:
                    sliderView.setDescription("Datumar HP-30");
                    sliderView.setImageDrawable( R.drawable.hp_30);
                    break;

                default:
                    sliderView.setDescription("Proizvod");

            }

            sliderView.setImageScaleType(ImageView.ScaleType.FIT_CENTER);


            final int finalI = i;
            //sliderView.setOnSliderClickListener(new SliderView.OnSliderClickListener() {
             //   @Override
               // public void onSliderClick(SliderView sliderView) {
           //         Toast.makeText(Proizvodi.this, "This is slider " + (finalI + 1), Toast.LENGTH_SHORT).show();
           //     }
           // });

            //at last add this view in your layout :
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

}