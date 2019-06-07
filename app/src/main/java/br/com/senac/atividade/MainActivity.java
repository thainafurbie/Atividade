package br.com.senac.atividade;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button botaoiniciar = (Button) findViewById(R.id.botaoiniciar);
        botaoiniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentiniciar = new Intent(MainActivity.this, FormularioAgendaActivity.class);
                startActivity(intentiniciar);
            }
        });
    }
}
