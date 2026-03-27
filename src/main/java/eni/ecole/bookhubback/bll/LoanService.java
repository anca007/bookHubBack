package eni.ecole.bookhubback.bll;


import eni.ecole.bookhubback.bo.Book;
import eni.ecole.bookhubback.bo.BookStatus;
import eni.ecole.bookhubback.bo.Loan;
import eni.ecole.bookhubback.bo.User;
import eni.ecole.bookhubback.repository.LoanRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@AllArgsConstructor
@Service
public class LoanService {

    LoanRepository loanRepository;

    public void borrowBook(User user, Book book) {

        int activeLoans = loanRepository.countByUserAndReturnedFalse(user);

        if (activeLoans >= 3) {
            throw new RuntimeException("Limite d'emprunts atteinte");
        }

        if (book.getStatus() != BookStatus.AVAILABLE) {
            throw new RuntimeException("Livre non disponible");
        }

        Loan loan = new Loan();
        loan.setUser(user);
        loan.setBook(book);
        loan.setStartDate(LocalDate.now());
        loan.setReturned(false);

        book.setStatus(BookStatus.BORROWED);

        loanRepository.save(loan);
    }



}
