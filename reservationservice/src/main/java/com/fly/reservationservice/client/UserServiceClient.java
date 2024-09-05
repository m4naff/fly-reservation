package com.fly.reservationservice.client;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * Feign client interface named {@link UserServiceClient} for interacting with the User Service.
 * Provides methods to validate tokens and retrieve authentication information.
 */
@FeignClient(name = "userservice", path = "api/v1/users",configuration = FeignClientConfig.class)
public interface UserServiceClient {


}
