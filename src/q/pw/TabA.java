package q.pw;

import q.util.Q;
import android.os.Bundle;
import android.content.Intent;
import android.widget.RadioButton;

/**
 * qqqqqqQ1
 * lhqqqqQ1
 * 
 * qqqxxxX0
 * lhqxxxX0
 * 
 * qqqxxxX0{a}{0}
 * lhqxxxX0{a}{0}
 * 
 * 密码在ubuntu中修改
 * 登录邮箱尽量改成q@xxd.cn
 */
public class TabA extends Q.view.tab.base {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

	@Override
	protected Intent[] onInitIntent() {
		return new Intent[]{
				new Intent(this, Level1A.class), 
				new Intent(this, Level2A.class),
				new Intent(this, Level3A.class)};
	}

	@Override
	protected void onInitRadioButton(RadioButton rbtn, int position) {
		switch(position){
		case 0:
			rbtn.setText("A");
			break;
		case 1:
			rbtn.setText("B");
			break;
		case 2:
			rbtn.setText("C");
			break;
		}
		rbtn.setButtonDrawable(R.drawable.tab_btn);
		rbtn.setPadding(0, 10, 0, 10);
	}

	@Override
	protected int getTabDirection(int top, int bottom) {
		return top;
	}
}
