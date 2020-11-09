package com.aplikacija.Mabeg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import java.util.Calendar;
import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;

public class Pomoc  extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Element adsElement = new Element();
        String mystring = getResources().getString(R.string.article_text);

        View aboutPage = new AboutPage(this)
                .isRTL(false)
                .setImage(R.drawable.providni_logo)
                .setDescription(mystring)
                .addItem(Povratakumeni())
                .addItem(getCopyRightsElement())
                .create();

        setContentView(aboutPage);
    }


    Element getCopyRightsElement() {
        Element copyRightsElement = new Element();
        final String copyrights = String.format(getString(R.string.copy_right));
        copyRightsElement.setTitle(copyrights);
        copyRightsElement.setGravity(Gravity.CENTER);
        copyRightsElement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Pomoc.this, copyrights, Toast.LENGTH_SHORT).show();
            }
        });
        return copyRightsElement;
    }

    Element Povratakumeni() {
        Element copyRightsElement = new Element();
        final String meni = String.format(getString(R.string.povratak));
        copyRightsElement.setTitle(meni);
        copyRightsElement.setGravity(Gravity.LEFT);
        copyRightsElement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iinent= new Intent(Pomoc.this,MainActivity.class);
                startActivity(iinent);
            }
        });
        return copyRightsElement;
    }
}