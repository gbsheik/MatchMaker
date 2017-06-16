package com.mmm.a370333.matchmakermaker;

import android.app.Activity;
import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by ShivLuthra on 6/15/17.
 */

public class FinishMake extends Activity {

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.finish_make);
        final Bundle bundle = getIntent().getExtras();

        Button btn_return = (Button) findViewById(R.id.btn_return);
        btn_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int_return = new Intent(view.getContext(), TitleScreen.class);
                int_return.putExtras(bundle);
                startActivityForResult(int_return, 0);
            }
        });
    }
}
