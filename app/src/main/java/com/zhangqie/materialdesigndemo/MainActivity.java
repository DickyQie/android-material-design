package com.zhangqie.materialdesigndemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.zhangqie.materialdesigndemo.ui.CoordinatorLayoutActivity;
import com.zhangqie.materialdesigndemo.ui.CoordinatorTabLayoutActivity;
import com.zhangqie.materialdesigndemo.ui.FloatingActionButtonActivity;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private String[] strings=new String[]{"FloatingActionButton","CollapsingToolbarLayout下拉",
            "CoordinatorLayout+TabLayout"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }


    private void initView(){
        listView= (ListView) findViewById(R.id.listview);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,strings);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(onItemClickListener);
    }

    Intent intent;
    AdapterView.OnItemClickListener onItemClickListener=new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            if (position==0){
                intent=new Intent(MainActivity.this, FloatingActionButtonActivity.class);
            }else if (position ==1){
                intent=new Intent(MainActivity.this,CoordinatorLayoutActivity.class);
            }else if (position == 2){
                intent=new Intent(MainActivity.this,CoordinatorTabLayoutActivity.class);
            }
            startActivity(intent);
        }
    };
}
