package com.mmm.a370333.matchmakermaker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

/**
 * Created by 370333 on 6/8/17.
 */
public class MakeMultResponse extends Activity{

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.make_multresponse);

        int questionAmount = R.id.spn_questionAmount;
        Intent intentBundle = new Intent(MakeMultResponse.this,QuestionType.class);
        final Bundle bundleNew = new Bundle();
        bundleNew.putInt("questionAmount",questionAmount);

        Spinner point1 = (Spinner) findViewById(R.id.spn_pts1);
        Spinner point2 = (Spinner) findViewById(R.id.spn_pts2);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.sa_pointValue, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        point1.setAdapter(adapter);
        point2.setAdapter(adapter);

        Button btn_next = (Button) findViewById(R.id.btn_next);
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int_next = new Intent(v.getContext(), QuestionType.class);
                int_next.putExtras(bundleNew);
                startActivityForResult(int_next, 0);
            }
        });
    }
}
