package com.example.admin.xo;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class kisiEkleme extends AppCompatActivity implements AdaptorListener{
    DatabaseHelper myDatabesHelper;
    List<ModelTxt> myDataSet;
    Button addButton;
    EditText textEdit;
    RecyclerView rv ;
    AdapterRV adap;
    private TextToSpeech siri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kisi_ekleme);
        myDatabesHelper = new DatabaseHelper(this);
        myDataSet = ModelTxt.cursorToArray(myDatabesHelper.getData());


        addButton = findViewById(R.id.add);
        textEdit = findViewById(R.id.name);
        addButton.setOnClickListener(   new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String onProcess=textEdit.getText().toString();
                if(!(textEdit.getText().toString().isEmpty())){
                    myDatabesHelper.addData(onProcess);
                    myDataSet.add(new ModelTxt((myDatabesHelper.getLastId()),onProcess));
                    textEdit.setText("");
                    adap.notifyDataSetChanged();

                }
            }
        });
        siri = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if(i!=TextToSpeech.ERROR){
                    siri.setLanguage(Locale.ENGLISH);
                }
            }
        });
        initializeRV();
    }

    private void initializeRV(){
        rv = findViewById(R.id.list);
        adap = new AdapterRV(this,myDataSet,this);
        rv.setAdapter(adap);
        rv.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onItemClick(View view, int position) {
        if(view.getId()==R.id.del){
            myDatabesHelper.delData(myDataSet.get(position).getId());
            myDataSet.remove(position);
            adap.notifyDataSetChanged();

        }
        else if (view.getId()== R.id.parent_layout){
            siri.speak(myDataSet.get(position).getText(),TextToSpeech.QUEUE_FLUSH,null);
        }
    }
}
