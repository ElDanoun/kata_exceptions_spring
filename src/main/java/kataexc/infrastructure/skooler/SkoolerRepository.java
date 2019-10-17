package kataexc.infrastructure.skooler;

import kataexc.domain.Skooler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SkoolerRepository {

    @Autowired
    JdbcTemplate jdbc;

    public List<Skooler> getAllSkoolers(){
        return jdbc.query("SELECT * FROM skoolers", new BeanPropertyRowMapper(Skooler.class));
    }

    public Skooler getSkoolerByPolygram(String polygram) {
        try {
            return (Skooler) jdbc.queryForObject("select * from Skoolers where polygram like ?",
                    new String[]{polygram},
                    new BeanPropertyRowMapper(Skooler.class));
        }
        catch (EmptyResultDataAccessException exc){
            throw new SkoolerNotFoundException(polygram);
        }
    }
}
