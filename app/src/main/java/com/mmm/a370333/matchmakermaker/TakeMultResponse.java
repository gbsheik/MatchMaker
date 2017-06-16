package com.mmm.a370333.matchmakermaker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;

/**
 * Created by 370333 on 6/16/17.
 */
public class TakeMultResponse extends Activity {

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.take_multresponse);

        final Bundle bundle = getIntent().getExtras();
        System.out.println("Pts:" + bundle.getInt("pointsEarned"));
        final int questionNum = bundle.getInt("questionNumber");
        int questionAmount = bundle.getInt("questionAmount");
        System.out.println(questionNum);
        System.out.println(Arrays.toString(bundle.getStringArray("mc_choices")));
        TextView question = (TextView)findViewById(R.id.mc_question);
        question.setText(bundle.getStringArray("mc_questions")[questionNum]);
        TextView choice1 = (TextView) findViewById(R.id.answer1);
        choice1.setText(bundle.getStringArray("mc_choices")[questionNum*3]);
        TextView choice2 = (TextView) findViewById(R.id.answer2);
        choice2.setText(bundle.getStringArray("mc_choices")[questionNum*3+1]);
        TextView choice3 = (TextView) findViewById(R.id.answer3);
        choice3.setText(bundle.getStringArray("mc_choices")[questionNum*3+2]);

        Button btn_a = (Button) findViewById(R.id.btn_choice1);
        Button btn_b = (Button) findViewById(R.id.btn_choice2);
        Button btn_c = (Button) findViewById(R.id.btn_choice3);

        btn_a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pointsEarned = bundle.getInt("pointsEarned");
                pointsEarned += bundle.getIntArray("mc_points")[questionNum*3];
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
                }
            }
        });
        btn_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pointsEarned = bundle.getInt("pointsEarned");
                pointsEarned += bundle.getIntArray("mc_points")[questionNum*3+1];
                bundle.putInt("pointsEarned", pointsEarned);
                bundle.putInt("questionNumber", questionNum+1);
                if (questionNum == bundle.getInt("questionAmount")-1){

                }
                else{
                    if (bundle.getStringArray("questionType")[questionNum+1].equals("mc")){
                        Intent int_next = new Intent(view.getContext(), TakeMultResponse.class);
                        int_next.putExtras(bundle);
                        startActivityForResult(int_next, 0);
                    }
                }
            }
        });
        btn_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pointsEarned = bundle.getInt("pointsEarned");
                pointsEarned += bundle.getIntArray("mc_points")[questionNum*3+2];
                bundle.putInt("pointsEarned", pointsEarned);
                bundle.putInt("questionNumber", questionNum+1);
                if (questionNum == bundle.getInt("questionAmount")-1){
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
                }
            }
        });

    }
}
