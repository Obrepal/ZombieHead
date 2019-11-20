package com.game.state;



import com.game.MAIN.Game;
import com.game.MAIN.Handler;

import java.awt.*;

public abstract class State {

        private static State currentState = null;

        public static void setState(State state){
            currentState = state;
        }

        public static  State getState(){
            return currentState;
        }


    // class
    protected Handler handler;

      public State(Handler handler){
          this.handler = handler;
      }

    public abstract void tick();

    public abstract void render (Graphics graphics);// we pass paintbrush







}

