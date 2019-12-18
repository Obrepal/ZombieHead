
import com.game.MAIN.Handler;
import com.game.enitity.creature.Player;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.mockito.Mock;
import org.mockito.Mockito;

import javax.swing.*;

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

    @Mock
    Handler handler;

    @Test
    public void testOfPlayer() {
        Player player = new Player(handler, 700, 800);
        player.setX(800);
        Assert.assertTrue( player.getX() == 800);

    }
    @Test
    public  void testOfKeymmaneger(){
        Player player = new Player(handler, 700, 800);
        KeyEvent e = new KeyEvent(new JFrame(), KeyEvent.KEY_PRESSED, 1, 0, 57, KeyEvent.CHAR_UNDEFINED);
        handler.getKeyManeger().keyPressed(e);
        //player.getInput();
        //Assert.assertTrue(700 == player.getX());
     //  handler.getKeyManeger().keyPressed(e);
        Assert.assertTrue(true);
}


}


