package sachhh;

import java.io.Serializable;

public class Sach implements Serializable {
	private String maSach;
	private String tenSach;
	private int soTrang;
	private String theLoai;
	private String nxb;
	public Sach(String maSach, String tenSach, int soTrang, String theLoai, String nxb) {
		super();
		this.maSach = maSach;
		this.tenSach = tenSach;
		this.soTrang = soTrang;
		this.theLoai = theLoai;
		this.nxb = nxb;
	}
	public String getMaSach() {
		return maSach;
	}
	public void setMaSach(String maSach) {
		this.maSach = maSach;
	}
	public String getTenSach() {
		return tenSach;
	}
	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}
	public int getSoTrang() {
		return soTrang;
	}
	public void setSoTrang(int soTrang) {
		this.soTrang = soTrang;
	}
	public String getTheLoai() {
		return theLoai;
	}
	public void setTheLoai(String theLoai) {
		this.theLoai = theLoai;
	}
	public String getNxb() {
		return nxb;
	}
	public void setNxb(String nxb) {
		this.nxb = nxb;
	}
	@Override
	public String toString() {
		return "Sach [maSach=" + maSach + ", tenSach=" + tenSach + ", soTrang=" + soTrang + ", theLoai=" + theLoai
				+ ", nxb=" + nxb + "]";
	}
	
	
}
