package ranji.makonotes;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class NoteAdapter extends ArrayAdapter<Note> {
    private ArrayList<Note> Notes;
    private Context context;

    public NoteAdapter(Context context, ArrayList<Note> Notes) {
        super(context, R.layout.activity_main3, R.id.product_name, Notes);
        this.Notes = Notes;
        this.context = context;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)
                getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.activity_main3, parent, false);
        }
        TextView texte = convertView.findViewById(R.id.product_name);
        TextView titre = convertView.findViewById(R.id.icon);

        titre.setText(getItem(position).getTitle());
        texte.setText(getItem(position).getText());


        //Handle buttons and add onClickListeners
        Button deleteBtn = (Button)convertView.findViewById(R.id.delete_btn);
        Button addBtn = (Button)convertView.findViewById(R.id.add_btn);

        final Note lanote = Notes.get(position);

        deleteBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //do something
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);

                // Setting Dialog Title
                alertDialog.setTitle(lanote.getTitle());
                // Setting Icon to Dialog
                alertDialog.setIcon(R.drawable.lelogomini);
                final String titre = lanote.getTitle();
                // Setting Dialog Message
                alertDialog.setMessage("Delete ?");
                alertDialog.setPositiveButton("Yes +3+", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        context.deleteFile(titre);
                        Toast.makeText(context, "I killed the entry master ^3^ ", Toast.LENGTH_SHORT).show();
                        Intent retour = new Intent(context,Main2Activity.class);
                        context.startActivity(retour);
                        ((Activity) context).finish();
                    }
                });

                alertDialog.setNeutralButton("No ! >3<", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                // Showing Alert Message
                alertDialog.show();
                notifyDataSetChanged();
            }
        });
        addBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent creernotes = new Intent(context,creernote.class);
                creernotes.putExtra("parent","edit");
                creernotes.putExtra("titre",lanote.getTitle());
                creernotes.putExtra("note", lanote.getText());
                context.startActivity(creernotes);
                notifyDataSetChanged();
            }
        });


        return convertView;
    }
}
