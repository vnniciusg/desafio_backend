package com.desafiobackend.domain.entities.user;

import com.desafiobackend.dto.request.user.CreateUserRequestDTO;

import java.math.BigDecimal;

public class User {
    private Long id;
    private String firstName;
    private String lastName;
    private String document;
    private String email;
    private String password;
    private BigDecimal balance;

    private UserType userType;

    public User() {
    }

    public User(Long id, String firstName, String lastName, String document, String email, String password, BigDecimal balance, UserType userType) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.document = document;
        this.email = email;
        this.password = password;
        this.balance = balance;
        this.userType = userType;
    }

    public static User mapToUser(CreateUserRequestDTO data) {
        User user = new User();
        user.setFirstName(data.firstName());
        user.setLastName(data.lastName());
        user.setDocument(data.document());
        user.setEmail(data.email());
        user.setPassword(data.password());
        user.setUserType(data.userType());

        return user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }


    public void validateTransaction(User userSender , BigDecimal amount) throws Exception{
        if(userSender.getUserType()  == UserType.MERCHANT){
            throw new Exception("Usuário do tipo lojista não está aurtorizado a realizar transferencias");
        }
        if(userSender.getBalance().compareTo(amount) < 0){
            throw new RuntimeException("Saldo insuficiente");
        }
    }
}
