import Service.PratosService;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestePratos {
    PratosService pratosService = new PratosService();

    @Test
    public void listaPratosNaoVazia(){
        assertTrue(pratosService.getPratos().size() >= 1);
    }
}
