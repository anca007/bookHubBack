package eni.ecole.bookhubback.bll;


import eni.ecole.bookhubback.bo.*;
import eni.ecole.bookhubback.repository.LoanRepository;
import eni.ecole.bookhubback.repository.ReservationRepository;
import eni.ecole.bookhubback.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@AllArgsConstructor
@Service
public class ReservationService {

    ReservationRepository reservationRepository;

    public void reserveBook(User user, Book book) {

        int count = reservationRepository.countByUserAndActiveTrue(user);

        if (count >= 5) {
            throw new RuntimeException("Limite atteinte");
        }

        int position = reservationRepository.countByBookAndStatus(book, ReservationStatus.ACTIVE);


        Reservation r = new Reservation();
        r.setUser(user);
        r.setBook(book);
        r.setReservationDate(LocalDate.now());
        r.setActive(true);
        r.setQueuePosition(position + 1);

        book.setStatus(BookStatus.RESERVED);

        reservationRepository.save(r);
    }

//    public void handleBookAvailable(Book book) {
//
//        List<Reservation> queue =
//                reservationRepository.findByBookAndStatusOrderByQueuePositionAsc(
//                        book,
//                        ReservationStatus.ACTIVE
//                );
//
//        if (!queue.isEmpty()) {
//            Reservation first = queue.get(0);
//
//            // notifier utilisateur
//            // ou auto-créer un loan
//
//            first.setStatus(ReservationStatus.FULFILLED);
//            reservationRepository.save(first);
//        } else {
//            book.setStatus(BookStatus.AVAILABLE);
//        }
//    }


}
