package com.company.thirtydaychallenge;

import java.util.*;

public class GroupAnagrams {

        public List<List<String>> groupAnagrams(String[] strs) {

            HashMap<String,List<String>> groupAnagramsMap = new HashMap<>();
            String sortedString;
            List<String> tmp;
            char[] stringInChars;

            for(String str: strs)
            {   stringInChars = str.toCharArray();
                Arrays.sort(stringInChars);
                sortedString = new String(stringInChars);
                if(groupAnagramsMap.containsKey(sortedString))
                {
                    groupAnagramsMap.get(sortedString).add(str);
                }
                else
                {
                    tmp = new ArrayList<>();
                    tmp.add(str);
                    groupAnagramsMap.put(sortedString,tmp);
                }
            }

            return new LinkedList<>(groupAnagramsMap.values());
        }
}
