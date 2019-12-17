
import com.game.MAIN.Handler;
import com.game.enitity.creature.Player;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;


import java.awt.event.KeyEvent;


public class MyfirstZOMBIEHEADTESTS {

    @Test
    public void testOfPlayerExistence() {
        try {
            Class.forName("com.game.enitity.creature.Player");
        } catch (ClassNotFoundException e) {
            Assert.fail("should have a class called Player");
        }
    }

    @Test
    public void testOfEnemyExistence(){
        try {
            Class.forName("com.game.enitity.creature.Enemy");
        } catch (ClassNotFoundException e){
            Assert.fail("should have a class called Enemy");
        }
    }

    @Test
    public void testOfWorldExistence(){
        try {
            Class.forName("World.World");
        } catch (ClassNotFoundException e){
            Assert.fail("should have a class called World");
        }
    }




    /* Handler handler1 = mock(Handler.class);
    @Mock
    Handler handler;

    @Test
    public void testOfPlayer() {
        Player player = new Player(handler, 700, 800);
    }*/




   /* @Test
    public void firstTest() {
        Assert.assertTrue(true);
    }



    protected int value1, value2;
    @Test
    public void testAdd(){
        value1 = 3;
        value2 = 3;
        double result = value1 + value2;
        Assert.assertTrue(result == 5);
    }*/


}


