package com.example.author;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.author.classes.DataStore;

public class MainActivity extends AppCompatActivity {

    private EditText textAuthor;
    private EditText textTitle;
    private Spinner spinnerGenre;
    private Button buttonSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textAuthor = (EditText)findViewById(R.id.editTextAuthor);
        textTitle = (EditText)findViewById(R.id.editTextTitle);
        spinnerGenre = (Spinner) findViewById(R.id.spinnerGenre);
        buttonSearch = (Button)findViewById(R.id.buttonSearch);

        ArrayAdapter<CharSequence> genreAdapter = ArrayAdapter.createFromResource(
                this,
                R.array.book_genres,
                android.R.layout.simple_spinner_item
        );
        genreAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerGenre.setAdapter(genreAdapter);

        buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //
                // Code will run on Button Click
                //
                String filterAuthor = textAuthor.getText().toString();
                String filterTitle = textTitle.getText().toString();
                int filterGenreId = spinnerGenre.getSelectedItemPosition();
                Intent intent = new Intent(MainActivity.this, ListActivity.class);
                intent.putExtra("AUTHOR", filterAuthor);
                intent.putExtra("TITLE", filterTitle);
                intent.putExtra("GENREID", filterGenreId);
                startActivity(intent);
            }
        });

        DataStore.Init(getApplicationContext());

    }
}
