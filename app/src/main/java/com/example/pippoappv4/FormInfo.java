package com.example.pippoappv4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.TypefaceSpan;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class FormInfo extends AppCompatActivity {

    private ImageButton ButtonConfig;
    private ImageButton ButtonFlor;
    private ImageButton ButtonInfo;

    private Button _buttonEmail;
    String _urlEmail = "mailto:felipe.kadanos2.0@gmail.com?bcc=rafaeltoledo602@gmail.com";
    private Button _buttonInsta;
    String _urlFefo = "https://www.instagram.com/lipz.png/";
    private Button _buttonInsta2;
    String _urlRafa = "https://www.instagram.com/faeltkk/";
    private Button _buttonGit;
    String _urlGit = "https://github.com/lipzpng";
    private Button _buttonLink;
    String _urlLink = "https://www.linkedin.com/in/felipe-kadanos-801220226/";
    private Button _buttonLinkRafa;
    String _urlLinkRafa = "https://www.linkedin.com/in/rafael-alves-7b4697272";


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_info);

        getSupportActionBar().hide();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        IniciarComponentes1();
        IniciarComponentes2();
        IniciarComponentes3();

        //botoes de link
        _buttonEmail = findViewById(R.id.buttonEmail);

        _buttonEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri _link = Uri.parse(_urlEmail);

                Intent intent = new Intent(Intent.ACTION_VIEW,_link);
                startActivity(intent);
            }
        });

        _buttonInsta = findViewById(R.id.buttonInsta);

        _buttonInsta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri _link = Uri.parse(_urlFefo);

                Intent intent = new Intent(Intent.ACTION_VIEW,_link);
                startActivity(intent);
            }
        });

        _buttonInsta2 = findViewById(R.id.buttonInsta2);

        _buttonInsta2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri _link = Uri.parse(_urlRafa);

                Intent intent = new Intent(Intent.ACTION_VIEW,_link);
                startActivity(intent);
            }
        });

        _buttonGit = findViewById(R.id.buttonGit);

        _buttonGit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri _link = Uri.parse(_urlGit);

                Intent intent = new Intent(Intent.ACTION_VIEW,_link);
                startActivity(intent);
            }
        });

        _buttonLink = findViewById(R.id.buttonLink);

        _buttonLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri _link = Uri.parse(_urlLink);

                Intent intent = new Intent(Intent.ACTION_VIEW,_link);
                startActivity(intent);
            }
        });

        _buttonLinkRafa = findViewById(R.id.buttonLink2);

        _buttonLinkRafa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri _link = Uri.parse(_urlLinkRafa);

                Intent intent = new Intent(Intent.ACTION_VIEW,_link);
                startActivity(intent);
            }
        });





        //botoes do menu
        ButtonConfig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FormInfo.this,FormConfig.class);
                startActivity(intent);
                finish();
            }
        });
        ButtonFlor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FormInfo.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        ButtonInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FormInfo.this,FormInfo.class);
            }
        });
    }

    private void IniciarComponentes1(){
        ButtonConfig = findViewById(R.id.ButtonConfig);
    }
    private void IniciarComponentes2(){
        ButtonFlor = findViewById(R.id.ButtonFlor);
    }
    private void IniciarComponentes3(){
        ButtonInfo = findViewById(R.id.ButtonInfo);
    }
}