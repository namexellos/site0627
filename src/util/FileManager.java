package util;
//���ϰ� ���õ� ���� ���⿡ ����� ���� Ŭ����!!!
public class FileManager {

	//Ȯ���� ���ϱ�
	public static String getExt(String path) {
		int index=path.lastIndexOf(".");
		System.out.println(index);
		return path.substring(index+1, path.length());
		
	}
	/*
	public static void main(String[] args) {
		System.out.println(getExt("dfgjdflkjg...dkgjalsd.dfg.png"));
	}	
	*/
}
