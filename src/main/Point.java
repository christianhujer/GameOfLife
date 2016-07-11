import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import static java.util.Arrays.asList;
import static java.util.Collections.unmodifiableSet;

public class Point {
    private final int x;
    private final int y;

    public Point(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    @Override public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x &&
                y == point.y;
    }

    @Override public String toString() {
        return "(" + x + ',' + y + ')';
    }

    @Override public int hashCode() {
        return Objects.hash(x, y);
    }

    public Point offset(final int dx, final int dy) {
        return new Point(x + dx, y + dy);
    }

    public Set<Point> getSurroundingPoints() {
        return unmodifiableSet(new HashSet<>(asList(
                offset(-1, -1),
                offset(-1, 0),
                offset(-1, 1),
                offset(0, -1),
                offset(0, 1),
                offset(1, -1),
                offset(1, 0),
                offset(1, 1)
        )));
    }
}
