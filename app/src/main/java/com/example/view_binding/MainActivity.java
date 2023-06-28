package com.example.view_binding;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.view_binding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        binding.actionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = binding.editName.getText().toString();
                String lastName = binding.editLastname.getText().toString();
                String email = binding.editEmail.getText().toString();
                String password = binding.editPassword.getText().toString();

                if (name.isEmpty() || lastName.isEmpty() || email.isEmpty() || password.isEmpty()) {
                     Toast.makeText(getBaseContext(), "faltan campos por completar!", Toast.LENGTH_SHORT).show();
                    return;
                }

                String sentence = name + " " + lastName + " " + email + " " + password;

                Toast.makeText(MainActivity.this, sentence, Toast.LENGTH_SHORT).show();

            }
        });
    }
}