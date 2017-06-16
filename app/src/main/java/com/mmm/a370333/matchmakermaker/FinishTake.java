package com.mmm.a370333.matchmakermaker;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by ShivLuthra on 6/16/17.
 */

public class FinishTake extends Activity{

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.finish_take);

        Bundle bundle = getIntent().getExtras();
        System.out.println(bundle.getInt("pointsEarned"));
        TextView finalScore = (TextView) findViewById(R.id.finalScore);
        finalScore.setText(""+bundle.getInt("pointsEarned"));
    }
}
