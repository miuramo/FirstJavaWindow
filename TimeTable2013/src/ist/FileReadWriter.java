package ist;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;

public class FileReadWriter {

	public static ArrayList<String> getLinesListFromResource(String path){
		ClassLoader cl = FileReadWriter.class.getClassLoader();

		if (cl == null) {
			System.err.println("Resource not found: " + path);
			return null;
		} else {
			InputStream ris = cl.getResourceAsStream(path);
			return getLinesListFromInputStream(ris, path);
		}
	}
	public static ArrayList<String> getLinesListFromInputStream(InputStream is, String name){
		ArrayList<String> list = new ArrayList<String>();
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String line = null;
			/* �t�@�C���ǂݍ��� */
			while ((line = br.readLine()) != null) {
				list.add(line);
			}
			/* �t�@�C������܂� */
			br.close();
		} catch (IOException err) {
			System.out.println("ReadError: "+name);
		}
		return list;
	}

	public static ArrayList<String> getLinesList(String fn, boolean createIfNotExist){
		File f = new File(fn);
		if (createIfNotExist){
			if (!f.exists()){
				try {
					if (f.createNewFile()){
						System.out.println("New file "+fn+" Created.");
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return getLinesList(fn);
	}

	public static ArrayList<String> getLinesList(String fn){
		try {
			return getLinesListFromInputStream(new FileInputStream(fn), fn);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	/* �t�@�C����ǂݍ��� */
	public static String[] getLines(String fn) {

		ArrayList<String> list = getLinesList(fn);
		return (String[]) list.toArray(new String[list.size()]);
	}

	public static String[] getLinesFromResource(String path){
		ArrayList<String> list = getLinesListFromResource(path);
		return (String[]) list.toArray(new String[list.size()]);
	}

	/** �z����t�@�C���ɏ������� 
	 * 
	 * @param fn �t�@�C����
	 * @param data ������̔z��i�e�s���v�f�j
	 */
	public static void putLines(String fn, String data[]) {
		try {
			FileWriter filewriter = new FileWriter(fn, false);
			for (int i = 0; i < data.length; i++) {
				/* ���s�����ǉ����� */
				/* ��������������݂܂� */
				filewriter.write(data[i]+System.getProperty("line.separator"));
			}
			/* �t�@�C������܂� */
			filewriter.close();
		} catch (IOException e) {
			System.out.println("WriteError:" + fn);
		}
	}
	
	/* �t�@�C���ɏ������� */
	public static void putLines(String fn, ArrayList<String> data) {
//		System.out.println(fn);
		try {
			FileWriter filewriter = new FileWriter(fn, false);
			for (String d : data) {
				/* ���s�����ǉ� */
				d = d + "\r\n";
				/* ��������������݂܂� */
				filewriter.write(d);
			}
			/* �t�@�C������܂� */
			filewriter.close();
		} catch (IOException e) {
			System.out.println("WriteError:" + fn);
		}
	}
	
	/* �t�@�C���ɏ������� */
	public static void putStringToFile(String fn, String out) {
//		System.out.println(fn);
		try {
			FileWriter filewriter = new FileWriter(fn, false);
			filewriter.write(out);
			/* �t�@�C������܂� */
			filewriter.close();
		} catch (IOException e) {
			System.out.println("WriteError:" + fn);
		}
	}

	/* ������𕪊����Ĕz��ŕԂ��܂� */
	public static String[] split(String delim, String text) {
		int index = -1;
		ArrayList<String> list = new ArrayList<String>();
		while ((index = text.indexOf(delim)) != -1) {
			list.add(text.substring(0, index));
			text = text.substring(index + delim.length());
		}
		list.add(text);
		String[] ret = (String[]) list.toArray(new String[list.size()]);
		return ret;
	}
	
	public static void writeBytesToFile(String filepath, byte[] ba){
		OutputStream fos = null;
		DataOutputStream dos = null;
		try{
			fos = new FileOutputStream(filepath);
			dos = new DataOutputStream(fos);
			dos.write(ba);
			dos.close();
			fos.close();
		}catch(IOException iex){
			iex.printStackTrace(System.out);
		}
	}
	
	public static byte[] readBytesFromFile(String path){
		File f = new File(path);
		if (!f.exists()) System.out.println("No file "+path);
		
		BufferedInputStream in;
		ByteArrayOutputStream varyBuf = new ByteArrayOutputStream();
		final int LS = 1024;
		int b;
		try {
			in = new BufferedInputStream(new FileInputStream(path));
			byte buf[] = new byte[LS];
			while((b = in.read(buf, 0, buf.length)) != -1 ) {
				varyBuf.write(buf,0,b) ;
			}
			varyBuf.close();
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return varyBuf.toByteArray();
	}
	public static ArrayList<String> buffer;
	public static void bufclear() {
		if (buffer == null) buffer = new ArrayList<String>();
		else buffer.clear();
	}
	public static void bufSave(String fn){
		FileReadWriter.putLines(fn, buffer);
	}
}
