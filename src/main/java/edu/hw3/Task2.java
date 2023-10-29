package edu.hw3;

import java.util.ArrayList;
import java.util.Map;

public class Task2 {

    private static final Map<Character, Integer> PARENTHESIS_BALANCE_WEIGHTS = Map.of(
        '(', 1,
        ')', -1
    );

    private Task2() {
    }

    public static ArrayList<String> clusterize(String str) {
        ArrayList<String> balancedClusters = new ArrayList<>();
        int balance = 0;
        StringBuilder currCluster = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            Character parenth = str.charAt(i);
            if (PARENTHESIS_BALANCE_WEIGHTS.containsKey(parenth)) {
                int balanceWeight = PARENTHESIS_BALANCE_WEIGHTS.get(parenth);
                currCluster.append(parenth);
                balance += balanceWeight;
                if (balance == 0) {
                    balancedClusters.add(currCluster.toString());
                    currCluster.setLength(0);
                }
                if (balance < 0) {
                    currCluster.setLength(0);
                    balance = 0;
                }
            }
        }
        return balancedClusters;
    }
}
