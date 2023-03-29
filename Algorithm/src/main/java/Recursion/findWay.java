package Recursion;

import java.util.HashMap;

public class findWay {
    HashMap<Integer,Integer> result;

    public boolean find(int[][] map, int a, int b, int chu, int kou ){
        if (map[chu][kou]==2){
            result.put(chu,kou);
            return true;
        }else {
            if (map[a][b]==0){
                //先假设这条路可以走
               map[a][b] = 2;
               //开始向周围搜索  搜索策略 右下 右 右上 下 左 左下 左上 上
                if (find(map,a+1,b+1,chu,kou)){
                    result.put(a,b);
                    return true;
                }else if (find(map,a,b+1,chu,kou)){
                    result.put(a,b);
                    return true;
                }else if (find(map,a-1,b+1,chu,kou)){
                    result.put(a,b);
                    return true;
                }else if (find(map,a+1,b,chu,kou)){
                    result.put(a,b);
                    return true;
                }else if (find(map,a,b-1,chu,kou)){
                    result.put(a,b);
                    return true;
                }else if (find(map,a+1,b-1,chu,kou)){
                    result.put(a,b);
                    return true;
                }else if (find(map,a-1,b-1,chu,kou)){
                    result.put(a,b);
                    return true;
                }else if (find(map,a+1,b,chu,kou)){
                    result.put(a,b);
                    return true;
                }else {
                    //说明该点走不通
                    map[a][b]=3;
                    return false;
                }
            }
        }
        return false;
    }
}
