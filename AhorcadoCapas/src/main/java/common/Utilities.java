package common;

import java.util.ArrayList;

public class Utilities {
    private static ArrayList<Integer> codigos = new ArrayList<>();
    public static int darID () {
        int id = (int)(Math.random()*1000);
        for (int i = 0; i < codigos.size(); ) {
            if (id == codigos.get(i))
                id = (int)(Math.random()*1000);
            else
                i++;
        }
        codigos.add(id);
        return id;
    }
}
