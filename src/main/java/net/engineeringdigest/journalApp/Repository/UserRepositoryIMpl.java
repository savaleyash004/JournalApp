package net.engineeringdigest.journalApp.Repository;

import net.engineeringdigest.journalApp.entry.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserRepositoryIMpl {


    @Autowired
    private MongoTemplate mongoTemplate;


    public List<User> getUserForSA() {
        Query query = new Query();
//        Criteria criteria =new Criteria();
//        query.addCriteria(criteria.orOperator())
        query.addCriteria(Criteria.where("email").regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$"));
        query.addCriteria(Criteria.where("sentimentAnalysis").exists(true));
        List<User> users = mongoTemplate.find(query, User.class);
        return users;
    }
}
