package com.example.joem.datapassingusinginterfaces;

import android.os.AsyncTask;

import java.util.LinkedList;

/**
 * Created by JoeM on 10/5/2017.
 */

//1st param: string of url to go to, 2nd void progress, 3rd returns linkedList of strings (tweets?)
public class GetTweetsAsyncTask extends AsyncTask<String, Void, LinkedList<String>> {

    //Naive approach (because passing whole 'activity'): passes instance of MainActivity; commented out
    /*MainActivity activity;
    public GetTweetsAsyncTask(MainActivity activity) {
        this.activity = activity;
    }*/

    //Instead of passing MainActivity we pass iData interface
    IData iDataName;
    public GetTweetsAsyncTask(IData iDataOther) {
        this.iDataName = iDataOther;
    }

    //(assuming we pass url?) returns list of tweets
    @Override
    protected LinkedList<String> doInBackground(String... strings) {
        LinkedList<String> linkedListName = new LinkedList<>();
        for (int i=0; i<10; i++){
            linkedListName.add("Tweet "+ i);//adds tweets
        }
        return linkedListName;//returns tweets
    }

    @Override
    protected void onPostExecute(LinkedList<String> strings) {
        //activity.handleData(strings);//part of naive approach of passing whole activity
        iDataName.handleListData(strings);
    }

    //An interface enables you to pick and choose what methods need to be implemented and not expose the whole class
    //the interface does not have a lot of methods like Main (so less is passed?)
    public static interface IData{//interface
        //when we define the interface we indicate:
        //scope view (public, etc), return value (void), method name (handleListData), type (LinkedList<String>),
            //name of parameter (parameterName), and any additional parameters (int, etc)
        public void handleListData(LinkedList<String> parameterName); //method
        //adding another method to an interface requires implementation of that method in MainActivity
            //but will be accessible in interface (iData) after implementing the new method (ex: iData.updateProgress)
    }
}
