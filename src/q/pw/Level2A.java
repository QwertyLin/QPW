package q.pw;

import java.util.ArrayList;

import q.pw.adapter.PwAdapter;
import q.pw.bean.Pw;
import android.app.ListActivity;
import android.os.Bundle;

public class Level2A extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//
		ArrayList<Pw> d = new ArrayList<Pw>();
		//
		d.add(new Pw("qq", "12325140、123816"));
		d.add(new Pw("tenpay", "12325140、123816"));
		
		d.add(new Pw("taobao", "q123816"));
		//
		setListAdapter(new PwAdapter(this, d));
	}
}
