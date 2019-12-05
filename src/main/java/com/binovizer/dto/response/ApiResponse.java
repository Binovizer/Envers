package com.binovizer.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({"SUCCESS", "data"})
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiResponse<T> {

  @JsonProperty("SUCCESS")
  private Boolean success;

  private T data;

  public static <T> ApiResponse<T> success(T data) {
    return ApiResponse.<T>builder().success(true).data(data).build();
  }

    public static <T> ApiResponse<T> failure(T data) {
        return ApiResponse.<T>builder().success(false).data(data).build();
    }
}
