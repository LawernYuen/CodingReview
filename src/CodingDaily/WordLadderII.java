package CodingDaily;

import java.lang.reflect.Array;
import java.util.*;

public class WordLadderII {
    public List<List<String>> findLadders(String start, String end, List<String> wordList){
        List<List<String>> ans = new ArrayList<>();
        // 如果不含end则直接结束，不然死循环
        if (!wordList.contains(end))
            return ans;

        return ans;
    }
    
    private void bfs(String start, String end, List<String> wordList, List<List<String>> ans){
        Queue<List<String>> queue = new LinkedList<>();
        List<String> path = new ArrayList<>();
        path.add(start);
        queue.offer(path);
        // 判断是否已经找到end，作为循环跳出的条件
        boolean isFound = false;
        Set<String> dict = new HashSet<>(wordList);
        // 记录已经访问过的单词
        Set<String> visited = new HashSet<>();
        visited.add(start);
        while (!queue.isEmpty()){
            int size = queue.size();
            Set<String> subVisited = new HashSet<>();
            for (int j = 0; j < size; j++){
                // 当前路径
                List<String> p = queue.poll();
                //当前路径末尾的单词
                String temp = p.get(p.size()-1);
                // 这个单词所有的下一个节点
                ArrayList<String> neighbors = getNeighbors(temp, dict);
                for (String neighbor : neighbors){
                    // 只考虑没出现过的单词
                    if (!visited.contains(neighbor)){
                        // 如果找到了end
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
