package dza.nemo.unitsconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MeasureConverterActivity extends AppCompatActivity {

    TextView tv_pounds;
    EditText et_kilogram;
    Button btn_converter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_measure_converter);


        et_kilogram = findViewById(R.id.editText_kilogram);
        tv_pounds = findViewById(R.id.textView_pounds);

        btn_converter = findViewById(R.id.button_convert);
        btn_converter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                convertKiloToPounds();
            }
        });

    }

    private void convertKiloToPounds() {

        String enteredKilos = et_kilogram.getText().toString();

        double kilo = Double.parseDouble(enteredKilos);

        double pounds = kilo * 2.205;

        tv_pounds.setText("" + pounds);

    }
}