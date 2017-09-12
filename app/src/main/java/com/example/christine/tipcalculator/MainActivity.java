package com.example.christine.tipcalculator;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.text.TextWatcher;
import android.text.Editable;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private EditText mealCostEditText;
    private Button oneToThreeButton;
    private Button fourToFiveButton;
    private Button sixToSevenButton;
    private Button eightToNineButton;
    private Button tenButton;
    private TextView percentTipTextView;
    private TextView suggestedTipTextView;
    private TextView displayMealCostTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mealCostEditText = (EditText) findViewById(R.id.et_MealCost);
        this.oneToThreeButton = (Button) findViewById(R.id.btn_OneToThree);
        this.fourToFiveButton = (Button) findViewById(R.id.btn_FourToFive);
        this.sixToSevenButton = (Button) findViewById(R.id.btn_SixToSeven);
        this.eightToNineButton = (Button) findViewById(R.id.btn_EightToNine);
        this.tenButton = (Button) findViewById(R.id.btn_Ten);
        this.percentTipTextView = (TextView) findViewById(R.id.tv_PercentTip);
        this.suggestedTipTextView = (TextView) findViewById(R.id.tv_SuggestedTip);
        this.displayMealCostTextView = (TextView) findViewById(R.id.tv_DisplayMealCost);

        this.mealCostEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(s.length()>0)
                {
                    //accounts for entries beginning with a decimal point
                    if(s.toString().equals(".")) {
                        displayMealCostTextView.setText("$0.");
                    }
                    //displays the cost of the meal with formatting
                    else {
                        double mealCost = Double.valueOf(mealCostEditText.getText().toString());
                        displayMealCostTextView.setText(String.format(Locale.US, "$%.2f", mealCost));
                    }
                }
                //when the editText is empty
                else{
                    displayMealCostTextView.setText("$0");
                    suggestedTipTextView.setText("");
                    percentTipTextView.setText("");
                }
            }
        });

        //each button pulls the meal cost from the edit text, calculates tip, and displays it

        this.oneToThreeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mealCostEditText.getText().toString().length()!=0) {
                    double mealCost = Double.valueOf(mealCostEditText.getText().toString());
                    if (mealCost >= 0) {
                        double totalTip = calculateTip(0.10, mealCost);
                        changeText(10, totalTip);
                    }
                }
            }
        });

        this.fourToFiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mealCostEditText.getText().toString().length()!=0) {
                    double mealCost = Double.valueOf(mealCostEditText.getText().toString());
                    if (mealCost >= 0) {
                        double totalTip = calculateTip(0.13, mealCost);
                        changeText(13, totalTip);
                    }
                }
            }
        });

        this.sixToSevenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mealCostEditText.getText().toString().length()!=0) {
                    double mealCost = Double.valueOf(mealCostEditText.getText().toString());
                    if (mealCost >= 0) {
                        double totalTip = calculateTip(0.15, mealCost);
                        changeText(15, totalTip);
                    }
                }
            }
        });

        this.eightToNineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mealCostEditText.getText().toString().length()!=0) {
                    double mealCost = Double.valueOf(mealCostEditText.getText().toString());
                    if (mealCost >= 0) {
                        double totalTip = calculateTip(0.20, mealCost);
                        changeText(20, totalTip);
                    }
                }
            }
        });

        this.tenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mealCostEditText.getText().toString().length()!=0) {
                    double mealCost = Double.valueOf(mealCostEditText.getText().toString());
                    if (mealCost >= 0) {
                        double totalTip = calculateTip(0.25, mealCost);
                        changeText(25, totalTip);
                    }
                }
            }
        });
    }

    //calculates tip given the percent and total
    private double calculateTip(double percent, double total) {
        return percent * total;
    }

    //Changes the text to display tip based on button selected
    private void changeText(int percentTip, double totalTip){
        percentTipTextView.setText("");
        percentTipTextView.setText(percentTip+"% tip");
        suggestedTipTextView.setText("");
        suggestedTipTextView.setText(String.format(Locale.US, "Suggested tip: \n$%.2f",totalTip));

    }
}



