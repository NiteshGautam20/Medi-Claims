package com.authorizationservice.authorization.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor      //need default constructor for JSON Parsing
@AllArgsConstructor
@ToString
@Entity
@ApiModel(description = "Creating model class for user logging in")
@Table(name="persons")
public class AuthenticationRequest {

    @Id
    @Column(name="username")
    @ApiModelProperty(value = "Username of the Customer doing login")
    private String username;
    
    @Column(name="password")
    @ApiModelProperty(value = "Password of the Customer doing login")
    private String password;

}
