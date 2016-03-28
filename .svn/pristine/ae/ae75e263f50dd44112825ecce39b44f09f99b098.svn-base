package ascenseur.utils;

import java.util.ArrayList;

/**
 * Created by r14006780 on 15/01/16.
 */
public class Calcul {

    public static int getMinPositiveOuNulleValeurDe(ArrayList<Integer> inputArray) {
        Integer minValue = inputArray.get(0);
        for(Integer i=1;i<inputArray.size();i++){
            if(inputArray.get(i) < minValue && inputArray.get(i) >= 0){
                minValue = inputArray.get(i);
            }
        }
        return minValue;
    }
}
