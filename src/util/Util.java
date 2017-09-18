package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
/**
 * 데이터 형식을 처리하는 클래스
 */
public class Util {
	public static boolean login = false;
	public static String name = "";

	public static String dateForm(String date){
		return date.substring(0, 4) + "/" + date.substring(4, 6) + "/" + date.substring(6, 8);
	} // end of dateForm()
	
	public static String timeForm(String time){
		return time.substring(0, 2) + ":" + time.substring(2, 4) ;
	} // end of dateForm()
	
	public static void setLogout(){
		FileInputStream fis = null;
		FileOutputStream fos = null;

		try {
			fis = new FileInputStream("login.properties");

		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		Properties prop = new Properties();
		try {
			prop.load(fis);
		} catch (IOException e1) {
			e1.printStackTrace();
		}	
		prop.setProperty("id", "");		
		login = false;
		
		try {
			prop.store(new FileOutputStream("login.properties"), null);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	} // end of getLoginId()
	
	public static void setLoginId(String id){
		FileInputStream fis = null;
		FileOutputStream fos = null;

		try {
			fis = new FileInputStream("login.properties");

		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		Properties prop = new Properties();
		try {
			prop.load(fis);
		} catch (IOException e1) {
			e1.printStackTrace();
		}	
		prop.setProperty("id", id);
		
		try {
			prop.store(new FileOutputStream("login.properties"), null);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	} // end of getLoginId()
	
	public static String getLoginId(){
		FileInputStream fis = null;

		try {
			fis = new FileInputStream("login.properties");

		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		Properties prop = new Properties();
		try {
			prop.load(fis);
		} catch (IOException e1) {
			e1.printStackTrace();
		}	
		String id = (String) prop.get("id");
		return id;
	} // end of getLoginId()
	
	public static String getLoginPw(){
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("login.properties");

		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		Properties prop = new Properties();
		try {
			prop.load(fis);
		} catch (IOException e1) {
			e1.printStackTrace();
		}	
		String pw =(String) prop.get("pw");
		return pw;
	} // end of getLoginPw()
} // end of class
