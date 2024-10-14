package br.edu.fateczl.projetoandroid03_1;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    /*
     *@author:Rodrigo Fortunato Martins Neves
     */
    private EditText etValorGasolina;
    private EditText etValorEtanol;
    private TextView tvResultado;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etValorGasolina = findViewById(R.id.etValorGasolina);
        etValorEtanol = findViewById(R.id.etValorEtanol);
        Button btnCalcular = findViewById(R.id.btnCalcular);
        tvResultado = findViewById(R.id.tvResultado);

        btnCalcular.setOnClickListener(view -> calcular());

    }

    private void calcular(){
        float valorGasolina = Float.parseFloat(etValorGasolina.getText().toString());
        float valorEtanol = Float.parseFloat(etValorEtanol.getText().toString());


        if ((valorGasolina*0.7) < valorEtanol){
            tvResultado.setText(getString(R.string.tvResultadoGasolina));
        }else {
            tvResultado.setText(getString(R.string.tvResultadoEtanol));
        }

    }


}