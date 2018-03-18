package com.example.marek.pelist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.w3c.dom.Text;

import java.util.Date;

public class ProfileEditingActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText fnameEditText;
    private EditText snameEditText;
    private EditText birthEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_editing);

        setupAddButton();
        initTextEdits();
    }

    protected void setupAddButton() {
        Button addButton = findViewById(R.id.addDataBtn);
        addButton.setOnClickListener(this);
    }

    protected void initTextEdits() {
        fnameEditText = findViewById(R.id.fnameEditText);
        snameEditText = findViewById(R.id.snameEditText);
        birthEditText = findViewById(R.id.birthEditText);
    }
    @Override
    public void onClick(View view) {
        if (validateData()) {
            Intent data = new Intent();
            data.putExtra("ProfileModel", toModel());
            setResult(RESULT_OK, data);
        }
        else {
            setResult(RESULT_CANCELED);
        }
        finish();
    }

    protected boolean validateData() {
        return true;
    }

    public ProfileModel toModel() {
        // #TODO Decode date
        return new ProfileModel(fnameEditText.getText().toString(), snameEditText.getText().toString(), new Date());
    }
}
