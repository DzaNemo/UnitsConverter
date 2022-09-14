package dza.nemo.unitsconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SpeedConverterActivity extends AppCompatActivity {

    private EditText speedValueEt;
    private TextView resultTv;
    private Button kilometersButton, milesButton;
    private double result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speed_converter);

        speedValueEt = findViewById(R.id.speedValue_editText);
        resultTv = findViewById(R.id.result_textView);

        kilometersButton = findViewById(R.id.button_kmphTo);
        kilometersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double temp = Double.parseDouble(speedValueEt.getText().toString());
                result = temp * 0.621;
                resultTv.setText(String.valueOf(result));
            }
        });

        milesButton = findViewById(R.id.button_milesphTo);
        milesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double temp = Double.parseDouble(speedValueEt.getText().toString());
                result = temp * 1.6;
                resultTv.setText(String.valueOf(result));
            }
        });

    }
}