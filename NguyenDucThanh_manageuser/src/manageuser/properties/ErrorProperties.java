/**
 * Copyright(C) 2021 Luvina Software Company
 *
 * ErrorProperties.java, 08/05/2021 NguyenDucThanh
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
 * Class Đọc các thông tin từ file error.propoties
 * 
 * @author NguyenDucThanh
 *
 */
public class ErrorProperties {
	private static Map<String, String> mapErrorProperties = new HashMap<String, String>();
	static {
		try {
			// Khởi tạo properties
			Properties properties = new Properties(); 
			// Đọc file properties
			properties.load(new InputStreamReader(ErrorProperties.class.getClassLoader()
					.getResourceAsStream(Constant.ERROR_PROPERTIES), "UTF-8"));
			// Khởi tạo Enumeration lưu trữ danh sách key trong file properties					
			Enumeration<?> enumeration = properties.propertyNames(); 
			// Đọc danh sach key
			while (enumeration.hasMoreElements()) { 
				// key = key tiếp theo
				String key = (String) enumeration.nextElement(); 
				// lấy value tương ứng với key
				String value = properties.getProperty(key); 
				// Add các giá trị key và value vào hashmap
				mapErrorProperties.put(key, value); 
			}
		} catch (IOException e) {
			System.out.println("ErrorProperties-mapErProperties-" + e.getMessage());
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
		return mapErrorProperties.get(key);
	}
}
