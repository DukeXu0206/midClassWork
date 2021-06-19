package com.example.midclasswork;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TableActivity extends Activity {
    private ListView listView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_software);
        listView = findViewById(R.id.listview);
        List<Map<String,Object>> list = getData();
        ListViewAdapter listViewAdapter = new ListViewAdapter(TableActivity.this, list,0);
        listView.setAdapter(listViewAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                list.remove(position);
                listViewAdapter.notifyDataSetChanged();
                listView.invalidate();
            }
        });
    }
    public List<Map<String, Object>> getData(){
        int[] imageId = new int[]{R.drawable.cat1,R.drawable.cat2,R.drawable.cat3,R.drawable.dog1,
                R.drawable.dog2,R.drawable.dog3,R.drawable.bird1,R.drawable.bird2,R.drawable.bird3
        };
        String[] name = new String[]{"宠物猫: cindy","宠物猫: kid","宠物猫: 小不点","宠物狗: jack","宠物狗: lion","宠物狗: 冰淇淋","宠物鸟: 贝贝","宠物鸟: 天天","宠物鸟: 学人精"};
        String[] info = new String[]{"状态: 已被徐天领养","状态: 未领养","状态: 未领养","状态: 未领养","状态: 未领养","状态: 未领养","状态: 未领养","状态: 未领养","状态: 未领养"};
        List<Map<String, Object>> list=new ArrayList<Map<String,Object>>();
        for (int i = 0; i < 8; i++) {
            Map<String, Object> map=new HashMap<String, Object>();
            map.put("image", imageId[i]);
            map.put("name",name[i]);
            map.put("info",info[i]);
            list.add(map);
        }
        return list;
    }

}
