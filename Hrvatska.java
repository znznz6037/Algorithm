package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hrvatska {
    public static void main(String[] args) {

        String[] alphabet = {"dz=", "c=", "c-", "d-", "lj", "nj", "s=", "z="};

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            //N 입력
            String str = br.readLine();
            br.close();

            int solution = 0;

            for(int i = 0; i < str.length(); i++) {
                String string;
                if(i + 2 <= str.length()) {
                    string = str.substring(i, i + 2);
                    for(int j = 1; j < alphabet.length; j++) {
                        if(alphabet[j].equals(string)) {
                            i++;
                            break;
                        }
                    }
                }
                if(i + 3 <= str.length()) {
                    string = str.substring(i, i + 3);
                    if(alphabet[0].equals(string)) i += 2;
                }
                solution++;
            }
            System.out.println(solution);

        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
