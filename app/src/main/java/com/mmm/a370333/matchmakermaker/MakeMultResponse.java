package com.mmm.a370333.matchmakermaker;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

/**
 * Created by 370333 on 6/8/17.
 */
public class MakeMultResponse extends Activity{

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.make_multresponse);

        Spinner point1 = (Spinner) findViewById(R.id.spn_pts1);
        Spinner point2 = (Spinner) findViewById(R.id.spn_pts2);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.sa_pointValue, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        point1.setAdapter(adapter);
        point2.setAdapter(adapter);
    }
}
