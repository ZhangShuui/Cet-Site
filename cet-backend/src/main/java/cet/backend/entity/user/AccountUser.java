package cet.backend.entity.user;

import lombok.Data;

@Data
public class AccountUser {
    int id;
    String username;
    String email;
    int isStu;
}