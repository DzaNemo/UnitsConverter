package dza.nemo.unitsconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout currencyLayout, speedLayout, measureLayout, temperatureLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        currencyLayout = findViewById(R.id.currency_layout);
        currencyLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent currencyIntent = new Intent(MainActivity.this,CurrencyConverterActivity.class);
                startActivity(currencyIntent);
            }
        });

        speedLayout = findViewById(R.id.speed_layout);
        speedLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent speedIntent = new Intent(MainActivity.this,SpeedConverterActivity.class);
                startActivity(speedIntent);
            }
        });

        measureLayout = findViewById(R.id.measure_layout);
        measureLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent measureIntent = new Intent(MainActivity.this,MeasureConverterActivity.class);
                startActivity(measureIntent);
            }
        });

        temperatureLayout = findViewById(R.id.temperature_layout);
        temperatureLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent temperatureIntent = new Intent(MainActivity.this, TemperatureConverterActivity.class);
                startActivity(temperatureIntent);
            }
        });


    }
}