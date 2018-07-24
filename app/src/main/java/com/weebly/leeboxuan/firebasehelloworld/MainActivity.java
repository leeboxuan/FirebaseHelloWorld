package com.weebly.leeboxuan.firebasehelloworld;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static java.lang.Integer.parseInt;


public class MainActivity extends AppCompatActivity {
    private TextView tv;
    private EditText etTitle, etDate, etNum;
    private CheckBox ckb;
    private Button btnAdd;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference messagePOJOReference;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAdd = (Button)findViewById(R.id.btnAdd);
        tv = (TextView)findViewById(R.id.tvContent);
        etTitle = (EditText)findViewById(R.id.etTitle);
        etDate = (EditText)findViewById(R.id.etDate);
        etNum = (EditText)findViewById(R.id.etNum);
        ckb = (CheckBox)findViewById(R.id.checkBox);
        firebaseDatabase = FirebaseDatabase.getInstance();
        messagePOJOReference = firebaseDatabase.getReference("event");
        messagePOJOReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Message data = dataSnapshot.getValue(Message.class);
                if (data != null) {
                    tv.setText("Title: " + data.getTitle() + "\nDate: "+data.getDate()+"\nNumOfDays: "+data.getNum()+"\nCompleted? " + data.isCompleted());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e(TAG, "Database error occurred", databaseError.toException());
            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean yes = true;
                if (ckb.isChecked() == false){
                    yes = false;
                }
                Integer i = parseInt(etNum.getText().toString());

                Message data = new Message(etDate.getText().toString(), etTitle.getText().toString(),yes,i);
                messagePOJOReference.setValue(data);
            }
        });
    }
}
