package ru.jaba.lab;

public enum ActionType {
    GO("идти","идти", "идёт", "идут"),
    SKIP("не делать", "не", "не", "не"),
    REALIZE("осознать", "понять", "понял","поняли"),
    NOTICE("замечать","заметить","заметил","заметили"),
    SLEEP("спать","погрузиться в сон","погрузился в сон","погрузились в сон"),
    SEE("увидеть", "увидеть", "увидел", "увидели"),
    COMBINED("совместить действия","","", ""),
    POSSIBLE("возможно","можно","может","могут"),
    DISAPPEAR("исчезать","исчезнуть","исчез","исчезли"),
    THINK("размышлять","размышлять","размышлял","размышляли"),
    DEFINE("определить","быть", "- ", "- "),
    KNOW("знать","знать","узнал","узнали"),
    APPROACH("подступиться","подступиться","подступился","подступились"),
    LIFT("поднимать","поднимать","поднял","подняли"),
    PASS("передавать","передавать","передал","передал"),
    COLLAPSE("свернуть","свернуть","свернул","свернули"),
    BUILD("построить","построить","построил","построил"),
    FLY("полететь","полететь","полетел","полетели"),
    ACCELERATE("разогнать","разогнать","разогнал","разогнали"),
    OBLIGATE("приходится","приходится","вынужден","вынуждены"),
    TAKE("брать","брать","взял","взяли"),
    WILL("будет","будет","будет","будут"),
    NEED("иметь нужду","понадобится","понадобится","понядобятся"),
    BRING("взять","взять","взял","взял"),
    COMMIT("совершить","совершить","совершил","совершили"),
    GET_INTO("проникнуть","проникнуть","проник","проникли"),
    MEET("познакомиться","познакомиться","познакомился","познакомился"),
    TURN("перевернуть","перевернуть","перевернул","перевернул"),
    WEIGHT("весить","весить","весит","весят")

    ;
    private final String text, infinitive, personalSingle, personalPlural;
    ActionType(String text, String infinitive, String personalSingle, String personalPlural) {
        this.text = text;
        this.infinitive = infinitive;
        this.personalSingle = personalSingle;
        this.personalPlural = personalPlural;
    }

    public String getInfinitive() {return infinitive;}
    public String getSingleForm() {return personalSingle;}
    public String getPluralForm() {return personalPlural;}

    @Override
    public String toString() {
        return text;
    }
}
