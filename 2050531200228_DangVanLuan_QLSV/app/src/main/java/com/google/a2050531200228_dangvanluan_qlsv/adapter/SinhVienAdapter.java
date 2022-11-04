package com.google.a2050531200228_dangvanluan_qlsv.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.a2050531200228_dangvanluan_qlsv.R;
import com.google.a2050531200228_dangvanluan_qlsv.model.SinhVien;

import java.util.List;

public class SinhVienAdapter extends BaseAdapter {


    private List<SinhVien> sinhVienList_228;
    private Context context;
    public SinhVienAdapter(Context context,List<SinhVien> listList)
    {
        this.context=context;
        this.sinhVienList_228=listList;
    }
    @Override
    public int getCount() {
        return sinhVienList_228.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if(view==null){
            viewHolder=new ViewHolder();


            LayoutInflater inflater =(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view= inflater.inflate(R.layout.list_item_sinhvien,null);
            //Ánh xạ
            viewHolder.tvMaSV_228=view.findViewById(R.id.tv_masv);
            viewHolder.tvHoTen_228=view.findViewById(R.id.tv_hoten);
            viewHolder.tvDienThoai_228=view.findViewById(R.id.tv_dienthoai);
            viewHolder.tvEmail_228=view.findViewById(R.id.tv_email);
            viewHolder.ivGioiTinh_228=view.findViewById(R.id.iv_gioitinh);
            view.setTag(viewHolder);

        }
        else {
            viewHolder=(ViewHolder) view.getTag();
        }
    //
        SinhVien sv=sinhVienList_228.get(i);
        viewHolder.tvMaSV_228.setText("Mã SV: "+ sv.getMaSV());
        viewHolder.tvHoTen_228.setText("Họ tên: "+ sv.getHoTen());
        viewHolder.tvDienThoai_228.setText("Điện thoại: "+ sv.getDienThoai());
        viewHolder.tvEmail_228.setText("Email: "+ sv.getEmail());
        if(sv.getGioiTinh()==0)
        {
            viewHolder.ivGioiTinh_228.setImageResource(R.drawable.icon_female);
        }
        else{
            viewHolder.ivGioiTinh_228.setImageResource(R.drawable.icon_male);
        }

            return view;
    }
    class ViewHolder{
        ImageView ivGioiTinh_228;
        TextView tvMaSV_228,tvHoTen_228,tvDienThoai_228,tvEmail_228;

    }
}
