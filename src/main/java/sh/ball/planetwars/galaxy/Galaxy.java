package sh.ball.planetwars.galaxy;

import java.util.Map;
import java.util.Random;
import sh.ball.planetwars.Planet;

public class Galaxy {
  private final Random rng;

  public Galaxy(long seed) {
    this.rng = new Random(seed);
  }

  private void generateMap() {

  }

  private Map<Point, Planet> generatePlanets() {
    return null;
  }
}
