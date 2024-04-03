package pl.liga.business;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.liga.business.dao.SchemaMatchDAO;
import pl.liga.domain.SchemaMatch;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class SchemaService {

    private final SchemaMatchDAO schemaMatchDAO;

    @Transactional
    public List<SchemaMatch> getSchemaMatches(Integer playersCount){
        int size = 0;
        if(playersCount > 32 && playersCount <= 48){
            size = 48;
        } else if (playersCount <= 32 && playersCount > 16) {
            size = 32;
        } else if (playersCount <= 16 && playersCount > 8) {
            size = 16;
        }else {
            size = 8;
        }
        return schemaMatchDAO.findSchemaMatches(size);
    }
}
