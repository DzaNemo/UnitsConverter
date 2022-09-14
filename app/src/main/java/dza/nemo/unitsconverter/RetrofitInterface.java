package dza.nemo.unitsconverter;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RetrofitInterface {

    //https://api.currencyfreaks.com/latest?apikey=8ca17c93f6254dc59f9c279dde201ba7

    // https://v6.exchangerate-api.com/v6/b665b898227e598796d90dfb/latest/USD
    @GET("v4/latest/{currency}")
    Call<JsonObject> getExchangeCurrency(@Path("currency") String currency);

}
