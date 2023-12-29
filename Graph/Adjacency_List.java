package Graph;

import java.util.*;

public class Adjacency_List {
	static class Edge {
		int src;
		int dest;
		int wt;

		public Edge(int s, int d, int w) {
			this.src = s;
			this.dest = d;
			this.wt = w;
		}
	}

	public static void main(String[] args) {
		int v = 5;
		@SuppressWarnings("unchecked")
		ArrayList<Edge>[] gr = new ArrayList[v]; // null-->empty ArrayList.
		for (int i = 0; i < v; i++) {
			gr[i] = new ArrayList<>();
		}

		// 0 --vertex
		gr[0].add(new Edge(0, 1, 5));

		// 1 --vertex
		gr[1].add(new Edge(1, 0, 5));
		gr[1].add(new Edge(1, 2, 1));
		gr[1].add(new Edge(1, 3, 3));

		// 2 --vertex
		gr[2].add(new Edge(2, 1, 1));
		gr[2].add(new Edge(2, 3, 1));
		gr[2].add(new Edge(2, 4, 2));

		// 3 --vertex
		gr[3].add(new Edge(3, 1, 3));
		gr[3].add(new Edge(3, 2, 1));

		// 4 --vertex
		gr[4].add(new Edge(4, 2, 2));

		// for 2 neignour
		for (int i = 0; i < gr[2].size(); i++) {
			Edge e = gr[2].get(i); // src,dest,wt;
			System.out.println(e.dest + " ");

		}
	}
}
