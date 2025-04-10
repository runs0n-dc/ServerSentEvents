package com.example.Assignment.Pothis;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
@Component
public class OutputFunctions {


    public void DomainReportDisplay(List<WikiChangeEvent> combinedList){
        System.out.println("\n====== DOMAINS REPORT [" + LocalDateTime.now() + "] ======");
        Map<String, Set<String>> domainToUniquePages = combinedList.stream()
                .filter(e -> e.meta != null && e.meta.domain != null && e.pageTitle != null)
                .collect(Collectors.groupingBy(
                        e -> e.meta.domain,
                        Collectors.mapping(e -> e.pageTitle, Collectors.toSet())
                ));
        System.out.println("Total number of Wikipedia Domains Updated: " + domainToUniquePages.size() + " //  ");
        System.out.println();
        domainToUniquePages.entrySet().stream()
                .sorted((e1, e2) -> Integer.compare(e2.getValue().size(), e1.getValue().size()))
                .forEach(entry -> {
                    String domain = entry.getKey();
                    int uniquePages = entry.getValue().size();
                    System.out.println(domain + ": " + uniquePages + " page" + (uniquePages > 1 ? "s" : "") + " updated");
                });
        System.out.println("=========================================================\n");
        this.UserReportDisplay(combinedList);
    }

    public void UserReportDisplay(List<WikiChangeEvent> combinedList){
        List<WikiChangeEvent> enWikiEvents = combinedList.stream()
                .filter(e -> e.meta != null && "en.wikipedia.org".equals(e.meta.domain))
                .filter(e -> e.performer != null && !Boolean.TRUE.equals(e.performer.userIsBot))
                .collect(Collectors.toList());

        Map<String, Integer> userToEditCount = new HashMap<>();
        for (WikiChangeEvent event : enWikiEvents) {
            String username = event.performer.userText;
            int currentCount = event.performer.userEditCount;
            userToEditCount.merge(username, currentCount, Math::max);
        }

        List<Map.Entry<String, Integer>> sortedUsers = userToEditCount.entrySet().stream()
                .sorted((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()))
                .collect(Collectors.toList());

        System.out.println("Users who made changes to en.wikipedia.org:");
        for (Map.Entry<String, Integer> entry : sortedUsers) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        System.out.println("=========================================================\n");
    }
}
