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
import java.util.ArrayList;
import java.util.List;
import ru.hilariousstartups.javaskills.psplayer.swagger_codegen.model.CheckoutLine;
import ru.hilariousstartups.javaskills.psplayer.swagger_codegen.model.Customer;
import ru.hilariousstartups.javaskills.psplayer.swagger_codegen.model.Employee;
import ru.hilariousstartups.javaskills.psplayer.swagger_codegen.model.EmployeeRecruitmentOffer;
import ru.hilariousstartups.javaskills.psplayer.swagger_codegen.model.Product;
import ru.hilariousstartups.javaskills.psplayer.swagger_codegen.model.RackCell;
/**
 * Объект описывает текущее состояние мира
 */
@Schema(description = "Объект описывает текущее состояние мира")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2021-08-29T20:10:20.018547+03:00[Europe/Moscow]")
public class CurrentWorldResponse {
  @SerializedName("tickCount")
  private Integer tickCount = null;

  @SerializedName("currentTick")
  private Integer currentTick = null;

  @SerializedName("income")
  private Double income = null;

  @SerializedName("salaryCosts")
  private Double salaryCosts = null;

  @SerializedName("stockCosts")
  private Double stockCosts = null;

  @SerializedName("gameOver")
  private Boolean gameOver = null;

  @SerializedName("checkoutLines")
  private List<CheckoutLine> checkoutLines = null;

  @SerializedName("employees")
  private List<Employee> employees = null;

  @SerializedName("recruitmentAgency")
  private List<EmployeeRecruitmentOffer> recruitmentAgency = null;

  @SerializedName("stock")
  private List<Product> stock = null;

  @SerializedName("rackCells")
  private List<RackCell> rackCells = null;

  @SerializedName("customers")
  private List<Customer> customers = null;

  public CurrentWorldResponse tickCount(Integer tickCount) {
    this.tickCount = tickCount;
    return this;
  }

   /**
   * Количество тиков, которое будет длиться игра
   * @return tickCount
  **/
  @Schema(description = "Количество тиков, которое будет длиться игра")
  public Integer getTickCount() {
    return tickCount;
  }

  public void setTickCount(Integer tickCount) {
    this.tickCount = tickCount;
  }

  public CurrentWorldResponse currentTick(Integer currentTick) {
    this.currentTick = currentTick;
    return this;
  }

   /**
   * Текущее время игры (текущий тик или шаг)
   * @return currentTick
  **/
  @Schema(description = "Текущее время игры (текущий тик или шаг)")
  public Integer getCurrentTick() {
    return currentTick;
  }

  public void setCurrentTick(Integer currentTick) {
    this.currentTick = currentTick;
  }

  public CurrentWorldResponse income(Double income) {
    this.income = income;
    return this;
  }

   /**
   * Текущая прибыль магазина
   * @return income
  **/
  @Schema(description = "Текущая прибыль магазина")
  public Double getIncome() {
    return income;
  }

  public void setIncome(Double income) {
    this.income = income;
  }

  public CurrentWorldResponse salaryCosts(Double salaryCosts) {
    this.salaryCosts = salaryCosts;
    return this;
  }

   /**
   * Расходы на зарплату
   * @return salaryCosts
  **/
  @Schema(description = "Расходы на зарплату")
  public Double getSalaryCosts() {
    return salaryCosts;
  }

  public void setSalaryCosts(Double salaryCosts) {
    this.salaryCosts = salaryCosts;
  }

  public CurrentWorldResponse stockCosts(Double stockCosts) {
    this.stockCosts = stockCosts;
    return this;
  }

   /**
   * Расходы на закупку товара
   * @return stockCosts
  **/
  @Schema(description = "Расходы на закупку товара")
  public Double getStockCosts() {
    return stockCosts;
  }

  public void setStockCosts(Double stockCosts) {
    this.stockCosts = stockCosts;
  }

  public CurrentWorldResponse gameOver(Boolean gameOver) {
    this.gameOver = gameOver;
    return this;
  }

   /**
   * Если true значит игра завершена, и дальнейшие вызовы сервера не нужны
   * @return gameOver
  **/
  @Schema(description = "Если true значит игра завершена, и дальнейшие вызовы сервера не нужны")
  public Boolean isGameOver() {
    return gameOver;
  }

  public void setGameOver(Boolean gameOver) {
    this.gameOver = gameOver;
  }

  public CurrentWorldResponse checkoutLines(List<CheckoutLine> checkoutLines) {
    this.checkoutLines = checkoutLines;
    return this;
  }

  public CurrentWorldResponse addCheckoutLinesItem(CheckoutLine checkoutLinesItem) {
    if (this.checkoutLines == null) {
      this.checkoutLines = new ArrayList<CheckoutLine>();
    }
    this.checkoutLines.add(checkoutLinesItem);
    return this;
  }

   /**
   * Кассы
   * @return checkoutLines
  **/
  @Schema(description = "Кассы")
  public List<CheckoutLine> getCheckoutLines() {
    return checkoutLines;
  }

  public void setCheckoutLines(List<CheckoutLine> checkoutLines) {
    this.checkoutLines = checkoutLines;
  }

  public CurrentWorldResponse employees(List<Employee> employees) {
    this.employees = employees;
    return this;
  }

  public CurrentWorldResponse addEmployeesItem(Employee employeesItem) {
    if (this.employees == null) {
      this.employees = new ArrayList<Employee>();
    }
    this.employees.add(employeesItem);
    return this;
  }

