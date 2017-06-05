package com.mmm.a370333.matchmakermaker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Button;
import android.view.View;

/**
 * Created by 370333 on 5/30/17.
 */
public class MakeFreeResponse extends Activity{
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.make_freeresponse);

        final Bundle bundle = getIntent().getExtras();
        int questionAmount = bundle.getInt("questionAmount");

        while (questionAmount > 0) {
            Spinner pointValue = (Spinner) findViewById(R.id.spn_questionPoints);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.sa_pointValue, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            pointValue.setAdapter(adapter);
            questionAmount--;

            Button btn_next = (Button) findViewById(R.id.btn_next);
            btn_next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent int_next = new Intent(v.getContext(), QuestionType.class);
                    startActivityForResult(int_next, 0,bundle);
                }
            });
        }
    }
}
