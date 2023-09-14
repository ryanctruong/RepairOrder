package com.example.repairorder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    View.OnClickListener submitListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            order = orderType.getText().toString();
            tech = technicianET.getText().toString();
            cost_inspection = Double.parseDouble(inspection.getText().toString());
            cost_paint = Double.parseDouble(paint.getText().toString());
            cost_part = Double.parseDouble(parts.getText().toString());
            cost_labor = Double.parseDouble(labor.getText().toString());


            double sub = cost_inspection + cost_paint + cost_part + cost_labor;
            subTotalText.setText("$" + String.valueOf(String.format("%.2f",sub)));
            taxText.setText("$" + String.valueOf(String.format("%.2f",sub/10)));
            totalText.setText("$" + String.valueOf(String.format("%.2f",sub + (sub/7))));

        }
    };
    Button submitButton;
    EditText orderType,technicianET, inspection, paint, parts, labor;
    TextView subTotalText, taxText, totalText;
    String order, tech, ins,pain,part,lab;

    double cost_inspection, cost_paint, cost_part, cost_labor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        submitButton = findViewById(R.id.submit_button);
        technicianET = findViewById(R.id.technicianEdit);
        subTotalText = findViewById(R.id.subtotal_value);

        orderType = findViewById(R.id.orderType_edit);
        inspection = findViewById(R.id.inspect_edit);
        paint = findViewById(R.id.paint_edit);
        parts = findViewById(R.id.parts_edit);
        labor = findViewById(R.id.labor_edit);

        taxText = findViewById(R.id.tax_value);
        totalText = findViewById(R.id.total_value);

        submitButton.setOnClickListener(submitListener);
    }
}