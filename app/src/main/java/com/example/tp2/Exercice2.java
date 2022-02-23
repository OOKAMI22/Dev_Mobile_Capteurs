package com.example.tp2;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static android.hardware.Sensor.*;

public class Exercice2 extends AppCompatActivity  {
    List<Sensor> sensorsList = new ArrayList<>();
    List<String> capteursList = new ArrayList<>();
    Map<Integer, String> allSensorsList = new HashMap<>();
    ListView capteurs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercice2);
        allSensorsList.putIfAbsent(TYPE_ACCELEROMETER,"TYPE_ACCELEROMETER");
        allSensorsList.putIfAbsent(TYPE_AMBIENT_TEMPERATURE,"TYPE_AMBIENT_TEMPERATURE");
        allSensorsList.putIfAbsent(TYPE_GRAVITY,"TYPE_GRAVITY");
        allSensorsList.putIfAbsent(TYPE_GYROSCOPE,"TYPE_GYROSCOPE");
        allSensorsList.putIfAbsent(TYPE_LIGHT,"TYPE_LIGHT");
        allSensorsList.putIfAbsent(TYPE_LINEAR_ACCELERATION,"TYPE_LINEAR_ACCELERATION");
        allSensorsList.putIfAbsent(TYPE_MAGNETIC_FIELD,"TYPE_MAGNETIC_FIELD");
        allSensorsList.putIfAbsent(TYPE_PRESSURE,"TYPE_PRESSURE");
        allSensorsList.putIfAbsent(TYPE_PROXIMITY,"TYPE_PROXIMITY");
        allSensorsList.putIfAbsent(TYPE_RELATIVE_HUMIDITY,"TYPE_RELATIVE_HUMIDITY");
        allSensorsList.putIfAbsent(TYPE_ROTATION_VECTOR,"TYPE_ROTATION_VECTOR");


        SensorManager mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensorsList = mSensorManager.getSensorList(Sensor.TYPE_ALL);
        capteurs = (ListView)  findViewById(R.id.listcaptid);



        for ( Integer i : allSensorsList.keySet() ){
            int j = 0;
            //test
            System.out.println("all sensors");
            System.out.println(allSensorsList.get(i));
            boolean trouve = false;
            while (!trouve && j < sensorsList.size() ){
                //test
                System.out.println("My sensors ");
                System.out.println(sensorsList.get(j).getStringType());

                if (sensorsList.get(j).getType()==i){trouve = true;}
                else{j++;}

            }
            if (!trouve){capteursList.add(allSensorsList.get(i));}


        }
        ArrayAdapter<String> adapteur = new ArrayAdapter<String>(Exercice2.this, android.R.layout.simple_list_item_1,capteursList);
        capteurs.setAdapter(adapteur);

    }

}