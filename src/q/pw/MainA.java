package q.pw;

import q.util.Q;
import q.util.QLog;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;

public class MainA extends Activity {
	
	//2134
	private boolean s1, s2, s3, s4;
	private int width, height;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		width = Q.os.window.manager(this).getWidth() / 2;
		height = Q.os.window.manager(this).getHeight() / 2;
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		float x, y;
		switch(event.getAction()){
		case MotionEvent.ACTION_MOVE:
			x = event.getX();
			y = event.getY();
			Q.log.kv(this, "onTouchEvent", "xy", x + " " + y);
			if(x > width && y < height){
				s2 = true;
				s1 = s3 = s4 = false;
				QLog.log(this, "s2");
			}
			if(s2 && x < width && y < height){
				s1 = true;
				s3 = s4 = false;
				QLog.log(this, "s1");
			}
			if(s2 && s1 && x < width && y > height){
				s3 = true;
				s4 = false;
				QLog.log(this, "s3");
			}
			if(s2 && s1 && s3 && x > width && y > height){
				s4 = true;
				QLog.log(this, "s4");
			}
			if(s1 && s2 && s3 && s4){
				synchronized (this) {
					if(s1 && s2 && s3 && s4){
						s1 = s2 = s3 = s4 = false;
						startActivity(new Intent(MainA.this, TabA.class));
						finish();
					}
					return true;
				}
			}
			break;
		}
		return super.onTouchEvent(event);
	}
}
