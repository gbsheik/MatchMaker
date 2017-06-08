package com.mmm.a370333.matchmakermaker;

        import android.app.Activity;
        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.*;

/**
 * Created by 370333 on 5/24/17.
 */
public class QuestionAmount extends Activity{

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.questionprompt);
        Spinner questionNumber = (Spinner)findViewById(R.id.spn_questionAmount);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.sa_questionAmount, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        questionNumber.setAdapter(adapter);

        int questionAmount = R.id.spn_questionAmount;
        Intent intentBundle = new Intent(QuestionAmount.this,QuestionType.class);
        final Bundle bundle = new Bundle();
        bundle.putInt("questionAmount",questionAmount);
        //This seems weird to me. Does this just mean that when the new activity starts, it will have this Intent.
        //Not that the new activity is called and started by this one
        //startActivity(intentBundle);

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
