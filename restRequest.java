import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class run1 {

		//URL Encode the data
//		private static String params = "postId=1";
		private static String end_point = "https://jsonplaceholder.typicode.com/todos";
		
		public static void main(String[] args) throws Exception {
			String res = dummyHttpReqRes2(end_point);
			System.out.println(res);
	    } 
		
		public static String dummyHttpReqRes2(String targetURL) throws IOException {
			URL url = new URL(targetURL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        try {
	            //Create connection
	            conn.setRequestMethod("GET");
	            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

	            //set to true to allow setting method parameters
	            conn.setDoOutput(true);

	            //Request
	            DataOutputStream writer = new DataOutputStream (conn.getOutputStream());
//	            writer.writeBytes(params);
	            writer.close();

	            //Response
	            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	            StringBuilder response = new StringBuilder(); 
	            String chunk;
	            while ((chunk = reader.readLine()) != null) {
	                response.append(chunk);
	            }
	            reader.close();
	            return response.toString();
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        } finally {
	            if (conn != null) {
	                conn.disconnect();
	            }
	        }
	    }
	
}
