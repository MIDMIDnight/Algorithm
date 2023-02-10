package Recursion;

public class MazeRecursion {
    public static void main(String[] args) {
        int[][] map=new int[8][7];
        for (int i =0;i<8;i++){
            map[i][0]=1;
            map[i][6]=1;
        }
        for (int i = 0; i < 7; i++) {
            map[0][i]=1;
            map[7][i]=1;
        }
        map[3][1]=1;
        map[3][2]=1;
        for (int[] aa:map
        ) {
            System.out.println();
            for (int a:aa
            ) {
                System.out.print(a+"   ");
            }
        }
        boolean b = setWays(map, 1, 1);
        System.out.println();
        System.out.println("----------------------------------------------------");
        for (int[] aa:map
        ) {
            System.out.println();
            for (int a:aa
            ) {
                System.out.print(a+"   ");
            }
        }
    }
    public static boolean setWays(int[][] map,int a,int b){
        if (map[6][5]==2){
            return true;
        }else {
            if (map[a][b]==0){
                map[a][b]=2;  //先假设这条路可以走
                //策略下 右 左 上
                if (setWays(map,a+1,b)){
                    return true;
                } else if (setWays(map,a,b+1)) {
                    return true;
                } else if (setWays(map,a,b-1)) {
                    return true;
                } else if (setWays(map,a-1,b)) {
                    return true;
                }else {
                    //说明该点走不通
                    map[a][b]=3;
                    return false;
                }
            }
            return false;
        }
    }
}
