class FIFAPlayer extends FIFAPlayerKey implements Keyed {
    private String name;
    private double goalsPerGame;

    public FIFAPlayer(int jerseyNumber, String country, String _name,
                      double _goalsPerGame) {
        super(jerseyNumber, country);
        name = _name;
        goalsPerGame = _goalsPerGame;
    }

    public String getName() {
        return name;
    }

    public double getGoalsPerGame() {
        return goalsPerGame;
    }
}
