package com.application.ilegra.rolldice;

import java.util.Random;

/**
 * Created by ilegra on 11/7/16.
 */
public class Dice {
    private int quantity;
    private int dice_weight;

    public Dice(String q, int d){
        try{
            this.quantity = Integer.parseInt(q);
        } catch (NumberFormatException e){
            this.quantity = 0;
        }

        this.dice_weight = d;
    }

    public int roll() {
        Random r = new Random();
        int total = 0;

        if(this.quantity > 0) {
            for(int i = 0; i < this.quantity; i++) {
                total += r.nextInt(dice_weight +1

                );
            }
        }

        return total;
    }
}
