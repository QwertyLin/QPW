package q.pw;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;

public class LevelA extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		LinearLayout layout = new LinearLayout(this);
		layout.setOrientation(LinearLayout.VERTICAL);
		setContentView(layout);
		
		Button b;
		b = new Button(this);
		b.setText("Level 1");
		layout.addView(b);
		b.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				startActivity(new Intent(LevelA.this, Level1A.class));
			}
		});
		//
		b = new Button(this);
		b.setText("Level 2");
		layout.addView(b);
		b.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				startActivity(new Intent(LevelA.this, Level2A.class));
			}
		});
		//
		b = new Button(this);
		b.setText("Level 3");
		layout.addView(b);
		b.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				startActivity(new Intent(LevelA.this, Level3A.class));
			}
		});
	}
}
