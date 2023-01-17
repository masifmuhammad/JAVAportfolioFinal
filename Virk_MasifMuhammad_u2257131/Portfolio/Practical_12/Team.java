package Portfolio.Practical_12;

/**
 * Represents a football team, which is a group of players who compete in a football league.
 */
public class Team implements Comparable<Team> {
    // The name of the team
    private String name;
    // The number of matches won by the team
    private int wins;
    // The number of matches drawn by the team
    private int draws;
    // The number of matches lost by the team
    private int losses;
    // The total number of points earned by the team in the league
    private int points;

    /**
     * Constructs a new football team with the given name.
     * The number of wins, draws, losses, and points are initialized to 0.
     *
     * @param name the name of the team
     */
    public Team(String name) {
        this.name = name;
        this.wins = 0;
        this.draws = 0;
        this.losses = 0;
        this.points = 0;
    }

    /**
     * Returns the name of the team.
     *
     * @return the name of the team
     */
    public String getName() {
        return name;
    }

    /**
     * Increases the number of wins and points of the team by 1.
     */
    public void increaseWin() {
        wins++;
        points += 3;
    }

    /**
     * Increases the number of losses of the team by 1.
     */
    public void increaseLoss() {
        losses++;
    }

    /**
     * Increases the number of draws and points of the team by 1.
     */
    public void increaseDraw() {
        draws++;
        points++;
    }

    /**
     * Compares this team to another team based on their points.
     * If the points are equal, the team names are used as a tie breaker.
     *
     * @param other the other team to compare to
     * @return a negative number if this team should be ranked before the other team,
     * a positive number if this team should be ranked after the other team,
     * or 0 if the teams have the same rank
     */
    @Override
    public int compareTo(Team other) {
        if (points != other.points) {
            return other.points - points;
        } else {
            return name.compareTo(other.name);
        }
    }

    /**
     * Returns a string representation of the team, including the name of the team,
     * the number of wins, draws, and losses, and the total number of points.
     *
     * @return a string representation of the team
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Team: ").append(name).append("\n");
        sb.append("Wins: ").append(wins).append("\n");
        sb.append("Draws: ").append(draws).append("\n");
        sb.append("Losses: ").append(losses).append("\n");
        sb.append("Points: ").append(points).append("\n");
        return sb.toString();
    }
}


