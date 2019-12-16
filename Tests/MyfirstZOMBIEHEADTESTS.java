
import com.game.MAIN.Handler;
import com.game.enitity.creature.Player;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.mockito.Mockito;

import static org.mockito.Mockito.*


import java.awt.event.KeyEvent;


public class MyfirstZOMBIEHEADTESTS {
    Handler handler =mock(Handler.class);
    Player player = new Player(handler, 700, 800);



    @Test
    public void firstTest() {
        Assert.assertTrue(true);
    }

    /*@Test
    public void testCollision(){

    }
    @Test
   public void testKeyListener(){
        Handler handler;
        Player player = new Player(handler  ,100, 200);
        KeyEvent e = new KeyEvent()




    }*/



    protected int value1, value2;
    @Test
    public void testAdd(){
        value1 = 3;
        value2 = 3;
        double result = value1 + value2;
        Assert.assertTrue(result == 5);
    }


}

*/
