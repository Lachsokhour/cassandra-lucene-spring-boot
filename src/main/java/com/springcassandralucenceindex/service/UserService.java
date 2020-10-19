package com.springcassandralucenceindex.service;

import com.datastax.oss.driver.api.core.CqlSession;
import com.springcassandralucenceindex.model.User;
import com.springcassandralucenceindex.repository.UserRepo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.stratio.cassandra.lucene.builder.Builder.*;

@Service
public class UserService {
    private CqlSession session;
    final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public List<User> findAll() {
        return userRepo.findAll();
    }

    public List<User> findAllByFilter(String fieldName, String search) {
        String fieldValue = "*"+search+"*";
        String json = search().filter(bool().must(wildcard(fieldName, fieldValue))).build();
        return userRepo.findAllByFilter(json);
    }

    public ResponseEntity<List<User>> sortUserByField(String fieldName, String order) {
        try{
            boolean Order;
            if(order.toLowerCase().equals("asc")) Order = false; else {
                Order = true;
            }
            String json = "{sort: {field: \""+fieldName+"\", reverse: "+Order+"}}";
            List<User> users = userRepo.sortUserByField(json);

            if (users.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(users,HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public List<User> test(){
        String json = search().filter(all()).build();
        return userRepo.findAllUser(json);
    }
}
