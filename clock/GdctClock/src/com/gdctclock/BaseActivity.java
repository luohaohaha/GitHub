package com.gdctclock;

import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;

public class BaseActivity extends Activity {
	
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
	        getMenuInflater().inflate(R.menu.activity_menu, menu);
	        return true;
	 }

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	
		switch (item.getItemId()) {
		case R.id.menu_clock:{
			Intent intent = new Intent();
			intent.setClass(BaseActivity.this,ClockListActivity.class);
			startActivity(intent);
		}
			break;
		case R.id.menu_rock:{
			Intent intent = new Intent();
			intent.setClass(BaseActivity.this,TurnActivity.class);
			startActivity(intent);
		}
					break;
		case R.id.menu_settings:{
			Intent intent = new Intent();
			intent.setClass(BaseActivity.this,DialogSettingActivity.class);
			startActivity(intent);
		}
			break;
		case R.id.menu_about:{
			Intent intent = new Intent();
			intent.setClass(BaseActivity.this,DialogAbouActivity.class);
			startActivity(intent);
		}
			break;

		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}
	
}
