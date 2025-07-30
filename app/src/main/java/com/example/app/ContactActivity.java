package com.example.app;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class ContactActivity extends AppCompatActivity {

    private EditText etFirstName, etSurname, etEmail, etEnquiry;
    private Button btnSubmit;
    private TextView errorFirstName, errorSurname, errorEmail, errorEnquiry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact);

        // Initialize views
        initializeViews();

        // Set up form validation
        setupFormValidation();

        // Set up submit button
        setupSubmitButton();
    }

    private void initializeViews() {
        // Initialize EditText fields
        etFirstName = findViewById(R.id.et_first_name);
        etSurname = findViewById(R.id.et_surname);
        etEmail = findViewById(R.id.et_email);
        etEnquiry = findViewById(R.id.et_enquiry);
        btnSubmit = findViewById(R.id.btn_submit);

        // Create error TextViews dynamically and add them to the layout
        createErrorTextViews();
    }

    private void createErrorTextViews() {
        // Create error TextViews with styling
        errorFirstName = createErrorTextView();
        errorSurname = createErrorTextView();
        errorEmail = createErrorTextView();
        errorEnquiry = createErrorTextView();

        // Add error TextViews after each EditText
        addErrorTextViewAfterEditText(etFirstName, errorFirstName);
        addErrorTextViewAfterEditText(etSurname, errorSurname);
        addErrorTextViewAfterEditText(etEmail, errorEmail);
        addErrorTextViewAfterEditText(etEnquiry, errorEnquiry);
    }

    private TextView createErrorTextView() {
        TextView errorTextView = new TextView(this);
        errorTextView.setTextColor(ContextCompat.getColor(this, android.R.color.holo_red_light));
        errorTextView.setTextSize(12);
        errorTextView.setVisibility(View.GONE);
        errorTextView.setPadding(12, 4, 12, 8);
        return errorTextView;
    }

    private void addErrorTextViewAfterEditText(EditText editText, TextView errorTextView) {
        android.view.ViewGroup parent = (android.view.ViewGroup) editText.getParent();
        int index = parent.indexOfChild(editText);
        parent.addView(errorTextView, index + 1);
    }

    private void setupFormValidation() {
        // Real-time validation for First Name
        etFirstName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                validateFirstName();
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        // Real-time validation for Surname
        etSurname.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                validateSurname();
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        // Real-time validation for Email
        etEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                validateEmail();
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        // Real-time validation for Enquiry
        etEnquiry.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                validateEnquiry();
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
    }

    private void setupSubmitButton() {
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateForm()) {
                    submitForm();
                }
            }
        });
    }

    private boolean validateFirstName() {
        String firstName = etFirstName.getText().toString().trim();

        if (TextUtils.isEmpty(firstName)) {
            showError(errorFirstName, "First name is required");
            setEditTextError(etFirstName, true);
            return false;
        } else if (firstName.length() < 2) {
            showError(errorFirstName, "First name must be at least 2 characters");
            setEditTextError(etFirstName, true);
            return false;
        } else if (!firstName.matches("[a-zA-Z ]+")) {
            showError(errorFirstName, "First name should contain only letters");
            setEditTextError(etFirstName, true);
            return false;
        } else {
            hideError(errorFirstName);
            setEditTextError(etFirstName, false);
            return true;
        }
    }

    private boolean validateSurname() {
        String surname = etSurname.getText().toString().trim();

        if (TextUtils.isEmpty(surname)) {
            showError(errorSurname, "Surname is required");
            setEditTextError(etSurname, true);
            return false;
        } else if (surname.length() < 2) {
            showError(errorSurname, "Surname must be at least 2 characters");
            setEditTextError(etSurname, true);
            return false;
        } else if (!surname.matches("[a-zA-Z ]+")) {
            showError(errorSurname, "Surname should contain only letters");
            setEditTextError(etSurname, true);
            return false;
        } else {
            hideError(errorSurname);
            setEditTextError(etSurname, false);
            return true;
        }
    }

    private boolean validateEmail() {
        String email = etEmail.getText().toString().trim();

        if (TextUtils.isEmpty(email)) {
            showError(errorEmail, "Email is required");
            setEditTextError(etEmail, true);
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            showError(errorEmail, "Please enter a valid email address");
            setEditTextError(etEmail, true);
            return false;
        } else {
            hideError(errorEmail);
            setEditTextError(etEmail, false);
            return true;
        }
    }

    private boolean validateEnquiry() {
        String enquiry = etEnquiry.getText().toString().trim();

        if (TextUtils.isEmpty(enquiry)) {
            showError(errorEnquiry, "Enquiry message is required");
            setEditTextError(etEnquiry, true);
            return false;
        } else if (enquiry.length() < 10) {
            showError(errorEnquiry, "Enquiry must be at least 10 characters long");
            setEditTextError(etEnquiry, true);
            return false;
        } else if (enquiry.length() > 500) {
            showError(errorEnquiry, "Enquiry must be less than 500 characters");
            setEditTextError(etEnquiry, true);
            return false;
        } else {
            hideError(errorEnquiry);
            setEditTextError(etEnquiry, false);
            return true;
        }
    }

    private boolean validateForm() {
        boolean isFirstNameValid = validateFirstName();
        boolean isSurnameValid = validateSurname();
        boolean isEmailValid = validateEmail();
        boolean isEnquiryValid = validateEnquiry();

        return isFirstNameValid && isSurnameValid && isEmailValid && isEnquiryValid;
    }

    private void submitForm() {
        // Disable submit button to prevent multiple submissions
        btnSubmit.setEnabled(false);
        btnSubmit.setText("Submitting...");

        // Simulate form submission delay
        btnSubmit.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Show success toast
                Toast.makeText(ContactActivity.this,
                        "Thank you! Your message has been sent successfully!",
                        Toast.LENGTH_LONG).show();

                // Clear form fields
                clearForm();

                // Re-enable submit button
                btnSubmit.setEnabled(true);
                btnSubmit.setText("Submit");
            }
        }, 1500); // 1.5 second delay to simulate submission
    }

    private void clearForm() {
        etFirstName.setText("");
        etSurname.setText("");
        etEmail.setText("");
        etEnquiry.setText("");

        // Hide all error messages
        hideError(errorFirstName);
        hideError(errorSurname);
        hideError(errorEmail);
        hideError(errorEnquiry);

        // Reset EditText backgrounds
        setEditTextError(etFirstName, false);
        setEditTextError(etSurname, false);
        setEditTextError(etEmail, false);
        setEditTextError(etEnquiry, false);
    }

    private void showError(TextView errorTextView, String message) {
        errorTextView.setText(message);
        errorTextView.setVisibility(View.VISIBLE);
    }

    private void hideError(TextView errorTextView) {
        errorTextView.setVisibility(View.GONE);
    }

    private void setEditTextError(EditText editText, boolean hasError) {
        if (hasError) {
            // Create red border for error state
            GradientDrawable errorBackground = new GradientDrawable();
            errorBackground.setColor(0x88ADD8E6); // Keep your original background color
            errorBackground.setStroke(3, ContextCompat.getColor(this, android.R.color.holo_red_light));
            errorBackground.setCornerRadius(4);
            editText.setBackground(errorBackground);
        } else {
            // Reset to normal background
            GradientDrawable normalBackground = new GradientDrawable();
            normalBackground.setColor(0x88ADD8E6); // Your original background color
            normalBackground.setCornerRadius(4);
            editText.setBackground(normalBackground);
        }
    }

    // MENU SETUP
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu, menu);
        return true;
    }

    // MENU ITEM HANDLING
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.about_game) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            return true;

        } else if (id == R.id.gameplay_video) {
            Toast.makeText(this, "GAMEPLAY", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, GameplayVideoActivity.class);
            startActivity(intent);
            return true;

        } else if (id == R.id.game_location) {
            Intent intent = new Intent(this, GameLocationActivity.class);
            startActivity(intent);
            return true;

        } else if (id == R.id.faq) {
            Toast.makeText(this, "FAQ", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, FaqActivity.class);
            startActivity(intent);
            return true;

        } else if (id == R.id.contact_us) {
            Toast.makeText(this, "CONTACT", Toast.LENGTH_SHORT).show();
            // Already on contact page, no need to navigate
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}