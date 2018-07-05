import java.util.*;
public class jam_bfs2178 {
	static int[][] coor;
	public static void main(String[] args) {
		
		Scanner scr = new Scanner(System.in);
		int[] dx = { -1, 0, 1, 0 };
		int[] dy = { 0, 1, 0, -1 };
		
		int n = scr.nextInt(); // 4행
		int m = scr.nextInt(); // 6열
		
		coor = new int[n+1][m+1];	// 4행 6열의 객체배열
		for(int i=1; i<=n; i++) {
			String temp = scr.next();
			for(int j=1; j<=m; j++) {
				coor[i][j] = temp.charAt(j-1)-48;
			}
		}
		Queue<Integer> q1 = new LinkedList<Integer>();
		Queue<Integer> q2 = new LinkedList<Integer>();
		q1.add(1);
		q2.add(1);
		
		while(true) {
			int now_x = q1.remove();
			int now_y = q2.remove();
			if( now_x == n && now_y == m ) break;
			for (int i = 0; i < 4; i++) {
				int next_x = now_x + dx[i];
				int next_y = now_y + dy[i];

				if (next_x <= 0 || next_y <= 0 || next_x > n || next_y > m) { // n,m이 다른문제랑 바뀜
					continue;
				}
				if (coor[next_x][next_y] == 1) {
					q1.add(next_x);
					q2.add(next_y);
					coor[next_x][next_y] = coor[now_x][now_y]+1;
				}
			}
		}
		System.out.println(coor[n][m]);
	}
}