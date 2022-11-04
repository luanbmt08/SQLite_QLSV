package com.google.a2050531200228_dangvanluan_qlsv;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import com.google.a2050531200228_dangvanluan_qlsv.dao.SinhVienDAO;
import com.google.a2050531200228_dangvanluan_qlsv.model.SinhVien;

public class AddActivity extends AppCompatActivity {
    private EditText edtHoTen_228,edtEmail_228,edtDienThoai_228;
    private RadioGroup rgGioiTinh_228;
    private Button btnThem_228,btnThoat_228;
     int gioitinh_228=1;
    private SinhVienDAO svDao_228;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        //AnhXa
        AnhXa();
        svDao_228=new SinhVienDAO(AddActivity.this);
        rgGioiTinh_228.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i==R.id.rb_nam){
                    gioitinh_228=1;
                }
                else{
                    gioitinh_228=0;
                }
            }
        });
        btnThem_228.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String hoten =edtHoTen_228.getText().toString();
                String email =edtEmail_228.getText().toString();
                String dienthoai =edtDienThoai_228.getText().toString();
                SinhVien sv = new SinhVien(hoten,gioitinh_228,dienthoai,email);
                svDao_228.ThemSinhVien_228(sv);
            }
        });

        btnThoat_228.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    public void AnhXa() {
        edtHoTen_228 =(EditText) findViewById(R.id.edt_hoten);
        edtEmail_228 =(EditText) findViewById(R.id.edt_email);
        edtDienThoai_228 =(EditText) findViewById(R.id.edt_dienthoai);
        rgGioiTinh_228=(RadioGroup) findViewById(R.id.rg_gioitinh);
        btnThem_228=(Button) findViewById(R.id.btn_them);
        btnThoat_228=(Button) findViewById(R.id.btn_thoat);

    }
}