   /**
   * Сотрудники
   * @return employees
  **/
  @Schema(description = "Сотрудники")
  public List<Employee> getEmployees() {
    return employees;
  }

  public void setEmployees(List<Employee> employees) {
    this.employees = employees;
  }

  public CurrentWorldResponse recruitmentAgency(List<EmployeeRecruitmentOffer> recruitmentAgency) {
    this.recruitmentAgency = recruitmentAgency;
    return this;
  }

  public CurrentWorldResponse addRecruitmentAgencyItem(EmployeeRecruitmentOffer recruitmentAgencyItem) {
    if (this.recruitmentAgency == null) {
      this.recruitmentAgency = new ArrayList<EmployeeRecruitmentOffer>();
    }
    this.recruitmentAgency.add(recruitmentAgencyItem);
    return this;
  }

   /**
   * Кадровое агенство. Справочная информация о том, каких сотрудников можно нанять и по какой ставке
   * @return recruitmentAgency
  **/
  @Schema(description = "Кадровое агенство. Справочная информация о том, каких сотрудников можно нанять и по какой ставке")
  public List<EmployeeRecruitmentOffer> getRecruitmentAgency() {
    return recruitmentAgency;
  }

  public void setRecruitmentAgency(List<EmployeeRecruitmentOffer> recruitmentAgency) {
    this.recruitmentAgency = recruitmentAgency;
  }

  public CurrentWorldResponse stock(List<Product> stock) {
    this.stock = stock;
    return this;
  }

  public CurrentWorldResponse addStockItem(Product stockItem) {
    if (this.stock == null) {
      this.stock = new ArrayList<Product>();
    }
    this.stock.add(stockItem);
    return this;
  }

   /**
   * Склад с товарами
   * @return stock
  **/
  @Schema(description = "Склад с товарами")
  public List<Product> getStock() {
    return stock;
  }

  public void setStock(List<Product> stock) {
    this.stock = stock;
  }

  public CurrentWorldResponse rackCells(List<RackCell> rackCells) {
    this.rackCells = rackCells;
    return this;
  }

  public CurrentWorldResponse addRackCellsItem(RackCell rackCellsItem) {
    if (this.rackCells == null) {
      this.rackCells = new ArrayList<RackCell>();
    }
    this.rackCells.add(rackCellsItem);
    return this;
  }

   /**
   * Продуктовые полки
   * @return rackCells
  **/
  @Schema(description = "Продуктовые полки")
  public List<RackCell> getRackCells() {
    return rackCells;
  }

  public void setRackCells(List<RackCell> rackCells) {
    this.rackCells = rackCells;
  }

  public CurrentWorldResponse customers(List<Customer> customers) {
    this.customers = customers;
    return this;
  }

  public CurrentWorldResponse addCustomersItem(Customer customersItem) {
    if (this.customers == null) {
      this.customers = new ArrayList<Customer>();
    }
    this.customers.add(customersItem);
    return this;
  }

   /**
   * Покупатели
   * @return customers
  **/
  @Schema(description = "Покупатели")
  public List<Customer> getCustomers() {
    return customers;
  }

  public void setCustomers(List<Customer> customers) {
    this.customers = customers;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CurrentWorldResponse currentWorldResponse = (CurrentWorldResponse) o;
    return Objects.equals(this.tickCount, currentWorldResponse.tickCount) &&
        Objects.equals(this.currentTick, currentWorldResponse.currentTick) &&
        Objects.equals(this.income, currentWorldResponse.income) &&
        Objects.equals(this.salaryCosts, currentWorldResponse.salaryCosts) &&
        Objects.equals(this.stockCosts, currentWorldResponse.stockCosts) &&
        Objects.equals(this.gameOver, currentWorldResponse.gameOver) &&
        Objects.equals(this.checkoutLines, currentWorldResponse.checkoutLines) &&
        Objects.equals(this.employees, currentWorldResponse.employees) &&
        Objects.equals(this.recruitmentAgency, currentWorldResponse.recruitmentAgency) &&
        Objects.equals(this.stock, currentWorldResponse.stock) &&
        Objects.equals(this.rackCells, currentWorldResponse.rackCells) &&
        Objects.equals(this.customers, currentWorldResponse.customers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tickCount, currentTick, income, salaryCosts, stockCosts, gameOver, checkoutLines, employees, recruitmentAgency, stock, rackCells, customers);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CurrentWorldResponse {\n");
    
    sb.append("    tickCount: ").append(toIndentedString(tickCount)).append("\n");
    sb.append("    currentTick: ").append(toIndentedString(currentTick)).append("\n");
    sb.append("    income: ").append(toIndentedString(income)).append("\n");
    sb.append("    salaryCosts: ").append(toIndentedString(salaryCosts)).append("\n");
    sb.append("    stockCosts: ").append(toIndentedString(stockCosts)).append("\n");
    sb.append("    gameOver: ").append(toIndentedString(gameOver)).append("\n");
    sb.append("    checkoutLines: ").append(toIndentedString(checkoutLines)).append("\n");
    sb.append("    employees: ").append(toIndentedString(employees)).append("\n");
    sb.append("    recruitmentAgency: ").append(toIndentedString(recruitmentAgency)).append("\n");
    sb.append("    stock: ").append(toIndentedString(stock)).append("\n");
    sb.append("    rackCells: ").append(toIndentedString(rackCells)).append("\n");
    sb.append("    customers: ").append(toIndentedString(customers)).append("\n");
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
