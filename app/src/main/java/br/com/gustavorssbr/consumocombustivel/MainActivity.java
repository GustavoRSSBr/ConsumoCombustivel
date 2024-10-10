package br.com.gustavorssbr.consumocombustivel;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText etConsumo;
    private EditText etTanque;
    private Button btnCalcular;
    private TextView tvRes;


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

        etConsumo = findViewById(R.id.etConsumo);
        etConsumo.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        etTanque = findViewById(R.id.etTanque);
        etTanque.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        btnCalcular = findViewById(R.id.btnCalcular);
        btnCalcular.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        tvRes = findViewById(R.id.tvRes);
        tvRes.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

        btnCalcular.setOnClickListener(op -> calcular());
    }

    public void calcular(){
        int consumo = Integer.parseInt(etConsumo.getText().toString());
        int tanque = Integer.parseInt(etTanque.getText().toString());

        int metros = (consumo * 1000) * tanque;

        String texto = getString(R.string.metros) + " " + metros + " metros";

        tvRes.setText(texto);



    }
}