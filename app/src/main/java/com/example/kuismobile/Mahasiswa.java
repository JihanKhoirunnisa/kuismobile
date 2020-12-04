package com.example.kuismobile;

public class Mahasiswa {
    private String _id, _nama, _jurusan, _angkatan;
    public Mahasiswa (String id, String nama, String jurusan, String angkatan) {
        this._id = id;
        this._nama = nama;
        this._jurusan = jurusan;
        this._angkatan = angkatan;
    }
    public Mahasiswa() {
    }
    public String get_id() {
        return _id;
    }
    public void set_id(String _id) {
        this._id = _id;
    }
    public String get_nama() {
        return _nama;
    }
    public void set_nama(String _nama) {
        this._nama = _nama;
    }
    public String get_jurusan() {
        return _jurusan;
    }
    public void set_jurusan(String _jurusan) {
        this._jurusan = _jurusan;
    }
    public String get_angkatan() {
        return _angkatan;
    }
    public void set_angkatan(String _angkatan) {
        this._angkatan = _angkatan;
    }
}