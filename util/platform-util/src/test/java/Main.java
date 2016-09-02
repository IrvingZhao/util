import com.lasun.association.platform.util.property.Property;
import com.lasun.association.platform.util.remote.http.ClientConfig;
import com.lasun.association.platform.util.remote.http.HttpMessage;
import com.lasun.association.platform.util.remote.http.HttpUtil;
import com.lasun.association.platform.util.remote.http.enums.HttpMethod;
import com.lasun.association.platform.util.remote.http.enums.RequestType;
import com.lasun.association.platform.util.serial.SerialUtil;
import com.lasun.association.platform.util.weixin.message.send.accessToken.AccessTokenInputMessage;
import com.lasun.association.platform.util.weixin.message.send.accessToken.AccessTokenOutputMessage;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by irving on 2016/8/10.
 */
public class Main {
    public static void main(String[] args) throws Exception {
//        BasicCredentialsProvider credsProvider = new BasicCredentialsProvider();
//        credsProvider.setCredentials(
//                new AuthScope("httpbin.org", 80),
//                new UsernamePasswordCredentials("user", "passwd".toCharArray()));
//        try (CloseableHttpClient httpclient = HttpClients.custom()
////                .setDefaultCredentialsProvider(credsProvider)
//                .build()) {
//            HttpGet httpget = new HttpGet("http://httpbin.org/basic-auth/user/passwd");
//
//            System.out.println("Executing request " + httpget.getRequestLine());
//            try (CloseableHttpResponse response = httpclient.execute(httpget)) {
//                System.out.println("----------------------------------------");
//                System.out.println(response.getStatusLine());
//                System.out.println(EntityUtils.toString(response.getEntity()));
//            }
//        }
//        CloseableHttpClient client = HttpClients.createDefault();
////        HttpPost post = new HttpPost();
////        MultipartEntityBuilder
//
//        List<NameValuePair> params = new ArrayList<>();
//        params.add(new BasicNameValuePair("a", "123"));
//        params.add(new BasicNameValuePair("b", "456"));
//        params.add(new BasicNameValuePair("c", "789"));
//        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(params);
//        HttpGet get = new HttpGet("http://localhost:8080/demo?" + EntityUtils.toString(entity));
//        InputStreamEntity streamEntity=new InputStreamEntity(entity.getContent());
//        get.setEntity(streamEntity);
//        CloseableHttpResponse response = client.execute(get);
//        HttpEntity resEntity = response.getEntity();
//        if (resEntity != null) {
//            System.out.println("Response content length: " + resEntity.getContentLength());
//        }
////        EntityUtils.consume(resEntity);
//        System.out.println(EntityUtils.toString(resEntity));
////        BufferedReader reader=new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
////        String temp;
//        while((temp=reader.readLine())!=null){
//            System.out.println(reader.readLine());
//        }
//        post.setConfig();
//        System.out.println(Byte.class.isAssignableFrom(String.class));
//        HttpPost post1=new HttpPost("http://www.baidu.com");
//        HttpPost post2=new HttpPost("https://www.baidu.com");
//        HttpPost post3=new HttpPost("HTTP://www.baidu.com");
//        HttpPost post4=new HttpPost("HTTPS://www.baidu.com");
//        System.out.println(post1.getURI().getScheme());
//        System.out.println(post2.getURI().getScheme());
//        System.out.println(post3.getURI().getScheme());
//        System.out.println(post4.getURI().getScheme());
//        System.out.println(post1.getConfig().getProxy().getSchemeName());
//        System.out.println(post2.getConfig().getProxy().getSchemeName());
//        System.out.println(post3.getConfig().getProxy().getSchemeName());
//        System.out.println(post4.getConfig().getProxy().getSchemeName());

//        KeyStore.getInstance(KeyStoreType.UBER.name());

//        HttpMessage message = new HttpMessage("http://localhost:8080/demo", HttpMethod.POST, RequestType.MULTIPART);
//        message.addRequestParam("key1", "value1");
//        message.addRequestParam("key2", new Date());
//        message.addRequestParam("key3", "中文");
//        message.addRequestParam("key4", new File("d:/settings.jar"));
//        message.setRequestStream(new ByteArrayInputStream("中文".getBytes("UTF-8")));
//        HttpUtil util = new HttpUtil(new ClientConfig().setSSLConfig("classpath:/apiclient_cert.p12", "1324630001", KeyStoreType.PKCS12));
//        SSLConfig config = new ClientConfig().getSSlConfig();
////        BufferedReader reader = new BufferedReader(new InputStreamReader(util.sendMessage(message)));
//        System.out.println("--------------response--------------------");
//        String temp;
//        while ((temp = reader.readLine()) != null) {
//            System.out.println(temp);
//        }
//        util.sendMessage(message);

//        AccessTokenOutputMessage accessTokenOutputMessage = new AccessTokenOutputMessage();
////        System.out.println(accessTokenOutputMessage.getParamMap());
////        System.out.println(accessTokenOutputMessage.getSerialContent());
//        System.out.println(accessTokenOutputMessage.getAppid());
//        HttpMessage message = new HttpMessage(accessTokenOutputMessage.getUrl(), HttpMethod.GET, RequestType.NORMAL, accessTokenOutputMessage.getParamMap());
//        new HttpUtil(new ClientConfig().setCharset(Charset.forName("ISO-8859-1"))).sendMessage(message);
//        InputStream stream = message.getResponseStream();
////        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
////        String temp;
////        while ((temp = reader.readLine()) != null) {
////            System.out.println(temp);
////        }
//
//        AccessTokenInputMessage inputMessge = SerialUtil.getSerialUtil().parse(stream, AccessTokenInputMessage.class, SerialUtil.SerialType.JSON);
//        System.out.println(inputMessge.getAccess_token());
//        Map<String,String> properties= Property.getKeyValues("wx\\.(\\w)*\\.(appId|appsecurity){1,1}");
//        properties.entrySet().forEach((entity)->{
//            System.out.println(entity.getKey());
//            System.out.println(entity.getValue());
//        });

        String s="wx.test.se";
        Pattern appId=Pattern.compile("wx\\.(\\w*)\\.appId");
        Matcher matcher=appId.matcher(s);
        if(matcher.matches()){
            System.out.println(matcher.group(1));
        }
    }
}
