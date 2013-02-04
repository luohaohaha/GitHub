package com.gdctclock.service;

import java.util.List;

import android.app.Service;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.IBinder;
import android.util.Log;

public class TurnService extends Service {


	private SensorEventListener mListener;

	private SensorManager mSensorManager;

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		mSensorManager = (SensorManager) this.getSystemService(SENSOR_SERVICE);

		mListener = new SensorEventListener() {

			public void onAccuracyChanged(Sensor arg0, int arg1) {

			}

			public void onSensorChanged(SensorEvent event) {

				if (event.values[2] > 8) {// Õý
					Log.d("TAGYY", " change to Ringing mode ");

				} else if (event.values[2] < -8) {// ·´
					Log.d("TAGYY", "change to SilentMode");

				}

			}
		};
		List<Sensor> mSensorList = mSensorManager.getSensorList(Sensor.TYPE_ALL);
		int size = mSensorList.size();
		for (int i = 0; i < size; i++) {
			if (mSensorList != null && (mSensorList.size() > 0)) {
				Sensor sensor = mSensorList.get(0);
				mSensorManager.registerListener(mListener, sensor,
						SensorManager.SENSOR_DELAY_NORMAL);
			} 
		}

	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		mSensorManager.unregisterListener(mListener);
	}

}
