/*
 * OpenAPI definition
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: v0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package ru.hilariousstartups.javaskills.psplayer.swagger_codegen.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.IOException;
/**
 * Кассовая линия. За ней может работать кассир, либо она может быть закрыта
 */
@Schema(description = "Кассовая линия. За ней может работать кассир, либо она может быть закрыта")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2021-08-22T18:41:52.626859+03:00[Europe/Moscow]")
public class CheckoutLine {
  @SerializedName("lineNumber")
  private Integer lineNumber = null;

  @SerializedName("employeeId")
  private Integer employeeId = null;

  @SerializedName("customerId")
  private Integer customerId = null;

  public CheckoutLine lineNumber(Integer lineNumber) {
    this.lineNumber = lineNumber;
    return this;
  }

   /**
   * Номер кассовой линии
   * @return lineNumber
  **/
  @Schema(description = "Номер кассовой линии")
  public Integer getLineNumber() {
    return lineNumber;
  }

  public void setLineNumber(Integer lineNumber) {
    this.lineNumber = lineNumber;
  }

  public CheckoutLine employeeId(Integer employeeId) {
    this.employeeId = employeeId;
    return this;
  }

   /**
   * Сотрудник, работающий в данный момент за этой кассой. Если касса закрыта, то незаполнено
   * @return employeeId
  **/
  @Schema(description = "Сотрудник, работающий в данный момент за этой кассой. Если касса закрыта, то незаполнено")
  public Integer getEmployeeId() {
    return employeeId;
  }

  public void setEmployeeId(Integer employeeId) {
    this.employeeId = employeeId;
  }

  public CheckoutLine customerId(Integer customerId) {
    this.customerId = customerId;
    return this;
  }

   /**
   * Сотрудник, оплачивающий товар на этой кассе
   * @return customerId
  **/
  @Schema(description = "Сотрудник, оплачивающий товар на этой кассе")
  public Integer getCustomerId() {
    return customerId;
  }

  public void setCustomerId(Integer customerId) {
    this.customerId = customerId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CheckoutLine checkoutLine = (CheckoutLine) o;
    return Objects.equals(this.lineNumber, checkoutLine.lineNumber) &&
        Objects.equals(this.employeeId, checkoutLine.employeeId) &&
        Objects.equals(this.customerId, checkoutLine.customerId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(lineNumber, employeeId, customerId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CheckoutLine {\n");
    
    sb.append("    lineNumber: ").append(toIndentedString(lineNumber)).append("\n");
    sb.append("    employeeId: ").append(toIndentedString(employeeId)).append("\n");
    sb.append("    customerId: ").append(toIndentedString(customerId)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}
