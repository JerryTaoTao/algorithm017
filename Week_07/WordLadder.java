//给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
//
//
//
// 每次转换只能改变一个字母。
// 转换过程中的中间单词必须是字典中的单词。
//
//
// 说明:
//
//
// 如果不存在这样的转换序列，返回 0。
// 所有单词具有相同的长度。
// 所有单词只由小写字母组成。
// 字典中不存在重复的单词。
// 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
//
//
// 示例 1:
//
// 输入:
//beginWord = "hit",
//endWord = "cog",
//wordList = ["hot","dot","dog","lot","log","cog"]
//
//输出: 5
//
//解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
//     返回它的长度 5。
//
//
// 示例 2:
//
// 输入:
//beginWord = "hit"
//endWord = "cog"
//wordList = ["hot","dot","dog","lot","log"]
//
//输出: 0
//
//解释: endWord "cog" 不在字典中，所以无法进行转换。
// Related Topics 广度优先搜索
// 👍 641 👎 0


//单词接龙


import java.util.*;
import java.util.stream.Collectors;

public class WordLadder{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new WordLadder().new Solution();
        //System.out.println(solution.ladderLength("hit",
        //"cog", Arrays.asList("hot","dot","dog","lot","cog")));
    }
    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            //return bfs(beginWord, endWord, wordList);
            //return bothBfs(beginWord, endWord, wordList);
            return optimizeBothBfs(beginWord, endWord, wordList);
        }

        public int optimizeBothBfs(String beginWord, String endWord, List<String> wordList) {
            int level = 0;
            if (!wordList.contains(endWord)) return level;
            LinkedList<String> startQ = new LinkedList<>();
            Set<String> startVisited = new HashSet<>();
            startQ.add(beginWord);
            startVisited.add(beginWord);
            int count1 = 0;
            int count2 = 0;


            LinkedList<String> endQ = new LinkedList<>();
            Set<String> endVisited = new HashSet<>();

            endQ.add(endWord);
            endVisited.add(endWord);

            while (startQ.size() > 0 && endQ.size() > 0) {
                if (startQ.size() <= endQ.size()) {
                    int size = startQ.size();
                    count1 ++;
                    for (int i = 0; i < size ; i ++) {
                        String sPop = startQ.pop();
                        List<String> neighbor1 = getConnectList(sPop, wordList, startVisited);
                        for (String s : neighbor1) {
                            if (endVisited.contains(s)) return count1 + count2 + 1;
                            if (!startVisited.contains(s)) {
                                startVisited.add(s);
                                startQ.add(s);
                            }
                        }
                    }
                } else {
                    int endSize = endQ.size();
                    count2 ++;
                    for (int i = 0; i < endSize ; i ++) {
                        String ePop = endQ.pop();
                        List<String> neighbor2 = getConnectList(ePop, wordList, endVisited);
                        for (String s : neighbor2) {
                            if (startVisited.contains(s)) return count1 + count2 + 1;
                            if (!endVisited.contains(s)) {
                                endVisited.add(s);
                                endQ.add(s);
                            }
                        }
                    }
                }
            }
            return 0;

        }

        public int bothBfs(String beginWord, String endWord, List<String> wordList) {
            int level = 0;
            if (!wordList.contains(endWord)) return level;
            LinkedList<String> startQ = new LinkedList<>();
            Set<String> startVisited = new HashSet<>();
            startQ.add(beginWord);
            startVisited.add(beginWord);
            int count1 = 0;
            int count2 = 0;


            LinkedList<String> endQ = new LinkedList<>();
            Set<String> endVisited = new HashSet<>();

            endQ.add(endWord);
            endVisited.add(endWord);

            while (startQ.size() > 0 && endQ.size() > 0) {
                int size = startQ.size();
                count1 ++;
                for (int i = 0; i < size ; i ++) {
                    String sPop = startQ.pop();
                    List<String> neighbor1 = getConnectList(sPop, wordList, startVisited);
                    for (String s : neighbor1) {
                        if (endVisited.contains(s)) return count1 + count2 + 1;
                        if (!startVisited.contains(s)) {
                            startVisited.add(s);
                            startQ.add(s);
                        }
                    }
                }
                int endSize = endQ.size();
                count2 ++;
                for (int i = 0; i < endSize ; i ++) {
                    String ePop = endQ.pop();
                    List<String> neighbor2 = getConnectList(ePop, wordList, endVisited);
                    for (String s : neighbor2) {
                        if (startVisited.contains(s)) return count1 + count2 + 1;
                        if (!endVisited.contains(s)) {
                            endVisited.add(s);
                            endQ.add(s);
                        }
                    }
                }
            }

            return 0;


        }

        public int bfs(String beginWord, String endWord, List<String> wordList) {
            int level = 0;
            if (!wordList.contains(endWord)) return level;
            LinkedList<String> queue = new LinkedList<>();
            Set<String> visited = new HashSet<>();
            queue.add(beginWord);
            visited.add(beginWord);
            while (queue.size() > 0) {
                int size = queue.size();
                level ++;
                for (int i = 0; i < size; i++) {
                    String pop = queue.pollFirst();
                    if (pop.equals(endWord)) return level;
                    List<String> neihgbors = getConnectList(pop, wordList, visited);
                    if (!neihgbors.isEmpty()) {
                        for(String e : neihgbors) {
                            if (!visited.contains(e)) {
                                queue.add(e);
                                visited.add(e);
                            }
                        }
                    }
                }
            }
            return 0;
        }

        public boolean isConnect(String f, String second) {
            int count = 0;
            for (int i = 0; i < f.length(); i++) {
                if (f.charAt(i) != second.charAt(i)) {
                    count ++;
                    if (count > 1) return false;
                }
            }
            return count == 1;
        }

        public  List<String> getConnectList(String curWord, List<String> wordList, Set<String> visited) {
            return wordList.stream().filter(e -> isConnect(curWord, e) && !visited.contains(e)).collect(Collectors.toList());
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}