package CodingDaily.Practices;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class traverseMap {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("a", "apple");
        map.put("b", "ball");

        // 使用entry，键值对都可以取到
        for (Map.Entry<String, String> entry : map.entrySet()){
            String mapKey = entry.getKey();
            String mapValue = entry.getValue();
            System.out.println(mapKey + ":" + mapValue);
        }

        // 遍历key或values，一般适用于只需要map中的key或者value时使用，在性能上比使用entrySet较好
        for (String key : map.keySet())
            System.out.println(key);
        for (String value : map.values())
            System.out.println(value);

        // 通过Iterator遍历
        Iterator<Map.Entry<String, String>> entries = map.entrySet().iterator();
        while (entries.hasNext()){
            Map.Entry<String, String> entry = entries.next();
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + ":" + value);
        }

        //通过键找值遍历，这种方式的效率比较低，因为本身从键取值是耗时的操作
        for (String key : map.keySet()){
            String value = map.get(key);
            System.out.println(key + ":" + value);
        }
    }
}
