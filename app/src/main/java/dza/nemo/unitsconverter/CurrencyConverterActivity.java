package dza.nemo.unitsconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CurrencyConverterActivity extends AppCompatActivity {

     EditText amount;
     TextView result;
     Spinner fromConvertSpinner, toConvertSpinner;
     Button convertButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency_converter);

        amount = findViewById(R.id.amount_editText);
        result = findViewById(R.id.textView_currencyResult);
        fromConvertSpinner = findViewById(R.id.spinner_fromCurrency);
        toConvertSpinner = findViewById(R.id.spinner_toCurrency);

        // list of data (currency) ,put in a array and with adapter set data to spinner
        String[] droDownList = {"BAM","AUD","CAD","EUR","GBP","HRK","RSD","USD"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, androidx.constraintlayout.widget.R.layout.support_simple_spinner_dropdown_item,droDownList);
        fromConvertSpinner.setAdapter(adapter);
        toConvertSpinner.setAdapter(adapter);

        convertButton = findViewById(R.id.button_convertCurrency);
        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RetrofitInterface retrofitInterface = RetrofitBuilder.getRetrofitInstance().create(RetrofitInterface.class);
                Call<JsonObject> call = retrofitInterface.getExchangeCurrency(fromConvertSpinner.getSelectedItem().toString());
                call.enqueue(new Callback<JsonObject>() {
                    @Override
                    public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {

                        //Log.d("response",String.valueOf(response.body()));

                        JsonObject res = response.body();
                        JsonObject rates = res.getAsJsonObject("rates");
                        double currency = Double.valueOf(amount.getText().toString());
                        double multiplier = Double.valueOf(rates.get(toConvertSpinner.getSelectedItem().toString()).toString());
                        double resultOfConvert = currency * multiplier;
                        result.setText(String.valueOf(resultOfConvert));


                    }

                    @Override
                    public void onFailure(Call<JsonObject> call, Throwable t) {

                    }
                });
            }
        });

    }


}