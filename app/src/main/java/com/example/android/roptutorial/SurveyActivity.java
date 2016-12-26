package com.example.android.roptutorial;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioGroup;

public class SurveyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey);

        RadioGroup rg = (RadioGroup) findViewById(R.id.premature_birth_button);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
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

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.tutorial_button);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedID) {
                switch (checkedID) {
                    case R.id.tutorial_yes:
                        Log.v("SurveyActivity", "yes tutorial");
                        break;
                    case R.id.tutorial_no:
                        Log.v("SurveyActivity", "no tutorial");
                        break;
                }
            }
        });

        final CheckBox expectingChildCheckBox = (CheckBox) findViewById(R.id.expecting_child_checkbox);
        expectingChildCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(expectingChildCheckBox.isChecked())
                    Log.v("SurveyActivity", "expecting cb selected");
            }
        });

        final CheckBox prematureNewbornCheckbox = (CheckBox) findViewById(R.id.premature_newborn_checkbox);
        prematureNewbornCheckbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(prematureNewbornCheckbox.isChecked())
                    Log.v("SurveyActivity", "newborn cb selected");
            }
        });

        final CheckBox knowSomeoneCheckBox = (CheckBox) findViewById(R.id.know_someone_checkbox);
        knowSomeoneCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(knowSomeoneCheckBox.isChecked())
                    Log.v("SurveyActivity", "know someone cb selected");
            }
        });



    }

}