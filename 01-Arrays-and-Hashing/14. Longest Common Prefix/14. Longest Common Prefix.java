1class Solution {
2    public String longestCommonPrefix(String[] strs) {
3        
4        if(strs.length == 0 ) return ;
5
6        String prefix = strs[0];
7
8        for(int i = 0; i < strs.length; i++){
9            while(strs[i].indexOf(prefix) != 0 ){
10                prefix = prefix.substring(0, prefix.length() - 1);
11                if(prefix.isEmpty()) return ;
12            }
13        }
14
15        return prefix;
16
17    }
18}