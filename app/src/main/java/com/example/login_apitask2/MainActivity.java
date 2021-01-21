package com.example.login_apitask2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.login_apitask2.API.ApiClient;
import com.example.login_apitask2.API.ApiService;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    EditText ed1, ed2;
    Button B1;
    private Retrofit retrofit;// = ApiClient.getClient();
    private ApiService api;//= retrofit.create(ApiService.class);
    private MultipartBody.Part part;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intFunction();
        IntListener();





    }

    private void intFunction() {

        retrofit = ApiClient.getClient();
        api = retrofit.create(ApiService.class);
        ed1 = findViewById(R.id.mb1);
        ed2 = findViewById(R.id.pass1);
        B1 = findViewById(R.id.btn);


    }

    private void IntListener() {

        B1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String mobile, password;
                mobile = ed1.getText().toString();
                password = ed2.getText().toString();

                if (mobile.isEmpty() || password.isEmpty()) {
                    Toast.makeText(MainActivity.this, "please enter phone number or password", Toast.LENGTH_SHORT).show();
                } else {
                    Call<String> call;
                    call = api.Login(mobile,password);
                    call.enqueue(new Callback<String>() {
                        @Override
                        public void onResponse(Call<String> call, Response<String> response) {
                            Toast.makeText(MainActivity.this, "Succeesefully ", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(MainActivity.this,dashbord.class);
                            startActivity(intent);


                        }

                        @Override
                        public void onFailure(Call<String> call, Throwable t) {

                        }
                    });

                }

            }


        });
    }
}