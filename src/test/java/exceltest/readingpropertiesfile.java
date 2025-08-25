package exceltest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class readingpropertiesfile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\testdata\\datafile.properties");
		Properties propobj=new Properties();
		propobj.load(file);
		String url=propobj.getProperty("appurl");
		String mail=propobj.getProperty("email");
		String pass=propobj.getProperty("password");
		String ordid=propobj.getProperty("orderid");
		String custid=propobj.getProperty("customerid");
		System.out.println(url+" "+mail+" "+pass+" "+ordid+" "+custid);
		System.out.println();
		
		

		
	}

}
