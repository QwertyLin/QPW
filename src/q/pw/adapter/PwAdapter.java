package q.pw.adapter;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import q.code.QCodeUtil;
import q.pw.R;
import q.pw.bean.Pw;
import qv.adapter.QAdapterBase;

public class PwAdapter extends QAdapterBase<Pw> {

	public PwAdapter(Context ctx, List<Pw> data) {
		super(ctx, data);
	}

	@Override
	protected Object getViewHolder(View v) {
		Holder h = new Holder();
		h.tvName = (TextView)v.findViewById(R.id.name);
		h.tvId = (TextView)v.findViewById(R.id.id);
		h.tvCode = (TextView)v.findViewById(R.id.code);
		return h;
	}

	@Override
	protected void onInitItem(int position, Pw data, Object viewHolder) {
		Holder h = (Holder)viewHolder;
		h.tvName.setText(data.getName());
		h.tvId.setText(data.getId());
		h.tvCode.setText(initCode(data.getName()));
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
			code = QCodeUtil.desEncode("QQQQQQQQ", name + name + name + name);
			
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
