package com.example.wind;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;

import java.io.IOException;
import java.util.Map;

import static org.apache.logging.log4j.message.MapMessage.MapFormat.JSON;

@Slf4j
public class test {

    public static void main(String[] args) throws IOException {

//        相当于浏览器 用来发请求
        CloseableHttpClient client = HttpClientBuilder.create().build();

//        get请求
        HttpGet get1 = new HttpGet("https://devapi.qweather.com/v7/weather/now?location=101010100&key=fc26dd832e824527a270c51470fa3886");

//     发请求 , 用response接收
        CloseableHttpResponse response = null;

        response = client.execute(get1);

         String weatherResult = EntityUtils.toString(response.getEntity());

        JSONObject jSONObject = JSONObject.parseObject(weatherResult);
        JSONObject now1 = jSONObject.getJSONObject("now");

//        String now=jSONObject.getString("now");
//        JSONObject jsnow=JSONObject.parseObject(now);
//        String temp=jsnow.getString("temp");
//        String text=jsnow.getString("text");
//      System.out.println("当前温度="+temp+"\t天气状况="+text+"\t风向="+windDir+"\t风力等级="+windScale+"\t相对湿度="+humidity+"\t大气压强="+pressure);
//        String windDir=jsnow.getString("windDir");
//        String windScale=jsnow.getString("windScale");
//        String humidity=jsnow.getString("humidity");
//        String pressure=jsnow.getString("pressure");
        Weather weather = JSONObject.toJavaObject(now1,Weather.class);

        System.out.println(weather);


    }

}
