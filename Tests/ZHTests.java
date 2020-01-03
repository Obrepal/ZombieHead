
import com.game.MAIN.Handler;
import com.game.display.Display;
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





public class ZHTests {

    @Test
    public  void testOfKeyManager() {
        KeyManager keyManager = new KeyManager();
        KeyEvent f = new KeyEvent(new JFrame(), KeyEvent.KEY_PRESSED, 1, 0, 70, KeyEvent.CHAR_UNDEFINED);
        keyManager.keyPressed(f);
        keyManager.tick();
        Assert.assertTrue(keyManager.isFire());

        KeyEvent w = new KeyEvent(new JFrame(), KeyEvent.KEY_PRESSED, 1, 0, 87, KeyEvent.CHAR_UNDEFINED);
        keyManager.keyPressed(w);
        keyManager.tick();
        Assert.assertTrue(keyManager.isUp());

        KeyEvent s = new KeyEvent(new JFrame(), KeyEvent.KEY_PRESSED, 1, 0, 83, KeyEvent.CHAR_UNDEFINED);
        keyManager.keyPressed(s);
        keyManager.tick();
        Assert.assertTrue(keyManager.isDown());

        KeyEvent a = new KeyEvent(new JFrame(), KeyEvent.KEY_PRESSED, 1, 0, 65, KeyEvent.CHAR_UNDEFINED);
        keyManager.keyPressed(a);
        keyManager.tick();
        Assert.assertTrue(keyManager.isLeft());

        KeyEvent d = new KeyEvent(new JFrame(), KeyEvent.KEY_PRESSED, 1, 0, 68, KeyEvent.CHAR_UNDEFINED);
        keyManager.keyPressed(d);
        keyManager.tick();
        Assert.assertTrue(keyManager.isRight());

        KeyEvent space = new KeyEvent(new JFrame(), KeyEvent.KEY_PRESSED, 1, 0, 32, KeyEvent.CHAR_UNDEFINED);
        keyManager.keyPressed(space);
        keyManager.tick();
        Assert.assertTrue(keyManager.isAttack());
    }

    @Test
    public void testOfDisplay(){
        Display display = new Display( "test", 100, 100);
        Assert.assertNotNull(display.getCanvas());
        Assert.assertNotNull(display.getFrame());
    }

}

