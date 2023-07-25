package com.github.zipcodewilmington.casino.games.Roulette;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;


public class rouletteTable {
    private final ArrayList numbers;

    private final HashMap<Object, Object> numbertocolor = new HashMap<>();
    Random random = new Random();
    
    

    public rouletteTable(ArrayList numbers, String colors) {
        this.numbers = numbers;

        rouletteGetNumbers();
        rouletteGetColors();

    }

        private void rouletteGetNumbers () {
            for (int i = 0; i <= 36; i++) {
                numbers.add(i);
            }
        }
        private void rouletteGetColors () {
            numbertocolor.put(0, "green");
            numbertocolor.put(1, "red");
            numbertocolor.put(2, "black");
            numbertocolor.put(3, "red");
            numbertocolor.put(4, "black");
            numbertocolor.put(5, "red");
            numbertocolor.put(6, "black");
            numbertocolor.put(7, "red");
            numbertocolor.put(8, "black");
            numbertocolor.put(9, "red");
            numbertocolor.put(10, "black");
            numbertocolor.put(11, "black");
            numbertocolor.put(12, "red");
            numbertocolor.put(13, "black");
            numbertocolor.put(14, "red");
            numbertocolor.put(15, "black");
            numbertocolor.put(16, "red");
            numbertocolor.put(17, "black");
            numbertocolor.put(18, "red");
            numbertocolor.put(19, "red");
            numbertocolor.put(20, "black");
            numbertocolor.put(21, "red");
            numbertocolor.put(22, "black");
            numbertocolor.put(23, "red");
            numbertocolor.put(24, "black");
            numbertocolor.put(25, "red");
            numbertocolor.put(26, "black");
            numbertocolor.put(27, "red");
            numbertocolor.put(28, "black");
            numbertocolor.put(29, "black");
            numbertocolor.put(30, "red");
            numbertocolor.put(31, "black");
            numbertocolor.put(32, "red");
            numbertocolor.put(33, "black");
            numbertocolor.put(34, "red");
            numbertocolor.put(35, "black");
            numbertocolor.put(36, "red");
        }

        public int spinWheel () {
            int index = random.nextInt(numbers.size());
            return (int) numbers.get(index);
        }

        public String getColors(int number) {
         return (String) numbertocolor.getOrDefault(number, "unknown");
        }


}
