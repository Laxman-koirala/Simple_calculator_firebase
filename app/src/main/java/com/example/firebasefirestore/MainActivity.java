package com.example.firebasefirestore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    public static final String KEY_RESULT = "result";
    public static final String KEY_TIMESTAMP = "timestamp";
    public EditText edit_first_number, edit_second_number;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit_first_number = findViewById(R.id.edittext_first);
        edit_second_number = findViewById(R.id.edittext_second);

    }

    public void addition_onclick(View v) {
        double num_first = Double.parseDouble(edit_first_number.getText().toString());
        double num_second = Double.parseDouble(edit_second_number.getText().toString());
        double result = num_first + num_second;
        FieldValue timestamp=FieldValue.serverTimestamp();
        String answer = String.valueOf(result);
        Map<String, Object> Calculation_detail = new HashMap<>();
        Calculation_detail.put(KEY_RESULT, answer);
        Calculation_detail.put(KEY_TIMESTAMP, timestamp);

        db.collection("Calculator_addition").document("calculations").set(Calculation_detail)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(MainActivity.this, "Your addition saved", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MainActivity.this, "Error!", Toast.LENGTH_SHORT).show();

                    }
                });
    }

    public void subtraction_onclick(View v) {
        double num_first = Double.parseDouble(edit_first_number.getText().toString());
        double num_second = Double.parseDouble(edit_second_number.getText().toString());
        double result = num_first-num_second;
        FieldValue timestamp=FieldValue.serverTimestamp();
        String answer = String.valueOf(result);
        Map<String, Object> Calculation_detail = new HashMap<>();
        Calculation_detail.put(KEY_RESULT, answer);
        Calculation_detail.put(KEY_TIMESTAMP, timestamp);

        db.collection("Calculator_Subtraction").document("calculations").set(Calculation_detail)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(MainActivity.this, "Your Subtraction saved", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MainActivity.this, "Error!", Toast.LENGTH_SHORT).show();

                    }
                });

    }

    public void multiplication_onclick(View v) {
        double num_first = Double.parseDouble(edit_first_number.getText().toString());
        double num_second = Double.parseDouble(edit_second_number.getText().toString());
        double result = num_first*num_second;
        FieldValue timestamp=FieldValue.serverTimestamp();
        String answer = String.valueOf(result);
        Map<String, Object> Calculation_detail = new HashMap<>();
        Calculation_detail.put(KEY_RESULT, answer);
        Calculation_detail.put(KEY_TIMESTAMP, timestamp);

        db.collection("Calculator_multiplication").document("calculations").set(Calculation_detail).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(MainActivity.this, "Your multiplication  saved", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(MainActivity.this, "Error!", Toast.LENGTH_SHORT).show();

            }
        });


    }

    public void division_onclick(View v) {
        double num_first = Double.parseDouble(edit_first_number.getText().toString());
        double num_second = Double.parseDouble(edit_second_number.getText().toString());
        double result = num_first/num_second;
        FieldValue timestamp=FieldValue.serverTimestamp();
        String answer = String.valueOf(result);
        Map<String, Object> Calculation_detail = new HashMap<>();
        Calculation_detail.put(KEY_RESULT, answer);
        Calculation_detail.put(KEY_TIMESTAMP, timestamp);

        db.collection("Calculator_division").document("calculations").set(Calculation_detail).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(MainActivity.this, "Your division saved", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(MainActivity.this, "Error!", Toast.LENGTH_SHORT).show();

            }
        });


    }

    public void power_onclick(View v) {
        double num_first = Double.parseDouble(edit_first_number.getText().toString());
        double num_second = Double.parseDouble(edit_second_number.getText().toString());
        double result = Math.pow(num_first,num_second);
        FieldValue timestamp=FieldValue.serverTimestamp();
        String answer = String.valueOf(result);
        Map<String, Object> Calculation_detail = new HashMap<>();
        Calculation_detail.put(KEY_RESULT, answer);
        Calculation_detail.put(KEY_TIMESTAMP, timestamp);

        db.collection("Calculator_division").document("calculations").set(Calculation_detail).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(MainActivity.this, "Your power saved", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(MainActivity.this, "Error!", Toast.LENGTH_SHORT).show();

            }
        });


    }
    public void clear_onclick(View v) {
        edit_first_number.setText("");
        edit_second_number.setText("");

    }
}