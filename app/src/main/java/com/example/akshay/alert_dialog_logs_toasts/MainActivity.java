package com.example.akshay.alert_dialog_logs_toasts;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Integer> selectedItemsList = new ArrayList<>();
    ListView lv;
    View convertView;
    ArrayList<String> names = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Working").setMessage("Hello");
        builder.show();*/

        LayoutInflater inflater = getLayoutInflater();
        convertView = (View) inflater.inflate(R.layout.my_library_alertdialog, null);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setView(convertView).setTitle("Click Any Files From Below");
        createListView();
        alertDialogBuilder.setPositiveButton("Positive Button", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        }).setNeutralButton("Neutral Button", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        }).setNegativeButton("Negative Button", null);
        alertDialogBuilder.show();
    }

    public void createListView() {
        ListView lv = (ListView) convertView.findViewById(R.id.alertDialog_listView);
        for (int i = 0; i < 20; i++) {
            names.add("Select "+i);
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.rowlayout, R.id.checkBoxRowLayout, names);
        lv.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String itemSelected = ((TextView) view).getText().toString();
                if (selectedItemsList.contains(itemSelected)) {
                    selectedItemsList.remove(itemSelected);
                } else {
                    selectedItemsList.add(i);
                }
                Toast.makeText(getApplicationContext(), "Clicked on  : " + itemSelected + "Number " + i, Toast.LENGTH_SHORT).show();
            }
        });
    }

    }