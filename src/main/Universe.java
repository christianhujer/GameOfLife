import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import static java.util.Arrays.asList;
import static java.util.Collections.emptySet;
import static java.util.Collections.unmodifiableSet;

public class Universe {
    public static final Universe EMPTY = new Universe();
    private final Set<Point> points;

    private Universe() {
        points = emptySet();
    }

    private Universe(final Set<Point> points) {
        this.points = Collections.unmodifiableSet(points);
    }

    public Universe(final Point... points) {
        this.points = unmodifiableSet(new HashSet<>(asList(points)));
    }

    @Override public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Universe universe = (Universe) o;
        return Objects.equals(points, universe.points);
    }

    @Override public int hashCode() {
        return Objects.hash(points);
    }

    public Universe transit() {
        final Set<Point> pointsInNewGeneration = new HashSet<>();
        for (final Point point : getSetOfPointsToInspect()) {
            final int liveNeighbors = countLiveNeighbours(point);
            if (isAlive(point)) {
                switch (liveNeighbors) {
                case 2:
                case 3:
                    pointsInNewGeneration.add(point);
                }
            } else {
                switch (liveNeighbors) {
                case 3:
                    pointsInNewGeneration.add(point);
                }
            }
        }
        return new Universe(pointsInNewGeneration);
    }

    private int countLiveNeighbours(final Point point) {
        return (int) point
                .getSurroundingPoints()
                .stream()
                .filter(this::isAlive)
                .count();
    }

    private boolean isAlive(final Point point) {
        return points.contains(point);
    }

    @Override public String toString() {
        return "Universe{" +
                "points=" + points +
                '}';
    }

    public Set<Point> getSetOfPointsToInspect() {
        final Set<Point> pointsToInspect = new HashSet<>();
        for (final Point point : points) {
            pointsToInspect.add(point);
            pointsToInspect.addAll(point.getSurroundingPoints());
        }
        return unmodifiableSet(pointsToInspect);
    }
}
