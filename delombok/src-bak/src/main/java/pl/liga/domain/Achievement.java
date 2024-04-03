package pl.liga.domain;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;
import lombok.With;

@Value
@Builder
@With
@EqualsAndHashCode(of = "hfId")
public class Achievement {

    public static String MAX = "MAX";
    public static String ONESEVENTY = "170PLUS";
    public static String HF = "HF";
    public static String QF = "QF";

    Integer hfId;
    Player player;
    Tournament tournament;
    Integer value;
}
