package br.com.senac.atividade;

import android.widget.EditText;

import br.com.senac.atividade.FormularioAgendaActivity;
import br.com.senac.atividade.modelo.Agenda;

public class FormularioHelper {
    private final EditText campoagenda;
    private final EditText campodata;
    private final EditText campoinicio;
    private final EditText campofim;
    private final EditText campolocal;
    private Agenda agenda;


    public  FormularioHelper(FormularioAgendaActivity Activity) {
        campoagenda = Activity.findViewById(R.id.agenda);
        campodata = Activity.findViewById(R.id.data);
        campoinicio = Activity.findViewById(R.id.inicio);
        campofim = Activity.findViewById(R.id.fim);
        campolocal = Activity.findViewById(R.id.fim);
        agenda = new Agenda();
    }

    public Agenda getAgenda(){
        agenda.setAgenda(campoagenda.getText().toString());
        agenda.setData(campodata.getText().toString());
        agenda.setInicio(campoinicio.getText().toString());
        agenda.setFim(campofim.getText().toString());
        agenda.setLocal(campolocal.getText().toString());

        return agenda;
    }

    public void alterform(Agenda agenda){
        campoagenda.setText(agenda.getAgenda());
        campodata.setText(agenda.getData());
        campoinicio.setText(agenda.getInicio());
        campofim.setText(agenda.getFim());
        campolocal.setText(agenda.getLocal());
        this.agenda = agenda;

    }


}
