package eni.ecole.bookhubback.repository;

import eni.ecole.bookhubback.bo.Book;
import eni.ecole.bookhubback.bo.Reservation;
import eni.ecole.bookhubback.bo.ReservationStatus;
import eni.ecole.bookhubback.bo.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    int countByUserAndActiveTrue(User user);

    List<Reservation> findByBookAndStatusOrderByQueuePositionAsc(Book book, ReservationStatus status);

    int countByBookAndStatus(Book book, ReservationStatus status);
}
