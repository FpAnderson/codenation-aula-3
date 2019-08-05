package challenge;

import java.sql.*;

public class QuoteDao {
	private Connection con = null;

	public Quote getQuote() throws SQLException {

		con = new ConnectionFactory().createConnection();
		PreparedStatement stmt = con.prepareStatement("SELECT * FROM scripts ORDER BY RANDOM() LIMIT 1;");
		ResultSet rs = stmt.executeQuery();

		Quote quote = null;

		while(rs.next())
		{
			quote = Quote.builder()
					.withquote(rs.getString("detail"))
					.withactor(rs.getString("actor")).build();
		}
		con.close();

		return quote;
	}

	public Quote getQuoteByActor(String actor) throws SQLException {

		con = new ConnectionFactory().createConnection();
		PreparedStatement stmt = con.prepareStatement("SELECT * FROM scripts S WHERE S.actor = ?");
		stmt.setString(1, actor);
		ResultSet rs = stmt.executeQuery();

		Quote quote = null;

		while(rs.next())
		{
			quote = Quote.builder()
					.withquote(rs.getString("detail"))
					.withactor(rs.getString("actor")).build();
		}
		con.close();

		return quote;
	}

}
