package com.example.dante.todo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TodoActivity extends AppCompatActivity {

    private Button button;
    private EditText editText;
    private ListView listView;
    private List<String> todos;
    private ArrayAdapter<String> adapter;

    // Powinno byc pobierane z resource.
    private String[] values = new String[] { "Android application" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo);
        getElementsFromLayout();

        todos = new ArrayList<>();
        Collections.addAll(todos, values);

        adapter = new ArrayAdapter<>(this, R.layout.todo_item, R.id.rowTextView, todos);
        listView.setAdapter(adapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editText.getText().toString();
                editText.setText("");

                todos.add(text);
                adapter.notifyDataSetChanged();
            }
        });
    }

    public void todoRemove(View v) {
        final int position = listView.getPositionForView((View) v.getParent());
        todos.remove(position);
        adapter.notifyDataSetChanged();
    }

    private void getElementsFromLayout() {
        button = (Button) findViewById(R.id.button2);
        editText = (EditText) findViewById(R.id.editText);
        listView = (ListView) findViewById(R.id.todos_list);
    }
}
