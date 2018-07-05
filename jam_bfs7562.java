import java.util.*;
public class jam_bfs7562 {
	public static void main(String[] args) {
		int[] dx = { 1, 2, 2, 1, -1, -2, -2, -1 };
		int[] dy = { 2, 1, -1, -2, -2, -1, 1, 2 };
		int t, l;
		
		Scanner scr = new Scanner(System.in);
		Coor2[][] coor;

		t = scr.nextInt();
		for(int testCase=0; testCase<t; testCase++) {
			l = scr.nextInt();
			int ans = 0;
			coor = new Coor2[l][l];

			for (int i = 0; i < l; i++)
				for (int j = 0; j < l; j++)
					coor[i][j] = new Coor2(i, j);

			int num1 = scr.nextInt();
			int num2 = scr.nextInt();
			int start_x = num1;
			int start_y = num2;
			num1 = scr.nextInt();
			num2 = scr.nextInt();
			int dest_x = num1;
			int dest_y = num2;
			
			Queue<Coor2> q = new LinkedList<Coor2>();
			q.add(coor[start_x][start_y]);
			coor[start_x][start_y].state = 1;
			
			for (int lv = 1; coor[dest_x][dest_y].state!=1; lv++) {
				int length = q.size();
	
				for (int k = 1; k <= length; k++) {
					Coor2 now = q.remove();
					for (int i = 0; i < 8; i++) {
						int next_x = now.x + dx[i];
						int next_y = now.y + dy[i];
	
						if (next_x < 0 || next_y < 0 || next_x >= l || next_y >= l) {
							continue;
						}
						if (coor[next_x][next_y].state == 1) {
							continue;
						}
						q.add(coor[next_x][next_y]);
						coor[next_x][next_y].state = 1;
					}
				}
				ans = lv;
			}
			System.out.println(ans);
		}

	}
}
class Coor2 {
	int x, y, state = 0;

	Coor2(int x, int y) {
		this.x = x;
		this.y = y;
	}
}