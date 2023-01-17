package Portfolio.Practical_12;
import java.util.*;

/**
 * Represents a football league, which is a competition between multiple football teams.
 */
public class FootballLeague {
    // The identifier of the league
    private String leagueId;
    // The list of teams participating in the league
    private List<Team> teams;
    // A random number generator for determining the winner in a random match
    private Random random;

    /**
     * Constructs a new football league with the given identifier.
     *
     * @param leagueId the identifier of the league
     */
    public FootballLeague(String leagueId) {
        this.leagueId = leagueId;
        this.teams = new LinkedList<>();
        this.random = new Random();
    }

    /**
     * Returns a string representation of the league, including the identifier of the league
     * and a list of the teams in the league along with their ranking.
     *
     * @return a string representation of the league
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Football League: ").append(leagueId).append("\n");
        int position = 1;
        // Append each team in the league along with their ranking
        for (Team team : teams) {
            sb.append("\nRanking ").append(position).append("\n");
            sb.append(team);
            position++;
        }
        return sb.toString();
    }

    /**
     * Adds a new team to the league. If the team already exists in the league,
     * an error message is printed and the team is not added.
     *
     * @param team the team to add
     */
    public void addTeam(Team team) {
        for (int i = 0; i < teams.size(); i++) {
            if (teams.get(i).getName().equals(team.getName())) {
                System.out.println("\nERROR: Team already exists in league.\n");
                return;
            }
        }
        this.teams.add(team);
    }

    /**
     * Removes the given team from the league.
     *
     * @param team the team to remove
     */
    public void removeTeam(Team team) {
        this.teams.remove(team);
    }

    /**
     * Simulates a random match between the two given teams and updates the win/loss record of each team.
     * The teams are then sorted based on their points and the league ranking is updated.
     *
     * @param team1 the first team in the match
     * @param team2 the second team in the match
     */
    public void randomWin(Team team1, Team team2) {
        if (random.nextInt(2) == 1) {
            team1.increaseWin();
            team2.increaseLoss();
        } else {
            team2.increaseWin();
            team1.increaseLoss();
        }
        Collections.sort(teams);
        System.out.println(this);
    }

    /**
     * Simulates a match between the two given teams and updates the win/loss record of each team based on their names.
     * The team with the lexicographically smaller name is considered the winner.
     * The teams are then sorted based on their points and the league ranking is updated.
     *
     * @param team1 the first team in the match
     * @param team2 the second team in the match
     */
    public void winBasedOnName(Team team1, Team team2) {
        if (team1.getName().compareTo(team2.getName()) < 0) {
            team1.increaseWin();
            team2.increaseLoss();
        } else {
            team2.increaseWin();
            team1.increaseLoss();
        }
        Collections.sort(teams);
        System.out.println(this);
    }

/**
 * Simulates a draw match between the two given teams and updates their draw record.
 * The teams are then sorted based on their points and the league ranking is updated.
 *
 * @param team1 the first team in the match
 * @param team2 the second team in the match
 */
public void drawMatch(Team team1, Team team2) {
    team1.increaseDraw();
    team2.increaseDraw();
    Collections.sort(teams);
    System.out.println(this);
}

    /**
     * Relegates the bottom three teams in this league to the given lower league and promotes the top three
     * teams from the lower league to this league.
     *
     * @param lowerLeague the lower league to which the bottom three teams will be relegated
     */
    public void relegate(FootballLeague upperLeague, FootballLeague lowerLeague) {
        if (teams.size() < 3) {
            System.out.println("ERROR: Not enough teams in league to relegate.");
            return;
        }
        for (int i = 0; i < 3; i++) {
            Team teamToMove = teams.get(3);
            upperLeague.removeTeam(teams.get(3));
            upperLeague.addTeam(lowerLeague.teams.get((0)));
            lowerLeague.removeTeam(lowerLeague.teams.get(0));
            lowerLeague.addTeam(teamToMove);
        }
    }

    /**
     * Returns the identifier of the league.
     *
     * @return the identifier of the league
     */
    public String getLeagueId() {
        return leagueId;
    }

    /**
     * Returns the list of teams in the league.
     *
     * @return the list of teams in the league
     */
    public List<Team> getTeams() {
        return teams;
    }
}
