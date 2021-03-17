package nl.hu.bep.example.fancyfishpro;

import nl.hu.bep.example.fancyfishpro.model.Inzet;
import nl.hu.bep.example.fancyfishpro.service.InzetService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InzetServiceUnitTest {
    @Autowired
    private InzetService inzetService;

    @Test
    public void checkForInitialData(){
        List<Inzet> inzetten = inzetService.list();
        Assert.assertEquals(inzetten.size(), 4);
    }

}
