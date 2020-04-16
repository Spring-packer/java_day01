package demotest;
//
//import com.google.gson.JsonElement;
//import com.google.gson.JsonObject;
//import com.google.gson.JsonParser;
//
//import java.io.*;
//import java.net.HttpURLConnection;
//import java.net.URL;
//
//
//public class HttpRequestUtil {
//
//    public static String  getXpath(String requestUrl){
//        String res= "";
//        String object = null;
//        StringBuffer buffer = new StringBuffer();
//        try{
//            URL url = new URL(requestUrl);
//            HttpURLConnection urlCon= (HttpURLConnection)url.openConnection();
//            if(200==urlCon.getResponseCode()){
//                InputStream is = urlCon.getInputStream();
//                InputStreamReader isr = new InputStreamReader(is,"utf-8");
//                BufferedReader br = new BufferedReader(isr);
//
//                String str = null;
//                while((str = br.readLine())!=null){
//                    buffer.append(str);
//                }
//                br.close();
//                isr.close();
//                is.close();
//                res = buffer.toString();
//                object = res;
//            }
//        }catch(IOException e){
//            e.printStackTrace();
//        }
//        return object;
//    }
//    public static JsonObject getXpath2(String requestUrl) {
//        String res = "";
//        JsonObject object = null;
//        StringBuffer buffer = new StringBuffer();
//        try {
//            URL url = new URL(requestUrl);
//            HttpURLConnection urlCon = (HttpURLConnection) url.openConnection();
//            if (200 == urlCon.getResponseCode()) {
//                InputStream is = urlCon.getInputStream();
//                InputStreamReader isr = new InputStreamReader(is, "utf-8");
//                BufferedReader br = new BufferedReader(isr);
//
//                String str = null;
//                while ((str = br.readLine()) != null) {
//                    buffer.append(str);
//                }
//                br.close();
//                isr.close();
//                is.close();
//                res = buffer.toString();
//                JsonParser parse = new JsonParser();
//                object = (JsonObject) parse.parse(res);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return object;
//    }
//    public static JsonObject postDownloadJson(String path,String post){
//        URL url = null;
//        try {
//            url = new URL(path);
//            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
//            httpURLConnection.setRequestMethod("POST");// 提交模式
//            // conn.setConnectTimeout(10000);//连接超时 单位毫秒
//            // conn.setReadTimeout(2000);//读取超时 单位毫秒
//            // 发送POST请求必须设置如下两行
//            httpURLConnection.setDoOutput(true);
//            httpURLConnection.setDoInput(true);
//            // 获取URLConnection对象对应的输出流
//            PrintWriter printWriter = new PrintWriter(httpURLConnection.getOutputStream());
//            // 发送请求参数
//            printWriter.write(post);//post的参数 xx=xx&yy=yy
//            // flush输出流的缓冲
//            printWriter.flush();
//            //开始获取数据
//            BufferedInputStream bis = new BufferedInputStream(httpURLConnection.getInputStream());
//            ByteArrayOutputStream bos = new ByteArrayOutputStream();
//            int len;
//            byte[] arr = new byte[1024];
//            while((len=bis.read(arr))!= -1){
//                bos.write(arr,0,len);
//                bos.flush();
//            }
//            bos.close();
//            JsonParser parse = new JsonParser();
//            return (JsonObject)parse.parse(bos.toString("utf-8"));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    //测试
//    public static void main(String args [] ) {
//        String res = null;
////        JsonObject exchange = getXpath2("https://api.binance.com/api/v1/exchangeInfo");
////        JsonElement je = exchange.get("symbols");
////
////        for(JsonElement jo:je.getAsJsonArray()){
////            String i = jo.getAsJsonObject().get("symbol").getAsString();
////            System.out.println(i);
////            String url2 = "https://api.binance.com/api/v1/klines?symbol="+i+"&interval=1m";
////            res = getXpath(url2);
////        }
//
//
//        JsonObject exchange = null;
//        String post = "apiKey=vmPUZE6mv9SD5VNHk4HlWFsOr6aKE2zvsw0MuIgwCIPy6utIco14y7Ju91duEh8A&" +
//                "secretKey=NhqPtmdSJYdKjVHjA7PZj4Mge3R5YNiP1e3UZjInClVN65XAbvqqM6A7H5fATj0j&"+
//                "&symbol=LTCBTC&side=BUY&type=LIMIT&timeInForce=GTCquantity=1&price=0.1&recvWindow=5000&timestamp=1519726440000";
//        exchange = postDownloadJson("https://api.binance.com/api/v1/order",post);
//        System.out.println(exchange);
////        System.out.println(res);
//
//    }
//}