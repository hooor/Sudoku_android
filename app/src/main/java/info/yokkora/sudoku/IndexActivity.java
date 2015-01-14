package info.yokkora.sudoku;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class IndexActivity extends ActionBarActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
        Button btnToTop = (Button) this.findViewById(R.id.to_top);
        btnToTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IndexActivity.this, TopActivity.class);
                startActivity(intent);
            }
        });
        Button btnToEasy = (Button) this.findViewById(R.id.to_easy);
        btnToEasy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IndexActivity.this, EasyActivity.class);
                startActivity(intent);
            }
        });
    }
}
