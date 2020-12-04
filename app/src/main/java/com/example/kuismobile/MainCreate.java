package com.example.kuismobile;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.kuismobile.R;

public class MainCreate extends AppCompatActivity {
    private MyDatabase db;
    private EditText Enama, Ejurusan, Eangkatan;
    private String Snama, Sjurusan, Sangkatan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_create);
        db = new MyDatabase(this);
        Enama = (EditText) findViewById(R.id.create_nama);
        Ejurusan = (EditText) findViewById(R.id.create_jurusan);
        Eangkatan = (EditText) findViewById(R.id.create_angkatan);
        Button btnCreate = (Button) findViewById(R.id.create_btn);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snama = String.valueOf(Enama.getText());
                Sjurusan = String.valueOf(Ejurusan.getText());
                Sangkatan = String.valueOf(Eangkatan.getText());
                if (Snama.equals("")){
                    Enama.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi nama",
                            Toast.LENGTH_SHORT).show();
                } else if (Sjurusan.equals("")){
                    Ejurusan.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi jurusan",
                            Toast.LENGTH_SHORT).show();
                } else if (Sangkatan.equals("")){
                    Eangkatan.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi angkatan",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Enama.setText("");
                    Ejurusan.setText("");
                    Eangkatan.setText("");
                    Toast.makeText(MainCreate.this, "Data telah ditambah",
                            Toast.LENGTH_SHORT).show();
                    db.CreateMahasiswa(new Mahasiswa(null, Snama, Sjurusan, Sangkatan));
                    Intent a = new Intent(MainCreate.this, MainActivity.class);
                    startActivity(a);
                }
            }
        });
    }
}