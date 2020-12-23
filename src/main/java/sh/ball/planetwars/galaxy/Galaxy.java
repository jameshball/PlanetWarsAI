package sh.ball.planetwars.galaxy;

import java.util.Map;
import java.util.Random;
import sh.ball.helper.Pair;
import sh.ball.planetwars.Owner;
import sh.ball.planetwars.Planet;

public class Galaxy {

  private static final int MIN_INITIAL_SHIPS = 50;
  private static final int MAX_INITIAL_SHIPS = 150;
  private static final int MIN_GROWTH = 1;
  private static final int MAX_GROWTH = 5;
  private static final double GROWTH_THRESHOLD_SCALAR = 0.9;
  private static final double DISTANCE_THRESHOLD = 5;

  private final int radius;

  private final Random rng;

  public Galaxy(Random rng, int radius) {
    this.rng = rng;
    this.radius = radius;
  }

  public Galaxy(int radius) {
    this(new Random(), radius);
  }

  private void generateMap() {

  }

  private Map<Point, Planet> generatePlanets() {
    return null;
  }

  private Pair<Point, Planet> generatePlanet(Map<Point, Planet> planets) {
    /* Random point in range ([0,radius],[0,radius]). */
    Point point = Point.random(rng, 0, radius + 1);
    /* Random number of ships in range [MIN_INITIAL_SHIPS,MAX_INITIAL_SHIPS]. */
    int ships = randomIntInRange(MIN_INITIAL_SHIPS, MAX_INITIAL_SHIPS);
    /* Random number of ships in range [MAX_GROWTH,MIN_GROWTH]. */
    int growth = randomIntInRange(MIN_GROWTH, MAX_GROWTH);

    if (!pointTooClose(point, planets, growth)) {
      return new Pair<>(point, new Planet(Owner.NEUTRAL, ships, growth));
    } else {
      return generatePlanet(planets);
    }
  }

  /* Returns a random integer in the range [min,max]. */
  private int randomIntInRange(int min, int max) {
    return rng.nextInt((max + 1) - min) + min;
  }

  private boolean pointTooClose(Point point, Map<Point, Planet> planets, int growth) {
    for (Map.Entry<Point, Planet> planetPair : planets.entrySet()) {
      Point planetPoint = planetPair.getKey();
      Planet planet = planetPair.getValue();

      double distance = Math.sqrt(planetPoint.x * planetPoint.x + planetPoint.y + planetPoint.y);
      /* The larger the growths of the new planet and existing planet, the more concerned we should
       * be about allowing the new planet to be made. The growth threshold will prevent planets with
       * a high growth rate being created near other planets with a high growth rate. */
      double growthThreshold = GROWTH_THRESHOLD_SCALAR *
          (Math.sqrt(growth) + Math.sqrt(planet.growth()));

      if (distance < growthThreshold || distance <= DISTANCE_THRESHOLD) {
        return true;
      }
    }

    return false;
  }
}
