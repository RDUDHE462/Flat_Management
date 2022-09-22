package com.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="flatrententity")
public class FlatRentEntity extends BaseEntity {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
  private String ownerName;
  private String flatNo;
  private String amount;
  private String type;
  
  public FlatRentEntity()
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

  public String getAmount() {
    return amount;
  }

  public void setAmount(String amount) {
    this.amount = amount;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  @Override
  public String toString() {
    return "FlatRentEntity [id=" + id + ", ownerName=" + ownerName + ", flatNo=" + flatNo + ", amount=" + amount
        + ", type=" + type + "]";
  }

  
  public FlatRentEntity(long id, String ownerName, String flatNo, String amount, String type) {
    super();
    this.id = id;
    this.ownerName = ownerName;
    this.flatNo = flatNo;
    this.amount = amount;
    this.type = type;
  }

  
  public FlatRentEntity(String ownerName, String flatNo, String amount, String type) {
    super();
    this.ownerName = ownerName;
    this.flatNo = flatNo;
    this.amount = amount;
    this.type = type;
  }

  @Override
  public String getKey() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String getValue() {
    // TODO Auto-generated method stub
    return null;
  }

}