package com.app.helper;

import java.util.Random;

import org.springframework.stereotype.Component;
@Component
public class GeneratePwd {

	//1. generate pwd
	private String genPwdRandom;
	
	public String genPwdForUnlocking() {
        int leftLimit = 48; // numeral '0'
   int rightLimit = 122; // letter 'z'
   int targetStringLength = 10;
   Random random = new Random();

   String generatedString = random.ints(leftLimit, rightLimit + 1)
     .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
     .limit(targetStringLength)
     .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
     .toString();

   System.out.println(generatedString);
   
   this.genPwdRandom=generatedString;

   return genPwdRandom;

	}
}
