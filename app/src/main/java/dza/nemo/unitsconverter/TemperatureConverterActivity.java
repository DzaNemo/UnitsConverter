package dza.nemo.unitsconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TemperatureConverterActivity extends AppCompatActivity {

    private EditText valueEt;
    private TextView resultTv;
    private Button celsiusButton, fahrenheitButton;
    private double result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature_converter);

        valueEt = findViewById(R.id.speedValue_editText);
        resultTv = findViewById(R.id.result_textView);

        celsiusButton = findViewById(R.id.button_kmphTo);
        celsiusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                double temp = Double.parseDouble(valueEt.getText().toString());
                result = temp * 1.8 + 32;
                resultTv.setText(String.valueOf(result));
            }
        });

        fahrenheitButton = findViewById(R.id.button_milesphTo);
        fahrenheitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                double temp = Double.parseDouble(valueEt.getText().toString());
                result = (temp - 32) / 1.8;
                resultTv.setText(String.valueOf(result));
            }
        });

    }
}