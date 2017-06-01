package com.mmm.a370333.matchmakermaker;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

/**
 * Created by 370333 on 5/30/17.
 */
public class MakeFreeResponse extends Activity{
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.make_freeresponse);

        Spinner pointValue = (Spinner) findViewById(R.id.spn_questionPoints);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.sa_pointValue,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        pointValue.setAdapter(adapter);
    }
}
