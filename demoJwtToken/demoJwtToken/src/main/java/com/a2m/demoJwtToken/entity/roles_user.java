package com.a2m.demoJwtToken.entity;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Data;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class roles_user {

	private int id;
	private int id_user;
	private int id_roles;
}
