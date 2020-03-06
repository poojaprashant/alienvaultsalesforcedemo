package com.alienvault.demo.service;

import com.alienvault.demo.entity.TokenInfo;
import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

   public TokenInfo getToken() throws IOException {
      String result="";
       TokenInfo object=null;
       HttpResponse response = null;
      HttpClient client = HttpClientBuilder.create().build();
      HttpPost post = new HttpPost("https://login.salesforce.com/services/oauth2/token");


       List<NameValuePair> arguments = new ArrayList<>(3);
       arguments.add(new BasicNameValuePair("grant_type", "password"));
      arguments.add(new BasicNameValuePair("client_id", "3MVG9n_HvETGhr3Apjr9iXAtnxdtqOI3TDIWiGGflGv17RQctBl77Aa8ZnJQj1ZWAWkZC71surCEICfoLcUOM"));
       arguments.add(new BasicNameValuePair("client_secret", "08E71FEBA4B9ECC40F95F3D356FB9F4418E75CCE2A1ED15EF39FE94317D41CCD"));
       arguments.add(new BasicNameValuePair("username", "pooja@sacumen.com"));
        arguments.add(new BasicNameValuePair("password", "Prashant@1"));

      try {
          post.setEntity(new UrlEncodedFormEntity(arguments));
         response = client.execute(post);
           HttpEntity entity=response.getEntity();
           result=EntityUtils.toString(response.getEntity());


           Gson g = new Gson();
         object = g.fromJson(result, TokenInfo.class);


      } catch (Exception e) {
           e.printStackTrace();
        }
    return object;
   }
   public String getQueryResults() throws IOException {
      System.out.println("inside method");
      HttpResponse response = null;
       TokenInfo info= getToken();
      System.out.println("Token generated");
      String result="";
      String queryUrl=info.getInstance_url()+"/services/data/v47.0/query?q=SELECT+Id+,+EventType+,+LogFile+FROM+EventLogFile";
      HttpClient client = HttpClientBuilder.create().build();
      HttpGet get = new HttpGet(queryUrl);
       get.addHeader("Authorization","Bearer " + info.getAccess_token());

       response=client.execute(get);
       System.out.println("executed Get requests");
       HttpEntity entity=response.getEntity();
       result=EntityUtils.toString(response.getEntity());


       return result;
   }

}
