package com.example.calculadoradegorjeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editValor;
    private TextView textPorcentagem, textGorjeta, textTotal;
    private SeekBar seekBarGorjeta;
    private double porcentagem = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editValor = findViewById(R.id.editTextValor);
        textPorcentagem = findViewById(R.id.textViewPorcentagem);
        textGorjeta = findViewById(R.id.textViewGorjeta);
        textTotal = findViewById(R.id.textViewTotal);
        seekBarGorjeta = findViewById(R.id.seekBarGorjeta);

        //Adicionar listener para o SeekBar
        seekBarGorjeta.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                porcentagem = progress;
                textPorcentagem.setText(Math.round(porcentagem) + " %");
                calcular();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void calcular() {
        String valorRecuparado = editValor.getText().toString();
        // Verifica se a entrada de valor não está vazia
        if (valorRecuparado == null || valorRecuparado.equals("")){
            Toast.makeText(this, "Digite um valor para calcular!", Toast.LENGTH_SHORT).show();
        }else {
            // Converte de strig para double
            double valorDigitado = Double.parseDouble(valorRecuparado);
            double gorjeta = valorDigitado * (porcentagem / 100);
            // Exibir o resultado
            textGorjeta.setText("R$ " + gorjeta);
            textTotal.setText("R$" + (gorjeta +valorDigitado));
        }

    }

}