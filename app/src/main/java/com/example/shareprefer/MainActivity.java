package com.example.shareprefer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText editText1,editText2;
Button button;
    SharedPreferences sharedPreferences;
    private static final String SHARED_PREF_NAME="mypref";
    private static final String KEY_NAME="name";
    private static final String KEY_EMAIL="email";
    private String textName;
    private String textEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText1=findViewById(R.id.name);
        editText2=findViewById(R.id.email);
        button=findViewById(R.id.save);
        sharedPreferences=getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            SharedPreferences.Editor editor=sharedPreferences.edit();
            editor.putString(KEY_NAME,editText1.getText().toString());
            editor.putString(KEY_EMAIL,editText2.getText().toString());
            editor.apply();
//                Intent intent=new Intent(MainActivity.this,HomeActivity.class);
//                startActivity(intent);
                Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();
            }
        });
        textName=sharedPreferences.getString(KEY_NAME,"ali");
        textEmail=sharedPreferences.getString(KEY_EMAIL,"ali");
        editText1.setText(textName);
        editText2.setText(textEmail);

    }

}