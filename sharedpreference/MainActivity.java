package com.example.sharedpreferences;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    EditText usernameEt,mobileEt,emailEt,pass1Et,pass2Et;
    Button submitBtn;
    SharedPreferences sharedpreferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        usernameEt=(EditText) findViewById(R.id.username);
        mobileEt=(EditText) findViewById(R.id.mobile);
        emailEt=(EditText) findViewById(R.id.email);
        pass1Et=(EditText) findViewById(R.id.password);
        pass2Et=(EditText) findViewById(R.id.repass);
        submitBtn=(Button) findViewById(R.id.submit);
        sharedpreferences=getSharedPreferences("UserDetails",MODE_PRIVATE);
        editor=sharedpreferences.edit();
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username=usernameEt.getText().toString().trim();
                int mobile=Integer.parseInt(mobileEt.getText().toString().trim());
                String email=emailEt.getText().toString().trim();
                String pass1=pass1Et.getText().toString().trim();
                String pass2=pass2Et.getText().toString().trim();
                if(username.isEmpty()){
                    usernameEt.setError("Username is empty");
                    usernameEt.requestFocus();
                    return;
                }
                if(email.isEmpty()){
                    emailEt.setError("Input email");
                    emailEt.requestFocus();
                    return;
                }
                if(pass2.isEmpty()){
                    pass1Et.setError("Enter Password");
                    pass1Et.requestFocus();
                    return;
                }
                if(pass1.length()<6){
                    pass1Et.setError("Length must be minimum 6 characters");
                    pass1Et.requestFocus();
                    return;
                }
                if(!pass2.equals(pass1)){
                    pass2Et.setError("Password not matched");
                    pass2Et.requestFocus();
                    return;}
                Toast.makeText(MainActivity.this,"Registration successfull",Toast.LENGTH_LONG).show();
                editor.putString("keyusername",username);
                editor.putInt("keymobile",mobile);
                editor.putString("keymail",email);
                editor.putString("keypassword",pass2);
                editor.apply();
            }
        });
    }
}
