package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


public interface UserRepository extends JpaRepository<User,Integer>, PagingAndSortingRepository<User, Integer> {

    Optional<UserAbstraction> findByName(String name);

    User findByNameAndId(String name,int id);
    Page<User> findById(int id , Pageable pageable);
    List<User> findBySalaryGreaterThan(String salaray);

    List<User> findByIdBefore(int id);


    @Transactional
    @Modifying
    @Query(value = "update User u set u.salary = :name where u.id = :id " , nativeQuery = true)
    void setUser(
            @Param("name") String name ,
            @Param("id") int id);

    List<User> getAllUsers();
    interface UserAbstraction{
        String getName();
    }
}
