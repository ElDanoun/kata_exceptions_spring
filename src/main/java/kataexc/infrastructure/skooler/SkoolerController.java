package kataexc.infrastructure.skooler;

import kataexc.domain.Skooler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/skoolers")
public class SkoolerController {

    private static final Logger logger = LoggerFactory.getLogger(SkoolerController.class);

    @Autowired
    private SkoolerRepository skoolerRepository;

    @GetMapping(value = "", produces = "application/json")
    public List<Skooler> getAllSkoolers(){
        return skoolerRepository.getAllSkoolers();
    }

    @GetMapping(value = "/{polygram}", produces = "application/json")
    public Skooler getSkooler(@PathVariable String polygram) throws SkoolerNotFoundException {
        return skoolerRepository.getSkoolerByPolygram(polygram);
    }

}
