package com.tka.onetoone;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="player")
public class Player {
	
	@Id
	private int playerid;
	private String playername;
	private int playerjersey;
	private int runs;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Address address;
	
	public Player() {
		super();
	}
	
	public Player(int playerid, String playername, int playerjersey, int runs, Address address) {
		super();
		this.playerid = playerid;
		this.playername = playername;
		this.playerjersey = playerjersey;
		this.runs = runs;
		this.address = address;
	}

	public int getPlayerid() {
		return playerid;
	}
	public void setPlayerid(int playerid) {
		this.playerid = playerid;
	}
	public String getPlayername() {
		return playername;
	}
	public void setPlayername(String playername) {
		this.playername = playername;
	}
	public int getPlayerjersey() {
		return playerjersey;
	}
	public void setPlayerjersey(int playerjersey) {
		this.playerjersey = playerjersey;
	}
	public int getRuns() {
		return runs;
	}
	public void setRuns(int runs) {
		this.runs = runs;
	}
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Player [playerid=" + playerid + ", playername=" + playername + ", playerjersey=" + playerjersey
				+ ", runs=" + runs + ", address=" + address + "]";
	}

	
	
	
}
