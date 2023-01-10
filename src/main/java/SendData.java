import java.io.*;
import java.net.*;

class SendData{
    public static void Send(String data) throws Exception {

        int value = Integer.parseInt(data);

        String json = "{\"device_developer_id\":\""+ "deviceDefault@yumdmb1" +"\",\"data\":{\"Value\":\""+value+"\"}}";
        String api = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VybmFtZSI6Inl1bWRtYjEiLCJyZWFkX3dyaXRlIjp0cnVlLCJpYXQiOjE2NzMzNTA0ODl9.21A22jfyYp5x12K0AyUMrM0QWtCDyTdW_VFiipn9mL4";

        URL url = new URL("https://apiv2.favoriot.com/v2/streams");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("apikey", api);
        con.setRequestProperty("Content-Length", Integer.toString(json.getBytes().length));
        con.setUseCaches(false);
        con.setDoOutput(true);

        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(json);
        wr.close();

        InputStream is = con.getInputStream();
        BufferedReader rd = new BufferedReader(new InputStreamReader(is));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            response.append(line);
            response.append('\r');
        }
        rd.close();
        System.out.println(response.toString());
        if(con != null){
            con.disconnect();
        }
    }
}