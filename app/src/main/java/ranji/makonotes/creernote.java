package ranji.makonotes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class creernote extends AppCompatActivity implements View.OnClickListener {
    private ImageButton savenote;
    private EditText note;
    private EditText title;
    private String notetitle;
    private String notetext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creernote);
        Intent intent = getIntent();
        String parent = intent.getStringExtra("parent");
        title = findViewById(R.id.icon);
        note = findViewById(R.id.nouvnote);

        if(parent != "menu"){
            String nom = intent.getStringExtra("titre");
            String contenu = intent.getStringExtra("note");
            title.setText(nom);
            note.setText(contenu);
        }

        savenote = findViewById(R.id.save);
        savenote.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        notetitle = title.getText().toString();
        notetext = note.getText().toString();
        if(view == savenote){
            if(notetitle.isEmpty()){
                Toast.makeText(creernote.this,"Please, name your note °3° ! ",
                        Toast.LENGTH_SHORT).show();
            }
            else{
                GestionNotes nouvelleNote = new GestionNotes();
                nouvelleNote.ecrire(notetitle,notetext,this);
                Toast.makeText(this, "Yay, note saved hihi +3+ ! ", Toast.LENGTH_SHORT).show();
                Intent retour = new Intent(this,Main2Activity.class);
                this.startActivityForResult(retour,10);
                finish();
            }
        }
    }

}
