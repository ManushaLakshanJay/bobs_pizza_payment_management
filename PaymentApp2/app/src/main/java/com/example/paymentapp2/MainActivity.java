package com.example.paymentapp2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editText_name,edittext_carno,edittext_cvv,edittext_exp;
    Button button_add,button_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText_name = findViewById(R.id.edittext_name);
        edittext_carno = findViewById(R.id.edittext_carno);
        edittext_cvv = findViewById(R.id.edittext_cvv);
        edittext_exp = findViewById(R.id.edittext_exp);

        button_add = findViewById(R.id.button_add);
        button_view = findViewById(R.id.button_view);


        button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringName = editText_name.getText().toString();
                String strincardno = edittext_carno.getText().toString();
                String stringcvv = edittext_cvv.getText().toString();
                String stringexpdate = edittext_exp.getText().toString();

                if (stringName.length() <=0 || strincardno.length() <=0){
                    Toast.makeText(MainActivity.this, "Enter All Data", Toast.LENGTH_SHORT).show();
                }else {
                    DatabaseHelperClass databaseHelperClass = new DatabaseHelperClass(MainActivity.this);
                    PayMethodModelClass payMethodModelClass = new PayMethodModelClass(stringName,strincardno,stringcvv,stringexpdate);
                    databaseHelperClass.addEmployee(payMethodModelClass);
                    Toast.makeText(MainActivity.this, "Add Payment method Successfully", Toast.LENGTH_SHORT).show();
                    finish();
                    startActivity(getIntent());
                }
            }
        });


        button_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ViewEmployeeActivity.class);
                startActivity(intent);
            }
        });


    }
}
