package kataexc.infrastructure.skooler;

import kataexc.KataexcApp;
import kataexc.domain.Skooler;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import sun.security.krb5.internal.rcache.AuthTimeWithHash;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = KataexcApp.class)
@WebAppConfiguration
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
public class SkoolerRepositoryTest {

    @Autowired
    private SkoolerRepository tested;

    @Test
    public void getAllSkoolersShouldReturnAllSkoolers() {
        //given dirty context clean-up
        //when
        List<Skooler> result = tested.getAllSkoolers();
        //then
        assertThat(result.size(), is(1));
    }

    @Test
    public void getSkoolerByPolygramShouldReturnCorrespondingSkooler()  {
        //given dirty context clean-up
        //when
        Skooler result = tested.getSkoolerByPolygram("QUEN");
        //then
        assertThat(result.getFirstName(), is("Quentin"));
    }

    @Test(expected = SkoolerNotFoundException.class)
    public void getSkoolerByPolygramShouldThrowSkoolerNotFoundWhenNotFOund()  {
        //given

        //when
        Skooler result = tested.getSkoolerByPolygram("khsgergerhehfkhf");
    }
}