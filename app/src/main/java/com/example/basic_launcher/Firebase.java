package com.example.basic_launcher;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Firebase extends AppCompatActivity {

    FirebaseFirestore dbroot;
    EditText etName, etEmail;
    Button Btnadd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase);

        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etMail);
        Btnadd = findViewById(R.id.btnadd);

        dbroot = FirebaseFirestore.getInstance();

        Btnadd.setOnClickListener(v -> {

            Map<String, String> items = new HashMap<>();
            items.put("name", etName.getText().toString().trim());
            items.put("email", etEmail.getText().toString().trim());

            dbroot.collection("students")
                    .add(items)
                    .addOnCompleteListener(task -> {
                        etName.setText("");
                        etEmail.setText("");
                        Toast.makeText(Firebase.this, "Inserted Data Successfully", Toast.LENGTH_SHORT).show();
                    });


//                Toast.makeText(Firebase.this, "click", Toast.LENGTH_SHORT).show();
//                insertData();
        });
    }
}