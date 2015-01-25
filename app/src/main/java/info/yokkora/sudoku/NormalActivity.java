package info.yokkora.sudoku;

public class NormalActivity extends android.app.Activity{

    // 数字のimageButton
    public final int imageButtons[] = {
            R.id.a_button, R.id.b_button, R.id.c_button, R.id.d_button
    };

    @Override
    protected void onCreate(android.os.Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal);

        android.widget.ImageButton btn1 = (android.widget.ImageButton)findViewById(R.id.num_button1);
        btn1.setImageResource(imageButtons[1]);

        // intent
        setIntent();
    }

    public void setIntent() {
        android.widget.Button btnToIndex = (android.widget.Button)findViewById(R.id.to_index);
        btnToIndex.setOnClickListener(new android.view.View.OnClickListener(){
            @Override
            public void onClick(android.view.View v) {
                android.content.Intent intent = new android.content.Intent(NormalActivity.this, IndexActivity.class);
                startActivity(intent);
            }
        });
    }
}
