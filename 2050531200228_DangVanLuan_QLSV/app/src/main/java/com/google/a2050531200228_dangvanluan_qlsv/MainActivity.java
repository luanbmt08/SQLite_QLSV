package com.google.a2050531200228_dangvanluan_qlsv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.a2050531200228_dangvanluan_qlsv.adapter.SinhVienAdapter;
import com.google.a2050531200228_dangvanluan_qlsv.dao.SinhVienDAO;
import com.google.a2050531200228_dangvanluan_qlsv.model.SinhVien;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView lvSinhVien_228;
    private List<SinhVien> sinhVienList_228;
    private SinhVienAdapter adapter_228;
    private SinhVienDAO svDao_228;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Ánh xạ
        lvSinhVien_228=(ListView) findViewById(R.id.lv_sinhvien);
        //Có dữ liệu

        sinhVienList_228=new ArrayList<SinhVien>();
        svDao_228=new SinhVienDAO(MainActivity.this);
        sinhVienList_228=svDao_228.TatCaSinhVien();
        //SinhVien sv1=new SinhVien("tao",1,"077","hihi");
        //sinhVienList.add(sv1);
        //SinhVien sv2=new SinhVien("to",1,"077","hihi");
        //sinhVienList.add(sv2);
        //
        adapter_228=new SinhVienAdapter(getApplicationContext(),sinhVienList_228);
        lvSinhVien_228.setAdapter(adapter_228);
        //Sự kiện listview
        
        SuKien_ListView();
    }

    private void SuKien_ListView() {
        lvSinhVien_228.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                SinhVien sv=sinhVienList_228.get(i);
                Intent intent=new Intent(MainActivity.this,EditActivity.class);
                intent.putExtra("DULIEU",sv);
                startActivity(intent);



            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_option, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NotNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.menu_them) {
            Intent intent = new Intent(MainActivity.this, AddActivity.class);
            startActivity(intent);
        }
        if(id== R.id.menu_thoat)
        {
            finish();
        }
        return true;
    }
    @Override
    protected void onResume() {
        super.onResume();
        sinhVienList_228.clear();
        sinhVienList_228.addAll(svDao_228.TatCaSinhVien());
        adapter_228.notifyDataSetChanged();
    }
}