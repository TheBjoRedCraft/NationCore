package dev.thebjoredcraft.nationcore.nation;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.*;
import java.util.UUID;

public class PlayerNationManager {
    public static JavaPlugin plugin;
    public static Connection connection;

    public static void connectToDatabase() {
        String host = "db.hexle.at";
        String database = "djhase";
        String username = "00028_db_user";
        String password = "HunGOFyRHp8hdm72Tn1BcGyw1e5dm9";
        int port = 3306;

        try {
            Bukkit.getConsoleSender().sendMessage("[NationCore] Connecting to database...");
            connection = DriverManager.getConnection("jdbc:mysql://db.hexle.at:3306/djhase?audwtoReconnect=true&useSSL=false", "00028_db_user", "HunGOFyRHp8hdm72Tn1BcGyw1e5dm9-ugsskYS6U");
            Bukkit.getConsoleSender().sendMessage("[NationCore] Successfully connected to database");
        } catch (SQLException e) {
            plugin.getLogger().severe("Error due connect to database: " + e.getMessage());
        }
    }

    public static void createTables() {
        try {
            PreparedStatement statement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS player_teams (uuid VARCHAR(36), player VARCHAR(100), team VARCHAR(100))");

            statement.execute();
        } catch (SQLException e) {
            plugin.getLogger().severe("Fehler beim Erstellen der Datenbanktabelle: " + e.getMessage());
        }
    }

    public static void joinTeam(Player player, String teamName) {
        UUID uuid = player.getUniqueId();
        leaveTeam(player);
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO player_teams (uuid, player, team) VALUES (?, ?, ?)");

            statement.setString(1, uuid.toString());
            statement.setString(2, player.getName());
            statement.setString(3, teamName);
            statement.execute();
            player.sendMessage("added " + player.getName() + " to " + teamName);
        } catch (SQLException e) {
            plugin.getLogger().severe("Error due join team: " + e.getMessage());
        }
    }

    public static void leaveTeam(Player player) {
        UUID uuid = player.getUniqueId();
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM player_teams WHERE uuid=?");

            statement.setString(1, uuid.toString());
            statement.execute();
            player.sendMessage("removed " + player.getName() + " from every team");
        } catch (SQLException e) {
            plugin.getLogger().severe("Error due remove from team: " + e.getMessage());
        }
    }

    public static String getTeam(Player player) {
        UUID uuid = player.getUniqueId();
        String team = "Kein Team";
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT team FROM player_teams WHERE uuid=?");

            statement.setString(1, uuid.toString());
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                team = result.getString("team");
            }
        } catch (SQLException e) {
            Bukkit.getConsoleSender().sendMessage("[NationCore] Error due getTeam: " + e.getMessage());
        }
        return team;
    }
}
