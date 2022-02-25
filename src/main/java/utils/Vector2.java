package utils;

public class Vector2 {
    public float x;
    public float y;

    public Vector2(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void set(Vector2 a) {
        this.x = a.x;
        this.y = a.y;
    }

    public Vector2 add(float x, float y) {
        return new Vector2(this.x + x, this.y + y);
    }

    public Vector2 add(Vector2 a) {
        this.x += a.x;
        this.y += a.y;
        return this;
    }

    public String asString() {
        return " (" + this.x + ", " + this.y + ") ";
    }

    public float magnitude() {
        return (float) Math.sqrt(this.x*this.x + this.y * this.y);
    }

    public Vector2 mult(float k) {
        this.x *= k;
        this.y += k;
        return this;
    }

    public Vector2 normalize() {
        float mod = (float) Exceptions.zeroException(this.magnitude());
        this.x/=mod;
        this.y/=mod;
        return this;
    }

    public Vector2 clear() {
        this.x = 0;
        this.y = 0;
        return this;
    }

    public static Vector2 sum(Vector2 a, Vector2 b) {
        return new Vector2(a.x + b.x, a.y + b.y);
    }

    public static Vector2 directionTo (Vector2 a, Vector2 b) {
        return new Vector2(b.x - a.x, b.y - a.y);
    }

    public static Vector2 normalize(Vector2 a) {
        float mod = (float) Exceptions.zeroException(a.magnitude());
        return new Vector2(a.x/mod, a.y/mod);
    }
}
