import java.io.*;
class CFile {
	public String readFile(String fn) {
		String data = "";
		FileInputSteam fin;
		try {
			fin = new FileInputStream(fn);
			byte []b = new byte [fin.available()];
			fin.read(b);
			data = new String(b);
			fin.close();
		}
		catch(Exception e) {
		}
		return data;
	}
	public void writeFile(String fn, String data) {
		FileOutputStream fout;
		try {
			fout = new FileOutputStream(fn);
			fout.write(data.getBytes());
			fout.close();
		}
		catch(Exception e) {
		}
	}
	public void copyFie(String sfn, String dfn) {
		writeFile(dfn, readFile(sfn));
	}
}
class cp {
	public static void main(String args[]) {
		if(args.length == 2) {
			CFile obj = new CFile();
			obj.copyFile(args[0],args[1]);
		}
		else {
			System.out.println("Usage : java cp sfn dfn");
		}
	}
}