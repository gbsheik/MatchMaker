package com.mmm.a370333.matchmakermaker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

/**
 * Created by 370333 on 6/8/17.
 */
public class MakeMultResponse extends Activity{

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.make_multresponse);

        final Bundle bundle = getIntent().getExtras();
        final int questionNumber = (int)bundle.get("questionAmount");
        final String[] questionType = bundle.getStringArray("questionType");
        questionType[questionNumber] = "mc";
        bundle.putStringArray("questionType", questionType);
        final String[] mc_choices = bundle.getStringArray("mc_choices");
        final String[] mc_questions = bundle.getStringArray("mc_questions");
        final int[] mc_points = bundle.getIntArray("mc_points");

        Integer[] pointItems = {0, 1, 2, 3, 4, 5};
        final Spinner point1 = (Spinner) findViewById(R.id.spn_pts1);
        final Spinner point2 = (Spinner) findViewById(R.id.spn_pts2);
        final Spinner point3 = (Spinner) findViewById(R.id.spn_pts3);
        ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(this, R.layout.support_simple_spinner_dropdown_item, pointItems);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        point1.setAdapter(adapter);
        point2.setAdapter(adapter);
        point3.setAdapter(adapter);
        final EditText et_choice1 = (EditText) findViewById(R.id.answer1);
        final EditText et_choice2 = (EditText) findViewById(R.id.answer2);
        final EditText et_choice3 = (EditText) findViewById(R.id.answer3);
        final EditText et_question = (EditText) findViewById(R.id.et_question);

        Button btn_next = (Button) findViewById(R.id.btn_next);
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mc_choices[questionNumber*3] = et_choice1.getText().toString();
                mc_choices[questionNumber*3+1] = et_choice2.getText().toString();
                mc_choices[questionNumber*3+2] = et_choice3.getText().toString();
                mc_points[questionNumber*3] = (int)point1.getSelectedItem();
                mc_points[questionNumber*3+1] = (int)point2.getSelectedItem();
                mc_points[questionNumber*3+2] = (int)point3.getSelectedItem();
                mc_questions[questionNumber] = et_question.getText().toString();
                bundle.putStringArray("mc_choices", mc_choices);
                bundle.putIntArray("mc_points", mc_points);
                bundle.putStringArray("mc_quesitons", mc_questions);

                if(bundle.getInt("questionAmount")==0){
                    Intent int_next = new Intent(view.getContext(), FinishMake.class);
                    int_next.putExtras(bundle);
                    startActivityForResult(int_next, 0);
                }
                else{
                    Intent int_next = new Intent(view.getContext(), QuestionType.class);
                    int_next.putExtras(bundle);
                    startActivityForResult(int_next,0);
                }
            }
        });
    }
}
