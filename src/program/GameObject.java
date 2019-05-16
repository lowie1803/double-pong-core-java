package program;

import program.ball.Ball;
import program.goal.Goal;
import program.physics.BoxCollider;
import program.player.Player;
import program.player.Score;
import program.renderer.Renderer;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GameObject {
    // static ~ quan li doi tuong
    public Renderer renderer;
    public Vector2D position;
    public Vector2D velocity;

    public BoxCollider hitBox; // = null
    public Vector2D anchor;
    public static ArrayList<GameObject> objects = new ArrayList<>();

    public static ArrayList<GameObject> topLayer = new ArrayList<>();
    public static ArrayList<GameObject> midLayer = new ArrayList<>();
    public static ArrayList<GameObject> botLayer = new ArrayList<>();
//    public static Vector2D defaultPosition;


    public boolean active;

    public static int scoreLeft;
    public static int scoreRight;
//

    public GameObject() {
        objects.add(this);
        position = new Vector2D();
        velocity = new Vector2D();

        anchor = new Vector2D(0.5, 0.5);
        active=true;
        scoreLeft=0;
        scoreRight=0;
//        defaultPosition.set(0, 0);

    }

    public static <E extends GameObject> E findIntersects(Class<E> cls, BoxCollider hitBox) {
        for (int i = 0; i < objects.size(); i++) {
            GameObject object = objects.get(i);
            if( cls.isAssignableFrom(object.getClass())
                && object.hitBox != null
                && object.hitBox.intersects(hitBox)) {
                return (E) object;
            }
        }
        return null;
    }

    public static <E extends GameObject> E recycle(Class<E> cls) {
        // E ~ Player / Background
        // cls ~ Player.class / Background.class
        // 1. Tim 1 doi tuong da deactive > reset > return
        E object = findDeactive(cls);
        if(object != null) {
            object.reset();
            return object;
        }
        // 2. Neu ko tim duoc > khoi tao > return
        try {
            object = cls.getConstructor().newInstance();
            return object;
        } catch(Exception ex) {
            return null;
        }
    }

    public static <E extends GameObject> E findDeactive(Class<E> cls) {
        for (int i = 0; i < objects.size(); i++) {
            GameObject object = objects.get(i);
            if(!object.active
                    && object.getClass().isAssignableFrom(cls)) {
                return (E)object;
            }
        }
        return null;
    }

    public void deactive() {
        active = false;
    }

    public void reset() {
        active = true;
    }

    public void render(Graphics g) {
        if(renderer != null&&active==true ) {
            renderer.render(g, this);
//            if (this.getClass()== Player.class || this.getClass()== Ball.class || this.getClass() == Goal.class){
//                g.drawRect((int)this.position.x-hitBox.width/2, (int)this.position.y-hitBox.height/2, hitBox.width, hitBox.height);
//            }
        }



    }

    public void run() {
        position.add(velocity);
    }

//    public static<E extends GameObject> void clearAll(Class<E> cls){
//        for (int i = 0; i < objects.size(); i++) {
//            GameObject object = objects.get(i);
//            if(object.active
//                    && object.getClass().isAssignableFrom(cls)) {
//                object.deactive();
//            }
//        }
//    }
    public static void clearAll() {
        objects.clear();
        botLayer.clear();
        midLayer.clear();
        topLayer.clear();
    }

    public static void clear(){
        for (int i = 0; i < objects.size(); i++) {
            GameObject object = objects.get(i);

                object.deactive();

        }
    }



//    public void resetPosition()
//    {
//        position=defaultPosition.clone();
//    }



}
