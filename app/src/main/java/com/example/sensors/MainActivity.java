package com.example.sensors;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorEventListener2;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
TextView  tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.tv);
        SensorManager sm = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        // List<Sensor> list = sm.getSensorList(Sensor.TYPE_ALL);
        // for(Sensor sensor : list){
        //     tv.append(sensor.getName() + "\n");
// две строчки о свете
        Sensor lightSensor = sm.getDefaultSensor(Sensor.TYPE_LIGHT);
      ////  sm.registerListener(this,lightSensor,SensorManager.SENSOR_DELAY_UI);    для света вернуть
        //аксилирометр движение
        Sensor acc = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sm.registerListener(this,acc,SensorManager.SENSOR_DELAY_UI);

    }

    public void onSensorChanged(SensorEvent event){
          //  tv.setText("Свет:" + event.values[0] + "\n");   вернуть для света
        tv.setText("Ускорение:" + event.values[0] + "\n" + event.values[1] + "\n" + event.values[2] + "\n");
        }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}

