package com.jspiders.springmvc.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;


@Data
@Entity
public class AdminPOJO {
@Id
private String username;
private String password;
}
