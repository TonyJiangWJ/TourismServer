package utils.statics;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class EncodeUtil {
	public static String toUTF8(String str){

		try {
			str=URLDecoder.decode(str,"ISO-8859-1");
			str=new String(str.getBytes("ISO-8859-1"));
			return str;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
