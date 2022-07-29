package jdbcTest;

import java.sql.SQLException;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import com.sjiang2020.jdbc.JdbcCrudCombined;

public class Testjdbc {

	
	@SuppressWarnings("resource")
	@Test
	public void testJdbcUpdateFromKeyboard() {
		
		JdbcCrudCombined jdbcCrudCombined = new JdbcCrudCombined();
		String sql = "insert into customers(firstName, lastName,email) Values(?,?,?)";
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("firsname: ");
		String firstName =scanner.next();
		System.out.println("lastName: ");
		String lastName = scanner.next();
		System.out.println("email: ");
		String email = scanner.next();

		jdbcCrudCombined.jdbcUpdate(sql, firstName, lastName, email);
	}
	
	@Test
	public void testJdbcQuery() throws SQLException {
		
		JdbcCrudCombined jdbcCrudCombined = new JdbcCrudCombined();
		//String sql = "insert into contact(id,firstName, lastName,tel) Values(?,?,?,?)";
		String sql = "select * from contact where id = ?";
		//jdbcCrudCombined.jdbcUpdate(sql, 1,"Song","Jiang","7754098315");
		jdbcCrudCombined.jdbcQuery(sql, 1);
	}

}
