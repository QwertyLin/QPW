package q.pw.adapter;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import q.pw.R;
import q.pw.bean.Pw;
import q.pw.util.AdapterBase;
import q.pw.util.CodeUtil;

public class PwAdapter extends AdapterBase<Pw, PwAdapter.Holder> {

	public PwAdapter(Context ctx, List<Pw> data) {
		super(ctx, data);
	}

	@Override
	protected Holder getHolder(View v) {
		Holder h = new Holder();
		h.tvName = (TextView)v.findViewById(R.id.name);
		h.tvId = (TextView)v.findViewById(R.id.id);
		h.tvCode = (TextView)v.findViewById(R.id.code);
		return h;
	}

	@Override
	protected void initItem(int position, Pw data, Holder holder) {
		holder.tvName.setText(data.getName());
		holder.tvId.setText(data.getId());
		holder.tvCode.setText(initCode(data.getName()));
	}

	@Override
	protected int getLayoutId() {
		return R.layout.item;
	}
	
	class Holder {
		TextView tvName;
		TextView tvId;
		TextView tvCode;
	}
	
	private String initCode(String name){
		String code = null;
		StringBuffer sb = new StringBuffer();
		try {
			code = CodeUtil.desEncode("QQQQQQQQ", name + name + name + name);
			for(char c : code.toCharArray()){
				if(sb.length() == 4){
					break;
				}
				if(Character.isLetter(c)){
					sb.append(Character.toUpperCase(c));
				}
			}
			for(char c : code.toCharArray()){
				if(Character.isDigit(c)){
					sb.append(c);
					break;
				}
			}
			return sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
