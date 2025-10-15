package week3day3;

public class JavaConnection extends MySqlConnection {

	public static void main(String[] args) {
		
		JavaConnection jObj = new JavaConnection();
		jObj.connect();
		jObj.disconnect();
		jObj.executeUpdate();
		jObj.executeQuery();

	}

	@Override
	public void connect() {
		
		System.out.println("Database Connected Successfully");
	}

	@Override
	public void disconnect() {
		
		System.out.println("Database disconnected successfully");
	}

	@Override
	public void executeUpdate() {
		
		System.out.println("Execute the new update");
		
	}

}
