package nl.gremmee.starfield;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

public class Star {
    float pz;
    float x;
    float y;
    float z;
    private ID id;
    private int color;
    private int speed;
    private Random random = new Random();

    public Star(ID aId) {
        x = Utils.getRandomFloat(-Starfield.WIDTH, Starfield.WIDTH);
        y = Utils.getRandomFloat(-Starfield.HEIGHT, Starfield.HEIGHT);
        z = getRandom().nextInt(Starfield.WIDTH);

        pz = z;
    }

    public void doRender(Graphics aGraphics) {
        color = Window.getMouseY();
        float c = Utils.map(color, 0, Starfield.HEIGHT, 64, 255);
        aGraphics.setColor(new Color((int) c, (int) c, (int) c));

        int offsetx = 0;
        int offsety = 0;

        float sx = Utils.map(x / z, 0, 1, 0, Starfield.WIDTH);
        float sy = Utils.map(y / z, 0, 1, 0, Starfield.HEIGHT);

        float px = Utils.map(x / pz, 0, 1, 0, Starfield.WIDTH);
        float py = Utils.map(y / pz, 0, 1, 0, Starfield.HEIGHT);

        pz = z;

        Graphics2D g2 = (Graphics2D) aGraphics;
        g2.setStroke(new BasicStroke(3));
        g2.drawLine((int) px + offsetx, (int) py + offsety, (int) sx + offsetx, (int) sy + offsety);
    }

    public void doUpdate() {
        speed = Window.getMouseX();
        float s = Utils.map(speed, 0, Starfield.WIDTH, 3, 50);
        z = z - s;
        if (z < 1) {
            z = Starfield.WIDTH;
            x = Utils.getRandomFloat(-Starfield.WIDTH, Starfield.WIDTH);
            y = Utils.getRandomFloat(-Starfield.HEIGHT, Starfield.HEIGHT);

            pz = z;
        }
    }

    public ID getID() {
        return this.id;
    }

    public Random getRandom() {
        return this.random;
    }

    public void render(Graphics aGraphics) {
        doRender(aGraphics);
    }

    public void setId(ID aId) {
        this.id = aId;
    }

    public void update() {
        doUpdate();
    }
}
