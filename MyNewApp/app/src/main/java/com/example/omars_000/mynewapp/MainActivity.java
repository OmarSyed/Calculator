package com.example.omars_000.mynewapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addText(View view){
        Button v = (Button) view;
        String text = v.getText().toString();
        TextView tF = findViewById(R.id.textView);
        tF.setText("");
        tF.append(text);
    }

    public void Evaluate(View view) {
        TextView tF = findViewById(R.id.textView);
        String text = tF.getText().toString();
        javax.script.ScriptEngineManager mgr = new javax.script.ScriptEngineManager();
        javax.script.ScriptEngine engine = mgr.getEngineByName("JavaScript");
        try{
            String newtext = (String) engine.eval(text);
            tF.setText(newtext);
        }
        catch(Exception e){
            tF.setText("Invalid input");
        }
    }

    public void deleteText(View view){
        TextView tF = findViewById(R.id.textView);
        String text = tF.getText().toString();
        StringBuilder new_text = new StringBuilder(text);
        new_text.delete(text.length()-1, text.length());
        tF.setText(new_text);

    }
}
