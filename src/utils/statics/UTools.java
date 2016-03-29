package utils.statics;

import java.util.Date;

public class UTools {
	public static final int NLG = 233;
	public static final int TPC = 122;
	public static final int PKG = 123;
	public static final int ACT = 213;
	public static String getUniqueId(String name,String string){
//		Date date = new Date();
		Date date = DateUtil.GetDateFromString(string);
		if(date!=null){
			return ParseMD5.parseStrToMd5U32(name+String.valueOf(date.getTime()));
		}else{
			return ParseMD5.parseStrToMd5U32(name+string);	
		}
		
	}
}
