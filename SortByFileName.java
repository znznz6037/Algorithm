import java.util.*;

class Solution {
    class File implements Comparable {
        String str;
        String head;
        int num;

        public File(String str, String head, int num) {
            this.str = str;
            this.head = head;
            this.num = num;
        }

        public int compareTo(Object obj) {
            File file = (File)obj;
            if(this.head.equals(file.head)) {
                if(this.num < file.num) return -1;
                else if(this.num == file.num) return 0;
                else return 1;
            }
            else return this.head.compareTo(file.head);
        }
    }

    public String[] solution(String[] files) {
        String[] answer = new String[files.length];

        File[] fileList = new File[files.length];
        for(int i = 0; i < files.length; i++) {
            fileList[i] = divideString(files[i]);
        }

        Arrays.sort(fileList);
        for(int i = 0; i < files.length; i++) {
            answer[i] = fileList[i].str;
        }

        return answer;
    }



    public File divideString(String str) {
        String head = "";
        String num = "";
        String tail = "";
        int idx = 0;

        //Head
        for(; idx < str.length(); idx++) {
            if(str.charAt(idx) >= '0' && str.charAt(idx) <= '9') break;
            head += str.charAt(idx);
        }

        //Number
        for(; idx < str.length(); idx++) {
            if(str.charAt(idx) < '0' || str.charAt(idx) > '9') break;
            num += str.charAt(idx);
        }

        File file = new File(str, head.toUpperCase(), Integer.parseInt(num));
        return file;
    }
}