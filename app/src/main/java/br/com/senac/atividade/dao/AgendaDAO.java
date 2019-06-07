package br.com.senac.atividade.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import br.com.senac.atividade.modelo.Agenda;

import java.util.ArrayList;
import java.util.List;

public class AgendaDAO extends SQLiteOpenHelper {

    public AgendaDAO(Context context) {
        super(context, "bdagenda", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE tbagenda(id INTERGER PRIMARY KEY, agenda TEXT NOT NULL, data TEXT, inicio TEXT,fim TEXT, local TEXT )";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS tbagenda";
        db.execSQL(sql);
    }

    public void inserirAgenda( Agenda agenda) {
        SQLiteDatabase writableDataBase = getWritableDatabase();
        ContentValues dados = gtdados (agenda);
        writableDataBase.insert("tbagenda", null, dados);
    }

    public List <Agenda> listaagenda() {
        String sql = "Select * From tbagenda;";
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(sql,null);

        List<Agenda> agendas = new ArrayList<Agenda>();

        while (c.moveToNext()) {
            Agenda agenda = new Agenda();

            agenda.setId(c.getLong(c.getColumnIndex("id")));
            agenda.setAgenda(c.getString(c.getColumnIndex("agenda")));
            agenda.setData(c.getString(c.getColumnIndex("data")));
            agenda.setInicio(c.getString(c.getColumnIndex("inicio")));
            agenda.setFim(c.getString(c.getColumnIndex("fim")));
            agenda.setLocal(c.getString(c.getColumnIndex("local")));

            agendas.add(agenda);
        }
        c.close();
        return agendas;
    }

    public void deleta (Agenda agenda) {
        SQLiteDatabase db = getWritableDatabase();
        String [] params = {agenda.getId().toString()};
        db.delete("tbagenda", "id = ?", params);
    }

    public void altera (Agenda agenda) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues dados = gtdados (agenda);
        String[] params = {agenda.getId().toString()};
        db.update("tbagenda", dados, "id= ?", params );
    }

    private ContentValues gtdados(Agenda agenda) {
        ContentValues dados = new ContentValues();
        dados.put("agenda", agenda.getAgenda());
        dados.put("data", agenda.getData());
        dados.put("inicio", agenda.getInicio());
        dados.put("fim", agenda.getFim());
        dados.put("local", agenda.getLocal());
        return dados;
    }

}