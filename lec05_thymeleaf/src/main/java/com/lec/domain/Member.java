package com.lec.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Setter;
import lombok.ToString;
import lombok.Getter;

@Getter
@Setter
@ToString
@Entity
public class Member {

	@Id 
	private String id;
	private String password;
	private String name;
	private String role;
	
}
