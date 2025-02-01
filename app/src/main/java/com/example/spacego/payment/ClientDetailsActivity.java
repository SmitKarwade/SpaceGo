package com.example.spacego.payment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.spacego.R;
import com.example.spacego.databaseaccess.SpaceRepo;
import com.example.spacego.databaseaccess.UserDetails;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textview.MaterialTextView;

public class ClientDetailsActivity extends AppCompatActivity {

    private MaterialButton submit;
    private TextInputEditText firstNameEditText;
    private TextInputEditText lastNameEditText;
    private MaterialButton calendarButton;
    private TextInputEditText dateEditText;
    private TextInputEditText addressEditText;
    private TextInputEditText emailEditText;
    private TextInputEditText mobileEditText;

    private SpaceRepo spaceRepo = new SpaceRepo(ClientDetailsActivity.this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_client_details);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        firstNameEditText = findViewById(R.id.first_name);
        lastNameEditText = findViewById(R.id.last_name);
        calendarButton = findViewById(R.id.cal_icon_btn);
        dateEditText = findViewById(R.id.date_text);
        addressEditText = findViewById(R.id.address_txt);
        emailEditText = findViewById(R.id.email_txt);
        mobileEditText = findViewById(R.id.mobile_text);


        submit = findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!firstNameEditText.getText().toString().isEmpty() && !lastNameEditText.getText().toString().isEmpty()
                        && !dateEditText.getText().toString().isEmpty() && !addressEditText.getText().toString().isEmpty() &&
                !emailEditText.getText().toString().isEmpty() && !mobileEditText.getText().toString().isEmpty()){

                    UserDetails user = new UserDetails(firstNameEditText.getText().toString(),
                            lastNameEditText.getText().toString(),
                            dateEditText.getText().toString(),
                            addressEditText.getText().toString(),
                            Long.parseLong(mobileEditText.getText().toString()),
                            emailEditText.getText().toString());

                    spaceRepo.addUserDetails(user);

                    Intent intent = new Intent(ClientDetailsActivity.this, PaymentActivity.class);
                    startActivity(intent);

                    Toast.makeText(ClientDetailsActivity.this, "Saved", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(ClientDetailsActivity.this, "Enter all details", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}