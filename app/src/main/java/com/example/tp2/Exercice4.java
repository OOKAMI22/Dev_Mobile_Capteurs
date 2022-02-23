package com.example.tp2;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.constraintlayout.widget.ConstraintLayout;

public class Exercice4 extends AppCompatActivity implements SensorEventListener {
    SensorManager mSensorManager;
    Sensor accelerometre;
    TextView direction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercice4);
        direction = (TextView) findViewById(R.id.fleche);
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        accelerometre = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        mSensorManager.registerListener(this,accelerometre, SensorManager.SENSOR_DELAY_NORMAL);

    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        float x = sensorEvent.values[0];
        float y = sensorEvent.values[1];

        if(y > 5){direction.setText("↑");}
        else if (y < -5){direction.setText("↓");}

        if(x > 5){direction.setText("←");}
        else if (x < -5){direction.setText("→");}


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