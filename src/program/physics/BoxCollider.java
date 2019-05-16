package program.physics;

import program.GameObject;
import program.Vector2D;

public class BoxCollider extends Rectangle {
    Vector2D anchor;

    public BoxCollider(GameObject object, int width, int height) {
        super(object.position, width, height);
        this.anchor = object.anchor;
    }

    public BoxCollider(Vector2D position, int width, int height, Vector2D anchor) {
        super(position,width,height);
        this.anchor = anchor;
    }

    @Override
    public double top() {
        return this.position.y - this.anchor.y * this.height;
    }

    @Override
    public double left() {
        return this.position.x - this.anchor.x * this.width;
    }

    public BoxCollider shift(double vx, double vy) {
        Vector2D newp = this.position.clone();
        newp.add(vx, vy);
        return new BoxCollider(newp, width, height, anchor);
    }
}
