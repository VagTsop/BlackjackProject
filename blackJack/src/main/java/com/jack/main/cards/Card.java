package com.jack.main.cards;

public class Card {

    private Value value;
    private Kind kind;
    private String image;

    public Card(Value value, Kind kind) {
        this.value = value;
        this.kind = kind;

    }

    public int getValue() {
        return value.getValue();
    }

    private String getStringForImage() {
        if (value.equals(Value.ACE) || value.equals(Value.JACK)) {
            return value.toString().charAt(0) + "" + kind.toString().charAt(0);
        } else if (value.equals(Value.KING) || value.equals(Value.QUEEN)) {
            return value.toString().charAt(0) + "" + kind.toString().charAt(0);
        } else {
            return String.valueOf(value.getValue()) + kind.toString().charAt(0);
        }

    }

    public String getImage() {
        return "https://deckofcardsapi.com/static/img/" + getStringForImage() + ".png";
    }
}
