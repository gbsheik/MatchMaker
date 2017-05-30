package com.mmm.a370333.matchmakermaker;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;

/**
 * Created by 370333 on 5/24/17.
 */
public class Activity2 extends Activity{

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.questionprompt);
        Spinner questionNumber = (Spinner)findViewById(R.id.textField1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.questionCount, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        questionNumber.setAdapter(adapter);

    }
}
