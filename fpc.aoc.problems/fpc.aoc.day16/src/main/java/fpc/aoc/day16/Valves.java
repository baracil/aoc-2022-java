package fpc.aoc.day16;

public class Valves {

  private final int[] rates;
  private final int[][] distances;

  public Valves(int[] rates, int[][] distances) {
    this.rates = rates;
    this.distances = distances;
  }

  public int getNbValves() {
    return rates.length;
  }

  public int rate(int valve) {
    return rates[valve];
  }

  public int distances(int valve1, int valve2) {
    return distances[valve1][valve2];
  }

}
