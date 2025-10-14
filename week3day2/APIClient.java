package week3day2;


public class APIClient {
	
	//Method Overloading
	
	public void sendRequest(String endpoint) {
		
		System.out.println("Sending the request:"+endpoint);

	}
	
	public void sendRequest(String endpoint,String requestBody,boolean requestStatus) {
		
		System.out.println("Endpoint :"+endpoint);
		System.out.println("Request Body:"+requestBody);
		System.out.println("Request Status:"+requestStatus);
		
	}
	
	public static void main(String[] args) {
		
		APIClient apiObj = new APIClient(); //Obj Creation
		apiObj.sendRequest("https://example.com/");
		apiObj.sendRequest("https://example.com/", "APIrequestType", true);

	}

}
