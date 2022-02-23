package com.example.tp2;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class Exercice1 extends AppCompatActivity implements SensorEventListener {

    private SensorManager mSensorManager;
    List<Sensor> sensorsList = new ArrayList<>();
    List<String> capteursList = new ArrayList<>();
    ListView capteurs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_capteurs);
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensorsList = mSensorManager.getSensorList(Sensor.TYPE_ALL);
        capteurs = (ListView)  findViewById(R.id.listcaptid);

        String tmp = "";
        for (Sensor capteur : sensorsList){
            tmp = capteur.getName();
            capteursList.add(tmp);
        }

        ArrayAdapter<String> adapteur = new ArrayAdapter<String>(Exercice1.this, android.R.layout.simple_list_item_1,capteursList);
        capteurs.setAdapter(adapteur);

    }



    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {
    }
}