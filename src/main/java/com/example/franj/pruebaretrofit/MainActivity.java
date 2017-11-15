package com.example.franj.pruebaretrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements Callback<Chiste> {
    static final String BASE_URL = "http://api.icndb.com/";
    private TextView texto1;
    private Button botonPedir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        texto1 = (TextView) findViewById(R.id.texto1);
        botonPedir = (Button) findViewById(R.id.botonPedir);
        botonPedir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start();
            }
        });
    }

    public void start() {

        Gson gson = new GsonBuilder()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        ChisteInterfaz chisteinterfaz = retrofit.create(ChisteInterfaz.class);

        Call<Chiste> call = chisteinterfaz.loadChiste();
        call.enqueue(this);

    }

    @Override
    public void onResponse(Call<Chiste> call, Response<Chiste> response) {
        if(response.isSuccessful()) {
            Chiste chiste = response.body();
            texto1.setText(chiste.getValue().getJoke());
        } else {
            System.out.println(response.errorBody());
        }
    }

    @Override
    public void onFailure(Call<Chiste> call, Throwable t) {
        t.printStackTrace();
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
