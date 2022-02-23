package com.example.tp2;

import android.content.Context;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.constraintlayout.widget.ConstraintLayout;

public class Exercice3 extends AppCompatActivity implements SensorEventListener {
    SensorManager mSensorManager;
    Sensor accelerometre;
    ConstraintLayout coleur;
    float lastSensorValues[] = new float[7];
    float r,g,b;
    int lastSensorCounter = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercice3);
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        coleur = (ConstraintLayout) findViewById(R.id.background);
        accelerometre = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        mSensorManager.registerListener(this, accelerometre, SensorManager.SENSOR_DELAY_NORMAL);

        r = (float) 66;
        g = (float) 44;
        b = (float) 22;

    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        float sensorValueSum = 0;
        float x = sensorEvent.values[0];
        float y = sensorEvent.values[1];
        float z = sensorEvent.values[2];

        lastSensorValues[lastSensorCounter%7] = (float)(Math.abs(x)+Math.abs(y) +Math.abs(z));
        System.out.println(lastSensorValues[lastSensorCounter%7]);
        lastSensorCounter++;

        for (int i = 0; i < 7 ; i++ ){
            sensorValueSum += lastSensorValues[i];
        }
        sensorValueSum /= 7;

        if (sensorValueSum <= b){
            coleur.setBackgroundColor(Color.BLACK);
        }
        else if (sensorValueSum <= g ){
            coleur.setBackgroundColor(Color.GREEN);
        }
        else if (sensorValueSum > g ){
            coleur.setBackgroundColor(Color.RED);
        }



    }
    @Override
    protected void onPause() {
        // arreter d'utiliser le capteur
        mSensorManager.unregisterListener(this, accelerometre);
        super.onPause();
    }
    @Override
    protected void onResume() {
        // reprendre l'utilisation du capteur
        mSensorManager.registerListener(this, accelerometre, SensorManager.SENSOR_DELAY_UI);
        super.onResume();
    }
    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

}