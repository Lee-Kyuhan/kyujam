import java.util.*;
public class jam_bfs7576 {
	static Coor[][] coor;
	public static void main(String[] args) {
		int m, n;
		int ans=0;
		int day;
		int[] dx = { -1, 0, 1, 0 };
		int[] dy = { 0, 1, 0, -1 };

		Scanner scr = new Scanner(System.in);
		Coor[][] coor;
		boolean isNonZeroAtFirst = true;

		m = scr.nextInt(); // 가로길이
		n = scr.nextInt(); // 세로길이
		coor = new Coor[m + 1][n + 1];

		for (int i = 1; i <= n; i++) { // 세로 먼저
			for (int j = 1; j <= m; j++) { // 가로 m번
				coor[j][i] = new Coor(j, i, scr.nextInt());
			}
		}

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (coor[i][j].state == 0)
					isNonZeroAtFirst = false;
			}
		}

		Queue<Coor> q = new LinkedList<Coor>();
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (coor[i][j].state == 1) {
					q.add(coor[i][j]);
				}

			}
		}
		
		for (int lv = 1; !q.isEmpty(); lv++) {
			int length = q.size();

			for (int k = 1; k <= length; k++) {
				Coor now = q.remove();
				for (int i = 0; i < 4; i++) {
					int next_x = now.x + dx[i];
					int next_y = now.y + dy[i];

					if (next_x <= 0 || next_y <= 0 || next_x > m || next_y > n) {
						continue;
					}
					if (coor[next_x][next_y].state != 0) {
						continue;
					}
					q.add(coor[next_x][next_y]);
					coor[next_x][next_y].state = 1;
				}
			}
			ans = lv-1;
		}
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (coor[i][j].state == 0)
					ans = -1;
			}
		}
		System.out.println(isNonZeroAtFirst ? 0 : ans);
	}
}

class Coor {
	int x, y, state = 0;

	Coor(int x, int y, int state) {
		this.x = x;
		this.y = y;
		this.state = state;
	}
}
