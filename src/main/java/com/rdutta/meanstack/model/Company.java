package com.rdutta.meanstack.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Company implements Serializable{
	@JsonIgnore
	int Min = 100000;
	@JsonIgnore
	int Max = 999999;
	@Id
	@JsonIgnore
	private long id = (long) Math.floor(Math.random() * (Max - Min) + Min);
	@Column(updatable = false)
	private String company_name;
	private String address;
	private String city;
	private String state;
	private String postal_code;
	private String phone;
	private String email;
	private String description;
	private String tagline;
}
