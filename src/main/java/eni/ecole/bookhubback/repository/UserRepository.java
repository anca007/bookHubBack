package eni.ecole.bookhubback.repository;

import eni.ecole.bookhubback.bo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
