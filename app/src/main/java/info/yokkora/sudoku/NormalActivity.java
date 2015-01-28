package info.yokkora.sudoku;

public class NormalActivity extends android.app.Activity{

    // 数字のimageButton
    public final int imageButtons[] = {
            R.id.a_button, R.id.b_button, R.id.c_button, R.id.d_button
    };

    @Override
    protected void onCreate(android.os.Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new SampleView(this));

        /*
        setContentView(R.layout.activity_normal);

        android.widget.ImageButton btn1 = (android.widget.ImageButton)findViewById(R.id.num_button1);
        btn1.setImageResource(imageButtons[1]);

        // intent
        setIntent();
        */
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

    private class SampleView extends android.view.View {
        private android.graphics.Paint mPaint;
        private float imageX;
        private float imageY;
        private android.graphics.Bitmap mBitmap;

        public SampleView(android.content.Context context) {
            super(context);
            mPaint = new android.graphics.Paint();
        }

        @Override
        protected void onDraw(android.graphics.Canvas canvas) {
            mBitmap = android.graphics.BitmapFactory.decodeResource(getResources(), R.drawable.num1);
            canvas.drawBitmap(mBitmap, imageX - mBitmap.getWidth() / 2,
                    imageY - mBitmap.getHeight() / 2, mPaint);
        }

        @Override
        public boolean onTouchEvent(android.view.MotionEvent event) {
            if (event.getAction() == android.view.MotionEvent.ACTION_DOWN) {
                imageX = event.getX();
                imageY = event.getY();
            }
            else if (event.getAction() == android.view.MotionEvent.ACTION_MOVE) {
                imageX = event.getX();
                imageY = event.getY();
            }
            else if (event.getAction() == android.view.MotionEvent.ACTION_UP) {
                imageX = event.getX();
                imageY = event.getY();
            }

            invalidate();
            return true;
        }
    }
}
