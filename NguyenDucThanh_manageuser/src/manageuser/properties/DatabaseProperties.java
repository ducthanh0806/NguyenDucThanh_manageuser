/**
 * Copyright(C) 2021 Luvina Software Company
 *
 * DatabaseProperties.java, 08/05/2021 NguyenDucThanh
 */
package manageuser.properties;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import manageuser.utils.Constant;

/**
 * Class đọc dữ liệu trong file database.properties
 * 
 * @author NguyenDucThanh
 *
 */
public class DatabaseProperties {
	private static Map<String, String> mapDatabaseProperties = new HashMap<String, String>();
	static {
		try {
			// Khởi tạo properties
			Properties properties = new Properties(); 
			// Đọc file properties
			properties.load(new InputStreamReader(DatabaseProperties.class.getClassLoader()
					.getResourceAsStream(Constant.DATABASE_PROPERTIES), "UTF-8"));
			// Khởi tạo Enumeration lưu trữ danh sách key trong file properties					
			Enumeration<?> enumeration = properties.propertyNames(); 
			// Đọc danh sach key
			while (enumeration.hasMoreElements()) { 
				// key = key tiếp theo
				String key = (String) enumeration.nextElement(); 
				// lấy value tương ứng với key
				String value = properties.getProperty(key); 
				// Add các giá trị key và value vào hashmap
				mapDatabaseProperties.put(key, value); 
			}
		} catch (IOException e) {
			System.out.println("DatabaseProperties-mapDBProperties-" + e.getMessage());
			//throw e;
		}
	}

	/**
	 * lấy value tương ứng với key trong file properties
	 * 
	 * @return key trong file properties
	 * 
	 */
	public static String getKey(String key) {
		return mapDatabaseProperties.get(key);
	}
}
