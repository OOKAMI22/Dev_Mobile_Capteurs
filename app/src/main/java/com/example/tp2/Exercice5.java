package com.example.tp2;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class Exercice5 extends AppCompatActivity implements SensorEventListener {
    SensorManager mSensorManager;
    Sensor accelerometre;
    ImageView flash;
    float shaker;
    boolean shake = false;


    @Override
    protected void onCreate(Bundle savedInstanceState)  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_exercice5);
    flash = (ImageView) findViewById(R.id.image);
    mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
    accelerometre = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);


    mSensorManager.registerListener(this, accelerometre, SensorManager.SENSOR_DELAY_NORMAL);

    shaker = (float) 44;


}

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        float sensorValueSum = 0;
        float x = sensorEvent.values[0];
        float y = sensorEvent.values[1];
        float z = sensorEvent.values[2];

        sensorValueSum = (float)(Math.abs(x)+Math.abs(y) +Math.abs(z));



        if (sensorValueSum >= shaker){

            CameraManager camManager = (CameraManager) getSystemService(Exercice5.this.CAMERA_SERVICE);
            try {
                if (shake) {
                    camManager.setTorchMode("0", false);
                    flash.setImageResource(R.drawable.flash_off);
                    shake = false;

                } else {
                    camManager.setTorchMode("0", true);
                    flash.setImageResource(R.drawable.flash_on);
                    shake = true;
                }
            } catch (CameraAccessException e) {
                e.printStackTrace();
            }
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