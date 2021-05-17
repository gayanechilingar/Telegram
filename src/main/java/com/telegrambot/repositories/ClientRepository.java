package com.telegrambot.repositories;

import com.telegrambot.domain.Client;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface ClientRepository extends MongoRepository<Client, String> {

    Optional<Client> findByUserId(Integer userId);

//    List<Client> findByPriceLessThan(int price);
//    
//    List<Client> findByPriceBetween(int price1, int price2);

}
