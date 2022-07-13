package com.revature.transactions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.configs.DbConfig;
import com.revature.demoapp.models.Pokemon;

public class updatePokemonTable {

	DbConfig d = new DbConfig();
	private static Connection conn;

	public static void updateObject(Object o) throws SQLException {
		String upName = "UPDATE pokemon SET name = ? WHERE pokemon_id = ?";
		String upPower = "UPDATE pokemon SET power = ? WHERE pokemon_id = ?";
		String upRP = "UPDATE pokemon SET reward_points = ? WHERE pokemon_id = ?";
		String upLC = "UPDATE pokemon SET location_caught = ? WHERE pokemon_id = ?";

		try (PreparedStatement updateName = conn.prepareStatement(upName);
				PreparedStatement updatePower = conn.prepareStatement(upPower);
				PreparedStatement updateRP = conn.prepareStatement(upRP);
				PreparedStatement updateLC = conn.prepareStatement(upLC);)

		{
			conn.setAutoCommit(false);

			updateName.setInt(1, p.getPokemonId());
			updateName.setInt(2, p.getPokemonId());
			updateName.executeUpdate();

			updatePower.setString(1, p.getPower());
			updateName.setInt(2, p.getPokemonId());
			updatePower.executeUpdate();

			updateRP.setInt(1, p.getRewardPoints());
			updateName.setInt(2, p.getPokemonId());
			updateRP.executeUpdate();

			updateLC.setString(1, p.getLocationCaught());
			updateName.setInt(2, p.getPokemonId());
			updateLC.executeUpdate();
			
			conn.commit();

		} catch (SQLException e) {
			e.printStackTrace();
			if (conn != null) {
				try {
					System.err.print("Transaction is being rolled back");
					conn.rollback();
				} catch (SQLException excep) {
					excep.printStackTrace();
				}
			}
		}
	}

}
