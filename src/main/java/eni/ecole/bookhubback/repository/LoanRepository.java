package eni.ecole.bookhubback.repository;

import eni.ecole.bookhubback.bo.Loan;
import eni.ecole.bookhubback.bo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LoanRepository extends JpaRepository<Loan, Long> {
    @Query("SELECT COUNT(l) FROM Loan l WHERE l.user = :user AND l.returned = false")
    int countByUserAndReturnedFalse(@Param("user") User user);
}
