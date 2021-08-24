package com.aplikacija.Mabeg;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.util.ArrayList;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;


public class EmailActivity extends AppCompatActivity {
    EditText txtMessage;
    DatabaseHelper myDB;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);
        myDB = new DatabaseHelper(this);

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
                startActivity(new Intent(EmailActivity.this, IstorijaPorudzbina.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onClick(View view){

        EditText txtTo = (EditText) findViewById(R.id.sendTo);
        EditText txtSubject = (EditText) findViewById(R.id.subjectTo);
        EditText txtImeFirme = (EditText) findViewById(R.id.imeFirme);
        EditText txtKontakt = (EditText) findViewById(R.id.kontaktTelefon);
        EditText txtAdresa = (EditText) findViewById(R.id.adresaFirme);
        final RadioGroup rg = (RadioGroup) findViewById(R.id.rg);
         txtMessage = (EditText) findViewById(R.id.messageTo);
        String[] to = {txtTo.getText().toString()};



        int selectedRadioButtonID = rg.getCheckedRadioButtonId();
        if (selectedRadioButtonID == -1 ||txtSubject.getText().toString().length() == 0 || txtMessage.getText().toString().length() == 0 || txtImeFirme.getText().toString().length() == 0 || txtAdresa.getText().toString().length() == 0|| txtKontakt.getText().toString().length() == 0) {

            displaySnackbar();
        }
        else{
            RadioButton selectedRadioButton = (RadioButton) findViewById(selectedRadioButtonID);
            String selectedRadioButtonText = selectedRadioButton.getText().toString();

            String imeFirme = txtImeFirme.getText().toString();
            String kontakt = txtKontakt.getText().toString();
            String adresa = txtAdresa.getText().toString();
            txtMessage.append("\n\nIme firme je : " + imeFirme);
            txtMessage.append("\nAdresa firme je : " + adresa);
            txtMessage.append("\nMoj kontakt telefon je : " + kontakt);
            txtMessage.append("\n Način isporuke : " + selectedRadioButtonText);
        }




        if (txtSubject.getText().toString().length() == 0) {
            txtSubject.setError( "Subject polje je obavezno!" );
        }
        else if( txtImeFirme.getText().toString().length() == 0 ) {
            txtImeFirme.setError( "Ime Vaše firme je obavezno!");
        }
        else if( txtAdresa.getText().toString().length() == 0 ) {
            txtAdresa.setError( "Adresa Vaše firme je obavezna!");
        }
        else if( txtKontakt.getText().toString().length() == 0 ) {
            txtKontakt.setError( "Vaš kontakt telefon je obavezan!");
        }
        else if (txtMessage.getText().toString().length() == 0) {
            txtMessage.setError( "Poruka mejla je obavezna!" );
        }
        else if( selectedRadioButtonID <=0 ) {
            displaySnackbar();
        }

        else {
            String newEntry = txtMessage.getText().toString().trim();
            AddData(newEntry);
            sendEmail(to, txtSubject.getText().toString(), txtMessage.getText().toString());

        }
    }




    private void sendEmail(String[] emailAddresses, String subject, String message){

        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.putExtra(Intent.EXTRA_EMAIL, emailAddresses);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
        emailIntent.putExtra(Intent.EXTRA_TEXT, message);
        emailIntent.setType("message/rfc822");
        startActivity(Intent.createChooser(emailIntent, "Odaberite aplikaciju za slanje email-a"));

        //finish();
    }

    public void nazad(View v)
    {
        Button dugme2 = (Button) findViewById(R.id.nazadDugme);
        dugme2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), MainActivity.class);
                view.getContext().startActivity(intent);}
        });
        Toast.makeText(getApplicationContext(), "Kliknite 2 puta za povratak u meni",Toast.LENGTH_SHORT).show();
    }

    public void displaySnackbar(){
        Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), "Popunite sva neophodna polja i izaberite način isporuke", Snackbar.LENGTH_LONG);
        snackbar.show();
    }


    public void AddData(String newEntry) {

        boolean insertData = myDB.addData(newEntry);

        if(insertData==false){
            Toast.makeText(this, "Došlo je do greške prilikom čuvanja porudžbine u istoriju", Toast.LENGTH_LONG).show();

        }
    }


}

