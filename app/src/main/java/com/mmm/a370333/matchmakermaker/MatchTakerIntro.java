package com.mmm.a370333.matchmakermaker;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


/**
 * Created by 348633 on 6/14/17.
 */
public class MatchTakerIntro extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.match_taker_intro);

        Button btn_next = (Button) findViewById(R.id.backButton);
        btn_next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent int_next = new Intent(view.getContext(), TitleScreen.class);
                startActivityForResult(int_next, 0);
            }
        });
    }
}
