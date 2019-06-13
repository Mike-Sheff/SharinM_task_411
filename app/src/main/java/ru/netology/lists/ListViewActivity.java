package ru.netology.lists;

import android.os.Bundle;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListViewActivity extends AppCompatActivity {

    private ListView list;
    private List<Map<String, String>> content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        list = findViewById(R.id.list);

        List<Map<String, String>> values = prepareContent();

        BaseAdapter listContentAdapter = createAdapter(values);

        list.setAdapter(listContentAdapter);
    }

    @NonNull
    private BaseAdapter createAdapter(List<Map<String, String>> values) {
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, values, R.layout.activity_separate, new String[]{"bottom", "top"}, new int[]{R.id.textView1, R.id.textView2});
        return simpleAdapter;
    }

    @NonNull
    private List<Map<String, String>> prepareContent() {
        content = new ArrayList<>();

        String[] arrayContent = getString(R.string.large_text).split("\n\n");
        for(int i=0 ; i < arrayContent.length; i++) {

            Map<String, String> map = new HashMap<>();

            map.put("bottom", arrayContent[i]);
            map.put("top", String.valueOf(arrayContent[i].length()));

            content.add(map);
        }

        return content;
    }
}
