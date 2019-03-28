package ranji.makonotes;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.regex.PatternSyntaxException;

public class GestionNotes{

    public ArrayList<String> listFilesForFolder(File folder) {
        ArrayList<String> liste = new ArrayList<>();
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                listFilesForFolder(fileEntry);
            } else {
                liste.add(fileEntry.getName());
            }
        }
        return liste;
    }


    public String lire(String filename, Context context){
        String test = "";
        FileInputStream inputStream;
        File directory = context.getFilesDir();
        File file = new File(directory, filename);
        try {
            inputStream = new FileInputStream(file);
            Scanner s = new Scanner(inputStream).useDelimiter("\\A");
            test = s.hasNext() ? s.next() : "";
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return test;
    }

    public void ecrire(String filename,String fileContents, Context context){
        FileOutputStream outputStream;
        try {
            outputStream = context.openFileOutput(filename, context.MODE_PRIVATE);
            File directory = context.getFilesDir();
            File file = new File(directory, filename);
            outputStream.write(fileContents.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




}
