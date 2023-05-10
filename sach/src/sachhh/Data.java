package sachhh;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JOptionPane;

public class Data {
 public Data() {
	 super();
 }
 public void saveFile(String fileName, Object o){
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try{
			fos = new FileOutputStream(fileName);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(o);
			oos.close();
		}catch(Exception ex){
			JOptionPane.showMessageDialog(null, "IOss  calo lozError!");
			return;
		}
	}
	// Doc file
	public Object readFile(String fileName) {
		Object o = null;
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try{
			fis = new FileInputStream(fileName); 
			ois = new ObjectInputStream(fis);
			o = ois.readObject();
			ois.close();
		}catch(Exception ex){
			JOptionPane.showMessageDialog(null, "IOsaaooo Error!");
		}
		return o;
	}
}
