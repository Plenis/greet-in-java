package net.greet;

public enum Language {
    IsiXhosa("Molo, "),
    English("Hello, "),
    Afrikaans("Gooi dag, "),
    Setswana("Dumela, ");


    private final String myLanguage;

    Language(String myLanguage){
        this.myLanguage = myLanguage;
    }

    public String getMyLanguage(){
        return this.myLanguage;
    }
}
