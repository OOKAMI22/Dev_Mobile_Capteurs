package com.example.tp2;

import android.content.Intent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class Acceuil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceuil);
    }

    public void allerVers1(View view) {startActivity(new Intent(Acceuil.this, Exercice1.class));}

    public void allerVers2(View view) {startActivity(new Intent(Acceuil.this, Exercice2.class));}

    public void allerVers3(View view) {startActivity(new Intent(Acceuil.this, Exercice3.class));}

    public void allerVers4(View view) {startActivity(new Intent(Acceuil.this, Exercice4.class));}

    public void allerVers5(View view) {startActivity(new Intent(Acceuil.this, Exercice5.class));}

    public void allerVers6(View view) {startActivity(new Intent(Acceuil.this, Exercice6.class));}

    public void allerVers7(View view) {startActivity(new Intent(Acceuil.this, Exercice7.class));}
}