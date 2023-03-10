package com.example.mytest;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Work> listWorks = new ArrayList<>();
    private WorkAdapter adapter;
    private ListView listView;

    private Button btnDelete, btnUpdate, btnAdd, btnDate;
    private EditText textTen,textNoiDung;

    private TextView ngay;

    private RadioGroup gioiTinh;

    private int selectedItemPosition = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);
        listWorks.add(new Work("diep", "noidung", "Nam", "20/2/2023"));
        listWorks.add(new Work("diepp", "noidung", "Nu", "20/2/2023"));
        textTen = findViewById(R.id.inputTenCV);
        ngay = findViewById(R.id.textViewNgay);
        textNoiDung = findViewById(R.id.inputNoiDung);
        gioiTinh = findViewById(R.id.gioiTinh);
        btnAdd = findViewById(R.id.btnAdd);
        btnDate = findViewById(R.id.btnDate);
        btnDelete = findViewById(R.id.btnDelete);
        btnUpdate = findViewById(R.id.btnUpdate);


//        Date btn
        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        ngay.setText(dayOfMonth + "/" + month + "/" + year);
                    }
                }, year, month, day);
                dialog.show();
            }
        });

//      Add btn
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String tenCV = textTen.getText().toString();
               String noiDung = textNoiDung.getText().toString();
               String ngayChon = ngay.getText().toString();
               RadioButton buttonGioiTinh = findViewById(gioiTinh.getCheckedRadioButtonId());

               if(tenCV.isEmpty() || noiDung.isEmpty() || ngayChon.isEmpty()) {
                   Toast.makeText(MainActivity.this, "dien day du thong tin", Toast.LENGTH_SHORT).show();
               } else {
                   Toast.makeText(MainActivity.this, buttonGioiTinh.getText().toString(), Toast.LENGTH_SHORT).show();
                   listWorks.add(new Work(tenCV, noiDung, buttonGioiTinh.getText().toString(), ngayChon));
                   initView();
               }

            }
        });

//        Delete
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedItemPosition != -1) {
                    listWorks.remove(selectedItemPosition);
                    adapter.notifyDataSetChanged();

                    // Thiết lập lại vị trí mục được chọn về giá trị mặc định
                    selectedItemPosition = -1;
                }
            }
        });

        //On click item
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedItemPosition = position;
                textTen.setText(listWorks.get(position).getTen());
                textNoiDung.setText(listWorks.get(position).getNoidung());
                if (listWorks.get(position).getGioitinh().equalsIgnoreCase("Nam")) {
                    gioiTinh.check(R.id.gioiTinhNam);
                } else {
                    gioiTinh.check(R.id.gioiTinhNu);
                }
                ngay.setText(listWorks.get(position).getNgayhoanthanh());
            }
        });

        //        Update
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ten = textTen.getText().toString();
                String noidung = textNoiDung.getText().toString();
                String ngayChon = ngay.getText().toString();
                RadioButton buttonGioiTinh = findViewById(gioiTinh.getCheckedRadioButtonId());

                if(ten.isEmpty() || noidung.isEmpty() || ngayChon.isEmpty()) {
                    Toast.makeText(MainActivity.this, "dien day du thong tin", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, buttonGioiTinh.getText().toString(), Toast.LENGTH_SHORT).show();
                    listWorks.set( selectedItemPosition,new Work(ten, noidung, buttonGioiTinh.getText().toString(), ngayChon));
                    initView();
                }
            }
        });



        initView();
    }

    private void initView() {
        adapter = new WorkAdapter(this, listWorks);
        listView.setAdapter(adapter);

    }

}