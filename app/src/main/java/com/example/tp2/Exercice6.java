package com.example.tp2;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import static android.hardware.Sensor.TYPE_PROXIMITY;

public class Exercice6 extends AppCompatActivity implements SensorEventListener {
    ImageView image;
    TextView message;
    SensorManager mSensorManager;
    Sensor proximity;
    int lastSensorCounter = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercice6);

        image = (ImageView) findViewById(R.id.image);
        message = (TextView) findViewById(R.id.message) ;

        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        proximity = mSensorManager.getDefaultSensor(TYPE_PROXIMITY);

        mSensorManager.registerListener(this, proximity,SensorManager.SENSOR_DELAY_NORMAL);

    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        float x = sensorEvent.values[0];
        if(x == 0){
            image.setImageResource(R.drawable.warning);
            message.setText("Attention vous êtes approximité d'un objet");
        }
        else{
            image.setImageResource(R.drawable.ras);
            message.setText("RAS aucun objet à approximité ");
        }

    }
    @Override
    protected void onPause() {
        // arrêter d'utiliser le capteur
        mSensorManager.unregisterListener(this,proximity);
        super.onPause();
    }
    @Override
    protected void onResume() {
        // reprendre l'utilisation du capteur
        mSensorManager.registerListener(this, proximity, SensorManager.SENSOR_DELAY_UI);
        super.onResume();
    }
    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

}