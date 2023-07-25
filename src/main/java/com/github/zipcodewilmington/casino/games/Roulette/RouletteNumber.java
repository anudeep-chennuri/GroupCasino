package com.github.zipcodewilmington.casino.games.Roulette;

public enum RouletteNumber {
                ZERO(0, RouletteBoard.GREEN, RouletteBoard.EVEN),
                ONE(1, RouletteBoard.RED, RouletteBoard.ODD),
                TWO(2, RouletteBoard.BLACK, RouletteBoard.EVEN),
                THREE(3, RouletteBoard.RED, RouletteBoard.ODD),
                FOUR(4, RouletteBoard.BLACK, RouletteBoard.EVEN),
                FIVE(5, RouletteBoard.RED, RouletteBoard.ODD),
                SIX(6, RouletteBoard.BLACK, RouletteBoard.EVEN),
                SEVEN(7, RouletteBoard.RED, RouletteBoard.ODD),
                EIGHT(8, RouletteBoard.BLACK, RouletteBoard.EVEN),
                NINE(9, RouletteBoard.RED, RouletteBoard.ODD),
                TEN(10, RouletteBoard.BLACK, RouletteBoard.EVEN),
                ELEVEN(11, RouletteBoard.RED, RouletteBoard.ODD),
                TWELVE(12, RouletteBoard.BLACK, RouletteBoard.EVEN),
                THIRTEEN(13, RouletteBoard.RED, RouletteBoard.ODD),
                FOURTEEN(14, RouletteBoard.BLACK, RouletteBoard.EVEN),
                FIFTEEN(15, RouletteBoard.RED, RouletteBoard.ODD),
                SIXTEEN(16, RouletteBoard.BLACK, RouletteBoard.EVEN),
                SEVENTEEN(17, RouletteBoard.RED, RouletteBoard.ODD),
                EIGHTEEN(18, RouletteBoard.BLACK, RouletteBoard.EVEN),
                NINETEEN(19, RouletteBoard.RED, RouletteBoard.ODD),
                TWENTY(20, RouletteBoard.BLACK, RouletteBoard.EVEN),
                TWENTYONE(21, RouletteBoard.RED, RouletteBoard.ODD),
                TWNETYTWO(22, RouletteBoard.BLACK, RouletteBoard.EVEN),
                TWENTYTHREE(23, RouletteBoard.BLACK, RouletteBoard.ODD),
                TWENTYFOUR(24, RouletteBoard.RED, RouletteBoard.EVEN),
                TWENTYFIVE(25, RouletteBoard.RED, RouletteBoard.ODD),
                TWENTYSIX(26, RouletteBoard.BLACK, RouletteBoard.EVEN),
                TWENTYSEVEN(27, RouletteBoard.RED, RouletteBoard.ODD),
                TWENTYEIGHT(28, RouletteBoard.BLACK, RouletteBoard.EVEN),
                TWENTYNINE(29, RouletteBoard.RED, RouletteBoard.ODD),
                THIRTY(30, RouletteBoard.BLACK, RouletteBoard.EVEN),
                THIRTYONE(31, RouletteBoard.RED, RouletteBoard.ODD),
                THIRTYTWO(32, RouletteBoard.BLACK, RouletteBoard.EVEN),
                THIRTYTHREE(33, RouletteBoard.RED, RouletteBoard.ODD),
                THIRTYFOUR(34, RouletteBoard.BLACK, RouletteBoard.EVEN),
                THIRTYFIVE(35, RouletteBoard.RED, RouletteBoard.ODD),
                THIRTYSIX(36, RouletteBoard.BLACK, RouletteBoard.EVEN);

    private final int numberValue;
    private final RouletteBoard color;
    private final RouletteBoard oddOrEven;

    RouletteNumber(int numberValue, RouletteBoard color, RouletteBoard oddOrEven) {
        this.numberValue = numberValue;
        this.color = color;
        this.oddOrEven = oddOrEven;

    }
    public int getNumberValue() {
        return numberValue;
    }

    public RouletteBoard getColor() {
        return color;
    }

    public RouletteBoard getOddOrEven() {
        return oddOrEven;
    }
}
