package com.game.Entity.Creatures;

import com.game.Bridge.Handler;
import com.game.Graphics.Assets;
import com.game.Entity.Entity;

//import com.game.Entity.Creatures.RailGun;


import java.awt.*;


public class Player extends Creature {

    private static float z;
    private static float t;

    private boolean attacking = false;
    private boolean firing = false;
    private long lastAttackTimer, attackCooldown, fireCooldown, lastFireTimer = 800, attackTimer = attackCooldown, fireTimer = fireCooldown;
    private Rectangle attackRect = new Rectangle();
    private Rectangle fireRect = new Rectangle();


    public Player(Handler handler, float x, float y) {
        super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);

        bounds.x = 16; //coordinate of player
        bounds.y = 32;
        bounds.width = 32;
        bounds.height = 32;
    }

    @Override
    public void tick() {
        //Movement
        getInput();
        move();
        handler.getGameCamera().centeronEntity(this);
        // Attack
        checkAttacks();
        checkFire();
    }

    private void checkAttacks() {

        Rectangle collisonRect = getCollisionBounds(0, 0);
        attackTimer += System.currentTimeMillis() - lastAttackTimer;
        lastAttackTimer = System.currentTimeMillis();
        if (attackTimer > 300) {
            attacking = false;
        }
        if (attackTimer < attackCooldown) {
            return;
        }

        int arSize = 64;
        attackRect.width = arSize;
        attackRect.height = arSize;
        if (handler.getKeyManeger().isAttack()) {
            attackRect.x = collisonRect.x - arSize / 4;                                      // collisonRect.width / 2 - arSize / 2;
            attackRect.y = collisonRect.y - arSize / 4;
        } else return;

        attacking = true;
        attackTimer = 0;

        for (int i = 0; i < 2; ++i) {
            for (Entity e : handler.getWorld().getEntityManager().getEntities()) {
                if (e.equals(this))
                    continue;

                if (e.getCollisionBounds(0, 0).intersects(attackRect)) {
                    e.hurt(1);
                }
            }

        }
    }

    private void checkFire() {
        Rectangle collisonRect = getCollisionBounds(0, 0);
        fireTimer += System.currentTimeMillis() - lastFireTimer;
        lastFireTimer = System.currentTimeMillis();

        if (fireTimer > 300) {
            firing = false;
        }

        if (fireTimer < fireCooldown) {
            return;
        }

        if (handler.getKeyManeger().isFire()) {

            if (yMove < 0) {
                fireRect.width = 2;
                fireRect.height = 100;
                fireRect.x = collisonRect.x + 16;
                fireRect.y = collisonRect.y - 84;

            }
            if (yMove > 0) {
                fireRect.width = 2;
                fireRect.height = 100;
                fireRect.x = collisonRect.x + 16;
                fireRect.y = collisonRect.y + 16;
            }
            if (xMove < 0) {
                fireRect.width = 100;
                fireRect.height = 2;
                fireRect.x = collisonRect.x - 80;
                fireRect.y = collisonRect.y + 16;

            }
            if (xMove > 0) {
                fireRect.width = 100;
                fireRect.height = 2;
                fireRect.x = collisonRect.x + 16;
                fireRect.y = collisonRect.y + 16;
            }
            firing = true;

        } else return;

        for (int i = 0; i < 2; ++i) {
            for (Entity e : handler.getWorld().getEntityManager().getEntities()) {
                if (e.equals(this))
                    continue;

                if (e.getCollisionBounds(0, 0).intersects(fireRect)) {
                    e.hurt(1);
                }
            }

        }

    }


    @Override
    public void render(Graphics graphics) {

        graphics.drawImage(Assets.player, (int) (x - handler.getGameCamera().getxOffset()),
                (int) (y - handler.getGameCamera().getyOffset()), width, height, null);

        graphics.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()),
                (int) (y + bounds.y - handler.getGameCamera().getyOffset()),
                bounds.width, bounds.height);
        if (attacking) {
            graphics.setColor(Color.GREEN);
            graphics.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()),
                    (int) (y + bounds.y - handler.getGameCamera().getyOffset()),
                    bounds.width, bounds.height);

        }
        if (firing) {
            graphics.setColor(Color.MAGENTA);
            if ((yMove < 0 || yMove > 0) && xMove >= 0 && xMove <= 0) {
                graphics.fillRect((int) (fireRect.x - handler.getGameCamera().getxOffset()), (int) (fireRect.y - handler.getGameCamera().getyOffset()), fireRect.width, fireRect.height);
            }
            if ((xMove < 0 || xMove > 0) && yMove >= 0 && yMove <= 0) {
                graphics.fillRect((int) (fireRect.x - handler.getGameCamera().getxOffset()), (int) (fireRect.y - handler.getGameCamera().getyOffset()), fireRect.width, fireRect.height);
            }
        }

        //graphics.fillRect((int)(x + DEFAULT_CREATURE_HEIGHT /4+ bounds.x-handler.getGameCamera().getxOffset()),(int) (y + DEFAULT_CREATURE_WIDTH/4+ bounds.y - handler.getGameCamera().getyOffset()), fireRect.width ,fireRect.height);


        graphics.setFont(new Font("TimesRoman", Font.PLAIN, 10));
        graphics.drawString(Float.toString(x), 5, 10);
        graphics.drawString(Float.toString(y), 5, 20);

        //Attack area
        z = x;
        t = y;

    }

    @Override
    public void die() {
        System.out.println(" You lose ");
    }

    @Override
    public void getInput() {
        xMove = 0;
        yMove = 0;

        if (handler.getKeyManeger().isUp())
            yMove = -2 * speed;
        if (handler.getKeyManeger().isDown())
            yMove = 2 * speed;
        if (handler.getKeyManeger().isLeft())
            xMove = -2 * speed;
        if (handler.getKeyManeger().isRight())
            xMove = 2 * speed;
    }


    static float getXP() {
        return z;
    }

    static float getYP() {
        return t;
    }

    public float getYMove() {
        return yMove;
    }
}
