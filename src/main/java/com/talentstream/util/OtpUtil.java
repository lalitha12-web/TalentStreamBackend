package com.talentstream.util;
import org.springframework.stereotype.Component;

import java.util.Random;
public class OtpUtil {
	public String generateOtp() {
        Random random = new Random();
        int randomNumber = random.nextInt(9000) + 1000;
        String output = Integer.toString(randomNumber);

         return output;
    }

}
