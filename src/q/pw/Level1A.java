package q.pw;

import java.util.ArrayList;

import q.pw.adapter.PwAdapter;
import q.pw.bean.Pw;
import android.app.ListActivity;
import android.os.Bundle;

public class Level1A extends ListActivity { 

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//
		ArrayList<Pw> d = new ArrayList<Pw>();
		//
		d.add(new Pw("weibo", "123816@qq.com"));
		
		d.add(new Pw("github", "q@xxd.cn"));
		d.add(new Pw("evernote", "linhqe"));
        d.add(new Pw("poco", "q@xxd.cn"));
        //
		setListAdapter(new PwAdapter(this, d));
	}
}
