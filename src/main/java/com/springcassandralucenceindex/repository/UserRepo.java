package com.springcassandralucenceindex.repository;

import com.springcassandralucenceindex.model.User;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends CassandraRepository<User,Integer> {

    
    @Query(value = "SELECT * FROM users WHERE expr(users_index, ?0)")
    List<User> findAllUser(String json);
    @Query(value = "SELECT * FROM users WHERE expr(users_index, ?0)")
    List<User> findAllByFilter(String json);
    @Query(value = "SELECT * FROM users WHERE expr(users_index, ?0)")
    List<User> findAllByFilterAndSort(String json);

    @Query(value = "SELECT * FROM users WHERE expr(users_index, ?0)")
    List<User> sortUserByField(String json);

}
