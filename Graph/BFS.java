package Graph;

import java.util.ArrayList;
import java.util.Queue;

import java.util.LinkedList;

class BFS {
	static class Edg {
		int src;
		int des;
		int wt;

		Edg(int a, int b, int c) {
			src = a;
			des = b;
			wt = c;
		}
	}

	static void make(ArrayList<Edg> gr[]) {
		for (int i = 0; i < gr.length; i++) {
			gr[i] = new ArrayList<>();
		}

		// 0 --vertex
		gr[0].add(new Edg(0, 1, 1));

		// 1 --vertex
		gr[1].add(new Edg(1, 0, 1));
		gr[1].add(new Edg(1, 2, 1));
		gr[1].add(new Edg(1, 3, 1));

		// 2 --vertex
		gr[2].add(new Edg(2, 1, 1));
		gr[2].add(new Edg(2, 3, 1));
		gr[2].add(new Edg(2, 4, 1));

		// 3 --vertex
		gr[3].add(new Edg(3, 1, 1));
		gr[3].add(new Edg(3, 2, 1));

		// 4 --vertex
		gr[4].add(new Edg(4, 2, 1));

	}

	public static void bfs_trav(ArrayList<Edg>[] gr) { // time complexity--> O(VERTICES+EDGES )
		Queue<Integer> q = new LinkedList<>();
		boolean vis[] = new boolean[gr.length];
		q.add(0); // source==0; starting element in the graph

		while (!q.isEmpty()) {
			int cu = q.remove();
			if (!vis[cu]) { // visit cu;
				System.out.print(cu + " ");
				vis[cu] = true;
				for (int i = 0; i < gr[cu].size(); i++) {
					Edg e = gr[cu].get(i);
					q.add(e.des);
				}
			}
		}
	}

	public static void dfs_trav(ArrayList<Edg> gr[], int curr, boolean vis[]) {
		System.out.print(curr + " ");
		vis[curr] = true;
		for (int i = 0; i < gr[curr].size(); i++) {
			Edg e = gr[curr].get(i);
			if (!vis[e.des]) {
				dfs_trav(gr, e.des, vis);
			}
		}

	}

	public static void main(String[] args) {
		int v = 5;
		@SuppressWarnings("unchecked")
		ArrayList<Edg>[] gr = new ArrayList[v];
		make(gr);
		System.out.println("BFS traversal");
		bfs_trav(gr);
		System.out.println("\nDFS traversal");
		dfs_trav(gr, 0, new boolean[v]);
	}
}
