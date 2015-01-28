package info.yokkora.sudoku;

/**
 * Created by admin on 2015/01/29.
 */
public class Test2Activity extends android.app.Activity implements android.hardware.SensorEventListener{

    private BallCarrySurFaceView mSurFaceView;

    private android.hardware.SensorManager mSensorManager;
    private android.hardware.Sensor mAccelerometer;

    public static float accel_x = 0.0f;
    public static float accel_y = 0.0f;

    @Override
    protected void onCreate(android.os.Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(android.view.Window.FEATURE_NO_TITLE);
        getWindow().addFlags(android.view.WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        mSurFaceView = new BallCarrySurFaceView(this);
        setContentView(mSurFaceView);

        mSensorManager = (android.hardware.SensorManager)getSystemService(android.content.Context.SENSOR_SERVICE);
        java.util.List<android.hardware.Sensor> list = mSensorManager.getSensorList(android.hardware.Sensor.TYPE_ACCELEROMETER);
        if (list.size() > 0) {
            mAccelerometer = list.get(0);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mAccelerometer, android.hardware.SensorManager.SENSOR_DELAY_GAME);
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
        if (event.sensor.getType() != android.hardware.Sensor.TYPE_ACCELEROMETER) {
            return;
        }

        accel_x = event.values[0];
        accel_y = event.values[1];
    }
}
