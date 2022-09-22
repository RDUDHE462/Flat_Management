package com.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="flat_entity")
public class FlatEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    private long id;
  private String ownerName;
  private String flatNo;
  private String floorNo;
  private String flatType;
  
  public FlatEntity()
  {}
  
  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getOwnerName() {
    return ownerName;
  }

  public void setOwnerName(String ownerName) {
    this.ownerName = ownerName;
  }

  public String getFlatNo() {
    return flatNo;
  }

  public void setFlatNo(String flatNo) {
    this.flatNo = flatNo;
  }

  public String getFloorNo() {
    return floorNo;
  }

  public void setFloorNo(String floorNo) {
    this.floorNo = floorNo;
  }

  public String getFlatType() {
    return flatType;
  }

  public void setFlatType(String flatType) {
    this.flatType = flatType;
  }
  

  
  @Override
  public String toString() {
    return "FlatEntity [id=" + id + ", ownerName=" + ownerName + ", flatNo=" + flatNo + ", floorNo=" + floorNo
        + ", flatType=" + flatType + "]";
  }

    

  

  public FlatEntity(long id, String ownerName, String flatNo, String floorNo, String flatType) {
    super();
    this.id = id;
    this.ownerName = ownerName;
    this.flatNo = flatNo;
    this.floorNo = floorNo;
    this.flatType = flatType;
  }
  
  

  public FlatEntity(String ownerName, String flatNo, String floorNo, String flatType) {
    super();
    this.ownerName = ownerName;
    this.flatNo = flatNo;
    this.floorNo = floorNo;
    this.flatType = flatType;
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