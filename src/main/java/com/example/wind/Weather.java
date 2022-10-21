package com.example.wind;

import lombok.Data;

@Data
public class Weather {


    private Integer temp;

    private String text;

    private String windDir;

    private Integer windScale;

    private Integer humidity;

    private Integer pressure;

    @Override
    public String toString() {
        return "当前温度="+temp+"\t天气状况="+text+"\t风向="+windDir+"\t风力等级="+windScale+"\t相对湿度="+humidity+"\t大气压强="+pressure;
    }
}
