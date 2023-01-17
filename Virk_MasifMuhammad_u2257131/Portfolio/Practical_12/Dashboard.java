package Portfolio.Practical_12;
/**
 * A dashboard to manage and display the data of two football leagues, LaLigaSantander and LaLigaSmartBank.
 */
public class Dashboard {
    public static void main(String[] args) {
        // Create a new league called LaLigaSantander
        FootballLeague leagueOne = new FootballLeague("LaLigaSantander");

        // Create some teams for the league
        Team barcelona = new Team("Barcelona");
        Team realMadrid = new Team("Real Madrid");
        Team villarreal = new Team("Villarreal");
        Team athleticoMadrid = new Team("Athletico Madrid");
        Team valencia = new Team("Valencia");
        Team sevilla = new Team("Sevilla");

        // Add the teams to the league
        leagueOne.addTeam(barcelona);
        leagueOne.addTeam(realMadrid);
        leagueOne.addTeam(villarreal);
        leagueOne.addTeam(athleticoMadrid);
        leagueOne.addTeam(valencia);
        leagueOne.addTeam(sevilla);

        // Create a new league called LaLigaSmartBank
        FootballLeague leagueTwo = new FootballLeague("LaLigaSmartBank");

        // Create some teams for the league
        Team lasPalmas = new Team("Las Palmas");
        Team eibar = new Team("Eibar");
        Team levante = new Team("Levante");
        Team granada = new Team("Granada");
        Team malaga = new Team("Malaga");
        Team alaves = new Team("Alaves");

        // Add the teams to the league
        leagueTwo.addTeam(lasPalmas);
        leagueTwo.addTeam(eibar);
        leagueTwo.addTeam(levante);
        leagueTwo.addTeam(granada);
        leagueTwo.addTeam(malaga);
        leagueTwo.addTeam(alaves);

        // Randomly determine a winner between Barcelona and Real Madrid in league one
        leagueOne.randomWin(barcelona, realMadrid);
        // Randomly determine a winner between Las Palmas and Eibar in league two
        leagueTwo.randomWin(lasPalmas, eibar);

        // Relegate the bottom three teams in league one to league two and promote the top three teams from
        // league two to league one
        leagueOne.relegate(leagueOne, leagueTwo);

        // Print the rankings of both leagues after the relegation
        System.out.println("\n\n-AFTER RELEGATION-\n\n");
        System.out.println(leagueOne);
        System.out.println(leagueTwo);
    }
}
