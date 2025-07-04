package br.unesp.rc.MSEmployee.dto;

import lombok.Data;

@Data
public class LoginRequest {
    private String user;
    private String password;
}
