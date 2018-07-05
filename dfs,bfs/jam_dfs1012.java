import java.util.*;
public class jam_dfs1012 {
      static int [][]arr;
      static int sero;
      static int garo;
      static int [] dx = {-1,0,1,0};
      static int [] dy = { 0,1,0,-1};
      public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         int testcase = sc.nextInt();
         for(int i=0; i<testcase; i++) {
            garo = sc.nextInt();
            sero = sc.nextInt();
            arr = new int[garo][sero];
            int num_wom = sc.nextInt();
            for(int k=0; k<num_wom; k++) {
               int a =sc.nextInt();
               int b = sc.nextInt();
               arr[a][b] = 1;
            }
            int count=0;
            for(int k=0; k<garo; k++) {
               for(int j=0; j<sero; j++) {
                  if(arr[k][j] ==1) 
                  {   
                     count++;
                     dfs(k,j);
                     
                  }
               }
            }
            System.out.println(count);
         }
      
      }
      static void dfs(int x, int y) {
         for(int i=0; i<4; i++) {
            int next_x = x + dx[i];
            int next_y = y + dy[i];
            
            if(next_x<0 || next_y<0 || next_x>=garo || next_y>=sero) {
               continue;
            }
            if(arr[next_x][next_y]==0) {
               continue;
            }
            if(arr[next_x][next_y]==1) {
               arr[next_x][next_y] =0;
               dfs(next_x,next_y);
            }
            
            
         }
         
      }
   }