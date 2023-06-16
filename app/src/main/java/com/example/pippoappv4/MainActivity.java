package com.example.pippoappv4;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Objects;
import java.util.Scanner;
import java.util.UUID;

public class MainActivity extends AppCompatActivity implements LocationListener {
    private static final String OPENWEATHERMAP_API_KEY = "6ddc493c66565c4fca3955ffe8e5deb6";
    private TextView textViewLocation;
    private TextView textViewTemperature;
    private TextView textViewDescription;
    private ImageView imageViewWeatherDescription;
    private TextView textViewUmid;

    private ImageButton buttonConfig;
    private ImageButton buttonFlor;
    private ImageButton buttonInfo;

    @Override
    public void onLocationChanged(Location location) {
        double latitude = location.getLatitude();
        double longitude = location.getLongitude();

        getWeatherData(latitude, longitude);
    }

    private void getWeatherData(double latitude, double longitude) {
        new Thread(() -> {
            try {
                URL url = new URL("https://api.openweathermap.org/data/2.5/weather?lat=" + latitude + "&lon=" + longitude + "&units=metric" + "&lang=pt_br" + "&appid=" + OPENWEATHERMAP_API_KEY);

                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");

                InputStream inputStream = connection.getInputStream();
                Scanner scanner = new Scanner(inputStream);
                StringBuilder stringBuilder = new StringBuilder();
                while (scanner.hasNextLine()) {
                    stringBuilder.append(scanner.nextLine());
                }
                String response = stringBuilder.toString();
                JSONObject jsonObject = new JSONObject(response);

                int temperature = jsonObject.getJSONObject("main").getInt("temp");
                String weatherDescription = jsonObject.getJSONArray("weather").getJSONObject(0).getString("description");
                String cityName = jsonObject.getString("name");

                ImageView imageViewWeatherIcon = findViewById(R.id.imageViewWeatherIcon);

                runOnUiThread(() -> {
                    textViewTemperature.setText(temperature + "°C");
                    imageViewWeatherIcon.setImageResource(getWeatherIconResource(weatherDescription));
                    textViewLocation.setText(cityName);
                });

            } catch (IOException | JSONException e) {
                e.printStackTrace();
            }
        }).start();
    }

    private int getWeatherIconResource(String weatherDescription) {
        int weatherIconResourceId = 0;

        switch (weatherDescription) {
            case "céu limpo":
                weatherIconResourceId = R.drawable.clear_sky;
                break;
            case "algumas nuvens":
                weatherIconResourceId = R.drawable.few_clouds;
                break;
            case "nublado":
                weatherIconResourceId = R.drawable.cloudy;
                break;
            case "nuvens dispersas":
                weatherIconResourceId = R.drawable.scattered_clouds;
                break;
            case "nuvens quebradas":
                weatherIconResourceId = R.drawable.overcast_clouds;
                break;
            case "nuvens encobertas":
                weatherIconResourceId = R.drawable.broken_clouds;
                break;
            case "chuva rápida":
                weatherIconResourceId = R.drawable.shower_rain;
                break;
            case "chuva leve":
                weatherIconResourceId = R.drawable.shower_rain;
                break;
            case "chuva":
                weatherIconResourceId = R.drawable.rain;
                break;
            case "tempestade":
                weatherIconResourceId = R.drawable.thunderstorm;
                break;
            case "névoa":
                weatherIconResourceId = R.drawable.mist;
                break;
            case "névoa seca":
                weatherIconResourceId = R.drawable.haze;
                break;
            case "nevoeiro":
                weatherIconResourceId = R.drawable.fog;
                break;
            case "rajadas de vento":
                weatherIconResourceId = R.drawable.squall;
                break;

            default:
                weatherIconResourceId = R.drawable.clima; // Ícone padrão caso a descrição não seja reconhecida
                break;
        }

        return weatherIconResourceId;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewDescription = findViewById(R.id.textRight);
        textViewLocation = findViewById(R.id.textLocation);
        textViewTemperature = findViewById(R.id.textTemp);
        imageViewWeatherDescription = findViewById(R.id.imageViewWeatherIcon);

        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, 1);
            return;
        }
        Location location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
        if (location != null) {
            onLocationChanged(location);
        } else {
            Toast.makeText(this, "Não foi possível obter a localização", Toast.LENGTH_SHORT).show();
        }

        Objects.requireNonNull(getSupportActionBar()).hide();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);

        IniciarComponentes1();
        IniciarComponentes2();
        IniciarComponentes3();

        // Botões de menu
        buttonConfig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, FormConfig.class);
                startActivity(intent);
                finish();
            }
        });

        buttonFlor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        buttonInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, FormInfo.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void IniciarComponentes1() {
        buttonConfig = findViewById(R.id.ButtonConfig);
    }

    private void IniciarComponentes2() {
        buttonFlor = findViewById(R.id.ButtonFlor);
    }

    private void IniciarComponentes3() {
        buttonInfo = findViewById(R.id.ButtonInfo);
    }
}