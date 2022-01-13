package com.zuhlke.yast.hellokotlin.persistence

import com.zuhlke.yast.hellokotlin.domain.Friend
import org.springframework.data.jpa.repository.JpaRepository

interface FriendRepository : JpaRepository<Friend, String>