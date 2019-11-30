package com.game.enitity.creature;

import com.game.MAIN.Handler;
import com.game.gfx.Assets;
import com.game.enitity.Entity;

import java.awt.*;


public class Player extends Creature {

    private static float z;
    private static float t;

    private boolean attacking = false;
    private long lastAttackTimer, attackCooldown = 800, attackTimer = attackCooldown;
    private Rectangle attackRect = new Rectangle();




    public Player(Handler handler, float x, float y) {
        super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);

        bounds.x= 16; //coordinate of player
        bounds.y = 32;
        bounds.width = 32;
        bounds. height = 32;
    }

        @Override
        public void tick(){

            //Movement
            getInput();
            move();
            handler.getGameCamera().centeronEntity(this);
            // Attack
            checkAttacks();
        }

        private void checkAttacks( ) {

            Rectangle collisonRect = getCollisionBounds(0, 0);
            attackTimer += System.currentTimeMillis() - lastAttackTimer;
            lastAttackTimer = System.currentTimeMillis();
            if(attackTimer > 300){
                attacking = false;
            }
            if(attackTimer < attackCooldown) {
                return;
            }

            int arSize = 64;
            attackRect.width = arSize;
            attackRect.height = arSize;
            if (handler.getKeyManeger().attack) {
                attackRect.x = collisonRect.x - arSize/4;                                      // collisonRect.width / 2 - arSize / 2;
                attackRect.y = collisonRect.y - arSize/4;
            } else return;

            attacking = true;
            attackTimer = 0;

            for (int i = 0; i < 2; ++i){
                for (Entity e : handler.getWorld().getEntityManager().getEntities()) {
                if (e.equals(this))
                    continue;

                if (e.getCollisionBounds(0, 0).intersects(attackRect)) {
                    e.hurt(1);
                    }
                }
                return;
            }
        }

        @Override
        public void die(){
        System.out.println(" You lose ");
        }

        private void getInput(){
            xMove = 0;
            yMove = 0;

            if(handler.getKeyManeger().up)
                yMove = -2*speed;
            if(handler.getKeyManeger().down)
                yMove = 2*speed;
            if(handler.getKeyManeger().left)
                xMove = -2*speed;
            if(handler.getKeyManeger().right)
                xMove = 2*speed;
        }

        @Override
        public  void render(Graphics graphics){
        graphics.drawImage(Assets.player, (int) (x - handler.getGameCamera().getxOffset()),
                (int) (y-handler.getGameCamera().getyOffset()) , width, height, null);
            graphics.setColor(Color.RED);
            graphics.fillRect((int)(x + bounds.x-handler.getGameCamera().getxOffset()),
                              (int)(y + bounds.y-handler.getGameCamera().getyOffset()),
                                    bounds.width,bounds.height);
            if(attacking) {
                graphics.setColor(Color.GREEN);
                graphics.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()),
                        (int) (y + bounds.y - handler.getGameCamera().getyOffset()),
                        bounds.width, bounds.height);
            }



            graphics.setFont(new Font("TimesRomna",Font.PLAIN, 10));
            graphics.drawString( Float.toString(x) ,5, 10);
            graphics.drawString( Float.toString(y) ,5, 20);

            //Attack area
            z = x;
            t = y;

    }

    static float getXP(){
        return z;
    }
    static float getYP(){
        return t;
    }
}
