package com.aplikacija.Mabeg;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;
import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;

public class O_nama extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {

                super.onCreate(savedInstanceState);

                Element adsElement = new Element();
                String mystring = getResources().getString(R.string.o_nama);

                View aboutPage = new AboutPage(this)
                        .isRTL(false)
                        .setImage(R.drawable.providni_logo)
                       // .addItem(new Element().setTitle("Verzija 1.1"))
                        .setDescription(mystring)
                       // .addItem(adsElement)
                        .addGroup("Umrežite se sa nama!")
                        .addEmail("office@mabeg.rs","Kontaktirajte nas putem mejla")
                        .addWebsite("http://www.mabeg.rs/","Posetite naš vebsajt")
                        .addYoutube("UC6-vI1kHD8Imm5ND_QvLsIQ","Posetite naš youtube kanal")
                        .addInstagram("mabeg_doo/?hl=sr","Posetite naš instagram profil")
                        .addFacebook("mabegfirma","Posetite naš facebook profil")
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
                                Toast.makeText(O_nama.this, copyrights, Toast.LENGTH_SHORT).show();
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
                                Intent iinent= new Intent(O_nama.this,MainActivity.class);
                                startActivity(iinent);
                        }
                });
                return copyRightsElement;
        }
}