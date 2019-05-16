package program.physics;

import program.Vector2D;

public class Rectangle {
    public Vector2D position;
    public int width;
    public int height;

    public Rectangle() {
        this(new Vector2D(0, 0), 1, 1);
    }

    public Rectangle(double x, double y, int width, int height) {
        this(new Vector2D(x, y), width, height);
    }

    public Rectangle(Vector2D position, int width, int height) {
        this.position = position;
        this.width = width;
        this.height = height;
    }

    public double top() {
        return this.position.y;
    }

    public double bot() {
        return this.top() + this.height;
    }

    public double left() {
        return this.position.x;
    }

    public double right() {
        return this.left() + this.width;
    }

    /**
     * return true if: this rectangle intersects with the other rectangle
     * else return false
     * @param other: the rectangle need to check intersects with this rectangle
     * @return
     */

    public boolean intersects(Rectangle other) {
        return this.right() >= other.left()
                && this.left() <= other.right()
                && this.top() <= other.bot()
                && this.bot() >= other.top();
    }


}
