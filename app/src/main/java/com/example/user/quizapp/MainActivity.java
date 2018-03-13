package com.example.user.quizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int rightAnswers;
    EditText mEditTextAnswer3;
    Button mButtonSend;
    Button mButtonReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Hide "Reset" button
        mButtonReset = (Button) findViewById(R.id.button_reset);
        mButtonReset.setVisibility(View.GONE);
    }

    /**
     * Show the result after clicking "Send" button
     */
    public void displayResult(View view) {
        // Check the question 1
        RadioButton rbRightAnswer1 = (RadioButton) findViewById(R.id.radio_button_answer1_2);
        if (rbRightAnswer1.isChecked()) {
            rightAnswers++;
        }

        // Check the question 2
        CheckBox checkboxRightAnswer1 = (CheckBox) findViewById(R.id.checkbox_answer2_2);
        CheckBox checkboxRightAnswer2 = (CheckBox) findViewById(R.id.checkbox_answer2_3);
        if ((checkboxRightAnswer1.isChecked()) && (checkboxRightAnswer2.isChecked())) {
            rightAnswers++;
        }

        // Check the question 3
        mEditTextAnswer3 = (EditText) findViewById(R.id.edit_text_answer3);
        if (mEditTextAnswer3.getText().toString().toLowerCase().equals("oreo")) {
            rightAnswers++;
        }

        // Check the question 4
        RadioButton rbRightAnswer4 = (RadioButton) findViewById(R.id.radio_button_answer4_1);
        if (rbRightAnswer4.isChecked()) {
            rightAnswers++;
        }

        // Display the result
        if (rightAnswers == 4) {
            Toast.makeText(this, R.string.you_win, Toast.LENGTH_SHORT).show();
        } else {
            String result = getString(R.string.result, rightAnswers);
            Toast.makeText(this, result, Toast.LENGTH_LONG).show();
        }

        // Show "Reset" button, hide "Send" button
        mButtonReset = (Button) findViewById(R.id.button_reset);
        mButtonReset.setVisibility(View.VISIBLE);
        mButtonSend = (Button) findViewById(R.id.button_send);
        mButtonSend.setVisibility(View.GONE);
    }

    /**
     * Restoring initial settings of the controls
     */
    public void resetSettings(View view) {
        // Clear right answers
        rightAnswers = 0;

        // Clear all answers
        RadioGroup radioGroup1 = (RadioGroup) findViewById(R.id.radio_group_1);
        radioGroup1.clearCheck();
        RadioGroup radioGroup2 = (RadioGroup) findViewById(R.id.radio_group_2);
        radioGroup2.clearCheck();
        RadioGroup radioGroup3 = (RadioGroup) findViewById(R.id.radio_group_3);
        radioGroup3.clearCheck();
        mEditTextAnswer3.setText("");

        // Show "send" button, hide "reset" button
        mButtonSend = (Button) findViewById(R.id.button_send);
        mButtonSend.setVisibility(View.VISIBLE);
        mButtonReset = (Button) findViewById(R.id.button_reset);
        mButtonReset.setVisibility(View.GONE);
    }
}
