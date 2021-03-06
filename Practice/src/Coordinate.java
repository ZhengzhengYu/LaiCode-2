public class Coordinate {
    int x;
    int y;
    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
    @Override
    public String toString() {
        return ( x + "," + y);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Coordinate)) {
            return false;
        }
        Coordinate another = (Coordinate) obj;
        return this.x == another.x && this.y == another.y;
    }

    @Override
    public int hashCode() {
        return x * 101 + y;
    }
}
