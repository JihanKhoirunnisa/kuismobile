package com.example.kuismobile;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.kuismobile.R;

public class MainUpdel extends AppCompatActivity {
    private MyDatabase db;
    private String Sid, Snama, Sjurusan, Sangkatan;
    private EditText Enama, Ejurusan, Eangkatan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_updel);
        db = new MyDatabase(this);
        Intent i = this.getIntent();
        Sid = i.getStringExtra("Iid");
        Snama = i.getStringExtra("Inama");
        Sjurusan = i.getStringExtra("Ijurusan");
        Sangkatan = i.getStringExtra("Iangkatan");
        Enama = (EditText) findViewById(R.id.updel_nama);
        Ejurusan = (EditText) findViewById(R.id.updel_jurusan);
        Eangkatan = (EditText) findViewById(R.id.updel_angkatan);
        Enama.setText(Snama);
        Ejurusan.setText(Sjurusan);
        Eangkatan.setText(Sangkatan);
        Button btnUpdate = (Button) findViewById(R.id.btn_up);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snama = String.valueOf(Enama.getText());
                Sjurusan = String.valueOf(Ejurusan.getText());
                Sangkatan = String.valueOf(Eangkatan.getText());
                if (Snama.equals("")){
                    Enama.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi nama",
                            Toast.LENGTH_SHORT).show();
                } else if (Sjurusan.equals("")){
                    Ejurusan.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi kelas",
                            Toast.LENGTH_SHORT).show();
                } else if (Sangkatan.equals("")){
                    Eangkatan.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi kelas",
                            Toast.LENGTH_SHORT).show();
                } else {
                    db.UpdateMahasiswa(new Mahasiswa(Sid, Snama, Sjurusan, Sangkatan));
                    Toast.makeText(MainUpdel.this, "Data telah diupdate",
                            Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
        Button btnDelete = (Button) findViewById(R.id.btn_del);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.DeleteMahasiswa(new Mahasiswa(Sid, Snama, Sjurusan, Sangkatan));
                Toast.makeText(MainUpdel.this, "Data telah dihapus",
                        Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}