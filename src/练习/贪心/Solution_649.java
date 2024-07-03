package 练习.贪心;

/**
 * 文件描述：
 *
 * @Author : restrain
 * @CreateDate 2024/7/2 12:05
 */
public class Solution_649 {
    public String predictPartyVictory(String senate) {
        // 贪心算法
        // 只需要计算出每个阵营有多少个 就可以比较

        // 要模拟出每一轮

        boolean R = true;
        boolean D = true;
        int flat = 0; // flat大于0 则R在D前面 小于0 则D在R前面 判断是否被消灭


        char[] charArray = senate.toCharArray();

        while (R && D){ // 有一个不是flase就退出循环
            R = false;
            D = false;

            for (int i=0; i<charArray.length; i++){
                if (charArray[i] == 'R'){
                    if (flat<0) charArray[i] = 0;
                    else R = true;
                    flat++;
                }

                if (charArray[i] == 'D'){
                    if (flat>0) charArray[i] = 0; // 被消灭
                    else D = true;
                    flat--;
                }
            }
        }

        return R ? "Radiant" : "Dire";
    }

    public static void main(String[] args) {
        System.out.println(new Solution_649().predictPartyVictory("DDRRRR"));
    }
}
