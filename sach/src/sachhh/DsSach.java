package sachhh;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class DsSach implements Serializable  {
	private ArrayList<Sach> ds;
	public DsSach() {
		ds = new ArrayList<>();
	}
	public boolean them(Sach s) {
		if(ds.contains(s))
			return false;
		return ds.add(s);
	}
	public boolean xoa(int index) {
		if(index >=0 && index <= ds.size()-1 ) {
			ds.remove(index);
			return true;
		}else {
			return true;
		}

	}
	public ArrayList<Sach> getDs() {
		return ds;
	}
	public int timsach(String maSach) {
		for (int i = 0; i < ds.size(); i++) {
			if(ds.get(i).getMaSach().equalsIgnoreCase(maSach))
				return i;
		}
		return -1;

	}
}
