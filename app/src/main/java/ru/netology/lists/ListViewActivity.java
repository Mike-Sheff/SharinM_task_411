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
        return new SimpleAdapter(this, values, android.R.layout.simple_list_item_1, new String[]{"bottom","top"}, new int[] {R.id.textView1, R.id.textView2});
    }

    @NonNull
    private List<Map<String, String>> prepareContent() {
        content = new ArrayList<>();

        Map<String, String> map = new HashMap<>();

        String[] arrayContent = getString(R.string.large_text).split("\n\n");
        for(int i=0 ; i < arrayContent.length; i++) {
            map.put("bottom", arrayContent[i]);
            map.put("top", String.valueOf(arrayContent[i].length()));

            content.add(map);
        }

        return content;
    }
}
