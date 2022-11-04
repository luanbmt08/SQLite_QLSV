package com.google.a2050531200228_dangvanluan_qlsv;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import com.google.a2050531200228_dangvanluan_qlsv.dao.SinhVienDAO;
import com.google.a2050531200228_dangvanluan_qlsv.model.SinhVien;

public class EditActivity extends AppCompatActivity {
    private EditText edtHoTen_228,edtEmail_228,edtDienThoai_228;
    private RadioGroup rgGioiTinh_228;
    private RadioButton rbNam_228, rbNu_228;
    private Button btnLuu_228,btnThoat_228;
    private SinhVienDAO svDAO_228;
    int gioitinh_228;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        svDAO_228=new SinhVienDAO(EditActivity.this);
        //Lấy dữ liệu
        Intent intent=getIntent();
        SinhVien sinhvien =(SinhVien) intent .getSerializableExtra("DULIEU");
        //anhxa
        AnhXa();
        //lấy dữ liệ lên view
        edtHoTen_228.setText(sinhvien.getHoTen());
        edtEmail_228.setText(sinhvien.getEmail());
        edtDienThoai_228.setText(sinhvien.getDienThoai());
        if(sinhvien.getGioiTinh()==1)
        {
            rbNam_228.setChecked(true);
            gioitinh_228=1;
        }
        else{
            rbNu_228.setChecked(true);
            gioitinh_228=0;
        }


        btnThoat_228.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        //su kien cho gioi tinh
        rgGioiTinh_228.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i==R.id.rb_nam){
                    gioitinh_228=1;

                }
                else {
                    gioitinh_228=0;
                }
            }
        });
        //lưu
        btnLuu_228.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sinhvien.setHoTen(edtHoTen_228.getText().toString());
                sinhvien.setEmail(edtEmail_228.getText().toString());
                sinhvien.setDienThoai(edtDienThoai_228.getText().toString());
                sinhvien.setGioiTinh(gioitinh_228);
                svDAO_228.CapNhatSinhVien_228(sinhvien);

            }
        });
}
private void AnhXa() {
        edtHoTen_228= (EditText) findViewById(R.id.edt_hoten);
    edtEmail_228= (EditText) findViewById(R.id.edt_email);
    edtDienThoai_228= (EditText) findViewById(R.id.edt_dienthoai);
    rgGioiTinh_228=(RadioGroup) findViewById(R.id.rg_gioitinh);
    rbNam_228=(RadioButton) findViewById(R.id.rb_nam);
    rbNu_228=(RadioButton) findViewById(R.id.rb_nu);
    btnLuu_228=(Button)  findViewById(R.id.btn_luu);
    btnThoat_228=(Button)  findViewById(R.id.btn_thoat);
}
}
