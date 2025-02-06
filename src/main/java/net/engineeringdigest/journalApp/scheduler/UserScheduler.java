package net.engineeringdigest.journalApp.scheduler;

import net.engineeringdigest.journalApp.Repository.UserRepositoryIMpl;
import net.engineeringdigest.journalApp.Service.EmailService;
import net.engineeringdigest.journalApp.cache.AppCache;
import net.engineeringdigest.journalApp.entry.JournalEntry;
import net.engineeringdigest.journalApp.entry.User;
import net.engineeringdigest.journalApp.enums.Sentiment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class UserScheduler {

    @Autowired
    private UserRepositoryIMpl userRepositoryIMpl;

    @Autowired
    private EmailService emailService;


    @Autowired
    private AppCache appCache;

//    @Scheduled(cron = "0 0 9 * * SUN")
    public void fetchUsersForSA() {
        List<User> users = userRepositoryIMpl.getUserForSA();
        for (User user : users) {
            List<JournalEntry> journalEntries = user.getJournalEntries();
            List<Sentiment> sentiments = journalEntries.stream().filter(x -> x.getDate().isAfter(LocalDateTime.now().minus(7, ChronoUnit.DAYS))).map(x -> x.getSentiment()).collect(Collectors.toList());
            Map<Sentiment, Integer> sentimentCounts = new HashMap<>();
            for (Sentiment sentiment : sentiments) {
                if (sentiment != null) {
                    sentimentCounts.put(sentiment, sentimentCounts.getOrDefault(sentiment, 0) + 1);
                }
            }
            Sentiment mostFrequencySentiment = null;
            int maxCount = 0;
            for (Map.Entry<Sentiment, Integer> entry : sentimentCounts.entrySet()) {

                if (entry.getValue() > maxCount) {
                    maxCount = entry.getValue();
                    mostFrequencySentiment = entry.getKey();
                }
            }
            if (mostFrequencySentiment != null) {
                emailService.sendEmail(user.getEmail(), "Sentiment Analysisi For 7 Days", mostFrequencySentiment.toString());
            }
        }
    }
    @Scheduled(cron = "0 0/10 * ? * *")
    public void clearAppCache() {
        appCache.init();
    }
}
