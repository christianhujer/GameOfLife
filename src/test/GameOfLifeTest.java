import org.junit.Test;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class GameOfLifeTest {

    @Test
    public void twoEmptyUniversesEqual() {
        final Universe firstEmptyUniverse = Universe.EMPTY;
        final Universe secondEmptyUniverse = Universe.EMPTY;
        assertEquals(firstEmptyUniverse, secondEmptyUniverse);
    }

    @Test
    public void emptyAndNonEmptyUniverseAreNotEqual() {
        final Universe emptyUniverse = Universe.EMPTY;
        final Universe nonEmptyUniverse = new Universe(new Point(0, 0));
        assertNotEquals(emptyUniverse, nonEmptyUniverse);
    }

    @Test
    public void emptyUniverseTransitsToEmptyUniverse() {
        final Universe emptyUniverse = Universe.EMPTY;
        final Universe expectedUniverse = Universe.EMPTY;
        final Universe actualUniverse = emptyUniverse.transit();
        assertEquals(expectedUniverse, actualUniverse);
    }

    @Test
    public void singleCellTransitsToEmptyUniverse() {
        final Universe singleCellUniverse = new Universe(new Point(0, 0));
        final Universe expectedUniverse = Universe.EMPTY;
        final Universe actualUniverse = singleCellUniverse.transit();
        assertEquals(expectedUniverse, actualUniverse);
    }

    @Test
    public void blinkerSequence() {
        final Universe verticalBlinker = new Universe(new Point(1, 0), new Point(1, 1), new Point(1, 2));
        final Universe horizontalBlinker = new Universe(new Point(0, 1), new Point(1, 1), new Point(2, 1));
        assertEquals(horizontalBlinker, verticalBlinker.transit());
        assertEquals(verticalBlinker, horizontalBlinker.transit());
    }

    @Test
    public void block() {
        final Universe block = new Universe(new Point(0, 0), new Point(0, 1), new Point(1, 0), new Point(1, 1));
        assertEquals(block, block.transit());
    }

    @Test
    public void getSetOfPointsToInspectFromEmptyUniverse() {
        final Universe emptyUniverse = Universe.EMPTY;
        final Set<Point> expectedSetOfPointsToInspect = Collections.emptySet();
        final Set<Point> actualSetOfPointsToInspect = emptyUniverse.getSetOfPointsToInspect();
        assertEquals(expectedSetOfPointsToInspect, actualSetOfPointsToInspect);
    }

    @Test
    public void getSetOfPointsToInspectFromSingleCellUniverse() {
        final Universe emptyUniverse = new Universe(new Point(0, 0));
        final Set<Point> expectedSetOfPointsToInspect = new HashSet<>(
                asList(new Point(-1, -1), new Point(0, -1), new Point(1, -1), new Point(-1, 0), new Point(0, 0),
                        new Point(1, 0), new Point(-1, 1), new Point(0, 1), new Point(1, 1)));
        final Set<Point> actualSetOfPointsToInspect = emptyUniverse.getSetOfPointsToInspect();
        assertEquals(expectedSetOfPointsToInspect, actualSetOfPointsToInspect);
    }
}
