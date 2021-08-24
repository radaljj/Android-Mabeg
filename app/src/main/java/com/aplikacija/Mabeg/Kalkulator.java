package com.aplikacija.Mabeg;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class Kalkulator extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    String[] duzina = {"74 metara", "110 metara", "300 metara", "360 metara", "450 metara", "600 metara"};
    String text;

    EditText editSirina;
    EditText editVisina;
    EditText editBrojKomadaNaKolutu;
    EditText editBrojKolutova;
    RadioGroup rg;
    boolean flag = true;
    Spinner spin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kalkulator);


        spin = (Spinner) findViewById(R.id.spinner1);
        editSirina = (EditText) findViewById(R.id.edtSirina);
        editBrojKomadaNaKolutu = (EditText) findViewById(R.id.edtBrKomadaNaKolutu);
        editBrojKolutova = (EditText) findViewById(R.id.brKolutova);
        editVisina = (EditText) findViewById(R.id.edtVisina);
        rg = (RadioGroup) findViewById(R.id.rg);
        spin.setOnItemSelectedListener(this);
        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, duzina);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spin.setAdapter(aa);


        if (isFirstTime()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(Kalkulator.this, R.style.DialogeTheme);
            String mystring = getResources().getString(R.string.kalkulator);
            builder.setTitle("Korišćenje kalkulatora");
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
                startActivity(new Intent(Kalkulator.this, IstorijaPorudzbina.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private boolean isFirstTime() {
        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        boolean ranBefore = preferences.getBoolean("RanBefore", false);
        if (!ranBefore) {
            // first time
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("RanBefore", true);
            editor.commit();
        }
        return !ranBefore;
    }

    private void izracunaj() {
boolean flag=true;
        double sirinaFormula = 0;
        double sirinaRibona = Double.parseDouble(editSirina.getText().toString());
        double visinaRibona = Double.parseDouble(editVisina.getText().toString());
        double brojKomadaNaKolutu = Double.parseDouble(editBrojKomadaNaKolutu.getText().toString());
        double brojKolutova = Double.parseDouble(editBrojKolutova.getText().toString());
        double brEtiketaRed = 0;
        double duzinaRibona = 0;
        text = spin.getSelectedItem().toString();
        int radioButtonID = rg.getCheckedRadioButtonId();

        RadioButton radioButton = (RadioButton) rg.findViewById(radioButtonID);

        String selectedText = (String) radioButton.getText();

        if (selectedText.equals("Jednoredne")) {
            brEtiketaRed = 1;
        } else if (selectedText.equals("Dvoredne")) {
            brEtiketaRed = 2;
        } else if (selectedText.equals("Troredne")) {
            brEtiketaRed = 3;
        } else if (selectedText.equals("Četvoredne")) {
            brEtiketaRed = 4;
        } else {
            displaySnackbar("Došlo je do greške kod odabira broja etiketa u redu");

        }

        if (sirinaRibona * brEtiketaRed <= 40) {
            sirinaFormula = 40;
        } else if (sirinaRibona * brEtiketaRed > 40 && sirinaRibona * brEtiketaRed <= 55) {
            sirinaFormula = 55;
        } else if (sirinaRibona * brEtiketaRed > 55 && sirinaRibona * brEtiketaRed <= 64) {
            sirinaFormula = 64;
        } else if (sirinaRibona * brEtiketaRed > 64 && sirinaRibona * brEtiketaRed <=76) {
            sirinaFormula = 76;
        } else if (sirinaRibona * brEtiketaRed > 76 && sirinaRibona * brEtiketaRed <= 89) {
            sirinaFormula = 89;
        } else if (sirinaRibona * brEtiketaRed > 89 && sirinaRibona * brEtiketaRed <= 110) {
            sirinaFormula = 110;
        } else if (sirinaRibona * brEtiketaRed > 110 && sirinaRibona * brEtiketaRed <= 165) {
            sirinaFormula = 165;
        } else if ((sirinaRibona * brEtiketaRed) >= 165||sirinaFormula==0) {
flag=false;
        }

        if (text.equals("74 metara")) {
            duzinaRibona = 74;
        } else if (text.equals("110 metara")) {
            duzinaRibona = 110;
        } else if (text.equals("300 metara")) {
            duzinaRibona = 300;
        } else if (text.equals("360 metara")) {
            duzinaRibona = 360;
        } else if (text.equals("450 metara")) {
            duzinaRibona = 450;
        } else if (text.equals("600 metara")) {
            duzinaRibona = 600;
        } else {
            displaySnackbar("Došlo je do greške kod odabira dužine ribona");
        }

        double prvi = ((visinaRibona + 3) / 1000) * (brojKomadaNaKolutu / brEtiketaRed) * brojKolutova;
        double rezultatFormula = prvi / duzinaRibona;
        double cuvanjeRezultat = Math.ceil(rezultatFormula);


        String cuvanjeRezultatString = String.valueOf((int) cuvanjeRezultat);
        String sirinaRibonaString = String.valueOf((int) sirinaFormula);
        String duzinaRibonaString = String.valueOf((int) duzinaRibona);

        if(!flag){
            displaySnackbar("Unesite odgovarajuću širinu etikete");


        }else {

            AlertDialog.Builder builder = new AlertDialog.Builder(Kalkulator.this, R.style.DialogeTheme);
            String mystring = "Potreban broj ribona je :  " + cuvanjeRezultatString + "\n" + " Dimenzija: " + sirinaRibonaString + " mm " +" X  " + duzinaRibonaString + " m ";
            builder.setTitle("Količina ribona za vaše potrebe");
            builder.setMessage(mystring);
            builder.setNegativeButton("U redu", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });

            builder.create().show();
        }
    }


    public void dugmeIzracunaj(View v) {

        int selectedRadioButtonID = rg.getCheckedRadioButtonId();



        if (editSirina.getText().toString().length() == 0||editSirina.getText().toString().equals("0")) {
            displaySnackbar("Unesite širinu etikete");
            editSirina.setError("Unesite širinu etikete");
        } else if (editVisina.getText().toString().length() == 0 ||editVisina.getText().toString().equals("0"))  {
            displaySnackbar("Unesite visinu etikete");
            editVisina.setError("Unesite visinu etikete");
        } else if (editBrojKomadaNaKolutu.getText().toString().length() == 0 ||editBrojKomadaNaKolutu.getText().toString().equals("0")) {
            displaySnackbar("Unesite broj komada etiketa na kolutu");
            editBrojKomadaNaKolutu.setError("Unesite broj komada etiketa na kolutu");
        } else if (editBrojKolutova.getText().toString().length() == 0 ||editBrojKolutova.getText().toString().equals("0")) {
            displaySnackbar("Unesite broj kolutova");
            editBrojKolutova.setError("Unesite broj kolutova");
        }else if( selectedRadioButtonID <=0 ) {
            displaySnackbar("Odaberite broj etiketa u redu");
        } else {
            izracunaj();
        }
    }

    public void meni(View view) {
        Intent intent = new Intent(view.getContext(), MainActivity.class);
        view.getContext().startActivity(intent);
    }


    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {

        //  Toast.makeText(getApplicationContext(),duzina[position] , Toast.LENGTH_LONG).show();


    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }

    public void displaySnackbar(String text) {
        Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), text, Snackbar.LENGTH_LONG);
        snackbar.show();
    }

}