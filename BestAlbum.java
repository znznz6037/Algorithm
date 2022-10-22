import java.util.*;

class Solution {
    class Song {
        int idx;
        int len;

        Song(int idx, int len) {
            this.idx = idx;
            this.len = len;
        }
    }

    Map<String, List<Song>> map;
    Map<String, Integer> cntMap;

    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};

        map = new HashMap<>();
        cntMap = new HashMap<>();

        setHashMap(genres, plays);
        return getAnswer(genres, plays);
    }

    public void setHashMap(String[] genres, int[] plays) {
        List<Song> list;
        for(int i = 0; i < genres.length; i++) {
            String genre = genres[i];

            if(map.get(genre) == null) {
                list = new ArrayList<Song>();
                list.add(new Song(i, plays[i]));
                map.put(genre, list);
                cntMap.put(genre, plays[i]);
            }
            else {
                list = map.get(genre);
                list.add(new Song(i, plays[i]));
                cntMap.put(genre, cntMap.get(genre) + plays[i]);
            }
        }
    }

    public int[] getAnswer(String[] genres, int[] plays) {
        int idx = 0;
        List<Integer> answerList = new ArrayList<>();
        List<String> keySet = new ArrayList<>(cntMap.keySet());

        Collections.sort(keySet, (o1, o2) -> cntMap.get(o2) - cntMap.get(o1));

        for(String genre: keySet) {
            List<Song> values = map.get(genre);

            if(values.size() == 1) {
                answerList.add(values.get(0).idx);
            }
            else {
                Collections.sort(values, new Comparator<Song>() {
                    public int compare(Song s1, Song s2) {
                        return s2.len - s1.len;
                    }
                });

                answerList.add(values.get(0).idx);
                answerList.add(values.get(1).idx);
            }
        }

        idx = 0;
        int[] answer = new int[answerList.size()];
        for(int i: answerList) {
            answer[idx++] = i;
        }

        return answer;
    }
}