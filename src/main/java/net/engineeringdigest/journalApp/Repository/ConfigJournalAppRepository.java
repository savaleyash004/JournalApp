package net.engineeringdigest.journalApp.Repository;


import net.engineeringdigest.journalApp.entry.ConfigJournalAppEntity;
import net.engineeringdigest.journalApp.entry.JournalEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ConfigJournalAppRepository extends MongoRepository<ConfigJournalAppEntity, ObjectId> {

}
