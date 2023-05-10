package sachhh;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Gui  extends JFrame implements ActionListener{
	private JTable table;
	private DefaultTableModel model;
	private JTextField txtMa,txtten,txtNXB ,txttim,txtSotrang;
	private JLabel lbma,lbten,lbSotrang,lbTheLoai,lbTitle,lbTim,lbNXB;
	private JComboBox<String> combo;
	private JButton btnTim,btnXoa,btnThem,btnluu,btnXoatrang,btnsua;
	private DsSach ds;
	private Data database;
	public Gui() {
		
		ds = new DsSach();
		database = new Data();
		gui();
		try {
			loadDate();
		} catch (Exception ex) {
			// TODO: handle exception
			ex.printStackTrace();
		}
	}
	public void gui() {
		//nourd
		JPanel pnNorth = new JPanel();
		pnNorth.add(lbTitle = new JLabel("Thong Tin Sach"));
		lbTitle.setForeground(Color.BLUE);
		lbTitle.setFont(new Font("arial",Font.BOLD,25));
		add(pnNorth,BorderLayout.NORTH);
		//
		Box b = Box.createHorizontalBox();
		Box bE = Box.createVerticalBox();
		JPanel pnleft = new JPanel();
		Box b1,b2,b3,b4,b5;
		bE.add(b1 = Box.createHorizontalBox());
		b1.add(lbma = new JLabel("ma sach"));
		b1.add(txtMa = new JTextField(30));
		bE.add(Box.createVerticalStrut(10));
		bE.add(b2 = Box.createHorizontalBox());
		b2.add(lbten = new JLabel("Ten sach:"));
		b2.add(txtten = new JTextField(30));
		bE.add(Box.createVerticalStrut(10));
		bE.add(b3 = Box.createHorizontalBox());
		b3.add(lbNXB= new JLabel("Nha Xuat Ban"));
		b3.add(txtNXB = new JTextField(30));
		bE.add(Box.createVerticalStrut(10));
		bE.add(b4 = Box.createHorizontalBox());
		b4.add(lbSotrang = new JLabel("so trang"));
		b4.add(txtSotrang = new JTextField(20));
		bE.add(Box.createVerticalStrut(10));
		
		bE.add(b5 = Box.createHorizontalBox());
		
		b5.add(lbTheLoai = new JLabel("the loai:"));
		combo = new JComboBox();
		combo.addItem("toan");
		combo.addItem("tin hoc");
		
		b5.add(combo);
		lbma.setPreferredSize(lbNXB.getPreferredSize());
		lbSotrang.setPreferredSize(lbNXB.getPreferredSize());
		lbTheLoai.setPreferredSize(lbNXB.getPreferredSize());
		lbten.setPreferredSize(lbNXB.getPreferredSize());

//		b1.setPreferredSize(new Dimension(300,20));
//		b2.setPreferredSize(new Dimension(240,20));
//		b3.setPreferredSize(new Dimension(240,20));
//		b4.setPreferredSize(new Dimension(240,20));

		pnleft.add(bE);
		b.add(pnleft);

//		
//		b.add(b2 = Box.createHorizontalBox());
//		b2.add(lbma = new JLabel("ma sach"));
//		b2.add(txtMa = new JTextField());
		model = new DefaultTableModel();
		table = new JTable(model);
		model.addColumn("ma sach");
		model.addColumn("ten sach");
		model.addColumn("so trang");
		model.addColumn("the loai");
		model.addColumn("nha xuat ban");
		JScrollPane scroo = new JScrollPane(table);
		b.add(scroo);
		add(b,BorderLayout.CENTER);

		JSplitPane slip = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		JPanel left , right;
		left = new JPanel();
		left.add(lbTim = new JLabel("Tim"));
		left.add(txttim =new JTextField(10));
		left.add(btnTim = new JButton("tim"));
		right = new JPanel();
		right.add(btnThem = new JButton("them"));
		right.add(btnXoa = new JButton("xoa"));
		right.add(btnluu= new JButton("luu"));
		right.add(btnsua = new JButton("sua"));
		right.add(btnXoatrang = new JButton("xoa trang"));
		slip.add(left);
		slip.add(right);
		add(slip,BorderLayout.SOUTH);
		
		btnluu.addActionListener(this);
		btnTim.addActionListener(this);
		btnXoa.addActionListener(this);
		btnXoatrang.addActionListener(this);
		btnThem.addActionListener(this);
		btnsua.addActionListener(this);
	}
	
	public void loadDate() throws Exception {
		ds = (DsSach)database.readFile("mon.dat");
		if(ds == null) {
			ds = new DsSach();
		}else {
			for (Sach s : ds.getDs()) {
				String[] row = {s.getMaSach(),s.getTenSach(),s.getSoTrang()+"",s.getTheLoai(),s.getNxb()};
				model.addRow(row);
			}
		}
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(btnThem)) {
			them();
			JOptionPane.showMessageDialog(null, "them thanh cong");
		}else if(o.equals(btnXoa)) {
			try {
				xoadong();
			} catch (Exception ex) {
				// TODO: handle exception
				ex.printStackTrace();
			}
		}else if(o.equals(btnXoatrang)) {
			xoatrangw();
		}else if(o.equals(btnluu)) {
			try {
			database.saveFile("mon.dat", ds);
				JOptionPane.showMessageDialog(null, "luu thanh cong");
			} catch (Exception ex) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, "loi cc");
				ex.printStackTrace();
			}
		}else if(o.equals(btnTim)) {
			int pos = ds.timsach(txttim.getText());
			if(pos!=-1) {
				JOptionPane.showInternalMessageDialog(null, "tim thay");
				table.setRowSelectionInterval(pos, pos);
			}
			else {
				JOptionPane.showInternalMessageDialog(null, "khong tim thay");
			}
			
		}
		
	}
	public void them() {
		String ma = txtMa.getText();
		String ten = txtten.getText();
		String soTrang = txtSotrang.getText();
		String theLoai = (String) combo.getSelectedItem();
		String NXB = txtNXB.getText();
		Sach s = new Sach(ma, ten, Integer.parseInt(soTrang), theLoai, NXB);
		if(ds.them(s)) {
			String []row = {ma,ten,soTrang,theLoai,NXB};
			model.addRow(row);
		}else {
			JOptionPane.showMessageDialog(null,"trung khong them");
		}
	}
	
	
	public void xoadong() throws Exception {
		int r = table.getSelectedRow();
		if(r!=-1) {
			int tb= JOptionPane.showConfirmDialog(null, "ban co chac chan xoa dong nay khong ?","delete",JOptionPane.YES_NO_OPTION);
			if(tb==JOptionPane.YES_OPTION) {
				ds.xoa(r);
				model.removeRow(r);
				database.saveFile("mon.dat",ds);
			}else
				JOptionPane.showMessageDialog(null, "chua chon dong xoa");
		}
	}

	
	public void xoatrangw() {
		txtMa.setText("");
		txtNXB.setText("");
		txtSotrang.setText("");
		txtten.setText("");
		txttim.setText("");
		txtMa.requestFocus();
		
	}
}
