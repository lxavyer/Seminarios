package com.leandro.textinputedittext;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    private ImageView iconView;
    private TextInputLayout nameInputLayout;
    private TextInputLayout passwordInputLayout;
    private TextInputLayout numberInputLayout;
    private Button signUpButton;
    private TextInputLayout emailInputLayout;
    private EditText emailEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iconView = findViewById(R.id.icon_view);
        nameInputLayout = findViewById(R.id.textInputLayout);
        passwordInputLayout = findViewById(R.id.passwordInputLayout);
        numberInputLayout = findViewById(R.id.numberInputLayout);
        signUpButton = findViewById(R.id.buttonPanel);
        emailInputLayout = findViewById(R.id.emailInputLayout);
        emailEditText = findViewById(R.id.email);

        EditText numberEditText = findViewById(R.id.number);


        signUpButton.setOnClickListener(v -> {
            String email = emailEditText.getText().toString().trim();
            if (!isValidEmail(email)) {
                emailInputLayout.setError("Endereço de e-mail inválido");
            } else {
                emailInputLayout.setError(null);  // Limpa o erro
            }
        });

        numberEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (s.length() > 11) {

                    numberInputLayout.setError("O número excede o limite de 10 dígitos");
                    numberInputLayout.setErrorIconDrawable(R.drawable.baseline_error_24);
                } else {

                    numberInputLayout.setError(null);
                    numberInputLayout.setErrorIconDrawable(null);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Não é necessário fazer nada aqui
            }
        });
    }

    private boolean isValidEmail(CharSequence email) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}