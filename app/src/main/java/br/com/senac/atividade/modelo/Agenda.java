package br.com.senac.atividade.modelo;

import java.io.Serializable ;

public class Agenda implements Serializable {
    private Long id;
    private String agenda;
    private String data;
    private String inicio;
    private String fim;
    private String local;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getAgenda() { return agenda; }

    public void setAgenda(String agenda) { this.agenda = agenda; }

    public String getData() { return data; }

    public void setData(String data) { this.data = data; }

    public String getInicio() { return inicio; }

    public void setInicio(String inicio) { this.inicio = inicio; }

    public String getFim() { return fim; }

    public void setFim(String fim) { this.fim = fim; }

    public String getLocal() { return local; }

    public void setLocal(String local) {
        this.local = local;
    }

    @Override
    public String toString(){
        return getAgenda() + " - " +  getData() + " - " + getInicio() + "-" + getFim() + "-"  + getLocal();
    }
}
