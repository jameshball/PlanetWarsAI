package sh.ball.planetwars.galaxy;

import java.util.Objects;
import java.util.Random;

public final class Point {

  public final int x;
  public final int y;

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Point point = (Point) o;
    return x == point.x &&
        y == point.y;
  }

  @Override
  public int hashCode() {
    return Objects.hash(x, y);
  }

  /* Generate a random Point using min (inclusive) and max (exclusive). */
  public static Point random(Random rng, int min, int max) {
    if (min > max) {
      return null;
    }
    return new Point(rng.nextInt(max - min) + min, rng.nextInt(max - min) + min);
  }
}
