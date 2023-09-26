package com.example.repairorder;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    View.OnClickListener submitListener = new View.OnClickListener() {
        @SuppressLint({"SetTextI18n", "DefaultLocale"})
        @Override
        public void onClick(View view) {
            order = orderType.getText().toString();
            tech = technicianET.getText().toString();
            cost_inspection = Double.parseDouble(inspection.getText().toString());
            cost_paint = Double.parseDouble(paint.getText().toString());
            cost_part = Double.parseDouble(parts.getText().toString());
            cost_labor = Double.parseDouble(labor.getText().toString());


            double t = cost_inspection + cost_paint + cost_part + cost_labor;
            subTotalText.setText("$" + String.format("%.2f",t));
            taxText.setText("$" + String.format("%.2f",t/9.25));
            totalText.setText("$" + String.format("%.2f", t + (t / 9.25)));

        }
    };

    AdapterView.OnItemSelectedListener spinListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            String message = adapterView.getItemAtPosition(i).toString();
            Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    };
    Button submitButton;
    EditText orderType,technicianET, inspection, paint, parts, labor;
    TextView subTotalText, taxText, totalText;
    String order, tech;

    double cost_inspection, cost_paint, cost_part, cost_labor;
    //double sub = 0;

    Spinner spin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        submitButton = findViewById(R.id.submit_button);
        technicianET = findViewById(R.id.technicianEdit);


        inspection = findViewById(R.id.inspect_edit);
        paint = findViewById(R.id.paint_edit);
        parts = findViewById(R.id.parts_edit);
        labor = findViewById(R.id.labor_edit);
        spin = findViewById(R.id.spin);


        taxText = findViewById(R.id.tax_value);
        taxText.setText("$0.0");
        totalText = findViewById(R.id.total_value);
        totalText.setText("$0.0");
        subTotalText = findViewById(R.id.subtotal_value);
        subTotalText.setText("$0.0");

        spin.setOnItemSelectedListener(spinListener);
        ArrayList<String> valuesList = new ArrayList<>();
        valuesList.add("Regular");
        valuesList.add("Butter");

        ArrayAdapter<String> typeAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,valuesList);
        spin.setAdapter(typeAdapter);
        inspection.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                cost_inspection = Double.parseDouble(inspection.getText().toString());

                double sub = cost_inspection;
                subTotalText.setText("$" + String.format("%.2f", sub));
                taxText.setText("$" + String.format("%.2f", sub / 9.25));
                totalText.setText("$" + String.format("%.2f", sub + (sub / 9.25)));
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        paint.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                cost_paint = Double.parseDouble(paint.getText().toString());

                double sub = cost_inspection + cost_paint;
                subTotalText.setText("$" + String.format("%.2f", sub));
                taxText.setText("$" + String.format("%.2f", sub / 9.25));
                totalText.setText("$" + String.format("%.2f", sub + (sub / 9.25)));
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        parts.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                cost_part = Double.parseDouble(parts.getText().toString());

                double sub = cost_inspection + cost_paint + cost_part;
                subTotalText.setText("$" + String.format("%.2f", sub));
                taxText.setText("$" + String.format("%.2f", sub / 9.25));
                totalText.setText("$" + String.format("%.2f", sub + (sub / 9.25)));
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        labor.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                cost_labor = Double.parseDouble(labor.getText().toString());

                double sub = cost_inspection + cost_paint + cost_part + cost_labor;
                subTotalText.setText("$" + String.format("%.2f", sub));
                taxText.setText("$" + String.format("%.2f", sub / 9.25));
                totalText.setText("$" + String.format("%.2f", sub + (sub / 9.25)));
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        submitButton.setOnClickListener(submitListener);
    }


}