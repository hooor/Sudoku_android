package info.yokkora.sudoku;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class EasyActivity extends ActionBarActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy);

        // timeをすすめる

        // 問題作成

        // gridに入れる数字を選ぶ
        setNumbers();

        // idをクリックすると選んだ数字を入れる

        // 回答する

        // intentのまとめ
        setButtonIntentListener();
    }

    // gridに入れる数字を選ぶ
    private void setNumbers() {
        final TextView num1 = (TextView) this.findViewById(R.id.num1);
        num1.setText("hoge");
        num1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                num1.setText("hogehoge2");
            }
        });

        /*
        for (int i = 1; i < 7; ++i) {
            TextView textview = (TextView) this.findViewById(R.id.num . i);
            ImageButton imgbtn = (ImageButton)findViewById(imageButtons[i]);
            nums[i] = new AnswerNum(imgbtn, i);
        }
        */
    }

    // intentのまとめ
    private void setButtonIntentListener() {
        Button btnToIndex = (Button) this.findViewById(R.id.to_index);
        btnToIndex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EasyActivity.this, IndexActivity.class);
                startActivity(intent);
            }
        });
    }
}
