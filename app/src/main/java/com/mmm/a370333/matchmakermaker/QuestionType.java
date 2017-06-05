package com.mmm.a370333.matchmakermaker;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

/**
 * Created by 370333 on 5/30/17.
 */
public class QuestionType extends Activity{
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final Bundle bundle = getIntent().getExtras();
        int questionAmount = bundle.getInt("questionAmount");

        if (questionAmount > 0) {
            setContentView(R.layout.questiontype);
            final Spinner questionType = (Spinner) findViewById(R.id.spn_questionType);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.sa_questionType, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            questionType.setAdapter(adapter);


            Button btn_next = (Button) findViewById(R.id.btn_make);
            btn_next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String type = questionType.getSelectedItem().toString();
                    if (type.equals("Free Response")) {

                        Intent int_next = new Intent(v.getContext(), MakeFreeResponse.class);
                        startActivityForResult(int_next, 0,bundle);
                    }
                }
            });
        }
    }
}

