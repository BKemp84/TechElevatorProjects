package com.techelevator;

public class Television {

	private final static int STARTING_CHANNEL = 3;
	private final static int STARTING_VOLUME = 2;
	private final static int MAX_CHANNEL = 18;
	private final static int MAX_VOLUME = 10;
	private final static int MIN_VOLUME = 0;
	
	private boolean isOn = false;
	private int currentChannel = STARTING_CHANNEL;
	private int currentVolume = STARTING_VOLUME;
	
	
	 public void turnOff() {
		 isOn = false;
	 }
	   
	 public void turnOn() {
		 isOn = true;
		 currentChannel = STARTING_CHANNEL;
		 currentVolume = STARTING_VOLUME;
	 }
	 
	 public void changeChannel(int newChannel) {
		 if (isOn && (newChannel >= STARTING_CHANNEL && newChannel <= MAX_CHANNEL)) {
				 currentChannel = newChannel; 
		 }
	 }
	 
	 public void channelUp() {
		 if (isOn) {
			 currentChannel++;
			 if (currentChannel > MAX_CHANNEL) {
				 currentChannel = STARTING_CHANNEL;
			 }
		 }
	 }
	    
	 public void channelDown() {
		 if (isOn) {
			 currentChannel--;
			 if (currentChannel < STARTING_CHANNEL) {
				 currentChannel = MAX_CHANNEL;
			 }
		 }
	 }
	   
	 public void raiseVolume() {
		 if (isOn) {
			 if (currentVolume + 1 > MAX_VOLUME) {
				 currentVolume = MAX_VOLUME;
			 } else {
				 currentVolume++;
			 }
		 }
	 }
	 
	 public void lowerVolume() {
		 if (isOn) {
			 currentVolume--;
			 if (currentVolume < MIN_VOLUME) {
				 currentVolume = MIN_VOLUME;
			 }
		 }
	 }
	
	
	public boolean isOn() {
		return this.isOn;
	}
	
	public int getCurrentChannel() {
		return this.currentChannel;
	}
	
	public int getCurrentVolume() {
		return this.currentVolume;
	}
	
}
