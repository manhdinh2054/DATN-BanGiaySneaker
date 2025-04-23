package org.example.baitapbuoi3.bangiaythethaosneaker.Repository;

import org.example.baitapbuoi3.bangiaythethaosneaker.Entity.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account,Integer> {
    Optional<Account> findByUserName(String username);

    @Query(value = "select * from accounts where roles = :roles",nativeQuery = true)
    Page<Account> findAllByRoles(String roles, Pageable pageable);


    Optional<Account> findByEmail(String email);
    Account findByPasswordResetToken(String token);
}
