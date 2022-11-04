package com.google.a2050531200228_dangvanluan_qlsv.database;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    public DbHelper(@Nullable Context context) {
        super(context, "QLSinhVien.sqlite", null, 1);
    }



    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sqlSVCreate ="CREATE TABLE IF NOT EXISTS " +
                "SinhVien(MaSV INTERER PRIMARY KEY AUTOINCREMENT, " +
                "HoTen VARCHAR(200), " +
                "GioiTinh INTEGER, " +
                "DienThoai VARCHAR(13)," +
                "Email VARCHAR(200))" ;
        sqLiteDatabase.execSQL(sqlSVCreate);
        String SqlInsert1="INSERT INTO SinhVien(HoTen,GioiTinh,DienThoai,Email) VALUES('Đặng Văn Luận','1','0773305502','vanluan0711@gmail.com')";
        String SqlInsert2="INSERT INTO SinhVien(HoTen,GioiTinh,DienThoai,Email) VALUES('Nguyễn Văn A','1','008217545','hihi0908@gmail.com')";
        String SqlInsert3="INSERT INTO SinhVien(HoTen,GioiTinh,DienThoai,Email) VALUES('Trần Thị B','0','07265675068','haha@gmail.com')";
        sqLiteDatabase.execSQL(SqlInsert1);
        sqLiteDatabase.execSQL(SqlInsert2);
        sqLiteDatabase.execSQL(SqlInsert3);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
