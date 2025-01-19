package com.alura.forohubapi.Dto;

public record LoginDTO(String login, String clave) {
    @Override
    public String login() {
        return login;
    }

    @Override
    public String clave() {
        return clave;
    }


}

