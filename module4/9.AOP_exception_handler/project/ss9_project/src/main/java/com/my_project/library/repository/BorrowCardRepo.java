package com.my_project.library.repository;

import com.my_project.library.entity.BorrowCard;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface BorrowCardRepo extends PagingAndSortingRepository<BorrowCard,Integer> {
    Iterable<BorrowCard> findByBorrowedIsTrue();
}
