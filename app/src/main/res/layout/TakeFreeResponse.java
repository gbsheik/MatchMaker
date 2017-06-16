package com.mmm.a370333.matchmakermaker;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Patrick on 6/16/2017.
 */

public class TakeFreeResponse extends Activity{

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.take_freeresponse);

        final Bundle bundle = getIntent().getExtras();
        System.out.println("Pts:" + bundle.getInt("pointsEarned"));
        final int questionNum = bundle.getInt("questionNumber");
        int questionAmount = bundle.getInt("questionAmount");
        bundle.getStringArray("fr_answers");
        System.out.println(questionNum);
        TextView question = (TextView)findViewById(R.id.fr_question);
        question.setText(bundle.getStringArray("fr_questions")[questionNum]);


        final EditText response = (EditText) findViewById(R.id.fr_space);
        Button btn_a = (Button) findViewByID(R.id.Next);


        btn_a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pointsEarned = bundle.getInt("pointsEarned");
                if(fr_answers[questionNum]==response.getText().toString()) {
                    pointsEarned += bundle.getIntArray("fr_points")[questionNum * 3];
                }
                bundle.putInt("pointsEarned", pointsEarned);
                bundle.putInt("questionNumber", questionNum+1);
                System.out.println(questionNum + " " + bundle.getStringArray("questionType").length);
                if (questionNum+1 == bundle.getStringArray("questionType").length){
                    Intent int_next = new Intent(view.getContext(), FinishTake.class);
                    int_next.putExtras(bundle);
                    startActivityForResult(int_next, 0);
                }
                else{
                    if (bundle.getStringArray("questionType")[questionNum+1].equals("mc")){
                        Intent int_next = new Intent(view.getContext(), TakeMultResponse.class);
                        int_next.putExtras(bundle);
                        startActivityForResult(int_next, 0);
                    }
                    else {
                        Intent int_next = new Intent(view.getContext(), TakeFreeResponse.class);
                        int_next.putExtras(bundle);
                        startActivityForResult(int_next, 0);
                    }
                }
            }
        });


    }
}

    }
}
