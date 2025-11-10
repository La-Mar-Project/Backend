package com.lamarfishing.core.user.dummy;

import com.lamarfishing.core.user.domain.User;
import com.lamarfishing.core.user.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserDummy {

    private final UserRepository userRepository;

    public void init(){
        if (userRepository.count() > 0) {
            return;
        }

        userRepository.save(User.create("김승규", "승규천사", User.Grade.BASIC, "01056604120"));
        userRepository.save(User.create("김영희", "영희악마", User.Grade.ADMIN, "01012345679"));
        userRepository.save(User.create("김지오", "지오천사", User.Grade.VIP, "01062647243"));
        userRepository.save(User.create("노수현", "수현악마", User.Grade.GUEST, "01055839181"));
        userRepository.save(User.create("원종윤", "종윤천사", User.Grade.BASIC, "01063461851"));
        userRepository.save(User.create("김철수", "철수악마", User.Grade.ADMIN, "01012345678"));
        userRepository.save(User.create("장창엽", "창엽천사", User.Grade.VIP, "01045105619"));
        userRepository.save(User.create("김준수", "준수악마", User.Grade.GUEST, "01044966580"));
    }

}
