package sh.ball.planetwars;

public class Planet {
  private Owner owner;
  private int ships;
  private int growth;

  public Planet(Owner owner, int ships, int growth) {
    this.owner = owner;
    this.ships = ships;
    this.growth = growth;
  }

  public Owner getOwner() {
    return owner;
  }

  public int ships() {
    return ships;
  }

  public int growth() {
    return growth;
  }
}
