package CodingDaily;

import java.lang.reflect.Array;
import java.util.*;

public class WordLadderII {
    public List<List<String>> findLadders(String start, String end, List<String> wordList){
        List<List<String>> ans = new ArrayList<>();
        // �������end��ֱ�ӽ�������Ȼ��ѭ��
        if (!wordList.contains(end))
            return ans;

        return ans;
    }
    
    private void bfs(String start, String end, List<String> wordList, List<List<String>> ans){
        Queue<List<String>> queue = new LinkedList<>();
        List<String> path = new ArrayList<>();
        path.add(start);
        queue.offer(path);
        // �ж��Ƿ��Ѿ��ҵ�end����Ϊѭ������������
        boolean isFound = false;
        Set<String> dict = new HashSet<>(wordList);
        // ��¼�Ѿ����ʹ��ĵ���
        Set<String> visited = new HashSet<>();
        visited.add(start);
        while (!queue.isEmpty()){
            int size = queue.size();
            Set<String> subVisited = new HashSet<>();
            for (int j = 0; j < size; j++){
                // ��ǰ·��
                List<String> p = queue.poll();
                //��ǰ·��ĩβ�ĵ���
                String temp = p.get(p.size()-1);
                // ����������е���һ���ڵ�
                ArrayList<String> neighbors = getNeighbors(temp, dict);
                for (String neighbor : neighbors){
                    // ֻ����û���ֹ��ĵ���
                    if (!visited.contains(neighbor)){
                        // ����ҵ���end
                        if (neighbor.equals(end)){
                            isFound = true;
                            p.add(neighbor);
                            ans.add(new ArrayList<String>(p));
                            p.remove(p.size()-1);
                        }
                        p.add(neighbor);
                        queue.offer(new ArrayList<>(p));
                        p.remove(p.size()-1);
                        subVisited.add(neighbor);
                     }
                }
            }
            visited.addAll(subVisited);
            if (isFound)
                break;
        }
    }

    private ArrayList<String> getNeighbors(String node, Set<String> dict){
        ArrayList<String> res = new ArrayList<String>();
        char[] chs = node.toCharArray();
        for (char ch = 'a'; ch <= 'z'; ch++){
            for (int i = 0; i < chs.length; i++){
                if (chs[i] == ch)
                    continue;
                char oldch = chs[i];
                chs[i] = ch;
                if (dict.contains(String.valueOf(chs)))
                    res.add(String.valueOf(chs));
                chs[i] = oldch;
            }
        }
        return res;
    }
}
