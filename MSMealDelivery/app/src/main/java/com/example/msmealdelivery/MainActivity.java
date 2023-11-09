package com.example.msmealdelivery;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText edtName;
    private TextInputEditText edtPhone;
    private Button btnSubmit;
    private RadioGroup rgSubsPlan;
    private Spinner spnPlanType;
    private CheckBox chkLemonade;
    private CheckBox chkMilk;
    private Spinner TypeofDelivery;
    private EditText edtSubscriptionDate;
    private TextView textViewPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the UI components
        edtName = findViewById(R.id.edtName);
        edtPhone = findViewById(R.id.edtPhone);
        btnSubmit = findViewById(R.id.btnSubmit);
        rgSubsPlan = findViewById(R.id.rgSubsPlan);
        spnPlanType = findViewById(R.id.spnPlanType);
        chkLemonade = findViewById(R.id.chkLemonade);
        chkMilk = findViewById(R.id.chkMilk);
        TypeofDelivery = findViewById(R.id.TypeofDelivery);
        edtSubscriptionDate = findViewById(R.id.edtDate);
        textViewPrice = findViewById(R.id.textViewPrice);

        // Set a click listener for the submit button
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String customerName = edtName.getText().toString();
                String phoneNumber = edtPhone.getText().toString();
                String message = "Customer Name: " + customerName + "\nPhone Number: " + phoneNumber;
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
            }
        });

        rgSubsPlan.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                if (checkedId == R.id.rdMonthly) {
                    // Enable the Spinner for monthly plan
                    spnPlanType.setEnabled(true);
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                            MainActivity.this, R.array.monthly_plan_options, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spnPlanType.setAdapter(adapter);

                    // Enable and uncheck additional features for monthly plan
                    chkLemonade.setEnabled(true);
                    chkMilk.setEnabled(true);
                    chkLemonade.setChecked(false);
                    chkMilk.setChecked(false);
                    calculateAndDisplayPrice("monthly");

                    // Enable the TypeofDelivery Spinner
                    TypeofDelivery.setEnabled(true);
                } else if (checkedId == R.id.rdYearly) {
                    // Enable the Spinner for yearly plan
                    spnPlanType.setEnabled(true);
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                            MainActivity.this, R.array.yearly_plan_options, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spnPlanType.setAdapter(adapter);

                    // Disable and uncheck additional features for yearly plan
                    chkLemonade.setChecked(false);
                    chkMilk.setChecked(false);
                    chkLemonade.setEnabled(false);
                    chkMilk.setEnabled(false);
                    calculateAndDisplayPrice("yearly");

                    // Now, populate the TypeofDelivery Spinner based on the selected plan
                    ArrayAdapter<CharSequence> deliveryAdapter = ArrayAdapter.createFromResource(
                            MainActivity.this, R.array.delivery_types, android.R.layout.simple_spinner_item);
                    deliveryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    TypeofDelivery.setAdapter(deliveryAdapter);
                }
            }
        });

        edtSubscriptionDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(android.widget.DatePicker view, int year, int month, int day) {
                                String selectedDate = year + "-" + (month + 1) + "-" + day;
                                edtSubscriptionDate.setText(selectedDate);
                            }
                        },
                        year, month, day
                );
                datePickerDialog.show();
            }
        });
    }

    private void calculateAndDisplayPrice(String subscriptionType) {
        int deliveryPrice = 0;

        int selectedDeliveryType = TypeofDelivery.getSelectedItemPosition();

        String[] deliveryPricesMonthly = getResources().getStringArray(R.array.delivery_prices_monthly);
        String[] deliveryPricesYearly = getResources().getStringArray(R.array.delivery_prices_yearly);

        if (subscriptionType.equals("monthly")) {
            if (selectedDeliveryType >= 0 && selectedDeliveryType < deliveryPricesMonthly.length) {
                String priceString = deliveryPricesMonthly[selectedDeliveryType];
                deliveryPrice = Integer.parseInt(priceString.replaceAll("[^0-9]", ""));
            }
        } else if (subscriptionType.equals("yearly")) {
            if (selectedDeliveryType >= 0 && selectedDeliveryType < deliveryPricesYearly.length) {
                String priceString = deliveryPricesYearly[selectedDeliveryType];
                deliveryPrice = Integer.parseInt(priceString.replaceAll("[^0-9]", ""));
            }
        }

        textViewPrice.setText("Delivery Price: CAD " + deliveryPrice);
    }


}
