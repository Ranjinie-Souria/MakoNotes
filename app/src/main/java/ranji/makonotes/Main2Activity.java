package ranji.makonotes;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;


public class Main2Activity extends AppCompatActivity{
    NoteAdapter adapter;
    ArrayList<String> titres = new ArrayList<String>();
    private ArrayList<Note> notes = new ArrayList<Note>();


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ListView mListView = findViewById(R.id.listView);

        notes = listenotes();
        adapter = new NoteAdapter(Main2Activity.this, notes);

        mListView.setAdapter(adapter);
    }


    public ArrayList<Note> listenotes() {
        GestionNotes lesnote = new GestionNotes();
        titres = lesnote.listFilesForFolder(getFilesDir());
        for (int i = 0; i < titres.size(); i++) {
            String titre = titres.get(i);
            String texte = lesnote.lire(titres.get(i),this);
            Note c = new Note(titre, texte);
            notes.add(c);
        }
        if (notes.isEmpty()){
            Toast.makeText(this, "Hey... You didn't create any notes ! -3-", Toast.LENGTH_SHORT).show();
        }
        return notes;
    }


}