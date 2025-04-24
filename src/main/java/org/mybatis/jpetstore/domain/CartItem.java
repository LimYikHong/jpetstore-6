/*
 *    Copyright 2010-2022 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       https://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.mybatis.jpetstore.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Optional;

// Edited by Yu Tian

/**
 * The Class CartItem.
 *
 * @author Eduardo Macarron
 */
public class CartItem implements Serializable {

  private static final long serialVersionUID = 6620528781626504362L;

  // edited by yutian again
  public Item item;
  public int quantity;
  public boolean inStock;
  public BigDecimal total;

  public boolean isInStock() {
    return inStock;
  }

  public void setInStock(boolean inStock) {
    this.inStock = inStock;
  }

  public BigDecimal getTotal() {
    return total;
  }

  public Item getItem() {
    return item;
  }

  public void setItem(Item item) {
    this.item = item;
    calculateTotal();
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
    calculateTotal();
  }

  public void incrementQuantity() {
    quantity++;
    calculateTotal();
  }

  // edited by yutian again
  public void calculateTotal() {
    total = Optional.ofNullable(item).map(Item::getListPrice).map(v -> v.multiply(new BigDecimal(quantity)))
        .orElse(null);
  }

  // Added by Yu Tian - Non-functional method for demonstration
  public void printDebugInfo() {
    System.out.println(
        "Debug Info - Item: " + item + ", Quantity: " + quantity + ", In Stock: " + inStock + ", Total: " + total);
  }

  // Added by Yu Tian - Placeholder method
  public void placeholderMethod() {
    // This method currently does nothing.
  }

}
