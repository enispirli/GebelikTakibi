package com.gebeliktakibi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class NoteActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etNote;
    Button btnAddNote;
    ListView lvNote;
    ArrayAdapter<String> adapter;
    ArrayList<String> arrayList;
    FirebaseAuth mAuth;
    private FirebaseDatabase db;
    private DatabaseReference dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        mAuth = FirebaseAuth.getInstance();
        db = FirebaseDatabase.getInstance();
        dbRef = db.getReference("gebelikBilgileri/").child("1");



        etNote=(EditText)findViewById(R.id.etNewNote);
        btnAddNote=(Button)findViewById(R.id.btnAddNote);
        lvNote=(ListView) findViewById(R.id.lvNote);
        btnAddNote.setOnClickListener(this);
        arrayList=new ArrayList<String>();
        adapter=new ArrayAdapter<String>(NoteActivity.this,android.R.layout.simple_list_item_1,arrayList);
        lvNote.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btnAddNote:
                dbRef.push().setValue(etNote.getText().toString());
                Toast.makeText(this,"Gönderildi.",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
