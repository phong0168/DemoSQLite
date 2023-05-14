package com.demosqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    BaiHocHelper baiHocHelper;
    ListView lst;
    ArrayList<BaiHoc> arrayList;
    BaiHocAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lst = (ListView) findViewById(R.id.lstView);
        arrayList = new ArrayList<>();
        adapter = new BaiHocAdapter(this, R.layout.layout_item, arrayList);
        lst.setAdapter(adapter);

        //Tao database
        baiHocHelper = new BaiHocHelper(this, "BaiHoc.sqlite", null, 1);
        //Tao bang
        baiHocHelper.QueryData("CREATE TABLE IF NOT EXISTS NoiDung(Id INTEGER PRIMARY KEY AUTOINCREMENT, TenNoiDung VARCHAR(200))");
        //Them du lieu
        baiHocHelper.QueryData("INSERT INTO NoiDung VALUES (null, 'Bai 1: Gioi thieu ve Android')");
        baiHocHelper.QueryData("INSERT INTO NoiDung VALUES (null, 'Bai 2: Cai dat moi trong lap trinh')");
        Cursor data = baiHocHelper.getData("SELECT * FROM NoiDung");
        while(data.moveToNext())
        {
            arrayList.add(new BaiHoc(data.getInt(0),data.getString(1)));

        }
        adapter.notifyDataSetChanged();



    }


}