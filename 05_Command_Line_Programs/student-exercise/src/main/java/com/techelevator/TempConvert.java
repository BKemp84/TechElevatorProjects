package com.techelevator;

import java.util.Scanner;

import org.mockito.internal.stubbing.answers.Returns;
import org.omg.IOP.TAG_RMI_CUSTOM_MAX_STREAM_FORMAT;

public class TempConvert {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		System.out.print("Please enter The temperature.");
		String temperature  = in.nextLine();
		int temperatureNum = Integer.parseInt(temperature);
		
		System.out.print("Is it (C)Celsius or (F) Farenheit?");
		String temperatureScale = in.nextLine();
		//String temperatureScaleNum =Integer.parse.Int(temperatureInput);
		//String tempScale = in.nextLine();
		if (temperatureScale.equals("F")) {
			System.out.println( "Temperature " + temperatureNum + "F is new temp " + ((temperatureNum - 32) /1.8) + "C");
			
		} else if (temperatureScale.equals("C")) {
			System.out.println( "Temperature " + temperatureNum + "C is new temp " + ((temperatureNum * 1.8) +32) + "F");
		}
		
		}

}
