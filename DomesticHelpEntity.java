package com.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="domestic_help")
public class DomesticHelpEntity extends BaseEntity {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private long id;
	private String flatNo;
	private String ownerName;
	private String name;
	private String helpType;
	private String arrivalTime;
	private String departureTime;
	private String date;
	
	public DomesticHelpEntity()
	{}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFlatNo() {
		return flatNo;
	}

	public void setFlatNo(String flatNo) {
		this.flatNo = flatNo;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHelpType() {
		return helpType;
	}

	public void setHelpType(String helpType) {
		this.helpType = helpType;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "DomesticHelpEntity [id=" + id + ", flatNo=" + flatNo + ", ownerName=" + ownerName + ", name=" + name
				+ ", helpType=" + helpType + ", arrivalTime=" + arrivalTime + ", departureTime=" + departureTime
				+ ", date=" + date + "]";
	}

	
	public DomesticHelpEntity(long id, String flatNo, String ownerName, String name, String helpType,
			String arrivalTime, String departureTime, String date) {
		super();
		this.id = id;
		this.flatNo = flatNo;
		this.ownerName = ownerName;
		this.name = name;
		this.helpType = helpType;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
		this.date = date;
	}

	
	public DomesticHelpEntity(String flatNo, String ownerName, String name, String helpType, String arrivalTime,
			String departureTime, String date) {
		super();
		this.flatNo = flatNo;
		this.ownerName = ownerName;
		this.name = name;
		this.helpType = helpType;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
		this.date = date;
	}

	@Override
	public String getKey() {
		
		return null;
	}

	@Override
	public String getValue() {
		
		return null;
	}

	

}
