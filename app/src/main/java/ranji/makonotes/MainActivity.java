package ranji.makonotes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageButton newnote;
    private ImageButton listnote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        newnote = (ImageButton) findViewById(R.id.newnote);
        newnote.setOnClickListener(this);

        listnote = (ImageButton) findViewById(R.id.listnotes);
        listnote.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        if(view == newnote){
            Intent creernotes = new Intent(this,creernote.class);
            creernotes.putExtra("parent","menu");
            this.startActivityForResult(creernotes,10);
        }

        if(view == listnote){
            Intent listnotes = new Intent(this,Main2Activity.class);
            this.startActivityForResult(listnotes,10);
        }



    }
}
