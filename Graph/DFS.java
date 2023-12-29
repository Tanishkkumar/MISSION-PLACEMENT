package Graph;

import java.util.ArrayList;

public class DFS {
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

	public static void dfs_trav(ArrayList<Edg> gr[], int curr, boolean vis[]) {  //O(V+E)
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
		System.out.println("DFS traversal");
		dfs_trav(gr, 0, new boolean[v]);
	}
}
