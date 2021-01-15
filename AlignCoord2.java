package com.company;

import java.io.*;
import java.util.Arrays;

public class AlignCoord2 {
	static class Coord implements Comparable<Coord> {
		int x;
		int y;

		public Coord(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Coord o) {
			if(this.y < o.y) return -1;
			else if(this.y > o.y) return 1;
			else {
				if(this.x < o.x) return -1;
				else return 1;
			}
		}
	}
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try{
			int N = Integer.parseInt(br.readLine());
			Coord[] coords = new Coord[N];
			String[] strings = new String[2];
			for(int i = 0; i < N; i++) {
				strings = br.readLine().split(" ");
				coords[i] = new Coord(Integer.parseInt(strings[0]), Integer.parseInt(strings[1]));
			}

			Arrays.sort(coords);

			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			for(Coord c: coords) {
				bw.write(c.x + " " + c.y);
				if(!c.equals(coords[N - 1])) bw.newLine();
			}
			bw.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
