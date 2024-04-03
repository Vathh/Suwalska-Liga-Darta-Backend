package pl.liga.domain;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;
import lombok.With;

@Value
@Builder
@With
@EqualsAndHashCode(of = {"schemaMatchId", "size", "markup"})
public class SchemaMatch {

    Integer schemaMatchId;
    Integer size;
    Integer playerANumber;
    Integer playerBNumber;
    String markup;
    String winnerDestinationMarkup;
    String loserDestinationMarkup;
    Integer points;
}
