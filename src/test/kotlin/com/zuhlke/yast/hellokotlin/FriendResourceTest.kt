package com.zuhlke.yast.hellokotlin

import com.zuhlke.yast.hellokotlin.domain.Friend
import com.zuhlke.yast.hellokotlin.persistence.FriendRepository
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.notNullValue
import org.junit.jupiter.api.Test
import org.mockito.ArgumentMatchers.any
import org.mockito.Mockito.`when`
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get


@WebMvcTest(FriendResource::class)
internal class FriendResourceTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @MockBean
    private lateinit var friendGenerator: FriendGenerator

    @MockBean
    private lateinit var friendRepository: FriendRepository

    @Test
    fun generate() {
        val sampleFriend = Friend("Bart Simpson", "Springfield", "+1 999 999 99 99")
        `when`(friendGenerator.generateFriend()).thenReturn(sampleFriend)
        `when`(friendRepository.save(any())).thenReturn(sampleFriend)

        mockMvc
            .get("/api/friends") {
                accept = MediaType.APPLICATION_JSON
            }
            .andExpect {
                status { isOk() }
                content { contentType(MediaType.APPLICATION_JSON) }
                content {
                    jsonPath("$.id", `is`(notNullValue()))
                    jsonPath("$.name", `is`(sampleFriend.name))
                    jsonPath("$.address", `is`(sampleFriend.address))
                    jsonPath("$.phoneNumber", `is`(sampleFriend.phoneNumber))
                }
            }
    }
}