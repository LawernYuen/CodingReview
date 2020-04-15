package CodingDaily.Practices;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class traverseMap {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("a", "apple");
        map.put("b", "ball");

        // ʹ��entry����ֵ�Զ�����ȡ��
        for (Map.Entry<String, String> entry : map.entrySet()){
            String mapKey = entry.getKey();
            String mapValue = entry.getValue();
            System.out.println(mapKey + ":" + mapValue);
        }

        // ����key��values��һ��������ֻ��Ҫmap�е�key����valueʱʹ�ã��������ϱ�ʹ��entrySet�Ϻ�
        for (String key : map.keySet())
            System.out.println(key);
        for (String value : map.values())
            System.out.println(value);

        // ͨ��Iterator����
        Iterator<Map.Entry<String, String>> entries = map.entrySet().iterator();
        while (entries.hasNext()){
            Map.Entry<String, String> entry = entries.next();
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + ":" + value);
        }

        //ͨ������ֵ���������ַ�ʽ��Ч�ʱȽϵͣ���Ϊ����Ӽ�ȡֵ�Ǻ�ʱ�Ĳ���
        for (String key : map.keySet()){
            String value = map.get(key);
            System.out.println(key + ":" + value);
        }
    }
}
