package org.whatsappstatus.user.repository;

public interface AuthRepository {
    boolean login(String username, String password);

    void save(String username, String password);
}
