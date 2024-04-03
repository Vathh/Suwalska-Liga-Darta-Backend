package pl.liga.business.dao;

import pl.liga.domain.Result;

import java.util.List;

public interface ResultDAO {

    List<Result> findAll();

    void savePresences(List<Result> results);

}
