package com.google.a2050531200228_dangvanluan_qlsv.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.google.a2050531200228_dangvanluan_qlsv.database.DbHelper;
import com.google.a2050531200228_dangvanluan_qlsv.model.SinhVien;

import java.util.ArrayList;
import java.util.List;

public class SinhVienDAO {
    private DbHelper csdl;
    public SinhVienDAO(Context context)
    {
        csdl = new DbHelper(context);
    }

    //Lấy tất cả sinh viên
    public List<SinhVien> TatCaSinhVien() {
        String sql = "SELECT * FROM SinhVien";
        List<SinhVien> sinhVienList = new ArrayList<SinhVien>();
        SQLiteDatabase database = csdl.getReadableDatabase();
        Cursor cursor = database.rawQuery(sql, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast())
        {
            int masv = cursor.getInt(0);
            String hoten =cursor.getString(1);
            int gioitinh =cursor.getInt(2);
            String dienthoai=cursor.getString(3);
            String email =cursor.getString(4);
            SinhVien sv=new SinhVien (masv,hoten,gioitinh,dienthoai,email);
            sinhVienList.add(sv);
            cursor.moveToNext();
        }
            return sinhVienList;
    }
    //Thêm Sinh Viên
    public void ThemSinhVien_228(SinhVien sv){
        SQLiteDatabase database =csdl.getWritableDatabase();
        ContentValues values =new ContentValues();
        values.put("HoTen",sv.getHoTen());
        values.put("GioiTinh",sv.getGioiTinh());
        values.put("DienThoai",sv.getDienThoai());
        values.put("Email",sv.getEmail());
        database.insert("SinhVien","",values);
    }
    //cập nhât sinh viên
    public void CapNhatSinhVien_228(SinhVien sv) {
        SQLiteDatabase database =csdl.getWritableDatabase();
        ContentValues values =new ContentValues();
        values.put("HoTen",sv.getHoTen());
        values.put("Email",sv.getEmail());
        values.put("DienThoai",sv.getDienThoai());
        values.put("GioiTinh",sv.getGioiTinh());
        String masv =String.valueOf(sv.getMaSV());
        String thamso[]= {masv};
        database.update("SinhVien",values,"MaSV=?",thamso);



    }

}
