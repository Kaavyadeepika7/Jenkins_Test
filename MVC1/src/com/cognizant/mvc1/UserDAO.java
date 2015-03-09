package com.cognizant.mvc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDAO {

	public Connection createConnection() throws SQLException,
			ClassNotFoundException {
		String dcn = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String usname = "Kaavyadeepika";
		String pass = "rangaprabha";
		Class.forName(dcn);
		return DriverManager.getConnection(url, usname, pass);

	}

	public boolean insertUser(User user) throws RegistrationException,
			ClassNotFoundException {

		boolean flag = false;

		try {

			Connection con = createConnection();

			String qstr = "insert into User_360640(firstName,lastName,password,age,address,gender,country) values(?,?,?,?,?,?,?)";

			PreparedStatement prepStatement = con.prepareStatement(qstr);

			prepStatement.setString(1, user.getfName());

			prepStatement.setString(2, user.getlName());

			prepStatement.setString(3, user.getPassword());

			prepStatement.setInt(4, user.getAge());

			prepStatement.setString(5, user.getAddress());

			prepStatement.setString(6, user.getGender());

			prepStatement.setString(7, user.getCountry());

			if (prepStatement.executeUpdate() > 0) {

				flag = true;

			}

		}

		catch (SQLException e) {

			throw new RegistrationException(e);

		}

		return flag;

	}
}
