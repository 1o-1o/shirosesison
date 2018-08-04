package microservice.sc.util;

import org.apache.commons.beanutils.PropertyUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

/**
 * 
 * @ClassName: BeanUtils
 * @Description:TODO(工具类，判断bean，数组，集合是否为空)
 * @author: zml
 * @date: 2014-4-18 上午10:20:26
 *
 */
public class BeanUtils extends PropertyUtils{

	public static boolean isBlank(Object obj){
		if(obj == null){
			return true;
		}
		return false;
	}
	public static boolean isBlank(List list){
		if(list == null || list.size()<=0){
			return true;
		}
		return false;
	}
	public static boolean isBlank(Map map){
		if(map == null || map.size()<=0){
			return true;
		}
		return false;
	}
	public static boolean isBlank(Object []obj){
		if(obj == null || obj.length<=0){
			return true;
		}
		return false;
	}

	/**
	 * 判断对象所有属性是否为null
	 * @param bean
	 * @return
	 * @throws IllegalAccessException
     */

		public static boolean checkFieldValueNull(Object bean) {
			boolean result = true;
			if (bean == null) {
				return true;
			}
			Class<?> cls = bean.getClass();
			Method[] methods = cls.getDeclaredMethods();
			Field[] fields = cls.getDeclaredFields();
			for (Field field : fields) {
				try {
					String fieldGetName = parGetName(field.getName());
					if (!checkGetMet(methods, fieldGetName)) {
						continue;
					}
					Method fieldGetMet = cls.getMethod(fieldGetName, new Class[]{});
					Object fieldVal = fieldGetMet.invoke(bean, new Object[]{});
					if (fieldVal != null) {
						if ("".equals(fieldVal)) {
							result = true;
						} else {
							result = false;
						}
					}
				} catch (Exception e) {
					continue;
				}
			}
			return result;
		}


		/**
		 * 拼接某属性的 get方法
		 *
		 * @param fieldName
		 * @return String
		 */
		public static String parGetName(String fieldName) {
			if (null == fieldName || "".equals(fieldName)) {
				return null;
			}
			int startIndex = 0;
			if (fieldName.charAt(0) == '_')
				startIndex = 1;
			return "get"
					+ fieldName.substring(startIndex, startIndex + 1).toUpperCase()
					+ fieldName.substring(startIndex + 1);
		}

		/**
		 * 判断是否存在某属性的 get方法
		 *
		 * @param methods
		 * @param fieldGetMet
		 * @return boolean
		 */
		public static boolean checkGetMet(Method[] methods, String fieldGetMet) {
			for (Method met : methods) {
				if (fieldGetMet.equals(met.getName())) {
					return true;
				}
			}
			return false;
		}
}
