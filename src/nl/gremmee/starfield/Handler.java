package nl.gremmee.starfield;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {
    LinkedList<Star> object = new LinkedList<>();

    public void addObject(Star aObject) {
        this.object.add(aObject);
    }

    public Star getGameObject(Star aObject) {
        int index = this.object.indexOf(aObject);
        if (index != -1) {
            return this.object.get(index);
        }
        return null;
    }

    public int getStars() {
        int result = 0;
        for (Star fireObject : object) {
            if (fireObject instanceof Star) {
                result++;
            }
        }
        return result;
    }

    public void removeObject(Star aObject) {
        this.object.remove(aObject);
    }

    public void render(Graphics aGraphics) {
        for (int i = 0; i < object.size(); i++) {
            Star tempObject = object.get(i);
            tempObject.render(aGraphics);
        }
    }

    public void update() {
        for (int i = 0; i < object.size(); i++) {
            Star tempObject = object.get(i);
            tempObject.update();
        }
    }
}
