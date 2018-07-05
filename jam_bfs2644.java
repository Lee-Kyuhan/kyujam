import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class jam_bfs2644 {
	static int n, m, start, dest, ans;
	static int[][] adM = new int[101][101];
	static int[] degree = new int[101];
	
	public static void main(String args[]) {
		Scanner scr = new Scanner(System.in);
		n = scr.nextInt();
		start = scr.nextInt();
		dest = scr.nextInt();
		m = scr.nextInt();
		
		for(int i=0; i < m; i++) {
			int x = scr.nextInt();
			int y = scr.nextInt();
			adM[x][y] = adM[y][x] = 1;
		}
		
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		while(!q.isEmpty()) {
			int now = q.remove();
			for(int i=1; i <= n; i++) {
				if( adM[now][i]==0 || degree[i] != 0 ) continue;
				degree[i] = degree[now] + 1;
				q.add(i);
			}
		}
		System.out.println(degree[dest]==0 ? -1 : degree[dest]);
	}
}