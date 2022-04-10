import java.util.*;

class Solution {
    class Jaccard {
        String str;
        int cnt;

        public Jaccard(String str, int cnt) {
            this.str = str;
            this.cnt = cnt;
        }

        public boolean equals(Object object) {
            Jaccard jaccard = (Jaccard)object;
            if(this.str.equals(jaccard.str)) return true;
            return false;
        }
    }

    public int solution(String str1, String str2) {
        float answer = 0;
        ArrayList<Jaccard> arrayList1 = new ArrayList<>();
        ArrayList<Jaccard> arrayList2 = new ArrayList<>();

        arrayList1 = divideStr(str1);
        arrayList2 = divideStr(str2);

        if(arrayList1.size() == 0 && arrayList2.size() == 0) return 65536;

        answer = calIntersection(arrayList1, arrayList2) / calUnion(arrayList1, arrayList2) * 65536;
        return (int)answer;
    }

    public ArrayList<Jaccard> divideStr(String s) {
        String subStr;
        ArrayList<Jaccard> arrayList = new ArrayList<>();

        for(int i = 0; i < s.length() - 1; i++) {
            subStr = s.substring(i, i + 2).toUpperCase();
            if(subStr.charAt(0) >= 'A' && subStr.charAt(0) <= 'Z' && subStr.charAt(1) >= 'A' && subStr.charAt(1) <= 'Z') {
                Jaccard jaccard = new Jaccard(subStr, 1);
                if(arrayList.contains(jaccard)) {
                    int idx = arrayList.indexOf(jaccard);
                    int cnt = arrayList.get(idx).cnt;
                    arrayList.set(idx, new Jaccard(subStr, cnt + 1));
                }
                else arrayList.add(jaccard);
            }
        }

        return arrayList;
    }

    public float calIntersection(ArrayList<Jaccard> arrayList1, ArrayList<Jaccard> arrayList2) {
        int value = 0;

        for(int i = 0; i < arrayList1.size(); i++) {
            if(arrayList2.contains(arrayList1.get(i))) {
                Jaccard jaccard1 = arrayList1.get(i);
                Jaccard jaccard2 = arrayList2.get(arrayList2.indexOf(jaccard1));
                value += jaccard1.cnt > jaccard2.cnt ? jaccard2.cnt : jaccard1.cnt;
            }
        }

        return value;
    }

    public float calUnion(ArrayList<Jaccard> arrayList1, ArrayList<Jaccard> arrayList2) {
        int value = 0;

        for(int i = 0; i < arrayList1.size(); i++) {
            if(arrayList2.contains(arrayList1.get(i))) {
                Jaccard jaccard1 = arrayList1.get(i);
                Jaccard jaccard2 = arrayList2.get(arrayList2.indexOf(jaccard1));
                int cnt = jaccard1.cnt < jaccard2.cnt ? jaccard2.cnt : jaccard1.cnt;
                arrayList1.set(arrayList1.indexOf(jaccard1), new Jaccard(jaccard1.str, cnt));
            }
        }

        for(int i = 0; i < arrayList2.size(); i++) {
            if(!arrayList1.contains(arrayList2.get(i))) {
                arrayList1.add(arrayList2.get(i));
            }
        }

        for(int i = 0; i < arrayList1.size(); i++) {
            value += arrayList1.get(i).cnt;
        }

        return value;
    }
}