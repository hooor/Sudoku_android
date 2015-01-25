package info.yokkora.sudoku;

/**
 * Created by admin on 2015/01/25.
 */
public class TestActivity extends android.app.Activity implements android.hardware.SensorEventListener{

    private android.hardware.SensorManager mSensorManager;
    private android.hardware.Sensor mAccelerometer;

    @Override
    protected void onCreate(android.os.Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        android.widget.Button btnToIndex = (android.widget.Button)findViewById(R.id.to_index);
        btnToIndex.setOnClickListener(new android.view.View.OnClickListener(){
                                          @Override
                                          public void onClick(android.view.View v) {
                                              android.content.Intent intent = new android.content.Intent(TestActivity.this, IndexActivity.class);
                                              startActivity(intent);
                                          }
                                      });

        mSensorManager = (android.hardware.SensorManager)getSystemService(android.content.Context.SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(android.hardware.Sensor.TYPE_ACCELEROMETER);

    }

    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mAccelerometer, 500000);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
    }

    @Override
    public void onAccuracyChanged(android.hardware.Sensor sensor, int accuracy) {

    }

    @Override
    public void onSensorChanged(android.hardware.SensorEvent event) {
        android.widget.TextView txt01 = (android.widget.TextView)findViewById(R.id.txt01);
        StringBuilder strBuild = new StringBuilder();

        strBuild.append("X" + event.values[0] + "\n");
        strBuild.append("X" + event.values[1] + "\n");
        strBuild.append("X" + event.values[2] + "\n");
        android.util.Log.d("TAG", "hogehog");
        txt01.setText(strBuild.toString());
    }
}
