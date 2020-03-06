package com.alienvault.demo.controller;

import com.alienvault.demo.entity.TokenInfo;
import com.alienvault.demo.service.UserService;
import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

@RestController
//@RequestMapping("/salesforce")
public class UserController {

    @Autowired
   UserService userService;


    @GetMapping("/generatetoken")
    public String getToken() throws IOException {
        System.out.println("api hit");
    TokenInfo result=userService.getToken();


   return result.toString();

}
    @GetMapping("/userinfo")
    public String getUserInfo() throws IOException {

      String result = userService.getQueryResults();

      return result;
    }
}
