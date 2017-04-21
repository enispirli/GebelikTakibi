package com.gebeliktakibi;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class NoteActivity extends AppCompatActivity {

    List<NoteObjeckt> noteObjecktArrayList;
    NoteAdapter adapterNot;


    EditText etNote;
    EditText etIcerik;
    Button btnAddNote;
    ListView lvNote;
    ArrayAdapter<String> adapter;
    ArrayList<String> arrayList;
    FirebaseAuth mAuth;
    FirebaseDatabase db;
    DatabaseReference notRef;
    FirebaseDatabase mFireNot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        mAuth = FirebaseAuth.getInstance();
        db = FirebaseDatabase.getInstance();

        noteObjecktArrayList = new ArrayList<NoteObjeckt>();
        adapterNot = new NoteAdapter(this,R.layout.list_item,noteObjecktArrayList);

        //    dbRef = db.getReference("gebelikBilgileri").child("1");


        etNote = (EditText) findViewById(R.id.etNewNote);
        etIcerik = (EditText) findViewById(R.id.etIcerik);
        btnAddNote = (Button) findViewById(R.id.btnAddNote);
        lvNote = (ListView) findViewById(R.id.lvNote);
        lvNote.setAdapter(adapterNot);
        lvNote.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), ""+noteObjecktArrayList.get(position).getBaslik(), Toast.LENGTH_SHORT).show();
            }
        });

        btnAddNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                degerEkle();

            }
        });
        attachDatabaseReadListener();


    }

    public void degerEkle() {

        FirebaseUser firebaseDatabase = FirebaseAuth.getInstance().getCurrentUser();
        String userid = firebaseDatabase.getUid();
        mFireNot = FirebaseDatabase.getInstance();
        notRef = mFireNot.getReference("notlar/"+userid);
        notRef.push().setValue(new NoteObjeckt(etNote.getText().toString(),
                etIcerik.getText().toString()));


    }

    Context context;
    NoteObjeckt noteList = null;
    private void attachDatabaseReadListener() {
        DatabaseReference dbRefCek = db.getReference("notlar/"+mAuth.getCurrentUser().getUid());
        dbRefCek.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot data: dataSnapshot.getChildren())
                    noteObjecktArrayList.add(data.getValue(NoteObjeckt.class));
                adapterNot.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
/*
        ChildEventListener mChildEventListener = null;
        if (mChildEventListener == null) {
            mChildEventListener = new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {


                    noteObjecktArrayList.add(new NoteObjeckt(dataSnapshot.child("konu").getValue().toString(),dataSnapshot.child("icerik").getValue().toString()));
                    adapterNot.notifyDataSetChanged();


                 //ArrayAdapter<String> notAdapter = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1,noteObjecktArrayList);
                 //lvNote.setAdapter(notAdapter);
                }

                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                }

                @Override
                public void onChildRemoved(DataSnapshot dataSnapshot) {
                }

                @Override
                public void onChildMoved(DataSnapshot dataSnapshot, String s) {
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                }
            };
            notRef.addChildEventListener(mChildEventListener);
*/
        //}
    }
}

