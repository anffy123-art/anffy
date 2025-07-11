package com.px.partybuild.util;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Component
public class NumberUtils {

    public int convertIntegerIsNullToZero(Integer value) {
        try{
            if(value == null){
                value = 0;
            }

            return value.intValue();
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    public int convertIntegerIsNullToZero(Object value) {
        try{
            if(value == null){
                value = 0;
            }

            return Integer.parseInt(value.toString());
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    public Double convertBigDecimal(BigDecimal value, int num){
        try{
            if(value == null){
                String res = "0.";
                for (int i = 0; i < num; i++){
                    res += "0";
                }
                return Double.parseDouble(res);
            }

            return Double.parseDouble(value.setScale(1, RoundingMode.HALF_UP).toString());
        }catch (Exception e){
            e.printStackTrace();
            return 0.0;
        }
    }

    public Double convertBigDecimal(Object value, int num){
        try{
            if(value == null){
                String res = "0.";
                for (int i = 0; i < num; i++){
                    res += "0";
                }
                return Double.parseDouble(res);
            }

            return Double.parseDouble(new BigDecimal(value.toString()).setScale(1, RoundingMode.HALF_UP).toString());
        }catch (Exception e){
            e.printStackTrace();
            return 0.0;
        }
    }
}
