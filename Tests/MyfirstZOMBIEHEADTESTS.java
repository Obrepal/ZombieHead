
import com.game.MAIN.Handler;
import com.game.enitity.creature.Player;
import input.KeyManager;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import java.awt.event.KeyEvent;


import javax.swing.*;

import static org.mockito.Mockito.*;


import java.awt.event.KeyEvent;


public class MyfirstZOMBIEHEADTESTS {

  /*  @Test
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
    }*/

    @Test
    public  void testOfKeyManager(){
        KeyManager keyManager = new KeyManager();
        KeyEvent e = new KeyEvent(new JFrame(), KeyEvent.KEY_PRESSED, 1, 0, 70, KeyEvent.CHAR_UNDEFINED);
        keyManager.keyPressed(e);
        System.out.println(e +" ");
        System.out.println(keyManager.getFire());
       // Assert.assertTrue (keyManager.getKeys1(70));
        Assert.assertTrue(keyManager.getFire());

    }

}

//java.awt.event.KeyEvent[KEY_PRESSED,keyCode=70,keyText=F,keyChar=Undefined keyChar,keyLocation=KEY_LOCATION_UNKNOWN,rawCode=0,primaryLevelUnicode=0,scancode=0,extendedKeyCode=0x0] on frame0
//false


