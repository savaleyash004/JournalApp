package net.engineeringdigest.journalApp.Repository;

import net.engineeringdigest.journalApp.entry.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, ObjectId> {
    User findByUserName(String username);

    void deleteByUserName(String userName);

}

