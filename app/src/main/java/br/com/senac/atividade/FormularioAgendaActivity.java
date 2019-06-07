package br.com.senac.atividade;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;



import br.com.senac.atividade.dao.AgendaDAO;
import br.com.senac.atividade.modelo.Agenda;


public class FormularioAgendaActivity extends AppCompatActivity {
    private FormularioHelper helper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formularioagenda);

        helper = new FormularioHelper(this);
        Intent intent = getIntent();
        Agenda agenda = (Agenda) intent.getSerializableExtra("agenda");

        if(agenda !=null) {
            helper.alterform(agenda);
            Toast.makeText(FormularioAgendaActivity.this, "Ok.", Toast.LENGTH_LONG).show();
        }

        Button botaogravar = (Button) findViewById(R.id.botaogravar);
        botaogravar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Agenda agenda = helper.getAgenda();
                AgendaDAO dao = new AgendaDAO(FormularioAgendaActivity.this);
            if (agenda.getId() != null) {
                dao.altera(agenda);
                Toast.makeText(FormularioAgendaActivity.this, "O evento foi alterado com sucesso", Toast.LENGTH_LONG).show();
            } else {
                dao.inserirAgenda(agenda);
                Toast.makeText(FormularioAgendaActivity.this, "O evento foi salvo com sucesso", Toast.LENGTH_LONG).show();
            }


            dao.close();

            }
        });

        Button botaolista = (Button) findViewById(R.id.botaoagenda);
        botaolista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent linklista = new Intent(FormularioAgendaActivity.this, ListaAgendaActivity.class);
                startActivity(linklista);
            }
        });
    }


}
