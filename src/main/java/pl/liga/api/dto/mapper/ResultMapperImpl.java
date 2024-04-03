package pl.liga.api.dto.mapper;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pl.liga.api.dto.ResultDTO;
import pl.liga.domain.Result;

@Component
@AllArgsConstructor
public class ResultMapperImpl {

    public ResultDTO map(Result result){
        return ResultDTO.builder()
                .pointsEarned(result.getPointsEarned())
                .playerName(result.getPlayer().getName())
                .build();
    }
}
