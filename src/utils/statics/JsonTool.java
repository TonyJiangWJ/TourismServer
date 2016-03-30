package utils.statics;

/**
 * Created by TonyJiang on 2016/3/26.
 */
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.Topic;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


/**
 * ��Ȩ���У�XXX���޹�˾
 *
 * JsonTool
 *
 * @author zhou.wenkai ,Created on 2015-10-8 09:04:23
 * 		   Major Function��<b>JSON ���� ������</b>
 *
 *         ע:������޸��˱�������д����������Ϊ��¼����Ǳ��˲����ͷ�֪ͨ��лл������
 * @author mender��Modified Date Modify Content:
 */
public class JsonTool {

    private static boolean DEBUG = false;

    /**
     * ��JSON�ַ�����װ������
     *
     * @param jsonStr ����װ��JSON�ַ���
     * @param clazz ����װ��ʵ���ֽ���
     * @return T: ��װJSON���ݵĶ���
     * @version 1.0
     */
    public static <T> T toBean(String jsonStr, Class<T> clazz) {
        try {
            JSONObject job = new JSONObject(jsonStr);
            return parseObject(job, clazz, null);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * �� �������Ϊ JSON��ʽ
     *
     * @param t ����װ�Ķ���
     * @return String: ��װ��JSONObject String��ʽ
     * @version 1.0
     */
    public static <T> String toJson(T t) {
        if (t == null) {
            return "{}";
        }
        return objectToJson(t);
    }

    /**
     * ��JSON�ַ�������Bean����
     *
     * @param jsonStr
     * @param className ������Bean���������
     * @return String:
     * @version 1.0
     */
    public static String createBean(String jsonStr, String className) {
        try {
            JSONObject job = new JSONObject(jsonStr);
            return createObject(job, className, 0);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * JSONObject ��װ�� ����ʵ��
     *
     * @param job ����װ��JSONObject
     * @param c ����װ��ʵ������class
     * @param v	����װʵ�����ⲿ��ʵ������</br>ֻ���ڲ������,�ⲿ��ʱ����null
     * @return T:��װ���ݵ�ʵ������
     * @version 1.0
     * @date 2015-10-9
     * @Author zhou.wenkai
     */
    @SuppressWarnings("unchecked")
    private static <T, V> T parseObject(JSONObject job, Class<T> c, V v) {
        T t = null;
        try {
            if(null == v) {
                t = c.newInstance();
            } else {
                Constructor<?> constructor = c.getDeclaredConstructors()[0];
                constructor.setAccessible(true);
                t = (T) constructor.newInstance(v);
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
//            Log.e(JsonTool.class.getSimpleName(),
//                    c.toString() + " should provide a default constructor " +
//                            "(a public constructor with no arguments)");
        } catch (Exception e) {
            if(DEBUG)
                e.printStackTrace();
        }

        Field[] fields = c.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            Class<?> type = field.getType();
            String name = field.getName();

            // if the object don`t has a mapping for name, then continue
            if(!job.has(name)) continue;

            String typeName = type.getName();
            if(typeName.equals("java.lang.String")) {
                try {
                    String value = job.getString(name);
                    if (value != null && value.equals("null")) {
                        value = "";
                    }
                    field.set(t, value);
                } catch (Exception e) {
                    if(DEBUG)
                        e.printStackTrace();
                    try {
                        field.set(t, "");
                    } catch (Exception e1) {
                        if(DEBUG)
                            e1.printStackTrace();
                    }
                }
            } else if(typeName.equals("int") ||
                    typeName.equals("java.lang.Integer")) {
                try {
                    field.set(t, job.getInt(name));
                } catch (Exception e) {
                    if(DEBUG)
                        e.printStackTrace();
                }
            } else if(typeName.equals("boolean") ||
                    typeName.equals("java.lang.Boolean")) {
                try {
                    field.set(t, job.getBoolean(name));
                } catch (Exception e) {
                    if(DEBUG)
                        e.printStackTrace();
                }
            } else if(typeName.equals("float") ||
                    typeName.equals("java.lang.Float")) {
                try {
                    field.set(t, Float.valueOf(job.getString(name)));
                } catch (Exception e) {
                    if(DEBUG)
                        e.printStackTrace();
                }
            } else if(typeName.equals("double") ||
                    typeName.equals("java.lang.Double")) {
                try {
                    field.set(t, job.getDouble(name));
                } catch (Exception e) {
                    if(DEBUG)
                        e.printStackTrace();
                }
            } else if(typeName.equals("long") ||
                    typeName.equals("java.lang.Long")) {
                try {
                    field.set(t, job.getLong(name));
                } catch (Exception e) {
                    if(DEBUG)
                        e.printStackTrace();
                }
            } else if(typeName.equals("java.util.List") ||
                    typeName.equals("java.util.ArrayList")){
                try {
                    Object obj = job.get(name);
                    Type genericType = field.getGenericType();
                    String className = genericType.toString().replace("<", "")
                            .replace(type.getName(), "").replace(">", "");
                    Class<?> clazz = Class.forName(className);
                    if(obj instanceof JSONArray) {
                        ArrayList<?> objList = parseArray((JSONArray)obj, clazz, t);
                        field.set(t, objList);
                    }
                } catch (Exception e) {
                    if(DEBUG)
                        e.printStackTrace();
                }
            } else {
                try {
                    Object obj = job.get(name);
                    Class<?> clazz = Class.forName(typeName);
                    if(obj instanceof JSONObject) {
                        Object parseJson = parseObject((JSONObject)obj, clazz, t);
                        field.set(t, parseJson);
                    }
                } catch (Exception e) {
                    if(DEBUG)
                        e.printStackTrace();
                }

            }
        }

        return t;
    }

    /**
     * �� JSONArray ��װ�� ArrayList ����
     *
     * @param array ����װ��JSONArray
     * @param c ����װʵ���ֽ���
     * @param v ����װʵ�����ⲿ��ʵ������</br>ֻ���ڲ������,�ⲿ��ʱ����null
     * @return ArrayList<T>: ��װ���ʵ�弯��
     * @version 1.0
     * @date 2015-10-8
     */
    @SuppressWarnings("unchecked")
    private static <T, V> ArrayList<T> parseArray(JSONArray array, Class<T> c, V v) {
        ArrayList<T> list = new ArrayList<T>(array.length());
        try {
            for (int i = 0; i < array.length(); i++) {
                if(array.get(i) instanceof JSONObject) {
                    T t = parseObject(array.getJSONObject(i), c, v);
                    list.add(t);
                } else {
                    list.add((T) array.get(i));
                }

            }
        } catch (Exception e) {
            if(DEBUG)
                e.printStackTrace();
        }
        return list;
    }

    /**
     * �� �������Ϊ JSON��ʽ
     *
     * @param t ����װ�Ķ���
     * @return String: ��װ��JSONObject String��ʽ
     * @version 1.0
     * @date 2015-10-11
     * @Author zhou.wenkai
     */
    private static <T> String objectToJson(T t) {

        Field[] fields = t.getClass().getDeclaredFields();
        StringBuilder sb = new StringBuilder(fields.length << 4);
        sb.append("{");

        for (Field field : fields) {
            field.setAccessible(true);
            Class<?> type = field.getType();
            String name = field.getName();

            // 'this$Number' ���ڲ�����ⲿ������(ָ��)�ֶ�
            if(name.contains("this$")) continue;

            String typeName = type.getName();
            if(typeName.equals("java.lang.String")) {
                try {
                    sb.append("\""+name+"\":");
                    sb.append(stringToJson((String)field.get(t)));
                    sb.append(",");
                } catch (Exception e) {
                    if(DEBUG)
                        e.printStackTrace();
                }
            } else if(typeName.equals("boolean") ||
                    typeName.equals("java.lang.Boolean") ||
                    typeName.equals("int") ||
                    typeName.equals("java.lang.Integer") ||
                    typeName.equals("float") ||
                    typeName.equals("java.lang.Float") ||
                    typeName.equals("double") ||
                    typeName.equals("java.lang.Double") ||
                    typeName.equals("long") ||
                    typeName.equals("java.lang.Long")) {
                try {
                    sb.append("\""+name+"\":");
                    sb.append(field.get(t));
                    sb.append(",");
                } catch (Exception e) {
                    if(DEBUG)
                        e.printStackTrace();
                }
            } else if(typeName.equals("java.util.List") ||
                    typeName.equals("java.util.ArrayList")){
                try {
                    List<?> objList = (List<?>) field.get(t);
                    if(null != objList && objList.size() > 0) {
                        sb.append("\""+name+"\":");
                        sb.append("[");
                        String toJson = listToJson((List<?>) field.get(t));
                        sb.append(toJson);
                        sb.setCharAt(sb.length()-1, ']');
                        sb.append(",");
                    }
                } catch (Exception e) {
                    if(DEBUG)
                        e.printStackTrace();
                }
            } else {
                try {
                    sb.append("\""+name+"\":");
                    sb.append("{");
                    sb.append(objectToJson(field.get(t)));
                    sb.setCharAt(sb.length()-1, '}');
                    sb.append(",");
                } catch (Exception e) {
                    if(DEBUG)
                        e.printStackTrace();
                }
            }

        }
        if(sb.length() == 1) {
            sb.append("}");
        }
        sb.setCharAt(sb.length()-1, '}');
        return sb.toString();
    }

    /**
     * �� List �������Ϊ JSON��ʽ
     *
     * @param objList ����װ�Ķ��󼯺�
     * @return String:��װ��JSONArray String��ʽ
     * @version 1.0
     * @date 2015-10-11
     * @Author zhou.wenkai
     */
    private static<T> String listToJson(List<T> objList) {
        final StringBuilder sb = new StringBuilder();
        for (T t : objList) {
            if(t instanceof String) {
                sb.append(stringToJson((String) t));
                sb.append(",");
            } else if(t instanceof Boolean ||
                    t instanceof Integer ||
                    t instanceof Float ||
                    t instanceof Double) {
                sb.append(t);
                sb.append(",");
            } else {
                sb.append(objectToJson(t));
                sb.append(",");
            }
        }
        return sb.toString();
    }

    /**
     * �� String �������Ϊ JSON��ʽ��ֻ�账��������ַ�
     *
     * @param str String ����
     * @return String:JSON��ʽ
     * @version 1.0
     * @date 2015-10-11
     * @Author zhou.wenkai
     */
    private static String stringToJson(final String str) {
        if(str == null || str.length() == 0) {
            return "\"\"";
        }
        final StringBuilder sb = new StringBuilder(str.length() + 2 << 4);
        sb.append('\"');
        for (int i = 0; i < str.length(); i++) {
            final char c = str.charAt(i);

            sb.append(c == '\"' ? "\\\"" : c == '\\' ? "\\\\"
                    : c == '/' ? "\\/" : c == '\b' ? "\\b" : c == '\f' ? "\\f"
                    : c == '\n' ? "\\n" : c == '\r' ? "\\r"
                    : c == '\t' ? "\\t" : c);
        }
        sb.append('\"');
        return sb.toString();
    }

    /**
     * ��JSONObject����Bean����
     *
     * @param job
     * @param className ������Bean���������
     * @param outCount �ⲿ��ĸ���
     * @return LinkedList<String>: ���ɵ�Bean����
     * @version 1.0
     * @date 2015-10-16
     * @Author zhou.wenkai
     */
    private static String createObject(JSONObject job, String className, int outCount) {
        final StringBuilder sb = new StringBuilder();
        String separator = System.getProperty("line.separator");

        // ���ɵ�Bean��ǰ���������ռ�
        String classFrontSpace = "";
        // ���ɵ�Bean���ֶ�ǰ���������ռ�
        String fieldFrontSpace = "    ";
        for (int i = 0; i < outCount; i++) {
            classFrontSpace += "    ";
            fieldFrontSpace += "    ";
        }

        sb.append(classFrontSpace + "public class " + className + " {");

        Iterator<?> it = job.keys();
        while (it.hasNext()) {
            String key = (String) it.next();
            try {
                Object obj = job.get(key);
                if(obj instanceof JSONArray) {
                    // �ж����Ƿ�Ϊ������������,���Ϊ�Զ��������ֶ�����ȡ��key������ĸ��д��Ϊ�ڲ�������
                    String fieldType = ((JSONArray)obj).get(0) instanceof JSONObject ?
                            "" : ((JSONArray)obj).get(0).getClass().getSimpleName();
                    if(fieldType == "") {
                        fieldType = String.valueOf(Character.isUpperCase(key.charAt(0)) ?
                                key.charAt(0) : Character.toUpperCase(key.charAt(0))) + key.substring(1);
                    }
                    sb.append(separator);
                    sb.append(fieldFrontSpace + "public List<" + fieldType + "> " + key + ";");

                    // ����ֶ�����Ϊ�Զ���������,��ȡJSONArray�е�һ��JSONObject����Bean
                    if(((JSONArray)obj).get(0) instanceof JSONObject) {
                        sb.append(separator);
                        sb.append(separator);
                        sb.append(fieldFrontSpace + "/** "+ fieldType +" is the inner class of "+ className +" */");
                        sb.append(separator);
                        sb.append(createObject((JSONObject)((JSONArray)obj).get(0), fieldType, outCount+1));
                    }
                } else if(obj instanceof JSONObject) {
                    String fieldType = String.valueOf(Character.isUpperCase(key.charAt(0)) ?
                            key.charAt(0) : Character.toUpperCase(key.charAt(0))) + key.substring(1);
                    sb.append(separator);
                    sb.append(fieldFrontSpace + "public List<" + fieldType + "> " + key + ";");
                    sb.append(separator);
                    sb.append(separator);
                    sb.append(fieldFrontSpace + "/** "+ fieldType +" is the inner class of "+ className +" */");
                    sb.append(separator);
                    sb.append(createObject((JSONObject)obj, fieldType, outCount+1));
                } else {
                    String type = obj.getClass().getSimpleName();
                    sb.append(separator);
                    sb.append(fieldFrontSpace + "public " + type + " " + key + ";");
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        sb.append(separator);
        sb.append(classFrontSpace + "}");
        sb.append(separator);

        return sb.toString();
    }

    public static String JavaArray2Json(ArrayList list){
    	JSONArray jsonArray = new JSONArray();
    	for(int i=0;i<list.size();i++){
    		try {
				JSONObject jsonObject = new JSONObject(toJson(list.get(i)));
				jsonArray.put(jsonObject);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	return jsonArray.toString();
    }
}

