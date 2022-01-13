package com.zuhlke.yast.hellokotlin

import com.zuhlke.yast.hellokotlin.domain.Friend
import com.zuhlke.yast.hellokotlin.persistence.FriendRepository
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/friends")
class FriendResource(private val friendGenerator: FriendGenerator, private val friendRepository: FriendRepository) {

    private val log = LoggerFactory.getLogger(javaClass)

    @GetMapping
    fun generate(): Friend {
        log.info("Requested to generate a new friend")
        val savedFriend = friendRepository.save(friendGenerator.generateFriend())
        log.info("Saved new friend")
        log.info("The answer to everything is {}", MyJavaClass().doSomething())
        return savedFriend
    }
}

