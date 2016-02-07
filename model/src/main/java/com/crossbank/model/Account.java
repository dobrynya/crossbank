package com.crossbank.model;

import java.util.UUID;

/**
 * Represents a bank account.
 * @uathor Dmitry Dobrynin
 * Created at 07.02.16 0:25.
 */
public class Account {
    private String id;
    private String owner;

    public Account() {}

    public Account(String id, String owner) {
        this.id = id;
        this.owner = owner;
    }

    public Account(String owner) {
        this(UUID.randomUUID().toString(), owner);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
