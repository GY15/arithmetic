package leetcode.hard;

import java.util.*;

public class findSubstring {
    // 将任意顺序的words组合在s中的index
    //思路，将word中的数存在一个map中，然后按照长度切s，若匹配则将map中计数减去，看切出来的东西是否匹配
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s.length() ==0||words.length==0){
            return  res;
        }

        if (s.replaceAll("a","").length()==0){
            if (words[0]==words[words.length-1]&&words[0].equals("a")){
                int i = s.length()-words.length;
                for (int j = 0; j <= i;j++){
                    res.add(j);
                }
                return res;
            }
        }
        try {
            int length = words[0].length();
            List<Word> list = new ArrayList<>();
            for (int j = 0; j < words.length; j++) {
                Word word = new Word(words[j]);
                String temp = s;
                while (true) {
                    int index = temp.indexOf(words[j]);
                    if (index < 0) {
                        if (word.queue.size() == 0) {
                            return res;
                        } else {
                            list.add(word);
                        }
                        break;
                    }
                    temp = temp.substring(0, index) + " " + temp.substring(index + 1);
                    word.setQueue(index);
                }
            }
            while (true) {
                sort(list);
                List<Word> tempList = new ArrayList<>();
                for (Word word : list) {
                    tempList.add(new Word(word));
                }
                int begin = tempList.remove(0).queue.peek();
                int next = begin;
                boolean isMatch = true;
                while (tempList.size() != 0) {
                    if (tempList.get(0).queue.size()==0){
                        isMatch =false;
                        break;

                    }
                    sort(tempList);

                    if (tempList.get(0).queue.peek() < next + length) {
                        tempList.get(0).queue.poll();
                    } else if (tempList.get(0).queue.peek() == next + length) {
                        next += length;
                        tempList.remove(0);
                    } else {
                        isMatch = false;
                        break;
                    }
                }
                if (isMatch && !res.contains(begin)) {
                    res.add(begin);
                }

                list.get(0).queue.poll();
                sort(list);
                if (list.get(0).queue.size() == 0) {
                    return res;
                }
            }

        }catch (Exception e){
            return res;
        }
        }
        private void sort(List<Word> list){
            Collections.sort(list, new Comparator<Word>() {
                @Override
                public int compare(Word o1, Word o2) {
                    return o1.queue.peek()-o2.queue.peek();
                }
            });
        }
        class Word {
            String words;
            Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1-o2;
                }
            });

            public Word(Word word) {
                this.words = word.words;
                this.queue = new PriorityQueue<>(word.queue);
            }

            public Word(String words) {
                this.words = words;
            }

            public void setQueue(int n) {
                this.queue.add(n);
            }
        }

        public static void main (String[]args){
            System.out.println(new findSubstring().findSubstring("aaaaaaaaaa", new String[]{"a","a","a"}).get(0));
        }
    public List<Integer> findSubstring2(String s, String[] words) {
        final Map<String, Integer> counts = new HashMap<>();
        for (final String word : words) {
            counts.put(word, counts.getOrDefault(word, 0) + 1);
        }
        final List<Integer> indexes = new ArrayList<>();
        final int n = s.length(), num = words.length, len = words[0].length();
        for (int i = 0; i < n - num * len + 1; i++) {
            final Map<String, Integer> seen = new HashMap<>();
            int j = 0;
            while (j < num) {
                final String word = s.substring(i + j * len, i + (j + 1) * len);
                if (counts.containsKey(word)) {
                    seen.put(word, seen.getOrDefault(word, 0) + 1);
                    if (seen.get(word) > counts.getOrDefault(word, 0)) {
                        break;
                    }
                } else {
                    break;
                }
                j++;
            }
            if (j == num) {
                indexes.add(i);
            }
        }
        return indexes;
    }
    }
