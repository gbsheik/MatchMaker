package com.mmm.a370333.matchmakermaker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class TitleScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.title);


        Button btn_next = (Button) findViewById(R.id.nextButton);
        btn_next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                Intent int_next = new Intent(view.getContext(), QuestionAmount.class);
                startActivityForResult(int_next, 0);
            }
        });

        Button btn_take = (Button) findViewById(R.id.btn_take);
        btn_take.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                if(getIntent()==null) {
                    Intent int_next = new Intent(view.getContext(), MatchTakerIntro.class);
                    startActivityForResult(int_next, 0);
                }
                else {
                    final Bundle bundle = getIntent().getExtras();
                    String[] questions = bundle.getStringArray("questionType");

                }
            }
        });
    }
}
