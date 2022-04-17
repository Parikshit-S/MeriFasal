package com.example.android.merifasal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {
    TextView hindiAlready;
    TextView registerAsSeller;
    EditText inputUsername,inputEmail,inputPassword,inputNumber,inputRefferal;
    Button btnRegister;
    String emailPattern="[a-zA-z0-9._-]+@[a-z]+\\.+[a-z]+";
    ProgressDialog progressDialog;

    FirebaseAuth mAuth;
    FirebaseUser mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        registerAsSeller=findViewById(R.id.registerAsSeller);
        hindiAlready=findViewById(R.id.hindiAlready);
        inputUsername=findViewById(R.id.username);
        inputRefferal=findViewById(R.id.refferal);
        inputEmail=findViewById(R.id.email);
        inputPassword=findViewById(R.id.password);
        inputNumber=findViewById(R.id.number);
        btnRegister=findViewById(R.id.btn_register);
        progressDialog=new ProgressDialog(this);
        mAuth=FirebaseAuth.getInstance();
        mUser=mAuth.getCurrentUser();

        hindiAlready.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this, RegisterSellerActivity.class));
            }
        });

        registerAsSeller.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this, RegisterSellerActivity.class));
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PerforAuth();
            }
        });
    }
    private void PerforAuth() {
        String username=inputUsername.getText().toString();
        String email=inputEmail.getText().toString();
        String password=inputPassword.getText().toString();
        String number=inputNumber.getText().toString();

        if (!email.matches(emailPattern))
        {
            inputEmail.setError("Enter Correct Email");
        }else if (password.isEmpty() || password.length()<6)
        {
            inputPassword.setError("Enter Proper Password");
        }else if (number.isEmpty() || number.length()<=9){
            inputNumber.setError("Add Proper Mobile Number");
        }else if (username.isEmpty() || username.length()==14){
            inputUsername.setError("Enter Correct Username");
        }else
        {
            progressDialog.setMessage("Please Wait For While!");
            progressDialog.setTitle("Registering New User");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();

            mAuth.createUserWithEmailAndPassword(email,password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful())
                    {
                        User user = new User(username, number, email);

                        FirebaseDatabase.getInstance().getReference("Users")
                                .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                             if (task.isSuccessful()){
                                 progressDialog.dismiss();
                                 sendUserToNextActivity();
                                 Toast.makeText(RegisterActivity.this,"Registration Successful",Toast.LENGTH_SHORT).show();
                             } else {
                                 Toast.makeText(RegisterActivity.this, "Failed To Register", Toast.LENGTH_SHORT).show();
                                 progressDialog.dismiss();
                             }
                            }
                        });

                    }else
                    {
                        progressDialog.dismiss();
                        Toast.makeText(RegisterActivity.this,""+task.getException(),Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void sendUserToNextActivity() {
        Intent intent=new Intent(RegisterActivity.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}