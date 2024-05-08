package com.green.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.green.dto.BusInfoDto;

@Controller
@ResponseBody
public class BusanBIMSController  {
	@RequestMapping("/GetBus")
	public String getBus(
			BusInfoDto dto
			/*@RequestParam("numOfRows") String numOfRows, @RequestParam("pageNo")String pageNo,@RequestParam("bstopnm") String bstopnm, @RequestParam("arsno")String arsno*/
			) throws IOException {
		
		
		String serviceKey ="lF9z%2F84nRg1%2FjDz5McsPAVnUnVKBogjud3xT1g2EMjU1IvNBgFuvNw%2BsanlGOujT5P8HxVsULncWUVgkPLvKFg%3D%3D";
		
		StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/6260000/BusanBIMS/busStopList"); /*URL*/   
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") +"="+ serviceKey); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode(dto.getPageNo(), "UTF-8")); /*페이지번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode(dto.getNumOfRows(), "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("bstopnm","UTF-8") + "=" + URLEncoder.encode(dto.getBstopnm(), "UTF-8")); /*정류소 명*/
        urlBuilder.append("&" + URLEncoder.encode("arsno","UTF-8") + "=" + URLEncoder.encode(dto.getArsno(), "UTF-8")); /*정류소 번호*/
        //urlBuilder.append("&" + URLEncoder.encode("type","UTF-8") + "=" + URLEncoder.encode("json", "UTF-8")); /*정류소 번호*/
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        System.out.println(sb.toString());
        
        return sb.toString();
    }
		
	}

