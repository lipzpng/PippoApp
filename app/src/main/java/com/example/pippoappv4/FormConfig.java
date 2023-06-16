package com.example.pippoappv4;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class FormConfig extends AppCompatActivity {

    private ImageButton ButtonConfig;
    private ImageButton ButtonFlor;
    private ImageButton ButtonInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_config);

        getSupportActionBar().hide();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        IniciarComponentes1();
        IniciarComponentes2();
        IniciarComponentes3();

        //Aciona os popups
        Button _buttonVermelho = (Button) findViewById(R.id.buttonVermelho);
        View view = findViewById(R.id.containerComponentsBottom);
        _buttonVermelho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //view.setBackgroundColor(getResources().getColor(R.drawable.container_components_vermelho));

                Toast.makeText(FormConfig.this, "Você selecionou a cor Vermelha", Toast.LENGTH_SHORT).show();

                View view = findViewById(R.id.containerComponentsBottom);

                // Crie um drawable com o novo degradê
                GradientDrawable gradientDrawable = new GradientDrawable(
                        GradientDrawable.Orientation.LEFT_RIGHT,
                        new int[]{Color.RED, Color.BLUE}); // Substitua as cores pelo seu degradê desejado

                // Defina o drawable como background da view
                view.setBackground(gradientDrawable);

            }
        });

        Button _buttonMarrom = (Button) findViewById(R.id.buttonMarrom);
        _buttonMarrom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cria o AlertDialog
                AlertDialog.Builder builder = new AlertDialog.Builder(FormConfig.this);
                builder.setTitle("Você selecionou a cor Marrom");
                builder.setMessage("Clique em OK para fechar");

                // Adiciona o botão "OK" ao AlertDialog e define o listener
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Fecha o popup
                        dialog.dismiss();
                    }
                });

                // Exibe o AlertDialog
                // Define a cor do botão "OK"
                AlertDialog dialog = builder.create();
                dialog.setOnShowListener(new DialogInterface.OnShowListener() {
                    @Override
                    public void onShow(DialogInterface dialog) {
                        Button positiveButton = ((AlertDialog) dialog).getButton(DialogInterface.BUTTON_POSITIVE);
                        positiveButton.setTextColor(getResources().getColor(R.color.brown));
                    }
                });
                dialog.show();
            }
        });

        Button _buttonLaranja = (Button) findViewById(R.id.buttonLaranja);
        _buttonLaranja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cria o AlertDialog
                AlertDialog.Builder builder = new AlertDialog.Builder(FormConfig.this);
                builder.setTitle("Você selecionou a cor Laranja");
                builder.setMessage("Clique em OK para fechar");

                // Adiciona o botão "OK" ao AlertDialog e define o listener
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Fecha o popup
                        dialog.dismiss();
                    }
                });

                // Exibe o AlertDialog
                // Define a cor do botão "OK"
                AlertDialog dialog = builder.create();
                dialog.setOnShowListener(new DialogInterface.OnShowListener() {
                    @Override
                    public void onShow(DialogInterface dialog) {
                        Button positiveButton = ((AlertDialog) dialog).getButton(DialogInterface.BUTTON_POSITIVE);
                        positiveButton.setTextColor(getResources().getColor(R.color.orange));
                    }
                });
                dialog.show();
            }
        });

        Button _buttonAmarelo = (Button) findViewById(R.id.buttonAmarelo);
        _buttonAmarelo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cria o AlertDialog
                AlertDialog.Builder builder = new AlertDialog.Builder(FormConfig.this);
                builder.setTitle("Você selecionou a cor Amarela");
                builder.setMessage("Clique em OK para fechar");

                // Adiciona o botão "OK" ao AlertDialog e define o listener
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Fecha o popup
                        dialog.dismiss();
                    }
                });

                // Exibe o AlertDialog
                // Define a cor do botão "OK"
                AlertDialog dialog = builder.create();
                dialog.setOnShowListener(new DialogInterface.OnShowListener() {
                    @Override
                    public void onShow(DialogInterface dialog) {
                        Button positiveButton = ((AlertDialog) dialog).getButton(DialogInterface.BUTTON_POSITIVE);
                        positiveButton.setTextColor(getResources().getColor(R.color.yellow));
                    }
                });
                dialog.show();
            }
        });

        Button _buttonVerde = (Button) findViewById(R.id.buttonVerde);
        _buttonVerde.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cria o AlertDialog
                AlertDialog.Builder builder = new AlertDialog.Builder(FormConfig.this);
                builder.setTitle("Você selecionou a cor Verde");
                builder.setMessage("Clique em OK para fechar");

                // Adiciona o botão "OK" ao AlertDialog e define o listener
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Fecha o popup
                        dialog.dismiss();
                    }
                });

                // Exibe o AlertDialog
                // Define a cor do botão "OK"
                AlertDialog dialog = builder.create();
                dialog.setOnShowListener(new DialogInterface.OnShowListener() {
                    @Override
                    public void onShow(DialogInterface dialog) {
                        Button positiveButton = ((AlertDialog) dialog).getButton(DialogInterface.BUTTON_POSITIVE);
                        positiveButton.setTextColor(getResources().getColor(R.color.green_medium));
                    }
                });
                dialog.show();
            }
        });

        Button _buttonAzul = (Button) findViewById(R.id.buttonAzul);
        _buttonAzul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cria o AlertDialog
                AlertDialog.Builder builder = new AlertDialog.Builder(FormConfig.this);
                builder.setTitle("Você selecionou a cor Azul");
                builder.setMessage("Clique em OK para fechar");

                // Adiciona o botão "OK" ao AlertDialog e define o listener
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Fecha o popup
                        dialog.dismiss();
                    }
                });

                // Exibe o AlertDialog
                // Define a cor do botão "OK"
                AlertDialog dialog = builder.create();
                dialog.setOnShowListener(new DialogInterface.OnShowListener() {
                    @Override
                    public void onShow(DialogInterface dialog) {
                        Button positiveButton = ((AlertDialog) dialog).getButton(DialogInterface.BUTTON_POSITIVE);
                        positiveButton.setTextColor(getResources().getColor(R.color.blue));
                    }
                });
                dialog.show();
            }
        });

        Button _buttonRoxo = (Button) findViewById(R.id.buttonRoxo);
        _buttonRoxo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cria o AlertDialog
                AlertDialog.Builder builder = new AlertDialog.Builder(FormConfig.this);
                builder.setTitle("Você selecionou a cor Roxa");
                builder.setMessage("Clique em OK para fechar");

                // Adiciona o botão "OK" ao AlertDialog e define o listener
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Fecha o popup
                        dialog.dismiss();
                    }
                });

                // Exibe o AlertDialog
                // Define a cor do botão "OK"
                AlertDialog dialog = builder.create();
                dialog.setOnShowListener(new DialogInterface.OnShowListener() {
                    @Override
                    public void onShow(DialogInterface dialog) {
                        Button positiveButton = ((AlertDialog) dialog).getButton(DialogInterface.BUTTON_POSITIVE);
                        positiveButton.setTextColor(getResources().getColor(R.color.purple));
                    }
                });
                dialog.show();
            }
        });

        Button _buttonPreto = (Button) findViewById(R.id.buttonPreto);
        _buttonPreto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cria o AlertDialog
                AlertDialog.Builder builder = new AlertDialog.Builder(FormConfig.this);
                builder.setTitle("Você selecionou a cor Preta");
                builder.setMessage("Clique em OK para fechar");

                // Adiciona o botão "OK" ao AlertDialog e define o listener
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Fecha o popup
                        dialog.dismiss();
                    }
                });

                // Exibe o AlertDialog
                // Define a cor do botão "OK"
                AlertDialog dialog = builder.create();
                dialog.setOnShowListener(new DialogInterface.OnShowListener() {
                    @Override
                    public void onShow(DialogInterface dialog) {
                        Button positiveButton = ((AlertDialog) dialog).getButton(DialogInterface.BUTTON_POSITIVE);
                        positiveButton.setTextColor(getResources().getColor(R.color.black));
                    }
                });
                dialog.show();
            }
        });

        Button _buttonBranco = (Button) findViewById(R.id.buttonBranco);
        _buttonBranco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cria o AlertDialog
                AlertDialog.Builder builder = new AlertDialog.Builder(FormConfig.this);
                builder.setTitle("Você selecionou a cor Branca");
                builder.setMessage("Clique em OK para fechar");

                // Adiciona o botão "OK" ao AlertDialog e define o listener
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Fecha o popup
                        dialog.dismiss();
                    }
                });

                // Exibe o AlertDialog
                // Define a cor do botão "OK"
                AlertDialog dialog = builder.create();
                dialog.setOnShowListener(new DialogInterface.OnShowListener() {
                    @Override
                    public void onShow(DialogInterface dialog) {
                        Button positiveButton = ((AlertDialog) dialog).getButton(DialogInterface.BUTTON_POSITIVE);
                        positiveButton.setTextColor(getResources().getColor(R.color.white_light));
                    }
                });
                dialog.show();
            }
        });





        //botoes de menu
        ButtonConfig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FormConfig.this,FormConfig.class);
            }
        });
        ButtonFlor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FormConfig.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        ButtonInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FormConfig.this,FormInfo.class);
                startActivity(intent);
                finish();
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