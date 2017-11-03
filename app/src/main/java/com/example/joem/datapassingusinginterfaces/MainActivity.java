package com.example.joem.datapassingusinginterfaces;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.LinkedList;

//implements IData interface
public class MainActivity extends AppCompatActivity implements GetTweetsAsyncTask.IData{

    LinkedList<String>data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //execute passes some url?
                //Instance of MainActivity passed here but that's ok bc all it ends up passing is the implementation of the interface
                new GetTweetsAsyncTask(MainActivity.this).execute("");
            }
        });
    }
    //method part of naive approach; commented out
    /*public void handleData(LinkedList<String>data){
        this.data=data;

        AlertDialog.Builder builderName = new AlertDialog.Builder(this);
        builderName.setTitle("Tweets")
                .setItems(data.toArray(new CharSequence[data.size()]), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
        final AlertDialog alertDialogName = builderName.create();
        alertDialogName.show();
    }*/

    @Override//implemented method similar to the 'handleData' method above
    public void handleListData(LinkedList<String> parameterName) {
        this.data=parameterName;

        AlertDialog.Builder builderName = new AlertDialog.Builder(this);
        builderName.setTitle("Tweets")
                .setItems(data.toArray(new CharSequence[data.size()]), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
        final AlertDialog alertDialogName = builderName.create();
        alertDialogName.show();
    }
}
