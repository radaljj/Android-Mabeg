package com.aplikacija.Mabeg;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PozivAktivnost  extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poziv_aktivnost);
        Button mDialButton = (Button) findViewById(R.id.btn_dial);
        Button mDialButton1 = (Button) findViewById(R.id.btn_dial1);

        final EditText mPhoneNoEt = (EditText) findViewById(R.id.et_phone_no);
        final EditText mPhoneNoEt1 = (EditText) findViewById(R.id.et_phone_no1);

        mDialButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phoneNo = mPhoneNoEt.getText().toString();
                if(!TextUtils.isEmpty(phoneNo)) {
                    String dial = "tel:" + phoneNo;
                    startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse(dial)));
                }else {
                    Toast.makeText(PozivAktivnost.this, "Doslo je do greske", Toast.LENGTH_SHORT).show();
                }

                finish();
            }
        });

        mDialButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phoneNo = mPhoneNoEt1.getText().toString();
                if(!TextUtils.isEmpty(phoneNo)) {
                    String dial = "tel:" + phoneNo;
                    startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse(dial)));
                }else {
                    Toast.makeText(PozivAktivnost.this, "Doslo je do greske", Toast.LENGTH_SHORT).show();
                }

                finish();
            }
        });
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
                startActivity(new Intent(PozivAktivnost.this, IstorijaPorudzbina.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}