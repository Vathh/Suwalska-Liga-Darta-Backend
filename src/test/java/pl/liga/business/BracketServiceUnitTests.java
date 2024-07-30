package pl.liga.business;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.liga.domain.Match;
import pl.liga.util.DomainFixtures;

@ExtendWith(MockitoExtension.class)
public class BracketServiceUnitTests {

    @Mock
    private SchemaService schemaService;

    @InjectMocks
    private BracketService bracketService;

    @Test
    void thatMovingWinnerToNextMatchWorksCorrectly(){
        //given
        Match match = DomainFixtures.someMatch1();


        //when

        //then
    }
}
