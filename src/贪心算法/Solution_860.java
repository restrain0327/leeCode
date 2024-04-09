package 贪心算法;

import java.util.Arrays;

public class Solution_860 {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;

        for (int i = 0; i < bills.length; i++) {
            // 收5元
            if (bills[i] == 5){
                five++;
                continue;
            }

            // 收10元
            if (bills[i] == 10){
                if (five > 0){
                    five--;
                    ten++;
                    continue;
                }else {
                    return false;
                }
            }

            // 收20元
            if (bills[i] == 20){
                if (five > 0 && ten > 0){
                    five--;
                    ten--;
                }else if (five >= 3){
                    five = five - 3;
                }else {
                    return false;
                }
            }
        }

        return true;
    }
}
