package com.example.android.roptutorial;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.RadioGroup;

public class SurveyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey);

        RadioGroup rg = (RadioGroup) findViewById(R.id.premature_birth_button);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                    case R.id.premature_birth_button_yes:
                        // do operations specific to this selection
                        Log.v("SurveyActivity", "yes");
                        break;
                    case R.id.premature_birth_button_no:
                        // do operations specific to this selection
                        Log.v("SurveyActivity", "no");
                        break;
                }
            }
        });

    }

}
