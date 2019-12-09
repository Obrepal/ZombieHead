package com.game.state;

import World.World;
import com.game.MAIN.Game;
import com.game.MAIN.Handler;
//import com.game.enitity.creature.Bullet;
import com.game.enitity.creature.Enemy;
import com.game.enitity.creature.Player;

import java.awt.Graphics;

public class GameState extends State {

   // private Player player;
    private World world;
   /* private Enemy enemy;
    private Enemy enemy1;
    private Enemy[] enemies = new Enemy[2];
    private Player player;
    */
   //private Bullet bullet;


    public GameState(Handler handler){
        super(handler);
        world = new World(handler,"res/textures/world1.txt");
        handler.setWorld(world);
        /*player = new Player(handler, handler.getWorld().getSpawnx(), handler.getWorld().getSpawny());
        enemy  = new Enemy(handler, 800,50);
        enemy1 = new Enemy(handler, 1000, 800);
        enemies[0] = enemy;
        enemies[1] = enemy1;*/
   //     bullet = new Bullet(100, 100);
    }


    @Override
    public  void tick(){
        world.tick();
      //  bullet.tick();
      /*  player.tick();
        enemy.tick();
        enemy1.tick();
     //   enemies[0].tick();
        System.out.println(" E!  " + enemy1.getXbound());
*/
    }

    @Override
    public void render (Graphics graphics){
        world.render(graphics);
        //bullet.render(graphics);
        /*enemy.render(graphics);
        enemy1.render(graphics);
        player.render(graphics);*/

        //Tile.tiles[2].render(graphics, 0,0);
    }

    /*public Enemy[] getEnemies() {
        return enemies;
    }*/
}
