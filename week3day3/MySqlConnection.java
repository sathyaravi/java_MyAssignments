package week3day3;

public abstract class MySqlConnection implements DatabaseConnection {

	@Override
	public void connect() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void disconnect() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void executeUpdate() {
		// TODO Auto-generated method stub
		
	}
	
	public void executeQuery() {
		
		System.out.println("Query executed Successfully");

	}

}
