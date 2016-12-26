package com.example.android.roptutorial;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;

public class SurveyActivity extends AppCompatActivity {

    private boolean knowsRisksPrematureBirth = false;
    private boolean wasTutorialHelpful = false;
    private boolean isExpectingChild = false;
    private boolean hasPrematureNewBorn = false;
    private boolean knowsSomeoneWithROP = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey);

        RadioGroup rg = (RadioGroup) findViewById(R.id.premature_birth_button);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.premature_birth_button_yes:
                        knowsRisksPrematureBirth = true;
                        Log.v("SurveyActivity", "knowsRisksPrematureBirth " + knowsRisksPrematureBirth);
                        break;
                    case R.id.premature_birth_button_no:
                        knowsRisksPrematureBirth = false;
                        Log.v("SurveyActivity", "knowsRisksPrematureBirth " + knowsRisksPrematureBirth);
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
                        wasTutorialHelpful = true;
                        Log.v("SurveyActivity", "wasTutorialHelpful " + wasTutorialHelpful);
                        break;
                    case R.id.tutorial_no:
                        wasTutorialHelpful = false;
                        Log.v("SurveyActivity", "wasTutorialHelpful " + wasTutorialHelpful);
                        break;
                }
            }
        });

        final CheckBox expectingChildCheckBox = (CheckBox) findViewById(R.id.expecting_child_checkbox);
        expectingChildCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(expectingChildCheckBox.isChecked()) {
                    isExpectingChild = true;
                    Log.v("SurveyActivity", "isExpectingChild " + isExpectingChild);
                }
                else
                    isExpectingChild = false;
            }
        });

        final CheckBox prematureNewbornCheckbox = (CheckBox) findViewById(R.id.premature_newborn_checkbox);
        prematureNewbornCheckbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(prematureNewbornCheckbox.isChecked()) {
                    hasPrematureNewBorn = true;
                    Log.v("SurveyActivity", "hasPrematureNewBorn " + hasPrematureNewBorn);
                }
                else
                    hasPrematureNewBorn = false;
            }
        });

        final CheckBox knowSomeoneCheckBox = (CheckBox) findViewById(R.id.know_someone_checkbox);
        knowSomeoneCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(knowSomeoneCheckBox.isChecked()) {
                    knowsSomeoneWithROP = true;
                }
                else {
                    knowsSomeoneWithROP = false;
                }

            }
        });

        Button submitSurveyButton = (Button) findViewById(R.id.submit_survey_button);
        //final String finalSurveyResult = surveyResult;
        submitSurveyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String surveyResult = surveyResultMessage();
                submitSurvey(surveyResult);
            }
        });

    }

    @NonNull
    private String surveyResultMessage() {
        String surveyResult = "Thank you for taking part on our survey. This is the information you have provided to us:\n";
        surveyResult += "\n\n" + getString(R.string.premature_birth) + " " + knowsRisksPrematureBirth;
        surveyResult += "\n\n" + getString(R.string.tutorial) + " " + wasTutorialHelpful;
        surveyResult += "\n\n" + getString(R.string.fits_you_more);
        surveyResult += "\n\n" + getString(R.string.expecting_child) + ": " + isExpectingChild;
        surveyResult += "\n\n" + getString(R.string.has_a_premature_child) + ": " + hasPrematureNewBorn;
        surveyResult += "\n\n" + getString(R.string.knows_someone) + ": " + knowsSomeoneWithROP;
        return surveyResult;
    }

    public void submitSurvey(String surveyResult) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL, "francislainy.campos@gmail.com");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Survey Result for ROP");
        intent.putExtra(Intent.EXTRA_TEXT, surveyResult);

        if(intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }

}