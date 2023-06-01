package com.lec.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class Member {

	@Id 
	@Column(name = "MEMBER_ID", updatable = false)
	private String member_id;
	private String name;
	private String password;
	private String role;
}
