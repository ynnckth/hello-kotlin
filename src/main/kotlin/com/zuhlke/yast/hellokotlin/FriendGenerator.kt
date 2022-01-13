package com.zuhlke.yast.hellokotlin

import com.github.javafaker.Faker
import com.zuhlke.yast.hellokotlin.domain.Friend
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class FriendGenerator(private val faker: Faker) {

    private val log = LoggerFactory.getLogger(javaClass)

    fun generateFriend(): Friend {
        val friend = Friend(faker.name().fullName(), faker.address().fullAddress(), faker.phoneNumber().phoneNumber())
        log.info("Generated new friend {}", friend.name)
        return friend
    }

}