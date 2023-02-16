package com.example.leveler_accelerometer_sensor;

import static java.lang.Short.TYPE;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    TextView x, y, z;

    SensorManager sensorManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        x = findViewById(R.id.value_of_x);
        y = findViewById(R.id.value_of_y);
        z = findViewById(R.id.value_of_z);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        if (sensorManager!=null)
        {
            Sensor accelerometer_sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
            if (accelerometer_sensor!=null)
            {
                sensorManager.registerListener(this, accelerometer_sensor, SensorManager.SENSOR_DELAY_NORMAL);
            }else{
                Toast.makeText(this, "accelerometer sensor not found...", Toast.LENGTH_SHORT).show();
            }
        }else {
            Toast.makeText(this, "Sensor is not working properly...", Toast.LENGTH_SHORT).show();
        }




    }

            @Override
            public void onSensorChanged(SensorEvent event) {
                if (event.sensor.getType()==Sensor.TYPE_ACCELEROMETER)
                {
                    x.setText("x cordinates: "+String.valueOf(event.values[0]));
                    y.setText("y cordinates: "+String.valueOf(event.values[1]));
                    z.setText("z cordinates: "+String.valueOf(event.values[2]));
                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        }